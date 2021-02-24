<%--
  Created by IntelliJ IDEA.
  User: Keen
  Date: 2020/11/25
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>九九乘法表</title>
</head>
<body>

<h1 align="center">九九乘法表</h1>
<%
    for (int i = 1; i <= 9; i++) {
        for (int j = 1; j <= i; j++) {
            System.out.print(j +"*"+ i +"="+ i*j +"\t");
        }
        System.out.println();
    }
%>
<%--输出到页面上--%>
<table border="1px" align="center" width="650px">
<% for (int i = 1; i <= 9; i++) { %>
    <tr>
<%    for (int j = 1; j <= i; j++) { %>
           <td><%=j +"*"+ i +"="+ i*j +"\t"%></td>
<%    } %>
    </tr>
<%
    }
%>
</table>


</body>
</html>
