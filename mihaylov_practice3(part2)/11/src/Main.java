class SumOfDigits {
    public static void main(String[] args) {

        int number1 = 1234;
        int number2 = 5678;
        int number3 = -4321;

        System.out.println("Сумма цифр числа " + number1 + ": " + sumDigits(number1));
        System.out.println("Сумма цифр числа " + number2 + ": " + sumDigits(number2));
        System.out.println("Сумма цифр числа " + number3 + ": " + sumDigits(number3));
    }

    public static int sumDigits(int number) {
        int sum = 0;
        number = Math.abs(number);

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}