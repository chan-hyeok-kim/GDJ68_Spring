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
		<h1>Detail Page</h1>
		
		<div class="border border-primary-subtle col-sm-4 p-2 mb-2">
			<h1>${sto.name}</h1></div>
		<div class="border border-primary-subtle col-sm-4 p-2 mb-2">
			<h1>${sto.total}</h1></div>
		<div class="border border-primary-subtle col-sm-4 p-2 mb-2">
			<h1>${sto.avg}</h1></div>

		<a class="btn btn-info" href="./update?num=${sto.num}">수정</a> 
		<a class="btn btn-info" href="./delete?num=${sto.num}">삭제</a>

	</section>
</body>
</html>