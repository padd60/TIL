<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<%@ include file="../includes/header.jsp" %>

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            글수정
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<form action="/board/modify" method="post" role="form">
								<div class="form-group">
									<label>Bno</label><input class="form-control" name="bno" value='<c:out value="${board.bno}"/>' readonly>
								</div>                        
								<div class="form-group">
									<label>Title</label><input class="form-control" name="title" value='<c:out value="${board.title}"/>'>
								</div>
								<div class="form-group">
									<label>Content</label><textarea rows="3" class="form-control" name="content"><c:out value="${board.content}"/></textarea>
								</div>
								<div class="form-group">
									<label>Writer</label><input class="form-control" name="writer" value='<c:out value="${board.writer}"/>' readonly>
								</div>
								<div class="form-group">
									<label>RegDate</label><input class="form-control" name="regDate" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.regdate}"/>' readonly>
								</div>
								<div class="form-group">
									<label>Update Date</label><input class="form-control" name="updateDate" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.updateDate}"/>' readonly>
								</div>
								<button data-oper="modify" class="btn btn-primary">수정</button>		
								<button data-oper="remove" class="btn btn-danger">삭제</button>	
								<button data-oper="list" class="btn btn-info">목록</button>	
								<!-- 추가부분 -->
								<input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum }"/>'>
								<input type='hidden' name='amount' value='<c:out value="${cri.amount }"/>'>
							</form>									
                            <!-- /.table-responsive -->
                        </div>
                        <script type="text/javascript">
                        $(document).ready(function(){
                        	var formObj = $("form");
                        	
                        	$('button').on("click", function(e){
                        		
                        		e.preventDefault();
                        		
                        		let operation = $(this).data("oper");
                        		
                        		console.log(operation);
                        		
                        		if(operation === 'remove'){
                        			formObj.attr("action", "/board/remove");
                        		} else if(operation === 'list'){
                        			// 목록으로 이동
									formObj.attr("action", "/board/list").attr("method", "get");
                        			// hidden tag 복제
                        			let pageNumTag = $("input[name='pageNum']").clone();
                        			let amountTag = $("input[name='amount']").clone();
                        			formObj.empty();
                        			
                        			// 다시 hidden tag 추가
                        			formObj.append(pageNumTag);
                        			formObj.append(amountTag);
                        		}
                        		formObj.submit();
                        	})
                        })
                        </script>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
            
<%@include file="../includes/footer.jsp"%>