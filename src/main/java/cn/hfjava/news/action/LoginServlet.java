package cn.hfjava.news.action;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;


@WebServlet(urlPatterns = "/servlet/doLogin")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        String remember = request.getParameter("autoLogin"); // null   "true"


        if("admin".equals(userName) && "123456".equals(password))
        {
            String userInfo = URLEncoder.encode(userName,"UTF-8")
                    + "#" + password;
            System.out.println(userInfo);
            Cookie userCookie = new Cookie("userInfo",userInfo);
            //userCookie.setSecure(true);
            userCookie.setPath("/"); // / 表示网站根目录
            if(null != remember)
            {
                //24 * 3600 * 10  10天
                userCookie.setMaxAge(864000);
            }
            else
            {
                userCookie.setMaxAge(0);
            }
            response.addCookie(userCookie);

            //统计在线人数
            ServletContext application = this.getServletContext();
            Integer count = (Integer)application.getAttribute("count");
            if(count == null){
                count = new Integer(1);
            }
            else{
                count = new Integer(count.intValue() + 1);
            }
            application.setAttribute("count",count);

            //保存用户登录状态
            HttpSession session = request.getSession();
            //session.setMaxInactiveInterval(1800); //设置session会话最大非活动过期时间:30分钟
            session.setAttribute("user",userName);
            //重定向
            response.sendRedirect("/users/list");
        }
        else{
            request.setAttribute("errMsg","用户名或密码错误，请重新输入！");
            //转发
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
