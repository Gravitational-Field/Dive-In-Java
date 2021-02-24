<%@ page import="java.util.Map" %>
<%@ page import="sun.security.mscapi.CPublicKey" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Keen
  Date: 2020/11/21
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>b.jsp</title>
</head>
<body>
<%--声明式脚本--%>
<%!
    private Integer id;
    private String name;
    private static Map<String, Object> map;
%>
<%!
    static{
        map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
    }
%>
<%!
    public int fun() {
        return 11;
    }
%>
<%!
    public class Student {
        private Integer id;
        private String name;
    }
%>
<%--表达式脚本: 向页面输出--%>
<%=1%> <br/>
<%=1.321%> <br/>
<%="hahaha"%> <br/>
<%=map%> <br/>
<%-- //http://localhost:8080/08_jsp/b.jsp?username=keen--%>
<%=request.getParameter("username")  %> <br/>
<%=fun()%> <br/>

</body>
</html>
