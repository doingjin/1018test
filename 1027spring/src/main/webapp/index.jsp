<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>zzin._.SignIn</title>
<script type="text/javascript">
	function signup() {
		window.open("signup.jsp","","width=500px,height=500px");
	}
</script>
</head>
<body>
<h2>Sign In</h2>
<form method="post" action="login.do">
	<table>
		<tr>
			<td>ID</td>
			<td><input type="text" name="mid" required></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="mpw" required></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="SignIn"></td>
		</tr>
	</table>
</form>
<a href="" onclick="signup()">SignUp</a>

</body>
</html>