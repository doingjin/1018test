<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>zzin._.MAIN</title>
<script type="text/javascript">
	function logout(){
		var res=confirm("Do you really want to log out?");
		//console.log(res);
		if (res==true) {
			  location.href="logout.do";
		} else {
			return false;
		}
	}
</script>
<style type="text/css">
table{
	width: 40%;
	text-align: center;
}
.disabled{
	color: lightgrey
	;
	font-style: italic;
}
.active{
	font-weight: bold;
	color: #FFDA62;
}
a{
	color: coral;
}
</style>
</head>
<body>

<a href="main.do">MAIN</a>
<h2>Welcome, <span style="color:coral">${mem}</span> ;)</h2>
<button onclick="logout()">LogOut</button>
<button onclick="location.href='insert.jsp'">write</button>


<table border="1">
	<thead style="background:lightgrey;">
		<tr>
			<th>num</th>
			<th style="width:50%">title</th>
			<th>ID</th>
			<th>date</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="v" items="${datas}">
			<tr>
				<td>${v.pnum}</td>
				<td><a href="post.do?pnum=${v.pnum}">${v.title}</a></td>
				<td>${v.mid}</td>
				<td>${v.pdate}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

	<div class="paging toolbar-bottom" id="paging">
		<c:if test="${paging.pageNo==paging.firstPageNo}">
			<span class="disabled">prev</span>
		</c:if>
		<c:if test="${paging.pageNo!=paging.firstPageNo}">
			<a href="main.do?page=${paging.prevPageNo}" class="button">prev</a>
		</c:if>
		<c:forEach var="i" begin="${paging.startPageNo}"
			end="${paging.endPageNo}" step="1">
			<c:choose>
				<c:when test="${i eq paging.pageNo}">
					<span class="active">${i}</span>
				</c:when>
				<c:otherwise>
					<a href="main.do?page=${i}" class="page">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.pageNo==paging.finalPageNo}">
			<span class="disabled">next</span>
		</c:if>
		<c:if test="${paging.pageNo!=paging.finalPageNo}">
			<a href="main.do?page=${paging.nextPageNo}" class="button">next</a>
		</c:if>
	</div>
</body>
</html>