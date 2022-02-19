package Book;

import java.util.ArrayList;
import java.util.Comparator;

public class Book {
    private String title;
    private double year;
    private double rating;
    private Author author;


    public Book(){
        String title="";
        double year=0;
        double rating=0.0;
        String Name=" ";
    }

    public Book(String title, double year, double rating) {
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(double year) {
        this.year = year;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    public String getTitle() {
        return title;
    }

    public double getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }
}
class SortbyRating implements Comparator<Book> {

    public int compare(Book a, Book b)
    {
        return  Double.compare(a.getRating(), b.getRating());
    }
}


class Sortbyname implements Comparator<Book> {
    public int compare(Book a, Book b)
    {
        return a.getTitle().compareToIgnoreCase(b.getTitle());
    }
}
class SortByYear implements Comparator<Book> {

    public int compare(Book a, Book b)
    {
        return (int) (a.getYear() - b.getYear());
    }
}