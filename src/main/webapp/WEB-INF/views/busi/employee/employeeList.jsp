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
                        <li><a href="#">员工基本信息管理</a></li>
                    </ol>
                    <div role="form" id="search_form_mytask" class="form-horizontal" style="float: left;width:60%;">
                        <div id="simpleSearchLabel">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">姓名</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="s_eusername"
                                           name="s_eusername" placeholder="姓名">
                                </div>
                                <button id="btn-search-employee" class="btn btn-primary btn-sm"
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
                    <table id="queryEmployeeTable"></table>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 员工添加的模态框 -->
<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="closeBtn();"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">员工信息添加</h4>
      </div>
      <div class="modal-body">
        <form id="addEmpForm" data-parsley-validate class="form-horizontal form-label-left">
		  <div class="form-group">
              <label class="control-label col-md-3 col-sm-3 col-xs-12">姓名&nbsp;<span class="required">*</span>
              </label>
              <div class="col-md-8 col-sm-4 col-xs-12">
                  <input type="text" id="name" name="name" class="form-control col-md-7 col-xs-12" placeholder="姓名">
              </div>
          </div>
          <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">性别&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12" id="genderSelect">
		        <label class="radio-inline">
				  <input type="radio" name="gender" id="gender1_add_input" value="M" checked="checked"> 男
				</label>
				<label class="radio-inline">
				  <input type="radio" name="gender" id="gender2_add_input" value="F"> 女
				</label>
	         </div>
	     </div>
	     <div class="form-group">
		    <label class="col-sm-3 control-label">民族</label>
		    <div class="col-sm-6">
		      <select class="form-control" name="nation" id="nation">
                <option value="汉族">汉族</option>  
			    <option value="彝族">彝族</option>  
			    <option value="回族">回族</option>  
			    <option value="苗族">苗族</option>  
			    <option value="藏族">藏族</option>  
			    <option value="维吾尔族">维吾尔族</option>  
			    <option value="壮族">壮族</option>  
			    <option value="布依族">布依族</option>  
			    <option value="朝鲜族">朝鲜族</option>  
			    <option value="满族">满族</option>  
			    <option value="侗族">侗族</option>  
			    <option value="瑶族">瑶族</option>  
			    <option value="白族">白族</option>  
			    <option value="土家族">土家族</option>  
			    <option value="蒙古族">蒙古族</option>  
			    <option value="哈尼族">哈尼族</option>  
			    <option value="哈萨克族">哈萨克族</option>  
			    <option value="傣族">傣族</option>  
			    <option value="黎族">黎族</option>  
			    <option value="傈僳族">傈僳族</option>  
			    <option value="佤族">佤族</option>  
			    <option value="畲族">畲族</option>  
			    <option value="高山族">高山族</option>  
			    <option value="拉祜族">拉祜族</option>  
			    <option value="水族">水族</option>  
			    <option value="东乡族">东乡族</option>  
			    <option value="纳西族">纳西族</option>  
			    <option value="景颇族">景颇族</option>  
			    <option value="柯尔克孜族">柯尔克孜族</option>  
			    <option value="土族">土族</option>  
			    <option value="达斡尔族">达斡尔族</option>  
			    <option value="仫佬族">仫佬族</option>  
			    <option value="羌族">羌族</option>  
			    <option value="布朗族">布朗族</option>  
			    <option value="撒拉族">撒拉族</option>  
			    <option value="毛南族">毛南族</option>  
			    <option value="仡佬族">仡佬族</option>  
			    <option value="锡伯族">锡伯族</option>  
			    <option value="阿昌族">阿昌族</option>  
			    <option value="普米族">普米族</option>  
			    <option value="塔吉克族">塔吉克族</option>  
			    <option value="怒族">怒族</option>  
			    <option value="乌孜别克族">乌孜别克族</option>  
			    <option value="俄罗斯族">俄罗斯族</option>  
			    <option value="鄂温克族">鄂温克族</option>  
			    <option value="德昂族">德昂族</option>  
			    <option value="保安族">保安族</option>  
			    <option value="裕固族">裕固族</option>  
			    <option value="京族">京族</option>  
			    <option value="塔塔尔族">塔塔尔族</option>  
			    <option value="独龙族">独龙族</option>  
			    <option value="鄂伦春族">鄂伦春族</option>  
			    <option value="赫哲族">赫哲族</option>  
			    <option value="门巴族">门巴族</option>  
			    <option value="珞巴族">珞巴族</option>  
			    <option value="基诺族">基诺族</option> 
            </select>
		    </div>
		  </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">文化程度&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="degree" name="degree" class="form-control col-md-7 col-xs-12" placeholder="文化程度">
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
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">出生日期&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input class="form_datetime form-control" type="text" id="birthday" name="birthday" size="16" placeholder="请选择" readonly/>
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">家庭住址&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="address" name="address" class="form-control col-md-7 col-xs-12" placeholder="家庭住址">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">电话&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="tel" name="tel" class="form-control col-md-7 col-xs-12" placeholder="电话">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">状态&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12" id="stateSelect">
		        <label class="radio-inline">
				  <input type="radio" name="state" id="state1_add_input" value="Y" checked="checked"> 在职
				</label>
				<label class="radio-inline">
				  <input type="radio" name="state" id="state2_add_input" value="N"> 离职
				</label>
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
        <button type="button" class="btn btn-primary" id="emp_save_btn">保存</button>
      </div>
    </div>
  </div>
</div>

<!-- 员工修改的模态框 -->
<div class="modal fade" id="empEditModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="closeBtn();"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">员工信息修改</h4>
      </div>
      <div class="modal-body">
        <form id="editEmpForm" data-parsley-validate class="form-horizontal form-label-left">
          <input type="hidden" id="edit_id" name="id" />
		  <div class="form-group">
              <label class="control-label col-md-3 col-sm-3 col-xs-12">姓名&nbsp;<span class="required">*</span>
              </label>
              <div class="col-md-8 col-sm-4 col-xs-12">
                  <input type="text" id="edit_name" name="name" class="form-control col-md-7 col-xs-12" readonly="readonly"/>
              </div>
          </div>
          <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">性别&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12" id="edit_genderSelect">
		        <label class="radio-inline">
				  <input type="radio" name="gender" id="gender1_edit_input" value="M" /> 男
				</label>
				<label class="radio-inline">
				  <input type="radio" name="gender" id="gender2_edit_input" value="F"> 女
				</label>
	         </div>
	     </div>
	     <div class="form-group">
		    <label class="col-sm-3 control-label">民族</label>
		    <div class="col-sm-6">
		      <select class="form-control" id="edit_nation" name="nation">
                <option value="汉族">汉族</option>  
			    <option value="彝族">彝族</option>  
			    <option value="回族">回族</option>  
			    <option value="苗族">苗族</option>  
			    <option value="藏族">藏族</option>  
			    <option value="维吾尔族">维吾尔族</option>  
			    <option value="壮族">壮族</option>  
			    <option value="布依族">布依族</option>  
			    <option value="朝鲜族">朝鲜族</option>  
			    <option value="满族">满族</option>  
			    <option value="侗族">侗族</option>  
			    <option value="瑶族">瑶族</option>  
			    <option value="白族">白族</option>  
			    <option value="土家族">土家族</option>  
			    <option value="蒙古族">蒙古族</option>  
			    <option value="哈尼族">哈尼族</option>  
			    <option value="哈萨克族">哈萨克族</option>  
			    <option value="傣族">傣族</option>  
			    <option value="黎族">黎族</option>  
			    <option value="傈僳族">傈僳族</option>  
			    <option value="佤族">佤族</option>  
			    <option value="畲族">畲族</option>  
			    <option value="高山族">高山族</option>  
			    <option value="拉祜族">拉祜族</option>  
			    <option value="水族">水族</option>  
			    <option value="东乡族">东乡族</option>  
			    <option value="纳西族">纳西族</option>  
			    <option value="景颇族">景颇族</option>  
			    <option value="柯尔克孜族">柯尔克孜族</option>  
			    <option value="土族">土族</option>  
			    <option value="达斡尔族">达斡尔族</option>  
			    <option value="仫佬族">仫佬族</option>  
			    <option value="羌族">羌族</option>  
			    <option value="布朗族">布朗族</option>  
			    <option value="撒拉族">撒拉族</option>  
			    <option value="毛南族">毛南族</option>  
			    <option value="仡佬族">仡佬族</option>  
			    <option value="锡伯族">锡伯族</option>  
			    <option value="阿昌族">阿昌族</option>  
			    <option value="普米族">普米族</option>  
			    <option value="塔吉克族">塔吉克族</option>  
			    <option value="怒族">怒族</option>  
			    <option value="乌孜别克族">乌孜别克族</option>  
			    <option value="俄罗斯族">俄罗斯族</option>  
			    <option value="鄂温克族">鄂温克族</option>  
			    <option value="德昂族">德昂族</option>  
			    <option value="保安族">保安族</option>  
			    <option value="裕固族">裕固族</option>  
			    <option value="京族">京族</option>  
			    <option value="塔塔尔族">塔塔尔族</option>  
			    <option value="独龙族">独龙族</option>  
			    <option value="鄂伦春族">鄂伦春族</option>  
			    <option value="赫哲族">赫哲族</option>  
			    <option value="门巴族">门巴族</option>  
			    <option value="珞巴族">珞巴族</option>  
			    <option value="基诺族">基诺族</option> 
            </select>
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
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">文化程度&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="edit_degree" name="degree" class="form-control col-md-7 col-xs-12">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">出生日期&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input class="form_datetime form-control" type="text" id="edit_birthday" name="birthday" size="16" placeholder="请选择" readonly/>
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">家庭住址&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="edit_address" name="address" class="form-control col-md-7 col-xs-12">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">电话&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12">
	             <input type="text" id="edit_tel" name="tel" class="form-control col-md-7 col-xs-12">
	         </div>
	     </div>
	     <div class="form-group">
	         <label class="control-label col-md-3 col-sm-3 col-xs-12">状态&nbsp;<span class="required">*</span>
	         </label>
	         <div class="col-md-8 col-sm-4 col-xs-12" id="edit_stateSelect">
		        <label class="radio-inline">
				  <input type="radio" name="state" id="state1_edit_input" value="Y" checked="checked"> 在职
				</label>
				<label class="radio-inline">
				  <input type="radio" name="state" id="state2_edit_input" value="N"> 离职
				</label>
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
        <button type="button" class="btn btn-primary" id="emp_edit_btn">保存</button>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $('#queryEmployeeTable').bootstrapTable(
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
                url: '${contextPath}/manemp/queryemployee',
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
                        title: '姓名',
                        width: '90px'
                    }, {
                        field: 'gender',
                        title: '性别',
                        formatter : function (value) {
                            if (value == 'M') {
                                return '男';
                            } else {
                                return '女';
                            }
                        }
                    }, {
                        field: 'nation',
                        title: '民族'
                    }, {
                        field: 'degree',
                        title: '文化程度'
                    }, {
                        field: 'idcardno',
                        title: '身份证号码'
                    }, {
                        field: 'birthday',
                        title: '出生日期',
                        formatter : function (value) {
	                    	return getMyDate(value);
	                    },
                        width: '105px'
                    }, {
                        field: 'address',
                        title: '家庭住址'
                    }, {
                        field: 'tel',
                        title: '电话'
                    }, {
                        field: 'state',
                        title: '状态',
                        formatter : function (value) {
                            if (value == 'Y') {
                                return '在职';
                            } else {
                                return '离职';
                            }
                        }
                    },{
                    	field: 'orgname',
                    	title: '所属用功单位' 
                    }],
            }
        );
    });
    
    //添加员工输入校验
    $("#addEmpForm").validate({
        rules: {
            name: {
                required: true,
                minlength: 1
            },
            nation: {
                required: true,
                minlength: 1
            },
            degree: {
                required: true,
                minlength: 2
            },
            idcardno: {
                required: true,
                minlength: 18
            },
            birthday: {
            	required: true,
                minlength: 6
            },
            address: {
            	required: true,
                minlength: 1
            },
            tel: {
            	required: true,
                minlength: 3
            }
        },
        messages: {
            name: {
                required: "姓名不能为空",
                minlength: "至少1个字符"
            },
            nation: {
                required: "民族不能为空",
                minlength: "至少1个字符"
            },
            degree: {
                required: "文化程度不能为空",
                minlength: "至少2个字符"
            },
            idcardno: {
                required: "身份证号码不能为空",
                minlength: "至少18个字符"
            },
            birthday: {
                required: "出生日期不能为空",
                minlength: "至少6个字符"
            },
            address: {
                required: "家庭住址不能为空",
                minlength: "至少1个字符"
            },
            tel: {
                required: "电话不能为空",
                minlength: "至少3个字符"
            }
        }
    });
    
    //修改员工输入校验
    $("#editEmpForm").validate({
        rules: {
            name: {
                required: true,
                minlength: 1
            },
            nation: {
                required: true,
                minlength: 1
            },
            degree: {
                required: true,
                minlength: 2
            },
            idcardno: {
                required: true,
                minlength: 18
            },
            birthday: {
            	required: true,
                minlength: 6
            },
            address: {
            	required: true,
                minlength: 1
            },
            tel: {
            	required: true,
                minlength: 3
            }
        },
        messages: {
            name: {
                required: "姓名不能为空",
                minlength: "至少1个字符"
            },
            nation: {
                required: "民族不能为空",
                minlength: "至少1个字符"
            },
            degree: {
                required: "文化程度为空",
                minlength: "至少2个字符"
            },
            idcardno: {
                required: "身份证号码不能为空",
                minlength: "至少18个字符"
            },
            birthday: {
                required: "出生日期不能为空",
                minlength: "至少6个字符"
            },
            address: {
                required: "家庭住址不能为空",
                minlength: "至少1个字符"
            },
            tel: {
                required: "电话不能为空",
                minlength: "至少3个字符"
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
    $('#btn-search-employee').on('click', function () {
        $('#queryEmployeeTable').bootstrapTable("refresh", {queryEmployeeList: {pageNumber: 1}});
    });

    //添加
    $("#btn-search-add").click(function () {
    	//发送ajax请求，查出用工单位信息，显示在下拉列表中
		getOrganizations();
    	//弹出模态框
		$("#empAddModal").modal({
			backdrop:"static"
		});
		//清除表单数据
		$("#name").val("");
		$("#gender").val("");
		$("#nation").val("");
		$("#degree").val("");
		$("#idcardno").val("");
		$("#birthday").val("");
		$("#address").val("");
		$("#tel").val("");
		$("#state").val("");
		$("#orgname").val("");
    });

    //添加点击保存
	$("#emp_save_btn").click(function(){
		//校验表单数据
		if (!$("#empAddModal form").validate().form()) {
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
        if(checks($("#degree").val())){
			toastr.error("文化程度含有非法字符，请重新输入!","错误提示：");
        	return;
        }
        if($("#idcardno").val().length>18){
			toastr.error("身份证号码超过18位，请重新输入!","错误提示：");
        	return;
        }
        if(checks($("#address").val())){
			toastr.error("家庭住址含有非法字符，请重新输入!","错误提示：");
        	return;
        }
        if(checks($("#tel").val())){
			toastr.error("电话号码含有非法字符，请重新输入!","错误提示：");
        	return;
        }
        if ($.trim($("#orgname").val()).length<1) {
        	alert("所属用工单位为空！")
            return;
        }; 
		$.post("${contextPath}/manemp/addemployee",
	            {
	                name: $("#name").val(),
	                gender: $('#genderSelect input[name="gender"]:checked').val(),
	                nation: $("#nation").val(),
	                degree: $("#degree").val(),
	                idcardno: $("#idcardno").val(),
	                birthday: $("#birthday").val(),
	                address: $("#address").val(),
	                tel: $("#tel").val(),
	                state: $('#stateSelect input[name="state"]:checked').val(),
// 	                orgid: $("#orgid").val(),
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
		                    	$("#empAddModal").modal('hide');
		                    	$("#orgname").empty(); 
				                $('#queryEmployeeTable').bootstrapTable("refresh", {querySecurityList: {pageNumber: 1}});
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
        var rows = $('#queryEmployeeTable').bootstrapTable('getSelections');
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
                    $.post("${contextPath}/manemp/delemployee",
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
                                        loadPage('${contextPath}/manemp/queryemployeepage');
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
        var rows = $('#queryEmployeeTable').bootstrapTable('getSelections');
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
		$("#empEditModal").modal({
			backdrop:"static"
		});
		//查出员工信息并显示
        getEmp(rows[0].id);
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

    //根据id查询员工信息
    function getEmp(id){
    	$.ajax({
    		url:"${contextPath}/manemp/queryempbyid/"+id,
    		type:"GET",
    		success:function(result){
    	console.log(result);
    			var empData = result.extend.emp;
    			var optionValue = $("<option></option>").append(empData.orgname).attr("value",empData.orgname);
    			optionValue.appendTo("#empEditModal select");
    			$("#edit_id").val(empData.id);
    			$("#edit_name").val(empData.name);
    			$("#edit_genderSelect input[name='gender'][value="+empData.gender+"]").attr("checked",true);
    			$("#edit_nation").val(empData.nation);
    			$("#edit_degree").val(empData.degree);
    			$("#edit_idcardno").val(empData.idcardno);
    			$("#edit_birthday").val(getMyDate(empData.birthday));
    			$("#edit_address").val(empData.address);
    			$("#edit_tel").val(empData.tel);
    			$("#edit_state").val(empData.state);
    			$("#edit_stateSelect input[name='state'][value="+empData.state+"]").attr("checked",true); 
//     			$("#edit_orgid").val(empData.orgname);
    		}
    	});
    }

    //修改点击保存
    $('#emp_edit_btn').on('click', function () {
    	//校验表单数据
		if (!$("#empEditModal form").validate().form()) {
            return;
        };
        if(checks($("#edit_name").val())){
			toastr.error("姓名含有非法字符，请重新输入!","错误提示：");
        	return;
        }
        if(checks($("#edit_degree").val())){
			toastr.error("文化程度含有非法字符，请重新输入!","错误提示：");
        	return;
        }
        if(checks($("#edit_idcardno").val())){
			toastr.error("身份证号码含有非法字符，请重新输入!","错误提示：");
        	return;
        }
        if(checks($("#edit_address").val())){
			toastr.error("家庭住址含有非法字符，请重新输入!","错误提示：");
        	return;
        }
        if(checks($("#edit_tel").val())){
			toastr.error("电话号码含有非法字符，请重新输入!","错误提示：");
        	return;
        }
        if($("#edit_idcardno").val().length>18){
			toastr.error("身份证号码超过18位，请重新输入!","错误提示：");
        	return;
        }
        if ($.trim($("#edit_orgname").val()).length<1) {
        	alert("所属用工单位为空！")
            return;
        };
        $.post("${contextPath}/manemp/editemployee",
            {
                id: $("#edit_id").val(),
                name: $("#edit_name").val(),
                gender: $('#edit_genderSelect input[name="gender"]:checked').val(),
                nation: $("#edit_nation").val(),
                degree: $("#edit_degree").val(),
                idcardno: $("#edit_idcardno").val(),
                birthday: $("#edit_birthday").val(),
                address: $("#edit_address").val(),
                tel: $("#edit_tel").val(),
                state: $('#edit_stateSelect input[name="state"]:checked').val(),
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
	                    	$("#empEditModal").modal('hide');
	                    	//修改点击关闭，清空用工单位下拉选项
	                    	$("#edit_orgname").empty(); 
			                $('#queryEmployeeTable').bootstrapTable("refresh", {querySecurityList: {pageNumber: 1}});
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
