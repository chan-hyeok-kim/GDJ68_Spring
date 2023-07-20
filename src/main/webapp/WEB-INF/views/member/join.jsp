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
		<form action="./join.do" method="post">
			
			<h1>회원가입 페이지</h1>
            
			<div class="mb-3">
				<label for="id" class="form-label">ID
				</label>
				<div class="col-sm-4">
					<input type="text" class="form-control"
						id="id" name="id" placeholder="ID를 입력하세요">
				</div>
			</div>

			<div class="mb-3">
				<label for="pw" class="form-label">Password </label>
				<div class="col-sm-4">
					<input type="password" class="form-control" id="pw" name="pw"
						placeholder="PW를 입력하세요">
				</div>
			</div>

			<div class="mb-3">
				<label for="name" class="form-label">이름 </label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="name" name="name"
						placeholder="이름을 입력하세요">
				</div>
			</div>



			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Email
					address</label>
				<div class="col-sm-4">
					<input type="email" class="form-control"
						id="exampleFormControlInput1" name="email"
						placeholder="name@example.com">
				</div>
			</div>


			<div class="mb-3">
				<label for="birth" class="form-label">생일 </label>
				<div class="col-sm-4">
					<input type="date" class="form-control" id="birth" name="birth">
				</div>
			</div>


			<button type="submit" class="btn btn-primary">회원가입</button>
			<input type="reset" class="btn btn-primary">
		</form>
	</section>
</body>
</html>