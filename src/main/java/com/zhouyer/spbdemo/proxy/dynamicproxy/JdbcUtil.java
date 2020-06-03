package com.zhouyer.spbdemo.proxy.dynamicproxy;

import com.mysql.cj.xdevapi.Collection;
import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @ClassName JdbcUtil
 * @Description Java 数据库连接工具
 * @Author zhouyer
 * @Date 2020/6/2 21:58
 * @Version 1.0
 **/
@UtilityClass
public class JdbcUtil {
    private String url = "jdbc:mysql://localhost:3306/zhouyer?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";

    private String username = "root";

    private String password = "123456";

    private Connection con = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getCon() {
        return con;
    }

    public void releaseCon(Connection connection) {
        try {
            if (null != connection && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
