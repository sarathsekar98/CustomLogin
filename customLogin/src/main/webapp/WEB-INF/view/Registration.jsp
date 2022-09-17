<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
<script>
function registration()
{
	//alert(document.getElementById('firstname').value);
	result=true;
	resultString="";
	if(document.getElementById('firstname').value=="")
	{
		resultString +="please enter the firstname <br>";
		result=false;
	}
	if(document.getElementById('lastname').value=="")
	{
		resultString +="please enter the lastname <br>";
		result=false;
	}
	if(document.getElementById('email').value=="")
	{
		resultString +="please enter the email <br>";
		result=false;
	}
	if(document.getElementById('password').value=="")
	{
		resultString +="please enter the password";
		result=false;	
	}
	document.getElementById('error').innerHTML = resultString;
	return result;
}
</script>
</head>
<body>
<div class="container">
<div class="row justify-content-center">
<div class="col-md-8 ">

<div class="my-3 p-5 rounded bg-dark text-white">
<c:if test="${success != ''}">
<p align="center">${success}</p><br>
</c:if>
<form action="newuser" onsubmit="return registration()" method="post">
<span id="error" class="text-warning"></span>
<p class="text-center" style="font-size:30px;">Registration</p>
<label for="firstname">FirstName</label>
<input class="form-control mb-2" name="firstname" id="firstname" type="text"/>
<label for="LastName ">LastName</label>
<input class="form-control mb-2" name="lastname" id="lastname" type="text"/>

<label for="Email">Email</label>
<input class="form-control mb-2" name="email" id="email" type="text"/>

<label for="firstname ">Password</label>
<input class="form-control" name="password" id="password" type="password"/>
<br>
<center><input class="btn btn-info" type="submit" value="Submit"></center>
</form>
</div>
</div>
</div>
</div>
</body>
</html>