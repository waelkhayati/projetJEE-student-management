<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <meta charset="UTF-8">
    <title>Payments List</title>
</head>
<body class="m-5">
<div class="container mt-5">
    <h1>Payments List</h1>
    <div class="mb-3">
        <a href="students" class="btn btn-primary">Students</a>
        <a href="courses" class="btn btn-primary">Courses</a>
        <a href="enrollments" class="btn btn-primary">Enrollments</a>
        <a href="payments?action=new" class="btn btn-success">Add New Payment</a>
    </div>
    <table class="table table-bordered table-hover">
        <thead class="thead-light">
            <tr>
                <th>ID</th>
                <th>Student</th>
                <th>Amount</th>
                <th>Date</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
		    <c:forEach items="${listPayments}" var="payment">
		        <tr>
		            <td>${payment.id}</td>
		            <td>${payment.studentName}</td>
		            <td>${payment.amount}</td>
		            <td><fmt:formatDate value="${payment.date}" pattern="yyyy-MM-dd" /></td>
		            <td><a href="payments?action=edit&id=${payment.id}" class="btn btn-sm btn-warning"><i class="bi bi-pencil-square"></i></a></td>
		            <td><a href="payments?action=delete&id=${payment.id}" class="btn btn-sm btn-danger" onclick="return confirm('Are you sure?')"><i class="bi bi-trash-fill"></i></a></td>
		        </tr>
		    </c:forEach>
		</tbody>
    </table>
</div>
</body>
</html>
