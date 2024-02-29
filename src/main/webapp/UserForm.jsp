<%@page import="com.techpalle.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserForm</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-info container">
  <div class="container-fluid ">
    <a class="navbar-brand" href="#">User Management System</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav me-auto mb-2 mb-Lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/list">User</a>
        </li>
       </ul>
    </div>
  </div>
</nav>
<%-- <%User u=(User)request.getAttribute("list"); %> --%>  
	<center>
	
	<c:if test="${list==null }">
		<form action="insert" method="post">
	</c:if>
	<c:if test="${list!=null }">
		<form action="update" method="post">
	</c:if>
	
	<h2 align="center">
		<c:if test="${list==null }">
		ADD USER
		</c:if>
		<c:if test="${list!=null }">
		EDIT USER
		</c:if>
	</h2>
	
	<div  style="width:300px;">
		<div>
			<input type="hidden" class="form-control" value="${list.id }" id="floatingInput0"  name="id">
		</div>
		<div class="form-floating mb-3">
 	 		<input type="text" class="form-control" value="${list.name }" id="floatingInput1"  name="name">
  			<label for="floatingInput1">Name</label>
		</div>
		<div class="form-floating mb-3">
  			<input type="email" class="form-control" value="${list.email}" id="floatingInput2"  name="email">
  			<label for="floatingInput2">Email</label>
		</div>
		<div class="form-floating mb-3">
  			<input type="text" class="form-control" value="${list.city}" id="floatingInput3" name="city">
  			<label for="floatingInput3">City</label>
		</div>
		<input type="submit" value="SAVE" id="btnsave" class="btn btn-success" style="width:200px">
	</div>
	</center>
</form>
</body>
</html>	