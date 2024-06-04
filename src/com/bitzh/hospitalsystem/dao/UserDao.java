package com.bitzh.hospitalsystem.dao;

import com.bitzh.hospitalsystem.Utils.DatabaseConnectionManager;
import com.bitzh.hospitalsystem.model.Appointment;
import com.bitzh.hospitalsystem.model.User;

import com.bitzh.hospitalsystem.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private Connection conn;

    public UserDao() throws SQLException {
        this.conn = DatabaseConnectionManager.getConnection();
    }


    public boolean register(User user) throws SQLException {
        //用户注册
        String sql = "INSERT INTO User (username, password, contact) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getPassword());
        stmt.setString(3, user.getContactInfo());
        int rowsInserted = stmt.executeUpdate();
        return rowsInserted > 0;
    }

    public User login(String username, String password) throws SQLException {
        //用户登录
        String sql = "SELECT * FROM User WHERE username = ? AND password = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setContactInfo(rs.getString("contact"));
            return user;
        } else {
            return null;
        }
    }

    public boolean bookAppointment(int userId, int doctorId, Timestamp appointmentTime) throws SQLException {
        //用户预约医生
        String sql = "INSERT INTO Appointment (user_id, doctor_id, appointment_time) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, userId);
        stmt.setInt(2, doctorId);
        stmt.setTimestamp(3, appointmentTime);
        int rowsInserted = stmt.executeUpdate();
        return rowsInserted > 0;
    }

    public List<Appointment> viewAppointments(int userId) throws SQLException {
        //查看用户的预约信息
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM Appointment WHERE user_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, userId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Appointment appointment = new Appointment();
            appointment.setId(rs.getInt("id"));
            appointment.setUserId(rs.getInt("user_id"));
            appointment.setDoctorId(rs.getInt("doctor_id"));
            appointment.setAppointmentTime(rs.getTimestamp("appointment_time"));
            appointments.add(appointment);
        }
        return appointments;
    }

    public boolean rateDoctor(int userId, int doctorId, String content) throws SQLException {
        //用户评价医生
        String sql = "INSERT INTO Review (user_id, doctor_id, content) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, userId);
        stmt.setInt(2, doctorId);
        stmt.setString(3, content);
        int rowsInserted = stmt.executeUpdate();
        return rowsInserted > 0;
    }


    public boolean updateUser(User user) throws SQLException {
        //更改用户信息
        String sql = "UPDATE User SET username = ?, password = ?, contact = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getPassword());
        stmt.setString(3, user.getContactInfo());
        stmt.setInt(4, user.getId());
        int rowsUpdated = stmt.executeUpdate();
        return rowsUpdated > 0;
    }
}