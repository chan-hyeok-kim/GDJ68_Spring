<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- prefix : c라는 건 코어태그를 의미 -->

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
		<h1 class="mb-4 text-center">BankBook List</h1>

		<table class="table table-dark table-hover">
			<thead>
				<th>상품명</th>
				<th>이자율</th>
			</thead>
			<tbody>

				<c:forEach items="${list}" var="d" varStatus="i">
					<!-- items = 콜렉션의 속성명 -->
					<!-- varStatus - 변수의 상태값을 i에 담아라  -->
					<!-- 필수는 아니지만 여러 부가적인 기능들이 있음  -->
					<tr>
						<td><a href="./detail?bookNum=${d.bookNum}">${d.bookName}</a></td>
						<td>${d.bookRate}${i.index}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>





		<ul class="pagination">
			<c:if test="${pager.pre}">
				<li class="page-item"><a class="page-link"
					href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">Previous</a></li>
			</c:if>
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<li class="page-item"><a href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}"
					class="page-link">${i}</a></li>
			</c:forEach>

			<!-- ${pager.next?'':'disabled'} -->
			<c:if test="${pager.next}">
				<li class="page-item"><a class="page-link"
					href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">Next</a></li>
			</c:if>
			
			<p class="ms-5">
			<div class="col-sm-3">
				<form action="./list" method="get">
					<select class="form-select" name="kind"
						aria-label="Default select example">
						<option value="name">Name</option>
						<option value="contents">Contents</option>
					</select>
			</div>
			<div class="col-sm-3">
				<input class="form-control me-2" type="search" name="search"
					placeholder="Search" aria-label="Search">
			</div>
			<div class="col-auto">
				<button class="btn btn-dark" type="submit">검색</button>
				</form>
			</div>
			</p>
			

				<p>
					<a href="./add" class="btn btn-info ms-4">상품등록</a>
				</p>
			
</ul>
           
			

			
	</section>
	
	
	<!-- 파라미터 : 클라이언트에서 서버 쪽으로 보내는 정보 -->
	<%-- <c:forEach begin="1" end="10" step="2" var="num">
	    <h1>${num}</h1>
	</c:forEach> --%>


	<!-- 출력할땐 세미콜론 안 붙임 -->
	
	<button id="list">GetList</button>
	

    <script src="../resources/js/bookList.js"></script>

</body>

<!-- 문자열을 자르는걸 파싱이라 하고, 파싱된걸 '토큰'이라 함-->
<!-- text decoration 에서 밑줄 제거 -->
</html>

