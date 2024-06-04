package com.bitzh.hospitalsystem.dao;

import com.bitzh.hospitalsystem.Utils.DatabaseConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
    private Connection conn;

    public AdminDao(Connection conn) throws SQLException {
        this.conn = DatabaseConnectionManager.getConnection();
    }

    public boolean login(String username, String password) throws SQLException {
        String sql = "SELECT * FROM Admin WHERE username = ? AND password = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();
        return rs.next();
    }
    public void addDoctor(String name, String specialty, String available_time, String username, String password) throws SQLException {
        String sql = "INSERT INTO Doctor (name, specialty, available_time, username, password) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, specialty);
        pstmt.setString(3, available_time);
        pstmt.setString(4, username);
        pstmt.setString(5, password);
        pstmt.executeUpdate();
    }

    public void updateDoctor(int id, String name, String specialty, String available_time) throws SQLException {
        String sql = "UPDATE Doctor SET name = ?, specialty = ?, available_time = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, specialty);
        pstmt.setString(3, available_time);
        pstmt.setInt(4, id);
        pstmt.executeUpdate();
    }

    public void resetDoctorPassword(int id) throws SQLException {
        String sql = "UPDATE Doctor SET password = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "123456");
        pstmt.setInt(2, id);
        pstmt.executeUpdate();
    }

    public void resetUserPassword(int id) throws SQLException {
        String sql = "UPDATE User SET password = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "123456");
        pstmt.setInt(2, id);
        pstmt.executeUpdate();
    }

    public void deleteReview(int id) throws SQLException {
        String sql = "DELETE FROM Review WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }

    public void deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM User WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }
}