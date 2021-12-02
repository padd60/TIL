<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix='sec' %>
    
<%@ include file="../includes/header.jsp" %>
<style>

	.uploadResult{
		width : 100%;
		min-height : 100px;
		background-color : gray;
		color : white;
	}
	
	.uploadResult ul{
		display : flex;
		flex-flow : row;
		justify-content: center;
		align-items: center;
	}
	
	.uploadResult ul li{
		list-style: none;
		padding: 10px;

	}
	
	.uploadResult ul li a{
		display: flex;
		flex-flow: column;
		align-items: center;
	}
	
	.uploadResult ul li img{
		width: 100px;
	}
	
	.bigPictureWrapper{
		position: absolute;
		display: none;
		justify-content: center;
		align-items: center;
		top: 0%;
		width: 100%;
		height: 100%;
		background-color: gray;
		z-index: 100;
		background: rgba(255,255,255,0.5);
	}
	
	.bigPicture{
		position: relative;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	
	.bigPicture img{
		width: 600px;
	}
</style>

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
							<form action="/board/register" method="post" role="form">
								<div class="form-group">
									<label>Title</label><input id="title" class="form-control" name="title">
								</div>
								<div class="form-group">
									<label>Content</label><textarea id="content" rows="3" class="form-control" name="content"></textarea>
								</div>
								<div class="form-group">
									<label>Writer</label><input class="form-control" name="writer"
										value='<sec:authentication property="principal.username"/>' readonly="readonly">
								</div>
								<!-- 새로 추가한 부분 -->
					            <div class="row">
					            	<div class="col-lg-12">
					            		<div class="panel panel-default">
						            		<div class="panel-heading">File Attach</div>
						            		<!-- /. panel-heading -->
						            		
						            		<div class="panel-body">
							            		<div class="form-group uploadDiv">
							            			<input type="file" name="uploadFile" multiple>
							            		</div>
						            		
							            		<div class="uploadResult">
							            		이곳에 파일을 넣어주세요!
							            			<ul>
							            			
							            			</ul>
							            		</div>
						            		
						            		</div>
						            		<!-- end panel body -->
						            		
					            		</div>
					            		<!-- end panel-default -->
					            	</div>
					            	<!-- end col -->
					            </div>
					            <!-- end row -->
								<input type='hidden' name="${_csrf.parameterName}" value="${_csrf.token}">							
								<button type="submit" class="btn btn-default">등록</button>		
								<button data-oper="list" class="btn btn-default">취소</button>				
							</form>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /. row -->
            

            
            <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
            <script type="text/javascript">
			$(document).ready(function(e){
				
				
				
        		$("button[data-oper='list']").on("click", (e)=>{
        			e.preventDefault();
        			window.location.href="/board/list";
        		});
				
				let formObj = $("form[role='form']");
				
				
				$("button[type='submit']").on("click", function(e){
					
					e.preventDefault();
					
					console.log("submit clicked");
					
					if($("#title").val() == null || $("#title").val() == ""){
						alert("제목을 입력해주세요!")
						return;
					}
					
					if($("#content").val() == null || $("#content").val() == ""){
						alert("내용을 입력해주세요!")
						return;
					}
					
					let str = "";
					
					$(".uploadResult ul li").each(function(i, obj){
						let jobj = $(obj);
						
						console.dir(jobj);
						
						str += "<input type='hidden' name='attachList["+i+"].fileName' value='"+jobj.data("filename")+"'>";
						str += "<input type='hidden' name='attachList["+i+"].uuid' value='"+jobj.data("uuid")+"'>";
						str += "<input type='hidden' name='attachList["+i+"].uploadPath' value='"+jobj.data("path")+"'>";
						str += "<input type='hidden' name='attachList["+i+"].fileType' value='"+jobj.data("type")+"'>";
					});
					
					
					
					formObj.append(str).submit();
					
				});
				
				let regex = new RegExp("(.*?)\.(exp|sh|zip|alz)$");
				let maxSize = 5242880; //5MB
				
				function checkExtension(fileName, fileSize){
					
					if(fileSize >= maxSize){
						alert("파일 사이즈 초과");
						return false;
					}
					
					if(regex.test(fileName)){
						alert("해당 종류의 파일은 업로드할 수 없습니다.");
						return false;
					}
					return true;
					
				}
				
				$("input[type='file']").change(function(e){
					
					let formData = new FormData();
					
					let inputFile = $("input[name='uploadFile']");
					
					let files = inputFile[0].files;
					
					for(let i = 0; i < files.length; i++){
						
						if(!checkExtension(files[i].name, files[i].size)){
							return false;
						}
						formData.append("uploadFile", files[i]);
						
					}
					
					$.ajax({
						url: '/uploadAjaxAction',
						processData: false,
						contentType: false,
						data: formData,
						beforeSend: function(xhr){
							xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
						},
						type: 'POST',
						dataType: 'json',
						success: function(result){
							console.log(result);
							showUploadResult(result); // 업로드 결과 처리 함수
						}
					});
					
				});
				
				function showUploadResult(uploadResultArr){
					
					if(!uploadResultArr || uploadResultArr.length == 0){
						return;
					}
					
					let uploadUL = $(".uploadResult ul");
					
					let str = "";
					
					$(uploadResultArr).each(function(i, obj){
						
						//image type
						if(obj.image){
							
							let fileCallPath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);
							
							str += "<li data-path='"+ obj.uploadPath +"'";
							str += "data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"'"
							str += "><div>";
							str += "<span>"+ obj.fileName +"</span>";
							str += "<button type='button' data-file='"+ fileCallPath +"' data-type='image' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
							str += "<img src='/display?fileName="+ fileCallPath +"'>";
							str += "</div>";
							str += "</li>";
							
						} else{
							let fileCallPath = encodeURIComponent(obj.uploadPath+ "/" + obj.uuid + "_" + obj.fileName);
							
							let fileLink = fileCallPath.replace(new RegExp(/\\/g), "/");
							
							str += "<li "
							str += " data-path='"+ obj.uploadPath +"' data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"'><div>";
							str += "<span> " + obj.fileName + "</span>";
							str += "<button type='button' data-file='"+ fileCallPath +"' data-type='file' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
							str += "<img src='/resources/img/noun_attach.png'>";
							str += "</div>";
							str += "</li>";
						}
					});
					
					uploadUL.append(str);
				}
				
        		var csrfHeaderName="${_csrf.headerName}";
        		var csrfTokenValue="${_csrf.token}";
        		
				$(".uploadResult").on("click", "button", function(e){
					
					console.log("delete file");
					
					let targetFile = $(this).data('file');
					let type = $(this).data("type");
					
					let targetLi = $(this).closest("li");
					
					$.ajax({
						url: '/deleteFile',
						data: {fileName: targetFile, type: type},
						beforeSend: function(xhr){
							xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
						},
						dataType: 'text',
						type: 'POST',
						success: function(result){
							alert(result);
							targetLi.remove();
						}
					});
					
				});
				
				//파일 드래그시 새창으로 열리는것 방지
				$(".uploadResult").on("dragenter dragover",function(event){
					//기본이벤트취소.새창이 열리는 것 방지
					event.preventDefault();
				});
				
				//파일 드롭시 새창으로 열리는것 방지. 파일업로드
				$(".uploadResult").on("drop",function(event){
					//기본이벤트취소.새창이 열리는 것 방지
					event.preventDefault();
					
					//FormData객체 생성. form태그에 대응하는 객체
					var formData=new FormData();
					
					//drop했을 때 파일의 목록을 구함
					var files=event.originalEvent.dataTransfer.files;

					for(var i=0;i<files.length;i++){
						var file=files[i];
						console.log(file);
						//파일확장자,size체크
						if(!checkExtension(files[i].name,files[i].size)){
							return; //중지
						}
						formData.append("uploadFile",files[i]);
					}

					$.ajax({
						url: "/uploadAjaxAction",
						processData: false, //QueryString(uploadAjaxAction?name=hkd)을 생성하지 않고 
						contentType: false, //multipart/form-data형식으로 보냄
						beforeSend: function(xhr){
							xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
						},							
						data: formData,  //formData전송
						type: "POST",
						dataType: "json",
						success: function(result){
							console.log(result);
							
							showUploadResult(result);//파일명출력								
						}
					});
					
				});

			});
			
			
			</script>
            
<%@include file="../includes/footer.jsp"%>