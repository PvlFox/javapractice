public class Juice {
    private String name;
    private double price;
    private int quantity;

    public Juice(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 1; // По умолчанию, количество сока — 1
    }

    public Juice(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double calculateTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return name + " - " + price + " $";
    }
}