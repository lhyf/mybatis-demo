package org.lhyf.jdbc;

import java.sql.*;

/****
 * @author YF
 * @date 2019-04-14 17:39
 * @desc PreparedStatementTest
 *
 **/
public class PreparedStatementTest {
    // JDBC 驱动名和数据库连接
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/mybatis?useUnicode=true&characterEncoding=UTF-8&useSSL=true";

    // 账号密码
    static final String USER = "root";
    static final String PASS = "123456";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            //STEP 2: 注册JDBC 驱动
            Class.forName(JDBC_DRIVER);

            //STEP 3: 打开一个连接
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: 获取Statment 执行SQL
            System.out.println("Creating statement...");
            String sql = "insert into tbl_employee (last_name, email, gender ) values (?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "小强");
            stmt.setString(2, "xiaoqiang@qq.com");
            stmt.setString(3, "male");
            int i = stmt.executeUpdate();

            System.out.println("update : " + i);
            //STEP 6: 关闭资源
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}