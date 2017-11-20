<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
</head>
<body>
		<div class="col-md-12">
		<div class="panel-body" style="padding-bottom:0px;">
        <div class="panel panel-default">
            <div class="panel-heading">查询条件</div>
            <div class="panel-body">
                		<div role="form" id="search_form_mytask" class="form-horizontal">
							<div id="simpleSearchLabel">
								<div class="form-group">
									<label for="taskSummary" class="col-sm-2 control-label">用户名</label>
									<div class="col-sm-3">
										<input type="text" class="form-control" id="s_eusername"
											name="s_eusername" placeholder="用户名">
									</div>
									<button id="btn-search-user" class="btn btn-primary btn-sm"
										style="margin-left: 11%">
										<i class="icon-search"></i> 查询
									</button>
								</div>
								
							</div>
						
						</div>
            </div>
        </div>       

        <div id="toolbar" class="btn-group">
            <button id="btn_add" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
            </button>
            <button id="btn_edit" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
            </button>
            <button id="btn_delete" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
            </button>
        </div>
        <table id="table"></table>
    </div>
	</div>
	<script type="text/javascript">
	$().ready(function() {
        $('#table').bootstrapTable(
        		{ 
        			class:'talbe table-condensed',
        			pagination: true,
        			height:500,
    			    sidePagination: 'server',
    			    dataType: 'json',
    			    striped:'true',
    			    pageNumber: 1,
    			    pageSize: 10,
    			    pageList: [1, 10, 20],
    			    queryParamsType:'',//默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
                                       // 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
    				showRefresh: true,
    				toolbar: '#toolbar',   
    				showColumns: true,
    				search: true, 
    				showToggle:'true',
    				showPaginationSwitch:'true',
    				uniqueId:'id',
    				clickToSelect:'true',
    				queryParams: function (params) {
    					params.username = $("#s_eusername").val();	 
    					return params;
    				},
    				method:'POST',
    				contentType: "application/x-www-form-urlencoded",
    			    url: '${contextPath}/manuser/queryuser',
        			 columns: [{radio:true},
							{
							    field: 'id',
							    title: 'ID',
							    sortable: true
							},
        			          {
        			        field: 'username',
        			        title: '用户名',
        			        sortable: true
        			    }, {
        			        field: 'password',
        			        title: '密码',
        			        sortable:true
        			    }, {
        			        field: 'status',
        			        title: '状态'
        			      
        			    }],
        		}
        		);
	});
	
	 $('#btn-search-user').on('click', function () {
         //var username = $("#username").val();
         $('#table').bootstrapTable("refresh", {queryUserList: {pageNumber: 1}});
     });
	 
	 $('#btn-search-del').on('click', function () {
		 var rows = $('#table').bootstrapTable('getSelections');
		 if(rows.length==0){
			 BootstrapDialog.alert({title: '警告',message: '请选择一条数据'});
			 return;
		 }
		 $.post("${contextPath}/manuser/delUser", 
					{
			 			id:rows[0].id
					},function (data) {
		            	BootstrapDialog.show({
	                        title: '操作结果',
	                        message: data,
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
	 });
	 $("#btn-search-add").click(function () {  
		//  $("#myModalLabel").text("新增"); 
		 // $('#myModal').modal(); 
		 BootstrapDialog.show({
             id: 'typeDialog',
             title: '添加用户',
             message: $('<div></div>').load('${contextPath}/manuser/loadadduserpage')
         });
	});
	 
	</script>
</body>
</html>
