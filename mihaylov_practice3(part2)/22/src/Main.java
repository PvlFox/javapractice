class FactorialCalculator {
    public static void main(String[] args) {
        int number1 = 5;
        int number2 = 7;
        int number3 = 0;

        System.out.println(number1 + "! = " + factorial(number1));
        System.out.println(number2 + "! = " + factorial(number2));
        System.out.println(number3 + "! = " + factorial(number3));
    }

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал для отрицательных чисел не определён.");
        }
        long result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}