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
                        <li><a href="#">社保管理</a></li>
                    </ol>
                    <div role="form" id="search_form_mytask" class="form-horizontal" style="float: left;width:60%;">
                        <div id="simpleSearchLabel">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">姓名</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="s_eusername"
                                           name="s_eusername" placeholder="姓名">
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
                    <table id="querySecurityTable"></table>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 社保添加 -->
<div class="modal fade" id="securityAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">社保信息添加</h4>
      </div>
      <div class="modal-body">
        <form id="addSecurityForm" data-parsley-validate class="form-horizontal form-label-left">
		  <div class="form-group">
              <label class="control-label col-md-3 col-sm-3 col-xs-12">姓名&nbsp;<span class="required">*</span>
              </label>
              <div class="col-md-8 col-sm-4 col-xs-12">
                  <input type="text" id="name" name="name" class="form-control col-md-7 col-xs-12" placeholder="姓名">
              </div>
          </div>
		  <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">参保时间&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input class="form_datetime form-control" type="text" id="insuredtime" name="insuredtime" size="16" placeholder="请选择" readonly/>
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">身份证号码&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="idcardno" name="idcardno" class="form-control col-md-7 col-xs-12" placeholder="身份证号码">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">缴费基数&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="base" name="base" class="form-control col-md-7 col-xs-12" placeholder="缴费基数">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">养老保险&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="endowment" name="endowment" class="form-control col-md-7 col-xs-12" placeholder="养老保险">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">失业保险&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="nemployment" name="nemployment" class="form-control col-md-7 col-xs-12" placeholder="失业保险">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">生育保险&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="maternity" name="maternity" class="form-control col-md-7 col-xs-12" placeholder="生育保险">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">工伤保险&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="injury" name="injury" class="form-control col-md-7 col-xs-12" placeholder="工伤保险">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">医疗保险&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="medical" name="medical" class="form-control col-md-7 col-xs-12" placeholder="医疗保险">
	         </div>
	     </div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="security_save_btn">保存</button>
      </div>
    </div>
  </div>
</div>

<!-- 社保修改 -->
<div class="modal fade" id="securityEditModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">社保信息修改</h4>
      </div>
      <div class="modal-body">
        <form id="editSecurityForm" data-parsley-validate class="form-horizontal form-label-left">
		  <input type="hidden" id="edit_id" name="id" />
		  <div class="form-group">
              <label class="control-label col-md-3 col-sm-3 col-xs-12">姓名&nbsp;<span class="required">*</span>
              </label>
              <div class="col-md-8 col-sm-4 col-xs-12">
                  <input type="text" id="edit_name" name="name" class="form-control col-md-7 col-xs-12" readonly="readonly"/>
              </div>
          </div>
		  <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">参保时间&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="edit_insuredtime" name="insuredtime" size="16" class="form_datetime form-control" placeholder="请选择" readonly/>
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">身份证号码&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="edit_idcardno" name="idcardno" class="form-control col-md-7 col-xs-12">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">缴费基数&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="edit_base" name="base" class="form-control col-md-7 col-xs-12">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">养老保险&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="edit_endowment" name="endowment" class="form-control col-md-7 col-xs-12">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">失业保险&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="edit_nemployment" name="nemployment" class="form-control col-md-7 col-xs-12">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">生育保险&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="edit_maternity" name="maternity" class="form-control col-md-7 col-xs-12">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">工伤保险&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="edit_injury" name="injury" class="form-control col-md-7 col-xs-12">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">医疗保险&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="edit_medical" name="medical" class="form-control col-md-7 col-xs-12">
	         </div>
	     </div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="security_edit_btn">保存</button>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $('#querySecurityTable').bootstrapTable(
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
                url: '${contextPath}/mansecurity/querysecurity',
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
                        title: '姓名'
                    }, {
                        field: 'insuredtime',
                        title: '参保时间',
	                    formatter : function (value) {
	                    	return getMyDate(value);
	                    }
                    }, {
                        field: 'idcardno',
                        title: '身份证号码'
                    }, {
                        field: 'base',
                        title: '缴费基数'
                    }, {
                        field: 'endowment',
                        title: '养老保险'
                    }, {
                        field: 'nemployment',
                        title: '失业保险'
                    }, {
                        field: 'maternity',
                        title: '生育保险'
                    }, {
                        field: 'injury',
                        title: '工伤保险'
                    }, {
                        field: 'medical',
                        title: '医疗保险'
                    }, {
                        field: 'securitytotal',
                        title: '保险合计'
                    }],
            }
        );
        
	    //社保添加校验
	    $("#addSecurityForm").validate({
	        rules: {
	        	name: {
	                required: true,
	                minlength: 1
	            },insuredtime: {
	                required: true,
	                minlength: 4
	            },idcardno: {
	            	required: true,
	                minlength: 18
	            },base: {
	            	required: true,
	                minlength: 1
	            },endowment: {
	            	required: true,
	                minlength: 1
	            },nemployment: {
	            	required: true,
	                minlength: 1
	            },maternity: {
	            	required: true,
	                minlength: 1
	            },injury: {
	            	required: true,
	                minlength: 1
	            },medical: {
	            	required: true,
	                minlength: 1
	            }
	        },
	        messages: {
	            name: {
	                required: "姓名不能为空",
	                minlength: "至少1个字符"
	            },
	            insuredtime: {
	            	required: "参保时间不能为空",
	                minlength: "至少4个字符"
	            },
	            idcardno: {
	            	required: "身份证号码不能为空",
	                minlength: "至少18个字符"
	            },
	            base: {
	            	required: "缴费基数不能为空",
	            	minlength: "至少1个字符"
	            },
	            endowment: {
	                required: "养老保险不能为空",
	                minlength: "至少1个字符"
	            },
	            nemployment: {
	                required: "失业保险不能为空",
	                minlength: "至少1个字符"
	            },
	            maternity: {
	                required: "生育保险不能为空",
	                minlength: "至少1个字符"
	            },
	            injury: {
	                required: "工伤保险不能为空",
	                minlength: "至少1个字符"
	            },
	            medical: {
	                required: "医疗保险不能为空",
	                minlength: "至少1个字符"
	            }
	        }
	    });
	    
	    //社保修改校验
	    $("#editSecurityForm").validate({
	        rules: {
	        	name: {
	                required: true,
	                minlength: 1
	            },insuredtime: {
	                required: true,
	                minlength: 4
	            },idcardno: {
	            	required: true,
	                minlength: 18
	            },base: {
	            	required: true,
	                minlength: 1
	            },endowment: {
	            	required: true,
	                minlength: 1
	            },nemployment: {
	            	required: true,
	                minlength: 1
	            },maternity: {
	            	required: true,
	                minlength: 1
	            },injury: {
	            	required: true,
	                minlength: 1
	            },medical: {
	            	required: true,
	                minlength: 1
	            }
	        },
	        messages: {
	            name: {
	                required: "姓名不能为空",
	                minlength: "至少1个字符"
	            },
	            insuredtime: {
	            	required: "参保时间不能为空",
	                minlength: "至少4个字符"
	            },
	            idcardno: {
	            	required: "身份证号码不能为空",
	                minlength: "至少18个字符"
	            },
	            base: {
	            	required: "缴费基数不能为空",
	            	minlength: "至少1个字符"
	            },
	            endowment: {
	                required: "养老保险不能为空",
	                minlength: "至少1个字符"
	            },
	            nemployment: {
	                required: "失业保险不能为空",
	                minlength: "至少1个字符"
	            },
	            maternity: {
	                required: "生育保险不能为空",
	                minlength: "至少1个字符"
	            },
	            injury: {
	                required: "工伤保险不能为空",
	                minlength: "至少1个字符"
	            },
	            medical: {
	                required: "医疗保险不能为空",
	                minlength: "至少1个字符"
	            }
	        }
	    });
	    
    });

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
    $('#btn-search-query').on('click', function () {
        $('#querySecurityTable').bootstrapTable("refresh", {querySecurityList: {pageNumber: 1}});
    });

    //添加
    $("#btn-search-add").click(function () {
    	//弹出模态框
		$("#securityAddModal").modal({
			backdrop:"static"
		});
    	//清除表单数据
		$("#name").val("");
		$("#insuredtime").val("");
		$("#idcardno").val("");
		$("#base").val("");
		$("#endowment").val("");
		$("#nemployment").val("");
		$("#maternity").val("");
		$("#injury").val("");
		$("#medical").val("");
    });
	
	//添加点击保存
    $('#security_save_btn').on('click', function () {
        if (!$("#addSecurityForm").validate().form()) {
            return;
        };
    	if(checks($("#name").val())){
			toastr.error("姓名含有非法字符，请重新输入!","错误提示：");
        	return;
        }
    	if(checks($("#idcardno").val())){
			toastr.error("身份证号码含有非法字符，请重新输入!","错误提示：");
        	return;
        }
    	if($("#idcardno").val().length>18){
			toastr.error("身份证号码超过18位，请重新输入!","错误提示：");
        	return;
        }
    	if(checksDecimal($("#base").val())){
			toastr.error("缴费基数含有非法字符，请重新输入!","错误提示：");
        	return;
        }
    	if(isNaN($("#base").val())){
			toastr.error("缴费基数是非法数字，请重新输入!","错误提示：");
        	return;
        }
    	if(checksDecimal($("#endowment").val())){
			toastr.error("养老保险含有非法字符，请重新输入!","错误提示：");
        	return;
        }
        if(isNaN($("#endowment").val())){
			toastr.error("养老保险是非法数字，请重新输入!","错误提示：");
        	return;
        }
    	if(checksDecimal($("#nemployment").val())){
			toastr.error("失业保险含有非法字符，请重新输入!","错误提示：");
        	return;
        }
    	 if(isNaN($("#nemployment").val())){
 			toastr.error("失业保险是非法数字，请重新输入!","错误提示：");
         	return;
         }
    	if(checksDecimal($("#maternity").val())){
			toastr.error("生育保险含有非法字符，请重新输入!","错误提示：");
        	return;
        }
    	if(isNaN($("#maternity").val())){
 			toastr.error("生育保险是非法数字，请重新输入!","错误提示：");
         	return;
         }
    	if(checksDecimal($("#injury").val())){
			toastr.error("工伤保险含有非法字符，请重新输入!","错误提示：");
        	return;
        }
    	if(isNaN($("#injury").val())){
 			toastr.error("工伤保险是非法数字，请重新输入!","错误提示：");
         	return;
         }
    	if(checksDecimal($("#medical").val())){
			toastr.error("医疗保险含有非法字符，请重新输入!","错误提示：");
        	return;
        }
    	if(isNaN($("#medical").val())){
 			toastr.error("医疗保险是非法数字，请重新输入!","错误提示：");
         	return;
         }
        $.post("${contextPath}/mansecurity/addsecurity",
            {
                name: $("#name").val(),
                insuredtime: $("#insuredtime").val(),
                idcardno: $("#idcardno").val(),
                base: $("#base").val(),
                endowment: $("#endowment").val(),
                nemployment: $("#nemployment").val(),
                maternity: $("#maternity").val(),
                injury: $("#injury").val(),
                medical: $("#medical").val(),
                securitytotal:$("#endowment").val()*1+$("#nemployment").val()*1+$("#maternity").val()*1+$("#injury").val()*1+$("#medical").val()*1
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
	                    	$("#securityAddModal").modal('hide');
			                $('#querySecurityTable').bootstrapTable("refresh", {querySecurityList: {pageNumber: 1}});
                      	}

                    }]
                });
            }
        );
    });
	
    //修改
    $("#btn-search-edit").on('click',function(){
        var rows = $('#querySecurityTable').bootstrapTable('getSelections');
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
		$("#securityEditModal").modal({
			backdrop:"static"
		});
        //查出社保信息并显示
        getSecurity(rows[0].id);
    });
	
    //根据id查询社保信息
    function getSecurity(id){
    	$.ajax({
    		url:"${contextPath}/mansecurity/querysecuritybyid/"+id,
    		type:"GET",
    		success:function(result){
    	console.log(result);
    			var securityData = result.extend.security;
    			$("#edit_id").val(securityData.id);
    			$("#edit_name").val(securityData.name);
    			$("#edit_insuredtime").val(getMyDate(securityData.insuredtime));
    			$("#edit_idcardno").val(securityData.idcardno);
    			$("#edit_base").val(securityData.base);
    			$("#edit_endowment").val(securityData.endowment);
    			$("#edit_nemployment").val(securityData.nemployment);
    			$("#edit_maternity").val(securityData.maternity);
    			$("#edit_injury").val(securityData.injury);
    			$("#edit_medical").val(securityData.medical);
    		}
    	});
    }
    
	//修改点击保存
    $('#security_edit_btn').on('click', function () {
    	if (!$("#editSecurityForm").validate().form()) {
            return;
        };
    	if(checks($("#edit_name").val())){
			toastr.error("姓名含有非法字符，请重新输入!","错误提示：");
        	return;
        }
    	if(checks($("#edit_idcardno").val())){
			toastr.error("身份证号码含有非法字符，请重新输入!","错误提示：");
        	return;
        }
    	if($("#edit_idcardno").val().length>18){
			toastr.error("身份证号码超过18位，请重新输入!","错误提示：");
        	return;
        }
    	if(checksDecimal($("#edit_base").val())){
			toastr.error("缴费基数含有非法字符，请重新输入!","错误提示：");
        	return;
        }
    	if(isNaN($("#edit_base").val())){
 			toastr.error("缴费基数是非法数字，请重新输入!","错误提示：");
         	return;
         }
    	if(checksDecimal($("#edit_endowment").val())){
  			toastr.error("养老保险含有非法字符，请重新输入!","错误提示：");
          	return;
          }
         if(isNaN($("#edit_endowment").val())){
 			toastr.error("养老保险是非法数字，请重新输入!","错误提示：");
         	return;
         }
         if(checksDecimal($("#edit_nemployment").val())){
  			toastr.error("失业保险含有非法字符，请重新输入!","错误提示：");
          	return;
          }
     	 if(isNaN($("#edit_nemployment").val())){
  			toastr.error("失业保险是非法数字，请重新输入!","错误提示：");
          	return;
          }
     	if(checksDecimal($("#edit_maternity").val())){
 			toastr.error("生育保险含有非法字符，请重新输入!","错误提示：");
         	return;
         }
     	if(isNaN($("#edit_maternity").val())){
  			toastr.error("生育保险是非法数字，请重新输入!","错误提示：");
          	return;
          }
     	if(checksDecimal($("#edit_injury").val())){
 			toastr.error("工伤保险含有非法字符，请重新输入!","错误提示：");
         	return;
         }
     	if(isNaN($("#edit_injury").val())){
  			toastr.error("工伤保险是非法数字，请重新输入!","错误提示：");
          	return;
          }
     	if(checksDecimal($("#edit_medical").val())){
 			toastr.error("医疗保险含有非法字符，请重新输入!","错误提示：");
         	return;
         }
     	if(isNaN($("#edit_medical").val())){
  			toastr.error("医疗保险是非法数字，请重新输入!","错误提示：");
          	return;
          }
        $.post("${contextPath}/mansecurity/editsecurity",
            {
                id: $("#edit_id").val(),
                name: $("#edit_name").val(),
                insuredtime: $("#edit_insuredtime").val(),
                idcardno: $("#edit_idcardno").val(),
                base: $("#edit_base").val(),
                endowment: $("#edit_endowment").val(),
                nemployment: $("#edit_nemployment").val(),
                maternity: $("#edit_maternity").val(),
                injury: $("#edit_injury").val(),
                medical: $("#edit_medical").val(),
                securitytotal:$("#edit_endowment").val()*1+$("#edit_nemployment").val()*1+$("#edit_maternity").val()*1+$("#edit_injury").val()*1+$("#edit_medical").val()*1
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
	                    	$("#securityEditModal").modal('hide');
			                $('#querySecurityTable').bootstrapTable("refresh", {querySecurityList: {pageNumber: 1}});
                      	}

                    }]
                });
            }
        );
    });
    
    //删除
    $('#btn-search-del').on('click', function () {
        var rows = $('#querySecurityTable').bootstrapTable('getSelections');
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
                    $.post("${contextPath}/mansecurity/delsecurity",
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
                                        loadPage('${contextPath}/mansecurity/querysecuritypage');
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

</script>
</body>
</html>
