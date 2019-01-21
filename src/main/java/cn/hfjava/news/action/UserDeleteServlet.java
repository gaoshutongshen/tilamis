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

@WebServlet(urlPatterns = "/users/delete")
public class UserDeleteServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String userid= request.getParameter("userid");
        User user = new User();
        user.setUserId(Integer.valueOf(userid));
        int result = userService.deleteUser(user);
        if (result > 0)
        {
            response.sendRedirect("/users/list");
        }
        else
        {
            request.setAttribute("msg","删除用户信息失败！");
            request.getRequestDispatcher("/users/list").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
