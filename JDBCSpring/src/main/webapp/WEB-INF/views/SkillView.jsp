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
	<span style="float: right">
		<p><a href="ViewSkillForm">Find all</a></p>
    	<p>Sorting by|<a href="SkillSort">name</a></p>
	</span>
	<h1 align="center">View skill</h1>
	<table border="1">
		<tr>
			<th>Skill</th>
		</tr>
		<c:forEach var="skill" items="${list}">
			<tr>
				<td><c:out value="${skill.name}"/></td>
				<td><a href="SkillDelete?name=${skill.name}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<footer>
		<p align="center"><a href="SkillCreate">Create skill</a></p>
	</footer>
</body>
</html>