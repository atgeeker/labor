<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
</head>
<body>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>
                    修改用户信息
                </h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <br/>
                <form id="editUserForm" data-parsley-validate
                      class="form-horizontal form-label-left">
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">用户账号 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="id" name="id" value="${user.id}" readonly="readonly"
                                   class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">用户账号 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="username" name="username" value="${user.username}" readonly="readonly"
                                   class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">用户真实姓名 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="realname" name="realname" value="${user.realname}"
                                   class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">密码 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="password" id="password" name="password" value="${user.password}" readonly="readonly"
                                   class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>

                    <div class="ln_solid"></div>
                    <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                            <%--<button type="button" class="btn btn-primary">返回</button>--%>
                            <button type="button" id="addbtn" class="btn btn-success">修改</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $().ready(function () {
        $("#editUserForm").validate({
            rules: {
                username: {
                    required: true,
                    minlength: 4
                },
                password: {
                    required: true,
                    minlength: 6
                },
                realname :{
                    required: true,
                    minlength: 2
                }
            },
            message: {
                username: {
                    required: "用户名必填",
                    minlength: "至少4个字符"
                },
                password: {
                    required: "密码必填",
                    minlength: "至少6个字符"
                },
                realname :{
                    required: "真实姓名必填",
                    minlength: "至少2个字符"
                }
            }
        })
    });

    $('#addbtn').on('click', function () {
        if (!$("#editUserForm").validate().form()) {
            return;
        }
        $.post("${contextPath}/manuser/edituser",
            {
                id:$("#id").val(),
                username: $("#username").val(),
                password: $("#password").val(),
                realname: $("#realname").val()
    },
        function (data) {
//            alert(data);
            BootstrapDialog.show({
                title: '操作结果',
                message: data,
                buttons: [{
                    label: '确认',
                    cssClass: 'btn-primary',
                    action: function (dialogItself) {
                        dialogItself.close();
                        //$("#fdialog").close();
                        //loadPage('${contextPath}/manuser/loadadduserpage');
                    }
                }]
            });
        }
        );
    });

</script>
</body>
</html>
