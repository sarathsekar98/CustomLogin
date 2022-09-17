<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
<script src="https://kit.fontawesome.com/6aa6f9bece.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="container-fluid">
<div class="row justify-content-center m-3">
<div class="col-md-12 bg-dark p-3 pt-5 ">
<c:if test="${success==2}">
 <span>user updated successfully</span>
</c:if>
<table class="table table-striped table-bordered text-center border-info text-white">
<thead class="bg-dark text-primary">
<tr>
<th>FirstName</th>
<th>LastName</th>
<th>Email</th>
<th>Password</th>
<th>Action</th>
</tr>
</thead>
<tbody>
<c:forEach var="user" items="${users}">
<tr>
<td>${user.firstname}</td>
<td>${user.lastname}</td>
<td>${user.email}</td>
<td>${user.password}</td>
<td class="text-center"><a href="./update?id=${user.id}" class="mr-3"><i class="fa-solid fa-wrench text-primary"></i></a><a href="./delete?id=${user.id}"><i class="fa-regular fa-trash text-danger"></i></a></td>
</tr>
</c:forEach>
</tbody>
</table></div></div></div>
</body>
</html>