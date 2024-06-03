package java.com.bitzh.hospitalsystem.dao;

import java.sql.*;
import java.com.bitzh.hospitalsystem.model.*;


//包含了与医生表进行交互的方法，如添加医生、删除医生、修改医生信息、查看医生列表和查看医生信息
public class DoctorDao {
    private Connection conn;
    // 构造函数，用于建立数据库连接
    public DoctorDao(Connection conn) {
        this.conn = conn;
    }
    public Doctor Login(String username,String password)throws SQLException {
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

}
