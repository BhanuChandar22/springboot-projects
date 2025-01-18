<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management App</title>
</head>
<body>
<%@ include file="header.html" %>
	<div class="container w-75">
		<c:choose>
		<c:when test="${!empty employees}">
			<table class="table table-hover">
				<p align="center" class="text-success"><b>${empMsg}</b></p>
				<thead class="table-danger">
					<tr >
					<th>Employee No</th>
					<th>Name</th>
					<th>Job</th>
					<th>Hiredate</th>
					<th>Salary</th>
					<th>Operations</th>
				</tr>
				</thead>
				<tbody class="table-info">
					<c:forEach var="employee" items="${employees}">
					<tr  >
						<td>${employee.empno}</td>
						<td>${employee.ename}</td>
						<td>${employee.job}</td>
						<td>${employee.hiredate}</td>
						<td>${employee.salary}</td>
						<td>
							<a href="edit?eno=${employee.empno}"><img src="images/edit2.png" width="30" height="30" /></a>&nbsp;&nbsp;&nbsp;
							<a href="delete?eno=${employee.empno}"><img src="images/delete1.png" width="30" height="30" onclick="return confirm('Are you sure want to delete?')" /></a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<h2 style="color:red;text-align:center">Records not found :(</h2>
		</c:otherwise>
	</c:choose>
	
	<p align="center">
	<a href="register"><img src="images/add1.png"  width="60" height="60"/></a> &nbsp;&nbsp;&nbsp;
	<a href="./" ><img src="images/home.png"  width="60" height="60"/></a>
	</p>
	</div>
</body>
</html>