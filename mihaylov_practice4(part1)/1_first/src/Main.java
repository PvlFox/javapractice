class Book {

    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void displayInfo() {
        System.out.println("Название: " + title);
        System.out.println("Автор: " + author);
        System.out.println("Цена: $" + price);
        System.out.println();
    }
}

class BookExample {
    public static void main(String[] args) {

        Book book1 = new Book("1984", "Джордж Оруэлл", 9.99);
        Book book2 = new Book("Убить пересмешника", "Харпер Ли", 7.99);
        Book book3 = new Book("Гарри Поттер и философский камень", "Джоан Роулинг", 10.99);

        System.out.println("Информация о книгах:");
        book1.displayInfo();
        book2.displayInfo();
        book3.displayInfo();
    }
}