<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        function deleteUser(id){
            //用户安全提示
            if(confirm("您确定要删除吗？")){
                //访问路径
                location.href="${pageContext.request.contextPath}/user/delUser?id="+id;
            }
        }

        window.onload = function(){
            //给删除选中按钮添加单击事件
            document.getElementById("delSelected").onclick = function(){
                if(confirm("您确定要删除选中条目吗？")){

                    var flag = false;
                    //判断是否有选中条目
                    var cbs = document.getElementsByName("uid");
                    for (var i = 0; i < cbs.length; i++) {
                        if(cbs[i].checked){
                            //有一个条目选中了
                            flag = true;
                            break;
                        }
                    }

                    if (flag){
                        if (confirm("确定删除？？?")){
                            document.getElementById("form").submit();
                        }
                    }else {
                        alert("请至少选择一条信息!")
                    }document.getElementById("form").submit();
                }

            }

        }

    </script>
</head>
<body>

<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="float: left;">

        <form class="form-inline" action="${pageContext.request.contextPath}/user/findUserByCondition" method="post">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" class="form-control" name="name"  value="${condition.name}" id="exampleInputName2" >
            </div>
            <div class="form-group">
                <label for="exampleInputName3">籍贯</label>
                <input type="text" class="form-control"  name="address" value="${condition.address}" id="exampleInputName3" >
            </div>

            <div class="form-group">
                <label for="exampleInputEmail2">邮箱</label>
                <input type="email" class="form-control"  name="email" value="${condition.email}" id="exampleInputEmail2"  >
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>

    </div>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th> </th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pageBean.list}" var="user">
            <tr>
                <td><input type="checkbox" name="uid" value="${user.id}"></td>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.qq}</td>
                <td>${user.email}</td>
                <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/user/toUpdate?id=${user.id}">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.id});">删除</a></td>
            </tr>
            </tr>
        </c:forEach>


        <tr>
            <td colspan="9" align="center"><a class="btn btn-primary" href="${pageContext.request.contextPath}/path/pathname/add">添加联系人</a></td>
        </tr>
    </table>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${pageBean.pageNum > 1}">
                <li>
                    <a href="${pageContext.request.contextPath}/user/findUserByCondition?pageNum=${pageBean.pageNum - 1}&pageSize=5&name=${condition.name}&address=${condition.address}&email=${condition.email}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:if>


            <c:forEach begin="1" end="${pageBean.counts}" var="i">
                <li><a href="${pageContext.request.contextPath}/user/findUserByCondition?pageNum=${i}&pageSize=5&name=${condition.name}&address=${condition.address}&email=${condition.email}">${i}</a></li>
            </c:forEach>

            <c:if test="${pageBean.pageNum < pageBean.counts}">
                <li>
                    <a href="${pageContext.request.contextPath}/user/findUserByCondition?pageNum=${pageBean.pageNum + 1}&pageSize=5&name=${condition.name}&address=${condition.address}&email=${condition.email}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>

                </li>
            </c:if>
            <span style="font-size: 25px;margin-left: 5px;">
                    共  ${pageBean.counts} 条记录，共 ${pageBean.pages}页
                </span>

        </ul>
    </nav>
</div>
</body>
</html>
