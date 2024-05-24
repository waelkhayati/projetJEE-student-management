package com.iteam.dao;

import com.iteam.model.Enrollment;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAO {
    private Connection connection = SingletonConnection.getConnection();

    public void addEnrollment(Enrollment enrollment) throws SQLException {
        String sql = "INSERT INTO enrollments (student_id, course_id) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, enrollment.getStudentId());
        statement.setInt(2, enrollment.getCourseId());
        statement.executeUpdate();
    }

    public void deleteEnrollment(int studentId, int courseId) throws SQLException {
        String sql = "DELETE FROM enrollments WHERE student_id = ? AND course_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, studentId);
        statement.setInt(2, courseId);
        statement.executeUpdate();
    }
    
    public List<Enrollment> getAllEnrollments() throws SQLException {
        List<Enrollment> enrollments = new ArrayList<>();
        String sql = "SELECT e.student_id, e.course_id, s.name as student_name, c.title as course_title " +
                     "FROM enrollments e " +
                     "JOIN students s ON e.student_id = s.id " +
                     "JOIN courses c ON e.course_id = c.id";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Enrollment enrollment = new Enrollment();
            enrollment.setStudentId(rs.getInt("student_id"));
            enrollment.setCourseId(rs.getInt("course_id"));
            enrollment.setStudentName(rs.getString("student_name")); 
            enrollment.setCourseTitle(rs.getString("course_title")); 
            enrollments.add(enrollment);
        }
        return enrollments;
    }


 
}
