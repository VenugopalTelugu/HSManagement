<%@page import="java.util.ArrayList"%>
<%@page import="com.techpalle.model.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USER MANAGEMENT SYSTEM</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-info container" style="border-radius:5px">
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
<h1 style="color:blue" align="center">USER MANAGEMENT SYSTEM</h1>
<hr class="container">

<div class="container">
	<a href="<%=request.getContextPath()%>/add" class="btn btn-warning mb-1">ADD USER</a>
	<br>
	<table class="table table-striped table-hover table-success">
		<thead class="table-dark">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>City</th>
				<th>Action</th>
			</tr>
		</thead>
		
		<tbody>
			<a:forEach var="d" items="${display}">
			<tr>
				<td><a:out value="${d.id }"></a:out></td>
				<td><a:out value="${d.name }"></a:out></td>
				<td><a:out value="${d.email }"></a:out></td>
				<td><a:out value="${d.city }"></a:out></td>
				<td><a href="edit?id=<a:out value="${d.id}"></a:out>" class="btn btn-success">EDIT</a> &nbsp;&nbsp;<a href="delete?id=<a:out value="${d.id}" ></a:out>" class="btn btn-danger">DELETE</a></td>
			</tr>
			</a:forEach>
		</tbody>
		
		<%-- <tbody>
		<%ArrayList<User> al=(ArrayList<User>)request.getAttribute("display"); %>
		<%for(User u: al){ %>
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getName()%></td>
				<td><%=u.getEmail()%></td>
				<td><%=u.getCity()%></td>
				<td><a href="<%=request.getContextPath()%>/edit?id=<%=u.getId()%>">EDIT</a>&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/delete?id=<%=u.getId()%>">DELETE</a></td>
			</tr>
		<%
		}
		%>
		</tbody> --%>
		
		
	</table>
</div>
</body>
</html>