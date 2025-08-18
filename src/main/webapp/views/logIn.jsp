<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath}/assets/css/index.css" rel="stylesheet"/>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="form-container">
    <h3>Log In</h3>
    <form action="/logIn" method="post">
        <input type="text" name="name" placeholder="Enter Name" required />
        <input type="password" name="password" placeholder="Enter Password" required />
        <input type="submit" value="Log In" />
    </form>
</div>
</body>
</html>
