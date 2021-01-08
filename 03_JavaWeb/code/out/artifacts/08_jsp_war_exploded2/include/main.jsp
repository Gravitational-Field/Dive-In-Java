<%--
  Created by IntelliJ IDEA.
  User: Keen
  Date: 2020/11/25
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main.jsp</title>
</head>
<body>
    头部信息 <br>
    主体信息 <br>
<%--  静态包含  --%>
<%--    <%@include file="/include/footer.jsp"%>--%>
<%--动态包含--%>
<jsp:include page="/include/footer.jsp">
    <jsp:param name="username" value="keen"/>
    <jsp:param name="password" value="123456"/>
</jsp:include>

<jsp:forward page="/b.jsp" />

</body>
</html>
