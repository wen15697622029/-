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
    <link rel="stylesheet" href="resources/css/admin.css" type="text/css"/>
    <script type="text/javascript" src="resources/js/index.js"></script>
    <script src="resources/js/jquery.js"></script>
    <script>
        $(function () {
            $(".hire").click(function () {
                var iid=parseInt($(this).prev().val());
                if (!confirm("确认录用")){
                    return false;
                }
                $.ajax({
                    type:"post",
                    url:"hire",
                    data:{iid:iid},
                    success:function (obj) {//成功后回调函数
                        alert(obj);
                        location.reload(true);
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
        <a href="interviewManage?istate=0&riid=${riid}"
                <c:if test="${istate eq 0}">
                    style="color: red"
                </c:if>>邀请中&emsp;</a>
        <a href="interviewManage?istate=1&riid=${riid}"
                <c:if test="${istate eq 1}">
                    style="color: red"
                </c:if>>参加&emsp;</a>
        <a href="interviewManage?istate=2&riid=${riid}"
                <c:if test="${istate eq 2}">
                    style="color: red"
                </c:if>>拒绝&emsp;</a>
    </div>
    <div id="d3" style="font-size: 24px">
        <div id="d31">
            <table >
                <tr style="background-color: #faebd7">
                    <th width="30px">ID</th>
                    <th width="80px">部门</th>
                    <th width="80px">职位</th>
                    <th width="80px">底薪</th>
                    <th width="60px">人数</th>
                    <th width="150px">招聘简介</th>
                    <th width="200px">面试时间</th>
                    <th width="200px">面试地址</th>
                    <th width="80px">面试官</th>
                    <c:if test="${istate eq 1}">
                        <th width="80px">录用</th>
                    </c:if>
                </tr>
                <c:forEach items="${interviews}" var="interview" varStatus="loop">
                    <tr >
                        <td>${interview.iid}</td>
                        <td>${interview.recruit_information.department.dname}</td>
                        <td>${interview.recruit_information.job.jname}</td>
                        <td>${interview.recruit_information.job.jsalary}</td>
                        <td>${interview.recruit_information.rinum}</td>
                        <td>${interview.recruit_information.riintro}</td>
                        <td>${DateAndString.dateToStringTime(interview.idate)}</td>
                        <td>${interview.iaddress}</td>
                        <td>${interview.staff.sname}</td>
                        <c:if test="${istate eq 1}">
                            <td><input type="hidden" name="iid" value="${interview.iid}" id="iid">
                                <input type="button" value="录用" class="hire">
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="d32" >
            <a href="interviewManage?istate=${istate}&riid=${riid}&currentPage=${currentPage-1==0?currentPage:currentPage-1}">上一页</a>
            <a href="interviewManage?istate=${istate}&riid=${riid}&currentPage=${currentPage}">第${currentPage}页</a>
            共${totalPages}页
            <a href="interviewManage?istate=${istate}&riid=${riid}&currentPage=${currentPage+1>totalPages?currentPage:currentPage+1}">下一页</a>
            <form action="interviewManage?istate=${istate}&riid=${riid}" method="post">
                <input style="width: 30px" type="number" min="1" max="${totalPages}" value="${currentPage}" name="currentPage">
                <input type="submit" value="跳转">
            </form>
        </div>
    </div>
</div>
</body>
</html>
