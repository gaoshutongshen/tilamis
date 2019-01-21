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
    <form action="${pageContext.request.contextPath}/servlet/r3" method="post">
        <table border="1">
            <tr>
                <th>姓名：</th>
                <td><input type="text" name="realName"></td>
            </tr>
            <tr>
                <th>年龄：</th>
                <td><input type="text" name="age"></td>
            </tr>
            <tr>
                <th>性别：</th>
                <td>
                    <input type="radio" name="gender" value="男" checked>男
                    <input type="radio" name="gender" value="女">女
                </td>
            </tr>
            <tr>
                <th>爱好：</th>
                <td>
                    <input type="checkbox" name="interests" value="旅游">旅游
                    <input type="checkbox" name="interests" value="运动">运动
                    <input type="checkbox" name="interests" value="阅读">阅读
                    <input type="checkbox" name="interests" value="网游">网游
                    <input type="checkbox" name="interests" value="游泳">游泳
                    <input type="checkbox" name="interests" value="编程">编程
                </td>
            </tr>
            <tr>
                <th>学历：</th>
                <td>
                    <select name="edu">
                        <option value="高中">高中</option>
                        <option value="大专">大专</option>
                        <option value="本科">本科</option>
                        <option value="硕士">硕士</option>
                        <option value="博士及以上">博士及以上</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>自我介绍：</th>
                <td>
                    <textarea name="intro" cols="30" rows="10">我特别喜欢Java技术</textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="提交"></td>
            </tr>
        </table>

    </form>

</body>
</html>
