package model;

public class Ticket {
    private double price;
    private double quantity;

    public Ticket() {
    }

    public Ticket(double price, double quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
