<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <head>
        <title>学员注册信息</title>
    </head>
<body>
    <div>
        <form action="show.jsp" method="post">
            <h1>请输入注册信息</h1>
            <div>用户名：<input type="text" name="username"></div>
            <div>密码：<input type="password" name="password"></div>
            <div>信息来源：
                <input type="checkbox" name="source" value="报刊">报刊
                <input type="checkbox" name="source" value="网络">网络
                <input type="checkbox" name="source" value="朋友推荐">朋友推荐
                <input type="checkbox" name="source" value="电视">电视
                <input type="checkbox" name="source" value="自媒体">自媒体
            </div>
            <div>
                <input type="submit" value="提交">
            </div>
        </form>
    </div>
</body>
</html>
