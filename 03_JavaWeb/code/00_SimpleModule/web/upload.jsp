<%--
  Created by IntelliJ IDEA.
  User: Keen
  Date: 2020/11/30
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="/00_SimpleModule/uploadServletJar" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="username"> <br>
    头像：<input type="file" name="photo"> <br>
    <input type="submit" value="上传头像">

</form>
</body>
</html>
