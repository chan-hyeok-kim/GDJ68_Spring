<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                  <h1>로그인 페이지</h1>
     <form action="./login" method="post">
     <div class="mb-3">
				<label for="id" class="form-label">ID
				</label>
				<div class="col-sm-4">
					<input type="text" class="form-control"
						id="id" name="id" value="id677" placeholder="ID를 입력하세요">
				</div>
			</div>

			<div class="mb-3">
				<label for="pw" class="form-label">Password </label>
				<div class="col-sm-4">
					<input type="password" value="123" class="form-control" id="pw" name="pw"
						placeholder="PW를 입력하세요">
				</div>
			</div>
     
			
			<p>
			<button type="submit" class="btn btn-primary">로그인</button>
			</p>
			</form>
</section>
</body>
</html>