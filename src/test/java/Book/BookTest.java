package Book;

import junit.framework.TestCase;
import org.junit.Test;
public class BookTest extends TestCase {
    @org.junit.Test
    public void testSetTitle() {
        Book book =new Book("The Outsiders",1990.0,4.5);
        String title = book.getTitle();
        assertEquals(title,book.getTitle());
    }
    @org.junit.Test
    public void testSetYear() {
        Book book =new Book("Dracula",2007.0,3.4);
        Double year = book.getYear();
        assertEquals(year,book.getYear());
    }
    @org.junit.Test
    public void testSetRating() {
        Book book =new Book("Flickan som lekte med elden",1974.0,3.6);
        Double rate = book.getRating();
        assertEquals(rate,book.getRating());
    }
    @org.junit.Test
    public void testGetTitle() {
        Book book =new Book("The Outsiders",2005.0,4.1);
        String title = book.getTitle();
        assertEquals(title,book.getTitle());
    }
    @org.junit.Test
    public void testGetYear() {
        Book book =new Book("Fifty Shades Darker",1911.0,3.1);
        Double year = book.getYear();
        assertEquals(year,book.getYear());
    }
    @org.junit.Test
    public void testGetRating() {
        Book book =new Book("Män som hatar kvinnor",1911.0,4.5);
        Double rate = book.getRating();
        assertEquals(rate,book.getRating());
    }
}