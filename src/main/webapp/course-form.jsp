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
    <title><c:choose><c:when test="${not empty course}">Edit Course</c:when><c:otherwise>Add Course</c:otherwise></c:choose></title>
</head>
<body class="m-5">
<div class="container mt-5">
    <h1 class="mb-4"><c:choose><c:when test="${not empty course}">Edit Course</c:when><c:otherwise>Add Course</c:otherwise></c:choose></h1>
    <form action="courses" method="post">
        <c:if test="${not empty course}">
            <input type="hidden" name="id" value="${course.id}">
            <input type="hidden" name="action" value="update">
        </c:if>
        <c:if test="${empty course}">
            <input type="hidden" name="action" value="insert">
        </c:if>
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" class="form-control" value="${course != null ? course.title : ''}" required>
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea id="description" name="description" class="form-control" required>${course != null ? course.description : ''}</textarea>
        </div>
        <div class="form-group">
            <label for="credit">Credits:</label>
            <input type="number" id="credit" name="credit" class="form-control" value="${course != null ? course.credit : ''}" required min="0">
        </div>
        <button type="submit" class="btn btn-primary">
            <c:choose>
                <c:when test="${not empty course}">Update</c:when>
                <c:otherwise>Submit</c:otherwise>
            </c:choose>
        </button>
    </form>
</div>
</body>
</html>
