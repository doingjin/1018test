<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>zzin._.SignUp</title>
</head>
<body>
<h2>Create Account</h2>
<form method="post" action="signup.do">
	<table>
		<tr>
			<td>ID</td>
			<td><input type="text" name="mid"></td>			
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="mpw"></td>			
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="mpw2"></td>			
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="SignUp"></td>			
		</tr>
	</table>
	
</form>

</body>
</html>