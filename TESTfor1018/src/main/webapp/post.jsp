<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>zzin._.POST</title>
<script type="text/javascript">
function deletep(){
	//console.log("${data.pnum}" ${data.pnum});
	var res=confirm("Do you really want to delete?");
	if (res==true) {
		  location.href="delete.do?pnum=${data.pnum}";
	} else {
		return false;
	}
}
</script>
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
a{
	color: coral;
}
</style>
</head>
<body>
<a href="main.do">MAIN</a>
<h2>POST</h2>
<c:if test="${mem eq data.mid}">
	<button onclick="deletep()">delete</button>
	<button onclick="location.href='edit.do?pnum=${data.pnum}'">edit</button>
	<br>
</c:if>

<table border="1">
	<tr>
		<td class="tt">title</td>
		<td style="width:70%">${data.title}</td>
	</tr>
	<tr>
		<td class="tt">writer</td>
		<td>${data.mid}</td>
	</tr>
	<tr height="300px">
		<td class="tt">content</td>
		<td>${data.content}</td>
	</tr>
</table>

</body>
</html>