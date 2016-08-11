<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/includes/taglib.jsp" %>
<html>
<head>
    <title>单表管理</title>
    <meta name="decorator" content="default"/>
    <%@ include file="/WEB-INF/views/includes/head.jsp" %>
    <script type="text/javascript">
        $(document).ready(function () {

        });
        function page(n, s) {
            $("#pageNo").val(n);
            $("#pageSize").val(s);
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<div class="container">

    <ul class="nav nav-tabs">
        <li class="active"><a href="${ctx}/type/">单表列表</a></li>
        <li><a href="${ctx}/type/form">单表添加</a></li>
    </ul>
    <form:form id="searchForm" modelAttribute="type" action="${ctx}/type/" method="post" class="breadcrumb form-search">
        <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
        <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
        <ul class="ul-form">
            <li><label>名称：</label>
                <form:input path="name" htmlEscape="false" maxlength="50" class="input-medium"/>
            </li>
            <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
            <li class="clearfix"></li>
        </ul>
    </form:form>
    <sys:message content="${message}"/>
    <table id="contentTable" class="table table-striped table-bordered table-condensed">
        <thead>
        <tr>
            <th>名称</th>
            <th>更新日期</th>
            <th>备注</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="type">
            <tr>
                <td><a href="${ctx}/type/form?id=${type.id}">
                        ${type.name}
                </a></td>
                <td>
                    <fmt:formatDate value="${type.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
                <td>
                        ${type.remarks}
                </td>
                <td>
                    <a href="${ctx}/type/form?id=${type.id}">修改</a>
                    <a href="${ctx}/type/delete?id=${type.id}" onclick="return confirmx('确认要删除该单表吗？', this.href)">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagination">${page}</div>
</div>
</body>
</html>