public class Book{

    private String bookName;
    private String authorName;
    private String releaseDate;
    private String publisher;
    private int isbn;

    Book(String bookName, String authorName, String releaseDate, String publisher, int isbn){
        this.bookName= bookName;
        this.authorName = authorName;
        this.releaseDate = releaseDate;
        this.publisher = publisher;
        this.isbn = isbn;

        System.out.println("Book created");
    }

}
