package cn.hfjava.news.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/servlet/r3"})
public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
         //获得表单数据
        String realName = request.getParameter("realName");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String[] interests = request.getParameterValues("interests");
        String edu = request.getParameter("edu");
        String intro = request.getParameter("intro");

        //Student student = new Student();
        //表单数据存储到request
        request.setAttribute("realName",realName);
        request.setAttribute("age",age);
        request.setAttribute("gender",gender);
        request.setAttribute("interests",interests);
        request.setAttribute("edu",edu);
        request.setAttribute("intro",intro);
        //转发
        request.getRequestDispatcher("/showInfo.jsp").forward(request,response);

    }
}
