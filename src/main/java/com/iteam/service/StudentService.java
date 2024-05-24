package com.iteam.service;

import com.iteam.dao.StudentDAO;
import com.iteam.model.Student;
import java.sql.SQLException;
import java.util.List;

public class StudentService {
    private StudentDAO studentDao = new StudentDAO();

    public void addStudent(Student student) {
        try {
            studentDao.addStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        try {
            return studentDao.getAllStudents();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateStudent(Student student) {
        try {
            studentDao.updateStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        try {
            studentDao.deleteStudent(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
