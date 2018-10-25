<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">View user</h1>
<span style="float: right">
	<p>Filter by|<a href="ViewUserForm">Find all</a></p>
    <p>Filter by|<a href="UserFilter?type=manager">manager</a> 
    | 
    <a href="UserFilter?type=developer">developer</a></p>
    <p>Sorting by|<a href="UserSortName">name</a></p>
</span>
<table border="1">
	<tr>
		<th>Name</th>
		<th>Surname</th>
		<th>Email</th>
		<th>Password</th>
		<th>Role</th>
	</tr>
	<c:forEach var="user" items="${list}">
		<tr>
			<td><c:out value="${user.name}"></c:out></td>
			<td><c:out value="${user.surname}"/></td>
			<td><c:out value="${user.email}"/></td>
			<td><c:out value="${user.password}"/></td>
			<td><c:out value="${user.role}"></c:out></td>
			<td><a href="UserEdit?id=${user.id}">Edit</a></td>
			<td><a href="UserDelete?id=${user.id}">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<footer>
	<p align="center"><a href="UserCreate">Create user</a></p>
</footer>
</body>
</html>