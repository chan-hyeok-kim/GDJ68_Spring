<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:if test="${empty login}">
    <script type="text/javascript">
       alert("로그인하세요");
       location.href="../member/login";
    </script>

</c:if>

<c:import url="../temp/bootStrap.jsp"></c:import>
  <!-- include summernote css/js-->
     <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>
	<section class="container mt-5">
		<h1 class="mb-2">${board}</h1>
		<form action="./add" method="post" enctype="multipart/form-data" id="frm">
           
            
			<table class="table mb-4text-center">
				<thead class="table-dark">
					<th>컬럼</th>
					<th>글 등록</th>
				</thead>
				<tbody>
					
					<tr>
						<td>제목</td>
						<td><input type="text" name="boardName" class="form-control" id="name"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea name="boardContents" class="form-control"
								cols="100px" id="contents"></textarea></td>
					</tr>
					<tr>
					<td>사진첨부</td><td>
<div id="fileList">
				<button type="button" id="btn1" class="btn btn-dark">File추가</button>
				</div>	
<script src="../resources/js/file.js"></script>
					
					</td>
					
					</tr>
				</tbody>
			</table>
			



			<button type="button" class="btn btn-dark" id="btn">등록</button>
<script>
	const btn = document.getElementById("btn");
	const name = document.getElementById("name");
	const frm = document.getElementById("frm");

	$('#contents').summernote({
		height:400,
		callbacks:{
			onImageUpload:function(files){
				alert('이미지 업로드');
			//	$('#summernote').summernote('insertNode', imageNode);
				// 이미지를 서버로 전송하고
				// 응답으로 이미지 경로와 파일명을 받아서
				// img태그를 만들어서 src속성에 이미지 경로를 넣는 것


				let formData = new FormData(); // <form></form>이 만들어진거임
				// 자바스크립트로 객체만들기
				formData.append("files",files[0]); // <input type="file" name="files">추가하는 거
 
				$.ajax({
					type: 'post',
					 url: 'setContentsImg',
					 data: formData, //객체 자체만 넣으면되서 중괄호 없어도됨
					 enctype: 'multipart/form-data',
					 cache: false,
					 contentType: false,
					 processData: false,
					 success:function(result){
						$('#contents').summernote('insertImage', result.trim());

					 },
					 error:function(){
						console.log('error');

					 }
				});
				// 이걸로 끝이 아님
				// 업로드한 이미지는 여러 상황(내용 수정, 글 작성하다 이동 등등)
			    // 에 따라 어떻게 지울 것인가? 결정해야 됨
                 

			},
			onMediaDelete:function(files){
				let path = $(files[0]).attr("src") // /resources/upload/notice/파일명

				$.ajax({
					type:'post',
					 url:'./setContentsImgDelete', 
					 data:{
						path:path
					 },
					success:function(result){ㅐ
						console.log(result);
					},
					error:function(){
						console.log("에러 발생");
					}
				})

			}


		}
	});
	
	
    btn.addEventListener("click",function(){
		console.log(name.value=="");
		console.log(name.value.length==0);
		if(name.value==""){
			alert("제목은 필수입니다");
			name.focus();
		}else{
			frm.submit();
		}
	});
</script>

		</form>
	</section>

</body>
</html>