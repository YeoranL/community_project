function userIdCheck() {
	const userId = document.querySelector("#userId");
	const userIdInfo = document.querySelector("#userIdInfo");

	let idExp = /^[a-z]+[a-z0-9]{5,19}$/g;
	if (!userId.value.match(idExp)) {
		userIdInfo.innerHTML = '영문자로 시작하는 영문자 또는 숫자 6~20자 입력바람';
		return false;
	} else if (userId.value === "") {
		userIdInfo.innerHTML = '공백불가합니다.';
		return false;
	} else {
		userIdInfo.innerHTML = '';
		return true;
	}
}
    
function idCheck() {
	var userId = document.getElementById('userId').value;
	if (userId == "") {
		alert("아이디를 입력해 주세요.");
		document.regForm.userId.focus();
	} else {
		url = "idCheck.jsp?userId=" + userId;
		window.open(url, "post", "width=300,height=150");
	}
}

function userPwdCheck() {
	const userPwd = document.querySelector("#userPassword");
	const userPwdInfo = document.querySelector("#userPwdInfo");
	//한글2~4문자, 영문자2~10문자 패턴 (정규표현식)
	let pwdExp = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{4,12}$/;
	if (!userPwd.value.match(pwdExp)) {
		userPwdInfo.innerHTML = '비밀번호 형식대로 입력바람';
		return false;
	} else if (userPwd.value === "") {
		userPwdInfo.innerHTML = '공백불가합니다.';
		return false;
	} else {
		userPwdInfo.innerHTML = '사용가능합니다.';
		return true;
	}
}

function userPwdOkCheck() {
	const userPwd = document.querySelector("#userPassword");
	const userPwdOk = document.querySelector("#userPassword2");
	const userPwdOkInfo = document.querySelector("#userPwdOkInfo");

	if (userPwd.value === userPwdOk.value) {
		userPwdOkInfo.innerHTML = `일치합니다.`;
		return true;
	} else {
		//패턴검색
		userPwdOkInfo.innerHTML = `패스워드가 일치하지 않습니다.`;
		return false;
	}
}

function userEmailCheck() {
	const userEmail = document.querySelector("#userEmail");
	const userEmailInfo = document.querySelector("#userEmailInfo");
	//한글2~4문자, 영문자2~10문자 패턴 (정규표현식)
	let mailExp = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;
	if (!userEmail.value.match(mailExp)) {
		userEmailInfo.innerHTML = '이메일 형식대로 입력바람';
		return false;
	} else if (userEmail.value === "") {
		userEmailInfo.innerHTML = '공백불가합니다.';
		return false;
	} else {
		userEmailInfo.innerHTML = '사용가능합니다.';
		return true;
	}
}

function execDaumPostcode() {
	new daum.Postcode({
		oncomplete: function(data) {
			document.getElementById('postcode').value = data.zonecode;
			document.getElementById('addr').value = data.address;
		}
	}).open();
}

function allCheck(event) {
	if (userPwdCheck() && userEmailCheck()) {
		alert("회원가입 성공");
		document.regForm.submit();
	} else {
		alert("가입내용이 문제가 있습니다. 점검해보세요.");
		event.preventDefault();
	}
}

function allCheck2() {
		alert("정보수정 성공");
		document.regForm.submit();
}

function process() {
	// [가입하기] 버튼 클릭 
	var query = {
		id: document.getElementById('userId').value,
		pwd: document.getElementById('userPassword').value,
		name: document.getElementById('userName').value,
		email: document.getElementById('userEmail').value,
		phone: document.getElementById('userPhone').value,
		birth: document.getElementById('birthday').value,
		postcode: document.getElementById('postcode').value,
		addr: document.getElementById('addr').value,
		addr1: document.getElementById('addr1').value,
		addr2: document.getElementById('addr2').value,
		kakao: document.getElementById('kakao').value,
		mailing: document.getElementById('mailing').value,
		sns: document.getElementById('sns').value,
		security: document.getElementById('security').value,
		isInstructor: document.getElementById('isInstructor').value,
		insExercise: document.getElementById('insExercise').value
	};
	
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "/community/registerPro.do", true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.onreadystatechange = function() {
		if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
			window.location.href = "/community/index.do";
		} else {
			console.error('Error:', xhr.statusText);
		}
	};
	xhr.send("user_id=" + encodeURIComponent(query.id) +
		"&user_password=" + encodeURIComponent(query.pwd) +
		"&user_name=" + encodeURIComponent(query.name) +
		"&user_email=" + encodeURIComponent(query.email) +
		"&user_phone=" + encodeURIComponent(query.phone) +
		"&birthday=" + encodeURIComponent(query.birth) + 
		"&postcode=" + encodeURIComponent(query.postcode) + 
		"&addr=" + encodeURIComponent(query.addr) + 
		"&addr1=" + encodeURIComponent(query.addr1) + 
		"&addr2=" + encodeURIComponent(query.addr2) + 
		"&kakao=" + encodeURIComponent(query.kakao) + 
		"&mailing=" + encodeURIComponent(query.mailing) + 
		"&sns=" + encodeURIComponent(query.sns) + 
		"&security=" + encodeURIComponent(query.security) + 
		"&is_instructor=" + encodeURIComponent(query.isInstructor) + 
		"&ins_exercise=" + encodeURIComponent(query.insExercise)
	);
}

function writeSave() {
	if (document.writeForm.writer.value == "") {
		alert("작성자를 입력하십시요.");
		document.writeForm.writer.focus();
		return false;
	}
	if (document.writeForm.subject.value == "") {
		alert("제목을 입력하십시요.");
		document.writeForm.subject.focus();
		return false;
	}
	if (document.writeForm.content.value == "") {
		alert("내용을 입력하십시요.");
		document.writeForm.content.focus();
		return false;
	}

	if (document.writeForm.pass.value == "") {
		alert(" 비밀번호를 입력하십시요.");
		document.writeForm.pass.focus();
		return false;
	}
}  


