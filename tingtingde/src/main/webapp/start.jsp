<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/26
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
    <script src="resources/js/jquery.js"></script>
    <script>
        $(function () {
            $(".a1").click(function(){
                alert("使用前请登录");
            });
        })
    </script>
</head>
<body>
<div id="d">
    <div id="d1">
        <div id="d11">
            <a href="login.jsp">&emsp;亲，请登录</a>
            <a href="register.jsp">&emsp;免费注册</a>
        </div>
        <div id="d12">
            <a href="staffLogin.jsp" >员工登录&emsp;</a>
            <a href="adminLogin.jsp">管理员登录&emsp;</a>
        </div>
    </div>
    <div id="d3" style="font-size: 24px">
        <div id="d31">
            <table >
                <tr style="background-color: #faebd7">
                    <th width="40px">ID</th>
                    <th width="80px">部门</th>
                    <th width="120px">职位</th>
                    <th width="100px">基本工资</th>
                    <th width="60px">人数</th>
                    <th width="150px">简介</th>
                    <th width="200px">发布时间</th>
                    <th width="80px">投递简历</th>
                </tr>
                <c:forEach items="${recruitInformations}" var="recruitInformation" varStatus="loop">
                    <tr >
                        <td>${recruitInformation.riid}</td>
                        <td>${recruitInformation.department.dname}</td>
                        <td>${recruitInformation.job.jname}</td>
                        <td>${recruitInformation.job.jsalary}</td>
                        <td>${recruitInformation.riNum}</td>
                        <td>${recruitInformation.riIntro}</td>
                        <td>${recruitInformation.riDate}</td>
                        <td><input style="width: 80px" class="a1" type="button" value="投递简历"></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="d32" >
            <a href="index?currentPage=${currentPage-1==0?currentPage:currentPage-1}">上一页</a>
            <a href="index?currentPage=${currentPage}">第${currentPage}页</a>
            共${totalPages}页
            <a href="index?currentPage=${currentPage+1>totalPages?currentPage:currentPage+1}">下一页</a>
            <form action="index" method="post">
                <input style="width: 30px" type="number" min="1" max="${totalPages}" value="${currentPage}" name="currentPage">
                <input type="submit" value="跳转">
            </form>
        </div>
    </div>
</div>
</body>
</html>
