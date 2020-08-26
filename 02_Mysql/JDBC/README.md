[toc]



---

# JDBC操作数据库



# 1. JDBC概述

-  `JDBC`（**J**ava **D**ata **B**ase **C**onnectivity,  Java数据库连接）
-  是一种用于执行SQL语句的`Java API`，为多种关系数据库提供统一访问**接口**
-  它由一组用`Java`语言编写的类和接口组成

![1537867424205](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200826103609.png)

- 有了JDBC，**程序员只需用JDBC API写一个程序，就可以访问所有数据库**。

![1537867533068](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200826103655.png)

## 1.1 JDBC API

- 提供者：**Sun/oracle公司**
- 内容：**供程序员调用的接口与类**，集成在`java.sql`和`javax.sql`包中，如
- `DriverManager` 类   管理各种不同的 **JDBC驱动**
- `Connection` 接口     连接数据库
- `Statement` 接口      执行SQL
- `ResultSet` 接口       返回结果



## 1.2 JDBC 驱动

- 提供者：**各数据库厂商**
- 作用：  **负责连接和访问各种不同的数据库**



## 1.3 程序员

- 有了JDBC，**程序员只需用 JDBC API 写一个程序，就可以访问所有数据库**。

## 1.4 三方关系

- SUN公司是规范制定者，制定了规范 `JDBC`（连接数据库规范）

- 数据库厂商微软、甲骨文等分别提供**实现 JDBC接口 的 驱动jar包**

- 程序员学习 `JDBC` 规范来**应用这些 jar 包里的类**

  ![1537868017069](C:%5CUsers%5CKeen%5CDesktop%5C%25E8%25B5%2584%25E6%2596%2599%5C13%2520JDBC%5C01%2520JDBC%5C%25E6%2596%2587%25E6%25A1%25A3%5Cimg%5CJDBC03.png)



#  2. 使用 JDBC API 

使用 JDBC API 可做5件事：

- 加载驱动
- 与数据库建立连接
- 发送操作数据库的 `SQL` 语句
- 处理 `SQL` 执行结果
- 释放数据库资源



![1537868466877](C:%5CUsers%5CKeen%5CDesktop%5C%25E8%25B5%2584%25E6%2596%2599%5C13%2520JDBC%5C01%2520JDBC%5C%25E6%2596%2587%25E6%25A1%25A3%5Cimg%5CJDBC04.png)

- `DriverManager` ：依据数据库的不同，管理JDBC驱动
- `Connection` ：负责连接数据库并担任传送数据的任务  
- `Statement` ：由 Connection 产生、负责发送执行SQL语句
- `ResultSet`：负责保存Statement执行后所产生的查询结果

**JDBC访问数据库步骤**

1. 加载一个Driver驱动
2. 创建数据库连接（Connection）
3. 创建SQL命令发送器Statement
4. 通过Statement发送SQL命令并得到结果
5. 处理SQL结果（select语句）
6. 关闭数据库资源

## 2.1 加载驱动

Two versions of MySQL Connector/J are available:

- Connector/J 5.1 is a Type 4 pure Java JDBC driver, which conforms to the JDBC 3.0, 4.0, 4.1, and 4.2 specifications. It provides compatibility with all the functionality of MySQL, including 5.5, 5.6, and 5.7. Connector/J 5.1 provides ease of development features, including auto-registration with the Driver Manager, standardized validity checks, categorized SQLExceptions, support for large update counts, support for local and offset date-time variants from the `java.time` package, support for JDBC-4.x XML processing, support for per connection client information, and support for the [`NCHAR`](https://dev.mysql.com/doc/refman/5.7/en/char.html), [`NVARCHAR`](https://dev.mysql.com/doc/refman/5.7/en/char.html) and `NCLOB` data types.

- Connector/J 8.0 is a Type 4 pure Java JDBC 4.2 driver for the Java 8 platform. It provides compatibility with all the functionality of MySQL 5.5, 5.6, 5.7, 8.0. See [MySQL Connector/J 8.0 Developer Guide](https://dev.mysql.com/doc/connector-j/8.0/en/) for details.



  Note

  MySQL Connector/J 8.0 is highly recommended for use with MySQL Server 8.0, 5.7, 5.6, and 5.5. Please upgrade to MySQL Connector/J 8.0.


The following table summarizes the Connector/J versions available, along with details like their JDBC driver type, what versions of the JDBC API they support, what versions of MySQL Server they work with, and their current development status:

**Table 2.1 Summary of Connector/J Versions**

| Connector/J version | Driver Type | JDBC version       | MySQL Server version  | Status                                           |
| ------------------- | ----------- | ------------------ | --------------------- | ------------------------------------------------ |
| 5.1                 | 4           | 3.0, 4.0, 4.1, 4.2 | 5.5, 5.6*, 5.7*, 8.0* | General availability                             |
| 8.0                 | 4           | 4.2                | 5.5, 5.6, 5.7, 8.0    | General availability.    **Recommended version** |

驱动5.1版本对应mysql版本5.5, 5.6*, 5.7*, 8.0*。

驱动8.0版本对应mysql版本5.5, 5.6, 5.7, 8.0。

使用上建议：

- 5.6版本的mysql；5.1版本的jdbc
- 使用8.0+版本的mysql需要注意，配置不方便
- <font color='red'>使用8.0的版本的jdbc时，驱动加载位置为：Class.forName("com.mysql.cj.jdbc.Driver");并且url字符串要设定时区。</font>

\* **JRE 1.8.x is required for Connector/J 5.1 to connect to MySQL 5.6, 5.7, and 8.0 with SSL/TLS when using some cipher suites**.

The current recommended version for Connector/J is 5.1. This guide also covers earlier versions of Connector/J, with specific notes given where a setting applies to a specific version.



驱动包下载地址：https://dev.mysql.com/downloads/connector/j/

- 通常使用maven来导入jdbc包

  ```xml
  <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.16</version>
  </dependency>
  
  <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>5.1.47</version>
  </dependency>
  ```

```java
// 下面列出常用的几种数据库驱动程序加载语句的形式 
Class.forName("oracle.jdbc.driver.OracleDriver"); //Oracle的JDBC驱动程序 
Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver"); //SQL Server
Class.forName("com.ibm.db2.jdbc.app.DB2Driver");//DB2的JDBC驱动程序 
Class.forName("com.mysql.jdbc.Driver"); //使用MySql的JDBC驱动程序

Class.forName("com.mysql.cj.jdbc.Driver"); //8.0版本的jdbc
```

## 2.2 获取数据库连接

```java
// DriverManager.getConnection(String url, String user, String password)方法
// String url = "jdbc:oracle:thin:@localhost:1521:orcl";
String url = "jdbc:mysql://localhost:3306/mydb";
String user="root";
String password="123456";
Connection conn = DriverManager.getConnection(url, user, password);
```

## 2.3 执行SQL

`Statement` 对象用于将 SQL 语句发送到数据库中，或者理解为执行 SQL 语句

有三种 Statement对象：

- `Statement`：用于执行不带参数的**简单SQL语句**；  会出现sql注入的风险
- `PreparedStatement`（从Statement 继承）：用于执行带参或不带参数的**预编译SQL语句**；避免了sql注入及字符串拼接。
  - setInt(1,"   ")
  - setString(2,"    ")
  - <font color='red'>需要注意，Statement是在execute时候传入sql，而PreparedStatement则是在对象初始化时传入预编译的sql。</font>
- `CallableStatement`（从PreparedStatement 继承）：用于执行数据库存储过程的调用;

![1537869111499](C:%5CUsers%5CKeen%5CDesktop%5C%25E8%25B5%2584%25E6%2596%2599%5C13%2520JDBC%5C01%2520JDBC%5C%25E6%2596%2587%25E6%25A1%25A3%5Cimg%5CJDBC05.png)



## 2.4 处理结果集

- `ResultSet` 对象是 `executeQuery()` 方法的返回值，它被称为**结果集**，它代表符合SQL语句条件的所有行，并且它通过一套 `getXXX` 方法（这些get方法可以访问当前行中的不同列）提供了对这些行中数据的访问。
- `ResultSet` 里的数据一行一行排列，每行有多个字段，且有一个记录指针，指针所指的数据行叫做当前数据行，我们只能来操作当前的数据行。**我们如果想要取得某一条记录，就要使用 ResultSet 的 next() 方法** ,如果我们想要得到ResultSet里的**所有记录**，就应该使用 `while` 循环。
- `ResultSet` 对象自动维护指向**当前数据行的游标**。**每调用一次 next() 方法，游标向下移动一行**。 
- **初始状态下记录指针指向第一条记录的前面**，通过next()方法指向第一条记录。
- 循环完毕后指向最后一条记录的后面。

![1537869396570](C:%5CUsers%5CKeen%5CDesktop%5C%25E8%25B5%2584%25E6%2596%2599%5C13%2520JDBC%5C01%2520JDBC%5C%25E6%2596%2587%25E6%25A1%25A3%5Cimg%5CJDBC06.png)

## 2.5 释放资源

- 作为一种好的编程风格，应在不需要 `Statement` 对象和 `Connection` 对象时显式地**关闭**它们。关闭Statement对象和Connection对象的语法形式为：
  - public void close() throws SQLException
- **用户不必关闭ResultSet**。当它的 Statement 关闭、重新执行或用于从多结果序列中获取下一个结果时，该ResultSet将被自动关闭
- **<font color='red'>注意：要按先ResultSet结果集，后Statement，最后Connection的顺序关闭资源，因为Statement和ResultSet是需要Connection才可以使用的，所以在使用结束之后有可能其他的Statement还需要连接，所以不能先关闭Connection</font>**

```java
//Class.forName("com.mysql.jdbc.Driver");
Class.forName("com.mysql.cj.jdbc.Driver");
String url = 
    "jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&serverTimezone=Asia/Shanghai";
String username = "root";
String password = "123456";
Connection conn = DriverManager.getConnection(url,username,password);
Statement st = conn.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM t_student");
while (rs.next()){
    System.out.println("id：" + rs.getInt("id"));
    System.out.println("生日：" + rs.getDate("birthday"));
    System.out.println("生日：" + rs.getTime("birthday"));
    System.out.println("生日：" + rs.getTimestamp("birthday"));
}
rs.close();
st.close();
conn.close();
```



# 3. 编程细节

## 3.1 JDBC日期和时间处理

 ```java
pst.setObject(7,"2020-10-19 18:20:30"); //设置字符串=》对应数据库中应该为varchar类型
// 只能设置日期，不能设置时间；=》对应数据库中应该为date类型 这里的Date来自java.sql.Date,而不是来自java.util.Date
pst.setDate(7, new Date(System.currentTimeMillis()));
// 只能设置时间，不能设置日期；=》对应数据库中应该为time类型
pst.setTime(7,new Time(System.currentTimeMillis()));
// 可以同时设置日期，也可以设置时间。=》对应数据库中应该为timestamp类型
pst.setTimestamp(7,new Timestamp(System.currentTimeMillis()));
 ```

> 参见：JDBCTest03.java

# 4. DBUtil工具类

## 4.1 DBUtil案例

> 参见：code\jdbc\DBUtil_v1.java

```java
package day11.util;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**
 * 获取数据连接
 * 释放资源
 */
public class DBUtil {

    private static Properties prop = new Properties();

    static {
        try {
            					prop.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
            // 加载数据库驱动(可以省略)
            Class.forName(prop.getProperty("driverClassName"));
        } catch (Exception e) {
            System.out.println("加载db.properties配置文件信息异常....");
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Connection getConnection() {

        Connection conn = null;
        try {
            String url = prop.getProperty("url");
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("获取数据库连接异常...");
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 释放资源
     *
     * @param conn
     * @param st
     */
    public static void close(Connection conn, Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
```

 

## 4.2 application.properties 数据库配置文件

```properties
# mysql数据库连接信息
driverClassName=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=Asia/Shanghai
username=root
password=123456
```



# 5. 数据库连接池

直接使用jdbc进行连接的坏处：

- 获取数据库连接是一个较耗时的操作
- 数据库的最大连接数量是有限的

```bash
查询数据库当前设置的最大连接数：

show variables like '%max_connections%';  # 在登入mysql后 mysql -uroot -p123456
```

## 5.1 数据库连接池的作用

- 数据库连接池负责分配、管理和释放数据库连接，它允许应用程序重复使用一个现有的数据库连接，而不是再重新建立一个；
- 释放空闲时间超过最大空闲时间的数据库连接，来避免因为没有释放数据库连接而引起的数据库连接遗漏。这项技术能明显提高对数据库操作的性能。

常见的三种数据库连接池：

	1. C3P0
 	2. DBCP
 	3. Druid 阿里巴巴：能够起到数据库连接池作用及监控数据库连接的作用。

## 5.2 连接池原理

- 目的：解决建立数据库连接耗费资源和时间很多的问题，提高性能。



![image-20200826195053056](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200826195739.png)

![image-20200826195732100](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200826195732.png)



## 5.4 Druid数据库连接池

​		阿里巴巴推出的国产数据库连接池，据网上测试对比，比目前的DBCP或C3P0数据库连接池性能更好，Druid与其他数据库连接池使用方法基本一样（与DBCP非常相似），将数据库的连接信息全部配置给DataSource对象(也称其为数据库连接池);

> 代码参考：DruidTest01.java
>
> ​					PoolTest01.java

```java
// 从数据源工厂获取数据库连接池对象
Properties prop = new Properties();
InputStream in = DataSourceTest01.class.getClassLoader().getResourceAsStream("application.properties");
prop.load(in);
in.close();
DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);  //加载后会自动赋值，不再需要dataSource.setUrl() 类似操作
Connection conn = dataSource.getConnection();
```

- 此时需要application.properties的key-value中的key与DruidDataSourceFactory数据库连接池工厂中的静态常量保持一致。

```properties
driverClassName=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/myapp?useSSL=false&serverTimezone=Asia/Shanghai
username=root
password=123456
maxActive=10
initialSize=5
minIdle=3
maxWait=10000
```

## 5.5 Druid配置参考

```properties
#数据库基本信息配置
driverClassName = oracle.jdbc.driver.OracleDriver
url = jdbc:oracle:thin:@127.0.0.1:1521:ORCL
username = ******
password = ******

#初始化连接数量
initialSize = 5

#最大并发连接数 
maxActive = 10

#最大空闲连接数
maxIdle

#最小空闲连接数
minIdle = 3

#配置获取连接等待超时的时间
maxWait = 60000

#超过时间限制是否回收
removeAbandoned = true

#超过时间限制多长回收
removeAbandonedTimeout = 180

#配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
timeBetweenEvictionRunsMillis = 60000

#配置一个连接在池中最小生存的时间，单位是毫秒
minEvictableIdleTimeMillis = 300000

#用来检测连接是否有效的sql，要求是一个查询语句
validationQuery = SELECT 1 FROM DUAL

#申请连接的时候检测
testWhileIdle = true 

#申请连接时执行validationQuery检测连接是否有效，配置为true会降低性能
testOnBorrow = false

#归还连接时执行validationQuery检测连接是否有效，配置为true会降低性能
testOnReturn = false

#打开PSCache，并且指定每个连接上PSCache的大小
poolPreparedStatements = true
maxPoolPreparedStatementPerConnectionSize = 50

属性类型是字符串，通过别名的方式配置扩展插件，常用的插件有：  				
				监控统计用的filter:stat
				日志用的filter:log4j
 				防御SQL注入的filter:wall
filters = stat
```

## 5.6 完整过程参照下边代码

>参考代码：DBUtil_v2.java

```java
public class DBUtil_v2 {

    private static DataSource dataSource;
    
    static {
        try {
            // 完成数据库连接池的初始化
            Properties prop = new Properties();
            InputStream in = DBUtil_v2.class.getClassLoader().getResourceAsStream("application.properties");
            prop.load(in);
            in.close();
            // 创建数据库连接池
            dataSource = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return conn;
    }

    public static void close(Connection conn, Statement st) {
        if(st!=null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static void close(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(conn, st);
    }
}
```





