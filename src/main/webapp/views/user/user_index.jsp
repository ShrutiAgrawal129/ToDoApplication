<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToDo Application Dashboard User Panel</title>

<!-- Bootstrap CDN -->
<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/index.css"/>

</head>
<body>

<!-- Navbar -->
<%@ include file="user_header.jsp" %>

<!-- Hero Section -->
<header class="hero">
    <h1>Organize Your Day</h1>
    <p>Track. Focus. Achieve more.</p>
</header>

<!-- About Section -->
<section class="section" id="about">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="card about-card">
                    <div class="row g-0">
                        <div class="col-md-6">
                            <img src="https://images.unsplash.com/photo-1506784983877-45594efa4cbe" class="img-fluid w-100 h-100" alt="About App Image">
                        </div>
                        <div class="col-md-6">
                            <div class="card-body">
                                <h2 class="card-title">About the ToDo App</h2>
                                <p class="card-text mt-4">
                                    This powerful ToDo Application helps you manage your daily tasks effortlessly. Whether it’s a busy work schedule or personal goals, track everything in one place with clarity and ease.
                                </p>
                                <ul class="mt-3">
                                    <li>Create, update, and delete tasks</li>
                                    <li>Secure user login and registration</li>
                                    <li>Responsive design for all devices</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>    
</section>

<!-- Bootstrap JS -->
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>

</body>
</html>
