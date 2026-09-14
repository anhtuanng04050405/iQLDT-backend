package DAO;

import DB.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
    public static boolean checkLogin(String username, String password) {
        String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";
        try {
            Connection conn = DBConnection.CreateConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                conn.close();
                return true;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}