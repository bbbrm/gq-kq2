<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/4
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="lib/layui/css/layui.css" media="all">
    <%-- 要使用xadmin来进行打开新窗口所以要引入xadmin相关的js --%>
    <script src="js/xadmin.js"></script>
    <link rel="stylesheet" href="css/xadmin.css">
    <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
</head>
<body>

<%--  lay-filter="test" 通过这个可以让行工具栏进行监听  --%>
<table class="layui-hide" id="demo" lay-filter="test"></table>

<%--写一个js 里面正常按照html标签去写, 根据id可以绑定toolbar 工具栏上 --%>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">

        <div class="layui-card-header ">
            <div class="layui-inline layui-show-xs-block">
                <input type="text" id="industryTitle" name="industryTitle"  placeholder="请输入部门名" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-inline layui-show-xs-block">
                <div class="layui-btn" id="search" lay-filter="search" data-type="reload"><i class="layui-icon">&#xe615;</i></div>
            </div>
        </div>


        <a class="layui-btn layui-btn-sm" lay-event="add" href="addClasses.jsp">添加</a>
        <%--<button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>--%>
        <%--<button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>--%>
        <%--<button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>--%>
    </div>



</script>

<%-- 可以在字段中去绑定js --%>
<script type="text/html" id="barDemo">
    <%-- lay-event 触发事件的关键字 --%>
    <%--<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>--%>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="lib/layui/layui.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

<script>
    layui.use('table', function () {
        var table = layui.table;
        // 自带jquery, 变成对象就行了
        var $ = layui.jquery;

        table.render({
            elem: '#demo'
            , url: 'classes/list'
            , toolbar: '#toolbarDemo'
            , title: '部门数据表'
            , cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field: 'id', title: 'Id',sort: true, width:80, fixed: 'left'}
                ,{field: 'staffCode', title: '员工编码', width:80}
                ,{field: 'designation', title: '名称', width:80}
                ,{field: 'morningShift', title: '早上上班时间', width:80}
                ,{field: 'afternoonTime', title: '下午下班时间', width:80}
                ,{field: 'remark', title: '备注', width:80}

                // toolbar
                , {fixed: 'right', title: '操作', toolbar: '#barDemo'}
            ]]
            , page: true
        });

        //头工具栏事件
        table.on('toolbar(test)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'getCheckData':
                    var data = checkStatus.data;
                    layer.alert(JSON.stringify(data));
                    break;
                case 'getCheckLength':
                    var data = checkStatus.data;
                    layer.msg('选中了：' + data.length + ' 个');
                    break;
                case 'isAll':
                    layer.msg(checkStatus.isAll ? '全选' : '未全选');
                    break;
            }
            ;
        });

        //监听行工具事件
        table.on('tool(test)', function (obj) {
            // obj.data 就是你所操作行的数据
            var data = obj.data;
            console.log(obj.data);
            // 工具栏的lay-event的值
            console.log(obj.event);
            //console.log(obj)
            if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    $.ajax({
                        type: 'get',
                        url : 'classes/deleteClasses',
                        data: {
                            id:obj.data.id
                        },
                        dataType: 'JSON',
                        success: function (data) {
                            if (data.code == 200) {
                                obj.del(); // 假删除
                                layer.msg('恭喜你删除成功');
                            } else {
                                layer.msg('删除失败');
                            }
                        }
                    })
                    layer.close(index);
                });
            } else if (obj.event === 'edit') {
                // open有四个参数, 标题, 路径, 宽,高
                xadmin.open('编辑', 'classes/load?id='+obj.data.id, 500, 500);
            }
        });
    });
</script>


</body>
</html>
