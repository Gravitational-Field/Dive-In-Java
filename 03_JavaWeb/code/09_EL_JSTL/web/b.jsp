<%--
  Created by IntelliJ IDEA.
  User: Keen
  Date: 2020/11/26
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%----%>
<%--EL表达式搜索 域数据的顺序--%>
<%
    pageContext.setAttribute("key","pageContext");
    request.setAttribute("key","request");
    session.setAttribute("key","session");
    application.setAttribute("key","application");
%>
获取域对象的数据：${key}

</body>
</html>
