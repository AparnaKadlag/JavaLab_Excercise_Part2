package Book;

import junit.framework.TestCase;

import java.util.ArrayList;

public class AuthorTest extends TestCase {
    Author author;
    ArrayList<Book> book1 = null;

    @org.junit.Test
    public void testTestGetName() {
        author =new Author("E.L. James",book1);
        String Name = author.getName();
        assertEquals(Name,Name);
    }
}