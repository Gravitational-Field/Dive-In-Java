<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Keen
  Date: 2020/11/26
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- “.”点运算 和 [] 中括号运算符  --%>
<%
    HashMap<String, String> map = new HashMap<>();
    map.put("a.a.a","aaaValue");
    map.put("b-b-b","bbbValue");
    map.put("c+c+c","cccValue");
    map.put("ddd","dddValue");
    request.setAttribute("map",map);

%>

${ map.ddd  } <br>
${ map.a.a.a } <br>
${ map["a.a.a"] } <br>
${ map["b-b-b"]  } <br>
${ map["c+c+c"]  } <br>


</body>
</html>
