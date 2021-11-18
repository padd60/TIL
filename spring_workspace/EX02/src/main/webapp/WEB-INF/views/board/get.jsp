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
                            글등록
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
								<div class="form-group">
									<label>Bno</label><input class="form-control" name="bno" value='<c:out value="${board.bno}"/>' readonly>
								</div>                        
								<div class="form-group">
									<label>Title</label><input class="form-control" name="title" value='<c:out value="${board.title}"/>' readonly>
								</div>
								<div class="form-group">
									<label>Content</label><textarea rows="3" class="form-control" name="content" readonly><c:out value="${board.content}"/></textarea>
								</div>
								<div class="form-group">
									<label>Writer</label><input class="form-control" name="writer" value='<c:out value="${board.writer}"/>' readonly>
								</div>
								<button data-oper="modify" class="btn btn-primary" onclick="location.href='/board/modify?bno=<c:out value="${board.bno}"/>'">수정</button>		
								<button data-oper="list" class="btn btn-info" onclick="location.href='/board/list'">목록</button>		
								
								<%-- <form id="openForm" action="/board/modify" method="get">
									<input type="hidden" id="bno" name="bno" value='<c:out value="${board.bno}"/>'>
								</form>	 --%>					
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
            
<%@include file="../includes/footer.jsp"%>