<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/23
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        out.write(12); //会有格式错误
        System.out.println("他出现了");
        out.print(12); //转换成字符串后才进行输出
    %>
</body>
</html>
