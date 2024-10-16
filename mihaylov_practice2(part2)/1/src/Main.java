import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class TextAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите текст: ");
        String text = scanner.nextLine();

        String[] words = text.split("\\s+");
        int wordCount = words.length;

        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : text.toCharArray()) {
            if (Character.isLetterOrDigit(c) || Character.isWhitespace(c)) {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
        }

        System.out.println("Количество слов: " + wordCount);
        System.out.println("Самое длинное слово: " + longestWord);

        System.out.println("Количество символов:");
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        String reversedText = new StringBuilder(text).reverse().toString();
        System.out.println("Текст в обратном порядке: " + reversedText);

        scanner.close();
    }
}