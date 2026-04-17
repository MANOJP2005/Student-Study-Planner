<%@ page import="java.util.*, model.Subject" %>

<%
if(session.getAttribute("user") == null){
    response.sendRedirect("login.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
<title>Dashboard</title>
<meta charset="UTF-8">

<link rel="stylesheet" href="/SmartStudyPlanner/css/style.css">

</head>

<body class="app-bg">

<!-- Logout Button -->
<form action="/SmartStudyPlanner/logout" method="get">
    <button class="logout-btn">🚪 Logout</button>
</form>

<h2>Your Study Plan</h2>

<!-- AI Suggestion Box -->
<div class="ai-box">
    <h3>AI Suggestion: Focus more on harder subjects and incomplete tasks.</h3>
</div>

<br>

<!-- Table -->
<table border="1">
<tr>
    <th>Subject</th>
    <th>Difficulty</th>
    <th>Hours</th>
    <th>Status</th>
</tr>

<%
List<Subject> subjects = (List<Subject>) request.getAttribute("subjects");

if(subjects != null){
    for(Subject s : subjects){
%>

<tr>
    <td><%= s.getName() %></td>
    <td><%= s.getDifficulty() %></td>
    <td><%= s.getHours() %></td>
    <td>
        <input type="checkbox" onclick="markDone(this)">
    </td>
</tr>

<%
    }
}
%>

</table>

<br>

<!-- Progress Bar -->
<div class="progress-container">
    <div id="progressBar" class="progress-bar">0%</div>
</div>

<script>
function markDone(checkbox) {
    let checkboxes = document.querySelectorAll("input[type='checkbox']");
    let total = checkboxes.length;
    let done = 0;

    checkboxes.forEach(cb => {
        if(cb.checked) done++;
    });

    let percent = total === 0 ? 0 : Math.round((done / total) * 100);

    let bar = document.getElementById("progressBar");
    bar.style.width = percent + "%";
    bar.innerText = percent + "%";
}
</script>

</body>
</html>