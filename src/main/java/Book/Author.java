package Book;

import java.util.ArrayList;

public class Author {
    private String AutherName;

    private ArrayList<Book> book;

    public Author(String name,ArrayList<Book> book) {
        this.AutherName = name;
        this.book =book;
    }
    public String getName() {

        return AutherName;
    }

    public void setAutherName(String autherName) {
        AutherName = autherName;
    }

    public ArrayList<Book> getBook() {
        return book;
    }
}
