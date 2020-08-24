package com.imcode;

import com.imcode.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentApp {

    public static void main(String[] args) throws Exception {
        List<Student> list = list();
        for (Student s : list) {
            System.out.println(s);
        }
    }

    public static List<Student> list() throws Exception {
        //1.获取数据库连接
        Connection conn = DBUtil.getConnection();
        //2.执行查询SQL
        String sql =
                "SELECT\n" +
                        "	S.ID,\n" +
                        "   S.STUDENT_NAME,\n" +
                        "   S.STUDENT_NUMBER,\n" +
                        "   C.CLASS_NAME,\n" +
                        "   C.CLASS_NUMBER\n" +
                        "FROM\n" +
                        "	T_STUDENT S\n" +
                        "LEFT JOIN T_CLASS C ON S.CLASS_ID = C.ID";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        //3.处理结果集
        List<Student> list = new ArrayList<>();
        while (rs.next()) {
            Student s = new Student();
            s.setId(rs.getInt("ID"));
            s.setStudentName(rs.getString("STUDENT_NAME"));
            s.setStudentNumber(rs.getString("STUDENT_NUMBER"));
            s.setClassName(rs.getString("CLASS_NAME"));
            s.setClassNumber(rs.getString("CLASS_NUMBER"));
            list.add(s);
        }
        return list;
    }
}
