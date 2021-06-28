<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admins</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
<h5 class="text-danger">Time session: ${timeSession} seconds</h5>
<div class="container">
    <table class="table table-hover" id="dev-table">
        <thead>
        <tr>
            <th>Id Admin</th>
            <th>Name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="admin" items="${admins}">
            <tr>
                <td>${admin.id}</td>
                <td>${admin.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h5 class="text-success">Cookie input: ${cookieValue}</h5>
</div>

<a href="home">Home</a>
<br>
<a href="teacher">Teachers</a>
<br>
<a href="course">Courses</a>
</body>
</html>
