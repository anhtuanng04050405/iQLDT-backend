package DAO;

import BEAN.Post;
import DB.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {

    // 1. Get all posts from su_kien
    public static List<Post> getAllPosts() {
        List<Post> list = new ArrayList<>();
        String sql = "SELECT * FROM su_kien";
        
        try {
            Connection conn = DBConnection.CreateConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Post p = new Post();
                p.setId(rs.getInt("id"));
                p.setTieude(rs.getString("tieude"));
                p.setBatdau(rs.getString("batdau"));
                p.setKetthuc(rs.getString("ketthuc"));
                p.setDiadiem(rs.getString("diadiem"));
                p.setNoidung(rs.getString("noidung"));
                p.setImgURL(rs.getString("imgURL"));
                
                list.add(p);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 2. Add Post
    public boolean addPost(Post p) {
        String sql = "INSERT INTO su_kien (tieude, batdau, ketthuc, diadiem, noidung, imgURL) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = DBConnection.CreateConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getTieude());
            ps.setString(2, p.getBatdau());
            ps.setString(3, p.getKetthuc());
            ps.setString(4, p.getDiadiem());
            ps.setString(5, p.getNoidung());
            ps.setString(6, p.getImgURL());
            
            int check = ps.executeUpdate();
            conn.close();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 3. Cập nhật bài viết theo id
    public boolean updatePost(Post p) {
        String sql = "UPDATE su_kien SET tieude=?, batdau=?, ketthuc=?, diadiem=?, noidung=?, imgURL=? WHERE id=?";
        try {
            Connection conn = DBConnection.CreateConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getTieude());
            ps.setString(2, p.getBatdau());
            ps.setString(3, p.getKetthuc());
            ps.setString(4, p.getDiadiem());
            ps.setString(5, p.getNoidung());
            ps.setString(6, p.getImgURL());
            ps.setInt(7, p.getId());
            
            int check = ps.executeUpdate();
            conn.close();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 4. Xóa bài viết theo id
    public boolean deletePost(int id) {
        String sql = "DELETE FROM su_kien WHERE id=?";
        try {
            Connection conn = DBConnection.CreateConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            
            int check = ps.executeUpdate();
            conn.close();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}