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

		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<c:if test="${pager.startNum eq 1}">
					<li class="page-item"><a class="page-link"
						href="./list?page=${pager.startNum}&kind=${pager.kind}&search=${pager.search}">Previous</a></li>
				</c:if>
				<c:if test="${pager.startNum ne 1}">
					<li class="page-item"><a class="page-link"
						href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">Previous</a></li>
				</c:if>

				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					<li class="page-item"><a class="page-link"
						href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
				</c:forEach>


				<li class="page-item ${pager.next?'':'disabled'}"><a
					class="page-link" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">Next</a></li>

			</ul>
		</nav>

		<table>

			<tr>
				<form action="./list" method="get">
				<td><select class="form-select" name="kind" multiple
					aria-label="Multiple select example">
						<option value="name">제목</option>
						<option value="writer">작성자</option>
						<option value="contents">내용</option>
				</select></td>
				<td><input type="search" name="search" placeholder="Search"
					></td>
				<td><input type="submit" value="검색" class="btn btn-dark">
				</td>
				</form>
			</tr>
		</table>

	</section>
</body>
</html>