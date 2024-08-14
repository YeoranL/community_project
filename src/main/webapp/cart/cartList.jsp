<%@ page language="java" contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<meta name="viewport" content="width=device-width,initial-scale=1.0"/> 
<link rel="stylesheet" href="cart/cart.css?v=2"/>
<script type="text/javascript" src="cart/cart.js"></script> 
<div id="shop" class="box2">  
<form method="post" name="cartform" action="/community/cartCancelPro.do" >
	<input type="hidden" id="loginID" name="loginID" value="${sessionScope.id}">
	<table class="vhcenter"> 
    <tr>
    	<th>운동코드</th>
    	<th>운동명</th>
    	<th>위치</th>
    	<th>날짜</th>
    	<th>비용</th>
    	<th>강사명</th>
    	<th></th>
    </tr>
    <c:forEach var="cart" items="${cartList}"> 
    <tr>
    	<td>${cart.exCode}</td>
      <td>${cart.exercise.exName}</td>
      <td>${cart.exercise.exLocation}</td>
      <td>${cart.exercise.exDate}</td>
      <td>${cart.exercise.exPrice}</td>
      <td>${cart.exercise.insName}</td>
      <td><button type="submit" value="${cart.exCode}" name="exCode" onclick="cancel()">취소</button></td>
    </tr>      
    </c:forEach> 
   </table> 
</form>
</div>