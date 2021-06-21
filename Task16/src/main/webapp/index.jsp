<html>
<head>
    <meta charset="utf-8">
    <title>Home</title>
</head>
<body>

<form id="myform">
    <select id="mymenu">
        <option value="http://localhost:8080/Task16_war/students">Students</option>
        <option value="http://localhost:8080/Task16_war/teachers">Teachers</option>
        <option value="http://localhost:8080/Task16_war/tasks">Tasks</option>
    </select>
    <input type="button" value="Select"
           onclick="window.location=document.forms[0].mymenu.options[document.forms[0].mymenu.selectedIndex].value"/>
</form>

</body>
</html>
