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
                    <div class="x_content">
                    <table id="log-datatable-fixed-header" class="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>登录账号</th>
                            <th>操作时间</th>
                            <th>操作ip</th>
                            <th>操作行为</th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                    </div>
                    <!-- 分页-->
                    <c:if test="${not empty pageInfo.pageResults}">
                        <div class="u27">
                            <!--  第1-${size}条，共${totalCount}条-->
                            <c:if test="${pageInfo.totalCount<=pageInfo.countOfCurrentPage}">
                                第1-${pageInfo.totalCount}条，共${pageInfo.totalCount}条
                            </c:if>
                            <c:if
                                    test="${pageInfo.totalCount>pageInfo.countOfCurrentPage &&pageInfo.totalCount<=pageInfo.countOfCurrentPage*(pageInfo.currentPageNo)}">
                                第
                                <c:if test="${pageInfo.currentPageNo==1}">1</c:if>
                                <c:if test="${pageInfo.currentPageNo>1}">${pageInfo.countOfCurrentPage*(pageInfo.currentPageNo-1)+1 }</c:if>
                                -${pageInfo.totalCount}条，共${pageInfo.totalCount}条
                            </c:if>
                            <c:if
                                    test="${pageInfo.totalCount>pageInfo.countOfCurrentPage &&pageInfo.totalCount>pageInfo.countOfCurrentPage * (pageInfo.currentPageNo)}">
                                第
                                <c:if test="${pageInfo.currentPageNo==1}">1</c:if>
                                <c:if test="${pageInfo.currentPageNo>1}">${pageInfo.countOfCurrentPage*(pageInfo.currentPageNo-1)+1 }</c:if>
                                -${pageInfo.countOfCurrentPage*(pageInfo.currentPageNo)}条，共${pageInfo.totalCount}条
                            </c:if>
                            <c:choose>
                                <c:when test="true">
                                    <a href="javascript:void();">
                                        上一页
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a href="javascript:void();"
                                       onclick="">
                                    </a>
                                </c:otherwise>
                            </c:choose>
                            <!-- 下一页 -->
                            <c:choose>
                                <c:when test="true">
                                    <a href="javascript:void();">
                                        下一页
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a href="javascript:void()"
                                       onclick="">
                                    </a>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">


</script>
</body>
</html>
