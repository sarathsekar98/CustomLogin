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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
function add()
{
const xhttp = new XMLHttpRequest();
xhttp.onload = function() {
  // alert(this.responseText);
   
   var s = JSON.parse(this.responseText);
   alert(s.firstname);
  }
xhttp.open("GET", "update1?id=1", true);
xhttp.send();
}
  
</script>
</head>
<body>
<div class="container">
<div class="row justify-content-center">
<div class="col-md-8 ">
<div class="my-3 p-5 rounded bg-dark text-white">
<c:url value="/login" var="login" />
<c:if test="${param.success != null}">
 <center><span class="text-center text-success">successfuly logged out</span></center>
</c:if>
<div id="demo"></div>
<form action="userupdate" method="post" enctype="multipart/form-data">
<p class="text-center" style="font-size:30px;">Update</p>
<input type="hidden" name="id" value="${user.id}">
<label for="firstname \">Firstname</label>
<input class="form-control mb-2" name="firstname" type="text" value="${user.firstname}"/>
<label for="password ">Lastname</label>
<input class="form-control" name="lastname" type="text" value="${user.lastname}"/>
<label for="password">Email</label>
<input class="form-control" name="email" type="text" value="${user.email}"/>
<label for="password ">Password</label>
<input class="form-control" name="password" type="password" value="${user.password}"/>
<label for="Profile">Profile picture</label>
<input class="form-control" name="sample" type="file" />
<br>
<center><input class="btn btn-info btn-sm mx-2" type="button" onclick="add()" value="Update"></center>
</form>
</div>
</div>
</div>
</div>
</body>
</html>