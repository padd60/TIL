<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String id = request.getParameter("userid"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>입력하신 아이디는 ...</h3>
<h2><%=id %>입니다!</h2>
</body>
</html>