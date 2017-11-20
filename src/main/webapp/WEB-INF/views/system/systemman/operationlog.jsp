<%--
  Created by IntelliJ IDEA.
  User: zzy
  Date: 2017/8/24
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>操作日志查询</title>
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
                        <li><a href="#">系统管理</a></li>
                    </ol>
                    <div role="form" id="search_form_mytask" class="form-horizontal">
                        <div id="simpleSearchLabel">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">用户名</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="username"
                                           name="username" placeholder="用户名">
                                </div>
                                <button id="btn-search-user" class="btn btn-primary btn-sm"
                                        style="margin-left: 11%">
                                    <i class="icon-search"></i> 查询
                                </button>
                            </div>

                        </div>

                    </div>
                    <!-- <div id="batch-toolbar">

                        <button id="btn-search-edit" class="btn btn-primary btn-sm">
                            <i class="icon-search"></i> 详情
                        </button>

                    </div> -->
                    <table id="queryOperationLogTable"></table>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $('#queryOperationLogTable').bootstrapTable(
            {
                classes: 'table table-hover',
                pagination: true,
                height: 450,
                sidePagination: 'server',
                dataType: 'json',
                striped: 'true',
                pageNumber: 1,
                pageSize: 10,
                pageList: [1, 10, 20],
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
                    params.username = $("#username").val();
                    return params;
                },
                method: 'POST',
                contentType: "application/x-www-form-urlencoded",
                url: '${contextPath}/operationlogquery',
                columns: [{radio: true},
                    {
                        field: 'id',
                        title: 'ID',
                        sortable: true
                    },
                    {
                        field: 'userName',
                        title: '登陆账号',
                        sortable: true
                    }, {
                        field: 'createTime',
                        title: '创建时间'
                    }, {
                        field: 'ipAddress',
                        title: 'ip地址',
                        sortable: true
                    }, {
                        field: 'message',
                        title: '操作行为'
                    }]
            }
        );
    });

    $('#btn-search-user').on('click', function () {
        //var username = $("#username").val();
        $('#queryOperationLogTable').bootstrapTable("refresh", {queryUserList: {pageNumber: 1}});
    });


</script>
</body>
</html>
