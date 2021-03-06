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
                            글목록
                            <button id="regBtn" type="button" class="btn btn-primary btn-xs pull-right">글등록</button>
                            <div class="dropdown pull-right" style="margin: 0 10px;">
							  <button class="btn btn-default btn-xs dropdown-toggle" type="button" data-toggle="dropdown">페이지 당 글갯수
							  <span class="caret"></span></button>
							  <ul class="dropdown-menu">
							    <li><a href="list?pageNum=1&amount=5&type=&keyword=">5개씩</a></li>
							    <li><a href="list?pageNum=1&amount=10&type=&keyword=">10개씩</a></li>
							    <li><a href="list?pageNum=1&amount=15&type=&keyword=">15개씩</a></li>
							    <li><a href="list?pageNum=1&amount=20&type=&keyword=">20개씩</a></li>
							  </ul>
							</div>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>#번호</th>
                                        <th width="800">제목</th>
                                        <th>작성자</th>
                                        <th>작성일</th>
                                        <th>수정일</th>
                                    </tr>
                                </thead>
                                <tbody>
                                   <c:forEach items="${list}" var="board">
                                   		<tr>
                                   			<td><c:out value="${board.bno}"/></td>
                                   			<td>
                                   			<a class='move' href='<c:out value="${board.bno}"/>'>                                   			
                                   				<c:out value="${board.title}"/><b class="replyCnt">[ <c:out value="${board.replyCnt}"></c:out> ]</b>
                                   			</a>
                                   			</td>
                                   			<td><c:out value="${board.writer}"/></td>
                                   			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}"/></td>
                                   			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"/></td>
                                   		</tr>
                                   </c:forEach>
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                            
                            <!-- search bar -->
                            <div class="row">
                            	<div class="col-lg-12">
                            		
                            		<form id="searchForm" action="/board/list" method="get">
                            			<select name="type">
                            				<option value="" <c:out value="${pageMaker.cri.type == null?'selected':''}"/>>--</option>
                            				<option value="T" <c:out value="${pageMaker.cri.type eq 'T'?'selected':''}"/>>제목</option>
                            				<option value="C" <c:out value="${pageMaker.cri.type eq 'C'?'selected':''}"/>>내용
                            				<option value="W" <c:out value="${pageMaker.cri.type eq 'W'?'selected':''}"/>>작성자</option>
                            				<option value="TC" <c:out value="${pageMaker.cri.type eq 'TC'?'selected':''}"/>>제목&amp;내용</option>
                            			</select>
                            			<input type="text" name="keyword" value="<c:out value="${pageMaker.cri.keyword}"/>" />
                            			<input type="hidden" name="pageNum" value="<c:out value="${pageMaker.cri.pageNum}"/>" />
                            			<input type="hidden" name="amount" value="<c:out value="${pageMaker.cri.amount}"/>" />
                            			<button class="btn btn-primary">검색</button>
                            		</form>
                            	</div>
                            </div>
                            <!-- end search bar -->
                            
                            <!-- pagination -->
                            <div class="pull-right">
                            	<ul class="pagination">
                            		<c:if test="${pageMaker.prev}">
                            			<li class="paginate_button previous"><a href="${pageMaker.startPage - 1}">이전</a></li>
                            		</c:if>
                            		
                            		<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                            			<li class="paginate_button ${pageMaker.cri.pageNum == num ? "active" : ""}"><a href="${num}">${num}</a></li>
                            		</c:forEach>
                            	
                            		<c:if test="${pageMaker.next}">
                            			<li class="paginate_button previous"><a href="${pageMaker.endPage + 1}">다음</a></li>
                            		</c:if>                            		        		                         		                            		
                            	</ul>
                            </div>
                            <form id="actionForm" action="/board/list" method="get">
                            	<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
                            	<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
                            	<input type="hidden" name="type" value="<c:out value="${pageMaker.cri.type}"/>">
                            	<input type="hidden" name="keyword" value="<c:out value="${pageMaker.cri.keyword}"/>">
                            </form>
                            <!-- end pagination -->
                            
                            <!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                                        </div>
                                        <div class="modal-body">
                                            처리가 완료되었습니다.
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            <!-- /.modal -->
                            <script type="text/javascript">
                            	$(document).ready(function(){
                            		let result = '<c:out value="${result}"/>';
                            		
                            		checkModal(result);
                            		
                            		// history 상태값 초기화
                            		history.replaceState({},null,null);
                            		
                            		// 등록 후 목록으로 이동한 경우가 아니면 result 값이 없으므로 중지
                            		// history.state값이 있는 경우에도 종료
                            		function checkModal(result){
                            			if(result === '' || history.state){
                            				return
                            			}
                            			
                            			if(parseInt(result) > 0){
                            				$(".modal-body").html("게시글 " + parseInt(result) + " 번이 등록되었습니다.");
                            			}
                            			//모달창 보이게
                            			$("#myModal").modal("show");
                            		}
                            		// 글등록버튼 클릭시 등록화면으로 이동
                            		$("#regBtn").on("click", function(){
                            			self.location="/board/register"	
                            		});
                            		
                            		let actionForm = $("#actionForm");
                            		
                            		$(".paginate_button a").on("click", function(e){
                            			e.preventDefault();
                            			
                            			console.log('click');
                            			
                            			actionForm.attr("action", "/board/list");
                            			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
                            			actionForm.submit();
                            		})
                            		
                            		$(".move").on("click", function(e){
                            			e.preventDefault();
                            			
                            			$(".bnoValue").remove();
                            			actionForm.append("<input class='bnoValue' type='hidden' name='bno' value='"+ $(this).attr("href") +"'>")
                            			actionForm.attr("action", "/board/get");
                            			actionForm.submit();
                            		})
                            		
		                       		let searchForm = $("#searchForm");
                            		
                            		$("#searchForm button").on("click", function(e){
                            			
                            			e.preventDefault();
                            			
                            			if(!searchForm.find("option:selected").val()){
                            				alert("검색종류를 선택하세요.")
                            				return false;
                            			}                            			
                            			
                            			if(!searchForm.find("input[name='keyword']").val()){
                            				alert("키워드를 입력하세요.")
                            				return false;
                            			}
                            			
                            			searchForm.find("input[name='pageNum']").val("1");
                            			
                            			searchForm.submit();
                            		});
                            		
	                          		let replyCnt = $(".replyCnt");
	                          		
	                          		console.log(replyCnt);
	                          		
	                          		replyCnt.each((index, item)=>{
	                          			console.log($(item).html());
	                          
	                          			$(item).html() == "[ 0 ]"? $(item).html("") : $(item).html()
	                          		})
                            	})
                            </script>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
            
<%@include file="../includes/footer.jsp"%>