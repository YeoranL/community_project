<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<link rel="stylesheet" href="./style.css?v=2"/>
<script type="text/javascript" src="./main.js"></script>
<script src="https://kit.fontawesome.com/dd1c09ef10.js" defer crossorigin="anonymous"></script>
<body onload="call_js()">
<div class="main">
<!-- 	<section> -->
		<!-- <img alt="" src="img/mainImg.jpg">			 -->


		<div class="slideshow">
			<div class="slideshow_slides">
				<a href="http://www.naver.com" target="_blank"><img src="./img/slide-1.jpg" alt="slide1"></a> 
				<a href="#"><img src="./img/slide-2.jpg" alt="slide2"></a> 
				<a href="#"><img src="./img/slide-3.jpg" alt="slide3"></a> 
				<a href="#"><img src="./img/slide-4.jpg" alt="slide4"></a>
			</div>
			<div class="slideshow_nav">
				<a href="" class="prev"><i class="fa-solid fa-circle-chevron-left"></i></a> 
				<a href="" class="next"><i class="fa-solid fa-circle-chevron-right"></i></a>
			</div>
			<div class="indicator">
				<a href="#" class="active"><i class="fa-solid fa-circle-dot"></i></a>
				<a href="#"><i class="fa-solid fa-circle-dot"></i></a> 
				<a href="#"><i class="fa-solid fa-circle-dot"></i></a> 
				<a href="#"><i class="fa-solid fa-circle-dot"></i></a>
			</div>
		</div>
		
		<h5>강의목록</h5>
		<table class="vhcenter"> 
      <tr>
      	<th>운동코드</th>
      	<th>운동명</th>
      	<th>장소</th>
      	<th>날짜</th>
      	<th>인원수</th> 
      	<th>강사명</th>
      	<th>비용</th>
      </tr>
      <c:forEach var="exercise" items="${exerciseList}"> 
      <tr>
      	<td>${exercise.getExCode()}</td>
      	<td>${exercise.getExName()}</td>
      	<td>${exercise.getExLocation()}</td>
      	<td>${exercise.getExDate()}</td>
      	<td>${exercise.getExMembercount()}</td>
      	<td>${exercise.getUserId()}</td>
      	<td>${exercise.getExPrice()}</td>
      </tr>
      </c:forEach> 
     </table> 
<!-- 	</section> -->
</div>
</body>