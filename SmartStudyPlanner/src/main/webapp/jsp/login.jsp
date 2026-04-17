<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta charset="UTF-8">

<link rel="stylesheet" href="/SmartStudyPlanner/css/style.css">

</head>

<body class="login-bg">

<div class="container login-box">

<h2>🔐 Login</h2>

<form action="<%=request.getContextPath()%>/login" method="post">

<input type="text" name="username" placeholder="Username" required>

<input type="password" name="password" placeholder="Password" required>

<button type="submit">Login</button>

</form>

<%
if(request.getParameter("error") != null){
%>
<p class="error">Invalid Credentials</p>
<% } %>

<br>

<a href="<%=request.getContextPath()%>/jsp/register.jsp">Create Account</a>

</div>

</body>
</html>