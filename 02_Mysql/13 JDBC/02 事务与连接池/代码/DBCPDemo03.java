package com.imcode;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

public class DBCPDemo03 {

    public static void main(String[] args) throws Exception {
        /*
        long s1 = System.currentTimeMillis();
        for(int i=1;i<=2000;i++){
            System.out.println("创建连接：" + i);
            Connection conn =
                    DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "123456");
            conn.close();
        }
        long s2 = System.currentTimeMillis();
        System.out.println("不使用连接池:" + (s2-s1)/1000);

        System.out.println("--------------------------");*/

        //1.初始化数据库连接池(数据源)对象
        Properties prop = new Properties();
        prop.load(DBCPDemo02.class.getClassLoader().getResourceAsStream("db.properties"));
        DataSource dataSource =
                BasicDataSourceFactory.createDataSource(prop);

        long s3 = System.currentTimeMillis();
        for (int i=1;i<=7000;i++){
            System.out.println("创建连接：" + i);
            //2.获取数据库连接
            Connection conn = dataSource.getConnection();
            conn.close();
        }
        long s4 = System.currentTimeMillis();
        System.out.println("使用连接池:" + (s4-s3)/1000);

    }
//不使用连接池:103
//    public static void main(String[] args) throws SQLException {
//        List<Connection> list = new ArrayList<>();
//        try{
//            for(int i=1;i<=2000;i++){
//                System.out.println("创建连接：" + i);
//                Connection conn =
//                        DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "123456");
//
//                list.add(conn);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            for(Connection c : list){
//                c.close();
//            }
//        }
//    }
}
