<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/bootStrap.jsp"></c:import>
 <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>
	<section class="container mt-5">
		<h1 class="mb-2">NOTICE</h1>
		<form action="./update" method="post" enctype="multipart/form-data">
		<table class="table mb-4text-center">
			<thead>
			
			<input type="hidden" name="boardNum" value="${bto.boardNum}">
			
				<th class="table-dark">제목</th>
				<th><div class="col-xs-3">
				<input type="text" class="form-control" name="boardName" value="${bto.boardName}" required>
				</div>
				</th>
			</thead>
			<tbody>
			<%-- 	<tr> 
				<td class="table-dark">작성자
				<th><div class="col-xs-3">
				<input type="text" class="form-control" name="writer" value="${bto.writer}" required>
				</div>
				</td>
				</tr> --%>
				<tr>
					<td class="table-dark">내용</td>
					<td><textarea rows="20px" class="form-control" cols="50px" id="contents" name="boardContents">${bto.boardContents}</textarea></td>
				</tr>
				<tr>
				<td></td>
				<td>

					<div id="fileList">
					<button type="button" id="btn1" class="btn btn-dark">File추가</button>
					
				<div>
					<c:forEach items="${bto.boardFileDTOs}" var="b">
					<div class="alert alert-warning" role="alert">
						${b.originalName}
					</div><span class="deletes" data-delete-num="${b.fileNum}">X</span> 
				</div>
			</div>
					</c:forEach>
				</td>
					</tr>
	
				</tbody>
				
			</table>
			<button type="submit" class="btn btn-dark">수정</button>
		</form>

		<%-- <form action="./update" method="post">
			<input type="hidden" name="boardNum" value="${mto.boardNum}">
			<input type="text" name="boardWriter" value="${mto.boardWriter}">
			<input type="text" name="boardName" value="${mto.boardName}">
			<textarea name="boardContents">${mto.boardContents}</textarea>
 --%>

			
	</section>
<script src="/resources/js/file.js"></script>
<script>
   //$('#contents').summernote('code',"기존내용");
   //'code'가 val()값을 담고있다보면됨
   $('#contents').summernote();

</script>

</body>
</html>