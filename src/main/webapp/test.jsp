<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/11/011
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String userName =request.getParameter("username");
    if (userName.equals("admin")){
        request.setAttribute("mess","注册失败, 请跟换其他用户名");
        request.getRequestDispatcher("userCreate.ksp").forward(request,response);
    }
%>
</body>
</html>
