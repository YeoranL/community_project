<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Board</title>
<link rel="stylesheet" href="board/board.css?v=2"/>
<script type="text/javascript" src="board/board.js"></script>
</head>
<body>
	<form method="post" name="writeform" action="/community/writePro.do" >
		<input type="hidden" name="no" value="${no}"> 
		<input type="hidden" name="ref" value="${ref}"> 
		<input type="hidden" name="step" value="${step}"> 
		<input type="hidden" name="depth" value="${depth}">
		<table width="200" border="1" cellspacing="0" cellpadding="0" align="center">
			<tr>
				<td align="right" colspan="2" >
					<a href="/myWeb/board/list.do"> 글목록</a></td>
			</tr>
			<tr>
				<td width="70" align="center">이 름</td>
				<td width="330"><input type="text" size="10" maxlength="10" name="writer"></td>
			</tr>
			<tr>
				<td width="70" align="center">제 목</td>
				<td width="330">
					<c:if test="${no == 0}">
						<input type="text" size="40" maxlength="50" name="subject">
					</c:if> 
					<c:if test="${no != 0}">
						<input type="text" size="40" maxlength="50" name="subject" value="[답변]">
					</c:if></td>
			</tr>
			<tr>
				<td width="70" align="center">Email</td>
				<td width="330">
					<input type="text" size="40" maxlength="30" name="email"></td>
			</tr>
			<tr>
				<td width="70" align="center">내 용</td>
				<td width="330"><textarea name="content" rows="13" cols="40"></textarea>
				</td>
			</tr>
			<tr>
				<td width="70" align="center">비밀번호</td>
				<td width="330">
					<input type="password" size="8" maxlength="12" name="pass"></td>
			</tr>
			<tr>
				<td colspan=2 align="center">
					<input type="submit" value="글쓰기"> 
					<input type="reset" value="다시작성"> 
					<input type="button" value="목록보기" OnClick="window.location='boardList.do'"></td>
			</tr>
		</table>
	</form>
</body>
</html>