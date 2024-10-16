class Product {
    private String name;
    private int quantity;
    private double price;

    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public void increaseQuantity(int amount) {
        if (amount > 0) {
            quantity += amount;
        } else {
            System.out.println("Количество для увеличения должно быть положительным.");
        }
    }

    public void decreaseQuantity(int amount) {
        if (amount > 0 && amount <= quantity) {
            quantity -= amount;
        } else {
            System.out.println("Некорректное количество для уменьшения.");
        }
    }

    public void changePrice(double newPrice) {
        if (newPrice >= 0) {
            price = newPrice;
        } else {
            System.out.println("Цена не может быть отрицательной.");
        }
    }

    public void displayInfo() {
        System.out.printf("Продукт: %s, Количество: %d, Цена: %.2f%n", name, quantity, price);
    }
}

class StoreInventory {
    public static void main(String[] args) {

        Product product = new Product("Яблоки", 100, 1.5);

        product.displayInfo();

        product.increaseQuantity(20);
        product.displayInfo();

        product.decreaseQuantity(30);
        product.displayInfo();

        product.changePrice(1.8);
        product.displayInfo();
    }
}