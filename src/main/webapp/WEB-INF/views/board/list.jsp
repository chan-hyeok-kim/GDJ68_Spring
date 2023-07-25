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
				<c:forEach items="${list}" var="n">
					<tr>
						<td>${n.boardNum}</td>
						<td><a href="./detail?boardNum=${n.boardNum}">${n.boardName}</a></td>

						<td>${n.boardWriter}</td>
						<td>${n.boardDate}</td>
						<td>${n.boardHit}</td>
					</tr>

				</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td><a href="./add" class="btn btn-dark">글 작성</a></td>
					<td></td>
					<td></td>
				</tr>

			</tbody>

		</table>
		<table>
			<tr>
				<td><form action="./search" method="get">
						<input type="search" name="boardName" placeholder="Search"
							required></td>
				<td><input type="submit" value="검색" class="btn btn-dark">
					</form></td>

			</tr>
		</table>

	</section>
</body>
</html>