<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<table width="500" border="1" cellspacing="0" cellpadding="0" align="center">
			<tr height="30">
				<td align="center" width="125" >글번호</td>
				<td align="center" width="125" align="center">${article.no}</td>
				<td align="center" width="125" >조회수</td>
				<td align="center" width="125" align="center">${article.readcount}</td>
			</tr>
			<tr height="30">
				<td align="center" width="125" >작성자</td>
				<td align="center" width="125" align="center">${article.writer}</td>
				<td align="center" width="125" >작성일</td>
				<td align="center" width="125" align="center">${article.regdate}</td>
			</tr>
			<tr height="30">
				<td align="center" width="125" >글제목</td>
				<td align="center" width="375" align="center" colspan="3">${article.subject}</td>
			</tr>
			<tr>
				<td align="center" width="125" >글내용</td>
				<td align="left" width="375" colspan="3"><pre>${article.content}</pre></td>
			</tr>
			<tr height="30">
				<td colspan="4"  align="right">
					<input type="button" value="글수정" onclick="document.location.href='updateForm.do?no=${article.no}&pageNum=${pageNum}'">
					&nbsp;&nbsp;&nbsp;&nbsp; 
					<input type="button" value="글삭제" onclick="document.location.href='deleteForm.do?no=${article.no}&pageNum=${pageNum}'">
					&nbsp;&nbsp;&nbsp;&nbsp; 
					<input type="button" value="답글쓰기" onclick="document.location.href='writeForm.do?no=${article.no}&ref=${article.ref}&step=${article.step}&depth=${article.depth}'">
					&nbsp;&nbsp;&nbsp;&nbsp; 
					<input type="button" value="글목록" onclick="document.location.href='boardList.do?pageNum=${pageNum}'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>