<%@ page language="java" isELIgnored="false" pageEncoding="UTF-8" %>

<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>

<%
    String contextPath = request.getContextPath();
    request.setAttribute("basePath",contextPath);
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <head>
        <title></title>
    </head>
<body>


    <div>欢迎 ${ user } 当前在线人数为：${count}位  <a href="${basePath}/servlet/Logout" onclick="return confirm('确认要退出系统吗？');">退出</a> </div>

    <%@ include file="common.jsp"%>


        <%
            int timeout = session.getMaxInactiveInterval();
            String sessionId = session.getId();




            out.print("<h1>timeout:" + timeout + "</h1>");
            out.print("<h1>sessionId:" + sessionId + "</h1>");
        %>
    <%!
         public String format(Date date){
             String pattern = "yyyy-MM-dd HH:mm:ss";
             SimpleDateFormat sdf = new SimpleDateFormat(pattern);
             return sdf.format(date);
         }

        // 判断是不是素数的方法
        public boolean isPrime(int i) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0)  return false;
            }
            return true;
        }

        public boolean isLeapYear(int year){
             if((year % 4 ==0 && year % 100 !=0)
                     || (year % 400 == 0)){
                 return true;
             }
             return false;
        }
    %>


    <!-- 小脚本  -->
    <%
        int sum = 0,count = 0;
        for(int i=2;i <=100;i++){
            if(isPrime(i) == true){
                sum += i;
            }
        }

        for(int year =2000;year <=2018;year++){
            if(isLeapYear(year) == true){
                count++;
            }
        }
    %>
    <h1>当前时间：<%= format(new Date()) %></h1>
    <h1>1~100之间的所有质数的和为<%= sum %></h1>
    <h1>从2000年~2018年期间，共有<%= count %>个闰年</h1>



</body>
</html>
