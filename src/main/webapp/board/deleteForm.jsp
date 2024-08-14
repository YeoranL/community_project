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
	<form method="POST" name="delForm" action="/community/deletePro.do?pageNum=${pageNum}" onsubmit="return deleteSave()">
		<table border="1" align="center" cellspacing="0" cellpadding="0" width="360">
			<tr height="30">
				<td align=center ><b>비밀번호를 입력해 주세요.</b></td>
			</tr>
			<tr height="30">
				<td align=center>비밀번호 : 
					<input type="password" name="pass" size="8" maxlength="12"> 
					<input type="hidden" name="no" value="${no}"></td>
			</tr>
			<tr height="30">
				<td align=center >
				<input type="submit" value="글삭제"> 
				<input type="button" value="글목록" onclick="document.location.href='boardList.do?pageNum=${pageNum}'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>