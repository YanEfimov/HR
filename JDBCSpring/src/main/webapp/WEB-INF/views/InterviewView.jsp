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
	<h1 align="center">View Interview</h1>
	<span style="float: right">
		<p>Filter by|<a href="InterviewView">Find all</a></p>
    	<p>Sort by|<a href="SortPlanDate">Plan date</a> 
    	| 
    	<a href="SortFactDate">Fact date</a></p>
	</span>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>FactDate</th>
			<th>PlanDate</th>
			<th>Vacacny</th>
			<th>Candidate</th>
		</tr>
		<c:forEach var="interview" items="${list}">
			<tr>
				<td><c:out value="${interview.name}"/></td>
				<td><c:out value="${interview.factDate}"/></td>
				<td><c:out value="${interview.planDate}"/></td>
				<td><c:out value="${interview.vacancyname}"/></td>
				<td><c:out value="${interview.candidatename}"/></td>
			    <td><a href="InterviewEdit?id=${interview.id}">Edit</a></td>
			    <td><a href="InterviewDelete?id=${interview.id}">Delete</a></td>
		</c:forEach>
	</table>
	<footer>
		<p align="center"><a href="InterviewCreate">Create interview</a></p>
	</footer>
</body>
</html>