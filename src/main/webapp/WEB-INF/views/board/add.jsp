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
		<h1 class="mb-2">${board}</h1>
		<form action="./add" method="post" enctype="multipart/form-data" id="frm">
           
            
			<table class="table mb-4text-center">
				<thead class="table-dark">
					<th>컬럼</th>
					<th>글 등록</th>
				</thead>
				<tbody class="table-dark">
					
					<tr>
						<td>제목</td>
						<td><input type="text" name="boardName" class="form-control" id="name"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea name="boardContents" class="form-control"
								cols="50px" id="contents"></textarea></td>
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