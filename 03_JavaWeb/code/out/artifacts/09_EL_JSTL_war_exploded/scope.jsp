<%--
  Created by IntelliJ IDEA.
  User: Keen
  Date: 2020/11/26
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center">EL 表达式的 11 个隐含对象</h1>
<h2 align="center">EL 获取四个特定域中的属性</h2>

<%
    pageContext.setAttribute("key2","pageContext");
    request.setAttribute("key2","request");
    session.setAttribute("key2","session");
    application.setAttribute("key2","application");
%>
<%--遵循最小域的原则--%>
${key2} <br>
<%= request.getAttribute("key2") %>  <br>
${requestScope.key2} <br>

</body>
</html>
