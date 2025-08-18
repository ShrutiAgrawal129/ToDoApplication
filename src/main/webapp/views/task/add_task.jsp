<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Task</title>
<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/index.css"/>

</head>
<body>
<%@include file="../user/user_header.jsp" %>
	<form class="form-container" action="/task/add_task" method="post">
		<label>Task Title:</label>
		<input type="text" name="title" required/><br><br>
		<label>Task Description:</label>
		<input type="text" name="description" required/><br><br>
		<label>DueDate (date & time):</label>
		<input type="date" name="dueDate" required /><br><br>
		<label>Reminder Time (date & time):</label>
    <input type="datetime-local" name="reminderTime" required /><br><br>
		<input type="submit"  value="Submit"/><br><br>
	</form>
</body>
</html>