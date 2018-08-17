<%@ page import="java.util.Date" %>
<%@ page import="com.w.model.Resume" %>
<%@ page import="java.util.List" %>
<%@ page import="com.w.util.DateAndString" %><%--
To change this template use File | Settings | File Templates.
--%>
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
    <link rel="stylesheet" href="resources/css/myResume.css" type="text/css"/>
    <script type="text/javascript" src="resources/js/index.js"></script>
    <script src="resources/js/jquery.js"></script>
    <script>
        $(function () {
            $("#del").click(function () {
                return confirm("是否删除简历"+$("#resumename").text());
            });
            $("a").mouseenter(function () {
                $(this).css("background-color","aquamarine");
            });
            $("a").mouseleave(function () {
                $(this).css("background-color","inherit");
            });
        })
    </script>
</head>
<body>
<div id="d">
    <div id="d4">
        <%--<img src="resources/images/1.gif" style="width: 1000px;height: 83px">--%>
    </div>
    <div id="d1">
        <div id="d11">
            <a href="login.jsp">&emsp;${user.uname}</a>
        </div>
        <div id="d12">
            <a href="user" >简历投递&emsp;</a>
            <a href="myResume" STYLE="color: red">简历管理&emsp;</a>
            <a href="myInterview">面试管理&emsp;</a>
        </div>
    </div>
    <div id="d3" style="font-size: 24px">
        <div id="d31">
            <a href="addresume">添加&emsp;</a>
            <c:forEach items="${resumes}" var="resume" varStatus="loop">
                <a href="updateresume?reid=${resume.reid}">修改&emsp;</a><a href="deleteResume?reid=${resume.reid}" id="del">删除&emsp;</a>
                <table >
                    <tr ><th colspan="4" id="resumename" width="1000px" style="text-align: center">
                            ${resume.resumename}</th></tr>
                    <tr><td colspan="4" width="1000px" style="background: rgba(126, 87, 100, 0.2)">个人信息</td></tr>
                    <tr>
                        <td width="15%">姓名</td><td width="35%">${resume.rename}</td>
                        <td width="15%">性别</td><td width="35%">${resume.resex}</td>
                    </tr>
                    <tr>
                        <td width="15%">身份证号</td><td width="35%">${resume.reidcardno}</td>
                        <td width="15%">出生时间</td><td width="35%">${DateAndString.dateToString(resume.rebirthday)}</td>
                    </tr>
                    <tr><td colspan="4" width="1000px" style="background: rgba(126, 87, 100, 0.2)">教育情况</td></tr>
                    <tr>
                        <td width="15%">学历</td><td width="35%">${resume.reeducation}</td>
                        <td width="15%">毕业院校</td><td width="35%">${resume.recollege}</td>
                    </tr>
                    <tr>
                        <td width="15%">专业</td><td width="35%">${resume.remajor}</td>
                        <td width="15%">毕业时间</td><td width="35%">${DateAndString.dateToString(resume.regraduate)}</td>
                    </tr>
                    <tr><td colspan="4" width="1000px" style="background: rgba(126, 87, 100, 0.2)">联系方式</td></tr>
                    <tr>
                        <td width="15%">手机</td><td width="35%">${resume.rephone}</td>
                        <td width="15%">电子邮箱</td><td width="35%">${resume.reemail}</td>
                    </tr>
                    <tr>
                        <td width="15%">地址</td><td width="35%">${resume.readdress}</td>
                        <td width="15%">邮编</td><td width="35%">${resume.repost}</td>
                    </tr>
                    <tr><td colspan="4" width="1000px" style="background: rgba(126, 87, 100, 0.2)">简介</td></tr>
                    <tr>
                        <td colspan="4" width="1000px">${resume.reintro}</td>
                    </tr>
                </table>
            </c:forEach>
        </div>
        <div id="d32" >
            <a href="myResume?currentPage=${currentPage-1==0?currentPage:currentPage-1}">上一页</a>
            <a href="myResume?currentPage=${currentPage}">第${currentPage}页</a>
            共${totalPages}页
            <a href="myResume?currentPage=${currentPage+1>totalPages?currentPage:currentPage+1}">下一页</a>
            <form action="myResume" method="post">
                <input style="width: 30px;line-height: 20px;font-size: 20px" type="number" min="1" max="${totalPages}" value="${currentPage}" name="currentPage">
                <input type="submit" value="跳转" style="line-height: 20px;font-size: 20px">
            </form>
        </div>
    </div>
</div>
</body>
</html>
