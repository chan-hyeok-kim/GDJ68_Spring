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

	<section class="mt-2">
		<h1 class="mb-2">Add Page</h1>

		<form action="./add" method="post" enctype="multipart/form-data">



			<div class="input-group mb-2">
				<span class="input-group-text">상품명</span> <input type="text"
					class="form-control 300px" name="bookName"><br>
			</div>
			<div class="input-group mb-2">
				<span class="input-group-text">이자율</span> <input type="text"
					class="form-control" name="bookRate"><br>
			</div>
			<div class="input-group">
				<span class="input-group-text">내용</span>
				<textarea rows="" cols="50px" class="form-control"
					name="bookContents" aria-label="내용"></textarea>
			</div>
			<br>
			<!-- name : 파라미터의 이름이 됨 -->
			<!-- set을뺀 세터이름 -->
			<p>
				<label class="btn btn-outline-primary" for="option2"> <input
					type="radio" class="form-check-input" id="option2" name="bookSale"
					checked value="1">판매가능
				</label> <br> <label class="btn btn-outline-primary" for="option3">
					<input type="radio" id="option3" class="form-check-input"
					name="bookSale" value="0">판매중지
				</label> <br>
			</p>

			<div class="input-group mb-2">
				<input type="file" class="form-control" name="photos"
					id="inputGroupFile04" aria-describedby="inputGroupFileAddon04"
					aria-label="Upload">

			</div>

			<div class="input-group mb-2">
				<input type="file" class="form-control" name="photos"
					id="inputGroupFile04" aria-describedby="inputGroupFileAddon04"
					aria-label="Upload">

			</div>

			<div class="input-group mb-2">
				<input type="file" class="form-control" name="photos"
					id="inputGroupFile04" aria-describedby="inputGroupFileAddon04"
					aria-label="Upload">

			</div>


			<!--   <p>
          <select name="bookSale">
                <option value="1">판매가능</option>
                <option value="0">판매중지</option>  
          </select>
          </p> -->

			<button type="sumbit" class="btn btn-outline-primary">등록</button>
			<input type="submit" value="ADD" class="btn btn-outline-primary">
			<input type="reset" value="ADD" class="btn btn-outline-primary">
			<input type="button" value="ADD" class="btn btn-outline-primary">
			<!-- input type="radio"도 가능 -->
			<!-- input은 checked 셀렉트는 selected로 미리선택가능 -->
		</form>
	</section>

</body>
</html>