<%
if(request.getParameter("error") != null){
%>
<p class="error">Registration Failed</p>
<% } %>
<!DOCTYPE html>
<html>
<head>
<title>Register</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="/SmartStudyPlanner/css/style.css">
</head>

<body class="login-bg">

<div class="container login-box">

<h2>Create Account</h2>

<form action="<%=request.getContextPath()%>/register" method="post">
<input type="text" name="username" placeholder="Username" required>

<input type="password" name="password" placeholder="Password" required>

<button type="submit">Register</button>

</form>

<br>

<a href="login.jsp">Already have an account? Login</a>

</div>

</body>
</html>