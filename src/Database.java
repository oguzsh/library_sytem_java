import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

public class Database {
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
            rs = stat.executeQuery("SELECT * FROM books");
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

    public void closeDb(){
        try{
            con.close();
            stat.close();
        }catch(Exception e){
            System.err.println("Hata" + e);
        }
    }
}
