<%@ page import="com.w.util.DateAndString" %>
<%--
  Created by IntelliJ IDEA.
  User: destiny
  Date: 2018/6/24/0024
  Time: 16:26
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
    <link rel="stylesheet" href="resources/css/check.css" type="text/css"/>
    <script type="text/javascript" src="resources/js/index.js"></script>
    <script src="resources/js/jquery.js"></script>
    <script>
        $(function () {
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
            <a href="adminLogin.jsp">&emsp;${admin.adname}</a>
        </div>
        <div id="d12">
            <a href="admin">员工管理&emsp;</a>
            <a href="pay" >薪资管理&emsp;</a>
            <a href="organizationalManagement" >组织管理&emsp;</a>
            <a href="attendanceInformation">考勤管理&emsp;</a>
            <a href="cultivate">培训管理&emsp;</a>
            <a href="ri">招聘信息&emsp;</a>
            <a href="r" style="color: red">招聘管理&emsp;</a>
            <a href="rap">奖惩管理&emsp;</a>
        </div>
    </div>
    <div id="d5">
        <a href="check?rstate=0&riid=${riid}"
                <c:if test="${rstate eq 0}">
                    style="color: red"
                </c:if>>未读&emsp;</a>
        <a href="check?rstate=1&riid=${riid}"
                <c:if test="${rstate eq 1}">
                    style="color: red"
                </c:if>>已读&emsp;</a>
        <a href="check?rstate=2&riid=${riid}"
                <c:if test="${rstate eq 2}">
                    style="color: red"
                </c:if>>面试&emsp;</a>
        <a href="check?rstate=3&riid=${riid}"
                <c:if test="${rstate eq 3}">
                    style="color: red"
                </c:if>>拒绝&emsp;</a>
    </div>
    <div id="d3" style="font-size: 24px">
        <div id="d31">
            <c:if test="${!empty recruitInformation}" >
        <table >
                <tr style="background-color: #faebd7">
                    <th width="80px">ID</th>
                    <th width="140px">部门</th>
                    <th width="140px">职位</th>
                    <th width="120px">基本工资</th>
                    <th width="120px">人数</th>
                    <th width="200px">简介</th>
                    <th width="200px">发布时间</th>
                </tr>
                <tr >
                        <td>${recruitInformation.riid}</td>
                        <td>${recruitInformation.department.dname}</td>
                        <td>${recruitInformation.job.jname}</td>
                        <td>${recruitInformation.job.jsalary}</td>
                        <td>${recruitInformation.rinum}</td>
                        <td>${recruitInformation.riintro}</td>
                        <td>${DateAndString.dateToStringTime(recruitInformation.ridate)}</td>
                    </tr>
            </table>
            </c:if>
            <c:forEach items="${recruits}" var="recruit" varStatus="loop">
                <c:if test="${rstate eq 0||rstate eq 1}">
                    <a href="interview?rid=${recruit.rid}">面试&emsp;</a><a href="refuse?rid=${recruit.rid}&riid=${recruitInformation.riid}" id="del">拒绝&emsp;</a>
                </c:if>

                <table >
                    <tr><th colspan="4" id="resumename" width="1000px" style="text-align: center">
                            ${recruit.resume.resumename}</th></tr>
                    <tr><td colspan="4" width="1000px" style="background: rgba(126, 87, 100, 0.2)">个人信息</td></tr>
                    <tr>
                        <td width="15%">姓名</td><td width="35%">${recruit.resume.rename}</td>
                        <td width="15%">性别</td><td width="35%">${recruit.resume.resex}</td>
                    </tr>
                    <tr>
                        <td width="15%">身份证号</td><td width="35%">${recruit.resume.reidcardno}</td>
                        <td width="15%">出生时间</td><td width="35%">${DateAndString.dateToString(recruit.resume.rebirthday)}</td>
                    </tr>
                    <tr><td colspan="4" width="1000px" style="background: rgba(126, 87, 100, 0.2)">教育情况</td></tr>
                    <tr>
                        <td width="15%">学历</td><td width="35%">${recruit.resume.reeducation}</td>
                        <td width="15%">毕业院校</td><td width="35%">${recruit.resume.recollege}</td>
                    </tr>
                    <tr>
                        <td width="15%">专业</td><td width="35%">${recruit.resume.remajor}</td>
                        <td width="15%">毕业时间</td><td width="35%">${DateAndString.dateToString(recruit.resume.regraduate)}</td>
                    </tr>
                    <tr><td colspan="4" width="1000px" style="background: rgba(126, 87, 100, 0.2)">联系方式</td></tr>
                    <tr>
                        <td width="15%">手机</td><td width="35%">${recruit.resume.rephone}</td>
                        <td width="15%">电子邮箱</td><td width="35%">${recruit.resume.reemail}</td>
                    </tr>
                    <tr>
                        <td width="15%">地址</td><td width="35%">${recruit.resume.readdress}</td>
                        <td width="15%">邮编</td><td width="35%">${recruit.resume.repost}</td>
                    </tr>
                    <tr><td colspan="4" width="1000px" style="background: rgba(126, 87, 100, 0.2)">简介</td></tr>
                    <tr>
                        <td colspan="4" >${recruit.resume.reintro}</td>
                    </tr>
                </table>
            </c:forEach>
        </div>
        <div id="d32" >
            <a href="check?rstate=${rstate}&riid=${riid}&currentPage=${currentPage-1==0?currentPage:currentPage-1}">上一页</a>
            <a href="check?rstate=${rstate}&riid=${riid}&currentPage=${currentPage}">第${currentPage}页</a>
            共${totalPages}页
            <a href="check?rstate=${rstate}&riid=${riid}&currentPage=${currentPage+1>totalPages?currentPage:currentPage+1}">下一页</a>
            <form action="check?rstate=${rstate}&riid=${riid}" method="post">
                <input style="width: 30px" type="number" min="1" max="${totalPages}" value="${currentPage}" name="currentPage">
                <input type="submit" value="跳转">
            </form>
        </div>
    </div>
</div>
</body>
</html>
