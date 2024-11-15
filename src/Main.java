import Entity.CRIndex;
import Entity.CRStatistics;
import Entity.StatisticsView;
import Service.FileService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public static void main() {
    String fileInPathStatistics = System.getProperty("user.dir").replace("/", "\\") + "/data/statistics.view.txt";
    FileService fileService = new FileService(fileInPathStatistics);
    System.out.println(fileInPathStatistics);
    List<StatisticsView> statisticsViews = fileService.readFileStatistics(fileInPathStatistics);
    statisticsViews.forEach(statisticsView -> {
        System.out.println(statisticsView.toString());
    });
    Map<CRStatistics, CRStatistics> dataCRS = statisticsViews.stream()
            .collect(Collectors.groupingBy(
                    cr -> new CRStatistics(cr.getId(), cr.getMonthOfDate(), cr.getYearOfDate()),
                    Collectors.collectingAndThen(
                            Collectors.toList(),
                            listCR -> {
                                CRStatistics crStatistics = new CRStatistics();
                                StatisticsView firstStatistics = listCR.getFirst();
                                int totalView = listCR.stream().mapToInt(StatisticsView::getView).sum();

                                crStatistics.setId(firstStatistics.getId());
                                crStatistics.setMonth(firstStatistics.getMonthOfDate());
                                crStatistics.setYear(firstStatistics.getYearOfDate());
                                crStatistics.setTotalView(totalView);
                                crStatistics.setTotalAddToCart(listCR.stream().mapToInt(StatisticsView::getAddToCart).sum());
                                crStatistics.setTotalCheckOut(listCR.stream().mapToInt(StatisticsView::getCheckOut).sum());

                                return crStatistics;
                            }
                    )
            ));
    dataCRS.forEach((k, v) -> System.out.println(v));

    //Write to File CRIndex

    String fileInPathIndex = System.getProperty("user.dir").replace("/", "\\") + "/data/CRIndex.view.txt";

    List<CRIndex> crIndexList = dataCRS.values().stream()
            .map(crStatistics -> {
                CRIndex crIndex = new CRIndex();
                crIndex.setId(crStatistics.getId());
                crIndex.setMonth(crStatistics.getMonth());
                crIndex.setYear(crStatistics.getYear());

                double totalView = crStatistics.getTotalView();
                crIndex.setAddToCartRatio(totalView > 0 ? (double) crStatistics.getTotalAddToCart() / totalView : 0);
                crIndex.setCheckOutRatio(totalView > 0 ? (double) crStatistics.getTotalCheckOut() / totalView : 0);

                return crIndex;
            })
            .collect(Collectors.toList());
    String fileOutPath = System.getProperty("user.dir") + "/data/CRIndex.view.txt";
    fileService.writeToFile(fileOutPath, crIndexList);
    crIndexList.forEach(System.out::println);
}