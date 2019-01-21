package cn.hfjava.news.action;

import cn.hfjava.news.common.ExcelUtils;
import cn.hfjava.news.pojo.User;
import cn.hfjava.news.service.UserService;
import cn.hfjava.news.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users/export")
public class ExportExcelServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userService.findAllUser();
        //导出操作
        ExcelUtils.exportExcel(userList,"用户信息列表","Sheet1",User.class,"UserInfos.xls",response);
    }
}
