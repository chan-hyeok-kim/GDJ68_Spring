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
	<section class="ms-3">
		<h1>Update Page</h1>
		<form action="./update" method="post">
			<input type="hidden" name="num" value="${sto.num}">
			<div class="input-group mb-2">
				<span class="input-group-text">이름</span>
				<input type="text" name="name" value="${sto.name}">
			</div>
			<div class="input-group mb-2">
				<span class="input-group-text">학번</span>
				<input type="text" name="num" disabled value="${sto.num}">
			<!-- 학번은 primary key라서 변경 불가 필수  -->
			</div>
			<div class="input-group mb-2">
				<span class="input-group-text">국어</span>
				<input type="text" name="kor" value="${sto.kor}">
			</div>
			<div class="input-group mb-2">
				<span class="input-group-text">영어</span>
				<input type="text" name="eng" value="${sto.eng}">
			</div>
			<div class="input-group mb-2">
				<span class="input-group-text">수학</span>
				<input type="text" name="math" value="${sto.math}">
			</div>
			<div class="input-group mb-2">
				<span class="input-group-text">총점</span>
				<input type="text" name="total" disabled value="${sto.total}">
			</div>
			<div class="input-group mb-2">
				<span class="input-group-text">평균</span>
				<input type="text" name="avg" disabled value="${sto.avg}">
			</div>
			
			<button type="submit" class="btn btn-info">수정</button>
		</form>

	</section>
</body>
</html>