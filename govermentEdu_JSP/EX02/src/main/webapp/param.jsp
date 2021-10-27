<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="param.js"></script>
</head>
<body>
<form method="get" action="ParamServlet" name="frm">
	아이디 : <input type="text" name="id"><br>
	나 이 : <input type="text" name="age"><br>
	<input type="submit" value="submit타입 전송" onclick="return check()">
	<input type="button" value="button타입 전송" onclick="check2()">
	<button onclick="return check()">button태그 전송</button>
	<button type="button" onclick="check2()">button태그의 button타입 전송</button>
</form>
</body>

</html>