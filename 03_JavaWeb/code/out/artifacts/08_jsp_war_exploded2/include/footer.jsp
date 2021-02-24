<%--
  Created by IntelliJ IDEA.
  User: Keen
  Date: 2020/11/25
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>footer.jsp</title>
</head>
<body>
脚页信息 <br>
<%= request.getParameter("username")%>
<%= request.getParameter("password")%>
<%= request.getRequestDispatcher("/a.jsp").forward(request,response)%>
</body>
</html>
