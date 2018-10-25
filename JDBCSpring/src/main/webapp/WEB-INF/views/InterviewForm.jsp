<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">create/update interview</h1>
        <form:form action="SaveInterview" method="post" modelAttribute="interview">
        <table>
        	<form:hidden path="id"/>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" /></td>
                <td><form:errors path="name"/></td>
            </tr>
            <tr>
                <td>PlanDate:</td>
                <td><form:input path="planDate" /></td>
                <td><form:errors path="planDate"/></td>
            </tr>
            <tr>
                <td>FactDate:</td>
                <td><form:input path="factDate"/></td>
                <td><form:errors path="factDate"/></td>
            </tr>
            <tr>
                <td>Vacancy:</td>
                <td><form:select path="idVacancy" items="${vacancys}"></form:select>
            </tr>
            <tr>
                <td>Candidate:</td>
                <td><form:select path="idCandidate" items="${candidates}"></form:select>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
</body>
</html>