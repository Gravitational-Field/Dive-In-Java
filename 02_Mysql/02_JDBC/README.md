<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [JDBC操作数据库](#jdbc%E6%93%8D%E4%BD%9C%E6%95%B0%E6%8D%AE%E5%BA%93)
- [1. JDBC概述](#1-jdbc%E6%A6%82%E8%BF%B0)
  - [1.1 JDBC API](#11-jdbc-api)
  - [1.2 JDBC 驱动](#12-jdbc-%E9%A9%B1%E5%8A%A8)
  - [1.3 程序员](#13-%E7%A8%8B%E5%BA%8F%E5%91%98)
  - [1.4 三方关系](#14-%E4%B8%89%E6%96%B9%E5%85%B3%E7%B3%BB)
- [2. 使用 JDBC API](#2-%E4%BD%BF%E7%94%A8-jdbc-api)
  - [2.1 加载驱动](#21-%E5%8A%A0%E8%BD%BD%E9%A9%B1%E5%8A%A8)
  - [2.2 获取数据库连接](#22-%E8%8E%B7%E5%8F%96%E6%95%B0%E6%8D%AE%E5%BA%93%E8%BF%9E%E6%8E%A5)
  - [2.3 执行SQL](#23-%E6%89%A7%E8%A1%8Csql)
  - [2.4 处理结果集](#24-%E5%A4%84%E7%90%86%E7%BB%93%E6%9E%9C%E9%9B%86)
  - [2.5 释放资源](#25-%E9%87%8A%E6%94%BE%E8%B5%84%E6%BA%90)
- [3. 编程细节](#3-%E7%BC%96%E7%A8%8B%E7%BB%86%E8%8A%82)
  - [3.1 JDBC日期和时间处理](#31-jdbc%E6%97%A5%E6%9C%9F%E5%92%8C%E6%97%B6%E9%97%B4%E5%A4%84%E7%90%86)
- [4. DBUtil工具类](#4-dbutil%E5%B7%A5%E5%85%B7%E7%B1%BB)
  - [4.1 DBUtil案例](#41-dbutil%E6%A1%88%E4%BE%8B)
  - [4.2 application.properties 数据库配置文件](#42-applicationproperties-%E6%95%B0%E6%8D%AE%E5%BA%93%E9%85%8D%E7%BD%AE%E6%96%87%E4%BB%B6)
- [5. 数据库连接池](#5-%E6%95%B0%E6%8D%AE%E5%BA%93%E8%BF%9E%E6%8E%A5%E6%B1%A0)
  - [5.1 数据库连接池的作用](#51-%E6%95%B0%E6%8D%AE%E5%BA%93%E8%BF%9E%E6%8E%A5%E6%B1%A0%E7%9A%84%E4%BD%9C%E7%94%A8)
  - [5.2 连接池原理](#52-%E8%BF%9E%E6%8E%A5%E6%B1%A0%E5%8E%9F%E7%90%86)
  - [5.4 Druid数据库连接池](#54-druid%E6%95%B0%E6%8D%AE%E5%BA%93%E8%BF%9E%E6%8E%A5%E6%B1%A0)
  - [5.5 Druid配置参考](#55-druid%E9%85%8D%E7%BD%AE%E5%8F%82%E8%80%83)
  - [5.6 完整过程参照下边代码](#56-%E5%AE%8C%E6%95%B4%E8%BF%87%E7%A8%8B%E5%8F%82%E7%85%A7%E4%B8%8B%E8%BE%B9%E4%BB%A3%E7%A0%81)
- [6. 数据库中的事务](#6-%E6%95%B0%E6%8D%AE%E5%BA%93%E4%B8%AD%E7%9A%84%E4%BA%8B%E5%8A%A1)
  - [6.1 Mysql中的事务](#61-mysql%E4%B8%AD%E7%9A%84%E4%BA%8B%E5%8A%A1)
  - [6.2 Oracle中的事务](#62-oracle%E4%B8%AD%E7%9A%84%E4%BA%8B%E5%8A%A1)
  - [6.3 JDBC控制事务](#63-jdbc%E6%8E%A7%E5%88%B6%E4%BA%8B%E5%8A%A1)
  - [6.4 数据库事务的ACID特性](#64-%E6%95%B0%E6%8D%AE%E5%BA%93%E4%BA%8B%E5%8A%A1%E7%9A%84acid%E7%89%B9%E6%80%A7)
  - [6.5 数据库事务的隔离级别](#65-%E6%95%B0%E6%8D%AE%E5%BA%93%E4%BA%8B%E5%8A%A1%E7%9A%84%E9%9A%94%E7%A6%BB%E7%BA%A7%E5%88%AB)
  - [6.6 JDBC中控制事务的隔离级别](#66-jdbc%E4%B8%AD%E6%8E%A7%E5%88%B6%E4%BA%8B%E5%8A%A1%E7%9A%84%E9%9A%94%E7%A6%BB%E7%BA%A7%E5%88%AB)
- [7. DBUtils](#7-dbutils)
  - [7.1 概述](#71-%E6%A6%82%E8%BF%B0)
  - [7.2 QueryRunner类](#72-queryrunner%E7%B1%BB)
  - [7.3 ResultSetHandler结果集处理接口](#73-resultsethandler%E7%BB%93%E6%9E%9C%E9%9B%86%E5%A4%84%E7%90%86%E6%8E%A5%E5%8F%A3)
  - [7.4 案例](#74-%E6%A1%88%E4%BE%8B)
    - [7.4.1 没有对象关系映射时的复杂情况演示](#741-%E6%B2%A1%E6%9C%89%E5%AF%B9%E8%B1%A1%E5%85%B3%E7%B3%BB%E6%98%A0%E5%B0%84%E6%97%B6%E7%9A%84%E5%A4%8D%E6%9D%82%E6%83%85%E5%86%B5%E6%BC%94%E7%A4%BA)
    - [7.4.2 QuerryRunner的使用演示实例 + 各种不同类型的结果集处理](#742-querryrunner%E7%9A%84%E4%BD%BF%E7%94%A8%E6%BC%94%E7%A4%BA%E5%AE%9E%E4%BE%8B--%E5%90%84%E7%A7%8D%E4%B8%8D%E5%90%8C%E7%B1%BB%E5%9E%8B%E7%9A%84%E7%BB%93%E6%9E%9C%E9%9B%86%E5%A4%84%E7%90%86)
    - [7.4.3 封装QuerryRunner操作,并测试](#743-%E5%B0%81%E8%A3%85querryrunner%E6%93%8D%E4%BD%9C%E5%B9%B6%E6%B5%8B%E8%AF%95)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

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

  ![](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200829082804.png)



#  2. 使用 JDBC API 

使用 JDBC API 可做5件事：

- 加载驱动
- 与数据库建立连接
- 发送操作数据库的 `SQL` 语句
- 处理 `SQL` 执行结果
- 释放数据库资源



![](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201118191533.png)



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

![1537869111499](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201118191534.png)





## 2.4 处理结果集

- `ResultSet` 对象是 `executeQuery()` 方法的返回值，它被称为**结果集**，它代表符合SQL语句条件的所有行，并且它通过一套 `getXXX` 方法（这些get方法可以访问当前行中的不同列）提供了对这些行中数据的访问。
- `ResultSet` 里的数据一行一行排列，每行有多个字段，且有一个记录指针，指针所指的数据行叫做当前数据行，我们只能来操作当前的数据行。**我们如果想要取得某一条记录，就要使用 ResultSet 的 next() 方法** ,如果我们想要得到ResultSet里的**所有记录**，就应该使用 `while` 循环。
- `ResultSet` 对象自动维护指向**当前数据行的游标**。**每调用一次 next() 方法，游标向下移动一行**。 
- **初始状态下记录指针指向第一条记录的前面**，通过next()方法指向第一条记录。
- 循环完毕后指向最后一条记录的后面。

![1537869396570](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201118191535.png)



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



![image-20200826195053056](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201118191536.png)

![image-20200826195732100](https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20201118191537.png)



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



# 6. 数据库中的事务

**事务：**事务指逻辑上的一组操作，组成这组操作的各个单元，要么全部成功，要么全部不成功。

例如：A——B转帐，对应于如下两条sql语句

update account set money=money-100 where name=‘A’;

update account set money=money+100 where name=‘B’;

但mysql默认一句sql语句会当做一个事务，完成后会自动提交该事务，所以对于上面的案例需要手动来确定一项事务的开启与关闭。



## 6.1 Mysql中的事务

mysql的默认引擎是INNODB，支持事务。

- mysql默认自动提交事务。每条语句都处在单独的事务中。

- 手动控制事务
  - 开启事务：start transaction
  - 提交事务：commit
  - 回滚事务：rollback  提交后无法回滚



## 6.2 Oracle中的事务

Oracle不需要特别的去指定事务的开始和结束。一个事务的结束就是下一个事务的开始

开启事务：

1、连接到数据库，并执行第一条DML语句（insert delete update）

2、前一个事务结束后，又输入了另一条DML语句

提交事务：commit

回滚事务：rollback



## 6.3 JDBC控制事务

​		当Jdbc程序向数据库获得一个Connection对象时，默认情况下这个Connection对象会自动向数据库提交在它上面发送的SQL语句。若想关闭这种默认提交方式，让多条SQL在一个事务中执行，可使用下列语句：

JDBC控制事务语句：

- conn.setAutoCommit(false); // 开启事物  手动管理事务

- conn.rollback();  // rollback 回滚

- conn.commit();  //  commit 提交事务

> 代码参考：03_transaction/TxTest01.java

```java
package com.imcode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 事务控制
 * 手动控制事务
 *
 * 在需要事务控制的SQL执行之前调用  conn.setAutoCommit(false);
 * SQL语句如果全部执行正确 提交事务  conn.commit();
 * 如果出现异常  回滚事务   conn.rollback();
 * 最后释放资源  conn.close(); 如果有未提交的事务，提交事务，关闭数据库连接
 */
public class JDBCDemo04 {

    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        try {
            String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
            String username = "app";
            String password = "123456";
            conn = DriverManager.getConnection(url, username, password);
            // 关闭事务的自动提交 手动控制事务
            conn.setAutoCommit(false);

            st = conn.createStatement();
            // 执行转账的动作
            String sql1 = "UPDATE T_ACCOUNT SET MONEY = MONEY - 500 WHERE ACCOUNT='JACK'";
            String sql2 = "UPDATE T_ACCOUNT SET MONEY = MONEY + 500 WHERE ACCOUNT='ROSE'";

            st.executeUpdate(sql1);
            st.executeUpdate(sql2);
            System.out.println("转账已经成功 已经成功 已经成功");
            // 手动提交事务
            conn.commit();

            System.out.println("给两个账户发送成功消息通知");
            int i = 100 / 0;
        } catch (Exception e) {
            // 如果出现异常回滚事务
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();// 关闭连接的时候事务自动提交
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
```

## 6.4 数据库事务的ACID特性

- 原子性（Atomicity）
  - 指事务是一个不可分割的工作单位，事务中的操作要么都发生，要么都不发生。 
- 持久性（Durability）
  - 指一个事务一旦被提交，它对数据库中数据的改变就是永久性的，接下来即使数据库发生故障也不应该对其有任何影响。
- 隔离性（Isolation）
  - 一个事务的执行不被另一个事务的执行干扰。
  - 事务的隔离性是多个用户并发访问数据库时，数据库为每一个用户开启的事务，不能被其他事务的操作数据所干扰，多个并发事务之间要相互隔离。
- 一致性（Consistency）
  - 通过实现原子性、持久性与隔离性来满足数据库事务的
  - 事务必须使数据库从一个一致性状态变换到另外一个一致性状态。转账前和转账后的总金额不变。为了保证一致性，在进行一项事务时，当发生异常时可以进行回滚；当数据被commit后，对数据库永久性改变，通过设置事务隔离级别来满足具体的业务需求，保证事务进行前后的数据库的稳定。



## 6.5 数据库事务的隔离级别

**隔离级别：**并行事务间的隔离程度。

- 两个并行事务同时访问数据库表相同行时可能出现三个问题：

1. **脏读：**<font color='red'>**危险**</font> 

   ​    事务T1读到了事务T2做出了修改但未提交的数据，若此时T2进行回滚操作，取消修改，此时T1读取的行无效，即为脏数据，也称作脏读。

2. **不可重复读:**  <font color='red'>**（update）**</font>

   ​    事务T1读取了一条记录，事务T2进行更新操作并提交后，事务1再次查询，发现与第一次读取的记录发生改变，也就是发生了不可重复读的问题。

3. **幻读:**  <font color='red'>**（insert或delete）**</font>

   ​	事务T1读取到满足where条件的结果集，事务T2进行insert或者delete了满足T1查询条件的记录，并进行了提交后，事务T1再次查询，可以看到事务T2中新insert或看不到新delete后的记录，新记录即为幻读。

   

**四种隔离级别：<font color='red'>级别逐渐严格</font>**

|  级别  | 名称                      | 特性                                     | 补充                                            |
| :----: | :------------------------ | ---------------------------------------- | ----------------------------------------------- |
| 第一级 | 读未提交 READ UNCOMMITTED | 幻读、不可重复读和脏读都允许；           | 主流数据库都不会设置为这个隔离级别。            |
| 第二级 | 读提交 READ COMMITTED     | 允许幻读、允许不可重复读，不允许脏读；   | oracle默认隔离界别，避免了脏读。                |
| 第三级 | 可重复读 REPEATABLE READ  | 允许幻读，不允许不可重复读，不允许脏读； | mysql默认隔离界别，避免了脏读与不可重复读问题。 |
| 第四级 | 可串行化 SERIALIZABLE     | 幻读、不可重复读和脏读都不允许；         | 挖没钱买的隔离，非常安全。                      |

<font color='red'>PS : 级别越高，性能要求越高，数据库开销越大，数据越安全。</font>

- 案例

| 时间 | 线程1 事物1                                    | 线程2 事物2                                                  | 说明                                                         |
| ---- | ---------------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| t1   | begin;                                         |                                                              |                                                              |
| t2   | select * from account where name='A';结果200块 |                                                              |                                                              |
| t3   |                                                | begin;                                                       |                                                              |
| t4   |                                                | update account set money=money+100 where name='A';           |                                                              |
| t5   | select * from account where name='A';结果300块 |                                                              | 读到了另一个线程未提交事务的数据。***\*赃读\****发生了       |
| t6   |                                                | commit;                                                      |                                                              |
| t7   | select * from account where name='A';结果300块 |                                                              | 读到了另一个线程提交事务的update数据。***\*不可重复读\****发生了 |
| t8   |                                                | insert into account values('C',1000);执行insert语句插入数据，事务自动提交了 |                                                              |
| t9   | select * from account;查到4条数据              |                                                              | 读到了另一个线程自动提交事务的insert语句数据。***\*幻读\****发生了 |
| t10  | commit;                                        |                                                              |                                                              |

- 讲解

```bash
时间1: T1开启事务
    时间2:	T2开启事务
		时间3:	执行修改
		时间4:	执行新增
		时间5: 	
				READ UNCOMMITTED 
					T1 查询到了 T2新增和修改的数据	-- 脏读				
				READ COMMITTED
					T1 查询不到 T2新增和修改数据
				REPEATABLE READ
					T1 查询不到 T2新增和修改数据
				SERIALIZABLE 
					T1 查询不到 T2新增和修改数据		
	时间6: 	T2提交事务
		时间7: 
				READ COMMITTED(Oracle)
					T1查询到了T2新增的后数据	-- 幻读	bash	    
					T1查询到了T2修改的后数据	-- 不可重复读	
				REPEATABLE READ(MySQL)
					T1查询到了T2新增的后数据	-- 幻读	
					T1查询不到T2修改的后数据	-- 可重复读	   	
				SERIALIZABLE 
				    T1查询不到T2新增的后数据
					T1查询不到T2修改的后数据
时间8: T1关闭事务

时间9: T3开启事务

    READ UNCOMMITTED、READ COMMITTED、REPEATABLE READ、SERIALIZABLE
	四种隔离级别 均可以查询到T2新增和修改后的数据
	
如果查询操作没有在事务中，只能查询到其它事务提交事务后的数据。a
```



- 查询事务隔离级别：

  ```mysql
  show variables like '%isolation%';
  
  select @@global.tx_isolation, @@tx_isolation;
  ```

- 修改隔离级别

```mysql
-- [GLOBAL | SESSION] 可选择对全局有效还是对当前会话有效
SET [GLOBAL | SESSION] TRANSACTION ISOLATION LEVEL  
  {
       REPEATABLE READ
     | READ COMMITTED
     | READ UNCOMMITTED
     | SERIALIZABLE
   }
```



## 6.6 JDBC中控制事务的隔离级别

Connection接口的设置隔离级别的方法：

<img src="https://cdn.jsdelivr.net/gh/lizhangjie316/img/2020/20200828215351.png" alt="image-20200828215351907" style="zoom:150%;" />

**<font color='red'>PS: 设置隔离级别必须在开启事务之前</font>**  即在conn.setAutoCommit(false);之前 conn.setTransactionIsolation(int level);

# 7. DBUtils

**<font color=red>存在的必要性在于解决数据库表与Bean实体之间的映射繁琐问题</font>**

## 7.1 概述

DBUtils是java编程中的数据库操作实用工具，小巧简单实用。

DBUtils封装了对JDBC的操作，简化了JDBC操作，可以少写代码。

**Dbutils核心类和接口：**

- QueryRunner中提供对sql语句操作的API.  

- ResultSetHandler接口，用于定义select操作后，怎样封装结果集.

https://mvnrepository.com/artifact/commons-dbutils/commons-dbutils

```xml
<!-- https://mvnrepository.com/artifact/commons-dbutils/commons-dbutils -->
<dependency>
    <groupId>commons-dbutils</groupId>
    <artifactId>commons-dbutils</artifactId>
    <version>1.7</version>
</dependency>
```



## 7.2 QueryRunner类

- update(String sql, Object... params) ，用来完成表数据的增加、删除、更新操作。 **不能事务控制**
- update(Connection conn, String sql, Object... params) ， **可以进行事务控制**
- query(String sql, ResultSetHandler<T> rsh, Object... params) ， 用来完成表数据的查询操作。  **不能事务控制**

- query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) ，**可以进行事务控制**

**<font color='red'>只要获得了conn连接，即可以进行事务控制。</font>**

> 参见代码：04_DBUtils/DbutilsTest01.java    为没有对象关系映射时的复杂情况演示。
>
> ​				    04_DBUtils/DbutilsTest02.java    为QuerryRunner的使用演示实例
>
> ​					04_DBUtils/DbutilsTest03.java(测试封装的操作)  +   04_DBUtils/DBUtil.java(封装好的QuerryRunner操作)

- [为没有对象关系映射时的复杂情况演示](Code/04_DBUtils/DbutilsTest01.java)
- [为QuerryRunner的使用演示实例](Code/04_DBUtils/DbutilsTest02.java)
- [测试封装QuerryRunner的操作](Code/04_DBUtils/DbutilsTest03.java)  +  [封装QuerryRunner的操作](Code/04_DBUtils/04_DBUtils/DBUtil.java) 

```java
// 映射关系的建立，不是通过对象的属性名称和数据库列名建立映射
// 而是通过setXxx() 方法来建立映射
// setXxx  去掉set  将第一个X 转小写，去和数据库的列名匹配
// setCreate_time -- > create_time
```



## 7.3 ResultSetHandler结果集处理接口

| ResultSetHandler接口的实现类 |                                                              |
| ---------------------------- | ------------------------------------------------------------ |
| ArrayHandler                 | 将结果集中的第一条记录封装到一个Object[]数组中，数组中的每一个元素就是这条记录中的每一个字段的值 |
| ArrayListHandler             | 将结果集中的每一条记录都封装到一个Object[]数组中，将这些数组在封装到List集合中。 |
| BeanHandler                  | 将结果集中第一条记录封装到一个指定的javaBean中。             |
| BeanListHandler              | 将结果集中每一条记录封装到指定的javaBean中，将这些javaBean在封装到List集合中 |
| ScalarHandler                | 它是用于单数据。例如select count(*) from 表操作。            |
| ColumnListHandler            | 将结果集中指定的列的字段值，封装到一个List集合中             |
| MapHandler                   | 将结果集第一行封装到Map集合中,Key 列名, Value 该列数据       |
| MapListHandler               | 将结果集封装到Map集合中,Key 列名, Value 该列数据,Map集合存储到List集合 |



## 7.4 案例

### 7.4.1 没有对象关系映射时的复杂情况演示

```java
public class DbutilsTest01 {

    @Test
    public void test01() {
        User user = getById(1);
        System.out.println(user);
    }

    public User getById(Integer userId) {
        // 通过id查询用户详细信息
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            // 1.获取数据库连接
            conn = DBUtil.getConnection();
            // 2.获取sql执行对象
            pst = conn.prepareStatement("SELECT * FROM t_user WHERE id = ?");
            // 3.设置参数
            pst.setInt(1, userId);
            // 4.获取结果集
            rs = pst.executeQuery();
            // 5.处理结果集
            if (rs.next()) {
                Integer id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String mobile = rs.getString("mobile");
                Date createTime = rs.getDate("create_time");
                Date updateTime = rs.getDate("update_time");
                User user = new User();
                user.setId(id);
                user.setUsername(username);
                user.setPassword(password);
                user.setEmail(email);
                user.setMobile(mobile);
                user.setCreateTime(createTime);
                user.setUpdateTime(updateTime);
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6.释放资源
            DBUtil.close(conn, pst, rs);
        }
        return null;
    }
}
```

### 7.4.2 QuerryRunner的使用演示实例 + 各种不同类型的结果集处理

```java
public class DbutilsTest02 {

    @Test
    public void test01() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        Connection conn = DBUtil.getConnection();
        // 如果手动传入数据库连接，需要手动关闭
        queryRunner.update(conn, "DELETE FROM t_user WHERE id = 2");
        DBUtil.close(conn);
    }

    @Test
    public void test02() {
        QueryRunner queryRunner = new QueryRunner();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            queryRunner.update(conn, "UPDATE t_account SET money = money - 100 WHERE account='A'");
            queryRunner.update(conn, "UPDATE t_account SET money = money + 100 WHERE account='B'");
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
    }

    @Test
    public void test03() throws SQLException {
        // QueryRunner 从数据源获取数据库连接，不需要程序手动控制连接
        // 程序员不需要维护数据库连接，不能手动控制事务
        QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
        queryRunner
                .update("UPDATE t_account SET money = money - 100 WHERE account='A'");
    }

    @Test
    public void test04() throws SQLException {
        // QueryRunner 从数据源获取数据库连接，不需要程序手动控制连接
        // 程序员不需要维护数据库连接，不能手动控制事务
        QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
        queryRunner
                .update("UPDATE t_user SET password = ? WHERE username = ? AND email = ?",
                        "111111", "admin", "admin@126.com");
    }


    @Test
    public void test05() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
        String sql
                = "SELECT id,username,password,email,mobile, create_time createTime, update_time updateTime FROM t_user WHERE id=1";
        User user = queryRunner.query(sql, new BeanHandler<User>(User.class));
        System.out.println(user);
        // 映射关系的建立，不是通过对象的属性名称和数据库列名建立映射
        // 而是通过setXxx() 方法来建立映射
        // setXxx  去掉set  将第一个X 转小写，去和数据库的列名匹配
        // setCreate_time -- > create_time
    }

    @Test
    public void test06() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
        String sql
                = "SELECT id,username,password,email,mobile, create_time createTime, update_time updateTime FROM t_user";
        List<User> list = queryRunner.query(sql, new BeanListHandler<User>(User.class));
        System.out.println(list);
    }

    @Test
    public void test07() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
        String sql
                = "SELECT * FROM t_user WHERE id=1";
        Object[] arr = queryRunner.query(sql, new ArrayHandler());
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test08() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
        String sql
                = "SELECT * FROM t_user";
        List<Object[]> list = queryRunner.query(sql, new ArrayListHandler());
        for (Object[] arr : list) {
            System.out.println(Arrays.toString(arr));
        }
    }


    @Test
    public void test09() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
        String sql
                = "SELECT * FROM t_user WHERE id=1";
        Map<String,Object> map = queryRunner.query(sql,new MapHandler());
        for (String key : map.keySet()) {
            System.out.println(key + "-->" + map.get(key));
        }
    }

    @Test
    public void test10() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
        String sql
                = "SELECT * FROM t_user";
        List<Map<String,Object>> list = queryRunner.query(sql,new MapListHandler());
        for (Map<String,Object> map : list) {
            for (String key : map.keySet()) {
                System.out.print(key + ":" + map.get(key) + "\t");
            }
            System.out.println();
        }
    }

    /**
    * @author: keen
    * @Date: 2020/8/29 19:01
    * @Description:查询一列数据
    */
    @Test
    public void test11() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
        //java.lang.Long cannot be cast to java.lang.Integer
        String sql
                = "SELECT count(*) FROM t_user";
        Long count = queryRunner.query(sql, new ScalarHandler<Long>());
        System.out.println(count);
    }

    /**
    * @author: keen
    * @Date: 2020/8/29 19:10
    * @Description:返回sql指定列第一行的数据 （默认是第一列）
    */
    @Test
    public void test12() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
        String sql
                = "SELECT * FROM t_user ORDER BY id desc";
        String username = queryRunner.query(sql, new ScalarHandler<String>("username"));
        System.out.println(username);
    }


//select count(*) from t_table;  结果集是单列一条
//SELECT username FROM t_user

    /**
    * @author: keen
    * @Date: 2020/8/29 19:13
    * @Description:结果集中指定列的字段值封装到List集合中
    */
    @Test
    public void test13() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
        String sql
                = "SELECT username FROM t_user";
        List<String> list = queryRunner.query(sql,new ColumnListHandler<String>());
        System.out.println(list);

    }

    @Test
    public void test14() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
        String sql
                = "SELECT * FROM t_user";
        List<String> list = queryRunner.query(sql,new ColumnListHandler<String>("email"));
        System.out.println(list);
    }
}
```

### 7.4.3 封装QuerryRunner操作,并测试

- **封装**

```java
public class DBUtil {
    private static DataSource dataSource;
    private static QueryRunner queryRunner;

    static {
        try {
            // 完成数据库连接池的初始化
            Properties prop = new Properties();
            InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("application.properties");
            prop.load(in);
            in.close();
            // 创建数据库连接池
            dataSource = DruidDataSourceFactory.createDataSource(prop);
            queryRunner = new QueryRunner(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回单个对象
     */
    public static <T> T queryOne(Class<? extends T> type, String sql, Object... params) {
        try {
            return queryRunner.query(sql, new BeanHandler<T>(type), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 返回对象的集合
     */
    public static <T> List<T> queryList(Class<? extends T> type, String sql, Object... params) {
        try {
            return queryRunner.query(sql, new BeanListHandler<T>(type), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 自动提交事务的新增、修改、删除
     */
    public static void update(String sql, Object... params) {
        try {
            queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
    * @author: keen
    * @Date: 2020/8/30 9:46
    * @Description:带事务的增、删、改
    */
    public static void update(Connection conn, String sql, Object... params) {
        try {
            queryRunner.update(conn, sql, params);
        } catch (SQLException e) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection conn, Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(conn);
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

- **测试使用**

```java
public class DbutilsTest03 {

    @Test
    public void test01() throws SQLException {
        String sql = "SELECT * FROM t_user WHERE id = ?";
        User user = DBUtil.queryOne(User.class, sql, 1);
        System.out.println(user);
    }

    @Test
    public void test02() throws SQLException {
        String sql = "SELECT * FROM t_user WHERE email=? and mobile=?";
        User user = DBUtil.queryOne(User.class, sql, "admin@126.com", "13888888888");
        System.out.println(user);
    }

    @Test
    public void test03() throws SQLException {
        String sql = "SELECT * FROM t_user";
        List<User> list = DBUtil.queryList(User.class, sql);
        System.out.println(list);
    }

    @Test
    public void test04() {
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "INSERT INTO t_account VALUES(?,?)";
            conn.setAutoCommit(false);
            DBUtil.update(conn, sql, "H", 250.5);
            int i = 100/0;
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
    }
}
```
