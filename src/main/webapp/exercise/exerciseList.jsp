<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<meta name="viewport" content="width=device-width,initial-scale=1.0"/> 
<link rel="stylesheet" href="exercise/exercise.css?v=5"/>
<script type="text/javascript" src="exercise/exercise.js"></script> 
<div id="exList"> 
   
  <p class="b">총 ${count}건</p> 
  
  <form method="post" name="exform" action="/community/exerciseJoinPro.do" >
  	<input type="hidden" id="loginID" name="loginID" value="${sessionScope.id}">					
    <table class="vhcenter"> 
      <tr>
      	<th>운동코드</th>
      	<th>운동명</th>
      	<th>장소</th>
      	<th>날짜</th>
      	<th>인원수</th> 
      	<th>강사명</th>
      	<th>비용</th>
      	<th></th>
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
      	<td><button type="submit" value="${exercise.getExCode()}" name="exCode" onclick="join()">신청</button></td> 
      </tr>      
      </c:forEach> 
     </table> 
  </form>
  <c:if test="${not empty sessionScope.id and sessionScope.id eq 'admin'}">		
  <a href="/community/exerciseInsertForm.do">강의등록하기</a>
  </c:if>
</div>