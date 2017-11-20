<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
</head>
<body>

<!-- 添加用户模态框 -->
<div class="modal fade" id="userAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="closeBtn();"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加用户</h4>
      </div>
      <div class="modal-body">
        <form id="addUserForm" data-parsley-validate class="form-horizontal form-label-left">
		  <div class="form-group">
              <label class="control-label col-md-3 col-sm-3 col-xs-12">用户名&nbsp;<span class="required">*</span>
              </label>
              <div class="col-md-8 col-sm-4 col-xs-12">
                  <input type="text" id="username" name="username" class="form-control col-md-7 col-xs-12" placeholder="用户名" />
              </div>
          </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">密码&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="password" id="password" name="password" class="form-control col-md-7 col-xs-12">
	         </div>
	     </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="closeBtn();">关闭</button>
	        <button type="button" class="btn btn-primary" id="user_save_btn">保存</button>
	      </div>
		</form>
      </div>
    </div>
  </div>
</div>

<!-- 修改用户模态框 -->
<div class="modal fade" id="userEditModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="closeBtn();"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="edit_myModalLabel">用户信息修改</h4>
      </div>
      <div class="modal-body">
        <form id="editUserForm" data-parsley-validate class="form-horizontal form-label-left">
          <input type="hidden" id="edit_id" name="id" />
		  <div class="form-group">
              <label class="control-label col-md-3 col-sm-3 col-xs-12">用户名&nbsp;<span class="required">*</span>
              </label>
              <div class="col-md-8 col-sm-4 col-xs-12">
                  <input type="text" id="edit_username" name="username" class="form-control col-md-7 col-xs-12" readonly="readonly"/>
              </div>
          </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">密码&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="password" id="edit_password" name="password" class="form-control col-md-7 col-xs-12">
	         </div>
	     </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="closeBtn();">关闭</button>
	        <button type="button" class="btn btn-primary" id="user_edit_btn">保存</button>
	      </div>
		</form>
      </div>
    </div>
  </div>
</div>

<div class="row">
    <div class="col-md-12">
        <div class="panel panel-default">
            <div class="tab-content">
                <div class="panel panel-default">
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="icon-home"></i> 首页</a></li>
                        <li><a href="#">用户管理</a></li>
                    </ol>
                    <div role="form" id="search_form_mytask" class="form-horizontal" style="float: left;width:60%;">
                        <div id="simpleSearchLabel">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">用户名</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="s_eusername"
                                           name="s_eusername" placeholder="用户名">
                                </div>
                                <button id="btn-search-user" class="btn btn-primary btn-sm"
                                        style="margin-left: 1%">
                                    <i class="icon-search"></i> 查询
                                </button>
                                <shiro:hasAnyRoles name="admin,manager">
		                            <button id="btn-search-add" class="btn btn-primary btn-sm">
		                                <i class="icon-search"></i> 添加
		                            </button>
		                            <button id="btn-search-edit" class="btn btn-primary btn-sm">
		                                <i class="icon-search"></i> 修改
		                            </button>
		                            <button id="btn-search-del" class="btn btn-danger btn-sm">
		                                <i class="icon-search"></i> 删除
		                            </button>
		                        </shiro:hasAnyRoles>
		                        	&nbsp;&nbsp;<strong>当前在职人数:</strong>&nbsp; ${countEntry}
                            </div>
                        </div>
                    </div>
                    <!-- <div id="batch-toolbar">
                    </div> -->
                    <table id="queryUserTable"></table>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $('#queryUserTable').bootstrapTable(
            {
                classes: 'table table-hover',
                pagination: true,
                height: 450,
                sidePagination: 'server',
                dataType: 'json',
                striped: 'true',
                pageNumber: 1,
                pageSize: 10,
                pageList: [1, 5, 10, 20],
                queryParamsType: '',//默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
                // 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
                showRefresh: true,
                toolbar: '#toolbar',
                showColumns: true,
                search: false,
                showToggle: 'true',
                showPaginationSwitch: 'true',
                uniqueId: 'id',
                clickToSelect: 'true',
                queryParams: function (params) {
                    params.username = $("#s_eusername").val();
                    return params;
                },
                method: 'POST',
                contentType: "application/x-www-form-urlencoded",
                url: '${contextPath}/manuser/queryuser',
                columns: [
                    {
                        radio: true
                    },
                    {
                        field: 'id',
                        title: 'ID'
                    },
                    {
                        field: 'username',
                        title: '用户名'
                    }, {
                        field: 'password',
                        title: '密码'
                    }, {
                        field: 'ipaddress',
                        title: 'ip地址'
                    }],
            }
        );
    });

    //添加用户输入校验
    $("#addUserForm").validate({
        rules: {
        	username: {
                required: true,
                minlength: 2
            },
            password: {
                required: true,
                minlength: 2
            }	
        },
        messages: {
        	username: {
                required: "用户名不能为空",
                minlength: "至少2个字符"
            },
            password: {
                required: "密码不能为空",
                minlength: "至少2个字符"
            }
        }
    });
    //修改用户输入校验
    $("#editUserForm").validate({
        rules: {
        	username: {
                required: true,
                minlength: 2
            },
            password: {
                required: true,
                minlength: 6
            }	
        },
        messages: {
        	username: {
                required: "用户名不能为空",
                minlength: "至少2个字符"
            },
            password: {
                required: "密码不能为空",
                minlength: "至少6个字符"
            }
        }
    });
    
    $('#btn-search-user').on('click', function () {
        $('#queryUserTable').bootstrapTable("refresh", {queryUserList: {pageNumber: 1}});
    });

    //添加
    $("#btn-search-add").click(function () {
    	//清除输入框数据
    	$("#username").val(""); 
		$("#password").val(""); 
    	//弹出模态框
		$("#userAddModal").modal({
			backdrop:"static"
		});
    });
    
    //点击保存
    $('#user_save_btn').on('click', function () {
        if (!$("#addUserForm").validate().form()) {
            return;
        }
        if(checks($("#username").val())){
			toastr.error("用户名含有非法字符，请重新输入!","错误提示：");
        	return;
        }
        $.post("${contextPath}/manuser/adduser",
            {
                username: $("#username").val(),
                password: $("#password").val(),
                realname: $("#realname").val()
            },
            function (data) {
                BootstrapDialog.show({
                    title: '操作结果',
                    message: data.errorMsg,
                    buttons: [{
                        label: '确认',
                        cssClass: 'btn-primary',
                        action: function (dialogItself) {
                            dialogItself.close();
                        	$("#userAddModal").modal('hide');
					        $('#queryUserTable').bootstrapTable("refresh", {queryUserList: {pageNumber: 1}});
                        }
                    }]
                });
            }
        );
    });

    //删除
    $('#btn-search-del').on('click', function () {
        var rows = $('#queryUserTable').bootstrapTable('getSelections');
        if (rows.length == 0) {
            BootstrapDialog.alert({
                title: '警告',
                type: BootstrapDialog.TYPE_WARNING,   //增加类型
                message: '请选择一条数据'
            });
            return;
        }

        //确认
        BootstrapDialog.confirm({
            title: '确认',
            message: '你确定要删除?',
            btnCancelLabel:'取消',
            btnOKLabel:'确认',
            callback: function (result) {
                if (result) {
                    $.post("${contextPath}/manuser/delUser",
                        {
                            id: rows[0].id
                        }, function (data) {
                            BootstrapDialog.show({
                                title: '操作结果',
                                message: data.errorMsg,
                                buttons: [{
                                    label: '确认',
                                    cssClass: 'btn-primary',
                                    action: function (dialogItself) {
                                        dialogItself.close();
                                        loadPage('${contextPath}/manuser/queryuserpage');
                                    }
                                }]
                            });
                        });
                } else {
                    console.log("not delete!");
                }
            }
        });
    });

    //修改
    $("#btn-search-edit").on('click',function(){
        var rows = $('#queryUserTable').bootstrapTable('getSelections');
        if (rows.length == 0) {
            BootstrapDialog.alert({
                title: '警告',
                buttonLabel:'确认',
                type: BootstrapDialog.TYPE_WARNING,   //增加类型
                message: '请选择一条数据'
            });
            return;
        }
        //弹出模态框
		$("#userEditModal").modal({
			backdrop:"static"
		});
		//查出用户信息并显示
        getUser(rows[0].id);
    });
    
  //根据id查询用户信息
    function getUser(id){
    	$.ajax({
    		url:"${contextPath}/manuser/queryuserbyid/"+id,
    		type:"GET",
    		success:function(result){
    			var userData = result.extend.user;
    			$("#edit_id").val(userData.id);
    			$("#edit_username").val(userData.username);
    			$("#edit_password").val(userData.password);
    		}
    	});
    }
  
    //修改点击保存
    $('#user_edit_btn').on('click', function () {
    	if (!$("#editUserForm").validate().form()) {
            return;
        }
        $.post("${contextPath}/manuser/edituser",
            {
                id: $("#edit_id").val(),
                username: $("#edit_username").val(),
                password: $("#edit_password").val()
            },
            function (result) {
            	BootstrapDialog.show({
                    title: '操作结果',
                    message: result.errorMsg,
                    buttons: [{
                        label: '确认',
                        cssClass: 'btn-primary',
	                    action: function(dialogRef){
	                    	dialogRef.close();
	                    	$("#userEditModal").modal('hide');
			                $('#queryUserTable').bootstrapTable("refresh", {queryUserList: {pageNumber: 1}});
                      	}

                    }]
                });
            }
        );
    });

    //点击关闭，清空输入框内容
	function closeBtn(){
		$("#username").val(""); 
		$("#password").val(""); 
		$("#edit_password").val(""); 
		$("#edit_username").val(""); 
	}
    
</script>
</body>
</html>
