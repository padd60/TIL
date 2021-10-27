<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div {
	margin: 20px 0;
}
</style>
</head>
<body>
<form method="post" action="LoginServlet">
  <div>
  <label for="id">아이디 : </label>
  <input type="text" name="id" id="id">  
  </div>
  <div>  
  <label for="pw">비밀번호 : </label>
  <input type="text" name="pw" id="pw">
  </div>
  <div>
  <label for="name">이름 : </label>
  <input type="text" name="name" id="name">  
  </div>
  <div>  
  <label for="email">이메일 : </label>
  <input type="text" name="email" id="email">
  </div>
  <div>  
  <label for="phone">전화번호 : </label>
  <input type="text" name="phone" id="phone">
  </div>
  <button>전송</button>
</form>
</body>
</html>