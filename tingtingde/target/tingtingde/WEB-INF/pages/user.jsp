<%@ page import="com.w.util.DateAndString" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
    <link rel="stylesheet" href="resources/css/user.css" type="text/css"/>
    <script type="text/javascript" src="resources/js/index.js"></script>
    <script src="resources/js/jquery.js"></script>
    <script>
        $(function () {
            $(".send").click(function () {
                var reid = $("#resume").val();
                if(reid==null){
                    alert("你没有简历可投递，请创建");
                    return false;
                }
                reid=parseInt(reid);
                var riid=parseInt($(this).prev().val());
                $.ajax({
                    type:"post",
                    url:"sendResume",
                    data:{riid:riid,reid:reid},
                    success:function (obj) {//成功后回调函数
                        $("#str").text(obj);
                    },
                    error:function (obj) {

                    }
                })
            })
            $("a").mouseenter(function () {
                $(this).css("background-color","aquamarine");
            });
            $("a").mouseleave(function () {
                $(this).css("background-color","inherit");
            });
        });
    </script>
</head>
<body>
<div id="d">
    <div id="d4">
        <%--<img src="resources/images/1.gif" style="width: 1000px;height: 100px">--%>
    </div>
    <div id="d1">
        <div id="d11">
            <a href="login.jsp">&emsp;${user.uname}</a>
        </div>
        <div id="d12">
            <a href="user" style="color: red">投递简历&emsp;</a>
            <a href="myResume" >简历管理&emsp;</a>
            <a href="myInterview">面试管理&emsp;</a>
        </div>
    </div>
    <div id="d3" style="font-size: 24px">
        <div id="d31">
            <table >
                <tr style="background-color: #faebd7">
                    <th width="50px">ID</th>
                    <th width="120px">部门</th>
                    <th width="120px">职位</th>
                    <th width="100px">基本工资</th>
                    <th width="80px">人数</th>
                    <th width="200px">简介</th>
                    <th width="200px">发布时间</th>
                    <th width="100px">投递简历</th>
                </tr>
                <c:forEach items="${recruitInformations}" var="recruitInformation" varStatus="loop">
                    <tr >
                        <td>${recruitInformation.riid}</td>
                        <td>${recruitInformation.department.dname}</td>
                        <td>${recruitInformation.job.jname}</td>
                        <td>${recruitInformation.job.jsalary}</td>
                        <td>${recruitInformation.rinum}</td>
                        <td>${recruitInformation.riintro}</td>
                        <td>${DateAndString.dateToStringTime(recruitInformation.ridate)}</td>
                        <td><input type="hidden" name="riid" value="${recruitInformation.riid}" id="riid">
                            <input type="button" value="投递简历" class="send">
                        </td>
                    </tr>
                </c:forEach>
                <tr><td colspan="6">
                    <select name="reid" id="resume">
                        <c:forEach items="${resumes}" var="resume">
                        <option value="${resume.reid}">简历ID:${resume.reid}简历名:${resume.resumename}</option>
                        </c:forEach>
                </td>
                    <td colspan="2" id="str" style="color: red"></td>
                </tr>
            </table>
        </div>
        <div id="d32" >
            <a href="user?currentPage=${currentPage-1==0?currentPage:currentPage-1}">上一页</a>
            <a href="user?currentPage=${currentPage}">第${currentPage}页</a>
            共${totalPages}页
            <a href="user?currentPage=${currentPage+1>totalPages?currentPage:currentPage+1}">下一页</a>
            <form action="user" method="post">
                <input style="width: 30px" type="number" min="1" max="${totalPages}" value="${currentPage}" name="currentPage">
                <input type="submit" value="跳转">
            </form>
        </div>
    </div>
</div>
</body>
</html>
