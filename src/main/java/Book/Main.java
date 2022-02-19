package Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<Author, ArrayList<Book>> map = new HashMap<>();
        Map<String, Integer> bookCount = new HashMap<>();
        ArrayList<String> TitleofBook=new ArrayList<String>();
        ArrayList<String> AuthorName=new ArrayList<String>();
        ArrayList<String> BookName=new ArrayList<String>();
        ArrayList<Book> bookhash = null;
        Scanner sc = new Scanner(System.in);

        ArrayList<String> authorName = new ArrayList<>();
        ArrayList<Author> autherArray = new ArrayList<>();
        ArrayList<Book> bookArray = new ArrayList<>();
        Set<String> ba = null;
        Author author;
        Book book;


        String line = "";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\246714\\IdeaProjects\\JavaLab_Excercise_Part2\\src\\main\\resources\\Books.csv"));
            int k=0;
            while ((line = br.readLine()) != null)
            {
                if(k == 0){
                    k++;
                    continue;
                }
                String BookDeatils[] = line.split(";");

                AuthorName.add(BookDeatils[6]);
                BookName.add(BookDeatils[8]);
                if (BookDeatils[6].contains(",")) {
                    String repet[] = BookDeatils[6].split(",");
                    for (int i = 0; i < repet.length; i++) {
                        authorName.add(repet[i]);
                        book = new Book(BookDeatils[8], Double.parseDouble(BookDeatils[7]), Double.parseDouble(BookDeatils[10]));
                        bookArray.add(book);
                    }
                } else {
                        authorName.add(BookDeatils[6]);
                        book = new Book(BookDeatils[8], Double.parseDouble(BookDeatils[7]), Double.parseDouble(BookDeatils[10]));
                        bookArray.add(book);
                }
            }
        } catch (
                IOException e)
        {
            e.printStackTrace();
        }


       //store auther details to auther
        for (int i = 0; i < authorName.size(); i++) {
            String auther_name = authorName.get(i);
            bookhash = new ArrayList<Book>();
            for (int k = 0; k < authorName.size(); k++) {
                if (auther_name.equals(authorName.get(k))) {
                    bookhash.add(bookArray.get(k));
                }
            }
            author = new Author(auther_name, bookhash);
            autherArray.add(author);
            map.put(author, bookhash);
        }
        Main main1 =new Main();
        int temp=0;
        while (temp!=8) {
            System.out.println("\n*************************************"+
                    "\n1. Sort By Title" +
                    "\n2. Sorte By Rating" +
                    "\n3. Sort By Year" +
                    "\n4. Enter Name of book, know who is the author" +
                    "\n5. How many books has an author written" +
                    "\n6. Enter a Date-books written in that year" +
                    "\n7. Most prolific author?" +
                    "\n8. Exit"
            );
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    main1.printsortbytitle(autherArray, 1);
                    break;
                case 2:
                    main1.printsortbytitle(autherArray, 2);
                    break;
                case 3:
                    main1.printsortbytitle(autherArray, 3);
                    break;
                case 4:
                System.out.println("*******************************************");
                System.out.println("Enter Name Of the Book = ");

                Scanner sc1 = new Scanner(System.in);
                String bookName = sc1.nextLine();
                ba = new HashSet<>();
                for (Author author1 : autherArray) {
                    for (Book book1 : author1.getBook()) {
                        if (book1.getTitle().equals(bookName)) {
                            ba.add(author1.getName());
                        }
                    }
                }
                for (String AutherNametoprint : ba) {
                    System.out.println("Author =" + AutherNametoprint);
                }
                break;
                case 5:
                System.out.println("*******************************************");
                System.out.println("Enter Name Of the Author = ");
                sc = new Scanner(System.in);
                String autherName = sc.nextLine();
                ba = new HashSet<>();
                for (Author author1 : autherArray) {
                    if (author1.getName().equals(autherName)) {
                        for (Book book1 : author1.getBook()) {
                            ba.add(book1.getTitle());
                        }
                    }
                }
                System.out.println(ba.size()+"Books written By" + " = " + autherName);
                break;
                case 6:
                System.out.println("*******************************************");
                System.out.println("Enter Name Of the Author = ");
                System.out.println("Enter Year = ");
                sc = new Scanner(System.in);
                int year = sc.nextInt();
                Set<String> nameOfBook = new HashSet<>();
                for (Author author1 : autherArray) {
                    for (Book book1 : author1.getBook()) {
                        if (book1.getYear() == year) {
                            nameOfBook.add(book1.getTitle());
                        }
                    }
                }

                System.out.println("Books in " + year + " are=");
                for (String s : nameOfBook) {
                    System.out.println(s);
                }
                break;
                case 7:
                System.out.println("*******************************************");
                for (Author author1 : autherArray) {
                    int count = 0;
                    for (Book book1 : author1.getBook()) {
                        count++;
                    }
                    bookCount.put(author1.getName(), count);
                }
                Map<String, Integer> result = new LinkedHashMap<>();
                bookCount.entrySet().stream()
                        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                        .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));

                Set<String> l = result.keySet();
                System.out.println("Most prolific author =" + l.iterator().next());
                break;
                case 8:
                    temp=8;
                    break;
                default:
                    break;
            }
        }
    }
    public void printsortbytitle(ArrayList<Author> autherArray,int abc){

        System.out.println("*******************************************");
        if(abc==1){
            System.out.println("Sort By Book Title ");
        }else if(abc==2){
            System.out.println("Sort By Average Rating");
        }else{
            System.out.println("Sort By Year");
        }
        System.out.println("*******************************************");
        for (int i = 0; i < autherArray.size(); i++) {
            if(abc==1) {
                Collections.sort(autherArray.get(i).getBook(), new Sortbyname());
            }else if(abc==2){
                Collections.sort(autherArray.get(i).getBook(), new SortbyRating());
            }else{
                Collections.sort(autherArray.get(i).getBook(), new SortByYear());
            }
        }
        for (Author author1 : autherArray) {
            System.out.println("Author = " + author1.getName());
            for (Book book1 : author1.getBook()) {
                if(abc==1) {
                    System.out.println("Title  =  " + book1.getTitle());
                }else if(abc==2){
                    System.out.println("Ratings  = " + book1.getRating());
                }else {
                    System.out.println("Year = " + book1.getYear());
                }
            }
        }
    }
}
