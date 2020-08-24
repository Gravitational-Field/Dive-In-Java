<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>博客系统 - 会员注册</title>
</head>
<body>

   会员注册
   <hr>
<form action="${pageContext.request.contextPath}/member/register" method="post">
    <input type="text" name="mobile"><br>
    <input type="text" name="password"><br>
    <button>注册</button>
</form>

</body>
</html>
