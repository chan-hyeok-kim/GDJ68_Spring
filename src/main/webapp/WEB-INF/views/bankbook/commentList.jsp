<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


 <c:forEach items="${commentList}" var="com" varStatus="i">
<c:choose>
    <c:when test="${i.first}">
         <tr id="getTotalPage" data-total="${pager.totalPage}"> 
    </c:when>
    <c:otherwise>
         <tr>
    </c:otherwise>
</c:choose> 
<!-- <div id="getTotalPage" data-total="${pager.totalPage}"> -->
<tr>
       <td>${com.boardContents}</td>
       <td>${com.writer}</td>
       <td>${com.boardDate}</td>
    </tr>
<!-- </div> -->
    </c:forEach>

<!-- json으로 하는 것이 가장 깔끔 -->