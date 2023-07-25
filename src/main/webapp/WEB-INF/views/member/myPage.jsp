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
		<h1 class="mb-2">my page</h1>
		<h3>
<table class="table table-bordered border-primary">
  <tr>
    <th>ID</th>
    <th>${login.id}</th>
  </tr>
  <tr>
    <td>pw</td>
    <td>${login.pw}</td>
  </tr>
  <tr>
    <td>이름</td>
    <td>${login.name}</td>
  </tr>
  <tr>
    <td>이메일</td>
    <td>${login.email}</td>
  </tr>
  <tr>
    <td>생일</td>
    <td>${login.birth}</td>
  </tr>
</table>



		</h3>
		<a href="./memberUpdate?id=${login.id}" class="btn btn-primary">수정</a>
	</section>
</body>
</html>

