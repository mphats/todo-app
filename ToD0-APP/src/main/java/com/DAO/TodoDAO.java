package com.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.TodoDtls;

public class TodoDAO {
    private Connection conn;

    public TodoDAO(Connection conn) {
        super();
        this.conn = conn;
    }

    public boolean addTodo(String t_name, String t_todo, String t_status) {
        boolean isSuccess = false;
        try {
            String sql = "INSERT INTO todoitems(t_name, t_todo, t_status) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t_name);
            ps.setString(2, t_todo);
            ps.setString(3, t_status);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                isSuccess = true;
            }
            ps.close(); // Close PreparedStatement
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception properly
        }
        return isSuccess;
    }

    public List<TodoDtls> getTodo() {
        List<TodoDtls> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM todoitems";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TodoDtls t = new TodoDtls();
                t.setId(rs.getInt(1));
                t.setName(rs.getString(2));
                t.setTodo(rs.getString(3));
                t.setStatus(rs.getString(4));
                list.add(t);
            }
            rs.close(); // Close ResultSet
            ps.close(); // Close PreparedStatement
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception properly
        }
        return list;
    }
    public TodoDtls getTodoById(int id) {
        TodoDtls t = null;
        try {
            String sql = "SELECT * FROM todoitems WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                t = new TodoDtls();
                t.setId(rs.getInt(1));
                t.setName(rs.getString(2));
                t.setTodo(rs.getString(3));
                t.setStatus(rs.getString(4));
            }
            rs.close(); // Close ResultSet
            ps.close(); // Close PreparedStatement
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception properly
        }
        return t;
    }

    public boolean updateTodo(TodoDtls t) {
    	boolean f=false;
    	try {
    		String sql = "UPDATE todoitems SET t_name=?, t_todo=?, t_status=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,t.getName());
            ps.setString(2,t.getTodo());
            ps.setString(3,t.getStatus());
            ps.setInt(4,t.getId());
            int i = ps.executeUpdate();
            if(i==1) {
            	f=true;
            }
            ps.close(); // Close PreparedStatement
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception properly
        }
    	return f;
    }
    public boolean deleteTodo(int id) {
        boolean isSuccess = false;
        try {
            String sql = "DELETE FROM todoitems WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            if (i == 1) {
                isSuccess = true;
            }
            ps.close(); // Close PreparedStatement
        } catch (Exception e) {
            // Log the exception
            System.err.println("An error occurred while deleting todo with ID " + id + ": " + e.getMessage());
            e.printStackTrace(); // Print stack trace for detailed debugging
        }
        return isSuccess;
    }


}
