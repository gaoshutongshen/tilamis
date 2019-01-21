<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%
    Object userObject = session.getAttribute("user");
    if(userObject == null){
        response.sendRedirect("/login.jsp");
        return;
    }
%>