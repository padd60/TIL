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
.container:hover input ~ .checkmark {
  background-color: #ccc;
}

/* When the checkbox is checked, add a blue background */
.container input:checked ~ .checkmark {
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
.container input:checked ~ .checkmark:after {
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
<title>Insert title here</title>
</head>
<body>
<div style="width: 460px; margin: 0 auto;">
<form method="post" action="createAccount.jsp" >
  <div style="text-align: center;">
	<c:url value="images/coupang.png" var="logo"></c:url>
  	<img alt="logo" src="${logo}" width="100%" >
  </div>
  <h4>회원정보를 입력해주세요</h4>
  <div class="input-container">
    <i class="fa fa-envelope icon"></i>
    <input class="input-field" type="text" placeholder="아이디(이메일)" name="userid">
  </div>

  <div class="input-container">
    <i class="fa fa-lock icon"></i>
    <input class="input-field" type="password" placeholder="비밀번호" name="pwd">
  </div>
  
  <div class="input-container">
    <i class="fa fa-check-square icon"></i>
    <input class="input-field" type="password" placeholder="비밀번호 확인" name="pwd">
  </div>
  
  <div class="input-container">
    <i class="fa fa-user icon"></i>
    <input class="input-field" type="text" placeholder="이름" name="name">
  </div>
  
  <div class="input-container">
    <i class="fa fa-phone-square icon"></i>
    <input class="input-field" type="text" placeholder="전화번호" name="phone">
  </div>
  <hr>
  <h4>쿠팡 서비스약관에 동의해주세요</h4>
  <label class="container"><b>모두 동의합니다.</b>
  <input type="checkbox">
  <span class="checkmark"></span>
  </label>
  <p style="margin-left: 35px; font-size: 12px; color: #666;">동의에는 필수 및 선택 목적(광고성 정보 수신 포함)에 대한 동의가 포함되어 있으며, 선택 목적의 동의를 거부하시는 경우에도 서비스 이용이 가능합니다.</p>
  <div style="padding: 20px 10px; margin: 20px auto; border: 1px solid #ccc">
  <label class="container" style="font-size: 14px">[필수] 만 14세 이상입니다
  <input type="checkbox">
  <span class="checkmark"></span>
  </label>
  <label class="container" style="font-size: 14px">[필수] 쿠팡 이용약관 동의
  <input type="checkbox">
  <span class="checkmark"></span>
  </label>
  <label class="container" style="font-size: 14px">[필수] 전자금융거래 이용약관 동의
  <input type="checkbox">
  <span class="checkmark"></span>
  </label>
  <label class="container" style="font-size: 14px">[필수] 개인정보 수집 및 이용 동의
  <input type="checkbox">
  <span class="checkmark"></span>
  </label>
  <label class="container" style="font-size: 14px">[필수] 개인정보 제3자 제공 동의
  <input type="checkbox">
  <span class="checkmark"></span>
  </label>
  <label class="container" style="font-size: 14px">[선택] 마케팅 및 이벤트 목적의 개인정보 수집 및 이용동의
  <input type="checkbox">
  <span class="checkmark"></span>
  </label>
  <label class="container" style="font-size: 14px">[선택] 광고성 정보 수신 동의
  <input type="checkbox">
  <span class="checkmark"></span>
  </label>
  <div style="margin-left: 30px;">
  <label class="container" style="font-size: 14px">[선택] 이메일 수신 동의
  <input type="checkbox">
  <span class="checkmark"></span>
  </label>
  <label class="container" style="font-size: 14px">[선택] SMS,MMS 수신 동의
  <input type="checkbox">
  <span class="checkmark"></span>
  </label>
  <label class="container" style="font-size: 14px">[선택] 앱 푸시 수신 동의
  <input type="checkbox">
  <span class="checkmark"></span>
  </label>
  </div>
  </div>
  <button type="submit" class="btn" style="font-size: 18px;"><b>동의하고 가입하기</b></button>
  <p style="color: #666; font-size: 10px; text-align: center;">©Coupang Corp. All rights reserved.</p>
</form>
</div>
</body>
</html>