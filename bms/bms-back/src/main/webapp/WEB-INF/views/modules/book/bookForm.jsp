<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/includes/taglib.jsp" %>
<html>
<head>
    <title>单表管理</title>
    <meta name="decorator" content="default"/>
    <%@include file="/WEB-INF/views/includes/head.jsp" %>
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
        <li><a href="${ctx}/book/">单表列表</a></li>
        <li class="active"><a href="${ctx}/book/form?id=${book.id}">单表${not empty book.id?'修改':'添加'}查看</a></li>
    </ul>
    <br/>
    <form:form id="inputForm" modelAttribute="book" action="${ctx}/book/save" method="post" class="form-horizontal">
        <form:hidden path="id"/>
        <sys:message content="${message}"/>
        <div class="control-group">
            <label class="control-label">书名：</label>
            <div class="controls">
                <form:input path="name" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
                <span class="help-inline"><font color="red">*</font> </span>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">作者：</label>
            <div class="controls">
                <form:input path="author" htmlEscape="false" maxlength="50" class="input-xlarge "/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">译者：</label>
            <div class="controls">
                <form:input path="interpreter" htmlEscape="false" maxlength="50" class="input-xlarge "/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">类别：</label>
            <div class="controls">
                <form:input path="type" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
                <span class="help-inline"><font color="red">*</font> </span>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">出版社：</label>
            <div class="controls">
                <form:input path="publish" htmlEscape="false" maxlength="50" class="input-xlarge "/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">价格：</label>
            <div class="controls">
                <form:input path="price" htmlEscape="false" class="input-xlarge "/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">总页数：</label>
            <div class="controls">
                <form:input path="count" htmlEscape="false" maxlength="11" class="input-xlarge "/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">出版日期：</label>
            <div class="controls">
                <form:input path="printDate" htmlEscape="false" class="input-xlarge "/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">封面图URL：</label>
            <div class="controls">
                <form:input path="imgurl" htmlEscape="false" class="input-xlarge "/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">书籍介绍文本路径：</label>
            <div class="controls">
                <form:input path="description" htmlEscape="false" class="input-xlarge "/>
            </div>
        </div>
        <div class="form-actions">
            <input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>
            <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
        </div>
    </form:form>
</div>
</body>
</html>