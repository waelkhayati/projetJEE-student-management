package com.iteam.web;

import com.iteam.model.Enrollment;
import com.iteam.service.EnrollmentService;
import com.iteam.service.StudentService;
import com.iteam.service.CourseService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import com.iteam.model.Student;
import com.iteam.model.Course;


@WebServlet(name = "EnrollmentServlet", urlPatterns = {"/enrollments"})
public class EnrollmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EnrollmentService enrollmentService;
    private StudentService studentService;
    private CourseService courseService;

    public EnrollmentServlet() {
        this.enrollmentService = new EnrollmentService();
        this.studentService = new StudentService();
        this.courseService = new CourseService();
    }

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "delete":
                    deleteEnrollment(request, response);
                    break;
                case "list":
                default:
                    listEnrollments(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException("Error handling enrollment actions", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        try {
            switch (action) {
                case "insert":
                    insertEnrollment(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException("Error handling enrollment post actions", e);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> listStudents = studentService.getAllStudents();
        List<Course> listCourses = courseService.getAllCourses();
        request.setAttribute("listStudents", listStudents);
        request.setAttribute("listCourses", listCourses);
        RequestDispatcher dispatcher = request.getRequestDispatcher("enrollment-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertEnrollment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        Enrollment newEnrollment = new Enrollment(studentId, courseId);
        enrollmentService.addEnrollment(newEnrollment);
        response.sendRedirect("enrollments");
    }

    private void deleteEnrollment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        enrollmentService.deleteEnrollment(studentId, courseId);
        response.sendRedirect("enrollments");
    }

   

        private void listEnrollments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
                request.setAttribute("listEnrollments", enrollments);
                RequestDispatcher dispatcher = request.getRequestDispatcher("enrollment-list.jsp");
                dispatcher.forward(request, response);
            } catch (Exception e) {
                throw new ServletException("Error retrieving enrollments", e);
            }
        }
    

}
