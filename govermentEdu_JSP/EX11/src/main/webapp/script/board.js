window.onload = function(){
	let check = document.getElementById("check");
	console.log(check);
	if(check.getAttribute("value") == "false"){
		alert("비밀번호가 틀렸습니다.")
	} else if(check.getAttribute("value") == "true"){
		alert("수정되었습니다.")
	}
	
	let del = document.getElementById("del");
	console.log(del);
	if(del.getAttribute("value") == "false"){
		alert("비밀번호가 틀렸습니다.")
	} else if(del.getAttribute("value") == "true"){
		alert("삭제되었습니다.")
	}
	
	let replyUpdate = document.querySelectorAll(".replyUpdate");
	for(let i = 0; i < replyUpdate.length; i++){
		replyUpdate[i].addEventListener("click", function(e){
			let target = e.target;
			let value = target.getAttribute("value");
			let re_update = document.getElementById("re_update");
			re_update.setAttribute("value", value);
		})
	}
	
	let replyDelete = document.querySelectorAll(".replyDelete");
	for(let i = 0; i < replyDelete.length; i++){
		replyDelete[i].addEventListener("click", function(e){
			let target = e.target;
			let value = target.getAttribute("value");
			let re_delete = document.getElementById("re_delete");
			re_delete.setAttribute("value", value);
		})
	}
}

function boardCheck(){
	if(document.frm.name.value.length == 0){
		alert("작성자를 입력하세요.")
		document.frm.name.focus();
		return false;
	}
	if(document.frm.pass.value.length == 0){
		alert("비밀번호를 입력하세요.")
		document.frm.pass.focus();
		return false;
	}
	if(document.frm.title.value.length == 0){
		alert("제목을 입력하세요.")
		document.frm.title.focus();
		return false;
	}
	if(document.frm.content.value.length == 0){
		alert("내용을 입력하세요.")
		document.frm.content.focus();
		return false;
	}
	return true;
}

function open_win(url, name){
	window.open(url, name, "width=500, height=230");
}

function passCheck(){
	if(document.frm.pass.value.length == 0){
		alert("비밀번호를 입력하세요.")
		document.frm.pass.focus();
		return false;
	}
	return true;
}

function replyCheck(){
	if(document.frm2.name.value.length == 0){
		alert("작성자를 입력하세요.")
		document.frm2.name.focus();
		return false;
	}
	if(document.frm2.password.value.length == 0){
		alert("비밀번호를 입력하세요.")
		document.frm2.password.focus();
		return false;
	}
	if(document.frm2.content.value.length == 0){
		alert("내용을 입력하세요.")
		document.frm2.content.focus();
		return false;
	}
	return true;
}

function passwordCheck1(){
	if(document.frm3.password.value.length == 0){
		alert("비밀번호를 입력하세요.")
		document.frm3.password.focus();
		return false;
	}
	return true;
}

function passwordCheck2(){
	if(document.frm4.password.value.length == 0){
		alert("비밀번호를 입력하세요.")
		document.frm4.password.focus();
		return false;
	}
	return true;
}

