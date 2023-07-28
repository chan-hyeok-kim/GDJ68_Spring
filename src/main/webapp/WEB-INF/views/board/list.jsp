<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   
	<table>
		<thead>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>날짜</th>
			<th>조회수</th>
			
		</thead>
		
		<tbody>
		<c:forEach items="${list}" var="b">
			<tr>
				<td>${b.boardNum}</td>
				<td>${b.boardWriter}</td>
				<td>${b.boardName}</td>
				<td>${b.boardDate}</td>
				<td>${b.boardHit}</td>
				
			</tr>
          </c:forEach>
		</tbody>

		
	</table>

</body>
</html>