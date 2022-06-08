package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    final static String USER = "root";
    final static String PASS = "12345678";//"12345678";


    public java.sql.Connection getConnect(){
        Connection conn = null;
        java.sql.Statement stmt = null;
        boolean flag = false;
        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javawebhomework",USER,PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
//            stmt = conn.createStatement();
//            String sql;
//            sql = "SELECT name FROM TEST2";
//            ResultSet rs = stmt.executeQuery(sql);

//            // 展开结果集数据库
//            while(rs.next()){
//                // 通过字段检索
//                String name  = rs.getString("name");
//                System.out.println(name);
//                if(myname.equals(name)) {
//                    flag = true;
//                    break;
//                }
//            }
//            // 完成后关闭
//            rs.close();
//            stmt.close();
//            conn.close();
//        }catch(SQLException se){
//            // 处理 JDBC 错误
//            se.printStackTrace();
//        }catch(Exception e){
//            // 处理 Class.forName 错误
//            e.printStackTrace();
//        }finally{
//            // 关闭资源
//            try{
//                if(stmt!=null) stmt.close();
//            }catch(SQLException se2){
//            }// 什么都不做
//            try{
//                if(conn!=null) conn.close();
//            }catch(SQLException se){
//                se.printStackTrace();
//            }
//        }
//        return flag;


    } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}

