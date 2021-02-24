<%@ page import="com.lzj.pojo.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="org.omg.PortableServer.POAPackage.ObjectAlreadyActive" %><%--
  Created by IntelliJ IDEA.
  User: Keen
  Date: 2020/11/26
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--EL表达式输出Bean--%>
<%
    Person person = new Person();
    person.setName("keen");
    person.setPhones(new String[]{"15788888888","15788887777","15777778888"});

    List<String> cities = new ArrayList<>();
    cities.add("北京");
    cities.add("上海");
    cities.add("广州");
    person.setCities(cities);

    Map<String, Object> map = new HashMap<>();
    map.put("key1","value1");
    map.put("key2","value2");
    map.put("key3","value3");
    person.setMap(map);

    request.setAttribute("person",person);
%>

${person} <br>
${person.name} <br>
${person.phones}<br>
${person.phones[1]}<br>
${person.cities}<br>
${person.cities[1]}<br>
${person.map}<br>
${person.map["key1"]} <br>
${person.map.key2} <br>
${person.age} <br>






</body>
</html>
