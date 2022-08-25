/*
	AJAX를 통한 데이터 통신
*/

const writeButton = document.querySelector(".write-button");

writeButton.onclick = () => {
	const title = document.querySelector(".board-title");
	const writer = document.querySelector(".board-writer");
	const content = document.querySelector(".board-content");
	
	let board = {
	"boardTitle": title.value,
	"boardWriter": title.writer,
	"boardContent": title.content,
	}
	
	send(board);	
}

function send() {
	const request = {
		async: false,					// async : 동기(false), 비동기(true)<default
		type: "post",					// RequestMethod
		url: "/api/v1/board/addition",	// 요청 URL
		data: board,					// 전송 데이터
		dataType: "json",				// 응답 데이터의 형식(Response Content Type)
		success: (response) => {		// 요청에 대한 응답이 성공했을 때 실행되는 funtion
			console.log(response);
		},
		error: (error) => {				// 요청 또는 응답이 실패했을 때 오류처리
			console.log(error);
		}
	}
	
	$.ajax(request);
	
}