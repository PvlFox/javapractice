class ElectronicDevice {
    private String brand;
    private String model;
    private double price;

    public ElectronicDevice(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public void displayInfo() {
        System.out.printf("Бренд: %s, Модель: %s, Цена: %.2f%n", brand, model, price);
    }
}

class Smartphone extends ElectronicDevice {
    private String operatingSystem;

    public Smartphone(String brand, String model, double price, String operatingSystem) {
        super(brand, model, price);
        this.operatingSystem = operatingSystem;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("Операционная система: %s%n", operatingSystem);
    }
}

class DeviceInventory {
    public static void main(String[] args) {
        Smartphone smartphone = new Smartphone("Apple", "iPhone 14", 999.99, "iOS");

        smartphone.displayInfo();
    }
}