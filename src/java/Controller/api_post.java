package Controller;

import BEAN.Post;
import DAO.PostDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api_post")
public class api_post extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        
        PrintWriter out = response.getWriter();
        
        List<Post> list = PostDAO.getAllPosts();
        
        StringBuilder json = new StringBuilder();
        json.append("{\"status\":\"success\",\"data\":[");
        
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Post p = list.get(i);
                
                String imgUrl = p.getImgURL();
                String imgUrl = p.getImgURL();
                
                if (imgUrl == null || imgUrl.trim().isEmpty() || "null".equalsIgnoreCase(imgUrl.trim()) || "undefined".equalsIgnoreCase(imgUrl.trim())) {
                    imgUrl = "https://xdcs.cdnchinhphu.vn/446259493575335936/2025/8/22/bk-1755856140169844190839.jpg";
                }
        
                json.append("{")
                    .append("\"id\":").append(p.getId()).append(",")
                    .append("\"post_tieude\":\"").append(escapeJson(p.getTieude())).append("\",")
                    .append("\"post_giobatdau\":\"").append(escapeJson(p.getGiobatdau())).append("\",")
                    .append("\"post_batdau\":\"").append(escapeJson(p.getBatdau())).append("\",")
                    .append("\"post_gioketthuc\":\"").append(escapeJson(p.getGioketthuc())).append("\",")
                    .append("\"post_ketthuc\":\"").append(escapeJson(p.getKetthuc())).append("\",")
                    .append("\"post_diadiem\":\"").append(escapeJson(p.getDiadiem())).append("\",")
                    .append("\"post_noidung\":\"").append(escapeJson(p.getNoidung())).append("\",")
                    .append("\"post_hinhanhminhhoa\":\"").append(escapeJson(imgUrl)).append("\"")
                    .append("}");

                if (i < list.size() - 1) {
                    json.append(",");
                }
            }
        }

                
        json.append("]}");
        
        out.print(json.toString());
        out.flush();
    }

    private String escapeJson(String str) {
        if (str == null) return "";
        return str.replace("\\", "\\\\")
                  .replace("\"", "\\\"")
                  .replace("\n", "\\n")
                  .replace("\r", "\\r")
                  .replace("\t", "\\t")
                  .replace("\b", "\\b")
                  .replace("\f", "\\f");
    }
}
