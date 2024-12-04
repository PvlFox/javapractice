import java.util.HashSet;
import java.util.Set;

public class Pizza {
    private static final int MAX_ALLOWED_INGREDIENTS = 7;

    private String name;
    private PizzaType pizzaType;
    private Set<Ingredient> ingredients;
    private int quantity;

    public Pizza(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
        this.ingredients = new HashSet<>();
        this.quantity = 1;
    }

    public Pizza(String name, PizzaType pizzaType, Set<Ingredient> ingredients, int quantity) {
        this.name = name;
        this.pizzaType = pizzaType;
        this.ingredients = ingredients;
        this.quantity = quantity;
    }

    public void addIngredient(Ingredient ingredient) {
        if (ingredients.size() < MAX_ALLOWED_INGREDIENTS) {
            if (ingredients.contains(ingredient)) {
                System.out.println("The pizza already contains this ingredient");
            } else {
                ingredients.add(ingredient);
            }
        } else {
            System.out.println("Cannot add more ingredients to the pizza.");
        }
    }

    public double calculatePrice() {
        double totalPrice = pizzaType.getPrice();
        for (Ingredient ingredient : ingredients) {
            totalPrice += ingredient.getPrice();
        }
        return totalPrice * quantity;
    }

    public String getName() {
        return name == null ? pizzaType.getName() : name;
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}