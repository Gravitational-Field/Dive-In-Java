package com.imcode;

import java.sql.*;

public class JDBCDemo03 {
    public static void main(String[] args) throws Exception {
        //select01("7369 or 1=1");
        //select02("7369 or 1=1");
        //select03("SMITH");
        insert(90,"测试部门","火星");
    }


    public static void insert(int deptno, String dname, String loc) throws Exception {
        Connection conn =
                DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "123456");

        String sql = "INSERT INTO DEPT(DEPTNO,DNAME,LOC) VALUES(?,?,?)";
        PreparedStatement st = conn.prepareStatement(sql);

        st.setObject(1,deptno);
        st.setObject(2,dname);
        st.setObject(3,loc);
        int r = st.executeUpdate();
        System.out.println("结果：" + r);
        st.close();
        conn.close();
    }


    public static void select03(String ename) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");// 参数是类的全路径名称
        Connection conn =
                DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "123456");

        String sql = "SELECT * FROM EMP WHERE ENAME=?";
        // SELECT * FROM EMP WHERE ENAME='SMITH or 1=1'
        PreparedStatement st = conn.prepareStatement(sql);
        st.setObject(1, ename);

        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("ename"));
        }
        st.close();
        conn.close();
    }


    public static void select02(String empno) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");// 参数是类的全路径名称
        Connection conn =
                DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "123456");

        String sql = "SELECT * FROM EMP WHERE EMPNO=?";
        //SELECT * FROM EMP WHERE EMPNO='7369 or 1=1'
        PreparedStatement st = conn.prepareStatement(sql);
        st.setObject(1, empno);

        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("ename"));
        }
        st.close();
        conn.close();
    }


    /**
     * SQL注入
     *
     * @param empno
     * @throws Exception
     */
    public static void select01(String empno) throws Exception {
        Connection conn =
                DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "123456");
        Statement st = conn.createStatement();
        String sql = "SELECT * FROM EMP WHERE EMPNO= " + empno;

        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString("ename"));
        }
        st.close();
        conn.close();
    }



}
