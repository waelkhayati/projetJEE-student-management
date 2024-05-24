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
    <title>Students List</title>
</head>
<body class="m-5">
<div class="container mt-5">
    <h1>Students List</h1>
    <div class="mb-3">
        <a href="students?action=new" class="btn btn-success">Add New Student</a>
        <a href="courses" class="btn btn-primary">Courses</a>
        <a href="enrollments" class="btn btn-primary">Enrollments</a>
        <a href="payments" class="btn btn-primary">Payments</a>
    </div>
    <table class="table table-bordered table-hover">
        <thead class="thead-light">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Department</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listStudent}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.email}</td>
                    <td>${student.department}</td>
                    <td><a href="students?action=edit&id=${student.id}" class="btn btn-sm btn-warning"><i class="bi bi-pencil-square"></i></a></td>
                    <td><a href="students?action=delete&id=${student.id}" class="btn btn-sm btn-danger" onclick="return confirm('Are you sure you want to delete this?')"><i class="bi bi-trash-fill"></i></a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
