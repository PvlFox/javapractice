class SumExample {

    public static int sum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {

        int result1 = sum(5, 10);
        int result2 = sum(-3, 7);
        int result3 = sum(0, 0);
        int result4 = sum(100, 250);

        System.out.println("Сумма 5 и 10: " + result1);
        System.out.println("Сумма -3 и 7: " + result2);
        System.out.println("Сумма 0 и 0: " + result3);
        System.out.println("Сумма 100 и 250: " + result4);
    }
}