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
</head>
<body>
<div class="container">
<div class="row justify-content-center">
<div class="col-md-8 ">
<div class="my-3 p-5 rounded bg-dark text-white">
<c:url value="/login" var="login" />
<c:if test="${param.logout != null}">
 <center><span class="text-center text-success">successfuly logged out</span></center>
</c:if>
<c:if test="${param.error != null}">
 <center><span class="text-center text-warning">please give me a correct input</span></center>
</c:if>
<form action="${login}" method="post">
<p class="text-center" style="font-size:30px;">Login</p>
<label for="firstname \">UserName</label>
<input class="form-control mb-2" name="username" type="text"/>
<label for="password ">Password</label>
<input class="form-control" name="password" type="password"/>
<br>
<center><input class="btn btn-info btn-sm mx-2" type="submit" value="Login"><a href="./registration" class="btn btn-sm btn-warning ml-1">cancel</a></center>
</form>
</div>
</div>
</div>
</div>
</body>
</html>