<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <head>
        <title></title>
    </head>
<body>
    <%
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] sources = request.getParameterValues("source");
        String str = "";
        for (String item : sources) {
            str += item +" ";
        }
    %>
    <div>
        <h1>你输入的学员注册信息</h1>
        <div>用户名：<%= username %></div>
        <div>密码：<%= password %></div>
        <div>信息来源：<%= str %></div>
        <div>返回发送请求的客户端IP地址:<%=request.getRemoteAddr()%></div>
        <div>返回虚拟路径的真实路径:<%=request.getRealPath("/")%></div>
        <div>返回上下文路径:<%=request.getContextPath()%></div>
    </div>
</body>
</html>
