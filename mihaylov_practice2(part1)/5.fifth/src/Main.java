import java.util.Scanner;

class RangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите целое положительное число x: ");

        if (scanner.hasNextInt()) {
            int x = scanner.nextInt();

            if (x > 0) {

                for (int i = -(x - 1); i <= (x - 1); i++) {
                    System.out.print(i + " ");
                }
            } else {
                System.out.println("Ошибка: введите положительное число.");
            }
        } else {
            System.out.println("Ошибка: введите целое число.");
        }

        scanner.close();
    }
}