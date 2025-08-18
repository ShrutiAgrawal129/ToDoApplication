<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>
<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/index.css"/>
</head>
<body>
<%@include file="user_header.jsp" %>
<div class="form-container">
	<h3>Edit Email</h3>
	<form action="/user/edit_profile" method="post">
		<input type="email" name="email" placeholder="Enter new email" required />
		<input type="submit" name="submit" value="Change"/>
	</form>
</div>
</body>
</html>
