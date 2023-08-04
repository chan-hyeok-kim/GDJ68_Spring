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
		<h1 class="mb-2">${board}</h1>

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
						
						<td>
						<c:catch>
						<!-- jsp에서 예외처리 -->
						<c:forEach begin="1" end="${n.depth}">--</c:forEach>
						</c:catch>
						
						<a href="./detail?boardNum=${n.boardNum}">${n.boardName}</a></td>
                         
						<td>${n.writer}</td>
						
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
					<li class="page-item"><a class="page-link move"
						href="#" data-num="${pager.startNum}">Previous</a></li>
				</c:if>
				<c:if test="${pager.startNum ne 1}">
					<li class="page-item"><a class="page-link move"
						href="#" data-num="${pager.startNum-1}">Previous</a></li>
				</c:if>

				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					<li class="page-item"><a class="page-link move"
						href="#" data-num="${i}">${i}</a></li>
				</c:forEach>


				<li class="page-item ${pager.next?'':'disabled'}"><a
					class="page-link move" href="#" data-num="${pager.lastNum+1}">Next</a></li>

			</ul>
		</nav>

		<table>

			<tr>
				<form action="./list" method="get" id="frm">
				<input type="hidden" value="${pager.page}" name="page" id="page">
				<td><select class="form-select" id="se1" name="kind"
					aria-label="Default select example" data-kind="${pager.kind}">
						<option value="name" class="op">제목</option>
						<option value="writer" class="op">작성자</option>
						<option value="contents" class="op">내용</option>
				</select></td>
				<td><input type="search" value="${pager.search}" name="search" placeholder="Search"
					></td>
				<td><input type="submit" value="검색" class="btn btn-dark" id="input1">
				</td>
				</form>
			</tr>
		</table>

	</section>
	<script src="/resources/js/list.js"></script>

</body>
</html>