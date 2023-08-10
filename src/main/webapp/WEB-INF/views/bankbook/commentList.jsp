<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${commentList}" var="com">
    <tr>
       <td>${com.boardContents}</td>
       <td>${com.writer}</td>
       <td>${com.boardDate}</td>
    </tr>
    </c:forEach>

