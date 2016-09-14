<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2016/9/6
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/includes/taglib.jsp"%>
<html>
<head>
    <title>测试</title>
    <%@include file="/WEB-INF/views/includes/head.jsp"%>
    <script src="${ctxStatic}/ichart/ichart.1.2.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        var data = [
            {name : 'H',value : 7,color:'#a5c2d5'},
            {name : 'E',value : 5,color:'#cbab4f'},
            {name : 'L',value : 12,color:'#76a871'},
            {name : 'L',value : 12,color:'#76a871'},
            {name : 'O',value : 15,color:'#a56f8f'},
            {name : 'W',value : 13,color:'#c12c44'},
            {name : 'O',value : 15,color:'#a56f8f'},
            {name : 'R',value : 18,color:'#9f7961'},
            {name : 'L',value : 12,color:'#76a871'},
            {name : 'D',value : 4,color:'#6f83a5'}
        ];
        $(function(){
            var chart = new iChart.Column2D({
                render : 'canvasDiv',//渲染的Dom目标,canvasDiv为Dom的ID
                data: data,//绑定数据
                title : 'Hello World\'s Height In Alphabet',//设置标题
                width : 800,//设置宽度，默认单位为px
                height : 400,//设置高度，默认单位为px
                shadow:true,//激活阴影
                shadow_color:'#c7c7c7',//设置阴影颜色
                coordinate:{//配置自定义坐标轴
                    scale:[{//配置自定义值轴
                        position:'left',//配置左值轴
                        start_scale:0,//设置开始刻度为0
                        end_scale:26,//设置结束刻度为26
                        scale_space:2,//设置刻度间距
                        listeners:{//配置事件
                            parseText:function(t,x,y){//设置解析值轴文本
                                return {text:t+" cm"}
                            }
                        }
                    }]
                }
            });
            //调用绘图方法开始绘图
            chart.draw();
        });
    </script>
</head>
<body>
<div id='canvasDiv'></div>
</body>
</html>
