import java.util.Scanner;

class DiscountCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите исходную цену товара: ");
        double originalPrice = scanner.nextDouble();

        System.out.print("Введите процент скидки: ");
        double discountPercentage = scanner.nextDouble();

        double discountAmount = (discountPercentage / 100) * originalPrice;
        double newPrice = originalPrice - discountAmount;

        System.out.printf("Новая цена со скидкой: %.2f%n", newPrice);

        scanner.close();
    }
}