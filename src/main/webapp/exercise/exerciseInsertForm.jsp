<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="exercise/exercise.css?v=5"/>
</head>
<body>
<h2>Exercise Information Form</h2>
<div id="exInsert">
  <form method="post" name="writeform" action="/community/exerciseInsertPro.do" >
    <table>
      <tr>
          <td>운동코드:</td>
          <td><input type="text" name="exCode"></td>
      </tr>
      <tr>
          <td>운동제목명:</td>
          <td><input type="text" name="exName"></td>
      </tr>
      <tr>
          <td>위치:</td>
          <td><input type="text" name="exLocation"></td>
      </tr>
      <tr>
          <td>날짜:</td>
          <td><input type="text" name="exDate"></td>
      </tr>
      <tr>
          <td>인원수:</td>
          <td><input type="number" name="exMembercount"></td>
      </tr>
      <tr>
          <td>강사아이디:</td>
          <td><input type="text" name="userId"></td>
      </tr>
      <tr>
          <td>가격:</td>
          <td><input type="text" name="exPrice"></td>
      </tr>
      <tr>
          <td colspan="2"><input type="submit" value="강의등록"></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>