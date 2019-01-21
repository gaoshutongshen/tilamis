<%@ page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <head>
        <title>用户信息修改</title>
    </head>
<body>
    <form action="${pageContext.request.contextPath}/users/save" method="post">
        <div><input type="hidden" name="userid" value="${param.userid}"></div>
        <div>用户名：<input type="text" name="userName" value="${user.userName}"></div>
        <div>原密码：<input type="password" name="oldpassword"></div>
        <div>新密码：<input type="password" name="password" ></div>
        <div>确认密码：<input type="password" name=""></div>
        <div>电子邮箱:<input type="email" name="email" value="${user.email}"></div>
        <div>${msg}</div>
        <div>
            <input type="submit" value="保存">
        </div>
    </form>
</body>
</html>
