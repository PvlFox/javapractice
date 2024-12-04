public class Printer {
    public static void printCheck(Order order) {
        System.out.println("*****************************");
        System.out.println("Order: " + order.getOrderNumber());
        System.out.println("Customer: " + order.getCustomer().getNumber());
        System.out.println("*****************************");

        for (Pizza pizza : order.getPizzas()) {
            System.out.println("Name: " + pizza.getName());
            System.out.println("------------------------");
            System.out.println("Pizza Base: " + pizza.getPizzaType().getName() + " " + pizza.getPizzaType().getPrice() + " $");

            for (Ingredient ingredient : pizza.getIngredients()) {
                System.out.println(ingredient.getName() + " " + ingredient.getPrice() + " $");
            }

            System.out.println("------------------------");
            System.out.println("Quantity: " + pizza.getQuantity());
            System.out.println("Amount: " + pizza.calculatePrice() + " $");
            System.out.println("------------------------");
        }
        System.out.println("*****************************");
    }
}