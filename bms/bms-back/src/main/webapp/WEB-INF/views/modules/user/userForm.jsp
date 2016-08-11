<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/includes/taglib.jsp" %>
<html>
<head>
    <title>单表管理</title>
    <meta name="decorator" content="default"/>
    <%@ include file="/WEB-INF/views/includes/head.jsp" %>
    <script type="text/javascript">
        $(document).ready(function () {
            //$("#name").focus();
            $("#inputForm").validate({
                submitHandler: function (form) {
                    loading('正在提交，请稍等...');
                    form.submit();
                },
                errorContainer: "#messageBox",
                errorPlacement: function (error, element) {
                    $("#messageBox").text("输入有误，请先更正。");
                    if (element.is(":checkbox") || element.is(":radio") || element.parent().is(".input-append")) {
                        error.appendTo(element.parent().parent());
                    } else {
                        error.insertAfter(element);
                    }
                }
            });
        });
    </script>
</head>
<body>
<div class="container">

    <ul class="nav nav-tabs">
        <li><a href="${ctx}/user/">单表列表</a></li>
        <li class="active"><a href="${ctx}/user/form?id=${user.id}">单表${not empty user.id?'修改':'添加'}查看</a></li>
    </ul>
    <br/>
    <form:form id="inputForm" modelAttribute="user" action="${ctx}/user/save" method="post" class="form-horizontal">
        <form:hidden path="id"/>
        <sys:message content="${message}"/>
        <div class="control-group">
            <label class="control-label">登录名：</label>
            <div class="controls">
                <form:input path="name" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
                <span class="help-inline"><font color="red">*</font> </span>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">密码：</label>
            <div class="controls">
                <form:input path="password" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
                <span class="help-inline"><font color="red">*</font> </span>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">用户名：</label>
            <div class="controls">
                <form:input path="userName" htmlEscape="false" maxlength="50" class="input-xlarge "/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">联系方式：</label>
            <div class="controls">
                <form:input path="phone" htmlEscape="false" class="input-xlarge "/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">头像：</label>
            <div class="controls">
                <form:input path="imgurl" htmlEscape="false" maxlength="225" class="input-xlarge "/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">简介：</label>
            <div class="controls">
                <form:input path="introduction" htmlEscape="false" maxlength="225" class="input-xlarge "/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">备注：</label>
            <div class="controls">
                <form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="225" class="input-xxlarge "/>
            </div>
        </div>
        <div class="form-actions">
            <input id="btnSubmit" class="btn btn-primary" type="submit"
                   value="保 存"/>&nbsp;
            <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
        </div>
    </form:form>
</div>
</body>
</html>