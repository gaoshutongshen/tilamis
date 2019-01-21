package cn.hfjava.news.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(urlPatterns = {"/user/*"})
public class AccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String action = request.getParameter("action");
        System.out.println("action======>" + action);
        if(action != null && "login".equals(action)) {

            if (username.equals("admin") && password.equals("123456")) {
                request.getSession().setAttribute("username", username);
                response.sendRedirect("/home.jsp");
            } else {
                request.setAttribute("msg", "用户名或密码错误！");
                request.getRequestDispatcher("/home.jsp").forward(request, response);
            }
        }
        else if(action != null && "logout".equals(action)){
            request.getSession().invalidate();
            response.sendRedirect("/home.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
