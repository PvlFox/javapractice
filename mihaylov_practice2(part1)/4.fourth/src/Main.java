import java.util.Scanner;

class TimeOfDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите целое число, представляющее час суток (от 0 до 23): ");

        if (scanner.hasNextInt()) {
            int hour = scanner.nextInt();

            if (hour >= 0 && hour <= 23) {
                String period;
                if (hour >= 6 && hour < 10) {
                    period = "Утро";
                } else if (hour >= 10 && hour < 18) {
                    period = "День";
                } else if (hour >= 18 && hour < 22) {
                    period = "Вечер";
                } else {
                    period = "Ночь";
                }
                System.out.println(period);
            } else {
                System.out.println("Ошибка: введите число от 0 до 23.");
            }
        } else {
            System.out.println("Ошибка: введите целое число.");
        }

        scanner.close();
    }
}