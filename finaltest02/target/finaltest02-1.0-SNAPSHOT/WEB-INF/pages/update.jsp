<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!-- HTML5文档-->
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>修改用户</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<script>
    $(function () {
        $.ajax({
            dataType:"json",
            type:'post',
            url:'${pageContext.request.contextPath}/city/findAll',
            success:function (data) {
                for(var i=0;i<data.length;i++){
                    $("#address").append("<option value='"+data[i].city+"'>"+data[i].city+"</option>")
                }
            }
        })
    })
</script>
<body>
<div class="container">
    <center><h3>修改联系人页面</h3></center>
    <form action="${pageContext.request.contextPath}/user/updateUser" method="post">
        <div class="form-group">
            <input type="hidden" name="id" value="${user.id}">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" value =${user.name}>
        </div>
        <div class="form-group">
            <label for="password">密码：</label>
            <input type="text" class="form-control" id="password" name="password" value=${user.password}>
        </div>
        <div class="form-group">
            <label for="gender">性别：</label>
            <c:if test="${user.gender == '男'}">
            <input type="radio" name="gender" value=${user.gender} checked="checked" id="gender"/>男
            <input type="radio" name="gender" value="女"/>女
        </div>
        </c:if>

        <c:if test="${user.gender == '女'}">
        <input type="radio" name="gender" value="男"  id="gender"/>男
        <input type="radio" name="gender" value=${user.gender}  checked="checked"/>女
</div>
</c:if>
        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" value=${user.age}>
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" class="form-control" id="address">
                <option selected>${user.address}</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" id="qq" name="qq" value=${user.qq}/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" id="email" name="email" value=${user.email}/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回" />
        </div>
    </form>
</div>
</body>
</html>