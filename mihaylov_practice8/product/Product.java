public class Product {
    private String name;
    private double price;
    private ProductType productType;  // Тип закуски (закуска или десерт)

    public Product(String name, double price, ProductType productType) {
        this.name = name;
        this.price = price;
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ProductType getProductType() {
        return productType;
    }

    @Override
    public String toString() {
        return name + " (" + productType.getName() + ") - " + price + " $";
    }
}