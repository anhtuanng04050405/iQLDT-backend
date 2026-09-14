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
        
        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        List<Post> list = PostDAO.getAllPosts();
        
        StringBuilder json = new StringBuilder();
        json.append("{\"status\":\"success\",\"data\":[");
        
        for (int i = 0; i < list.size(); i++) {
            Post p = list.get(i);
            json.append("{")
                .append("\"post_tieude\":\"").append(escapeJson(p.getTieude())).append("\",")
                .append("\"post_batdau\":\"").append(escapeJson(p.getBatdau())).append("\",")
                .append("\"post_ketthuc\":\"").append(escapeJson(p.getKetthuc())).append("\",")
                .append("\"post_diadiem\":\"").append(escapeJson(p.getDiadiem())).append("\",")
                .append("\"post_noidung\":\"").append(escapeJson(p.getNoidung())).append("\",")
                .append("\"post_hinhanhminhhoa\":\"").append(escapeJson(p.getImgURL())).append("\"")
                .append("}");
            if (i < list.size() - 1) json.append(",");
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
                  .replace("\r", "\\r");
    }
}