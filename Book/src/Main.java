public class Main {
    public static void main(String[] args) {
        Author fmDostaevsky = new Author("Федор", "Достаевский", 10);
        Book book = new Book("Преступление и наказание", 1866, fmDostaevsky, 6);
        System.out.println("Книга большая?");
        System.out.println(book.isBig());

        System.out.println("Описание книги содержит Достаевский?");
        System.out.println(book.matches("Достаевский"));

        System.out.println("Описание книги содержит Преступление?");
        System.out.println(book.matches("Преступление"));

        System.out.println("Описание книги содержит Федор?");
        System.out.println(book.matches("Федор"));

        System.out.println("Описание книги содержит Вася?");
        System.out.println(book.matches("Вася"));

        System.out.println("Оценка стоимости книги, руб:");
        System.out.println(book.estimatePrice());

        System.out.println(book);
    }
}
