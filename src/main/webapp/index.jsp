<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<body>
<form action="/upload/method3" method="post">
    用户名：<input type="text" name="username"><br>
    密码：<input type="text" name="password"><br>
    生日：<input type="text" name="birthday">
    <input type="submit">
</form>

<form action="/upload/method2" method="post" enctype="multipart/form-data">
        用户名：<input type="text" name="username"><br>
        上传文件：<input type="file" name="userIcon"><br>
        <input type="submit">
    </form>

<form action="/upload/method4" method="post">
    用户明：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit">
</form>
</body>
</html>
