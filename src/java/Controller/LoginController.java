package Controller;

import DAO.LoginDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Forward to login.jsp
        request.getRequestDispatcher("/WEB-INF/View/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        boolean isValid = LoginDAO.checkLogin(username, password);
        
        if (isValid) {
            // Successful login
            HttpSession session = request.getSession();
            session.setAttribute("adminUser", username);
            response.sendRedirect(request.getContextPath() + "/UpdateForwardController");
        }
        
        else {
            // Login Failed
            request.setAttribute("msg", "Tài khoản hoặc mật khẩu không chính xác!");
            request.getRequestDispatcher("/WEB-INF/View/login.jsp").forward(request, response);
        }
        
    }
}