import java.util.Scanner;

class SymmetricNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите трехзначное положительное число: ");
        int number = scanner.nextInt();
        if (number < 100 || number > 999) {
            System.out.println("Ошибка: введенное число не является трехзначным.");
        } else {
            int firstDigit = number / 100;
            int lastDigit = number % 10;
            if (firstDigit == lastDigit) {
                System.out.println("Число " + number + " является симметричным.");
            } else {
                System.out.println("Число " + number + " не является симметричным.");
            }
        }
        scanner.close();
    }
}