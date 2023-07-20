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
						<td><a href="./detail.do?bookNum=${d.bookNum}">${d.bookName}</a></td>
						<td>${d.bookRate}${i.index}</td>
					</tr>
				</c:forEach>


			</tbody>
		</table>
		<br> <a href="./add" class="btn btn-info">상품등록</a>
	</section>

	<!-- 파라미터 : 클라이언트에서 서버 쪽으로 보내는 정보 -->	
	<%-- <c:forEach begin="1" end="10" step="2" var="num">
	    <h1>${num}</h1>
	</c:forEach> --%>
	
	
	<!-- 출력할땐 세미콜론 안 붙임 -->
</body>

<!-- 문자열을 자르는걸 파싱이라 하고, 파싱된걸 '토큰'이라 함-->
<!-- text decoration 에서 밑줄 제거 -->
</html>

