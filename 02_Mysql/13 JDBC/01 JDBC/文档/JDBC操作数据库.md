# JDBC操作数据库

## 目标

- JDBC 概述
- 使用 JDBC API

## 1. JDBC 概述

-  `JDBC`（**J**ava **D**ata **B**ase **C**onnectivity,  Java数据库连接）
-  是一种用于执行SQL语句的`Java API`，为多种关系数据库提供统一访问**接口**
- 它由一组用`Java`语言编写的类和接口组成

![1537867424205](img\JDBC01.png)



- 有了JDBC，**程序员只需用JDBC API写一个程序，就可以访问所有数据库**。



![1537867533068](img\JDBC02.png)

### JDBC API

- 提供者：**Sun/oracle公司**
- 内容：**供程序员调用的接口与类**，集成在`java.sql`和`javax.sql`包中，如
- `DriverManager` 类   管理各种不同的 **JDBC驱动**
- `Connection` 接口     连接数据库
- `Statement` 接口      执行SQL
- `ResultSet` 接口       返回结果

### JDBC 驱动

- 提供者：**数据库厂商**
- 作用：  **负责连接和访问各种不同的数据库**



### 程序员

- 有了JDBC，**程序员只需用 JDBC API 写一个程序，就可以访问所有数据库**。

### 三方关系

- SUN公司是规范制定者，制定了规范 `JDBC`（连接数据库规范）
- 数据库厂商微软、甲骨文等分别提供**实现 JDBC接口 的 驱动jar包**
- 程序员学习 `JDBC` 规范来**应用这些 jar 包里的类**

  ![1537868017069](img\JDBC03.png)

##  2. 使用 JDBC API 

使用 JDBC API 可做5件事：

- 加载驱动
- 与数据库建立连接
- 发送操作数据库的 `SQL` 语句
- 处理 `SQL` 执行结果
- 释放数据库资源



![1537868466877](img\JDBC04.png)

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



### 加载驱动

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



\* **JRE 1.8.x is required for Connector/J 5.1 to connect to MySQL 5.6, 5.7, and 8.0 with SSL/TLS when using some cipher suites**.

The current recommended version for Connector/J is 5.1. This guide also covers earlier versions of Connector/J, with specific notes given where a setting applies to a specific version.



驱动包下载地址：https://dev.mysql.com/downloads/connector/j/



```java
// 下面列出常用的几种数据库驱动程序加载语句的形式 
Class.forName("oracle.jdbc.driver.OracleDriver"); //Oracle的JDBC驱动程序 
Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver"); //SQL Server
Class.forName("com.ibm.db2.jdbc.app.DB2Driver");//DB2的JDBC驱动程序 
Class.forName("com.mysql.jdbc.Driver"); //使用MySql的JDBC驱动程序
```



### 获取数据库连接

```java
// DriverManager.getConnection(String url, String user, String password)方法
// String url = "jdbc:oracle:thin:@localhost:1521:orcl";
String url = "jdbc:mysql://localhost:3306/mydb";
String user="root";
String password="123456";
Connection conn = DriverManager.getConnection(url, user, password);
```

### 执行SQL

`Statement` 对象用于将 SQL 语句发送到数据库中，或者理解为执行 SQL 语句

有三种 Statement对象：

- `Statement`：用于执行不带参数的**简单SQL语句**；  会出现sql注入的风险
- `PreparedStatement`（从Statement 继承）：用于执行带或不带参数的**预编译SQL语句**；避免了sql注入及字符串拼接。
- `CallableStatement`（从PreparedStatement 继承）：用于执行数据库存储过程的调用;



![1537869111499](img\JDBC05.png)



### 处理结果集

- `ResultSet` 对象是 `executeQuery()` 方法的返回值，它被称为**结果集**，它代表符合SQL语句条件的所有行，并且它通过一套 `getXXX` 方法（这些get方法可以访问当前行中的不同列）提供了对这些行中数据的访问。
- `ResultSet` 里的数据一行一行排列，每行有多个字段，且有一个记录指针，指针所指的数据行叫做当前数据行，我们只能来操作当前的数据行。**我们如果想要取得某一条记录，就要使用 ResultSet 的 next() 方法** ,如果我们想要得到ResultSet里的**所有记录**，就应该使用 `while` 循环。
- `ResultSet` 对象自动维护指向**当前数据行的游标**。**每调用一次 next() 方法，游标向下移动一行**。 
- **初始状态下记录指针指向第一条记录的前面**，通过next()方法指向第一条记录。
- 循环完毕后指向最后一条记录的后面。

![1537869396570](img\JDBC06.png)

### 释放资源

- 作为一种好的编程风格，应在不需要 `Statement` 对象和 `Connection` 对象时显式地**关闭**它们。关闭Statement对象和Connection对象的语法形式为：
  - public void close() throws SQLException
- **用户不必关闭ResultSet**。当它的 Statement 关闭、重新执行或用于从多结果序列中获取下一个结果时，该ResultSet将被自动关闭
- 注意：要按先ResultSet结果集，后Statement，最后Connection的顺序关闭资源，因为Statement和ResultSet是需要连接是才可以使用的，所以在使用结束之后有可能其他的Statement还需要连接，所以不能先关闭Connection

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

# 3.  

##  3. DBUtil工具类

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

 

```properties
# mysql数据库连接信息
driverClassName=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=Asia/Shanghai
username=root
password=123456
```

 