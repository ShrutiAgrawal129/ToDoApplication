<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Tasks</title>
<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/index.css"/>
</head>
<body>
<%@include file="../user/user_header.jsp" %>
<br><br>
<div class="container mt-5">
    <h2 class="text-center mb-4">Your Tasks</h2>
    <div class="table-responsive">
        <table class="table table-bordered table-striped table-hover align-middle">
            <thead class="table-dark">
                <tr>
                    <th scope="col">Task Id</th>
                    <th scope="col">Title</th>
                    <th scope="col">Description</th>
                    <th scope="col">Due Date</th>
                    <th scope="col">Status</th>
                    <th scope="col">Update Status</th>
                    <th scope="col">Edit/Delete Task</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="task" items="${tasks}">
                <tr>
                    <td>${task.getId()}</td>
                    <td>${task.title}</td>
                    <td>${task.description}</td>
                    <td>${task.dueDate}</td>
                    <td>
                        <c:choose>
                            <c:when test="${task.status == true}">
                                ✅ Completed
                            </c:when>
                            <c:when test="${task.status == false}">
                                ⏳ Pending
                            </c:when>
                            <c:otherwise>
                                ❓ Unknown
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <form action="/task/view_tasks" method="post" class="d-inline">
                            <input type="hidden" name="Id" value="${task.id}" />
                            <c:if test="${task.status != true}">
                                <button type="submit" class="btn btn-success btn-sm">Mark as Completed</button>
                            </c:if>
                            <c:if test="${task.status == true}">
                                <button type="submit" class="btn btn-secondary btn-sm" disabled>Mark as Completed</button>
                            </c:if>
                        </form>
                    </td>
                    <td>
	                    <form action="/task/update_task" method="post" class="d-inline">
	                     <input type="hidden" name="Id" value="${task.id}" />
		                     <input type="submit" class="btn btn-primary btn-sm" value="Edit" name="edit"/></t>
		                     <input type="submit" class="btn btn-danger btn-sm" value="Delete" name="delete"/>
	                    </form>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
