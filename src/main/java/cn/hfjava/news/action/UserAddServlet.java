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

@WebServlet(urlPatterns = "/users/add")
public class UserAddServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User userObject = new User();
        userObject.setUserName(userName);
        userObject.setPassword(password);
        userObject.setEmail(email);

        boolean result = userService.addNewUser(userObject);
        if(result){

            //Tomcat容器相对于Web应用本身加参数建立完整的URL    /users/list绝对路径
            //   /users/list  --> http://localhost:8080/users/list


            //Tomcat容器相对于原来请求URL的目录加参数来生成完整的URL   users/list 相对路径
            //   users/list  -->  http://localhost:8080/users/users/list  ERROR
            response.sendRedirect("/users/list");
        }
        else
        {
            request.setAttribute("msg","保存用户失败!");
            request.getRequestDispatcher("/userAdd.jsp").forward(request,response);
        }
    }
}
