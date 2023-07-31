<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../temp/header.jsp"></c:import>
<section class="container mt-5">
<table class="table mb-4text-center">
		<thead class="table-dark">
			<th style="width:70%">SUBJECT</th>
			<th style="width:10%">NAME</th>
			<th style="width:10%">DATE</th>
			<th style="width:10%">HIT</th>
		</thead>
		<tbody>
			<tr>
				<td>${board.boardName}</td>
				<td>${board.boardWriter}</td>
				<td>${board.boardDate}</td>
				<td>${board.boardHit}</td>
			</tr>
			<tr>
				<td colspan="4">${board.boardContents}</td>
			</tr>
			</tbody>
	</table>

<a href="./list" class="btn btn-dark">List</a>
<a href="./update?boardNum=${board.boardNum}" class="btn btn-dark">수정</a>
<a href="./delete?boardNum=${board.boardNum}" class="btn btn-dark">삭제</a>
<a href="./detail?boardNum=${board.boardNum}" class="btn btn-dark">답글 등록</a>


</section>
</body>
</html>