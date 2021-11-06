<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 관리</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/product.js"></script>
</head>
<body>
<div id="wrap" align="center">
<h1>상품 삭제 - 관리자 페이지</h1>
<form method="post" action="productDelete.do" >
	<table>
	<tr>
		<td>
			<c:choose>
				<c:when test="${empty product.pictureUrl}">
					<img alt="img" src="upload/noimage.jpeg">
				</c:when>
				<c:otherwise>
					<img alt="img" src="upload/${product.pictureUrl}">
				</c:otherwise>
			</c:choose>
		</td>
		<td>
			<table>
				<tr>
					<th style="width: 150px"> 상 품 명 </th>
					<td>${product.name}</td>
				</tr>
				<tr>
					<th> 가 격 </th>
					<td>${product.price}원</td>
				</tr>
				<tr>
					<th> 설 명 </th>
					<td><div style="height: 220px; width: 100%">
							<%-- <pre>${product.description}</pre> --%>
							<textarea rows="15" cols="90" name-"description readonly>${product.description}</textarea>
							</div></td>
				</tr>
			</table>
		</td>
	</tr>
	</table>
	<br>
	<input type="hidden" name="code" value="${product.code}">
	<input type="submit" value="삭제" onclick="return deleteCheck()">
	<input type="button" value="목록" onclick="location.href='productList.do'">
</form>
</div>
</body>
</html>