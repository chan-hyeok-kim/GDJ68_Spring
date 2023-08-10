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
		<p class="text-center">
		<h1 class="ms-2">Reply Page</h1>
		</p>
		<form action="./reply" method="post">


			<table class="table mb-4text-center">
					<tr>
						<td>내용</td>
						<td><textarea name="boardContents" class="form-control"
								cols="50px"></textarea></td>

					</tr>

				</tbody>
			</table>
			<input type="hidden" name="boardNum" value="${bto.boardNum}">
			
			<button type="sumbit" class="btn btn-dark">등록</button>
		</form>

	</section>

</body>
</html>