<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HeaderFile</title>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark fixed-top">
    <div class="container">
    	<img src="${pageContext.request.contextPath}/assets/images/todo-icon-4.jpg" alt="Icon" width="26" height="26"></t>
        <a class="navbar-brand fw-bold" href="/index">ToDoApp</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" href="/logIn">Log In</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/register">Register</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#about">About</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>