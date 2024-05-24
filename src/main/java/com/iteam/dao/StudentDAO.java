package com.iteam.dao;

import com.iteam.model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private Connection connection = SingletonConnection.getConnection();

    public void addStudent(Student student) throws SQLException {
        String sql = "INSERT INTO students (name, email, department) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, student.getName());
        statement.setString(2, student.getEmail());
        statement.setString(3, student.getDepartment());
        statement.executeUpdate();

        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            student.setId(generatedKeys.getInt(1)); 
        }
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Student student = new Student(
                resultSet.getString("name"), 
                resultSet.getString("email"), 
                resultSet.getString("department"));
            student.setId(resultSet.getInt("id")); 
            students.add(student);
        }
        return students;
    }

    public void updateStudent(Student student) throws SQLException {
        String sql = "UPDATE students SET name = ?, email = ?, department = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, student.getName());
        statement.setString(2, student.getEmail());
        statement.setString(3, student.getDepartment());
        statement.setInt(4, student.getId());
        statement.executeUpdate();
    }

    public void deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }
}
