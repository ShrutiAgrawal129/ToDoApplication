<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet"/>
 <link href="${pageContext.request.contextPath}/assets/css/index.css" rel="stylesheet"/>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="form-container">
    <h3>Register</h3>
    <form action="/register" method="post">
        <input type="text" name="name" placeholder="Enter your name" required />
        <input type="email" name="email" placeholder="Enter your email" required />
        <input type="password" name="password" placeholder="Enter your password" required />
        <input type="submit" value="Register" />
    </form>
</div>
</body>
</html>
