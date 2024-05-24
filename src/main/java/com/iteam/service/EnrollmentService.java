package com.iteam.service;

import com.iteam.dao.EnrollmentDAO;
import com.iteam.model.Enrollment;

import java.sql.SQLException;
import java.util.List;

public class EnrollmentService {
    private EnrollmentDAO enrollmentDao = new EnrollmentDAO();

    public void addEnrollment(Enrollment enrollment) {
        try {
            enrollmentDao.addEnrollment(enrollment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEnrollment(int studentId, int courseId) {
        try {
            enrollmentDao.deleteEnrollment(studentId, courseId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Enrollment> getAllEnrollments() throws SQLException {
        return enrollmentDao.getAllEnrollments(); 
    }

    
}

