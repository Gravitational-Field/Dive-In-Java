<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lzj.pojo.Student" %>
<%@ page import="java.lang.reflect.Array" %><%--
  Created by IntelliJ IDEA.
  User: Keen
  Date: 2020/11/25
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生页面</title>
    <style type="text/css">
        table{
            border: 1px black solid;
            width: 600px;
            align-content: center;
            border-collapse: collapse;
        }

        td,th{
            align-content: center;
            border: 1px black solid;
        }

    </style>
</head>
<body>
<%--  创造学生  --%>
<%
    ArrayList<Student> studentList = (ArrayList<Student>) request.getAttribute("stuList");
    System.out.println(studentList);
%>
<table>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>age</td>
        <td>phone</td>
        <td>操作</td>
    </tr>
    <% for (Student student:studentList) { %>
    <tr>
        <td><%=student.getId()%></td>
        <td><%=student.getName()%></td>
        <td><%=student.getAge()%></td>
        <td><%=student.getPhone()%></td>
        <td><a href="">删除</a> &nbsp; <a href="">修改</a></td>
    </tr>
    <% }%>
</table>



</body>
</html>
