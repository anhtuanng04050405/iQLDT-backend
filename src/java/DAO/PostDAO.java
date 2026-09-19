package DAO;

import BEAN.Post;
import DB.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {

    public static List<Post> getAllPosts() {
        List<Post> list = new ArrayList<>();
        String sql = "SELECT * FROM su_kien";
        
        try (Connection conn = DBConnection.CreateConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Post p = new Post();
                p.setId(rs.getInt("id"));
                p.setTieude(rs.getString("tieude"));
                p.setGiobatdau(rs.getString("giobatdau"));
                p.setBatdau(rs.getString("batdau"));
                p.setGioketthuc(rs.getString("gioketthuc"));
                p.setKetthuc(rs.getString("ketthuc"));
                p.setDiadiem(rs.getString("diadiem"));
                p.setNoidung(rs.getString("noidung"));
                p.setImgURL(rs.getString("imgURL"));
                
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Post getPostById(int id) {
        String sql = "SELECT * FROM su_kien WHERE id = ?";
        try (Connection conn = DBConnection.CreateConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Post p = new Post();
                    p.setId(rs.getInt("id"));
                    p.setTieude(rs.getString("tieude"));
                    p.setGiobatdau(rs.getString("giobatdau"));
                    p.setBatdau(rs.getString("batdau"));
                    p.setGioketthuc(rs.getString("gioketthuc"));
                    p.setKetthuc(rs.getString("ketthuc"));
                    p.setDiadiem(rs.getString("diadiem"));
                    p.setNoidung(rs.getString("noidung"));
                    p.setImgURL(rs.getString("imgURL"));
                    return p;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addPost(Post p) {
        String sql = "INSERT INTO su_kien (tieude, giobatdau, batdau, gioketthuc, ketthuc, diadiem, noidung, imgURL) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.CreateConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, p.getTieude());
            ps.setString(2, p.getGiobatdau());
            ps.setString(3, p.getBatdau());
            ps.setString(4, p.getGioketthuc());
            ps.setString(5, p.getKetthuc());
            ps.setString(6, p.getDiadiem());
            ps.setString(7, p.getNoidung());
            ps.setString(8, p.getImgURL());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updatePost(Post p) {
        String sql = "UPDATE su_kien SET tieude=?, giobatdau=?, batdau=?, gioketthuc=?, ketthuc=?, diadiem=?, noidung=?, imgURL=? WHERE id=?";
        try (Connection conn = DBConnection.CreateConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, p.getTieude());
            ps.setString(2, p.getGiobatdau());
            ps.setString(3, p.getBatdau());
            ps.setString(4, p.getGioketthuc());
            ps.setString(5, p.getKetthuc());
            ps.setString(6, p.getDiadiem());
            ps.setString(7, p.getNoidung());
            ps.setString(8, p.getImgURL());
            ps.setInt(9, p.getId());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deletePost(int id) {
        String sql = "DELETE FROM su_kien WHERE id=?";
        try (Connection conn = DBConnection.CreateConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}