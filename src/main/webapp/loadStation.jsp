<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/2
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <script src="/js/jquery-1.11.3.js"></script>
    <script src="/layui/layui.js"></script>
    <script src="../js/xadmin.js"></script>
</head>
<body>
<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">ID</label>
        <div class="layui-input-block">

            <input type="text" name="id" readonly="true"
                   required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input" value="${list.id}" >
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">员工编码</label>
        <div class="layui-input-block">
            <input type="text" name="staffCode" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input" value="${list.staffCode}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">岗位名称</label>
        <div class="layui-input-block">
            <input type="text" name="post" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input" value="${list.post}" >
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">所在部门</label>
        <div class="layui-input-block">
            <input type="text" name="department"  required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input" value="${list.department}" >
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">直接上级</label>
        <div class="layui-input-block">
            <input type="text" name="superior"  required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input" value="${list.superior}" >
        </div>
    </div>

    <%--<div class="layui-form-item">--%>
        <%--<label class="layui-form-label">岗位类别</label>--%>
        <%--<div class="layui-input-block">--%>
            <%--<input type="text" name="jobCategory" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input" value="${list.jobCategory}" >--%>
        <%--</div>--%>
    <%--</div>--%>


    <div class="layui-form-item">
        <label class="layui-form-label">岗位类别</label>
        <div class="layui-input-block">
            <select name="jobCategory" lay-verify="required" >
                <option value=""></option>
                <option value="${list.jobCategory}">管理类</option>
                <option value="${list.jobCategory}">文职类</option>
                <option value="${list.jobCategory}">技术类</option>

            </select>
        </div>
    </div>


    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">岗位职责描述</label>
        <div class="layui-input-block">
            <textarea name="describe" placeholder="请输入内容" class="layui-textarea" value="${list.describe}"></textarea>
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
            alert()
            // data.field 其实就是我们表单的所有数据,封装成的一个对象
            // 想要获取对应的输入框的内容的话, 你直接去这个对象中根据name标签来获取对应的属性就行了
            // layer.msg(JSON.stringify(data.field));
            $.ajax({
                type: 'post',
                url: 'updatestation',
                data: {
                    id: data.field.id,
                    staffCode: data.field.staffCode,
                    post: data.field.post,
                    department: data.field.department,
                    superior: data.field.superior,
                    jobCategory: data.field.jobCategory,
                    describe: data.field.describe,


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
