<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="/community/member/login.js"></script>
<title>운동 신청 웹사이트</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: white;
	color: #333;
	margin: 0;
	padding: 0;
}

.container {
	width: 90%;
	max-width: 1200px;
	margin: 0 auto;
}

header {
	background-color: #333;
	color: white;
	padding: 1em 0;
}

header .container {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

header h1 {
	margin: 0;
	font-size: 1.5em;
}

nav ul {
	list-style: none;
	padding: 0;
	margin: 0;
	display: flex;
}

nav li {
	margin-left: 1em;
}

nav a {
	color: white;
	text-decoration: none;
}

nav a:hover {
	text-decoration: underline;
}

main {
	/* padding: 2em 0; */
	width: 80%;
	margin: 0 auto;
}

main section {
	text-align: center;
}

main img {
	max-width: 100%;
	height: auto;
/* 	border-radius: 8px;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); */
}

main h2 {
	margin-top: 1em;
	font-size: 2em;
}

footer {
	background-color: #333;
	color: white;
	text-align: center;
	padding: 1em 0;
	margin-top: 2em;
}

header button {
    background-color: #cfd2d1;
    color: white;
    border: none;
    padding: 10px 20px;
    font-size: 1em;
    cursor: pointer;
}

header button:hover {
    background-color: #555;
}
</style>
<% 
	String userId = (String) session.getAttribute("userId");
%>
</head>
<body>
	<!-- Header -->
	<header style="background-color: #FFDEAD;">
		<div class="container">
			<h1>TeamFit</h1>
			<nav>
				<ul>
					<li><a href="/community/index.do">Home</a></li>
				<c:if test="${not empty sessionScope.id and sessionScope.id eq 'admin'}">				
					<li><a href="/community/exerciseList.do">List</a></li>
					<li><a href="/community/userList.do">UserList</a></li>
					
					<!-- <li><a href="/community/qnaWrite.do">Contact</a></li> -->
				</c:if>
				<c:if test="${not empty sessionScope.id and sessionScope.id ne 'admin'}">					
					<li><a href="/community/exerciseList.do">Join</a></li>
					<li>
					<!-- <a href="/community/cartList.do">Cart</a> -->
					<a href="<c:url value='/cartList.do'>
    			<c:param name='loginID' value='${sessionScope.id}'/>
					</c:url>">Cart</a>
					</li>
					<!-- <li><a href="/community/qnaWrite.do">Contact</a></li> -->
				</c:if>
				<li><a href="/community/boardList.do">Board</a></li> 
				</ul>
			</nav>
			<div style="display: flex; justify-content: flex-end;">
				<c:if test="${!empty sessionScope.id}">
					${sessionScope.id}님이로그인 하셨습니다.
					<input type="text" id="loginID" name="loginID" value="${sessionScope.id}">					
					<button id="uLogout" onclick="uLogout()">로그아웃</button>
				</c:if>
				<c:if test="${empty sessionScope.id}">
					<button style="margin-left: 10px;" onclick="window.location.href='/community/loginForm.do'">SignIn</button>
					<button style="margin-left: 10px;" onclick="window.location.href='/community/registerForm.do'">SignUp</button>
				</c:if>
			</div>
		</div>
	</header>

	<main>
		<div id=container class="box2">
			<jsp:include page="${cont}" />
		</div>
	</main>

	<!-- Footer -->
	<footer>
		<div class="container">&copy; 2024 Yeoran Website</div>
	</footer>
</body>
</html>