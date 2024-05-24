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
    <title><c:choose><c:when test="${not empty payment}">Edit Payment</c:when><c:otherwise>Add Payment</c:otherwise></c:choose></title>
</head>
<body class="m-5">
<div class="container mt-5">
    <h1><c:choose><c:when test="${not empty payment}">Edit Payment</c:when><c:otherwise>Add Payment</c:otherwise></c:choose></h1>
    <form action="payments" method="post">
        <c:if test="${not empty payment}">
            <input type="hidden" name="id" value="${payment.id}">
            <input type="hidden" name="action" value="update">
        </c:if>
        <c:if test="${empty payment}">
            <input type="hidden" name="action" value="insert">
        </c:if>

        <div class="form-group">
            <label for="studentId">Student:</label>
            <select id="studentId" name="studentId" class="form-control" required>
                <option value="">Select a Student</option>
                <c:forEach items="${listStudents}" var="student">
                    <option value="${student.id}" ${payment != null && student.id == payment.studentId ? 'selected' : ''}>${student.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="amount">Amount:</label>
            <input type="number" id="amount" name="amount" class="form-control" step="0.01" value="${payment != null ? payment.amount : ''}" required>
        </div>

        <div class="form-group">
            <label for="date">Date:</label>
            <input type="date" id="date" name="date" class="form-control" value="${payment != null ? payment.date : ''}" required>
        </div>

        <button type="submit" class="btn btn-primary">
            <c:choose>
                <c:when test="${not empty payment}">Update</c:when>
                <c:otherwise>Submit</c:otherwise>
            </c:choose>
        </button>
    </form>
</div>
</body>
</html>
