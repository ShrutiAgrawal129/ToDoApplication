<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/index.css"/>
</head>
<body>
<%@include file="user_header.jsp" %>
<div class="form-container">
	<h3>Change Password</h3>
	<form action="/user/change_password" method="post">
		<input type="text" name="opass" placeholder="Enter Old Password" required />
		<input type="password" name="n1pass" placeholder="Enter New Password" required />
		<input type="password" name="n2pass" placeholder="Confirm New Password" required />
		<input type="submit" value="Submit"/>
	</form>
</div>
</body>
</html>
