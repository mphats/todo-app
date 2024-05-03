package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
    private static Connection conn;

    public static Connection getConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo","root","2000Fh22@");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
