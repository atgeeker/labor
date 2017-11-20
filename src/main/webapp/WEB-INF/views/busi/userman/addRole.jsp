<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
</head>
<body>
	<div class="row">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_title">
					<h2>
						添加用户
					</h2>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<br />
					<form id="addUserForm" data-parsley-validate
						class="form-horizontal form-label-left">

						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="first-name">用户名 <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" id="username" name="username"
									class="form-control col-md-7 col-xs-12">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="last-name">密码 <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="password" id="password" name="password"
									 class="form-control col-md-7 col-xs-12">
							</div>
						</div>
						
						<div class="ln_solid"></div>
						<div class="form-group">
							<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
								<button type="button" class="btn btn-primary">返回</button>
								<button type="button" id="addbtn" class="btn btn-success">提交</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$().ready(function() {
			$("#addUserForm").validate({
		        rules: {
		        	username: {  
	                    required:true,  
	                    minlength:4
	            	},
	            	password:{
	            		 required:true,  
	                     minlength:6  
	            	}
		 		 },
		 		 message:{
		 			username: {  
	                    required:"用户名必填",  
	                    minlength:"至少4个字符"  
	           		}, 
	           		password:{
	           			required:"密码必填",  
	                    minlength:"至少6个字符" 
	           		}
		 		 }
		    })
		    });			
		
		$('#addbtn').on('click', function () {
			if(!$("#addUserForm").validate().form()){
				return;
			}
			$.post("${contextPath}/manuser/adduser", 
					{
	                username: $("#username").val(),
	                password: $("#password").val()
	            }, function (data) {
	            	BootstrapDialog.show({
                        title: '操作结果',
                        message: data,
                        buttons: [{
                            label: '确认',
                            cssClass: 'btn-primary',
                            action: function (dialogItself) {
                                dialogItself.close();
                                //loadPage('${contextPath}/manuser/loadadduserpage');
                            }
                        }]
                    });
	            });
    	});
		
		
		
</script>
</body>
</html>
