<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Layout01</title>
    <style>
        *{ padding: 0; margin: 0;}
        #header{
            background: black;
            color: white;
            width: 800px;
            height: 200px;
        }
        h1{
            padding-left: 20px;
            padding-top: 20px;
        }

        #aside{
            background: #dddddd;
            width:200px;
            height:500px; 
            float: left;
        }
        #article{
            background: #cccccc;
            width: 600px;
            height: 500px;
            float: left;
        }

        #wrap{
            width: 800px;
            margin: auto;
        }
    </style>
</head>
<body>
    <div id="wrap">
        <div id="header">
            <h1>TIS 정보기술 교육센터</h1>
        </div>
		<jsp:include page="layoutMenu.jsp"></jsp:include>
        <div id="aside"></div>
        <div id="article"></div>
		<jsp:include page="layoutFooter.jsp"></jsp:include>
    </div>
</body>
</html>