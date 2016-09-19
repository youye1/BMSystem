<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/includes/taglib.jsp" %>
<%@ taglib prefix="sitemesh"
           uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<html style="overflow-x:auto;overflow-y:auto;">
<head>
    <title><sitemesh:title/> - Powered By Youye</title>
    <%@include file="/WEB-INF/views/includes/head.jsp" %>
    <sitemesh:head/>
    <style type="text/css">
        .head {
            width: 100%;
            height: 70px;
            border-top: 2px solid #00B2EE;
            border-bottom: 2px solid #1E90FF;
            background: #00B2EE;
        }

        .head h3 {
            font-size: 28px;
            color: #fff;
            margin-left: 30px;
            font-family: 微软雅黑;
        }
        .head label{
            height: 70px;
            width: auto;
            font-size: 26px;
            font-weight: bold;
            color: #fff;
            margin-top: 20px;
            text-align: center;
            font-family: 新宋体;
        }
        .head div{
            width: auto;
            height:100%;
            float: left;
            padding-left: 20px;
        }
        #tags{
            width: auto;
            height: auto;
            margin-right: 10px;
        }
        #tags div{
            width: auto;
            height: 50px;
            border-bottom: 1px solid #B7B7B7;
            background-color: #00B2EE;
        }
    </style>
</head>
<body>
<div class="head">
    <div style="float:left;">
        <h3>图书管理系统</h3>
    </div>
    <div>
        <label>用户管理</label>
    </div>
    <div>
        <label>图书管理</label>
    </div>
</div>
<div style="padding-top: 15px">
    <div id="tags" class="span2" style="float: left">

        <ul>
            <li><a href="${ctx}/user/list">用户列表</a></li>
            <li><a href="${ctx}/book/list">书籍列表</a></li>
            <li><a href="${ctx}/type/list">类别列表</a></li>
        </ul>

    </div>
    <div class="control-group" style="float: left">
        <sitemesh:body/>
    </div>
</div>
<script type="text/javascript">

</script>
</body>
</html>