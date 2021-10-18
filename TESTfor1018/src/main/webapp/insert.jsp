<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>zzin._.WRITE</title>
<style type="text/css">
table{
	width: 40%;
	text-align: center;
	border-collapse: collapse;
}
th, td {
    padding: 5px;
}
.tt{
	background: lightgrey;
	font-weight: bold;
}
input:focus, textarea:focus{
	outline: none;
}
a{
	color: coral;
}
</style>
</head>
<body>
<a href="main.do">MAIN</a>
<h2>WRITE</h2>
<br>
<form method="post" action="insert.do">
	<input type="hidden" name="mid" value="${mem}">
	<table border="1">
		<tr>
			<td class="tt">title</td>
			<td><input type="text" name="title" style="width:100%; border: 0;"></td>
		</tr>
		<tr>
			<td class="tt">content</td>
			<td><textarea name="content" style="width:100%; height:300px; border: 0; resize: none;"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="write"></td>
		</tr>
	</table>
</form>

</body>
</html>