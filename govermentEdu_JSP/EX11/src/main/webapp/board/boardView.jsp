<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 게시판 </title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="script/board.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<input id="check" type="hidden" value="${param.check}">
<div id="wrap" align="center">
<h1> 게시글 상세보기 </h1>
	<table>
		<tr>
			<th> 작성자 </th> <td>${board.name}</td>
			<th> 이메일 </th> <td>${board.email}</td>
		</tr>
		
		<tr>
			<th> 작성일 </th> <td><fmt:formatDate value="${board.writedate}"/></td>
			<th> 조회수 </th> <td>${board.readcount}</td>
		</tr>		
		
		<tr>
			<th width="500"> 제목 </th>
			<td colspan="3">${board.title}</td>
		</tr>	
		
		<tr>
			<th> 내용 </th>
			<td colspan="3"><pre>${board.content}</pre></td>
		</tr>			
	</table>
	<br><br>
	<input type="button" value="게시글 수정" onclick="open_win('BoardServlet?command=board_check_pass_form&num=${board.num}','update')">
	<input type="button" value="게시글 삭제" onclick="open_win('BoardServlet?command=board_check_pass_form&num=${board.num}','delete')">
	<input type="button" value="게시글 리스트" onclick="location.href='BoardServlet?command=board_list'">
	<input type="button" value="게시글 등록" onclick="location.href='BoardServlet?command=board_write_form'">
	<br>
	<!-- 댓글목록 --------------------------------------------------------------------------------->
	<table class="list" style="margin-top: 50px">
		<c:forEach var="reply" items="${replyList}">
		<tr class="record">
			<td style="border: none">
				${reply.name}<br>
				<fmt:formatDate value="${reply.writedate}"/><br><br>
				<pre>${reply.content}</pre>
			</td>
			<td width="20%" style="border:none">
				<!-- Button to Open the Modal -->
				<button type="button" class="btn btn-primary btn-sm replyUpdate" data-bs-toggle="modal" data-bs-target="#replyUpdate" value="${reply.no}">
				  수정
				</button>
				<button type="button" class="btn btn-primary btn-sm replyDelete" data-bs-toggle="modal" data-bs-target="#replyDelete" value="${reply.no}">
				  삭제
				</button>
			</td>
		</tr>
		<tr>
			<td style="border:none;" colspan="2">
				<hr>
			</td>
		</tr>
		</c:forEach>
	</table>
	<!-- 댓글목록 -->
	<!-- 댓글 입력폼 ------------------------------------------------------------------------------->
	<form action="BoardServlet" name="frm2" method="post">
		<input type="hidden" name="pNum" value="${board.num}">
		<input type="hidden" name="command" value="reply_write">
		<table>
			<tr>
				<td>
					<input type="text" name="name" placeholder="name">
				</td>
			</tr>
			<tr>
				<td>
					<input type="password" name="password" placeholder="password">
				</td>
			</tr>
			<tr>
				<td>
					<textarea name="content" rows="5" cols="100" placeholder="content"></textarea>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="댓글등록" onclick="return replyCheck()">
				</td>
			</tr>						
		</table>
	</form>
	<!-- 댓글 입력폼 -->
</div>

<!-- The Modal -->
<div class="modal" id="replyUpdate">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
	<form action="BoardServlet" name="frm3" method="post">
    <input type="hidden" name="pNum" value="${board.num}">
   	<input type="hidden" name="command" value="reply_update">
	<input id="re_update" type="hidden" name="no">
      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">댓글 수정</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
      	<input type="password" name="password" placeholder="password" style="margin-bottom: 20px">
      	<textarea name="content" rows="5" cols="53" placeholder="content"></textarea>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
      	<button type="submit" class="btn btn-danger" data-bs-dismiss="modal" onclick="return passwordCheck1()">수정</button>
        <button type="submit" class="btn btn-danger" data-bs-dismiss="modal">취소</button>
      </div>
    </form>
    </div>
  </div>
</div>
<!-- The Modal -->
<div class="modal" id="replyDelete">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
	<form action="BoardServlet" name="frm4" method="get">
	<input type="hidden" name="pNum" value="${board.num}">
   	<input type="hidden" name="command" value="reply_delete">
	<input id="re_delete" type="hidden" name="no" value="">
      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">댓글 삭제</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">

        <p>해당 댓글을 삭제하시겠습니까?</p>
        <input type="password" name="password" placeholder="password" style="margin-top: 20px">

      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
      	<button type="submit" class="btn btn-danger" data-bs-dismiss="modal" onclick="return passwordCheck2()">삭제</button>
        <button type="submit" class="btn btn-danger" data-bs-dismiss="modal">취소</button>
      </div>
    </form>
    </div>
  </div>
</div>
<script type="text/javascript">
let check = document.getElementById("check");
console.log(check);
if(check.getAttribute("value") == "false"){
	alert("비밀번호가 틀렸습니다.")
} else if(check.getAttribute("value") == "true"){
	alert("수정되었습니다.")
}

let replyUpdate = document.querySelectorAll(".replyUpdate");
for(let i = 0; i < replyUpdate.length; i++){
	replyUpdate[i].addEventListener("click", function(e){
		let target = e.target;
		let value = target.getAttribute("value");
		let re_update = document.getElementById("re_update");
		re_update.setAttribute("value", value);
	})
}

let replyDelete = document.querySelectorAll(".replyDelete");
for(let i = 0; i < replyDelete.length; i++){
	replyDelete[i].addEventListener("click", function(e){
		let target = e.target;
		let value = target.getAttribute("value");
		let re_delete = document.getElementById("re_delete");
		re_delete.setAttribute("value", value);
	})
}
</script>
</body>
</html>