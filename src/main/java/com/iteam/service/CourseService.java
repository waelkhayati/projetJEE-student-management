package com.iteam.service;

import com.iteam.dao.CourseDAO;
import com.iteam.model.Course;
import java.sql.SQLException;
import java.util.List;

public class CourseService {
    private CourseDAO courseDao = new CourseDAO();

    public void addCourse(Course course) {
        try {
            courseDao.addCourse(course);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Course> getAllCourses() {
        try {
            return courseDao.getAllCourses();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateCourse(Course course) {
        try {
            courseDao.updateCourse(course);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCourse(int id) {
        try {
            courseDao.deleteCourse(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
