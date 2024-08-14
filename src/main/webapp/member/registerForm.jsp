<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="member/member.css?v=3"/>
<script type="text/javascript" src="./script.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<div id="regForm" class="box">
		<h4>사이트 이용정보 입력</h4>
    <table>
      <tr>
        <td class="title"><label for="userId">아이디</label></td>
        <td>
          <span>영문자, 숫자, _만 입력가능, 최소3자이상 입력하세요</span><br>
          <input type="text" name="userId" id="userId" size="25" minlength="3" maxlength="12" onkeyup="userIdCheck()">&nbsp;
          <input type="button" value="중복확인" onClick="idCheck()" />
        	<span id="userIdInfo" style="color: red;"></span>
        </td>
      </tr>
      <tr>
        <td class="title"><label for="userPassword">비밀번호</label></td>
        <td>
          <span>4~12자리의 영문,숫자,특수문자(!,@,$,%,^,&,*)만 가능</span><br>
          <input type="password" name="userPassword" id="userPassword" size="25" minlength="3" maxlength="12" required onkeyup="userPwdCheck()">
        	<span id="userPwdInfo" style="color: red;"></span>
        </td>
      </tr>
      <tr>
        <td class="title"><label for="userPassword2">비밀번호 확인</label></td>
        <td>
          <input type="password" name="userPassword2" id="userPassword2" size="25" minlength="3" maxlength="12" required onkeyup="userPwdOkCheck()">
        	<span id="userPwdOkInfo" style="color: red;"></span>
        </td>
      </tr>
    </table>

    <h4>개인정보 입력</h4>
    <table>
      <tr>
        <td class="title"><label for="userName">이름</label></td>
        <td>
          <input type="text" name="userName" id="userName" size="25">
        </td>
      </tr>
      <tr>
        <td class="title"><label for="userEmail">E-mail</label></td>
        <td>
          <input type="text" name="userEmail" id="userEmail" size="40" onkeyup="userEmailCheck()">
          <span id="userEmailInfo" style="color: red;"></span>
        </td>
      </tr>
      <tr>
        <td class="title"><label for="isInstructor" >강사여부</label></td>
        <td>
          <label class="radio-label">
          <input type="radio" name="isInstructor" id="isInstructor" value="1">
          <span>강사</span>
        </label>
        <label class="radio-label">
          <input type="radio" name="isInstructor" id="isInstructor" value="2">
          <span>일반</span>
        </label>
        </td>
      </tr>
      <tr>
        <td class="title"><label for="insExercise">강의할 운동명</label></td>
        <td>
          <input type="text" name="insExercise" id="insExercise" size="25">
        </td>
      </tr>
      <tr>
        <td class="title"><label for="userPhone">휴대폰번호</label></td>
        <td>
          <input type="text" name="userPhone" id="userPhone" size="25">
        </td>
      </tr>
      <tr>
        <td class="title"><label for="birthday">생년월일</label></td>
        <td>
          <input type="text" name="birthday" id="birthday" size="20" placeholder="연도-월-일">
        </td>
      </tr>
      <tr>
        <td class="title"><label for="address">주소</label></td>
        <td>
          <input type="text" name="postcode" id="postcode" size="15"><input type="button" value="주소검색" style="background-color: black; color: white;" onclick="execDaumPostcode()"><br>
          <input type="text" name="addr" id="addr" size="30"><span>기본주소</span><br>
          <input type="text" name="addr1" id="addr1" size="30"><span>상세주소</span><br>
          <input type="text" name="addr2" id="addr2" size="30"><span>참고항목</span><br>
        </td>
      </tr>
    </table>

    <h4>기타 개인설정</h4>
    <table>
      <tr>
        <td class="title"><label for="kakao">카카오톡 메세지</label></td>
        <td>
        	<label class="checkbox-label">
          <input type="checkbox" name="kakao" id="kakao" >
          <span>카카오톡 메세지를 받겠습니다.</span>
          </label>
          <span style="color: red;">&gt;수신체크를 하시면 세일 소식을 가장 먼저 받아보실 수 있습니다.</span>
        </td>
      </tr>
      <tr>
        <td class="title"><label for="mailing">메일링서비스</label></td>
        <td>
        	<label class="checkbox-label">
          <input type="checkbox" name="mailing" id="mailing" ><span>정보 메일을 받겠습니다.</span>
        	</label>
        </td>
      </tr>
      <tr>
        <td class="title"><label for="sns">SNS 수신여부</label></td>
        <td>
        	<label class="checkbox-label">
          <input type="checkbox" name="sns" id="sns" ><span>휴대폰 문자메세지를 받겠습니다.</span>
        	</label>
        </td>
      </tr>
      <tr>
        <td class="title"><label for="security">정보공개</label></td>
        <td>              	
          <span>정보공개를 바꾸시면 앞으로 0원 이내에는 변경이 안됩니다.</span><br>
          <label class="checkbox-label">    
          <input type="checkbox" name="security" id="security" >          
          <span>다른분들이 나의 정보를 볼 수 있도록 합니다.</span>
          </label>          
        </td>
      </tr>
    </table>
    <br>
    <div style="text-align: center;">
      <button id="process" onclick="process()">회원가입</button>
      <button id="cancle">취소</button> 
    </div>
	</div>
</body>
</html>