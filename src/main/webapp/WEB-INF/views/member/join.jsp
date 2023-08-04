<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="../temp/bootStrap.jsp"></c:import>

<style>
    .f{
		color: red;
	}

	.s{
		color : greenyellow;
	}

</style>
</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>
	<section class="ms-3">
		<form action="./join" method="post" enctype="multipart/form-data" id="frm">
			
			<h1>회원가입 페이지</h1>
            
			<div class="mb-3">
				<label for="id" class="form-label">ID
				</label>
				<div class="col-sm-4">
					<input type="text" class="form-control"
						id="idtest" name="id" placeholder="ID를 입력하세요">
				</div>
			</div>
            <div id="msg1"></div>


			<div class="mb-3">
				<label for="pw" class="form-label">Password </label>
				<div class="col-sm-4">
					<input type="password" class="form-control" id="pw" name="pw"
						placeholder="PW를 입력하세요">
				</div>
			</div>
			<div id="msg2"></div>

			<div class="mb-3">
				<label for="pw2" class="form-label">Password 확인 </label>
				<div class="col-sm-4">
					<input type="password" class="form-control" id="pw2" name="pw2"
						placeholder="PW를 입력하세요">
				</div>
			</div>
			<div id="msg3"></div>

			<div class="mb-3">
				<label for="name" class="form-label">이름 </label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="name1" name="name"
						placeholder="이름을 입력하세요">
				</div>
			</div>
			<div id="msg4"></div>



			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Email
					address</label>
				<div class="col-sm-4">
					<input type="email" class="form-control"
						id="email" name="email"
						placeholder="name@example.com">
				</div>
			</div>
			<div id="msg5"></div>

			<div class="mb-3">
				<label for="birth" class="form-label">생일 </label>
				<div class="col-sm-4">
					<input type="date" class="form-control" id="birth" name="birth">
				</div>
			</div>
			<div id="msg6"></div>

			<div class="mb-3">
				<label for="pic" class="form-label">사진첨부</label>
				<div class="col-sm-4">
					<input type="file" class="form-control" id="pic" name="pic">
				</div>
			</div>


			<button type="button" class="btn btn-primary" id="btn">회원가입</button>
			<input type="reset" class="btn btn-primary">
			

		</form>
	</section>
	<script src="../resources/js/member.js"></script>

</body>
</html>