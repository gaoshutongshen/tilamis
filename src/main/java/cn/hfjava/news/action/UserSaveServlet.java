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
import java.util.Date;

@WebServlet(urlPatterns = "/users/save")
public class UserSaveServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String userId = request.getParameter("userid");
        String userName = request.getParameter("userName");
        String oldPass = request.getParameter("oldpassword");
        String newPass = request.getParameter("password");
        String email = request.getParameter("email");

        User userBo =userService.findUserById(Integer.valueOf(userId));
        System.out.println("userBo-----》" + userBo.toString());
        if(!userBo.getPassword().equals(oldPass)){
            request.setAttribute("msg","原密码不正确！");
            request.getRequestDispatcher("/users/update?userid=" + userId).forward(request,response);
        }
        else {
            User user = new User();
            user.setUserId(Integer.valueOf(userId));
            user.setPassword(newPass);
            user.setUserName(userName);
            user.setModifyDate(new Date());
            user.setEmail(email);

            System.out.println("user----->" + user.toString());
            int result = userService.modifyUser(user);
            if(result > 0)
            {
                response.sendRedirect("/users/list");
            }
            else{
                request.setAttribute("msg","更新用户信息失败！");
                request.getRequestDispatcher("/users/update").forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
