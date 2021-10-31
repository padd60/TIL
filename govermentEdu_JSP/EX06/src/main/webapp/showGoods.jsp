<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>입력 완료된 정보</h2>
<form method="post" action="GoodsServlet">
	<table>
		<tr>
			<td>상품명</td>
			<td>${itemInfo.name}</td>
		</tr>
		<tr>
			<td>가격</td>
			<td>${itemInfo.price}</td>
		</tr>
		<tr>
			<td>설명</td>
			<td>${itemInfo.description}</td>
		</tr>
		<tr style="text-align: center;">
			<td></td>
			<td>
			<input type="submit" value="전송"/>
			<input type="reset" value="취소"/>
			</td>
		</tr>								
	</table>
</form>
</body>
</html>