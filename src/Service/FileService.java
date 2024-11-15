package Service;

import Entity.CRIndex;
import Entity.StatisticsView;
import General.IFileService;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileService implements IFileService<StatisticsView> {
private String fileName;

    public FileService(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public  List<StatisticsView> readFileStatistics(String fileName) {
        List<StatisticsView> statisticsViews = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

            String lineData;
            while ((lineData = bufferedReader.readLine()) != null) {
                StatisticsView statisticsView = new StatisticsView();
                if(!lineData.isEmpty()){
                    String[] arrdata = lineData.split(";");
                    statisticsView.setId(Integer.parseInt(String.valueOf(arrdata[0])));
                    statisticsView.setView(Integer.parseInt(String.valueOf(arrdata[1])));
                    statisticsView.setAddToCart(Integer.parseInt(String.valueOf(arrdata[2])));
                    statisticsView.setCheckOut(Integer.parseInt(String.valueOf(arrdata[3])));
                    statisticsView.setCreatedAtDate(LocalDate.parse(String.valueOf(arrdata[4])));

                }
                statisticsViews.add(statisticsView);

        }
        }catch (IOException e){
            e.getCause();
        }
        return statisticsViews;
    }
    public <T> void writeToFile(String fileOutPath, List<T> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutPath))) {
            for (T item : data) {
                writer.write(item.toString());
                writer.newLine();
            }
            System.out.println("Dữ liệu đã được ghi vào file: " + fileOutPath);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    @Override
    public List<StatisticsView> writeFileStatistics(String fileOutPath) {
        return List.of();
    }
}
