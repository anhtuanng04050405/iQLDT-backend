package Controller;

import BEAN.Post;
import DAO.PostDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AdminPostServlet")
public class AdminPostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        
        String action = request.getParameter("action");
        PostDAO dao = new PostDAO();
        
        if ("add".equals(action)) {
            Post p = new Post();
            p.setTieude(request.getParameter("tieude"));
            p.setBatdau(request.getParameter("batdau"));
            p.setKetthuc(request.getParameter("ketthuc"));
            p.setDiadiem(request.getParameter("diadiem"));
            p.setNoidung(request.getParameter("noidung"));
            p.setImgURL(request.getParameter("imgURL"));
            
            dao.addPost(p);
        } 
        else if ("update".equals(action)) {
            Post p = new Post();
            p.setId(Integer.parseInt(request.getParameter("id")));
            p.setTieude(request.getParameter("tieude"));
            p.setBatdau(request.getParameter("batdau"));
            p.setKetthuc(request.getParameter("ketthuc"));
            p.setDiadiem(request.getParameter("diadiem"));
            p.setNoidung(request.getParameter("noidung"));
            p.setImgURL(request.getParameter("imgURL"));
            
            dao.updatePost(p);
        } 
        else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.deletePost(id);
        }

        // Navigation to Forward Controller
        response.sendRedirect(request.getContextPath() + "/UpdateForwardController");
    }
}