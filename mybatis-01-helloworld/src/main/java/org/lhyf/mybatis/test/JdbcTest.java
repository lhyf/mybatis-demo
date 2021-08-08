package org.lhyf.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author YF
 * @date 2021/08/08 12:03
 * @Description
 */
public class JdbcTest {
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
        InputStream inputStream = JdbcTest.class.getClassLoader().getResourceAsStream("jdbc.properties");

        Properties properties = new Properties();
        properties.load(inputStream);

        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String sql = "select id,last_name lastName,email,gender from tbl_employee where id = ?";

        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1,1);
        statement.execute();
        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next()) {
            System.out.println(" id：" + resultSet.getInt("id") );
            System.out.println(" lastName：" + resultSet.getString("lastName") );
            System.out.println(" email：" + resultSet.getString("email") );
            System.out.println(" gender：" + resultSet.getInt("gender") );
        }

    }
}
