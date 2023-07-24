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
		<h1 class="mb-2">my page</h1>
		<h3>
<table class="table table-bordered border-primary ">
  <tr>
    <th>ID</th>
    <th>${login.id}</th>
  </tr>
  <tr>
    <td>pw</td>
    <td>${login.pw}</td>
  </tr>
</table>


			<div class="mb-3">ID: ${login.id}</div>
			<div class="mb-3">pw: ${login.pw}</div>
			<div class="mb-3">이름: ${login.name}</div>
			<div class="mb-3">이메일: ${login.email}</div>
			<div class="mb-3">생일: ${login.birth}</div>

		</h3>
		<a href="./memberUpdate?id=${login.id}">수정</a>
	</section>
</body>
</html>

