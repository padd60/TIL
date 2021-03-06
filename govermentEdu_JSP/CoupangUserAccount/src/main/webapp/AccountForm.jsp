<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Add icon library -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

.input-container {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  width: 100%;
  margin-bottom: 15px;
}

.icon {
  padding: 10px;
  background: #ddd;
  color: #666;
  min-width: 50px;
  text-align: center;
}

.input-field {
  width: 100%;
  padding: 10px;
  outline: none;
  border: 1px solid #ccc;
}

.input-field:focus {
  border-bottom: 2px solid dodgerblue;
}

/* Set a style for the submit button */
.btn {
  background-color: dodgerblue;
  color: white;
  padding: 15px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.btn:hover {
  opacity: 1;
}

/* The container */
.container {
  display: block;
  position: relative;
  padding-left: 35px;
  margin-bottom: 12px;
  cursor: pointer;
  font-size: 18px;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

/* Hide the browser's default checkbox */
.container input {
  position: absolute;
  opacity: 0;
  cursor: pointer;
  height: 0;
  width: 0;
}

/* Create a custom checkbox */
.checkmark {
  position: absolute;
  top: 0;
  left: 10px;
  height: 20px;
  width: 20px;
  background-color: #fff;
  border-radius: 5px;
  border: 1px solid #666;
}

/* On mouse-over, add a grey background color */
.container:hover .checkmark {
  background-color: #ccc;
}

#allCheck.active .checkmark{
  background-color: #2196F3;
}

#allCheck.active .checkmark:after{
  border: solid #fff;
  border-width: 0 3px 3px 0;
}

/* When the checkbox is checked, add a blue background */
.checkBoxes input.active+.checkmark {
  background-color: #2196F3;
}

.container:hover .checkmark:after{
  border: solid #fff;
  border-width: 0 3px 3px 0;
}

/* Create the checkmark/indicator (hidden when not checked) */
.checkmark:after {
  content: "";
  position: absolute;
}

/* Show the checkmark when checked */
.container input.active+.checkmark:after {
  display: block;
  border: solid #fff;
  border-width: 0 3px 3px 0;
}

/* Style the checkmark/indicator */
.container .checkmark:after {
  left: 6px;
  top: 2px;
  width: 4px;
  height: 9px;
  border: solid #ccc;
  border-width: 0 2px 2px 0;
  -webkit-transform: rotate(45deg);
  -ms-transform: rotate(45deg);
  transform: rotate(45deg);
}

</style>
<title>COUPANG_LOGIN</title>
</head>
<body>
<div style="width: 460px; margin: 0 auto;">
<form method="post" action="#" >
  <div style="margin: 50px auto 10px; width: 200px;">
  	<img alt="logo" src="images/logo-coupang.png" width="100%" >
  </div>
  <h4>??????????????? ??????????????????</h4>
  <div class="input-container">
    <i class="fa fa-envelope icon"></i>
    <input class="input-field" type="text" placeholder="?????????(?????????)" name="userid">
  </div>

  <div class="input-container">
    <i class="fa fa-lock icon"></i>
    <input class="input-field" type="password" placeholder="????????????" name="pwd">
  </div>
  
  <div class="input-container">
    <i class="fa fa-check-square icon"></i>
    <input class="input-field" type="password" placeholder="???????????? ??????" name="pwd">
  </div>
  
  <div class="input-container">
    <i class="fa fa-user icon"></i>
    <input class="input-field" type="text" placeholder="??????" name="name">
  </div>
  
  <div class="input-container">
    <i class="fa fa-phone-square icon"></i>
    <input class="input-field" type="text" placeholder="????????????" name="phone">
  </div>
  <hr>
  <h4>?????? ?????????????????? ??????????????????</h4>
  <label class="container" id="allCheck"><b>?????? ???????????????.</b>
  <span class="checkmark"></span>
  </label>
  <p style="margin-left: 35px; font-size: 12px; color: #666;">???????????? ?????? ??? ?????? ??????(????????? ?????? ?????? ??????)??? ?????? ????????? ???????????? ?????????, ?????? ????????? ????????? ??????????????? ???????????? ????????? ????????? ???????????????.</p>
  <div class="checkBoxes" style="padding: 20px 10px; margin: 20px auto; border: 1px solid #ccc">
  <label class="container" style="font-size: 14px">[??????] ??? 14??? ???????????????
  <input type="checkbox">
  <span class="checkmark"></span>
  </label>
  <label class="container" style="font-size: 14px">[??????] ?????? ???????????? ??????
  <input type="checkbox">
  <span class="checkmark"></span>
  </label>
  <label class="container" style="font-size: 14px">[??????] ?????????????????? ???????????? ??????
  <input type="checkbox">
  <span class="checkmark"></span>
  </label>
  <label class="container" style="font-size: 14px">[??????] ???????????? ?????? ??? ?????? ??????
  <input type="checkbox">
  <span class="checkmark"></span>
  </label>
  <label class="container" style="font-size: 14px">[??????] ???????????? ???3??? ?????? ??????
  <input type="checkbox">
  <span class="checkmark"></span>
  </label>
  <label class="container" style="font-size: 14px">[??????] ????????? ??? ????????? ????????? ???????????? ?????? ??? ????????????
  <input type="checkbox">
  <span class="checkmark"></span>
  </label>
  <label class="container" style="font-size: 14px">[??????] ????????? ?????? ?????? ??????
  <input type="checkbox">
  <span class="checkmark"></span>
  </label>
  <div style="margin-left: 30px;">
  <label class="container" style="font-size: 14px">[??????] ????????? ?????? ??????
  <input type="checkbox">
  <span class="checkmark"></span>
  </label>
  <label class="container" style="font-size: 14px">[??????] SMS,MMS ?????? ??????
  <input type="checkbox">
  <span class="checkmark"></span>
  </label>
  <label class="container" style="font-size: 14px">[??????] ??? ?????? ?????? ??????
  <input type="checkbox">
  <span class="checkmark"></span>
  </label>
  </div>
  
  </div>
  <button type="submit" class="btn" style="font-size: 18px;"><b>???????????? ????????????</b></button>
  <p style="color: #666; font-size: 10px; text-align: center;">??Coupang Corp. All rights reserved.</p>
</form>
<script type="text/javascript">
	let flag = false;
	let allCheck = document.querySelector("#allCheck")
	let checkBox = document.querySelectorAll(".checkBoxes input");
	
	allCheck.addEventListener("click", ()=>{
		let active = allCheck.getAttribute("class");
		if(active == "container active"){			
			allCheck.setAttribute("class", "container");
		}else{
			allCheck.setAttribute("class", "container active");
		}
	});
	
	for(let i = 0; i < checkBox.length; i++){
		checkBox[i].addEventListener("click", (e)=>{
			let target = e.target
			let active = target.getAttribute("class");
			
			if(active == "active"){			
				target.removeAttribute("class");
			}else{
				target.setAttribute("class", "active");
			}
		})
	}
	
	allCheck.addEventListener("click", (e)=>{	
		if(!flag){
			for(let i = 0; i < checkBox.length; i++){
				checkBox[i].setAttribute("class", "active")
			}
			for(let i = 0; i < checkBox.length; i++){
				checkBox[i].setAttribute("checked", "true");
			}
			flag = true;
			
		}else{
			for(let i = 0; i < checkBox.length; i++){
				checkBox[i].removeAttribute("class");
			}
			for(let i = 0; i < checkBox.length; i++){
				checkBox[i].removeAttribute("checked");
			}
			flag = false;
		}
		console.log(flag);
	})
	
	
</script>
</div>
</body>
</html>