class Greeting {

    public static void main(String[] args) {

        printGreeting("Иван");
        printGreeting("Александра");
    }

    public static void printGreeting(String name) {
        System.out.println("Hello, " + name + "!");
    }
}