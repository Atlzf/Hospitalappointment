package java.com.bitzh.hospitalsystem.dao;

import java.com.bitzh.hospitalsystem.Utils.DatabaseConnectionManager;
import java.util.*;
import java.sql.*;
import java.com.bitzh.hospitalsystem.model.*;


//包含了与医生表进行交互的方法，如添加医生、删除医生、修改医生信息、查看医生列表和查看医生信息
public class DoctorDao {
    private Connection conn;
    // 构造函数，用于建立数据库连接
    public DoctorDao(Connection conn)throws SQLException {
        this.conn = DatabaseConnectionManager.getConnection();
    }

    //医生登录
    public Doctor Login(String username,String password)throws SQLException {
        //医生登录
        String sql = "select * from Doctor where username = ? and password = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);//将第一个问好填充为username，防止注入
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
            Doctor doctor = new Doctor();
            doctor.setUsername(rs.getString("username"));
            doctor.setPassword(rs.getString("password"));
            return doctor;
        }else{
            return null;
        }
    }
    public List<Appointment> getDoctorAppointments(int doctorId) throws SQLException {
        // 获取医生的预约信息
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM Appointment WHERE doctor_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, doctorId);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Appointment appointment = new Appointment();
            // 填充预约信息
            // 注意：这里假设你的Appointment类有相应的setter方法
            // 你需要根据你的Appointment类的实际情况进行修改
            appointment.setId(rs.getInt("id"));
            appointment.setUserId(rs.getInt("user_id"));
            appointment.setDoctorId(rs.getInt("doctor_id"));
            appointment.setAppointmentTime(rs.getTimestamp("appointment_time"));
            appointments.add(appointment);
        }
        return appointments;
    }

}
