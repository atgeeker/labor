<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<script type="text/javascript">
		 $(".form_datetime").datetimepicker({
		 format: "yyyy-mm-dd",
		 autoclose: true,
		 todayBtn: true,
		 todayHighlight: true,
		 showMeridian: true,
		 pickerPosition: "bottom-left",
		 language: 'zh-CN',//中文，需要引用zh-CN.js包
		 startView: 2,//月视图
		 minView: 2//日期时间选择器所能够提供的最精确的时间选择视图
		 }); 
	</script>
</head>
<body>

<div class="row">
    <div class="col-md-12">
        <div class="panel panel-default">
            <div class="tab-content">
                <div class="panel panel-default">
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="icon-home"></i> 首页</a></li>
                        <li><a href="#">入职基本信息管理</a></li>
                    </ol>
                    <div role="form" id="search_form_mytask" class="form-horizontal" style="float: left;width:60%;">
                        <div id="simpleSearchLabel">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">姓名</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="s_eusername"
                                           name="s_eusername" placeholder="姓名">
                                </div>
                                <button id="btn-search-entry" class="btn btn-primary btn-sm"
                                        style="margin-left: 11%">
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
                    <table id="queryEntryTable"></table>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 入职添加的模态框 -->
<div class="modal fade" id="entryAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="closeBtn();"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">入职信息添加</h4>
      </div>
      <div class="modal-body">
        <form id="addEntryForm" data-parsley-validate class="form-horizontal form-label-left">
		  <div class="form-group">
              <label class="control-label col-md-3 col-sm-3 col-xs-12">姓名&nbsp;<span class="required">*</span>
              </label>
              <div class="col-md-8 col-sm-4 col-xs-12">
                  <input type="text" id="name" name="name" class="form-control col-md-7 col-xs-12" placeholder="姓名">
              </div>
          </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">工作岗位&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="post" name="post" class="form-control col-md-7 col-xs-12" placeholder="工作岗位">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">入职时间&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input class="form_datetime form-control" type="text" id="entrytime" name="entrytime" size="16" placeholder="请选择" readonly/>
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">试用期开始时间&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input class="form_datetime form-control" type="text" id="probationbegin" name="probationbegin" size="16" placeholder="请选择" readonly/>
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">试用期结束时间&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input class="form_datetime form-control" type="text" id="probationend" name="probationend" size="16" placeholder="请选择" readonly/>
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">合同开始时间&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input class="form_datetime form-control" type="text" id="contractbegin" name="contractbegin" size="16" placeholder="请选择" readonly/>
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">合同结束时间&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input class="form_datetime form-control" type="text" id="contractend" name="contractend" size="16" placeholder="请选择" readonly/>
	         </div>
	     </div>
	     <div class="form-group">
		    <label class="col-sm-3 control-label">所属用工单位</label>
		    <div class="col-sm-6">
		      <select class="form-control" name="orgname" id="orgname">
		      </select>
		    </div>
		  </div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="closeBtn();">关闭</button>
        <button type="button" class="btn btn-primary" id="entry_save_btn">保存</button>
      </div>
    </div>
  </div>
</div>

<!-- 入职修改的模态框 -->
<div class="modal fade" id="entryEditModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="closeBtn();"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">入职信息修改</h4>
      </div>
      <div class="modal-body">
        <form id="editEntryForm" data-parsley-validate class="form-horizontal form-label-left">
          <input type="hidden" id="edit_id" name="id" />
		  <div class="form-group">
              <label class="control-label col-md-3 col-sm-3 col-xs-12">姓名&nbsp;<span class="required">*</span>
              </label>
              <div class="col-md-8 col-sm-4 col-xs-12">
                  <input type="text" id="edit_name" name="name" class="form-control col-md-7 col-xs-12" readonly="readonly" />
              </div>
          </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">工作岗位&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="edit_post" name="post" class="form-control col-md-7 col-xs-12">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">入职时间&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input class="form_datetime form-control" type="text" id="edit_entrytime" name="entrytime" size="16" placeholder="请选择" readonly/>
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">试用期开始时间&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input class="form_datetime form-control" type="text" id="edit_probationbegin" name="probationbegin" size="16" placeholder="请选择" readonly/>
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">试用期结束时间&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input class="form_datetime form-control" type="text" id="edit_probationend" name="probationend" size="16" placeholder="请选择" readonly/>
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">合同开始时间&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input class="form_datetime form-control" type="text" id="edit_contractbegin" name="contractbegin" size="16" placeholder="请选择" readonly/>
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">合同结束时间&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input class="form_datetime form-control" type="text" id="edit_contractend" name="contractend" size="16" placeholder="请选择" readonly/>
	         </div>
	     </div>
	     <div class="form-group">
		    <label class="col-sm-3 control-label">所属用工单位</label>
		    <div class="col-sm-6">
		      <select class="form-control" name="orgname" id="edit_orgname">
		      </select>
		    </div>
		  </div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="closeBtn();">关闭</button>
        <button type="button" class="btn btn-primary" id="entry_edit_btn">保存</button>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $('#queryEntryTable').bootstrapTable(
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
                url: '${contextPath}/manentry/queryentry',
                columns: [
                    {
                        radio: true
                    },
                    {
                        field: 'id',
                        title: '编号'
                    },
                    {
                        field: 'name',
                        title: '姓名'
                    }, {
                        field: 'post',
                        title: '工作岗位'
                    }, {
                        field: 'entrytime',
                        title: '入职时间',
                        formatter : function (value) {
	                    	return getMyDate(value);
	                    }
                    }, {
                        field: 'probationbegin',
                        title: '试用期开始时间',
                        formatter : function (value) {
	                    	return getMyDate(value);
	                    }
                    }, {
                        field: 'probationend',
                        title: '试用期结束时间',
                        formatter : function (value) {
	                    	return getMyDate(value);
	                    }
                    }, {
                        field: 'contractbegin',
                        title: '合同开始时间',
                        formatter : function (value) {
	                    	return getMyDate(value);
	                    }
                    }, {
                        field: 'contractend',
                        title: '合同结束时间',
                        formatter : function (value) {
	                    	return getMyDate(value);
	                    }
                    },{
                    	field: 'orgname',
                    	title: '所属用功单位' 
                    }],
            }
        );
    });
    
    //入职输入校验
    $("#addEntryForm").validate({
        rules: {
            name: {
                required: true,
                minlength: 1
            },
            post: {
                required: true,
                minlength: 2
            },
            entrytime: {
            	required: true,
                minlength: 6
            },
            probationbegin: {
            	required: true,
                minlength: 6
            },
            probationend: {
            	required: true,
                minlength: 6
            },
            contractbegin: {
            	required: true,
                minlength: 6
            },
            contractend: {
            	required: true,
                minlength: 6
            }
        },
        messages: {
            name: {
                required: "姓名不能为空",
                minlength: "至少1个字符"
            },
            post: {
                required: "工作岗位不能为空",
                minlength: "至少2个字符"
            },
            entrytime: {
                required: "入职时间不能为空",
                minlength: "至少6个字符"
            },
            probationbegin: {
                required: "试用期开始时间不能为空",
                minlength: "至少6个字符"
            },
            probationend: {
                required: "试用期结束时间不能为空",
                minlength: "至少6个字符"
            },
            contractbegin: {
                required: "合同开始时间不能为空",
                minlength: "至少6个字符"
            },
            contractend: {
                required: "合同结束时间不能为空",
                minlength: "至少6个字符"
            }
        }
    });
    
    //入职输入校验
    $("#editEntryForm").validate({
        rules: {
            name: {
                required: true,
                minlength: 1
            },
            post: {
                required: true,
                minlength: 2
            },
            entrytime: {
            	required: true,
                minlength: 6
            },
            probationbegin: {
            	required: true,
                minlength: 6
            },
            probationend: {
            	required: true,
                minlength: 6
            },
            contractbegin: {
            	required: true,
                minlength: 6
            },
            contractend: {
            	required: true,
                minlength: 6
            }
        },
        messages: {
            name: {
                required: "姓名不能为空",
                minlength: "至少1个字符"
            },
            post: {
                required: "工作岗位不能为空",
                minlength: "至少2个字符"
            },
            entrytime: {
                required: "入职时间不能为空",
                minlength: "至少6个字符"
            },
            probationbegin: {
                required: "试用期开始时间不能为空",
                minlength: "至少6个字符"
            },
            probationend: {
                required: "试用期结束时间不能为空",
                minlength: "至少6个字符"
            },
            contractbegin: {
                required: "合同开始时间不能为空",
                minlength: "至少6个字符"
            },
            contractend: {
                required: "合同结束时间不能为空",
                minlength: "至少6个字符"
            }
        }
    });

    //时间格式化
    function getMyDate(str){  
        var oDate = new Date(str);  
        oYear = oDate.getFullYear();  
        oMonth = oDate.getMonth()+1;  
        oDay = oDate.getDate(); 
        oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) ;//最后拼接时间  
        return oTime;  
    };  
    //补0操作  
    function getzf(num){  
        if(parseInt(num) < 10){  
            num = '0'+num;  
        }  
        return num;  
    }
    
    //模糊查询
    $('#btn-search-entry').on('click', function () {
        $('#queryEntryTable').bootstrapTable("refresh", {queryEntryList: {pageNumber: 1}});
    });

    //添加
    $("#btn-search-add").click(function () {
    	//发送ajax请求，查出用工单位信息，显示在下拉列表中
		getOrganizations();
    	//弹出模态框
		$("#entryAddModal").modal({
			backdrop:"static"
		});
		//清除表单数据
		$("#name").val("");
		$("#post").val("");
		$("#entrytime").val("");
		$("#probationbegin").val("");
		$("#probationend").val("");
		$("#contractbegin").val("");
		$("#contractend").val("");
		$("#orgname").val("");
    });

    //添加点击保存
	$("#entry_save_btn").click(function(){
		//校验表单数据
		if (!$("#entryAddModal form").validate().form()) {
            return;
        };
        if(checks($("#name").val())){
			toastr.error("姓名含有非法字符，请重新输入!","错误提示：");
        	return;
        }
        if(checks($("#post").val())){
			toastr.error("工作岗位含有非法字符，请重新输入!","错误提示：");
        	return;
        }
        if ($.trim($("#orgname").val()).length<1) {
        	alert("所属用工单位为空！");
            return;
        };
		$.post("${contextPath}/manentry/addentry",
	            {
	                name: $("#name").val(),
	                post: $("#post").val(),
	                entrytime: $("#entrytime").val(),
	                probationbegin: $("#probationbegin").val(),
	                probationend: $("#probationend").val(),
	                contractbegin: $("#contractbegin").val(),
	                contractend: $("#contractend").val(),
	                orgname: $("#orgname").val()
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
		                    	$("#entryAddModal").modal('hide');
		                    	$("#orgname").empty(); 
				                $('#queryEntryTable').bootstrapTable("refresh", {querySecurityList: {pageNumber: 1}});
	                      	}
	                    }]
	                });
	            }
		);
		
	});
    
    //查出用功单位信息并显示在下拉列表中
    function getOrganizations(){
		$.ajax({
			url:"${contextPath}/manorg/queryOrgs",
			type:"GET",
			success:function(result){
				//显示部门信息在下拉列表中
				$.each(result.extend.orgList,function(){
					var optionEle = $("<option></option>").append(this.name).attr("value",this.name);
					optionEle.appendTo("#orgname");
				});
			}
		});
    }
    
    
    //删除
    $('#btn-search-del').on('click', function () {
        var rows = $('#queryEntryTable').bootstrapTable('getSelections');
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
                    $.post("${contextPath}/manentry/delentry",
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
                                        loadPage('${contextPath}/manentry/queryentrypage');
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
        var rows = $('#queryEntryTable').bootstrapTable('getSelections');
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
		$("#entryEditModal").modal({
			backdrop:"static"
		});
		//查出入职信息并显示
        getEntry(rows[0].id);
		//查出用工单位信息并显示
        $.ajax({
			url:"${contextPath}/manorg/queryOrgs",
			type:"GET",
			success:function(result){
				var editOrgname = $("#edit_orgname").val();
				var i = 0;
				var length = result.extend.orgList.length;
				//显示部门信息在下拉列表中
				$.each(result.extend.orgList,function(){
					if(editOrgname != this.name && i <= length){
						var optionEle = $("<option></option>").append(this.name).attr("value",this.name);
						optionEle.appendTo("#edit_orgname");
					}
					i++;
				});
			}
		});
    });

    //根据id查询入职信息
    function getEntry(id){
    	$.ajax({
    		url:"${contextPath}/manentry/queryentrybyid/"+id,
    		type:"GET",
    		success:function(result){
    		console.log(result);
    			var entryData = result.extend.entry;
    			var optionValue = $("<option></option>").append(entryData.orgname).attr("value",entryData.orgname);
    			optionValue.appendTo("#entryEditModal select");
    			$("#edit_id").val(entryData.id);
    			$("#edit_name").val(entryData.name);
    			$("#edit_post").val(entryData.post);
    			$("#edit_entrytime").val(getMyDate(entryData.entrytime));
    			$("#edit_probationbegin").val(getMyDate(entryData.probationbegin));
    			$("#edit_probationend").val(getMyDate(entryData.probationend));
    			$("#edit_contractbegin").val(getMyDate(entryData.contractbegin));
    			$("#edit_contractend").val(getMyDate(entryData.contractend));
    		}
    	});
    }

    //修改点击保存
    $('#entry_edit_btn').on('click', function () {
    	//校验表单数据
		if (!$("#editEntryForm").validate().form()) {
            return;
        };
    	if(checks($("#edit_name").val())){
			toastr.error("姓名含有非法字符，请重新输入!","错误提示：");
        	return;
        }
        if(checks($("#edit_post").val())){
			toastr.error("工作岗位含有非法字符，请重新输入!","错误提示：");
        	return;
        }
        if ($.trim($("#edit_orgname").val()).length<1) {
        	alert("所属用工单位为空！")
            return;
        };
        $.post("${contextPath}/manentry/editentry",
            {
                id: $("#edit_id").val(),
                name: $("#edit_name").val(),
                post: $("#edit_post").val(),
                entrytime: $("#edit_entrytime").val(),
                probationbegin: $("#edit_probationbegin").val(),
                probationend: $("#edit_probationend").val(),
                contractbegin: $("#edit_contractbegin").val(),
                contractend: $("#edit_contractend").val(),
                orgname: $("#edit_orgname").val()
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
	                    	$("#entryEditModal").modal('hide');
	                    	//修改点击关闭，清空用工单位下拉选项
	                    	$("#edit_orgname").empty(); 
			                $('#queryEntryTable').bootstrapTable("refresh", {querySecurityList: {pageNumber: 1}});
                      	}
                    }]
                });
            }
        );
    });
    
    //修改点击关闭，清空用工单位下拉选项
	function closeBtn(){
		$("#edit_orgname").empty(); 
		$("#orgname").empty(); 
	}

</script>
</body>
</html>
