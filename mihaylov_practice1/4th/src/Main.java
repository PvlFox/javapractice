import java.util.Scanner;

class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите температуру в градусах Цельсия: ");
        int celsius = scanner.nextInt();
        double fahrenheit = (celsius * 9.0 / 5) + 32;
        System.out.printf("Температура в градусах Фаренгейта: %.2f%n", fahrenheit);
        scanner.close();
    }
}