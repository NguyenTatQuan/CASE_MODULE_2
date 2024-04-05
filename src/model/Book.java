package model;

import java.io.Serializable;

public class Book implements DiscountBook,Serializable {
    private String bookId;
    private String name;
    private double price;
    private String manufacturer;
    private String description;
    private final double SALE = 0.8;



    public Book() {
    }

    public Book(String bookId, String name, double price, String manufacturer, String description) {
        this.bookId = bookId;
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.description = description;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSALE() {
        return SALE;
    }

    @Override
    public double getMoney() {
        return getPrice()*getSALE();
    }
    @Override
    public String toString() {
        return "Book{" +
                "Id='" + bookId + '\'' +
                ", Tên sách='" + name + '\'' +
                ", Giá=" + price +
                ", Nhà sáng tác='" + manufacturer + '\'' +
                ", Mô tả='" + description + '\'' +
                ", Giảm giá 20% còn ='" + getMoney() + '\'' +
                '}';
    }
}