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
<section>
     <h1>Add page</h1>
     <form action="./add" method=post>
     <div class="input-group mb-2">
     <span class="input-group-text">학생이름</span>
     <input type="text" name=name>
     </div>
     <div class="input-group mb-2">
     <span class="input-group-text">국어점수</span>
     <input type="text" name=kor>
     </div>
     <div class="input-group mb-2">
     <span class="input-group-text">영어점수</span>
     <input type="text" name=eng>
     </div>
     <div class="input-group mb-2">
     <span class="input-group-text">수학점수</span>
     <input type="text" name=math>
     </div>
     
     
     <button type="submit" class="btn btn-outline-primary">등록</button>
     <input type="reset" class="btn btn-outline-primary">
     </form>
</section>
</body>
</html>