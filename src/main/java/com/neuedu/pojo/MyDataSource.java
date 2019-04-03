package com.neuedu.pojo;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class MyDataSource {
    private String driver;
    private String url;
    private String username;
    private String password;
    List<Connection> connections = new LinkedList<>();

    public MyDataSource(String driver, String url, String username, String password) {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
        try {
            Class.forName(driver);
            for(int i = 1 ;i<= 10 ;i++){
                this.connections.add(getConnection());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        Connection con = null;
        Connection con2 = null;
        try {
            con = DriverManager.getConnection(url,username,password );
            ConnectionProxy connectionProxy = new ConnectionProxy(con, connections);
            con2 = (Connection) Proxy.newProxyInstance(
                    con.getClass().getClassLoader(),
                    new Class[]{Connection.class}, connectionProxy);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con2;
    }
}
