package com.imcode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo02 {
    // 向员工表插入数据
    public static void main(String[] args) throws Exception {

        //insert(80, "教务部", "中国福州");
        //update(80, "教务部007", "福州007");
        //delete();
        insertEmp();
    }


    public static void insertEmp() throws Exception {

        String sql = "INSERT INTO EMP(EMPNO,ENAME,HIREDATE) VALUES (1007,'张三',to_date('2018-02-20','YYYY-MM-DD'))";
        Connection conn =
                DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "123456");
        Statement st = conn.createStatement();
        int r = st.executeUpdate(sql);
        System.out.println("结果：" + r);
        st.close();
        conn.close();
    }


    public static void insert(int deptno, String dname, String loc) throws Exception {
        //Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn =
                DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "123456");
        Statement st = conn.createStatement();
        String sql = "INSERT INTO DEPT(DEPTNO,DNAME,LOC) VALUES(" + deptno + ",'" + dname + "','" + loc + "')";
        int r = st.executeUpdate(sql);
        System.out.println("结果：" + r);
        st.close();
        conn.close();
    }

    /**
     * 根据传入的部门编号，更新该部门的部门名称和地理位置
     *
     * @param deptno
     * @param dname
     */
    public static void update(int deptno, String dname, String loc) throws Exception {
        String sql = "UPDATE DEPT SET DNAME='" + dname + "',LOC='" + loc + "' WHERE DEPTNO=" + deptno;

        Connection conn =
                DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "123456");
        Statement st = conn.createStatement();
        int r = st.executeUpdate(sql);
        System.out.println("结果：" + r);
        st.close();
        conn.close();
    }

    public static void delete() throws Exception {

        String sql = "DELETE FROM DEPT WHERE DEPTNO >= 50";
        Connection conn =
                DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "123456");
        Statement st = conn.createStatement();
        int r = st.executeUpdate(sql); //
        System.out.println("结果：" + r);
        st.close();
        conn.close();
    }


}
