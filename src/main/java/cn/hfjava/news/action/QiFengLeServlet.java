package cn.hfjava.news.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/QiFengLeServlet/QiFengLe")
public class QiFengLeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
String username=request.getParameter("userName");
String password=request.getParameter("password");
if ("admin".equals(username)&&"123456".equals(password)){
    response.sendRedirect("/userList");
}
else{
    request.getAttribute("保存用户失败");
    request.getRequestDispatcher("/QiFengLe.jsp").forward(request,response);
}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
