<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Keen
  Date: 2020/11/26
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--EL表达式--%>
<%--1. 关系运算--%>
${12 > 12}  and ${12 gt 12} <br>
${12 >= 12} and ${12 ge 12} <br>
${12 == 12} and ${12 eq 12} <br>
${12 != 12} and ${12 ne 12} <br>
${12 < 12}  and ${12 lt 12} <br>
${12 <= 12} and ${12 le 12} <br>

<%--2. 逻辑运算--%>
<%--与 或 非--%>
<hr>
${11 == 11 && 12 == 12} and  ${11 == 11 and 12 == 12} <br>
${11 != 11 || 12 != 12} and  ${11 != 11 or 12 != 12}  <br>
${ !true }   and  ${ not true }


<%--3. 算数运算--%>
<%--加减乘除取余--%>
<hr>
${ 12+12 }  <br>
${ 12-12 }  <br>
${ 12*12 }  <br>
${ 12/12 } and ${ 12 div 12 }  <br>
${ 15%12 } and ${ 15 mod 12 }  <br>

<%--empty判空运算--%>
<hr>
<%
//1、值为 null 值的时候，为空
    request.setAttribute("emptyNull",null);
//2、值为空串的时候，为空
    request.setAttribute("emptyStr","");
//3、值是 Object 类型数组，长度为零的时候
    request.setAttribute("emptyArr",new Object[]{});
//4、list 集合，元素个数为零
    request.setAttribute("emptyList", new ArrayList<>());
//5、map 集合，元素个数为零
    request.setAttribute("emptyMap", new HashMap<>());

%>

${empty emptyNull} <br>
${empty emptyStr} <br>
${empty emptyArr} <br>
${empty emptyList} <br>
${empty emptyMap} <br>

<%--三元运算符--%>
<hr>
${ 12>13?"12>13":"12<=13" }

</body>
</html>
