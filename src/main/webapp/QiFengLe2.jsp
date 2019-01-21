<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/21/021
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我是重定向2页面</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String username= request.getParameter("username");
    String password= request.getParameter("password");
    String email= request.getParameter("email");
%>
<div>
    <h1>显示信息</h1>
    <div>用户名:<%=username%> </div>
    <div>密码:<%=password%> </div>
    <div>邮箱:<%=email%> </div>



</div>
</body>
</html>
