public enum ProductType {
    APPETIZER("Appetizer"),  // Закуски
    DESSERT("Dessert");      // Десерты

    private String name;

    // Конструктор для перечисления
    ProductType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}