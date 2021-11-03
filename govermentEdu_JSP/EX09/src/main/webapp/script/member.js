function loginCheck(){
	if(document.frm.userid.value.length == 0){
		alert("id를 입력하세요");
		frm.userid.focus();
		return false;
	}
	if(document.frm.pwd.value == ""){
		alert("비밀번호를 입력하세요");
		frm.pwd.focus();
		return false;
	}	
	return true;
}

function idCheck(){
	if(document.frm.userid.value == ""){
		alert('아이디를 입력하여 주십시오.');
		document.frm.userid.focus();
		return;
	}
	var url = "idCheck.do?userid=" + document.frm.userid.value;
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}

function idok(){
	opener.frm.userid.value=document.frm.userid.value;
	opener.frm.reid.value=document.frm.userid.value;
	self.close();
}

function joinCheck(){
	if(document.frm.name.value.length == 0){
		alert("이름을 써주세요.");
		frm.name.focus();
		return false;
	}
	if(document.frm.userid.value.length == 0){
		alert("아이디를 써주세요.");
		frm.userid.focus();
		return false;
	}
	if(document.frm.userid.value.length < 4){
		alert("아이디는 4글자이상이어야 합니다.");
		frm.userid.focus();
		return false;
	}	
	if(document.frm.pwd.value == ""){
		alert("비밀번호를 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}	
	if(document.frm.userid.value != document.frm.reid.value){
		alert("중복체크를 하지 않았습니다.");
		frm.userid.focus();
		return false;
	}			
	
	return true;
}