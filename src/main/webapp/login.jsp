<%@ page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%
    //上下文路径
    String contextPath = request.getContextPath(); //   /
    request.setAttribute("basePath",contextPath);
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <head>
        <title>用户登录</title>
    </head>
<body>


    <%
        String userName = "";
        String password = "";
       Cookie[] cookies = request.getCookies();
       if(cookies != null){
           for (Cookie cookie : cookies) {
               if(cookie.getName().equals("userInfo")){
                   String values = cookie.getValue();//admin#123456
                   String[] userInfo = values.split("#");
                   userName = java.net.URLDecoder.decode(userInfo[0],"utf-8");
                   password = userInfo[1];
               }
           }
       }
    %>
    <form method="post" action="${basePath}/servlet/doLogin">
        <div>用户名：<input type="text" name="userName" value="<%= userName %>" autocomplete="off" autofocus required placeholder="请输入用户名"></div>
        <div>密码：<input type="password" name="password" value="<%= password %>" placeholder="请输入密码" required> </div>
        <label title="为了确保您的信息安全，请不要在网吧或者公共机房勾选此项！" for="autoLogin">
            <input type="checkbox" name="autoLogin" id="autoLogin" value="true" checked>十天内免登录
        </label>
        <div>${ errMsg }</div>
        <div><input type="submit" value="登录"></div>
    </form>
</body>
</html>
