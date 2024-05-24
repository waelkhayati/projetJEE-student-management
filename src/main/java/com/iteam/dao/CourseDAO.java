package com.iteam.dao;

import com.iteam.model.Course;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    private Connection connection = SingletonConnection.getConnection();

    public void addCourse(Course course) throws SQLException {
        String sql = "INSERT INTO courses (title, description, credit) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, course.getTitle());
        statement.setString(2, course.getDescription());
        statement.setInt(3, course.getCredit());
        statement.executeUpdate();
    }

    public List<Course> getAllCourses() throws SQLException {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM courses";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Course course = new Course(
                resultSet.getString("title"), 
                resultSet.getString("description"), 
                resultSet.getInt("credit"));
            course.setId(resultSet.getInt("id"));
            courses.add(course);
        }
        return courses;
    }

    public void updateCourse(Course course) throws SQLException {
        String sql = "UPDATE courses SET title = ?, description = ?, credit = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, course.getTitle());
        statement.setString(2, course.getDescription());
        statement.setInt(3, course.getCredit());
        statement.setInt(4, course.getId());
        statement.executeUpdate();
    }

    public void deleteCourse(int id) throws SQLException {
        String sql = "DELETE FROM courses WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }
}
