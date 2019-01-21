<%@ page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <head>
        <title>添加用户</title>
    </head>
<body>
    <form action="${pageContext.request.contextPath}/users/add" method="post">
        <div>用户名：<input type="text" name="userName"></div>
        <div>密码：<input type="password" name="password"></div>
        <div>确认密码：<input type="password" name="repassword"></div>
        <div>电子邮箱：<input type="text" name="email"></div>
        <div><input type="submit" value="保存"></div>
    </form>
</body>
</html>
