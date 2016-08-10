<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/includes/taglib.jsp" %>
<html>
<head>
    <title>注册</title>
    <%@include file="/WEB-INF/views/includes/head.jsp" %>
    <style type="text/css">
        <%@include file="/WEB-INF/views/includes/loginstyle.css"%>
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12" style="margin-top: 100px">
            <form:form id="loginForm"  modelAttribute="user" ction="${ctx}/addUser" method="post">
                <h4 align="center">欢迎注册</h4>
                <form:hidden path="id"/>
                <div class="form-group">
                    <label class="input-lable">
                        登录名
                    </label>
                    <form:input path="loginName" htmlEscape="false" maxlength="50" class="input-xlarge "/>
                </div>
                <div class="form-group">
                    <label class="input-lable">
                        密码
                    </label>
                    <form:input path="password" htmlEscape="false" maxlength="50" class="input-xlarge "/>
                </div>
                <div>
                    <input class="btn btn-large btn-primary" type="submit" value="注 册"/>&nbsp;&nbsp;
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
