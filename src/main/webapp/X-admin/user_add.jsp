<%--
  Created by IntelliJ IDEA.
  User: 白
  Date: 2019/9/2
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <title>Title</title>
    <script src="/X-admin/lib/layui/layui.js"></script>
    <link rel="stylesheet" href="/X-admin/lib/layui/css/layui.css" media="all">
    <script src="/X-admin/js/xadmin.js"></script>
</head>
<body>
<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">用户ID</label>
        <div class="layui-input-block">
            <input type="text" name="user_id"  placeholder="请输入用户" autocomplete="off" class="layui-input" value="${user.userName}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input type="text" name="user_name"  placeholder="请输入用户" autocomplete="off" class="layui-input" value="${user.userName}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input type="text" name="sex"  placeholder="请输入性别" autocomplete="off" class="layui-input" value="${user.passWord}">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script>
    //Demo
    // 用layui来监听表单的提交
    layui.use('form', function(){
        var form = layui.form;
        // JQ
        var $ = layui.jquery;

        //监听提交
        form.on('submit(formDemo)', function(data){

            // data.field 其实就是我们表单的所有数据,封装成的一个对象
            // 想要获取对应的输入框的内容的话, 你直接去这个对象中根据name标签来获取对应的属性就行了
            // layer.msg(JSON.stringify(data.field));
            $.ajax({
                type: 'post',
                url: 'updateUser',
                data: {
                    user_id:data.field.user_id,
                    user_name: data.field.user_name,
                    sex: data.field.sex
                },
                dataType: 'json',
                success: function (data) {
                    if (data.code == 200) {
                        // 如果更新成功了最好把这个窗口给关了
                        xadmin.close();
                        // 我如果只有关闭, 那么父窗口的数据 并不会更新
                        // 重新加载父窗口数据
                        xadmin.father_reload();
                    }else {
                        layer.msg('不好意思更新失败了');
                    }
                }
            })

            return false;
        });
    });
</script>
</body>
</html>
