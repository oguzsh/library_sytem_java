public class Book{

    private String bookName;
    private String authorName;
    private String releaseDate;
    private String publisher;
    private String isbn;

    Book(String bookName, String authorName, String releaseDate, String publisher, String isbn){
        this.bookName= bookName;
        this.authorName = authorName;
        this.releaseDate = releaseDate;
        this.publisher = publisher;
        this.isbn = isbn;

        System.out.println("Book created");
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
