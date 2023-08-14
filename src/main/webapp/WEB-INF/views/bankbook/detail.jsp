<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

			<section>
				<h1>Detail Page</h1>

				<c:forEach items="${bto.fileDTOs}" var="d">
					<img alt="" src="../resources/upload/bankbook/${d.fileName}">
				</c:forEach>

				<h3></h3>

				<!-- Getter 이름 : 메서드에서 get을 제외하고 첫번째 글자를 소문자로 바꾼 것 -->
				<!-- Setter 이름 : 메서드에서 set을 제외하고 첫번째 글자를 소문자로 바꾼 것 -->
				<div class="border border-primary-subtle col-sm-4 p-2 mb-2">
					<h1>${requestScope.bto.bookName}</h1>
				</div>
				<div class="border border-primary-subtle col-sm-4 p-2 mb-2">
					<h1>${bto.bookRate}</h1>
				</div>
				<div class="border border-primary-subtle col-sm-4 p-2 mb-2">
					<h1>${bto.bookContents}</h1>
				</div>

				<div class="border border-primary-subtle col-sm-4 p-2 mb-2">
					<c:choose>
						<c:when test="${bto.bookSale eq 1}">
							<h1>판매중</h1>
						</c:when>
						<c:otherwise>
							<h1>판매종료</h1>
						</c:otherwise>
					</c:choose>
				</div>
				<!-- if else같은거라 보면 됨 -->


				<%-- <c:if test="${dto.bookSale eq 1}">
					<h1>판매중</h1>
					</c:if>
					<c:if test="${dto.bookSale eq 0}">
						<h1>판매종료</h1>
					</c:if> --%>


					<!-- EL방식 -->
					<!-- scope명.키값(속성명).get이름 -->

					<button class="btn btn-dark" id="update">수정</button>

					<button class="btn btn-dark" id="del" data-delete-num="${bto.bookNum}"
						data-delete-name="bookNum">삭제</button>

					<a class="btn btn-dark" href="../bookAccount/add?bookNum=${bto.bookNum}">상품 가입</a>
					<button class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#accountModal">상품가입</button>

					<!-- Modal -->
					<div class="modal fade" id="accountModal" tabindex="-1" aria-labelledby="exampleModalLabel"
						aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h1 class="modal-title fs-5" id="exampleModalLabel">비밀번호를
										입력하세요</h1>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<div class="mb-3">

										<div class="col-sm-4">
											<input type="password" class="form-control" id="pw" name="accountPassword"
												placeholder="PW를 입력하세요">
										</div>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary" id="close"
										data-bs-dismiss="modal">Close</button>
									<button type="button" id="add" class="btn btn-primary"
										data-add-num="${bto.bookNum}">
										상품가입</button>
								</div>
							</div>
						</div>
					</div>

					<!-- 댓글 -->
					<div>
					
						<div class="col-sm-4">
							<textarea class="form-control" id="comment" name="boardContents"></textarea>
							
								<button id="commentAdd" class="btn btn-dark" data-url="commentAdd">답글 등록</button>
				
				</div>

						<div>
							<table id="commentList">
								
							</table>

							<div id="more">
							
							</div>

						</div>
						
					</div>


			
				
					<script src="../resources/js/delete.js"></script>
					<script>
						let bn=$('#add').attr("data-add-num");
						let pageNum=1

						getCommentList(bn,pageNum)
						 
						$('#commentAdd').click(function(){
							let contents = $('#comment').val();
							$.ajax({
								type:'post',
								url:'commentAdd',
								data:{
									bookNum:bn,
									boardContents:contents
								},
								success:function(r){
									if(r.trim()>0){
									   console.log("댓글 등록 완료");
									   $('#commentList').empty();
									   $('#comment').val('');
									    pageNum=1;
									//    여기서 pageNum초기화를 안하면 
									//    더보기를 진행했을때 바뀐 페이지(pageNum)가 그대로남게됨
									   getCommentList(bn,1);
									//    pageNum은무조건 1번보내야함
									
									}

								},

							})
						})

						$("#more").on("click", "#moreButton", function(){
							getCommentList(bn, ++pageNum);
						})

						function getCommentList(bookNum,page){
							$.ajax({
								type: "get",
								url: "./commentList",
								data:{
									bookNum:bookNum,
									page:page
								},
								success:function(result){
									$('#commentList').append(result);
									let total = $('#getTotalPage').attr("data-total");
									if(pageNum>total){
										--pageNum;
										alert("마지막 페이지입니다")
										return;
									}
									let button = '<button id="moreButton">더보기('+pageNum+'/'+total+')</button>'
									$('#more').html(button);

								},
								error:function(){
									alert("관리자에게 문의하세요")
								}
							})
						}
		// 더보기버튼에 대한 3가지 
// 코멘트리스트 jsp에 만들것인가 
// ajax후에 만들것인가
// 미리 만들어져있을것인가

					</script>
					<script>
						// const add = document.getElementById("add");
						// add.addEventListener("click", function () {
						// 	let bookNum = add.getAttribute("data-add-num");
						// 	let pw = document.getElementById("pw").value;
						// 	ajax2(bookNum, pw);

						// });
						
						

						
						
						$('#add').click(function(){
							let bookNum = $(this).attr("data-add-num");
							let pw = $('#pw').val();
							ajax2(bookNum, pw)

							
						})


						function ajax2(bookNum, pw) {
							$.ajax({
								type: "post",
								url: "../bookAccount/add",
								data:{
									bookNum:bookNum,
									accountPassword:pw
								},
								success:function(r){
									if(r.trim()>0){
										alert("가입 성공")
									}else{
										alert("가입 실패")
									}

								},
								error: function(){
									alert("관리자에게 문의")
								}

								
							
							})
							
								

						}



							// fetch("../bookAccount/add", {
							// 	method: "post",
							// 	body: "bookNum="+bookNum+"&accountPassword="+pw
									
							// 		// 왼쪽은 멤버변수, 오른쪽은 매개변수
							//     ,
							// 	headers: {
							// 		'content-type': "application/x-www-form-urlencoded"
							// 	}


							// })
							// 	.then((response) => {
							// 		return response.text();

							// 	})
							// 	.then((r)=>{
							// 		if(r>0){
							// 			alert("가입 완료");
							// 		}else{
							// 			alert("가입 실패");
							// 		}
							// 	  document.getElementById("close").click;
     
							// 	  location.href="/";
							// 	})
							// 	;

						



						// function ajax1(bookNum, pw) {

						// 	//1.
						// 	let xhttp = new XMLHttpRequest();

						// 	//2.요청 정보
						// 	xhttp.open("post", "../bookAccount/add");

						// 	//요청 header 정보. enctype 디폴트는 원래 이거임
						// 	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

						// 	//요청 발생(post일 경우 파라미터 작성 key=value&key2=value)
						// 	xhttp.send("bookNum=" + bookNum + "&accountPassword=" + pw);

						// 	//응답 처리
						// 	xhttp.onreadystatechange = function () {
						// 		if (this.readyState == 4 && this.status == 200) {
						// 			let r = this.responseText.trim();
						// 			console.log(r);

						// 			document.getElementById("close").click;

						// 			if (r > 0) {

						// 				alert("가입 성공");
						// 			} else {
						// 				alert("가입 실패");
						// 			}


						// 			location.href = "/";

						// 		}
						// 	}
						// };


					</script>

			</section>
		</body>

		</html>