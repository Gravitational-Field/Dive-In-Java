# FAQ：

# 已解决

# 1. 响应状态描述符：

- 是什么？

- 有哪些？
  - 200
  - 301   [302与302的区别](https://www.cnblogs.com/lanqiu5ge/p/9457074.html)
  - 302
  - 404
  - 500

# 2. 请求的转发与重定向

## 1）请求的转发

> 请求转发是指，服务器收到请求后，从一个资源跳到另一个资源的操作。
>
> **个人理解：**客服端发出一次请求，面对要完成的任务，服务器端需要协同多个servlet来完成这一件事，再将结果响应到客户端。

- 代码实例

```java
//在doGet或doPost方法中直接使用      其中/ 代表  http://ip:port/工程名/   映射到项目代码中是web目录
request.getRequestDispatcher("/servlet2").forward(request,reqponse);

request.getRequestDispatcher("/b.jsp").forward(request,reqponse);
```



![image-20201125222223378](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201125222223.png)



## 2）请求的重定向

> 请求的重定向是指：
>
> ​	客户端发来请求，服务器告知客户端，让其访问另一个给定的地址去访问。客户端于是重新发起新的请求，舍弃了先前的请求。重新确定了自己的访问方向，故称重定向。

- 代码实例

- 第一种方式

  ```java
  // 设置响应状态码 302 ，表示重定向，（已搬迁） 
  resp.setStatus(302); // 设置响应头，说明 新的地址在哪里 
  resp.setHeader("Location", "http://localhost:8080");   //http://localhost:8080/工程名/新请求
  ```

- 第二种方式

  ```java
  resp.sendRedirect("http://localhost:8080");
  ```

![image-20201125223238793](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201125223238.png)

==base标签解决path问题==

PS: 请求转发的/映射到工程名，重定向额/映射到端口号，因为resp发送到浏览器后，再解析那个/，导致解析不到工程路径，故还需增加工程名。

# 3. doGet和doPost中中文格式乱码问题

## 3.1 服务器端乱码

> 乱码来源：客户端传来的中文数据，在服务器中打印时出现问题。

- doGet中可以通过将获取的参数先进行iso8895-1编码为字节数组，再通过utf-8将字节数组构建为字符串。（这种方法是需要耗费太多的精力） 

  > 代码参见：http://localhost:8080/07_Servlet/a.html
  >
  > JavaWeb\JavaWeb\07_Servlet\src\com\lzj\servlet\ParameterServlet.java
  >
  > [关于get方式提交中文乱码问题的解决方式_IT菜鸟的后花园-CSDN博客_get请求中文乱码](https://blog.csdn.net/u012564085/article/details/80003283)

- doPost中可以修改请求体的字符集编码为utf-8，来解决post请求中的中文乱码问题。

![image-20201126223149138](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201126223149.png)

## 3.2 客户端乱码

![image-20201126223302121](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201126223302.png)

# 4. 路径问题



html的base标签

> JavaWeb\JavaWeb\07_Servlet\src\com\lzj\servlet\ForwardC.java
>
> JavaWeb\JavaWeb\07_Servlet\web\a\b\c.html

jsp中的base标签，设定之后

- 动态base标签

```jsp
<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";
%>
<%=basePath%>

<!--写base标签，永远固定相对路径跳转的结果-->
<base href="<%=basePath%>">
```

- jsp页面中的使用方式

```jsp
1. 直接web目录下的   使用
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
<a href='index.jsp'>转到首页</a>     <%-- 注意此处不能加/，base标签中已经加/了 -%>
jsp页面中均已经映射到达web目录内，故base标签之后的路径，若是相对于base的，则不需要再添加/。

form表单中action直接进行提交就好，初始也不需加/
```









## 5. 导入项目

## 5.1 导入一个web项目，部署到tomcat上

打开或导入一个项目的父目录 => 添加一个tomcat server，创建configuration =》 fix

在project construct中，facets中，添加一个web，fix后，则在Artifacts中有相应的Web explode， 再将一些lib fix或者add到模块中。即可以运行了。

![image-20201202163825076](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201202163825.png)

![image-20201202164127014](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201202164127.png)

## 5.2 导入Spring Boot项目，maven部署





---

# 未解决

- Servlet的生命周期

- Servlet默认请求

- 响应状态描述符

- URL与URI的区别

- 请求转发与请求重定向的区别

- 请求转发可能导致的问题   （路径参考问题）   使用**base**标签解决

- web中的/ 与服务器中的/ 区分；以及路径问题

- ~~中文乱码问题，doGet中的乱码、doPost中的乱码、  相应乱码问题~~ 

- request的一些方法辨析   contextPath   servletPath

- cookie 和session区别

- ServletContext与HttpServlet关系

- RESTful API规范

- get请求和post请求的区别

  







