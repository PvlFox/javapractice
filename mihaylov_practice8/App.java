import java.util.HashSet;
import java.util.Set;

public class PizzaOrderSystem {

    public static void main(String[] args) {
        // Создаем клиента
        Customer customer = new Customer("John Doe", "123456789");

        // Создаем пиццу с ингредиентами
        Pizza pizza1 = new Pizza("NewPizza", PizzaType.REGULAR);
        pizza1.addIngredient(Ingredient.BACON);
        pizza1.addIngredient(Ingredient.SALAMI);
        pizza1.addIngredient(Ingredient.CORN);
        pizza1.setQuantity(3);

        // Создаем пиццу Margarita
        Pizza pizza2 = new Pizza("Margarita", PizzaType.CALZONE);
        pizza2.addIngredient(Ingredient.CHEESE);
        pizza2.addIngredient(Ingredient.BACON);

        // Создаем заказ
        Order order = new Order(customer);
        order.addPizza(pizza1);
        order.addPizza(pizza2);

        // Печать чека
        Printer.printCheck(order);
    }
}