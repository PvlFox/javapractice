public class Customer {
    private static int customerIdCounter = 1000;
    private String name;
    private String phoneNumber;
    private int number;

    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.number = customerIdCounter++;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getNumber() {
        return number;
    }
}