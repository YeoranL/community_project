<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <jsp:useBean id="dao" class="mymemberone.MemberDAO" scope="page" />
<%
String userid = request.getParameter("userid");
boolean check = dao.idCheck(userid);
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID중복체크</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="script.js"></script>
</head>
<body>
	<%-- <b><%=userid%></b>
	<%
	if (check) {
		out.println("는 이미 존재한는 ID입니다.<br></br>");
	} else {
		out.println("는 사용 가능 합니다.<br></br>");
	}
	%> --%>
	<a href="#" onClick="javascript:self.close()">닫기</a>
</body>
</html>