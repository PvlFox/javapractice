class MethodOverloadingExample {
    public static void main(String[] args) {

        int product1 = multiply(3, 5);
        int product2 = multiply(2, 4, 6);

        System.out.println("Произведение двух чисел: " + product1);
        System.out.println("Произведение трех чисел: " + product2);
    }

    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public static int multiply(int num1, int num2, int num3) {
        return num1 * num2 * num3;
    }
}