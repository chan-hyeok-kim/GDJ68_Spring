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

	<section>
		<h1>Detail Page</h1>
		


		<h3></h3>

		<!-- Getter 이름 : 메서드에서 get을 제외하고 첫번째 글자를 소문자로 바꾼 것 -->
		<!-- Setter 이름 : 메서드에서 set을 제외하고 첫번째 글자를 소문자로 바꾼 것 -->
		<div class="border border-primary-subtle col-sm-4 p-2 mb-2">
			<h1>${requestScope.dto.bookName}</h1>
		</div>
		<div class="border border-primary-subtle col-sm-4 p-2 mb-2">
			<h1>${dto.bookRate}</h1>
		</div>
		<div class="border border-primary-subtle col-sm-4 p-2 mb-2">
			<h1>${dto.bookContents}</h1>
		</div>

		<div class="border border-primary-subtle col-sm-4 p-2 mb-2">
			<c:choose>
				<c:when test="${dto.bookSale eq 1}">
					<h1>판매중</h1>
				</c:when>
				<c:otherwise>
					<h1>판매종료</h1>
				</c:otherwise>
			</c:choose>
		</div>
		<!-- if else같은거라 보면 됨 -->


		<%--    <c:if test="${dto.bookSale eq 1}">
          <h1>판매중</h1>
     </c:if>
     <c:if test="${dto.bookSale eq 0}">
          <h1>판매종료</h1>
     </c:if> --%>


		<!-- EL방식 -->
		<!-- scope명.키값(속성명).get이름 -->
		<a href="./update?bookNum=${dto.bookNum}">수정</a> <a
			href="./delete?bookNum=${dto.bookNum}">삭제</a>
	</section>
</body>
</html>