

# JavaWeb





# 6. Tomcat

##  6.1 JavaWeb 概念

> 1. 什么是JavaWeb？
>
> - JavaWeb是Java语言编写通过浏览器访问的程序的总称。
> - JavaWeb是基于请求和响应开发的。
>
> 2. 什么是请求？
>
> - 请求是指客户端给服务器发送数据，叫请求 Request。
>
> 3. 什么是响应？
>
> - 响应是指服务器给客户端回传数据，叫响应 Response。
>
> 4. 请求和响应的关系
>
> - 请求和响应是成对出现的，有请求就有响应。

![image-20201123193728902](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123193728.png)

## 6.2 **Web** 资源的分类

> 静态资源：html、css、js、txt、mp4 视频 , jpg 图片
>
> 动态资源：Servlet 程序、jsp 页面

## 6.3 常用的Web服务器

- **Tomcat：**由 Apache 组织提供的一种 Web 服务器，提供对 jsp 和 Servlet 的支持。它是一种轻量级的 javaWeb 容器（服务器），也是当前应用最广的 JavaWeb 服务器（免费）。 

- **Jboss：**是一个遵从 JavaEE 规范的、开放源代码的、纯 Java 的 EJB 服务器，它支持所有的 JavaEE 规范（免费）。 

- **GlassFish：** 由 Oracle 公司开发的一款 JavaWeb 服务器，是一款强健的商业服务器，达到产品级质量（应用很少）。 

- **Resin：**是 CAUCHO 公司的产品，是一个非常流行的服务器，对 servlet 和 JSP 提供了良好的支持，性能也比较优良，resin 自身采用 JAVA 语言开发（收费，应用比较多）。 

- **WebLogic：**是 Oracle 公司的产品，是目前应用最广泛的 Web 服务器，支持 JavaEE 规范，而且不断的完善以适应新的开发要求，适合大型项目（收费，用的不多，适合大公司）。

## 6.4 Tomcat服务器和Servlet版本的对应关系

![image-20201123195340428](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123195340.png)

- 当前企业常用的版本 7.、8.   
- Servlet 2.5 版本是现在世面使用最多的版本（xml 配置）， Servlet3.0 之后。就是注解版本的 Servlet 使用。
- 练习推荐使用 tomcat 8.0.50 ， Servlet程序使用2.5版本。

## 6.5 **Tomcat** 的使用

### 6.5.1 安装

​		找8.0.50版本，直接解压即可使用。

### 6.5.2 目录介绍

> **bin**  专门用来存放 Tomcat 服务器的可执行程序 
>
> **conf**  专门用来存放 Tocmat 服务器的配置文件 
>
> **lib**  专门用来存放 Tomcat 服务器的 jar 包 
>
> **logs**  专门用来存放 Tomcat 服务器运行时输出的日记信息 
>
> **temp**  专门用来存放 Tomcdat 运行时产生的临时数据 
>
> **webapps**  专门用来存放部署的 Web 工程。 
>
> **work**  是 Tomcat 工作时的目录，用来存放 Tomcat 运行时 jsp 翻译为 Servlet 的源码，和 Session 钝化的目录。

### 6.5.3 启动tomcat服务器

> 需要注意：需提前配置好**JAVA_HOME** 环境变量 （JAVA_HOME 配置的路径只需要配置到 jdk 的安装目录即可。不需要带上 bin 目录）

1. 找到 Tomcat 目录下的 bin 目录下的 startup.bat 文件，双击，就可以启动 Tomcat 服务器。

2. 打开浏览器，在浏览器地址栏中输入以下地址测试： 

   [http://localhost:8080](http://localhost:8080 )

   [http://127.0.0.1:8080 ](http://127.0.0.1:8080 )

   http://真实 ip:8080

### 6.5.4 tomcat停止

- 点击 tomcat 服务器窗口的 x 关闭按钮 
- 把 Tomcat 服务器窗口置为当前窗口，然后按快捷键 Ctrl+C 
- 找到Tomcat 的bin目录下的shutdown.bat双击，就可以停止Tomcat服务器

### 6.5.5 tomcat修改端口号

> Tomcat 默认的端口号是：8080
>
> Mysql 默认的端口号是：3306
>
> HTTP 协议默认的端口号是：80
>
> 平时上百度：[http://www.baidu.com:80](http://www.baidu.com:80)

找到 Tomcat 目录下的 conf 目录，找到 server.xml 配置文件。

![image-20201123202521639](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123202521.png)

### 6.5.6  部暑web工程到Tomcat中

- 第一种方式：把web工程的目录拷贝到Tomcat的webapps目录下即可

  1. 在 webapps 目录下创建一个 book 工程

  ![image-20201123203038058](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123203038.png)

  2. 做的书城第一阶段的内容拷贝到里面

  ![image-20201123203049389](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123203049.png)

  3. 访问 Tomcat 下的 web 工程

     只需要在浏览器中输入访问地址格式如下： http://ip:port/工程名/目录下/文件名  即可成功访问。

  

- 第二种方式

  ​	找到 Tomcat 下的 conf 目录\Catalina\localhost\ 下,创建如下的配置文件：

  ![image-20201123203239270](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123203239.png)

```xml
<!-- abc.xml 配置文件内容如下：
Context 表示一个工程上下文 
path 表示工程的访问路径:/abc 
docBase 表示你的工程目录在哪里 
访问这个工程的路径如下:http://ip:port/abc/ 就表示访问 E:\book 目录
--> 
<Context path="/abc" docBase="E:\book" />
```

### 6.5.7 文件访问index.html与http://ip:端 口号/工程名/访问的区别

- 文件直接访问

![image-20201123204603841](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123204603.png)

- 输入地址访问

![image-20201123204625938](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123204626.png)



### 6.5.8 访问的缺省情况

http://ip ====>>>>  没有端口号默认访问http协议默认端口 80

http://ip:port/ ====>>>>  没有工程名的时候，默认访问的是 ROOT 工程

http://ip:port/工程名/   ====>>>>   没有资源名，默认访问 index.html 页面

## 6.6 IDEA整合tomcat

1. 操作的菜单如下：File | Settings | Build, Execution, Deployment | Application Servers 

![image-20201123205338912](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123205339.png)

2. 配置你的 Tomcat 安装目录：

![image-20201123205405981](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123205406.png)

3. 可以通过创建一个 Model 查看是不是配置成功

<img src="https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123205432.png" alt="image-20201123205432609" style="zoom:80%;" />

## 6.7 IDEA 中动态 web 工程的操作

### 6.7.1 IDEA 中创建动态 web 工程

1. 创建一个新模块：

<img src="https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123205559.png" alt="image-20201123205559390" style="zoom:80%;" />

2. 选择你要创建什么类型的模块：

   <img src="https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123205641.png" alt="image-20201123205641302" style="zoom: 80%;" />

3. 输入模块名，完成创建。

<img src="https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123205821.png" alt="image-20201123205814137" style="zoom:80%;" />

4. 创建成功

<img src="https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123205913.png" alt="image-20201123205913418"  />

### 6.7.2 Web 工程的目录介绍

![image-20201123210017568](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123210017.png)

### 6.7.3 给动态 web 工程添加额外 jar 包

1. 将额外jar包添加到lib目录下
2. 打开项目结构菜单操作界面，添加一个自己的类库

![image-20201123210608696](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123210608.png)

3. 添加类库需要的 jar 包文件。

![image-20201123210659648](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123210659.png)

4. 选择添加的类库，给哪个模块使用

![image-20201123210736079](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123210736.png)

5. 选择 Artifacts 选项，将类库，添加到打包部署中：

![image-20201123210821147](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123210821.png)

### 6.7.4 在 IDEA 中部署工程到 Tomcat 上运行

1. 修改 web 工程对应的 Tomcat 运行实例名称

![image-20201123211008554](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123211008.png)

2. 确认 Tomcat 实例中有要部署运行的 web 工程模块

![image-20201123211124653](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123211124.png)

3. 修改 Tomcat 实例启动后默认的访问地址

   ![image-20201123211152067](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123211152.png)

4. 在 IDEA 中如何运行，和停止 Tomcat 实例。

- 修改工程访问路径

  ![image-20201123211305678](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123211305.png)

- 修改运行的端口号

![image-20201123211355387](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123211355.png)

- 修改运行使用的浏览器
- 配置资源热部署

![image-20201123211458931](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123211459.png)

![image-20201123211957579](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123211957.png) **通常这么进行设置。**

# 7. Servlet

## 7.1 Servlet技术

### 7.1.1 什么是 Servlet?

>1、Servlet 是 JavaEE 规范之一。规范就是接口
>
>2、Servlet 就 JavaWeb 三大组件之一。三大组件分别是：Servlet 程序、Filter 过滤器、Listener 监听器
>
>3、Servlet 是运行在服务器上的一个 java 程序，它可以接收客户端发送过来的请求，并响应数据给客户端。
>
>

### 7.1.2 手动实现 Servlet 程序（采用实现Servlet 接口的方式）

> 步骤：
>
> 1、编写一个类去实现 Servlet 接口 (实现一个接口，必须实现这个接口的所有方法，否则需将类定义为abstract)
>
> 2、实现 service 方法，处理请求，并响应数据 
>
> 3、到 web.xml 中去配置 servlet 程序的访问地址 

- 类的编写

```java
public class HelloServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        // 实现接口的不需要重写init方法
        System.out.println("HelloServlet init 初始化方法");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("HelloServlet被访问了！！！");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String method = httpServletRequest.getMethod();

        if ("Get".equals(method)) {
            doGet();
        } else {
            doPost();  //默认调用post请求
        }
    }

    public void doGet() {
        System.out.println("HelloServlet doGET请求");
    }

    public void doPost() {
        System.out.println("HelloServlet doPOST请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
```

- web.xml配置 (将)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
    
    <!-- servlet标签给Tomcat配置Servlet程序 -->
    <servlet>
        <!--servlet-name标签 Servlet程序起一个别名（一般是类名） -->
        <servlet-name>HelloServlet</servlet-name>
        <!--servlet-class是Servlet程序的全类名-->
        <servlet-class>com.atguigu.servlet.HelloServlet</servlet-class>
        <!--init-param是初始化参数-->
        <init-param>
            <!--是参数名-->
            <param-name>username</param-name>
            <!--是参数值-->
            <param-value>root</param-value>
        </init-param>
        <!--init-param是初始化参数-->
        <init-param>
            <!--是参数名-->
            <param-name>url</param-name>
            <!--是参数值-->
            <param-value>jdbc:mysql://localhost:3306/test</param-value>
        </init-param>
    </servlet>
    
    <!--servlet-mapping标签给servlet程序配置访问地址-->
    <servlet-mapping>
        <!--servlet-name标签的作用是告诉服务器，我当前配置的地址给哪个Servlet程序使用-->
        <servlet-name>HelloServlet</servlet-name>
        <!--
            url-pattern标签配置访问地址                                     
               / 斜杠在服务器解析的时候，表示地址为：http://ip:port/工程路径         
               /hello 表示地址为：http://ip:port/工程路径/hello             
        -->
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>
</web-app>
```

### 7.1.3 url 地址到 Servlet 程序的访问

![image-20201123215059690](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123215059.png)

### 7.1.4 Servlet 的生命周期

> [Servlet 生命周期 | 菜鸟教程 (runoob.com)](https://www.runoob.com/servlet/servlet-life-cycle.html)

```
1. 执行Servlet构造方法
2. 执行init初始化方法
第一、二步，是在第一次访问，的时候创建 Servlet 程序会调用。
3. 执行service方法
第三步，每次访问都会调用。
4. 执行 destroy 销毁方法
第四步，在 web 工程停止的时候调用。
```

### 7.1.5 GET 和 POST 请求的分发处理

> 详情请看 代码 06_Servlet | HelloServlet.java

- 上边案例已经展示。

### 7.1.6 通过继承 HttpServlet 实现 Servlet 程序 （常用）

一般在实际项目开发中，都是使用继承 HttpServlet 类的方式去实现 Servlet 程序。

1、编写一个类去继承 HttpServlet 类 

2、根据业务需要重写 doGet 或 doPost 方法 

3、到 web.xml 中的配置 Servlet 程序的访问地址

```java
public class HelloServlet2 extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("HelloServlet init 初始化方法");

        System.out.println("HelloServlet程序的别名为：" + config.getServletName());
        System.out.println("初始化参数 username 的值为：" + config.getInitParameter("username"));
        System.out.println("初始化参数 url 的值为：" + config.getInitParameter("url"));

        System.out.println(config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2的doGet方法！"); //默认是doGet方法
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2的doPost方法！");
    }
}
```

- web.xml (完整版)

```xml
    <servlet>
        <servlet-name>HelloServlet2</servlet-name>
        <servlet-class>com.lzj.servlet.HelloServlet2</servlet-class>
        <init-param>
            <param-name>username</param-name>
            <param-value>root2</param-value>
        </init-param>
        <init-param>
            <param-name>url</param-name>
            <param-value>jdbc:mysql://loaclhost:3306/test2</param-value>
        </init-param>
    </servlet>
    <servlet-mapping>
        <servlet-name>HelloServlet2</servlet-name>
        <url-pattern>/hello2</url-pattern>
    </servlet-mapping>
```

### 7.1.7 使用 IDEA 创建 Servlet 程序

- 菜单：new ->Servlet 程序

![image-20201123221758582](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123221759.png)

- 配置 Servlet 的信息：

![image-20201123221823657](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201124085919.png)

### 7.1.8 Servlet 类的继承体系

![image-20201123221950405](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201123221950.png)

## 7.2 ServletConfig 类

> 1、可以获取 Servlet 程序的别名 servlet-name 的值 
>
> 2、获取初始化参数 init-param 
>
> 3、获取 ServletContext 对象

- web.xml中的配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
    
    <!-- servlet标签给Tomcat配置Servlet程序 -->
    <servlet>
        <!--servlet-name标签 Servlet程序起一个别名（一般是类名） -->
        <servlet-name>HelloServlet</servlet-name>
        <!--servlet-class是Servlet程序的全类名-->
        <servlet-class>com.atguigu.servlet.HelloServlet</servlet-class>
        <!--init-param是初始化参数-->
        <init-param>
            <!--是参数名-->
            <param-name>username</param-name>
            <!--是参数值-->
            <param-value>root</param-value>
        </init-param>
        <!--init-param是初始化参数-->
        <init-param>
            <!--是参数名-->
            <param-name>url</param-name>
            <!--是参数值-->
            <param-value>jdbc:mysql://localhost:3306/test</param-value>
        </init-param>
    </servlet>
    
    <!--servlet-mapping标签给servlet程序配置访问地址-->
    <servlet-mapping>
        <!--servlet-name标签的作用是告诉服务器，我当前配置的地址给哪个Servlet程序使用-->
        <servlet-name>HelloServlet</servlet-name>
        <!--
            url-pattern标签配置访问地址                                     
               / 斜杠在服务器解析的时候，表示地址为：http://ip:port/工程路径         
               /hello 表示地址为：http://ip:port/工程路径/hello             
        -->
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>
</web-app>
```

- Servlet中的代码：

```java
@Override
    public void init(ServletConfig servletConfig) throws ServletException {
        // 实现接口的不需要调用super.init(servletConfig)方法     eg: HelloServlet
        System.out.println("HelloServlet init 初始化方法");
		//1、可以获取 Servlet 程序的别名 servlet-name 的值 
        System.out.println("HelloServlet程序的别名为：" + servletConfig.getServletName());
        
		//2、获取初始化参数 init-param 
        System.out.println("初始化参数 username 的值为：" + servletConfig.getInitParameter("username"));
        
        System.out.println("初始化参数 url 的值为：" + servletConfig.getInitParameter("url"));
		//3、获取 ServletContext 对象
        System.out.println(servletConfig.getServletContext());
    }


@Override
    public void init(ServletConfig config) throws ServletException {
        // 继承HttpServlet需要调用super.init(servletConfig) eg: HelloServlet2
        super.init(config); 
        System.out.println("HelloServlet init 初始化方法");

        System.out.println("HelloServlet程序的别名为：" + config.getServletName());
        System.out.println("初始化参数 username 的值为：" + config.getInitParameter("username"));
        System.out.println("初始化参数 url 的值为：" + config.getInitParameter("url"));

        System.out.println(config.getServletContext());
    }
```

**<font color='red'>PS: 注意</font>**

> // 实现接口的不需要调用super.init(servletConfig)方法
>
>  // 继承HttpServlet需要调用super.init(servletConfig)
>
> 原因：实现的Servlet接口，对init方法进行了重新的实现
>
> ​			 而继承HttpServlet类后，对init方法进行重写时，其父抽象类GenericServlet中已经进行了一些init操作，故需要调用父类初始化，再进行继续重写。否则某些属性得不到赋值。
>
> ```java
> public void init(ServletConfig config) throws ServletException { // GenericServlet
>     this.config = config;
>     this.init();
> }
> ```

## 7.3 ServletContext类

### 7.3.1 什么是 ServletContext?

> 1、ServletContext 是一个接口，它表示 Servlet 上下文对象 
>
> 2、一个 web 工程，只有一个 ServletContext 对象实例。 
>
> 3、ServletContext 对象是一个**域对象**。 
>
> 4、ServletContext 是在 web 工程部署启动的时候创建。在 web 工程停止的时候销毁。

- **域对象**

> 域对象，是可以像 Map 一样存取数据的对象，叫域对象。 
> 这里的域指的是存取数据的操作范围，相对于整个 web 工程。

|        | 存数据         | 取数据         | 删除数据          |
| ------ | -------------- | -------------- | ----------------- |
| map    | put()          | get()          | remove()          |
| 域对象 | setAttribute() | getAttribute() | removeAttribute() |

### 7.3.2 ServletContext 类的四个作用

>1、获取 web.xml 中配置的上下文参数 context-param 
>
>2、获取当前的工程路径，格式:     /工程路径 
>
>3、获取工程部署后在服务器硬盘上的绝对路径 
>
>4、像 Map 一样存取数据

- **web.xml**

```xml
<context-param>
    <param-name>username</param-name>
    <param-value>context</param-value>
</context-param>
<context-param>
    <param-name>password</param-name>
    <param-value>root</param-value>
</context-param>
```

- 自定义的ContextServlet类

```java
@WebServlet(name = "ContextServlet", value = "/context")  //直接new出来的Servlet可以选择带注解
public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletConfig().getServletContext();
        ServletContext servletContext1 = getServletContext();

        String username = servletContext.getInitParameter("username");
        System.out.println("context-param 参数 username 的值是:" + username);
        System.out.println("context-param 参数 password 的值是:" + servletContext.getInitParameter("password"));
        //context-param 参数 username 的值是:context
        //context-param 参数 password 的值是:root

        //  / 斜杠被服务器解析地址为:http://ip:port/工程名/        并被映射到 IDEA 代码的 web 目录
        System.out.println("工程目录的部署路径：" + servletContext.getRealPath("/"));
        //工程目录的部署路径：D:\微云同步助手\810968336\Java\JavaWeb\out\artifacts\06_Servlet_war_exploded\
        System.out.println("工程下 css 目录的绝对路径是:" + servletContext.getRealPath("/css"));
        //工程下 css 目录的绝对路径是:D:\微云同步助手\810968336\Java\JavaWeb\out\artifacts\06_Servlet_war_exploded\css
        System.out.println("工程下 imgs 目录 1.jpg 的绝对路径是:" + servletContext.getRealPath("/imgs/1.jpg"));
        //工程下 imgs 目录 1.jpg 的绝对路径是:D:\微云同步助手\810968336\Java\JavaWeb\out\artifacts\06_Servlet_war_exploded\imgs\1.jpg

        System.out.println("服务器本地的ip地址" + request.getLocalAddr());
        System.out.println("客户端的ip地址" + request.getRemoteAddr());  //nginx反向代理传来的地址无法获取真实的ip地址

    }
}
```

- 自定义的ContextServlet1类

```java
public class ContextServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        System.out.println(context);
        System.out.println("保存之前: Context 获取 key1 的值是:"+ context.getAttribute("key1"));
        context.setAttribute("key1","value1");
        System.out.println(" Context 获取域对象 key1 的值是:"+ context.getAttribute("key1"));
    }
}
```

## 7.4 Http协议

### 7.4.1 概念

> 什么是协议?
>
> - 协议是指双方或多方约定好的规则。
>
> - HTTP 协议：客户端和服务器之间通信时，发送的数据，需要遵守的规则，叫 HTTP 协议(应用层协议)。

### 7.4.2 Http的请求协议格式

- 客户端给服务器发送数据叫请求，请求分为get请求与post请求，在Servlet中分别由doGet和doPost进行处理。

#### 1）Get请求

- 请求行

  - (1) 请求的方式   GET 
  - (2) 请求的资源路径[+?+请求参数] 
  - (3) 请求的协议的版本号   HTTP/1.1

- 请求头

  key : value 组成  不同的键值对，表示不同的含义。

![image-20201124093945426](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201124093945.png)

#### 2）Post请求

- 请求行

  - (1) 请求的方式 POST 

  - (2) 请求的资源路径[+?+请求参数] 

  - (3) 请求的协议的版本号   HTTP/1.1 

- 请求头

  - key : value  不同的请求头，有不同的含义

- 请求体 ===>>>  就是发送给服务器的数据

![image-20201124094144269](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201124094144.png)

#### 3) 常用请求头说明

- Accept: 表示客户端可以接收的数据类型 
- Accpet-Languege: 表示客户端可以接收的语言类型 
- User-Agent: 表示客户端浏览器的信息 
- Host： 表示请求时的服务器 ip 和端口号

#### 4) Get请求和Post请求的分类

- **Get请求**

  1、form 标签 method=get 

  2、a 标签 

  3、link 标签引入 css 

  4、Script 标签引入 js 文件 

  5、img 标签引入图片 

  6、iframe 引入 html 页面 

  **7、在浏览器地址栏中输入地址后敲回车**   

- **Post请求**

  8、form 标签 method=post 

### 7.4.3 Http的响应协议格式

- 响应行 

  (1) 响应的协议和版本号    HTTP/1.1

  (2) 响应状态码     200

  (3) 响应状态描述符    ok

- 响应头 

  ​	 key : value    不同的响应头，有其不同含义 

**<font color='red'>空行</font>** 

- 响应体   ---->>>  回传给客户端的数据

![image-20201124101816370](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201124101816.png)

### 7.4.4 常用的响应码说明

- 200  表示请求成功 

- 302  表示请求重定向（明天讲） 

- 404  表示请求服务器已经收到了，但是你要的数据不存在（请求地址错误） 

- 500  表示服务器已经收到请求，但是服务器内部错误（代码错误）
- 304  服务端已经执行了GET，但文件未变化

### 7.4.5 MIME 类型说明

> MIME 是 HTTP 协议中数据类型。
>
> MIME 的英文全称是"Multipurpose Internet Mail Extensions" 多功能 Internet 邮件扩充服务。MIME 类型的格式是“大类型/小类型”，并与某一种文件的扩展名相对应。

- 常见的 MIME 类型：

![image-20201124102602812](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201124102602.png)

![image-20201124102612525](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201124102612.png)

### 7.4.6 谷歌浏览器查看 HTTP 协议

![image-20201124102740479](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201124102740.png)









**web项目中的路径问题。 base标签处进行说明。**

# 8. 书城项目

>环境依赖：jdk1.8 + tomcat 8.0.50 + mysql 5.7.29
>
>实现：用户注册与登录

## 8.1 JavaEE项目的三层架构







## 8.4 编写BaseDao

### 8.4.1 导入 **DBUtils** **的** **jar** 包

>commons-dbutils-1.3.jar

### 8.4.2 编写BaseDao抽象类





## 8.5 编写UserDao和测试

### 8.5.1 UserDao接口



### 8.5.2 UserDaoImpl实现类



### 8.5.3 UserDaoTest测试



## 8.6 编写UserService和测试

### 8.6.1 UserService接口



### 8.6.2 UserServiceImpl实现类

```java
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {

        if (userDao.queryUserByUsername(username) == null) {
           // 等于null,说明没查到，没查到表示可用
           return false;
        }
        return true;
    }
}
```

### 8.6.3 UserServiceTest测试

> 需要junit jar包

```java
public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "admin", "123456", "")));
        System.out.println(userService.login(new User(null, "admin", "12345", "")));
    }

    @Test
    public void registUser() {
        //去mysql客户端看结果
        userService.registUser(new User(null, "adidas", "123456", "12@qw.q"));
        userService.registUser(new User(null, "nike", "123456", "12@qw.q"));
    }

    @Test
    public void exitsUsername() {
        System.out.println(userService.exitsUsername("keen"));
        System.out.println(userService.exitsUsername("nike"));
    }
}
```



## 8.7 编写Web层

### 8.7.1 实现用户注册功能

#### （1）图解用户注册的流程



####  （2）修改regist.html和regist_success.html页面

1. 添加base 标签

```html
<!--写 base 标签，永远固定html页面相对路径跳转的结果--> 
<!-- 特别注意base标签位置，一般写在标题下，写在哪里，之后的路径都是基于此路径。 -->
<base href="http://localhost:8080/book/"> 
```

2. 修改 base 标签对页面中所有相对路径的影响（浏览器 F12，哪个报红，改哪个,直接打开即可）

```html
<link type="text/css" rel="stylesheet" href="static/css/style.css" > 
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
<!-- 注意包含之后的一些资源的相对路径，也需要修改 -->
```

3. 修改注册表单的提交地址和请求方式

![image-20201120142753461](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201120142753.png)



#### （3） 编写RegistServlet程序

```java
public class RegistServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //2. 检查验证码
        if("abcd".equalsIgnoreCase(code)){
            //验证码成立
            if(userService.exitsUsername(username)){
                //用户名已存在
                System.out.println("用户名["+ username +"]已经存在！");
                //重定向至原页面
                req.getRequestDispatcher("/pages/user/register.html").forward(req,resp);
            } else {
                //用户名不存在,进行注册，并保存
                userService.registUser(new User(null, username, password, email));
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req, resp);
            }
        } else {
            //验证码不成立
            System.out.println("验证码["+code+"]输入错误！");
            req.getRequestDispatcher("/pages/user/register.html").forward(req,resp);
        }
    }
}
```

#### （4） web.xml中配置

```xml
<servlet>
    <servlet-name>RegistServlet</servlet-name>
    <servlet-class>com.lzj.web.RegistServlet</servlet-class>
</servlet>

<servlet-mapping>
    <servlet-name>RegistServlet</servlet-name>
    <url-pattern>/registServlet</url-pattern>
</servlet-mapping>
```



### 8.7.2 用户登录功能实现

> 与注册功能过程类似

```java
public class LoginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userService.login(new User(null,username, password, null));

        if(user == null){
            //没有找到用户
            System.out.println("没有找到用户["+username+"]!");
            req.getRequestDispatcher("/pages/user/login.html").forward(req,resp);
        } else {
            //找到相应用户
            System.out.println(user);
            req.setAttribute("user",user);
            req.getRequestDispatcher("/pages/user/login_success.html").forward(req,resp);
        }
    }
}
```



# 9. JSP页面

## 9.1 JSP介绍

> jsp 全称Java Server Pages，即java服务器页面。本质是Servlet程序，为了解决原生Servlet回传页面html的繁琐与复杂，来代替Servlet方便的进行回传html页面的数据。

- Servlet回传html数据案例

```java
public class PrintHtmlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");

        PrintWriter writer = resp.getWriter();

        writer.write("<!DOCTYPE html>\r\n");
        writer.write(" <html lang=\"en\">\r\n");
        writer.write(" <head>\r\n");
        writer.write(" <meta charset=\"UTF-8\">\r\n");
        writer.write(" <title>Title</title>\r\n");
        writer.write(" </head>\r\n");
        writer.write(" <body>\r\n");
        writer.write(" 这是 html 页面数据 \r\n");
        writer.write(" </body>\r\n");
        writer.write("</html>\r\n");
        writer.write("\r\n");
    }
}
```

## 9.2 JSP的本质

> - jsp页面本质上使一个Servlet程序。
>- 当第一次访问jsp页面时，Tomcat程序会将jsp页面翻译成一个java 源文件（a.jsp对应java文件名为a_jsp.java），并将其编译成.class字节码程序。
> - 可以在tomcat启动中的查看到 Using CATALINA_BASE: 后面的地址，即为部署地址。

## 9.3 JSP的三种语法

### 9.3.1  jsp头部的page指令

- jsp 的 page 指令可以修改 jsp 页面中一些重要的属性，或者行为。

![image-20201125205954560](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201125205954.png)

>1. language 属性            表示 jsp 翻译后是什么语言文件。暂时只支持 java。 
>2. contentType 属性       表示 jsp 返回的数据类型是什么。也是源码中 response.setContentType()参数值 
>3. pageEncoding 属性    表示当前 jsp 页面文件本身的字符集。 
>4. import 属性        跟 java 源代码中一样。用于导包，导类。 
>5. autoFlush 属性   设置当 out 输出流缓冲区满了之后，是否自动刷新冲级区。默认值是 true。 
>6. buffer 属性         设置 out 缓冲区的大小。默认是 8kb
>7. errorPage属性   设置当 jsp 页面运行时出错，自动跳转去的错误页面路径。    /1.jsp    /error500.html
>8. isErrorPage 属性   设置当前 jsp 页面是否是错误信息页面。默认是 false。若为 true 可以获取异常信息。
>9. session 属性    设置访问当前 jsp 页面，是否会创建 HttpSession 对象。默认是 true。
>10. extends 属性   设置 jsp 翻译出来的 java 类默认继承谁。  默认继承HttpJspBase类

![image-20201125210227280](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201125210227.png)

### 9.3.2 jsp中的常用脚本

#### 1）声明脚本 (极少使用)

- 格式

> 声明脚本的格式是： <%! 声明 java 代码 %>

- 作用

> 可以给 jsp 翻译出来的 java 类定义属性、方法、静态代码块、内部类等。
>
> 1. 声明类属性 
> 2. 声明 static 静态代码块 
> 3. 声明类方法 
> 4. 声明内部类

- 案例：

```jsp
<%--1、声明类属性--%>
    <%!
        private Integer id;
        private String name;
        private static Map<String,Object> map;
    %>
<%--2、声明static静态代码块--%>
    <%!
        static {
            map = new HashMap<String,Object>();
            map.put("key1", "value1");
            map.put("key2", "value2");
            map.put("key3", "value3");
        }
    %>
<%--3、声明类方法--%>
    <%!
        public int abc(){
            return 12;
        }
    %>
<%--4、声明内部类--%>
    <%!
        public static class A {
            private Integer id = 12;
            private String abc = "abc";
        }
%>
```

![image-20201125212000746](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201125212000.png)



#### 2）表达式脚本  （常用）

- 格式

>  表达式脚本的格式是：<%=表达式%>

- 作用 ：在浏览器页面上输出数据 

> 在jsp 页面上输出数据。
>
> 1. 输出整型 
> 2. 输出浮点型 
>
> 3. 输出字符串 
>
> 4. 输出对象

- 特点

> 1. 所有的表达式脚本都会被翻译到_jspService() 方法中 
>
> 2. 表达式脚本都会被翻译成为 out.print()输出到页面上 
>
> 3. 由于表达式脚本翻译的内容都在_jspService() 方法中,所以_jspService()方法中的对象都可以直接使用。 
>
> 4. 表达式脚本中的表达式不能以分号结束。

- 案例： **<font color='red'>特别注意不能加分号</font>**

```jsp
<%=12 %> <br>
<%=12.12 %> <br>
<%="我是字符串" %> <br>
<%=map%> <br>
<%=request.getParameter("username")%>
```

![image-20201125212547729](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201125212547.png)

#### 3）代码脚本

- 格式

>**<%** 
>
>​		java 语句 
>
>%>

- 作用

> 在.jsp文件中书写类似于Servlet的java代码，来完成业务功能。

- 特点

> 1、代码脚本翻译之后都在_jspService 方法中 
>
> 2、代码脚本由于翻译到_jspService()方法中，所以在\_jspService()方法中的现有对象都可以直接使用。 
>
> 3、还可以由多个代码脚本块组合完成一个完整的 java 语句。 
>
> 4、代码脚本还可以和表达式脚本一起组合使用，在 jsp 页面上输出数据

- 案例：

```jsp
<%--1.代码脚本----if 语句--%>
    <%
        int i = 13 ;
        if (i == 12) {
    %>
            <h1>我是h1标签</h1>
    <%
        } else {
    %>
        <h1>我就是h1标签！</h1>
    <%
        }
    %>
<br>
<%--2.代码脚本----for 循环语句--%>
    <table border="1" cellspacing="0">
    <%
        for (int j = 0; j < 10; j++) {
    %>
        <tr>
            <td>第 <%=j + 1%>行</td>
        </tr>
    <%
        }
    %>
    </table>
<%--3.翻译后java文件中_jspService方法内的代码都可以写--%>
    <%
        String username = request.getParameter("username");
        System.out.println("用户名的请求参数值是：" + username);
%>	
```

![image-20201125213401628](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201125213401.png)

### 9.3.3 jsp中的三种注释

1）html注释

> html 注释会被翻译到 java 源代码中。在_jspService 方法里，以 out.writer 输出到客户端

```html
<!-- 这是 html 注释 -->
```



2）java注释

> java 注释会被翻译到 java 源代码中。 

```jsp
<% 
    // 单行 java 注释 
    /* 多行 java 注释 */ 
%>
```

3）jsp注释

> jsp 注释可以注掉，jsp 页面中所有代码。 不会被翻译到java源代码中。

```jsp
<%-- 这是 jsp 注释 --%>
```

## 9.4 jsp的九大内置对象

|   内置对象   | 对象描述                                                     |
| :----------: | :----------------------------------------------------------- |
|   request    | 请求对象                                                     |
|   response   | 响应对象                                                     |
| page Context | jsp的上下文对象                                              |
|   session    | 会话对象                                                     |
| application  | ServletContext对象                                           |
|    config    | Servletconfig对象                                            |
|     out      | jsp输出流对象                                                |
|     page     | 指向当前jsp的对象                                            |
|  exception   | 异常对象（只有在设定了page指令  isErrorPage为True后，才可以使用） |

![image-20201125214758670](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201125214758.png)

## 9.5 jsp的九大内置对象中的四大域对象

- 域对象

  > 代表该对象可以像map那样进行存取。setAttribute()   getAttribute()    removeAttribute()

- **四大域对象**

| 四大域对象  | 所属类                  | 有效范围                                                   |
| ----------- | ----------------------- | :--------------------------------------------------------- |
| pageContext | (PageContextImpl 类)    | 当前 jsp 页面范围内有效                                    |
| request     | (HttpServletRequest 类) | 一次请求内有效                                             |
| session     | (HttpSession 类)        | 一个会话范围内有效（打开浏览器访问服务器，直到关闭浏览器） |
| application | (ServletContext 类)     | 整个 web 工程范围内都有效（只要 web 工程不停止，数据都在） |

> 四个域对象功能一样,但对数据的存取范围不同。故在使用上它们是有优先顺序的。 
>
> 四个域在使用的时候，优先顺序分别是，他们从小到大的范围的顺序。 
>
> **pageContext**  =》  **request**  =》 **session**  =》  **application** 

- **测试**

  - scope.jsp

    ```jsp
    <body>
        <h1>scope.jsp页面</h1>
        <%
            // 往四个域中都分别保存了数据
            pageContext.setAttribute("key", "pageContext");
            request.setAttribute("key", "request");
            session.setAttribute("key", "session");
            application.setAttribute("key", "application");
        %>
        pageContext域是否有值：<%=pageContext.getAttribute("key")%> <br>
        request域是否有值：<%=request.getAttribute("key")%> <br>
        session域是否有值：<%=session.getAttribute("key")%> <br>
        application域是否有值：<%=application.getAttribute("key")%> <br>
        <%
    //        request.getRequestDispatcher("/scope2.jsp").forward(request,response);
        %>
        <%--
            <jsp:forward page=""></jsp:forward> 是请求转发标签，它的功能就是请求转发
                page 属性设置请求转发的路径
        --%>
        <jsp:forward page="/scope2.jsp"></jsp:forward>
    </body>
    ```

  - scope.jsp

    ```jsp
    <body>
        <h1>scope2.jsp页面</h1>
        pageContext域是否有值：<%=pageContext.getAttribute("key")%> <br>
        request域是否有值：<%=request.getAttribute("key")%> <br>
        session域是否有值：<%=session.getAttribute("key")%> <br>
        application域是否有值：<%=application.getAttribute("key")%> <br>
    </body>
    ```

    

## 9.6 jsp中out输出和response.getWriter() 输出的区别

- response.getWriter()曾经在Servlet中用作回传字符串。
- out输出对象时jsp的内置对象。出现在 jsp翻译后的Servlet的  _jspService()方法中
- response.getOutputStream()      用于下载(传递二进制数据)

**<font color='red'>PS：注意这两个流工作的原理及顺序</font>**  

- **<font color='red'>在jsp页面中，统一使用out.print() 来进行输出，避免打乱页面输出内容的顺序。</font>**  

![image-20201125221213258](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201125221213.png)

由于 jsp 翻译之后，底层源代码都是使用 out 来进行输出，所以一般情况下。我们在 jsp 页面中统一使用 out 来进行输出。避免打乱页面输出内容的顺序。

- out.write() 输出字符串没有问题。 

- **out.print() 输出任意数据都没有问题（都转换成为字符串后调用的 write 输出）。** 

## 9.7 jsp的常用标签

### 9.7.1 jsp静态包含

> *<%@ include file=""%>* *就是静态包含* 
>
> file *属性指定你要包含的* jsp *页面的路径* 
>
> *地址中第一个斜杠* */* *表示为* *http://ip:port/**工程路径**/*      映射到代码的web目录

- **静态包含的特点：**

  ​	1. 静态包含不会翻译被包含的jsp页面。 

  ​	2. 静态包含其实是把被包含的jsp页面的代码拷贝到包含的位置执行输出。

```jsp
<%@ include file="/include/footer.jsp"%>
```

### 9.7.2 jsp动态包含

> <jsp:include page=""></jsp:include>   这是动态包含 
>
> page 属性是指定要包含的 jsp 页面的路径 
>
> 动态包含也可以像静态包含一样。把被包含的内容执行输出到包含位置

- **动态包含的特点：**

1. 动态包含会把包含的 jsp 页面也翻译成为 java 代码 

2. 动态包含底层代码使用如下代码去调用被包含的 jsp 页面执行输出。 

   > JspRuntimeLibrary.include(request, response, "/include/footer.jsp", out, false); 

3. 动态包含，还可以传递参数，传递的参数可以在包含的页面中使用。

```jsp
<jsp:include page="/include/footer.jsp"> 
    <jsp:param name="username" value="bbj"/> 
    <jsp:param name="password" value="root"/> 
</jsp:include>
```

- **动态包含的底层原理：**

![image-20201125163018980](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201125163019.png)

### 9.7.3 标签-转发

进行转发操作

> 等价于Servlet中的 ：
>
> ​	request.getRequestDispatcher("/scope2.jsp").forward(request,response);



```jsp
<jsp:forward page="/scope2.jsp"></jsp:forward>    <%-- 这种可能引发错误 --%>
<jsp:forward page="/b.jsp" />	<%-- 推荐使用单标签 --%>
```

## 9.8 jsp 的练习题

### 9.8.1 在 jsp 页面中输出九九乘法口诀表

```jsp
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
```

### 9.8.2 jsp 输出一个表格，里面有 10 个学生信息。

![image-20201125194153292](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201125194153.png)

- Student类

  ```java
  public class Student {
  
      private Integer id;
      private String name;
      private Integer age;
      private String phone;
  }
  ```

- SearchStudentServlet类

```java
@WebServlet(name = "SearchStudentServlet", value="/searchStudentServlet")
// 采用注解的好处是不需要在web.xml中进行配置
public class SearchStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从数据库中获取数据
        System.out.println("hahah");
        ArrayList<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int t = i+1;
            studentList.add(new Student(t,"name"+t,18+t,"phone"+t));
        }
        //将数据存进request域中
        request.setAttribute("stuList", studentList);
        //请求转发
        request.getRequestDispatcher("/test/showStudent.jsp").forward(request,response);
    }
}
```

- showStudent.jsp

```jsp
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lzj.pojo.Student" %>
<%@ page import="java.lang.reflect.Array" %>
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
```

## 9.9 什么是 Listener 监听器？

> 1. Listener 监听器它是 JavaWeb 的三大组件之一。JavaWeb 的三大组件分别是：Servlet 程序、Filter 过滤器、Listener 监 听器。
> 2. Listener 它是 JavaEE 的规范，就是接口。 
> 3. 监听器的作用是，监听某种事物的变化。然后通过回调函数，反馈给客户（程序）去做一些相应的处理。

### 9.9.1 ServletContextListener 监听器 (其中一种监听器，还有很多类型的监听器)

> - ServletContextListener 它可以监听 ServletContext 对象的创建和销毁。 
> - ServletContext 对象在 web 工程启动的时候创建，在 web 工程停止的时候销毁。 
> - 监听到创建和销毁之后都会分别调用 ServletContextListener 监听器的方法反馈。

- 两个方法

```java
public interface ServletContextListener extends EventListener {
    void contextInitialized(ServletContextEvent var1);

    void contextDestroyed(ServletContextEvent var1);
}
```

- 使用ServletContextListener监听器监听 ServletContext 对象
  1. 编写一个类去实现 ServletContextListener 
  2. 实现其两个回调方法 
  3. 到 web.xml 中去配置监听器

```java
public class ServletContextListenerImp implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("servletContext对象被创建了.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("servletContext对象被销毁了.");
    }
}
```

- web.xml配置

  ```xml
  <listener>
      <listener-class>com.lzj.listener.ServletContextListenerImp</listener-class>
  </listener>
  ```



# 10. EL 表达式 & JSTL 标签库

## 10.1 EL 表达式（代替jsp页面表达式脚本）

### 10.1.1 什么是 EL 表达式

> EL 表达式的全称是：Expression Language即表达式语言。
>
> EL 表达式的作用：EL 表达式主要是代替 jsp 页面中的表达式脚本在 jsp 页面中进行数据的输出。
>
> 因为 EL 表达式在输出数据的时候，要比 jsp 的表达式脚本要简洁很多。

- 对比

```jsp
<body>
<%--09_EL_JSTL\web\a.jsp--%>
<%
    request.setAttribute("key","值");
%>
表达式脚本输出：<%=request.getAttribute("key")%> <br>
EL表达式输出${key}
</body>
```

- 使用格式

```jsp
EL 表达式的格式是：${表达式} 
EL 表达式在输出 null 值的时候，输出的是空串。jsp 表达式脚本输出 null 值的时候，输出的是 null 字符串。
```

### 10.1.2 EL 表达式搜索域数据的顺序

- EL 表达式主要是在 jsp 页面中输出域对象中的数据。
- 当四个域中都有相同的 key 的数据的时候，EL 表达式会按照四个域的从小到大的顺序去进行搜索，找到就输出。

```jsp
<body>
<%--09_EL_JSTL\web\b.jsp--%>
<%--EL表达式搜索 域数据的顺序--%>
<%
    //往四个域中都保存了相同的 key 的数据。
    pageContext.setAttribute("key","pageContext");
    request.setAttribute("key","request");
    session.setAttribute("key","session");
    application.setAttribute("key","application");
%>
获取域对象的数据：${key}

</body>
```

### 10.1.3 EL 表达式输出 Bean 的普通属性，数组属性。List 集 合属性，map 集合属性

- Person类

```java
public class Person {
	// 09_EL_JSTL\src\com\lzj\pojo\Person.java
    private String name;
    private String[] phones;
    private List<String> cities;
    private Map<String, Object> map;
    
    public int getAge() { return 18; }
}
```

- 输出 Person 类中普通属性，数组属性。list 集合属性和 map 集合属性

```jsp
<body>
<%--09_EL_JSTL\web\c.jsp--%>
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
${person.age} <br>    <%--根据get方法进行获取值--%>

</body>
```

### 10.1.4 EL运算符

> 语法： ${ 运算表达式 }

#### 1）关系运算

![image-20201130212622246](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201130212637.png)

#### 2）逻辑运算

![](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201130212637.png)

#### 3）算数运算

![image-20201130212649176](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201130212649.png)

![image-20201130212712158](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201130212712.png)

#### 4） empty运算

- empty 运算可以判断一个数据是否为空，如果为空，则输出 true,不为空输出 false。 

- 以下几种情况为空： 

  1、值为 null 值的时候，为空 

  2、值为空串的时候，为空 

  3、值是 Object 类型数组，长度为零的时候 

  4、list 集合，元素个数为零 

  5、map 集合，元素个数为零 

```jsp
<%--09_EL_JSTL\web\d.jsp--%>
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
```

#### 5) 三元运算

- 表达式 1？表达式 2：表达式 3 
- 如果表达式 1 的值为真，返回表达式 2 的值，如果表达式 1 的值为假，返回表达式 3 的值。

```jsp
<%--09_EL_JSTL\web\e.jsp--%>
<%--三元运算符--%>
<hr>
${ 12>13?"12>13":"12<=13" }
```

#### 6）“.”点运算 和 [] 中括号运算符

- .点运算，可以输出 Bean 对象中某个属性的值。 

- []中括号运算，可以输出有序集合中某个元素的值。 

- 并且[]中括号运算，还可以输出 map 集合中 key 里含有特殊字符的 key 的值



```
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
```

### 10.1.4 EL 表达式的 11 个隐含对象

> 变量                                           类型                                                  作用 
>
> pageContext                         PageContextImpl                       它可以获取 jsp 中的九大内置对象 
>
> 
>
> pageScope                            Map<String,Object>                  它可以获取 pageContext 域中的数据 
>
> requestScope                       Map<String,Object>                   它可以获取 Request 域中的数据 
>
> sessionScope                       Map<String,Object>                   它可以获取 Session 域中的数据 
>
> applicationScope                Map<String,Object>                    它可以获取 ServletContext 域中的数据 
>
> 
>
> param                                   Map<String,String>                     它可以获取请求参数的值 
>
> paramValues                        Map<String,String[]>               它也可以获取请求参数的值，获取多个值的时候使用。 
>
> 
>
> header                                  Map<String,String>                      它可以获取请求头的信息 
>
> headerValues                       Map<String,String[]>               它可以获取请求头的信息，它可以获取多个值的情况 
>
> 
>
> cookie                                   Map<String,Cookie>                     它可以获取当前请求的 Cookie 信息

#### 1) EL 获取四个特定域中的属性

> pageScope   ===>  pageContext 域 
>
> requestScope  ===>  Request 域 
>
> sessionScope   ===>  Session 域 
>
> applicationScope   ===>  ServletContext 域

- 为什么需要隐含对象？

> ​    ${key2}  输出时会满足最小域原则，但有时在pageContext有key2时，我们想输出request的key2，所以需要可以指定的方式来确定是哪个域中的key2输出的结果。即可以选择性的输出某一个域中的值，而不是使用默认的顺序输出。

```jsp
<body>

param.username: &nbsp;${param.username} <br>
param.username: &nbsp;${param.password} <br>
paramValues.username[0]: &nbsp;${paramValues.username[0]} <br>
paramValues.hobbies: &nbsp;${paramValues.hobby} <br>
paramValues.hobby[0]: &nbsp;${paramValues.hobby[0]} <br>
paramValues.hobby[1]: &nbsp;${paramValues.hobby[1]} <br>

</body>
```



# todo









# 11.  文件上传与下载 （完）

> 均是针对用户而言的。上传是上传到服务器，下载是下载到本地。

[JAVA上传文件图片到指定服务器目录_java文件上传到指定服务器](https://blog.csdn.net/u014108448/article/details/46804729)

## 11.1 文件的上传

> 从客户端将文件发送到服务器端。

1、要有一个 form 标签，method=post 请求 

2、form 标签的 encType 属性值必须为 multipart/form-data 值 

3、在 form 标签中使用 input type=file 添加上传的文件 

4、编写服务器代码（Servlet 程序）接收，处理上传的数据。

> encType=multipart/form-data 表示提交的数据，以多段（每一个表单项一个数据段）的形式进行拼 
>
> 接，然后以二进制流的形式发送给服务器

### 11.1.1 文件上传，HTTP 协议的说明

![image-20201202093715672](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201202093715.png)

### 11.1.2 文件上传所需jar包和API

> 文件上传需要依赖两个jar包，**commons-fileupload-1.2.1.jar** 与  **commons-io-1.4.jar**, 前者依赖于后者

#### 1）导入两个jar包

commons-fileupload-1.2.1.jar 

commons-io-1.4.jar

#### 2）API说明

- ServletFileUpload 类，用于解析上传的数据

- FileItem 类，表示每一个表单项。 

- boolean ServletFileUpload.*isMultipartContent*(HttpServletRequest request);     判断当前上传的数据格式是否是多段的格式

- public List<FileItem> parseRequest(HttpServletRequest request)    解析上传的数据 

- boolean FileItem.isFormField()   判断当前这个表单项，是否是普通的表单项。还是上传的文件类型。 

     true 表示普通类型的表单项 

     false 表示上传的文件类型

- String FileItem.getFieldName()    获取表单项的 name 属性值

- String FileItem.getString()   获取当前表单项的值。

- String FileItem.getName();   获取上传的文件名

- void FileItem.write( file );   将上传的文件写到 参数 file 所指向抽硬盘位置 。 

### 11.1.3 fileupload 类库的使用

- 上传文件的表单：

```jsp
<form action="/00_SimpleModule/uploadServletJar" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="username"> <br>
    头像：<input type="file" name="photo"> <br>
    <input type="submit" value="上传头像">
</form>
```

- 原生的上传文件

```java
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("图片上传成功");
        ServletInputStream inputStream = req.getInputStream();

        byte[] buffer = new byte[1024000];
        int read = inputStream.read(buffer);
        System.out.println(new String(buffer,0,read));

    }
}
```

- jar包中的方法解析上传的数据

  1. 判断上传的数据是否是多段数据，多段数据才进行上传

  2. 创建表单项FileItemFactory 工厂实现类

  3. 创建用于解析上传数据的ServletFileUpload对象

  4. 解析上传的数据，得到表单项FileItem的List

  5. 循环遍历，isFormFiled判断是否是普通表单项，

     ture：则getString获取内容

     false： 则可以write到文件中

```java
public class UploadServletJar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charest=UTF-8");

        //1. 判断上传数据是否为多段数据（只有是多段的数据，才是文件上传）
        if(ServletFileUpload.isMultipartContent(req)){

            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

            List<FileItem> list = null;
            try {
                list = servletFileUpload.parseRequest(req);
                for (FileItem fileItem:list) {

                    if(fileItem.isFormField()){
                        //普通表单项
                        System.out.println("表单项的name属性值："+fileItem.getFieldName());
                        System.out.println("表单项的value属性值："+fileItem.getString());  //中文会乱码
                    } else{
                        // 上传的文件
                        System.out.println("表单项的name属性值："+fileItem.getFieldName());  //photo
                        System.out.println("上传的文件名："+fileItem.getName());

                        fileItem.write(new File("d://"+fileItem.getName()));  //传回到本地
                        String realPath = getServletContext().getRealPath("/");
                        System.out.println("realPath:"+realPath);
                        // D:\微云同步助手\810968336\JavaWeb\JavaWeb\out\artifacts\00_SimpleModule_war_exploded\
                        //System.out.println("req.getServletPath():"+req.getServletPath());
                        File file = new File(realPath+"file/"+fileItem.getName());
                        fileItem.write(file);  //写到了tomcat部署的文件中了。
                        System.out.println("file upload success!!");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
```

## 11.2 文件的下载

> 文件从服务器端下载到本地。

### 11.2.1 文件下载API说明

- response.getOutputStream(); 

- servletContext.getResourceAsStream(); 

- servletContext.getMimeType(); 

- response.setContentType();
- response.setHeader("Content-Disposition", "attachment; fileName=1.jpg"); 
  - 这个响应头告诉浏览器。这是需要下载的。而 attachment 表示附件，也就是下载的一个文件。fileName=后面， 表示下载的文件名。
  - 下载无法正确显示出正确的中文名。原因是在响应头中，不能包含有中文字符，只能包含 ASCII 码。

### 11.2.2 案例演示

```java
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //文件下载5步骤
        //1. 获取要下载的文件名
        String downloadFileName = "1.png";

        ServletContext servletContext = getServletContext();
        //2. 获取下载文件的文件类型
        String mimeType = servletContext.getMimeType(downloadFileName);
        System.out.println("下载的文件类型为："+mimeType);

        //3. 在回传前告诉客户端返回的数据类型
        resp.setContentType(mimeType);
        //4. 要告诉客户端收到的数据是用于下载使用（还是使用响应头）
        // Content-Disposition 响应头，表示收到的数据怎么处理
        // attachment 表示附件，表示下载使用
        // filename= 表示指定下载的文件名
        String ua = req.getHeader("User-Agent");
        if(ua.contains("Firefox")){
            //火狐浏览器，使用BASE64编码，才可以保存中文文件
            String str = "attachment; fileName=" + "=?utf-8?B?" +
                    new BASE64Encoder().encode("北京.png".getBytes("utf-8")) + "?=";
            resp.setHeader("Content-Disposition",str); //文件名可指定
        } else{
            //其它浏览器：google、IE
            //Content-Disposition: attachment; filename=%E5%8C%97%E4%BA%AC.png
            resp.setHeader("Content-Disposition","attachment; filename="+ URLEncoder.encode("北京.png","UTF-8")); //文件名可指定
        }

        //获取响应的输出流
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFileName);
        ServletOutputStream outputStream = resp.getOutputStream();
        // 将文件内容回传给客户端
        //5. 读取输入流中全部的数据，复制给输出流，输出给客户端
        IOUtils.copy(resourceAsStream,outputStream);
    }
}
```



### 11.2.3 附件中文名乱码问题 

> 发生在文件下载过程中

#### 1） 使用URLEncoder解决IE和chrome的附件中文名乱码问题

如果客户端浏览器是 IE 浏览器 或者 是谷歌浏览器。我们需要使用 URLEncoder 类先对中文名进行 UTF-8 的编码 

操作。因为 IE 浏览器和谷歌浏览器收到含有编码后的字符串后会以 UTF-8 字符集进行解码显示。

```java
// 把中文名进行 UTF-8 编码操作。 
String str = "attachment; fileName=" + URLEncoder.encode("中文.jpg", "UTF-8");
// 然后把编码后的字符串设置到响应头中 
response.setHeader("Content-Disposition", str);
```

#### 2）使用BASE64编码解决 火狐附件中文名乱码问题

如果客户端浏览器是火狐浏览器。 那么我们需要对中文名进行 BASE64 的编码操作

这时候需要把请求头 Content-Disposition: attachment; filename=中文名 

编码成为：Content-Disposition: attachment; filename==?charset?B?xxxxx?=

=?charset?B?xxxxx?= 现在我们对这段内容进行一下说明。 

```html
=?      表示编码内容的开始 

charset 表示字符集 

B       表示 BASE64 编码 

xxxx 表示文件名 BASE64 编码后的内容 

?=    表示编码内容的结束
```

- 火狐使用的是 BASE64 的编解码方式还原响应中的汉字。所以需要使用 BASE64Encoder 类进行编码操作。

```java
public class BASE64Operate {

    public static void main(String[] args) throws Exception {
        String content = "这是需要 Base64 编码的内容";
        // 创建一个 Base64 编码器
        BASE64Encoder base64Encoder = new BASE64Encoder();
        // 执行 Base64 编码操作
        String encodedString = base64Encoder.encode(content.getBytes("UTF-8"));
        System.out.println(encodedString);  //6L+Z5piv6ZyA6KaBIEJhc2U2NCDnvJbnoIHnmoTlhoXlrrk=
        // 创建 Base64 解码器
        BASE64Decoder base64Decoder = new BASE64Decoder();
        // 解码操作
        byte[] bytes = base64Decoder.decodeBuffer(encodedString);

        String str = new String(bytes, "UTF-8");  // 这是需要 Base64 编码的内容
        System.out.println(str);
    }
}
```

- 修改方式

```java
// 使用下面的格式进行 BASE64 编码后 
String str = "attachment; fileName=" + "=?utf-8?B?" + new BASE64Encoder().encode("中文.jpg".getBytes("utf-8")) + "?="; 
// 设置到响应头中 
response.setHeader("Content-Disposition", str);
```



# 12. 书城项目第三阶段

## 12.1 页面jsp动态化

> 1. 在 html 页面顶行添加 page 指令。   
>
>    ​	在html页面的最上方添加:   <%@ page contentType="text/html;charset=UTF-8" language="java" %>
>
> 2. 修改文件后缀名：.html => .jsp 
>
> 3. 使用 IDEA 搜索替换.html 为.jsp(快捷键：Ctrl+Shift+R)    

![image-20201204185940971](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201204185948.png)

## 12.2 抽取页面中的相同的内容

![image-20201204190643280](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201204190643.png)

> 静态加载：
>
> ```jsp
> <%-- 引入css与base标签 --%>
> <%@include file="/pages/common/head.jsp" %>
> 
> <%-- 管理菜单展示 --%>
> <%@include file="/pages/common/manager_menu.jsp"%>
> 
> <%--静态包含页脚内容--%>
> <%@include file="/pages/common/footer.jsp"%>
> ```
>
> 这里要加/，见下方动态base标签解析。

- **head.jsp**

> 1. 定义动态base标签
> 2. 抽取公共css及jquery等库的导入

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<!--注意basePath字符串中最后有“/”-->
<!--写base标签，永远固定相对路径跳转的结果-->
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
```

> 特别注意base标签在不同的标签中用法不同。
>
> 1. 在html原生的标签中，已经直接映射到了web目录下，在base标签之后定义的，故不需要再在开始位置增加 /，进行导入。
> 2. 而对于jsp的标签，因为相当于一个servlet程序，仍需要开始位置添加一个 /

```jsp
<!-- html原生标签 -->
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
<a href="index.jsp">返回首页</a>

<!-- jsp标签 -->
<%-- 引入css与base标签 --%>
<%@include file="/pages/common/head.jsp" %>

<%-- 管理菜单展示 --%>
<%@include file="/pages/common/manager_menu.jsp"%>

<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp"%>
```

- **footer.jsp**

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
</div>
```

- **login_success_menu.jsp**

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <span>欢迎<span class="um_span">韩总</span>光临尚硅谷书城</span>
    <a href="pages/order/order.jsp">我的订单</a>
    <a href="index.jsp">注销</a>&nbsp;&nbsp;
    <a href="index.jsp">返回</a>
</div>
```

- **manager_menu.jsp**

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <a href="book_manager.jsp">图书管理</a>
    <a href="order_manager.jsp">订单管理</a>
    <a href="index.jsp">返回商城</a>
</div>
```

## 12.3 登录、注册错误提示及表单回显

> 思路：
>
> 1. 发生错误，则在对应的Servlet方法中将错误信息存到request域中
> 2. 在jsp页面对应位置进行显示通过request域

- Servlet 程序端需要添加回显信息到 Request 域中

![image-20201204194949651](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201204194949.png)

- jsp 页面，需要输出回显信息

![image-20201204195030857](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201204195030.png)

## 12.4 BaseServlet的抽取

> 抽取的目的：
>
> 1. 在实际的项目开发中，一个模块，一般只使用一个 Servlet 程序。
> 2. 用户操作分为：登录、注册、更新、删除、查询所有、按条件查询，如果创建很多个Servlet类来配置请求，则会非常冗余，则可以按照用户操作，图书操作，其它类别操作进行分别统一归类。
>    1. 怎么能调用login 和 regist对应的方法？ 采用反射进行调用，通过隐藏域传回来的name="action"来获取value="login",来进行区分，对应反射的method，并调用。
> 3. 可以提取出公共部分到BaseServlet抽象类来，并使BaseServlet继承HttpServlet。而归类的UserServlet继承BaseServlet。

1. jsp页面添加隐藏域

```jsp
<input type="hidden" name="action" value="login">
```

2. 创建BaseServlet抽象类

```java
public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        try {
            // 获取action业务鉴别字符串，获取相应的业务 方法反射对象
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);

            //System.out.println(method);
            // 调用目标业务 方法
            method.invoke(this, req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

3. 将LoginServlet及RegistServlet聚合成一个UserServlet，并在web.xml中进行配置，并且修改请求的地址。

- 这边的方法是LoginServlet与RegistServlet直接改个名称得来，会在有请求过来时，通过反射找到对应的方法。

```java
public class UserServlet extends BaseServlet {

    private UserService userService= new UserServiceImpl();

    
    public void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求的参数
        //String username = req.getParameter("username");
        //String password = req.getParameter("password");
        //String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());


        //2. 检查验证码
        if("abcd".equalsIgnoreCase(code)){
            //验证码成立
            if(userService.exitsUsername(user.getUsername())){
                //用户名已存在
                System.out.println("用户名["+ user.getUsername() +"]已经存在！");
                req.setAttribute("msg","用户名["+ user.getUsername() +"]已经存在！");
                req.setAttribute("username",user.getUsername());
                req.setAttribute("email",user.getEmail());
                //请求的转发
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            } else {
                //用户名不存在,进行注册，并保存
                userService.registUser(new User(null, user.getUsername(), user.getPassword(), user.getEmail()));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            //验证码不成立
            System.out.println("验证码["+code+"]输入错误！");
            req.setAttribute("msg","验证码输入错误！");
            req.setAttribute("username",user.getUsername());
            req.setAttribute("email",user.getEmail());
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String username = req.getParameter("username");
        //String password = req.getParameter("password");
        User user1 = WebUtils.copyParamToBean(req.getParameterMap(),new User());

        User user = userService.login(user1);

        if(user == null){
            //没有找到用户
            System.out.println("没有找到用户["+user1.getUsername()+"]!");
            req.setAttribute("msg","用户名或密码错误！");
            req.setAttribute("username",user1.getUsername());
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        } else {
            //找到相应用户
            System.out.println(user);
            req.setAttribute("user",user);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }
}
```

## 12.5 数据的封装与抽取BeanUtils的使用

> 面对的问题：
>
> - 从页面传过来的param有很多，需要一项一项的进行封装到对象中，比较繁琐。
>
> 思路：
>
> - 获取参数map，将参数map使用已经封装好的jar包进行bean的封装。

- BeanUtils工具类（第三方的工具类）

> 可以一次性的把所有请求的参数注入到 JavaBean 中。
> 经常用于把 Map 中的值注入到 JavaBean 中，或者是对象属性值的拷贝操作。

1. 导包

- commons-beanutils-1.8.0.jar 
- commons-logging-1.1.1.jar

2. 编写 WebUtils 工具类

```java
public class WebUtils {

    /**
    * @Description: 将map注入到bean中
    * @Params: map 参数来源
     * bean：注入到的bean
    * @Return: 返回实体类对象
    */
    public static <T> T  copyParamToBean(Map map, T bean) {
        try {
            System.out.println("注入前：" + bean);
            BeanUtils.populate(bean, map);  // 关键
            System.out.println("注入后：" + bean);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
```

3. 在Servlet中进行使用

- 参见12.4的代码

```java
//获取了所有的参数并一次性封装到了对象中
User user = WebUtils.copyParamToBean(req.getParameterMap(),new User()); 
//后续的一些内容需要改成user.set属性
```

## 12.6 用EL表达式修改表单回显 (项目第四阶段)

使用EL表达式修改表达式脚本，来更便捷的输出。

![image-20201204210523247](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201204210523.png)

# 13. MVC （项目第五阶段）

> MVC模式，是一种分层设计的思想。能够有效降低代码耦合，分工明确，将代码进行分离，便于后期维护。
>
> Model：模型。业务逻辑相关的数据封装为具体的 JavaBean 类，其中不掺杂任何与数据处理相关的代码JavaBean/domain/entity/pojo。
>
> View：视图。只负责数据和界面的显示，不接受任何与显示数据无关的代码，便于程序员和前端工程师的分工协作。
>
> Controller：控制器。只负责接收请求，并调用业务层代码，包装数据并派发——Servlet。请求转发或重定向到某个页面。

![image-20201211220523241](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201211220523.png)



> 构建的流程：
>
> 1. 创建图书的javabean
> 2. 图书模块的Dao和对DaoTest
>    - 
> 3. 图书模块的Service与ServiceTest
> 4. 图书模块的Web层
>    - 功能请求





