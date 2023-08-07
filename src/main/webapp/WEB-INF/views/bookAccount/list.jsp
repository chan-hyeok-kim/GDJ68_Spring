<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



	<section class="container mt-5">
		<h1 class="mb-2">상품 가입 목록</h1>

		<table class="table mb-4text-center">
			<thead class="table-dark">
				<th style="width: 20%">계좌번호</th>
				<th style="width: 60%">잔액</th>
				
				<th style="width: 20%">DATE</th>
				
			</thead>
			<tbody>
				<c:forEach items="${list}" var="n">
					<tr>
					
						<td>${n.account}</td>
						<td>${n.accountBalance}</td>	
						<td>${n.accountDate}</td>
						
					</tr>

				</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td><a href="./add" class="btn btn-dark">글 작성</a></td>
				
					
				</tr>

			</tbody>

		</table>

		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<c:if test="${pager.startNum eq 1}">
					<li class="page-item"><a class="page-link move"
						href="#" data-num="${pager.startNum}">Previous</a></li>
				</c:if>
				<c:if test="${pager.startNum ne 1}">
					<li class="page-item"><a class="page-link move"
						href="#" data-num="${pager.startNum-1}">Previous</a></li>
				</c:if>

				
				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					<li class="page-item pagei"><a class="page-link move"
						href="#" data-num="${i}">${i}</a></li>
				</c:forEach>


				<li class="page-item ${pager.next?'':'disabled'}"><a
					class="page-link move" href="#" data-num="${pager.lastNum+1}">Next</a></li>

			</ul>
		</nav>


	</section>
<script src="/resources/js/list.js">
</script>	