<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tasks</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <table class="table table-hover" id="dev-table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="task" items="${tasks}">
            <tr>
                <td>${task.id}</td>
                <td>${task.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<a href="home">Home</a>
<br>
<a href="result">Results</a>
<br>
<a href="course">Courses</a>
<br>
<a href="student">Students</a>
</body>
</html>
