import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int orderIdCounter = 10000;
    private int orderNumber;
    private Customer customer;
    private List<Pizza> pizzas;

    public Order(Customer customer) {
        this.customer = customer;
        this.orderNumber = orderIdCounter++;
        this.pizzas = new ArrayList<>();
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Pizza pizza : pizzas) {
            total += pizza.calculatePrice();
        }
        return total;
    }
}