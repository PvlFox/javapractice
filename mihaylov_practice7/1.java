import java.util.*;

public class CafeApp {

    // меню
    public static class MenuItem {
        private String name;
        private double price;
        private String category;

        public MenuItem(String name, double price, String category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        @Override
        public String toString() {
            return name + " - " + price + " тг";
        }
    }

    // заказ
    public static class Order {
        private static int idCounter = 1;
        private int orderId;
        private Date date;
        private List<MenuItem> items;

        public Order(List<MenuItem> items) {
            this.orderId = idCounter++;
            this.date = new Date();
            this.items = items;
        }

        public int getOrderId() {
            return orderId;
        }

        public Date getDate() {
            return date;
        }

        public List<MenuItem> getItems() {
            return items;
        }
    }

    // заказчик
    public static class Customer {
        private String name;
        private String phone;
        private List<Order> orderHistory;

        public Customer(String name, String phone) {
            this.name = name;
            this.phone = phone;
            this.orderHistory = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public List<Order> getOrderHistory() {
            return orderHistory;
        }

        public void addOrder(Order order) {
            orderHistory.add(order);
        }
    }

    // Интерфейс ICafe
    public interface ICafe {
        void addMenuItem(MenuItem item);
        void removeMenuItem(String name);
        List<MenuItem> getMenuItems();
        Order createOrder(Customer customer, List<MenuItem> items);
    }

    // Класс Cafe реализует интерфейс ICafe
    public static class Cafe implements ICafe {
        private List<MenuItem> menu;
        private Map<Integer, Customer> customers;

        public Cafe() {
            menu = new ArrayList<>();
            customers = new HashMap<>();
        }

        @Override
        public void addMenuItem(MenuItem item) {
            menu.add(item);
        }

        @Override
        public void removeMenuItem(String name) {
            menu.removeIf(item -> item.getName().equalsIgnoreCase(name));
        }

        @Override
        public List<MenuItem> getMenuItems() {
            return menu;
        }

        @Override
        public Order createOrder(Customer customer, List<MenuItem> items) {
            Order order = new Order(items);
            customer.addOrder(order);
            return order;
        }

        public void addCustomer(int id, Customer customer) {
            customers.put(id, customer);
        }

        public Customer getCustomer(int id) {
            return customers.get(id);
        }
    }

    // Главный класс для запуска программы
    public static void main(String[] args) {
        // Создаем кафе и добавляем несколько блюд в меню
        Cafe cafe = new Cafe();
        cafe.addMenuItem(new MenuItem("Кофе", 950.0, "Напитки"));
        cafe.addMenuItem(new MenuItem("Сэндвич", 1900.0, "Еда"));
        cafe.addMenuItem(new MenuItem("Чизкейк", 1230.0, "Десерт"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в кафе!");
        System.out.print("Введите имя клиента: ");
        String name = scanner.nextLine();
        System.out.print("Введите телефон клиента: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(name, phone);
        List<MenuItem> orderItems = new ArrayList<>();
        boolean ordering = true;

        // Главный цикл для оформления заказа
        while (ordering) {
            System.out.println("\nМеню:");
            for (MenuItem item : cafe.getMenuItems()) {
                System.out.println(item);
            }

            System.out.print("Введите название блюда для добавления в заказ (или 'готово' для завершения): ");
            String itemName = scanner.nextLine();

            if (itemName.equalsIgnoreCase("готово")) {
                ordering = false;
            } else {
                boolean itemFound = false;
                for (MenuItem item : cafe.getMenuItems()) {
                    if (item.getName().equalsIgnoreCase(itemName)) {
                        orderItems.add(item);
                        System.out.println(itemName + " добавлен в заказ.");
                        itemFound = true;
                        break;
                    }
                }
                if (!itemFound) {
                    System.out.println("Блюдо с таким названием не найдено.");
                }
            }
        }

        // Создаем заказ
        Order order = cafe.createOrder(customer, orderItems);
        System.out.println("\nID заказа: " + order.getOrderId());
        System.out.println("Заказанные блюда:");
        for (MenuItem item : order.getItems()) {
            System.out.println(item);
        }
        double totalPrice = orderItems.stream().mapToDouble(MenuItem::getPrice).sum();
        System.out.printf("Общая стоимость (тг): %.2f%n", totalPrice);

        scanner.close();
    }
}