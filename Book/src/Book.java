public class Book {

    String title;
    int releaseYear;
    Author author;
    int pages;

    public Book(String title, int releaseYear, Author author, int pages) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.author = author;
        this.pages = pages;
    }

    public boolean isBig() {
        if (pages > 500) {
            return true;
        } else {
            return false;
        }

    }

    public boolean matches(String word) {
        if (author.name.contains(word) || author.surname.contains(word) || title.contains(word)) {
            return true;
        } else return false;
    }

    public int estimatePrice() {
        int price = (int) Math.floor(3 * pages * Math.sqrt(author.rating));
        if (price > 250) {
            return price;
        } else {
            return 250;
        }
    }

    @Override
    public String toString() {
        return "Название книги: " + "\"" + title + "\"" + ", год выпуска книги: " + releaseYear + ", автор: " + author.name + " " + author.surname + ", кол-во страниц: " + pages;
    }


}
