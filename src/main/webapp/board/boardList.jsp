<%@ page language="java" contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<meta name="viewport" content="width=device-width,initial-scale=1.0"/> 
<link rel="stylesheet" href="board/board.css?v=2"/>
 
<div id="shop" class="box2">      
  <div class="write_button">
  <a href="/community/writeForm.do">글쓰기</a>
  </div>					
	<c:if test="${count == 0}">
		<table width="700" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">게시판에 저장된 글이 없습니다.</td>
			</tr>
		</table>
	</c:if>
	<c:if test="${count > 0}">
	<table border="1" width="700" cellpadding="0" cellspacing="0" align="center">
      <tr height="30">
      	<td align="center" width="50">번 호</td>
				<td align="center" width="250">제 목</td>
				<td align="center" width="100">작성자</td>
				<td align="center" width="150">작성일</td>
				<td align="center" width="50">조 회</td>
				<td align="center" width="100">IP</td>
      </tr>
      <c:forEach var="board" items="${boardList}"> 
			<tr height="30">
				<td align="center" width="50">
					<c:out value="${number}" /> 
					<c:set var="number" value="${number - 1}" />
				</td>
				<td width="250" style="text-align: left;">
					<c:if test="${board.depth > 0}">
						<img src="board/images/level.gif" width="${5 * board.depth}" height="16">
						<img src="board/images/re.gif"> 
					</c:if> 
					<c:if test="${board.depth == 0}">
						<img src="board/images/level.gif" width="${5 * board.depth}" height="16">
					</c:if> 
					<a href="content.do?no=${board.no}&pageNum=${currentPage}">${board.subject}</a> 
					<c:if test="${board.readcount >= 20}">
						<img src="board/images/hot.gif" border="0" height="16">
					</c:if>
				</td>
				<td align="center" width="100">
					<a href="mailto:${board.email}">${board.writer}</a>
				</td>
				<td align="center" width="150">${board.regdate}</td>
				<td align="center" width="50">${board.readcount}</td>
				<td align="center" width="100">${board.ip}</td>
			</tr>
			</c:forEach> 
     </table>      
  </c:if>
  <p class="b">총 ${count}건</p>
  <div class="page_section" align="center">
	  <c:if test="${count > 0}">
			<c:set var="imsi" value="${ count % pageSize == 0 ? 0 : 1 }" />
			<c:set var="pageCount" value="${count / pageSize + imsi}" />
			<c:set var="pageBlock" value="${3}" />
			<fmt:parseNumber var="result" value="${(currentPage-1) / pageBlock}" integerOnly="true" />
			<c:set var="startPage" value="${result * pageBlock + 1}" />
			<c:set var="endPage" value="${startPage + pageBlock-1}" />
			<c:if test="${endPage > pageCount}">
				<c:set var="endPage" value="${pageCount}" />
			</c:if>
			<c:if test="${startPage > pageBlock}">
				<a href="boardList.do?pageNum=${startPage - pageBlock }">[이전]</a>
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<a href="boardList.do?pageNum=${i}">[${i}]</a>
			</c:forEach>
			<c:if test="${endPage < pageCount}">
				<a href="boardList.do.do?pageNum=${startPage + pageBlock}">[다음]</a>
			</c:if>
		</c:if>
  </div>
	
</div>