package java.com.bitzh.hospitalsystem.dao;

import java.com.bitzh.hospitalsystem.Utils.DatabaseConnectionManager;
import java.com.bitzh.hospitalsystem.model.Review;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDao {
    private Connection conn;

    public ReviewDao(Connection conn) throws SQLException {
        this.conn = DatabaseConnectionManager.getConnection();
    }

    public void addReview(Review review) throws SQLException {
        String sql = "INSERT INTO Review (user_id, doctor_id, content) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, review.getUserId());
        pstmt.setInt(2, review.getDoctorId());
        pstmt.setString(3, review.getContent());
        pstmt.executeUpdate();
    }

    public List<Review> getReviewsByUserId(int userId) throws SQLException {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM Review WHERE user_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, userId);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Review review = new Review();
            review.setId(rs.getInt("id"));
            review.setUserId(rs.getInt("user_id"));
            review.setDoctorId(rs.getInt("doctor_id"));
            review.setContent(rs.getString("content"));
            reviews.add(review);
        }
        return reviews;
    }

    public List<Review> getReviewsByDoctorId(int doctorId) throws SQLException {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM Review WHERE doctor_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, doctorId);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Review review = new Review();
            review.setId(rs.getInt("id"));
            review.setUserId(rs.getInt("user_id"));
            review.setDoctorId(rs.getInt("doctor_id"));
            review.setContent(rs.getString("content"));
            reviews.add(review);
        }
        return reviews;
    }
}