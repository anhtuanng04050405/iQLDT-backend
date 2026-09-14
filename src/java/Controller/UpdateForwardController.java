package Controller;

import BEAN.Post;
import DAO.PostDAO;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UpdateForwardController")
public class UpdateForwardController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        
        HttpSession session = request.getSession();
        if (session.getAttribute("adminUser") == null) {
            response.sendRedirect(request.getContextPath() + "/LoginController");
            return;
        }
        
        request.setCharacterEncoding("UTF-8");
        
        // 1. Take all the post and send them to JSP.
        List<Post> list = PostDAO.getAllPosts();
        request.setAttribute("listPost", list);
        
        //2. When the user clicks the edit button
        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            for (Post p : list) {
                if (p.getId() == id) {
                    request.setAttribute("postEdit", p);
                    break;
                }
            }
        }
        
        //3. Forward to JSP
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/update.jsp");
        rd.forward(request, response);
    }
}