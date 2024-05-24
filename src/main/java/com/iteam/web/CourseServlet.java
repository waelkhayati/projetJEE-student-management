package com.iteam.web;

import com.iteam.model.Course;
import com.iteam.service.CourseService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CourseServlet", urlPatterns = {"/courses"})
public class CourseServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CourseService courseService = new CourseService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteCourse(request, response);
                break;
            case "list":
            default:
                listCourses(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "insert":
                insertCourse(request, response);
                break;
            case "update":
                updateCourse(request, response);
                break;
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("course-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Course existingCourse = courseService.getAllCourses().stream().filter(c -> c.getId() == id).findFirst().orElse(null);
        RequestDispatcher dispatcher = request.getRequestDispatcher("course-form.jsp");
        request.setAttribute("course", existingCourse);
        dispatcher.forward(request, response);
    }

    private void insertCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int credit = Integer.parseInt(request.getParameter("credit"));
        Course newCourse = new Course(title, description, credit);
        courseService.addCourse(newCourse);
        response.sendRedirect("courses");
    }

    private void updateCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int credit = Integer.parseInt(request.getParameter("credit"));
        Course course = new Course(title, description, credit);
        course.setId(id);
        courseService.updateCourse(course);
        response.sendRedirect("courses");
    }

    private void deleteCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        courseService.deleteCourse(id);
        response.sendRedirect("courses");
    }

    private void listCourses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCourses", courseService.getAllCourses());
        RequestDispatcher dispatcher = request.getRequestDispatcher("course-list.jsp");
        dispatcher.forward(request, response);
    }
}
