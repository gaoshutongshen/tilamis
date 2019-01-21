<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/21/021
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>重定向页面测试</title>
</head>
<body>
<form action="QiFengLe2.jsp" method="post">
    <h1>请输入注册信息</h1>
    <div>用户名:<input type="text" name="username"> </div>
    <div>密码:<input type="text" name="password"> </div>
    <div>确认密码:<input type="text" name="os_password"></div>
    <div>邮箱:<input type="email" name="email"></div>
    <div><input type="submit" value="提交"> </div>
</form>
</body>
</html>
