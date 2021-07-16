<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Results</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <table class="table table-hover" id="dev-table">
        <thead>
        <tr>
            <th>Id Result</th>
            <th>Mark</th>
            <th>Review</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="result" items="${results}">
            <tr>
                <td>${result.id}</td>
                <td>${result.mark}</td>
                <td>${result.review}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<a href="home">Home</a>
<br>
<a href="student">Students</a>
<br>
<a href="teacher">Teachers</a>
<br>
<a href="task">Tasks</a>
</body>
</html>
