import java.util.*;

public class TodoApp {

    public static class Task {
        private int id;  // айдишник
        private String description;  // описание
        private String category;  // категория
        private boolean isDone;  // выполнен ли
        private Date creationDate;  // дата создания

        // Конструктор
        public Task(int id, String description, String category, boolean isDone) {
            this.id = id;
            this.description = description;
            this.category = category;
            this.isDone = isDone;
            this.creationDate = new Date();  // Дата создания задачи — текущее время
        }

        // Методы доступа
        public int getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }

        public String getCategory() {
            return category;
        }

        public boolean isDone() {
            return isDone;
        }

        public void setDone(boolean isDone) {
            this.isDone = isDone;
        }

        public Date getCreationDate() {
            return creationDate;
        }

        @Override
        public String toString() {
            return id + ". " + description + " (Категория: " + category + ", Статус: " + (isDone ? "Выполнено" : "Не выполнено") + ")";
        }
    }

    // Класс TodoList
    public static class TodoList {
        private List<Task> tasks;  // Список задач
        private Set<String> categories;  // Уникальные категории задач
        private Map<String, List<Task>> tasksByCategory;  // Задачи, сгруппированные по категориям

        // Конструктор
        public TodoList() {
            tasks = new ArrayList<>();
            categories = new HashSet<>();
            tasksByCategory = new HashMap<>();
        }

        // Метод для добавления задачи
        public void addTask(Task task) {
            tasks.add(task);
            categories.add(task.getCategory());

            // Добавляем задачу в HashMap по категории
            tasksByCategory.computeIfAbsent(task.getCategory(), k -> new ArrayList<>()).add(task);

            System.out.println("Задача \"" + task.getDescription() + "\" добавлена.");
        }

        // Метод для удаления задачи
        public void removeTask(int taskId) {
            Task taskToRemove = null;
            for (Task task : tasks) {
                if (task.getId() == taskId) {
                    taskToRemove = task;
                    break;
                }
            }

            if (taskToRemove != null) {
                tasks.remove(taskToRemove);
                tasksByCategory.get(taskToRemove.getCategory()).remove(taskToRemove);
                System.out.println("Задача \"" + taskToRemove.getDescription() + "\" удалена.");
            } else {
                System.out.println("Задача с таким ID не найдена.");
            }
        }

        // Метод для отметки задачи как выполненной
        public void markTaskAsDone(int taskId) {
            for (Task task : tasks) {
                if (task.getId() == taskId) {
                    task.setDone(true);
                    System.out.println("Задача \"" + task.getDescription() + "\" отмечена как выполненная.");
                    return;
                }
            }
            System.out.println("Задача с таким ID не найдена.");
        }

        // Метод для поиска задач по ключевым словам
        public void searchTasks(String keyword) {
            boolean found = false;
            for (Task task : tasks) {
                if (task.getDescription().contains(keyword)) {
                    System.out.println("Найдена задача: " + task);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Задачи с ключевым словом \"" + keyword + "\" не найдены.");
            }
        }

        // Метод для вывода всех задач
        public void displayAllTasks() {
            System.out.println("=== Вывод всех задач ===");
            for (Task task : tasks) {
                System.out.println(task);
            }
        }

        // Метод для вывода задач по категориям
        public void displayTasksByCategory() {
            System.out.println("=== Вывод задач по категориям ===");
            for (String category : categories) {
                System.out.println("Категория: " + category);
                for (Task task : tasksByCategory.get(category)) {
                    System.out.println("- " + task);
                }
            }
        }

        // Метод для вывода статистики по задачам
        public void displayStatistics() {
            int totalTasks = tasks.size();
            int completedTasks = 0;
            int incompleteTasks = 0;

            for (Task task : tasks) {
                if (task.isDone()) {
                    completedTasks++;
                } else {
                    incompleteTasks++;
                }
            }

            System.out.println("=== Статистика ===");
            System.out.println("Всего задач: " + totalTasks);
            System.out.println("Выполнено: " + completedTasks);
            System.out.println("Не выполнено: " + incompleteTasks);
        }
    }

    // Главный класс
    public static void main(String[] args) {
        TodoList todoList = new TodoList();

        // Добавление объектов задач
        todoList.addTask(new Task(1, "Купить молоко", "Покупки", false));
        todoList.addTask(new Task(2, "Позвонить маме", "Личное", false));
        todoList.addTask(new Task(3, "Подготовить отчет", "Работа", false));

        // Вывод всех задач
        todoList.displayAllTasks();

        // Отметка задачи как выполненной
        todoList.markTaskAsDone(1);

        // Поиск задач по ключевому слову
        todoList.searchTasks("отчет");

        // Вывод задач по категориям
        todoList.displayTasksByCategory();

        // Статистика
        todoList.displayStatistics();

        // Добавление новой задачи
        todoList.addTask(new Task(4, "Сходить в спортзал", "Здоровье", false));

        // Обновленный список всех задач
        todoList.displayAllTasks();

        // Удаление задачи
        todoList.removeTask(2);

        // Финальный список задач
        todoList.displayAllTasks();

        // Обновленная статистика
        todoList.displayStatistics();
    }
}