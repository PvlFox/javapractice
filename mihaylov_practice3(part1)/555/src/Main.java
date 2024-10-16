class AverageCalculator {
    public static void main(String[] args) {

        double average1 = calculateAverage(10.0, 20.0, 30.0);
        double average2 = calculateAverage(5.5, 7.5, 10.0);
        double average3 = calculateAverage(1.0, 2.0, 3.0);

        System.out.println("Среднее арифметическое первого набора: " + average1);
        System.out.println("Среднее арифметическое второго набора: " + average2);
        System.out.println("Среднее арифметическое третьего набора: " + average3);
    }

    public static double calculateAverage(double num1, double num2, double num3) {
        return (num1 + num2 + num3) / 3;
    }
}