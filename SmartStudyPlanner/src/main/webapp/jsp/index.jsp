<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<%
if(session.getAttribute("user") == null){
    response.sendRedirect("login.jsp");
}
%>
<%
if(session.getAttribute("user") == null){
    response.sendRedirect("login.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<title>Smart Study Planner</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="/SmartStudyPlanner/css/style.css">
<style>
body {
    font-family: Arial;
    background: linear-gradient(to right, #4facfe, #00f2fe);
    text-align: center;
}

.container {
    background: white;
    padding: 20px;
    margin: 50px auto;
    width: 50%;
    border-radius: 10px;
    box-shadow: 0 0 10px gray;
}

input, select {
    padding: 8px;
    margin: 5px;
}

button {
    padding: 10px 15px;
    background: #4facfe;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

button:hover {
    background: #007bff;
}
</style>

<script>
function addRow() {
    var table = document.getElementById("subjectTable");
    var row = table.insertRow();

    row.innerHTML = `
        <td><input type="text" name="name"></td>
        <td>
            <select name="difficulty">
                <option>Easy</option>
                <option>Medium</option>
                <option>Hard</option>
            </select>
        </td>
    `;
}
</script>

</head>

<body class="app-bg">
<div class="container">

<h2>📘 Smart Study Planner</h2>

<form action="/SmartStudyPlanner/planner" method="post">

<table id="subjectTable" align="center">
<tr>
    <th>Subject</th>
    <th>Difficulty</th>
</tr>

<tr>
    <td><input type="text" name="name"></td>
    <td>
        <select name="difficulty">
            <option>Easy</option>
            <option>Medium</option>
            <option>Hard</option>
        </select>
    </td>
</tr>

</table>

<br>

<button type="button" onclick="addRow()">➕ Add Subject</button>
<br><br>

<button type="submit">🚀 Generate Plan</button>

</form>

</div>

</body>
</html>