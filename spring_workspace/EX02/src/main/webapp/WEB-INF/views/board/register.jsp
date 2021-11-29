<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<%@ include file="../includes/header.jsp" %>
<style>

	.uploadResult{
		width : 100%;
		background-color : gray;
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
									<label>Title</label><input class="form-control" name="title">
								</div>
								<div class="form-group">
									<label>Content</label><textarea rows="3" class="form-control" name="content"></textarea>
								</div>
								<div class="form-group">
									<label>Writer</label><input class="form-control" name="writer">
								</div>
								<button class="btn btn-default">등록</button>		
								<button class="btn btn-default">취소</button>											
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
            
            <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
            <script type="text/javascript">
			$(document).ready(function(e){
				
				let formObj = $("form[role='form']");
				
				$("button[type='submit']").on("click", function(e){
					
					e.preventDefault();
					
					console.log("submit clicked");
					
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
							
							str += "<li><div>";
							str += "<span>"+ obj.fileName +"</span>";
							str += "<button type='button' data-file='"+ fileCallPath +"' data-type='image' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
							str += "<img src='/display?fileName="+ fileCallPath +"'>";
							str += "</div>";
							str += "</li>";
							
						} else{
							let fileCallPath = encodeURIComponent(obj.uploadPath+ "/" + obj.uuid + "_" + obj.fileName);
							
							let fileLink = fileCallPath.replace(new RegExp(/\\/g), "/");
							
							str += "<li><div>";
							str += "<span> " + obj.fileName + "</span>";
							str += "<button type='button' data-file='"+ fileCallPath +"' data-type='file' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
							str += "<img src='/resources/img/noun_attach.png'>";
							str += "</div>";
							str += "</li>";
						}
					});
					
					uploadUL.append(str);
				}
				
				$(".uploadResult").on("click", "button", function(e){
					
					console.log("delete file");
					
					let targetFile = $(this).data('file');
					let type = $(this).data("type");
					
					let targetLi = $(this).closest("li");
					
					$.ajax({
						url: '/deleteFile',
						data: {fileName: targetFile, type: type},
						dataType: 'text',
						type: 'POST',
						success: function(result){
							alert(result);
							targetLi.remove();
						}
					});
					
				});

			});
			
			
			</script>
            
<%@include file="../includes/footer.jsp"%>