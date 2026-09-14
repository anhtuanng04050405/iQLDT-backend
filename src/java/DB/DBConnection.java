package DB;
import java.sql.*;

public class DBConnection {
    public static Connection CreateConnection(){
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/iqldt";
        String username = "root";
        String password = "1234";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.getLogger(DBConnection.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.getLogger(DBConnection.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return conn;
    }
}
