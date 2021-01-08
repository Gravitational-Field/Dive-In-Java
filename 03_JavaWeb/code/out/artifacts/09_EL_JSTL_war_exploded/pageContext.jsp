<%--
  Created by IntelliJ IDEA.
  User: Keen
  Date: 2020/11/26
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--pageContext 对象的使用 --%>
<%--1. 协议： --%>
<%--2. 服务器 ip： --%>
<%--3. 服务器端口： --%>
<%--4. 获取工程路径： --%>
<%--5. 获取请求方法： --%>
<%--6. 获取客户端 ip 地址： --%>
<%--7. 获取会话的 id 编号：--%>
<%=request.getScheme()%>   <br>
<%=request.getServerName()%>   <br>
<%=request.getServerPort()%>   <br>
<%=request.getContextPath()%>   <br>
<%=request.getMethod()%> <br>
<%=request.getRemoteHost()%> <br>
<%=session.getId()%> <br>

<%
    pageContext.setAttribute("req",request);
%>

1. 协议: ${pageContext.request.scheme} <br>    <!-- 1. 协议: http -->
1. 协议: ${req.scheme} <br>    <!-- 1. 协议: http -->
2. 服务器 ip: ${pageContext.request.serverName} <br>  <!-- 2. 服务器 ip: localhost -->
3. 服务器端口: ${pageContext.request.serverPort} <br>  <!-- 3. 服务器端口: 8080 -->
4. 获取工程路径：${pageContext.request.contextPath} <br> <!-- 4. 获取工程路径：/09_EL_JSTL -->
5. 获取请求方法：${pageContext.request.method} <br>  <!-- 5. 获取请求方法：GET -->
6. 获取客户端 ip 地址：${pageContext.request.remoteHost} <br>  <!-- 6. 获取客户端 ip 地址：127.0.0.1 -->
7. 获取会话的 id 编号 ${pageContext.session.id} <br>  <!-- 7. 获取会话的 id 编号 08B952431A4B27E9A7517879983DF9CB -->


</body>
</html>
