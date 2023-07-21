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
	<section>
		<h1>Update Page</h1>
		<form action="./update" method="post">
			<input type="hidden" name="num" value="${sto.num}">
			<div class="input-group mb-2">
				학생 이름<input type="text" name="name" value="${sto.name}">
			</div>
			<div class="input-group mb-2">
				국어 점수<input type="text" name="kor" value="${sto.kor}">
			</div>
			<div class="input-group mb-2">
				영어 점수<input type="text" name="eng" value="${sto.eng}">
			</div>
			<div class="input-group mb-2">
				수학 점수<input type="text" name="math" value="${sto.math}">
			</div>
			
			
			<button type="submit">수정</button>
		</form>

	</section>
</body>
</html>