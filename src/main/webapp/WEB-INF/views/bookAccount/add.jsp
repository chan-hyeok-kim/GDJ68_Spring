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
                  <h1>상품가입 페이지</h1>
     <form action="./add" method="post" id="frm">
     <input type="hidden" name="bookNum" value="${dto.bookNum}">
   
			<div class="mb-3">
				<label for="pw" class="form-label">Password </label>
				<div class="col-sm-4">
					<input type="password" class="form-control" id="pw" name="accountPassword"
						placeholder="PW를 입력하세요">
				</div>
			</div>
			<div class="mb-3">
				<label for="pw2" class="form-label">Password확인 </label>
				<div class="col-sm-4">
					<input type="password" class="form-control" id="pw2" name="accountPassword2"
						placeholder="PW를 입력하세요">
				</div>
			</div>

     
    
			
			<p>
			<button type="button" id="btn" class="btn btn-primary">상품 가입</button>
			</p>
			</form>
	</section>
<script>
    const btn = document.getElementById("btn");
	const pw = document.getElementById("pw");
    const frm = document.getElementById("frm");

    btn.addEventListener("click", function(){
		if(pw.value.length==4 && Number.isInteger(pw.value*1)){
			frm.submit();	
		}else{
		   alert("비밀번호는 숫자 4자리까지입니다");
		}
		
	})
</script>

</body>
</html>