<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <head>
        <title></title>
        <style>
            .errorCls {color:#f00;}
        </style>
    </head>
<body>
    <%@include file="common.jsp"%>



    <h1>用户列表页面</h1>
    <form action="${pageContext.request.contextPath}/users/deleteAll" method="post">
    <a href="javascript:;" id="delAll">批量删除</a> <a href="/userAdd.jsp">添加</a> <a href="/users/export" target="_blank">导出到Excel(easypoi)</a>
    <table border="1">
        <tr>
            <th><input type="checkbox" id="checkAll"></th>
            <th>编号</th>
            <th>用户名</th>
            <th>密码</th>
            <th>邮箱</th>
            <th>创建时间</th>
            <th>修改时间</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${users}" var="user">
            <tr>
                <td><input type="checkbox" name="ids" value="${user.userId}"></td>
                <td>${user.userId}</td>
                <td>${user.userName}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
                <td>${user.createDate}</td>
                <td>${user.modifyDate}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/users/detail?userid=${user.userId}">查看</a>
                    <a href="${pageContext.request.contextPath}/users/update?userid=${user.userId}">修改</a>
                    <a href="${pageContext.request.contextPath}/users/delete?userid=${user.userId}" onclick="return window.confirm('确认要删除吗？');">删除</a>
                </td>

            </tr>
        </c:forEach>
        <tfoot>
            <tr>
                <td colspan="8" align="center">
                    当前第1页 共10页  总共100条记录 <a href="#">首页</a> <a href="#">上一页</a> <a href="#">下一页</a> <a href="#">尾页</a>
                </td>
            </tr>
        </tfoot>
    </table>

    </form>
    <div class="errorCls">${msg}</div>
    <script src="/js/jquery.min.js"></script>

    <script>
        $(function () {
            $('#delAll').click(function () {

                $('form').submit(); //通过a超链接提交表单
            });
        });
    </script>
</body>
</html>
