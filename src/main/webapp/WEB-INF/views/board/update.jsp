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
			<thead>
			<form action="./update" method="post">
			<input type="hidden" name="boardNum" value="${mto.boardNum}">
				<th class="table-dark">제목</th>
				<th><div class="col-xs-3">
				<input type="text" class="form-control" name="boardName" value="${mto.boardName}" required>
				</div>
				</th>
			</thead>
			<tbody>
				<tr>
					<td class="table-dark">작성자</td>
					<td><input type="text" class="form-control" name="boardWriter"
						value="${mto.writer}"></td>
				</tr>
				<tr>
					<td class="table-dark">내용</td>
					<td><textarea rows="20px" class="form-control" cols="50px" name="boardContents">${mto.boardContents}</textarea></td>
				</tr>
		          	
			</tbody>
		</table>
		<%-- <form action="./update" method="post">
			<input type="hidden" name="boardNum" value="${mto.boardNum}">
			<input type="text" name="boardWriter" value="${mto.boardWriter}">
			<input type="text" name="boardName" value="${mto.boardName}">
			<textarea name="boardContents">${mto.boardContents}</textarea>
 --%>

			<button type="submit" class="btn btn-dark">수정</button>
		</form>
	</section>
</body>
</html>