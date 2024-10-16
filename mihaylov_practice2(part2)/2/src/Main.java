import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class CityGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> cityMap = new HashMap<>();
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        List<String> cities = new LinkedList<>();

        String previousCity = "";
        String currentPlayer = "Игрок 1";

        while (true) {
            System.out.print(currentPlayer + ", введите название города: ");
            String city = scanner.nextLine().trim().toLowerCase();

            if (city.isEmpty() || cityMap.containsKey(city)) {
                System.out.println("Ошибка: город уже был введён или название пустое. Попробуйте снова.");
                continue;
            }

            if (!previousCity.isEmpty() && city.charAt(0) != previousCity.charAt(previousCity.length() - 1)) {
                System.out.println("Ошибка: название города должно начинаться с буквы '" + previousCity.charAt(previousCity.length() - 1) + "'. Попробуйте снова.");
                continue;
            }

            cityMap.put(city, cityMap.getOrDefault(city, 0) + 1);
            cities.add(city);

            char lastChar = city.charAt(city.length() - 1);
            charCountMap.put(lastChar, charCountMap.getOrDefault(lastChar, 0) + 1);

            previousCity = city;

            currentPlayer = currentPlayer.equals("Игрок 1") ? "Игрок 2" : "Игрок 1";

            System.out.println("Список городов: " + String.join(", ", cities));
            System.out.println("Количество слов: " + cityMap.size());
            System.out.println("Количество букв в конце городов: " + charCountMap);
        }
    }
}