class FibonacciExample {
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int result1 = fibonacci(6);
        int result2 = fibonacci(10);
        int result3 = fibonacci(0);
        int result4 = fibonacci(1);

        System.out.println("6-е число Фибоначчи: " + result1);
        System.out.println("10-е число Фибоначчи: " + result2);
        System.out.println("0-е число Фибоначчи: " + result3);
        System.out.println("1-е число Фибоначчи: " + result4);
    }
}