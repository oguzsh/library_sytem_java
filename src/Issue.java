public class Issue {

    private String bookName;
    private String bookISBN;
    private String userIDN;
    private String periodDay;
    private String issuedDate;


    Issue(String bookName, String bookISBN, String userIDN, String periodDay, String issuedDate){
        this.bookName = bookName;
        this.bookISBN = bookISBN;
        this.userIDN = userIDN;
        this.periodDay = periodDay;
        this.issuedDate = issuedDate;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String getUserIDN() {
        return userIDN;
    }

    public void setUserIDN(String userIDN) {
        this.userIDN = userIDN;
    }

    public String getPeriodDay() {
        return periodDay;
    }

    public void setPeriodDay(String periodDay) {
        this.periodDay = periodDay;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }
}
