<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Demo SQL Injection</title>
<link rel="stylesheet" type="text/css" href="css/c.css">
</head>
<body>
	<div style="text-align: center">
		<h1>Admin Login</h1>
		<form action="login" method="post" id="loginForm">
			<label for="username">Username:</label> 
			<input name="username" size="30" required /> 
			<br> 
			<br> 
			<label for="password">Password:</label>
			<input type="password" name="password" size="30" required /> 
			<br>
			${message}
			<br> 
			<br>
			<button type="submit">Login</button>
		</form>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$("#loginForm").validate({
			rules : {
				username : "required",
				password : "required"
			},
			messages : {
				username : "Please enter username",
				password : "Please enter password"
			}
		});

	});
</script>
</html>