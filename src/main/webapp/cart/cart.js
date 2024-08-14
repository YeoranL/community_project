function cancel() {
	
	var loginID = document.getElementById('loginID').value;	

	if (loginID == null || loginID == "") {
		alert("로그인이 필요한 항목입니다.");
	} 

	alert("해당 강의가 취소되었습니다.");

}