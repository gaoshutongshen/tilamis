package cn.hfjava.news.action;

import cn.hfjava.news.pojo.User;
import cn.hfjava.news.service.UserService;
import cn.hfjava.news.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/detail")
public class UserViewServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String userId = request.getParameter("userid");
        User user = userService.getUserDetail(Integer.valueOf(userId));
        request.setAttribute("user",user);
        request.getRequestDispatcher("/userDetail.jsp").forward(request,response);
    }
}
