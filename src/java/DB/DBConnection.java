package DB;
import java.sql.*;

public class DBConnection {
    public static Connection CreateConnection(){
        Connection conn = null;
        String url = "jdbc:mysql://gateway01.ap-southeast-1.prod.aws.tidbcloud.com:4000/iqldt?sslMode=VERIFY_IDENTITY";
        String username = "2dttsUDTBABDmD3.root";
        String password = "xKNSpi8N3c5yWQhb";
        
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
