class EvenChecker {
    public static void main(String[] args) {

        int[] numbers = {2, 3, 4, 5, 10, 15};

        for (int number : numbers) {
            if (isEven(number)) {
                System.out.println(number + " - четное");
            } else {
                System.out.println(number + " - нечетное");
            }
        }
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}