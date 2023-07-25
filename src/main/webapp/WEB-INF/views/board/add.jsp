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
		<form action="./add" method="post">

			<table class="table mb-4text-center">
				<thead class="table-dark">
					<th>컬럼</th>
					<th>게시글 등록</th>
				</thead>
				<tbody class="table-dark">
					<tr>
						<td>작성자</td>
						<td><input type="text" name="boardWriter"
							class="form-control"></td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" name="boardName" class="form-control" required></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea name="boardContents" class="form-control"
								cols="50px"></textarea></td>
					</tr>
				</tbody>
			</table>


			<!-- 
<div class="input-group mb-2">
<span class="input-group-text">작성자</span>
<input type="text" name="boardWriter" class="form-control">
</div>	

<div class="input-group mb-2">
<span class="input-group-text">제목</span>
<input type="text" name="boardName" class="form-control">
</div>	

<div class="input-group mb-2">			
<span class="input-group-text">내용</span>
<textarea name="boardContents" class="form-control" cols="50px">
</textarea>
</div>

<div class="input-group mb-2">
<span class="input-group-text">날짜</span>
<input type="date" name="boardDate" class="form-control" value="2023-07-25">

</div>

 -->

			<button type="submit" class="btn btn-dark">등록</button>

		</form>
	</section>

</body>
</html>