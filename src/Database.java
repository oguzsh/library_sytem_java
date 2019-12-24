import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
    private Connection con = null;
    private Statement stat = null;
    private ResultSet rs = null;

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

    public void closeDb(){
        try{
            con.close();
            stat.close();
        }catch(Exception e){
            System.err.println("Hata" + e);
        }
    }
}
