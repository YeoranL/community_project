<%@ page language="java" contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<meta name="viewport" content="width=device-width,initial-scale=1.0"/> 
<link rel="stylesheet" href="mgmember/member.css?v=2"/>
<div id="userList"> 
   
  <%-- <p class="b">총 ${count}건</p> --%> 
  
  <form method="post" name="exform" action="/community/userModifyPro.do" >
    <table class="vhcenter"> 
      <tr>
      	<th>no</th>
      	<th>아이디</th>
      	<th>이름</th>
      	<th>이메일</th>
      	<th>핸드폰번호</th>
      	<th>생년월일</th> 
      	<th>주소</th>
      	<th>강사여부</th>
      	<th>강의운동명</th>
      	<th></th>
      </tr>
      <c:forEach var="user" items="${userList}"> 
      <tr>
      	<td>${user.getNo()}</td>
      	<td>${user.getUserId()}</td>
      	<td>${user.getUserName()}</td>
      	<td>${user.getUserEmail()}</td>
      	<td>${user.getUserPhone()}</td>
      	<td>${user.getBirthday()}</td>
      	<td>${user.getTotalAddr()}</td>      	
      	<td>${user.getIsInstructorNm()}</td>
      	<td>${user.getInsExercise()}</td>
      	<td><button type="submit" value="${exercise.getExCode()}" name="exCode" onclick="join()">신청</button></td> 
      </tr>      
      </c:forEach> 
     </table> 
  </form>
</div>