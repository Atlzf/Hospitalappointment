package com.bitzh.hospitalsystem.dao;

import com.bitzh.hospitalsystem.model.Appointment;
import java.sql.*;
import java.util.*;
import com.bitzh.hospitalsystem.Utils.DatabaseConnectionManager;

//这个类包含了与预约表进行交互的方法，如添加预约、删除预约、修改预约信息和查看预约列表。
public class AppointmentDao {
    private Connection conn;
    public AppointmentDao(Connection conn) throws SQLException {
        this.conn = DatabaseConnectionManager.getConnection();
    }
    ;


    public void addAppointment(Appointment appointment) throws SQLException {
        String sql = "INSERT INTO Appointment (user_id, doctor_id, appointment_time) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, appointment.getUserId());
        pstmt.setInt(2, appointment.getDoctorId());
        pstmt.setTimestamp(3, appointment.getAppointmentTime());
        pstmt.executeUpdate();
    }
    public void deleteAppointment(int id) throws SQLException {
        String sql = "DELETE FROM Appointment WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }
    public void updateAppointment(Appointment appointment) throws SQLException {
        String sql = "UPDATE Appointment SET user_id = ?, doctor_id = ?, appointment_time = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, appointment.getUserId());
        pstmt.setInt(2, appointment.getDoctorId());
        pstmt.setTimestamp(3, appointment.getAppointmentTime());
        pstmt.setInt(4, appointment.getId());
        pstmt.executeUpdate();
    }

    public List<Appointment> getAppointments() throws SQLException {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM Appointment";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Appointment appointment = new Appointment();
            appointment.setId(rs.getInt("id"));
            appointment.setUserId(rs.getInt("user_id"));
            appointment.setDoctorId(rs.getInt("doctor_id"));
            appointment.setAppointmentTime(rs.getTimestamp("appointment_time"));appointments.add(appointment);
            }
        return appointments;
    }

}
