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
<h1 align="center">create/update Feedback</h1>
        <form:form action="SaveFeedback" method="post" modelAttribute="feedback">
        <table>
            <tr>
                <td>Reason:</td>
                <td><form:input path="reason"/></td>
                <td><form:errors path="reason"/></td>
            </tr>
            <tr>
                <td>Feedback:</td>
                <td><form:select path="feedbackState" items="${feedbackstates}">
                </form:select></td>
            </tr>
            <tr>
                <td>Interviewer:</td>
                <td><form:select path="idInterviewer" items="${developers}"></form:select></td>
            </tr>
            <tr>
                <td>Interview:</td>
                <td><form:select path="idInterview" items="${interviews}"></form:select></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
</body>
</html>