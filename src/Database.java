import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

public class Database implements IBook{
    private Connection con = null;
    public Statement stat = null;
    public ResultSet rs = null;

    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String dbName = "library_system";
    private final String url = "jdbc:mysql://localhost:3306/"+dbName+"?serverTimezone=UTC";
    private final String user = "root";
    private final String password = "";

    Database(){
        this.connect();
    }

    public Statement connect(){
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);
            stat = con.createStatement();
            System.out.println("Veritabanı bağlantısı başarılı");

        }catch (Exception e){
            System.out.println("Veritabanı bağlantısı başarısız");
            System.err.println("Hata" + e);
        }

        return stat;
    }


    public DefaultTableModel viewBooks(DefaultTableModel dataModel){
        connect();
        try{
            // Tablolardan books tablosu seçildi
            rs = stat.executeQuery("SELECT * FROM books");
            // Veritabanı teknik bilgileri alındı ( satır-sütun sayısı vs.)
            ResultSetMetaData md = rs.getMetaData();

            // Tablonun sütun sayısı öğrenildi değişkene atıldı ve sutünlardaki veriler tek tek okundu ve ekledik
            int columnCount = md.getColumnCount();
            for(int i = 1; i <= columnCount; i++ ){
                dataModel.addColumn(md.getColumnName(i));
            }


            Vector<String> row; //String tipinde bir vektör oluşturup adına row dedik


            while(rs.next()){   //içerideki veri bitene kadar okuyoruz
                row = new Vector<>(columnCount);  //oluşturduğumuz row değişkenine sütun sayısı kadar vektör oluşturup row'a attık
                for(int i = 1; i<=columnCount; i++){
                    row.add(rs.getString(i)); // satırlara verileri yerleştirdik
                }
                // Bütün veriyi row değişkeni ile dataModel e ekledik
                dataModel.addRow(row);
            }
        } catch (SQLException e) {
            System.out.println("Hata : " + e);
        }

        closeDb(); //veritabanı bağlantısını kapatıyoruz
        return dataModel;
    }

    public DefaultTableModel viewUsers(DefaultTableModel dataModel){
        connect();
        try{
            rs = stat.executeQuery("SELECT * FROM users");
            ResultSetMetaData md = rs.getMetaData();

            int columnCount = md.getColumnCount();
            for(int i = 1; i <= columnCount; i++ ){
                dataModel.addColumn(md.getColumnName(i));
            }

            Vector<String> row;
            while(rs.next()){
                row = new Vector<>(columnCount);
                for(int i = 1; i<=columnCount; i++){
                    row.add(rs.getString(i));
                }
                dataModel.addRow(row);
            }
        } catch (SQLException e) {
            System.out.println("Hata : " + e);
        }

        closeDb();
        return dataModel;
    }

    public DefaultTableModel viewIssued(DefaultTableModel dataModel){
        connect();
        try{
            rs = stat.executeQuery("SELECT * FROM issues");
            ResultSetMetaData md = rs.getMetaData();

            int columnCount = md.getColumnCount();
            for(int i = 1; i <= columnCount; i++ ){
                dataModel.addColumn(md.getColumnName(i));
            }

            Vector<String> row;
            while(rs.next()){
                row = new Vector<>(columnCount);
                for(int i = 1; i<=columnCount; i++){
                    row.add(rs.getString(i));
                }
                dataModel.addRow(row);
            }
        } catch (SQLException e) {
            System.out.println("Hata : " + e);
        }

        closeDb();
        return dataModel;
    }

    public void addUser(User user){
        connect();
        try {
            String query = "INSERT INTO users(first_name, last_name, password, identif_number, role) VALUES (?,?,?,?,?);";
            PreparedStatement p_stat = con.prepareStatement(query);
            p_stat.setString(1, user.getName());
            p_stat.setString(2, user.getLastname());
            p_stat.setString(3, user.getPassword());
            p_stat.setString(4, user.getIdentifyNumber());
            p_stat.setString(5, user.getRole());
            int status = p_stat.executeUpdate();
            p_stat.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addBook(Book book){
        connect();
        try {
            String query = "INSERT INTO books(bookName, authorName, releaseDate, publisher, ISBN) VALUES (?,?,?,?,?);";
            PreparedStatement p_stat = con.prepareStatement(query);
            p_stat.setString(1, book.getBookName());
            p_stat.setString(2, book.getAuthorName());
            p_stat.setString(3, book.getReleaseDate());
            p_stat.setString(4, book.getPublisher());
            p_stat.setString(5, book.getIsbn());
            p_stat.executeUpdate();
            p_stat.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void addIssue(Issue issue){
        connect();
        try {
            String query = "INSERT INTO issues(issue_bookName, issue_Date, issue_ISBN, user_identify) VALUES (?,?,?,?);";
            PreparedStatement p_stat = con.prepareStatement(query);
            p_stat.setString(1, issue.getBookName());
            p_stat.setString(2, issue.getIssuedDate());
            p_stat.setString(3, issue.getBookISBN());
            p_stat.setString(4, issue.getUserIDN());
            p_stat.executeUpdate();
            p_stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeBook(String ISBN) {
        connect();
        try{
            String query = "DELETE FROM books WHERE isbn=?;";
            PreparedStatement p_stat = con.prepareStatement(query);
            p_stat.setString(1, ISBN);
            p_stat.executeUpdate();
            p_stat.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void removeUser(String identifNum) {
        connect();
        try{
            String query = "DELETE FROM users WHERE identif_number=?;";
            PreparedStatement p_stat = con.prepareStatement(query);
            p_stat.setString(1, identifNum);
            p_stat.executeUpdate();
            p_stat.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void closeDb(){
        try{
            con.close();
            stat.close();
        }catch(Exception e){
            System.err.println("Hata" + e);
        }
    }
}
