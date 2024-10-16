//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        int a = 10;
        int b = 5;
        double c = 3.14;
        boolean isTrue = true;
        String message = "Hello, World!";

        int sum = a + b;
        int difference = a - b;
        int product = a * b;
        double division = (double) a / b;
        double modulo = a % b;

        boolean andResult = (a > b) && (b < 10);
        boolean orResult = (a < b) || (b > 0);
        boolean notResult = !isTrue;

        System.out.println("Сумма: " + sum);
        System.out.println("Разность: " + difference);
        System.out.println("Произведение: " + product);
        System.out.println("Деление: " + division);
        System.out.println("Остаток от деления: " + modulo);
        System.out.println("Результат логического И: " + andResult);
        System.out.println("Результат логического ИЛИ: " + orResult);
        System.out.println("Логическое отрицание: " + notResult);
        System.out.println("Строка: " + message);

        }
    }
