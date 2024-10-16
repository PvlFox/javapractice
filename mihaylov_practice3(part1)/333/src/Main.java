class MaxFinder {
    public static void main(String[] args) {

        int[] array1 = {1, 3, 7, 0, -5};
        int[] array2 = {12, 5, 9, 18, 7};
        int[] array3 = {-1, -4, -3, -2};

        System.out.println("Максимум в первом массиве: " + findMax(array1));
        System.out.println("Максимум во втором массиве: " + findMax(array2));
        System.out.println("Максимум в третьем массиве: " + findMax(array3));
    }

    public static int findMax(int[] numbers) {
        int max = numbers[0];

        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }

        return max;
    }
}