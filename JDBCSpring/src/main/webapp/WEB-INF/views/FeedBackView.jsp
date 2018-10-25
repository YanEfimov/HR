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
	<h1 align="center">View feedback</h1>
	<table border="1">
		<tr>
			<th>Reason</th>
			<th>FeedbackState</th>
			<th>Interviewer</th>
			<th>Interview</th>
		</tr>
		<c:forEach var="feedback" items="${list}">
			<tr>
				<td><c:out value="${feedback.reason}"></c:out></td>
				<td><c:out value="${feedback.feedbackState}"/></td>
				<td><c:out value="${feedback.interviewername}"/></td>
				<td><c:out value="${feedback.interviewname}"/></td>
				<td><a href="FeedBackEdit?id=${feedback.id}">Edit</a></td>
			    <td><a href="FeedBackDelete?id=${feedback.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<footer>
		<p align="center"><a href="FeedbackCreate">Create feedback</a></p>
	</footer>
</body>
</html>