<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
${"hello world"}
</div>
<div>
${5+2}
</div>
<div>${3 eq 3}</div>
<%
	String input="hello world";
%>
<div>${empty input}</div>

</body>
</html>