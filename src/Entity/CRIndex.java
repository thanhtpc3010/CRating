package Entity;

import java.util.Objects;

public class CRIndex {
    private int id;
    private int month;
    private int year;
    private double addToCartRatio;
    private double checkOutRatio;

    public CRIndex(){}

    public CRIndex(int id, int month, int year, double addToCartRatio, double checkOutRatio) {
        this.id = id;
        this.month = month;
        this.year = year;
        this.addToCartRatio = addToCartRatio;
        this.checkOutRatio = checkOutRatio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getAddToCartRatio() {
        return addToCartRatio;
    }

    public void setAddToCartRatio(double addToCartRatio) {
        this.addToCartRatio = addToCartRatio;
    }

    public double getCheckOutRatio() {
        return checkOutRatio;
    }

    public void setCheckOutRatio(double checkOutRatio) {
        this.checkOutRatio = checkOutRatio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CRIndex crIndex = (CRIndex) o;
        return id == crIndex.id && month == crIndex.month && year == crIndex.year && Double.compare(addToCartRatio, crIndex.addToCartRatio) == 0 && Double.compare(checkOutRatio, crIndex.checkOutRatio) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, month, year, addToCartRatio, checkOutRatio);
    }

    @Override
    public String toString() {
        return "CRIndex{" +
                "id=" + id +
                ", month=" + month +
                ", year=" + year +
                ", addToCartRatio=" + addToCartRatio +
                ", checkOutRatio=" + checkOutRatio +
                '}';
    }
}
