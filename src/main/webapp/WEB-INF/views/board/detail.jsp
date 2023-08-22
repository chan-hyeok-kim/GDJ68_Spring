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
	<p class="text-center"><h1 class="ms-2">${board}</h1></p>
	<table class="table mb-4text-center">
		<thead class="table-dark">
			<th style="width:70%">SUBJECT</th>
			<th style="width:10%">NAME</th>
			<th style="width:10%">DATE</th>
			<th style="width:10%">HIT</th>
		</thead>
		<tbody>
			<tr>
				<td>${bto.boardName}</td>
				<td>${bto.writer}</td>
				<td>${bto.boardDate}</td>
				<td>${bto.boardHit}</td>
			</tr>
			<tr>
				<td colspan="4">${bto.boardContents}</td>
			</tr>
			<tr>
				<td colspan="4">
				 <c:forEach items="${bto.boardFileDTOs}" var="b">
					<a href="./fileDown?fileNum=${b.fileNum}">${b.originalName}</a>
				</c:forEach> 
				</td>
			</tr>

		</tbody>
	</table>

	<form id="frm">
	<input type="hidden" name="boardNum" value="${bto.boardNum}">
</form>
	<a href="./list" class="btn btn-dark">List</a>
<!-- <a href="./update?boardNum=${bto.boardNum}" class="btn btn-dark">수정</a> -->


<c:if test="${board ne 'NOTICE'}">
<!-- <a href="./reply?boardNum=${bto.boardNum}" class="btn btn-dark">답글 등록</a> -->
<button id="reply" class="btn btn-dark c1" data-url="reply">답글 등록</button>
</c:if> 
<button id="update" class="btn btn-dark c1" data-url="update">수정</button>
<button data-url="delete" class="btn btn-dark c1" id="del" data-delete-name="boardNum" data-delete-num="${bto.boardNum}">삭제</button>

<script src="../resources/js/delete.js"></script>


</section>	

</body>
</html>