<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <meta charset="UTF-8">
    <title>Add Enrollment</title>
</head>
<body class="m-5">
<div class="container mt-5">
    <h1>Add Enrollment</h1>
    <form action="enrollments" method="post">
        <input type="hidden" name="action" value="insert">
        <div class="form-group">
            <label for="studentId">Student:</label>
            <select id="studentId" name="studentId" class="form-control" required>
                <option value="">Select a Student</option>
                <c:forEach items="${listStudents}" var="student">
                    <option value="${student.id}">${student.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="courseId">Course:</label>
            <select id="courseId" name="courseId" class="form-control" required>
                <option value="">Select a Course</option>
                <c:forEach items="${listCourses}" var="course">
                    <option value="${course.id}">${course.title}</option>
                </c:forEach>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Enroll</button>
    </form>
</div>
</body>
</html>
