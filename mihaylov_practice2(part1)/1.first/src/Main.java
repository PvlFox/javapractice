import java.util.Scanner;

class Greetings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine();
        System.out.println("Здравствуй, " + name + "!");
        scanner.close();
    }
}