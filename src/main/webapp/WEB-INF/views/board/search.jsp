<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<h1 class="mb-2">NOTICE</h1>

		<table class="table mb-4text-center">
			<thead class="table-dark">
				<th style="width: 10%">NO</th>
				<th style="width: 60%">SUBJECT</th>
				<th style="width: 10%">NAME</th>
				<th style="width: 10%">DATE</th>
				<th style="width: 10%">HIT</th>
			</thead>
			<tbody>
				<c:forEach items="${mto}" var="m">
					<tr>
						<td>${m.boardNum}</td>
						<td><a href="./detail?boardNum=${m.boardNum}">${m.boardName}</a></td>

						<td>${m.boardWriter}</td>
						<td>${m.boardDate}</td>
						<td>${m.boardHit}</td>
					</tr>
				</c:forEach>
				<tr>
				<td></td>
					<td><a href="./list" class="btn btn-dark">List</a></td>
				</tr>
			</tbody>
		</table>


	</section>
</body>
</html>