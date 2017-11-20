<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
</head>
<body>
<div class="row">
    <div class="col-md-12">
        <div class="panel panel-default">
            <div class="tab-content">
                <div class="panel panel-default">
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="icon-home"></i> 首页</a></li>
                        <li><a href="#">用工单位管理</a></li>
                    </ol>
                    <div role="form" id="search_form_mytask" class="form-horizontal" style="float: left;width:60%;">
                        <div id="simpleSearchLabel">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">单位名称</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="s_eusername"
                                           name="s_eusername" placeholder="单位名称">
                                </div>
                                <button id="btn-search-query" class="btn btn-primary btn-sm"
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
                            </div>
                        </div>
                    </div>
                    <table id="queryOrgTable"></table>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 用工单位添加 -->
<div class="modal fade" id="orgAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">用工单位添加</h4>
      </div>
      <div class="modal-body">
        <form id="addOrgForm" data-parsley-validate class="form-horizontal form-label-left">
		  <div class="form-group">
              <label class="control-label col-md-3 col-sm-3 col-xs-12">单位名称&nbsp;<span class="required">*</span>
              </label>
              <div class="col-md-8 col-sm-4 col-xs-12">
                  <input type="text" id="name" name="name" class="form-control col-md-7 col-xs-12" placeholder="单位名称">
              </div>
          </div>
		  <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">单位类型&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="type" name="type" class="form-control col-md-7 col-xs-12" placeholder="单位类型">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">负责人&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="manager" name="manager" class="form-control col-md-7 col-xs-12" placeholder="负责人">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">联系电话&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="tel" name="tel" class="form-control col-md-7 col-xs-12" placeholder="联系电话">
	         </div>
	     </div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="org_save_btn">保存</button>
      </div>
    </div>
  </div>
</div>

<!-- 用工单位修改 -->
<div class="modal fade" id="orgEditModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">用工单位修改</h4>
      </div>
      <div class="modal-body">
        <form id="editOrgForm" data-parsley-validate class="form-horizontal form-label-left">
		  <input type="hidden" id="edit_id" name="id" />
		  <div class="form-group">
              <label class="control-label col-md-3 col-sm-3 col-xs-12">单位名称&nbsp;<span class="required">*</span>
              </label>
              <div class="col-md-8 col-sm-4 col-xs-12">
                  <input type="text" id="edit_name" name="name" class="form-control col-md-7 col-xs-12" readonly="readonly"/>
              </div>
          </div>
		  <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">单位类型&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="edit_type" name="type" class="form-control col-md-7 col-xs-12">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">负责人&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="edit_manager" name="manager" class="form-control col-md-7 col-xs-12">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">联系电话&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="edit_tel" name="tel" class="form-control col-md-7 col-xs-12">
	         </div>
	     </div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="org_edit_btn">保存</button>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $('#queryOrgTable').bootstrapTable(
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
                    params.name = $("#s_eusername").val();
                    return params;
                },
                method: 'POST',
                contentType: "application/x-www-form-urlencoded",
                url: '${contextPath}/manorg/queryorg',
                columns: [
                    {
                        radio: true
                    },
                    {
                        field: 'id',
                        title: 'ID'
                    },
                    {
                        field: 'name',
                        title: '单位名称'
                    }, {
                        field: 'type',
                        title: '单位类型'
                    }, {
                        field: 'manager',
                        title: '负责人'
                    }, {
                        field: 'tel',
                        title: '联系电话'
                    }],
            }
        );
	    //用工单位添加校验
	    $("#addOrgForm").validate({
	        rules: {
	            name: {
	                required: true,
	                minlength: 1
	            },
	            type: {
	                required: true,
	                minlength: 1
	            },
	            manager: {
	                required: true,
	                minlength: 1
	            },
	            tel: {
	                required: true,
	                minlength: 1
	            }
	        },
	        messages: {
	            name: {
	                required: "单位名称必填",
	                minlength: "至少1个字符"
	            },
	            type: {
	                required: "单位类型必填",
	                minlength: "至少1个字符"
	            },
	            manager: {
	                required: "负责人必填",
	                minlength: "至少1个字符"
	            },
	            tel: {
	                required: "联系电话必填",
	                minlength: "至少1个字符"
	            }
	        }
	    });
	    
	    //用工单位修改校验
	    $("#editOrgForm").validate({
	        rules: {
	            name: {
	                required: true,
	                minlength: 1
	            },
	            type: {
	                required: true,
	                minlength: 1
	            },
	            manager: {
	                required: true,
	                minlength: 1
	            },
	            tel: {
	                required: true,
	                minlength: 1
	            }
	        },
	        messages: {
	            name: {
	                required: "单位名称必填",
	                minlength: "至少1个字符"
	            },
	            type: {
	                required: "单位类型必填",
	                minlength: "至少1个字符"
	            },
	            manager: {
	                required: "负责人必填",
	                minlength: "至少1个字符"
	            },
	            tel: {
	                required: "联系电话必填",
	                minlength: "至少1个字符"
	            }
	        }
	    });
	    
    });

    //模糊查询
    $('#btn-search-query').on('click', function () {
        $('#queryOrgTable').bootstrapTable("refresh", {queryOrgList: {pageNumber: 1}});
    });

    //显示校验结果的提示信息
	function show_validate_msg(ele,status,msg){
		//清除当前元素的校验状态
		$(ele).parent().removeClass("has-success has-error");
		$(ele).next("span").text("");
		if("success"==status){
			$(ele).parent().addClass("has-success");
			$(ele).next("span").text(msg);
		}else if("error" == status){
			$(ele).parent().addClass("has-error");
			$(ele).next("span").text(msg);
		}
	}
    
    //添加
    $("#btn-search-add").click(function () {
    	
    	//弹出模态框
		$("#orgAddModal").modal({
			backdrop:"static"
		});
    	//清除表单数据
		$("#name").val("");
		$("#type").val("");
		$("#manager").val("");
		$("#tel").val("");
    });
	
	//添加点击保存
    $('#org_save_btn').on('click', function () {
        if (!$("#addOrgForm").validate().form()) {
            return;
        };
        if(checks($("#name").val())){
			toastr.error("单位名称含有非法字符，请重新输入!","错误提示：");
        	return;
        }
        if(checks($("#type").val())){
			toastr.error("单位类型含有非法字符，请重新输入!","错误提示：");
        	return;
        }
        if(checks($("#manager").val())){
			toastr.error("负责人含有非法字符，请重新输入!","错误提示：");
        	return;
        }
        if(checks($("#tel").val())){
			toastr.error("联系电话含有非法字符，请重新输入!","错误提示：");
        	return;
        }
        $.post("${contextPath}/manorg/addorg",
            {
                name: $("#name").val(),
                type: $("#type").val(),
                manager: $("#manager").val(),
                tel: $("#tel").val()
            },
            function (data) {
                BootstrapDialog.show({
                    title: '操作结果',
                    message: data.errorMsg,
                    buttons: [{
                        label: '确认',
                        cssClass: 'btn-primary',
	                    action: function(dialogRef){
	                        dialogRef.close();
	                    	$("#orgAddModal").modal('hide');
			                $('#queryOrgTable').bootstrapTable("refresh", {queryOrgList: {pageNumber: 1}});
                      	}

                    }]
                });
            }
        );
    });
	
    //修改
    $("#btn-search-edit").on('click',function(){
        var rows = $('#queryOrgTable').bootstrapTable('getSelections');
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
		$("#orgEditModal").modal({
			backdrop:"static"
		});
        //查出用工单位信息并显示
        getOrg(rows[0].id);
    });
	
    //根据id查询用工单位信息
    function getOrg(id){
    	$.ajax({
    		url:"${contextPath}/manorg/queryorgbyid/"+id,
    		type:"GET",
    		success:function(result){
    			var orgData = result.extend.org;
    			$("#edit_id").val(orgData.id);
    			$("#edit_name").val(orgData.name);
    			$("#edit_type").val(orgData.type);
    			$("#edit_manager").val(orgData.manager);
    			$("#edit_tel").val(orgData.tel);
    		}
    	});
    }
    
	//修改点击保存
    $('#org_edit_btn').on('click', function () {
    	if (!$("#editOrgForm").validate().form()) {
            return;
        };
        if(checks($("#edit_name").val())){
			toastr.error("单位名称含有非法字符，请重新输入!","错误提示：");
        	return;
        }
        if(checks($("#edit_type").val())){
			toastr.error("单位类型含有非法字符，请重新输入!","错误提示：");
        	return;
        }
        if(checks($("#edit_manager").val())){
			toastr.error("负责人含有非法字符，请重新输入!","错误提示：");
        	return;
        }
        if(checks($("#edit_tel").val())){
			toastr.error("联系电话含有非法字符，请重新输入!","错误提示：");
        	return;
        }
        $.post("${contextPath}/manorg/editorg",
            {
                id: $("#edit_id").val(),
                name: $("#edit_name").val(),
                type: $("#edit_type").val(),
                manager: $("#edit_manager").val(),
                tel: $("#edit_tel").val()
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
	                    	$("#orgEditModal").modal('hide');
			                $('#queryOrgTable').bootstrapTable("refresh", {queryOrgList: {pageNumber: 1}});
                      	}

                    }]
                });
            }
        );
    });
    
    //删除
    $('#btn-search-del').on('click', function () {
        var rows = $('#queryOrgTable').bootstrapTable('getSelections');
        if (rows.length == 0) {
            BootstrapDialog.alert({
                title: '警告',
                buttonLabel:'确认',
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
                    $.post("${contextPath}/manorg/delOrg",
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
                                        loadPage('${contextPath}/manorg/queryorgpage');
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

    //清空表单样式及内容
	function reset_form(ele){
		$(ele)[0].reset();
		//清空表单样式
		$(ele).find("*").removeClass("has-error has-success");
		$(ele).find(".help-block").text("");
	}

</script>
</body>
</html>
