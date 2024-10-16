import java.util.InputMismatchException;
import java.util.Scanner;

class NumberOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Введите целое число: ");
            int integerNumber = scanner.nextInt();

            if (integerNumber % 2 == 0) {

                System.out.print("Введите дробное число: ");
                double decimalNumber = scanner.nextDouble();

                double product = integerNumber * decimalNumber;
                System.out.printf("Произведение: %.2f%n", product);
            } else {

                System.out.print("Введите другое целое число: ");
                int anotherInteger = scanner.nextInt();

                int sum = integerNumber + anotherInteger;
                System.out.println("Сумма: " + sum);
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: пожалуйста, введите корректные числа.");
        } finally {
            scanner.close();
        }
    }
}