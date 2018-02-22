<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <title>首页</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap -->
    <link href="${contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${contextPath}/static/css/font-awesome.min.css" rel="stylesheet">

    <link href="${contextPath}/static/css/bootstrap-dialog.min.css" rel="stylesheet">
    <link href="${contextPath}/static/css/bootstrap-table.min.css" rel="stylesheet">
    <link href="${contextPath}/static/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/static/css/bootstrap-switch.min.css" rel="stylesheet">
    <link href="${contextPath}/static/css/tablecenter.css" rel="stylesheet">

    <!-- bootstrap-progressbar -->
    <link href="${contextPath}/static/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="${contextPath}/static/css/custom.css" rel="stylesheet">
	<!-- Bootstrap弹框 -->
	<link href="${contextPath}/static/css/toastr.min.css" rel="stylesheet"/>
	<!-- BootStrap时间选择 -->
	<link href="${contextPath}/static/css/bootstrap-datetimepicker.css" rel="stylesheet"/>

    <!--[if lt IE 9]>
    <script src="${contextPath}/static/static/js/html5shiv.js"></script>
    <script src="${contextPath}/static/static/js/respond.min.js"></script>
    <![endif]-->
    <script src="${contextPath}/static/js/ajax.js" type="text/javascript"></script>

    <script src="${contextPath}/static/js/sea.js" type="text/javascript"></script>

    <!-- jQuery -->
    <script src="${contextPath}/static/js/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="${contextPath}/static/js/bootstrap.min.js"></script>
    <!-- Bootstrap Dialog -->
    <script src="${contextPath}/static/js/bootstrap-dialog.min.js" type="text/javascript"></script>
    <script src="${contextPath}/static/js/jquery.validate.min.js" type="text/javascript"></script>
    <script src="${contextPath}/static/js/messages_zh.min.js" type="text/javascript"></script>
    <script src="${contextPath}/static/js/bootstrap-table.min.js" type="text/javascript"></script>
    <script src="${contextPath}/static/js/bootstrap-table-zh-CN.min.js" type="text/javascript"></script>

    <script src="${contextPath}/static/js/bootstrap-switch.min.js" type="text/javascript"></script>
    <script src="${contextPath}/static/js/myjs/myjs.js" type="text/javascript"></script>
    <!-- BootStrap时间选择 -->
    <script src="${contextPath}/static/js/bootstrap-datetimepicker.js"></script>
	<script src="${contextPath}/static/js/bootstrap-datetimepicker.zh-CN.js"></script>
    <!-- Bootstrap弹框 -->
	<script src="${contextPath}/static/js/toastr.min.js"></script>
	<script src="${contextPath}/static/js/toastr_option.js"></script>
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <!-- left -->
        <%@ include file="_left.jsp" %>
        <!-- left -->
        <!-- top navigation -->
        <%@ include file="_top.jsp" %>
        <!-- top navigation -->
        <!-- page content -->
        <div class="right_col" id="mainbody" role="main">
            <sitemesh:write property="body"/>
        </div>
        <!-- /page content -->
        <footer>
            <div class="pull-right">
<!--                 <a href="javascript:void(0);">贵州威宁经济开发区物业管理有限公司劳务派遣信息管理系统</a>	 -->
            </div>
            <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
    </div>
</div>


<!-- Custom Theme Scripts -->
<script src="${contextPath}/static/js/custom.min.js"></script>
</body>

</html>
