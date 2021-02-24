<%--
  Created by IntelliJ IDEA.
  User: Keen
  Date: 2021/1/5
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>json</title>
    <script type="text/javascript">
        var jsonObj = {
            "key1": 1,
            "key2": "abc",
            "key3": false,
            "key4": [11,"bcd",true],
            "key5": {
                "key5_1": 551,
                "key5_2": "key5_2_value"
            },
            "key6": [{
                    "key6_1": 6611,
                    "key6_2": "key6_2_value"
                 },{
                    "key6_1": 6612,
                    "key6_2": "key6_2_value"
            }],
        };
        // alert(jsonObj); //[object Object]
        // alert(jsonObj.key1); //1
        // alert(jsonObj.key2); //abc
        // alert(jsonObj.key3); //false
        // alert(jsonObj.key4); //11,bcd,true
        /*for (var i = 0; i < jsonObj.key4.length; i++) {
            alert(jsonObj.key4[i]);  //11    bcd     true
        }
        alert(jsonObj.key5.key5_1); // 551
        alert(jsonObj.key5.key5_2); // key5_2_value
        alert(jsonObj.key6[0].key6_1); //6611
        alert(jsonObj.key6[0].key6_2); //key6_2_value*/

    </script>
  </head>
  <body>
  $END$
  </body>
</html>
