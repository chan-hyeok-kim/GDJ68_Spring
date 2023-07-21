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
		<h1 class="mb-4 text-center">학생 목록</h1>
		<table class="table table-dark table-hover">
			<thead>
			    <th>학번</th>
				<th>이름</th>
				<th>총합</th>
				<th>평균</th>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="s">
					<tr>
					    <td>${s.num}</td> 
						<td><a href="./detail?num=${s.num}"> ${s.name}</a></td>
						<td>${s.total}</td>
						<td>${s.avg}</td>
					<tr>
			</tbody>
			</c:forEach>

		</table>


	</section>
</body>
</html>