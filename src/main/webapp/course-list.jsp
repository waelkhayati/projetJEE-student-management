<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <meta charset="UTF-8">
    <title>Courses List</title>
</head>
<body class="m-5">
<div class="container mt-5">
    <h1>Courses List</h1>
    <div class="mb-3">
        <a href="students" class="btn btn-primary">Students</a>
        <a href="courses?action=new" class="btn btn-success">Add New Course</a>
        <a href="enrollments" class="btn btn-primary">Enrollments</a>
        <a href="payments" class="btn btn-primary">Payments</a>
    </div>
    <table class="table table-bordered table-hover">
        <thead class="thead-light">
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Credits</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listCourses}" var="course">
                <tr>
                    <td>${course.id}</td>
                    <td>${course.title}</td>
                    <td>${course.description}</td>
                    <td>${course.credit}</td>
                    <td><a href="courses?action=edit&id=${course.id}" class="btn btn-sm btn-warning"><i class="bi bi-pencil-square"></i></a></td>
                    <td><a href="courses?action=delete&id=${course.id}" class="btn btn-sm btn-danger" onclick="return confirm('Are you sure?')"><i class="bi bi-trash-fill"></i></a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
