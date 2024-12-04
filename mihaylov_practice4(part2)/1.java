import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private boolean isCheckedOut;

    // Конструктор для инициализации полей
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isCheckedOut = false; // книга доступна по умолчанию
    }

    // Метод для изменения статуса книги на "на руках"
    public void checkout() {
        this.isCheckedOut = true;
    }

    // Метод для изменения статуса книги на "доступна"
    public void checkin() {
        this.isCheckedOut = false;
    }

    // Геттер для поля title
    public String getTitle() {
        return title;
    }

    // Метод для вывода информации о книге
    public void displayInfo() {
        System.out.println("Название: " + title);
        System.out.println("Автор: " + author);
        System.out.println("Доступна: " + (isCheckedOut ? "Нет" : "Да"));
    }

    // Геттер для статуса книги
    public boolean isCheckedOut() {
        return isCheckedOut;
    }
}

class Reader {
    private String name;
    private List<Book> checkedOutBooks;

    // Конструктор для инициализации полей
    public Reader(String name) {
        this.name = name;
        this.checkedOutBooks = new ArrayList<>();
    }

    // Метод для того, чтобы взять книгу в библиотеке
    public void checkoutBook(Book book) {
        if (!book.isCheckedOut()) {
            book.checkout();
            checkedOutBooks.add(book);
        } else {
            System.out.println("Книга \"" + book.getTitle() + "\" уже на руках.");
        }
    }

    // Метод для того, чтобы вернуть книгу в библиотеку
    public void checkinBook(Book book) {
        if (checkedOutBooks.contains(book)) {
            book.checkin();
            checkedOutBooks.remove(book);
        } else {
            System.out.println("Эта книга не была взята вами.");
        }
    }

    // Метод для вывода информации о читателе и книгах
    public void displayInfo() {
        System.out.println("Читатель: " + name);
        System.out.println("Книги на руках:");
        for (Book book : checkedOutBooks) {
            book.displayInfo();
        }
    }
}

class Library {
    private List<Book> books;

    // Конструктор для инициализации списка книг
    public Library() {
        this.books = new ArrayList<>();
    }

    // Метод для добавления книги в библиотеку
    public void addBook(Book book) {
        books.add(book);
    }

    // Метод для отображения доступных книг
    public void displayAvailableBooks() {
        System.out.println("Доступные книги:");
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                book.displayInfo();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // объекты библиотеки
        Library library = new Library();

        // объекты книг
        Book book1 = new Book("1984", "Джордж Оруэлл");
        Book book2 = new Book("Гарри Поттер", "Джоан Роулинг");

        library.addBook(book1);
        library.addBook(book2);

        Reader reader = new Reader("Жанибек");

        // Вывод доступных книг
        library.displayAvailableBooks();

        // Читатель берет книгу
        reader.checkoutBook(book1);
        reader.displayInfo();

        // Вывод доступных книг после того, как читатель взял книгу
        library.displayAvailableBooks();

        // Читатель возвращает книгу
        reader.checkinBook(book1);
        reader.displayInfo();

        // Вывод доступных книг после возврата книги
        library.displayAvailableBooks();
    }
}