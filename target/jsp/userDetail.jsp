<%@ page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <head>
        <title></title>
    </head>
<body>
    <table border="1">
        <tr>
            <th>编号</th>
            <td>${user.userId}</td>
            <th>电子邮箱</th>
            <td>${user.email}</td>
        </tr>
        <tr>
            <th>登录名</th>
            <td>${user.userName}</td>
            <th>创建时间</th>
            <td>${user.createDate}</td>
        </tr>
        <tr>
            <th>密码</th>
            <td>${user.password}</td>
            <th>更新时间</th>
            <td>${user.modifyDate}</td>
        </tr>
    </table>
    <div> <a href="javascript:history.back()">返回</a></div>
</body>
</html>
