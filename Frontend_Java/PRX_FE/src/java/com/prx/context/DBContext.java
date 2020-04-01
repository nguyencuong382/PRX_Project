package com.prx.context;

import com.prx.util.AppContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {

    private String url;
    private static DBContext dbContext;
    AppContext ac = new AppContext();

    public static DBContext getInstace() throws ClassNotFoundException {
        if (dbContext == null) {
            dbContext = new DBContext();
        }
        return dbContext;
    }

    public Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url);
        } catch (Exception e) {
            url = ac.env("urlConnection");
            con = DriverManager.getConnection(url);
        }
        return con;
    }

    private DBContext() throws ClassNotFoundException {
        url = ac.env("urlConnection");
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

    }

}
