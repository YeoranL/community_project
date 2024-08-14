//게시판
document.addEventListener('DOMContentLoaded', function() {
	var writeButton = document.getElementById('writePro');
	writeButton.addEventListener('click', function() {
		var query = {
			no: document.getElementById('no').value,
			ref: document.getElementById('ref').value,
			step: document.getElementById('step').value,
			depth: document.getElementById('depth').value,
			writer: document.getElementById('writer').value,
			email: document.getElementById('email').value,
			subject: document.getElementById('subject').value,
			content: document.getElementById('content').value,
			pass: document.getElementById('pass').value
		};
		console.log(query);

		var xhr = new XMLHttpRequest();
		xhr.open('POST', '/community/writePro.do', true);
		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

		xhr.onreadystatechange = function() {
			if (xhr.readyState === 4 && xhr.status === 200) {
				window.location.href = '/community/boardList.do';
			} else if (xhr.readyState === 4) {
				console.error('Error:', xhr.statusText);
			}
		};

		xhr.onerror = function() {
			console.error('Request failed');
		};

		var queryString = Object.keys(query)
			.map(function(key) {
				return encodeURIComponent(key) + '=' + encodeURIComponent(query[key]);
			})
			.join('&');

		xhr.send(queryString);
	});
	
	// [취소] 버튼 클릭 
	var cancelButton = document.getElementById('cancle');
	cancelButton.addEventListener('click', function() {
		window.location.href = "/community/boardList.do";
	});
});