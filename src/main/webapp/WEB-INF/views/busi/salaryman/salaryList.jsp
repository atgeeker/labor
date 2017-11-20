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
                        <li><a href="#">工资管理</a></li>
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
                    <table id="querySalaryTable"></table>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 工资添加 -->
<div class="modal fade" id="salaryAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">工资信息添加</h4>
      </div>
      <div class="modal-body">
        <form id="addSalaryForm" data-parsley-validate class="form-horizontal form-label-left">
		  <div class="form-group">
              <label class="control-label col-md-3 col-sm-3 col-xs-12">姓名&nbsp;<span class="required">*</span>
              </label>
              <div class="col-md-8 col-sm-4 col-xs-12">
                  <input type="text" id="name" name="name" class="form-control col-md-7 col-xs-12" placeholder="姓名">
              </div>
          </div>
		  <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">基本工资&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="base" name="base" class="form-control col-md-7 col-xs-12" placeholder="基本工资">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">绩效&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="achievements" name="achievements" class="form-control col-md-7 col-xs-12" placeholder="绩效">
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
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">应发工资&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="payablesalary" name="payablesalary" class="form-control col-md-7 col-xs-12" placeholder="应发工资">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">实发工资&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="realsalary" name="realsalary" class="form-control col-md-7 col-xs-12" placeholder="实发工资">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">状态&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12" id="stateSelect">
		        <label class="radio-inline">
				  <input type="radio" name="state" id="state1_add_input" value="Y" checked="checked"> 已发
				</label>
				<label class="radio-inline">
				  <input type="radio" name="state" id="state2_add_input" value="N"> 未发
				</label>
	         </div>
	     </div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="salary_save_btn">保存</button>
      </div>
    </div>
  </div>
</div>

<!-- 工资修改 -->
<div class="modal fade" id="salaryEditModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">工资信息修改</h4>
      </div>
      <div class="modal-body">
        <form id="editSalaryForm" data-parsley-validate class="form-horizontal form-label-left">
		  <input type="hidden" id="edit_id" name="id" />
		  <div class="form-group">
              <label class="control-label col-md-3 col-sm-3 col-xs-12">姓名&nbsp;<span class="required">*</span>
              </label>
              <div class="col-md-8 col-sm-4 col-xs-12">
                  <input type="text" id="edit_name" name="name" class="form-control col-md-7 col-xs-12" readonly="readonly"/>
              </div>
          </div>
		  <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">基本工资&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="edit_base" name="base" class="form-control col-md-7 col-xs-12">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">绩效&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="edit_achievements" name="achievements" class="form-control col-md-7 col-xs-12">
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
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">应发工资&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="edit_payablesalary" name="payablesalary" class="form-control col-md-7 col-xs-12">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">实发工资&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="edit_realsalary" name="realsalary" class="form-control col-md-7 col-xs-12">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">状态&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12" id="edit_stateSelect">
		        <label class="radio-inline">
				  <input type="radio" name="state" id="state1_edit_input" value="Y"> 已发
				</label>
				<label class="radio-inline">
				  <input type="radio" name="state" id="state2_edit_input" value="N"> 未发
				</label>
	         </div>
	     </div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="salary_edit_btn">保存</button>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $('#querySalaryTable').bootstrapTable(
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
                url: '${contextPath}/mansalary/querysalary',
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
                        field: 'base',
                        title: '基本工资'
                    }, {
                        field: 'achievements',
                        title: '绩效'
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
                        field: 'payablesalary',
                        title: '应发工资'
                    }, {
                        field: 'realsalary',
                        title: '实发工资'
                    }, {
                        field: 'state',
                        title: '状态',
                        formatter : function (value) {
                            if (value == 'Y') {
                                return '已发';
                            } else {
                                return '未发';
                            }
                        }

                    }],
            }
        );
        
	    //工资添加校验
	    $("#addSalaryForm").validate({
	        rules: {
	            name: {
	                required: true,
	                minlength: 1
	            },
	            base: {
	                required: true,
	                minlength: 1
	            },
	            achievements: {
	                required: true,
	                minlength: 1
	            },
	            endowment: {
	            	required: true,
	                minlength: 1
	            },
	            nemployment: {
	            	required: true,
	                minlength: 1
	            },
	            maternity: {
	            	required: true,
	                minlength: 1
	            },
	            injury: {
	            	required: true,
	                minlength: 1
	            },
	            medical: {
	            	required: true,
	                minlength: 1
	            },
	            payablesalary: {
	            	required: true,
	                minlength: 1
	            },
	            realsalary: {
	            	required: true,
	                minlength: 1
	            }
	        },
	        messages: {
	            name: {
	                required: "姓名不能为空",
	                minlength: "至少1个字符"
	            },
	            base: {
	                required: "基本工资不能为空",
	                minlength: "至少1个字符"
	            },
	            achievements: {
	                required: "绩效不能为空",
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
	            },
	            payablesalary: {
	                required: "应发工资不能为空",
	                minlength: "至少1个字符"
	            },
	            realsalary: {
	                required: "实发工资不能为空",
	                minlength: "至少1个字符"
	            }
	        }
	    });
	    
	    //工资修改校验
	    $("#editSalaryForm").validate({
	        rules: {
	            name: {
	                required: true,
	                minlength: 1
	            },
	            base: {
	                required: true,
	                minlength: 1
	            },
	            achievements: {
	                required: true,
	                minlength: 1
	            },
	            endowment: {
	            	required: true,
	                minlength: 1
	            },
	            nemployment: {
	            	required: true,
	                minlength: 1
	            },
	            maternity: {
	            	required: true,
	                minlength: 1
	            },
	            injury: {
	            	required: true,
	                minlength: 1
	            },
	            medical: {
	            	required: true,
	                minlength: 1
	            },
	            payablesalary: {
	            	required: true,
	                minlength: 1
	            },
	            realsalary: {
	            	required: true,
	                minlength: 1
	            }
	        },
	        messages: {
	            name: {
	                required: "姓名不能为空",
	                minlength: "至少1个字符"
	            },
	            base: {
	                required: "基本工资不能为空",
	                minlength: "至少1个字符"
	            },
	            achievements: {
	                required: "绩效不能为空",
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
	            },
	            payablesalary: {
	                required: "应发工资不能为空",
	                minlength: "至少1个字符"
	            },
	            realsalary: {
	                required: "实发工资不能为空",
	                minlength: "至少1个字符"
	            }
	        }
	    });
	    
	    //限制文本框只能输入数字和小数点 
	    /* $("#base,#achievements,#endowment,#nemployment,#maternity,#injury,#medical,#payablesalary,#realsalary,#edit_base,#edit_achievements,#edit_endowment,#edit_nemployment,#edit_maternity,#edit_injury,#edit_medical,#edit_payablesalary,#edit_realsalary").keyup(function(){    
	        $(this).val($(this).val().replace(/[^0-9.]/g,''));    
	    }).bind("paste",function(){  //CTR+V事件处理    
	        $(this).val($(this).val().replace(/[^0-9.]/g,''));     
	    }).css("ime-mode", "disabled"); //CSS设置输入法不可用     */
	    
    });

    //模糊查询
    $('#btn-search-query').on('click', function () {
        $('#querySalaryTable').bootstrapTable("refresh", {querySalaryList: {pageNumber: 1}});
    });

    //添加
    $("#btn-search-add").click(function () {
    	
    	//弹出模态框
		$("#salaryAddModal").modal({
			backdrop:"static"
		});
    	//清除表单数据
		$("#name").val("");
		$("#base").val("");
		$("#achievements").val("");
		$("#endowment").val("");
		$("#nemployment").val("");
		$("#maternity").val("");
		$("#injury").val("");
		$("#medical").val("");
		$("#payablesalary").val("");
		$("#realsalary").val("");
		
    });
	
	//添加点击保存
    $('#salary_save_btn').on('click', function () {
        if (!$("#addSalaryForm").validate().form()) {
            return;
        };
        if(checks($("#name").val())){
			toastr.error("姓名含有非法字符，请重新输入!","错误提示：");
        	return;
        }
        if(checksDecimal($("#base").val())){
			toastr.error("基本工资含有非法字符，请重新输入!","错误提示：");
        	return;
        }
        if(isNaN($("#base").val())){
			toastr.error("基本工资是非法数字，请重新输入!","错误提示：");
        	return;
        }
        if(checksDecimal($("#achievements").val())){
			toastr.error("绩效含有非法字符，请重新输入!","错误提示：");
        	return;
        }
        if(isNaN($("#achievements").val())){
			toastr.error("绩效是非法数字，请重新输入!","错误提示：");
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
    	if(checksDecimal($("#payablesalary").val())){
			toastr.error("应发工资含有非法字符，请重新输入!","错误提示：");
        	return;
        }
    	if(isNaN($("#payablesalary").val())){
 			toastr.error("应发工资是非法数字，请重新输入!","错误提示：");
         	return;
         }
    	if(checksDecimal($("#realsalary").val())){
			toastr.error("实发工资含有非法字符，请重新输入!","错误提示：");
        	return;
        }
    	if(isNaN($("#realsalary").val())){
 			toastr.error("实发工资是非法数字，请重新输入!","错误提示：");
         	return;
         }
    	if ($('#edit_stateSelect input[name="state"]:checked').val()=="") {
        	alert("状态为空！")
            return;
        };
        $.post("${contextPath}/mansalary/addsalary",
            {
                name: $("#name").val(),
                base: $("#base").val(),
                achievements: $("#achievements").val(),
                endowment: $("#endowment").val(),
                nemployment: $("#nemployment").val(),
                maternity: $("#maternity").val(),
                injury: $("#injury").val(),
                medical: $("#medical").val(),
                payablesalary: $("#payablesalary").val(),
                realsalary: $("#realsalary").val(),
                state: $('#stateSelect input[name="state"]:checked').val()
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
	                    	$("#salaryAddModal").modal('hide');
			                $('#querySalaryTable').bootstrapTable("refresh", {querySalaryList: {pageNumber: 1}});
                      	}

                    }]
                });
            }
        );
    });
	
    //修改
    $("#btn-search-edit").on('click',function(){
        var rows = $('#querySalaryTable').bootstrapTable('getSelections');
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
		$("#salaryEditModal").modal({
			backdrop:"static"
		});
        //查出工资信息并显示
        getSalary(rows[0].id);
    });
	
    //根据id查询工资信息
    function getSalary(id){
    	$.ajax({
    		url:"${contextPath}/mansalary/querysalarybyid/"+id,
    		type:"GET",
    		success:function(result){
    	console.log(result);
    			var salaryData = result.extend.salary;
    			$("#edit_id").val(salaryData.id);
    			$("#edit_name").val(salaryData.name);
    			$("#edit_base").val(salaryData.base);
    			$("#edit_achievements").val(salaryData.achievements);
    			$("#edit_endowment").val(salaryData.endowment);
    			$("#edit_nemployment").val(salaryData.nemployment);
    			$("#edit_maternity").val(salaryData.maternity);
    			$("#edit_injury").val(salaryData.injury);
    			$("#edit_medical").val(salaryData.medical);
    			$("#edit_payablesalary").val(salaryData.payablesalary);
    			$("#edit_realsalary").val(salaryData.realsalary);
    			$("#edit_stateSelect input[name='state'][value="+salaryData.state+"]").attr("checked",true); 
    		}
    	});
    }
    
	//修改点击保存
    $('#salary_edit_btn').on('click', function () {
    	 if (!$("#editSalaryForm").validate().form()) {
             return;
         };
         if(checks($("#edit_name").val())){
 			toastr.error("姓名含有非法字符，请重新输入!","错误提示：");
         	return;
         }
         if(checksDecimal($("#edit_base").val())){
  			toastr.error("基本工资含有非法字符，请重新输入!","错误提示：");
          	return;
          }
         if(isNaN($("#edit_base").val())){
 			toastr.error("基本工资是非法数字，请重新输入!","错误提示：");
         	return;
         }
         if(checksDecimal($("#edit_achievements").val())){
  			toastr.error("绩效含有非法字符，请重新输入!","错误提示：");
          	return;
          }
         if(isNaN($("#edit_achievements").val())){
 			toastr.error("绩效是非法数字，请重新输入!","错误提示：");
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
     	if(checksDecimal($("#edit_payablesalary").val())){
 			toastr.error("应发工资含有非法字符，请重新输入!","错误提示：");
         	return;
         }
     	if(isNaN($("#edit_payablesalary").val())){
  			toastr.error("应发工资是非法数字，请重新输入!","错误提示：");
          	return;
          }
     	if(checksDecimal($("#edit_realsalary").val())){
 			toastr.error("实发工资含有非法字符，请重新输入!","错误提示：");
         	return;
         }
     	if(isNaN($("#edit_realsalary").val())){
  			toastr.error("实发工资是非法数字，请重新输入!","错误提示：");
          	return;
          }
        if ($('#edit_stateSelect input[name="state"]:checked').val()=="") {
        	alert("状态为空！")
            return;
        };
        $.post("${contextPath}/mansalary/editsalary",
            {
                id: $("#edit_id").val(),
                name: $("#edit_name").val(),
                base: $("#edit_base").val(),
                achievements: $("#edit_achievements").val(),
                endowment: $("#edit_endowment").val(),
                nemployment: $("#edit_nemployment").val(),
                maternity: $("#edit_maternity").val(),
                injury: $("#edit_injury").val(),
                medical: $("#edit_medical").val(),
                payablesalary: $("#edit_payablesalary").val(),
                realsalary: $("#edit_realsalary").val(),
                state: $('#edit_stateSelect input[name="state"]:checked').val()
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
	                    	$("#salaryEditModal").modal('hide');
			                $('#querySalaryTable').bootstrapTable("refresh", {querySalaryList: {pageNumber: 1}});
                      	}

                    }]
                });
            }
        );
    });
    
    //删除
    $('#btn-search-del').on('click', function () {
        var rows = $('#querySalaryTable').bootstrapTable('getSelections');
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
                    $.post("${contextPath}/mansalary/delsalary",
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
                                        loadPage('${contextPath}/mansalary/querysalarypage');
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
