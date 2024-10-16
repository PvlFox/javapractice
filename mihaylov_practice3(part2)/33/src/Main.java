class PowerExample {
    public static double power(double a, int n) {
        if (n == 0) {
            return 1;
        }
        else if (n < 0) {
            return 1 / power(a, -n);
        }
        return a * power(a, n - 1);
    }
    public static void main(String[] args) {

        double result1 = power(2, 3);
        double result2 = power(5, 0);
        double result3 = power(3, -2);
        double result4 = power(10, 2);

        System.out.println("2^3: " + result1);
        System.out.println("5^0: " + result2);
        System.out.println("3^-2: " + result3);
        System.out.println("10^2: " + result4);
    }
}