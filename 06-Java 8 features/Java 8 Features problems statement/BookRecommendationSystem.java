package name;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class Book {
    private String title;
    private String author;
    private String genre;
    private double rating;

    public Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public double getRating() { return rating; }
}

class BookRecommendation {
    private String title;
    private double rating;

    public BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Rating: " + rating;
    }
}

public class BookRecommendationSystem {
    public static void recommendBooks(List<Book> books, int pageNumber) {
        int pageSize = 5;

        List<BookRecommendation> recommendations = books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase("Science Fiction") && book.getRating() > 4.0)
                .map(book -> new BookRecommendation(book.getTitle(), book.getRating()))
                .sorted(Comparator.comparingDouble(BookRecommendation::getRating).reversed())
                .limit(10)
                .collect(toList());

        int fromIndex = (pageNumber - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, recommendations.size());

        if (fromIndex >= recommendations.size()) {
            System.out.println("Page " + pageNumber + " is out of range.");
            return;
        }

        System.out.println("Page " + pageNumber + " of Book Recommendations:");
        recommendations.subList(fromIndex, toIndex).forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Dune", "Frank Herbert", "Science Fiction", 4.8),
            new Book("Neuromancer", "William Gibson", "Science Fiction", 4.2),
            new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.3),
            new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.1),
            new Book("Ender's Game", "Orson Scott Card", "Science Fiction", 4.5),
            new Book("Snow Crash", "Neal Stephenson", "Science Fiction", 4.0),
            new Book("The Martian", "Andy Weir", "Science Fiction", 4.6),
            new Book("Brave New World", "Aldous Huxley", "Science Fiction", 4.4),
            new Book("Old Man's War", "John Scalzi", "Science Fiction", 4.2),
            new Book("The Left Hand of Darkness", "Ursula K. Le Guin", "Science Fiction", 4.3),
            new Book("1984", "George Orwell", "Dystopian", 4.7)
        );
        recommendBooks(books, 1);
        recommendBooks(books, 2);
    }
}

