<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>

			<c:import url="../temp/bootStrap.jsp"></c:import>
			 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

		</head>

		<body>
			<c:import url="../temp/header.jsp"></c:import>
			<section class="container mt-5">
				<h1 class="mb-2">my page</h1>
				<h3>



					<!-- 	<div class="container text-center">
  <div class="row">
    <div class="col-6 col-sm-3 border border-info">.col-6 .col-sm-3</div>
    <div class="col-6 col-sm-3 border border-info">.col-6 .col-sm-3</div>

    Force next columns to break to new line
    <div class="w-100"></div>

    <div class="col-6 col-sm-3">.col-6 .col-sm-3</div>
    <div class="col-6 col-sm-3">.col-6 .col-sm-3</div>
  </div>
</div> -->



					<table class="table table-striped table-hover">
						<tr>
							<!-- <td><img alt="" src="../resources/upload/member/${login.memberFileDTO.fileName}"></td> -->
							<td></td>
						</tr>
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

				<div id="productList">


				</div>

			</section>

			<script>
				// const productList = document.getElementById("productList");
				
				 getList(1);
			
				// productList.addEventListener("click", function (event) {
				// 	if (event.target.classList.contains("move")) {
						
				// 		let page = event.target.getAttribute("data-num");
				// 		console.log("before");
				// 		getList(page);	
						
				// 	}

				// })
				
               $('#productList').on("click",".move",function(){
				
				   let page = $(this).attr("data-num");
				   console.log(page);
				   getList(page);
			   })

			   
			   


				

				 function getList(page) {
					$.ajax({
						type: "GET",
						url: "../bookAccount/list",
						data:{
							page: page

						},
						success:function(result){
							
                              $('#productList').html(result.trim());
						},
						error: function(){
							alert("목록을 가져오지 못했습니다");
						}
					})


				// 	fetch("../bookAccount/list?page=" + page, {
				// 		method: "get"
				// 	})
				// 		.then((response) => { return response.text() })
				// 		.then((r) => {
				// 			console.log("ajax 실행");
				// 			productList.innerHTML = r;
				// 			console.log("after");
							
				// 		});
				 	// ;

				 }







			</script>
		</body>

		</html>