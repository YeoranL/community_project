<%@page import="java.util.Date"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<link rel="stylesheet" href="member/member.css?v=3"/>
<script type="text/javascript" src="member/login.js"></script>

<c:if test="${empty sessionScope.id}">
	<div id="lStatus">
		<div class="info_section">
			<label for="cid">아이디</label> 
			<input id="cid" name="cid" type="text" size="20" maxlength="20">
			<label for="cpasswd">비밀번호</label>
			<input id="cpasswd" name="cpasswd" type="password" size="20" maxlength="20">
		</div>
		
		<div class="button_section">
			<button id="uLogin">로그인</button>
			<button id="uRes">회원가입</button>
		</div>	
	</div>
</c:if>
