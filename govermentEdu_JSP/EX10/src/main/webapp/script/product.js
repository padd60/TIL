function productCheck(){
	if(document.frm.name.value.length == 0){
		alert("상품명을 써주세요.");
		frm.name.focus();
		return false;
	}
	if(document.frm.price.value.length == 0){
		alert("가격을 써주세요.");
		frm.price.focus();
		return false;
	}
	if(idNaN(document.frm.name.price)){
		alert("숫자를 입력해야 합니다.");
		frm.price.select();
		return false;
	}
	return true;
}