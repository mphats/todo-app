package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegisterDAO {
    private Connection conn;

    public RegisterDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean addAccount(String name, String email, String password, String contact) {
        boolean isSuccess = false;
        try {
            String sql = "INSERT INTO userdetails(name, email, password, contact) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, password);
                ps.setString(4, contact);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    isSuccess = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    public boolean loginIntoAccount(String email, String password) {
        try {
            String sql = "SELECT * FROM userdetails WHERE email=? AND password=?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, email);
                ps.setString(2, password);
                try (ResultSet rs = ps.executeQuery()) {
                    return rs.next();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
