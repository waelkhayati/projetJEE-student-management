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
    <title><c:choose><c:when test="${not empty student}">Edit Student</c:when><c:otherwise>Add Student</c:otherwise></c:choose></title>
</head>
<body class="m-5">
<div class="container mt-5">
    <h1><c:choose><c:when test="${not empty student}">Edit Student</c:when><c:otherwise>Add Student</c:otherwise></c:choose></h1>
    <form action="students" method="post">
        <c:if test="${not empty student}">
            <input type="hidden" name="id" value="${student.id}">
            <input type="hidden" name="action" value="update">
        </c:if>
        <c:if test="${empty student}">
            <input type="hidden" name="action" value="insert">
        </c:if>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" class="form-control" value="${student != null ? student.name : ''}" required>
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" class="form-control" value="${student != null ? student.email : ''}" required>
        </div>

        <div class="form-group">
            <label for="department">Department:</label>
            <input type="text" id="department" name="department" class="form-control" value="${student != null ? student.department : ''}" required>
        </div>

        <button type="submit" class="btn btn-primary">
            <c:choose>
                <c:when test="${not empty student}">Update</c:when>
                <c:otherwise>Submit</c:otherwise>
            </c:choose>
        </button>
    </form>
</div>
</body>
</html>
