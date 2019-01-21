package cn.hfjava.news.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
// http://localhost:8080/servlet/hello
@WebServlet(urlPatterns="/servlet/hello")  //url访问地址 可以自定义
public class HelloServlet extends HttpServlet {

    //请求方式   method=GET POST DELETE PUT ...

    //get请求
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        //response.setCharacterEncoding("utf-8");
        /*
        *  .html    text/html
        *  .txt     text/plain
        *  .json    application/json
        *  .xml     application/xml
        *  .jpg     image/jpg image/jpeg
        *  .png     image/png
        *
        * */
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        PrintWriter out = response.getWriter();
        out.print("username--->" + username);

        out.flush();
        out.close();
    }

    //post请求

   /* @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }*/
}
