<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="b.jsp" method="get">
    <input type="text" name="userid" id="id">
    <input type="submit" value="전송">
  </form>
  <a id="link" href="#">클릭</a>
  <button id="loca">location방식 이동</button>
  <script type="text/javascript">
    let id = document.getElementById("id");
    let link = document.getElementById("link");
    link.addEventListener("click", ()=>{
      let userid = "b.jsp?userid=" + id.value;
      link.setAttribute("href", userid);
    })
    
 	let loca = document.getElementById("loca");
	loca.addEventListener("click", ()=>{
    	location.href="b.jsp?userid=" + id.value;
    })
  	</script>
</body>
</html>