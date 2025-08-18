<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Task</title>
<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/index.css"/>

</head>
<body>
 	<%@include file="../user/user_header.jsp" %>
		<form class="form-container" action="/task/editTask" method="post">
			
				<input type="hidden" name="Id" value="${task.id}" />
				<label><b><i>Enter Title</i></b></label><br>
				<input type="text" name="title" value="${task.title }" required/><br><br>
				<label><b><i>Enter Description</i></b></label><br>
				<input type="text" name="description" value="${task.description }" required/><br><br>
				<label><b><i>Enter DueDate</i></b></label><br>
				<input type="date" name="dueDate" value="${task.dueDate }" required/><br><br>
				<input type="submit" value="Submit" /><br><br>
		</form>
	
</body>
</html>