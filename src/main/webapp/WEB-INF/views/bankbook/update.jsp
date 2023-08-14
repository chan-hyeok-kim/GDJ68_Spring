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
     <h1>Update Page</h1>
     <form action="./update" method="post">
     <input type="hidden" name="bookNum" value="${bto.bookNum}">
     <!-- disabled, hidden, read only? -->
		<div class="input-group mb-2">
			<span class="input-group-text">상품명</span> <input type="text"
				name="bookName" class="form-control" value="${bto.bookName}">
		</div>
		<br>
		<div class="input-group mb-2">
			<span class="input-group-text">내용</span>
			<textarea rows="" cols="" name="bookContents">${bto.bookContents}</textarea>
			<br>
		</div>
		
		
		이자율 <input type="text" name="bookRate" value="${bto.bookRate}"><br>

		<p>
			판매가능 <input type="radio" value="1" checked name="bookSale"><br>
			판매중지 <input type="radio" value="0" name="bookSale"><br>
		</p>
		
		<p>
<!-- 			<select name="bookSale">
				<option value="1">판매가능</option>
				<option value="0" selected>판매중지</option>
			</select> -->	
		</p>
		
		<button type="submit" class="btn btn-info">수정</button>
		<input type="submit" value="수정">
		<input type="reset" value="수정">
		<input type="button" value="수정">
		</form>
</body>
</html>