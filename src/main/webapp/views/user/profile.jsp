<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Profile</title>
<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/index.css"/>
</head>
<body>
<%@include file="user_header.jsp" %>
<div class="profile-container">
	<p><label>Id:</label> ${userAtt.u_id}</p>
	<p><label>Name:</label> ${userAtt.name}</p>
	<p><label>Email:</label> ${userAtt.email}</p>

	<form action="/user/profile" method="post" style="margin-top: 20px;">
		<input type="submit" name="eprofile" value="Edit Profile" class="btn btn-primary"/>
		<input type="submit" name="cpassword" value="Change Password" class="btn btn-secondary"/>
	</form>
</div>
</body>
</html>
