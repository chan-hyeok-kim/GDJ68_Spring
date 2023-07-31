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

		<table class="table mb-4text-center">
			<form action="./add" method="post">
			<thead class="table-dark">
				<th>컬럼</th>
				<th>게시글 등록</th>
			</thead>

			<tbody>
				<input type="hidden" name="boardNum" class="form-control">
				<tr>
					<td>제목</td>
					<td><input type="text" name="boardName" class="form-control"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="writer" class="form-control"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea class="form-control" name="boardContents"
							rows="" cols=""></textarea></td>
				</tr>

				
			</tbody>


		</table>
<button type="submit" class="btn btn-dark">등록</button>

</form>

	</section>

</body>
</html>