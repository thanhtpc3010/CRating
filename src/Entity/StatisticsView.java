package Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class StatisticsView {
    private int id;
    private int view;
    private int addToCart;
    private int checkOut;
    private LocalDate createdAtDate;

    public StatisticsView() {}

    public StatisticsView(int id, int view, int addToCart, int checkOut, LocalDate createdAtDate) {
        this.id = id;
        this.view = view;
        this.addToCart = addToCart;
        this.checkOut = checkOut;
        this.createdAtDate = createdAtDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getAddToCart() {
        return addToCart;
    }

    public void setAddToCart(int addToCart) {
        this.addToCart = addToCart;
    }

    public int getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(int checkOut) {
        this.checkOut = checkOut;
    }

    public LocalDate getCreatedAtDate() {
        return createdAtDate;
    }

    public void setCreatedAtDate(LocalDate createdAtDate) {
        this.createdAtDate = createdAtDate;
    }
    public int getMonthOfDate(){
        return this.createdAtDate.getMonthValue();
    }
    public int getYearOfDate(){
        return this.createdAtDate.getYear();
    }

    @Override
    public String toString() {
        return "StatisticsView{" +
                "id=" + id +
                ", view=" + view +
                ", addToCart=" + addToCart +
                ", checkOut=" + checkOut +
                ", createdAtDate=" + createdAtDate +
                '}';
    }
}
