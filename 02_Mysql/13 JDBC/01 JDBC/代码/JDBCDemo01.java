package com.imcode;

import java.sql.*;

public class JDBCDemo01 {
    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            //1. 加载一个Driver驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");// 参数是类的全路径名称
            //2. 创建数据库连接
            conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "123456");
            //3. 创建SQL命令发送器Statement
            st = conn.createStatement();
            //4. 通过Statement发送SQL命令并得到结果
            //String sql = "select * from emp"; //Java代码中的SQL语句不要使用分号
            String sql = "select empno no, ename name, job from emp where ename='SMITH' ";
            rs = st.executeQuery(sql);
            //5. 处理SQL结果（select语句）
            while (rs.next()) {
                //5.1 获取行数据
//            Integer empno = rs.getInt(1);
//            String ename = rs.getString(2);
                Integer empno = rs.getInt("no");
                String ename = rs.getString("job");
                System.out.println(empno + "-->" + ename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //6. 关闭数据库资源
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
