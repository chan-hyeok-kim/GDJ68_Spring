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
		<h1>Detail Page</h1>
		
		이름: <div class="border border-primary-subtle col-sm-2 p-2 mb-2">
			 ${sto.name}</div>
		학번: <div class="border border-primary-subtle col-sm-2 p-2 mb-2">
			 ${sto.num}</div>	
		
		국어: <div class="border border-primary-subtle col-sm-2 p-2 mb-2">
			 ${sto.kor}</div>	
        영어:<div class="border border-primary-subtle col-sm-2 p-2 mb-2">
			 ${sto.eng}</div>	
		수학:<div class="border border-primary-subtle col-sm-2 p-2 mb-2">
			 ${sto.math}</div>			
		총점:<div class="border border-primary-subtle col-sm-2 p-2 mb-2">
			 ${sto.total}</div>
		평균:<div class="border border-primary-subtle col-sm-2 p-2 mb-2">
			 ${sto.avg}</div>
       
		<a class="btn btn-info" href="./update?num=${sto.num}">수정</a> 
		<a class="btn btn-info" href="./delete?num=${sto.num}">삭제</a>

	</section>
</body>
</html>