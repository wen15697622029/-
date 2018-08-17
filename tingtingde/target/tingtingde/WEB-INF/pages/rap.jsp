<%@ page import="com.w.util.DateAndString" %>
<%@ page import="com.w.model.Job" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
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
            $("#did").change(function () {
                var did=parseInt($(this).val());
                $.ajax({
                    type:"post",
                    url:"loadJob",
                    data:{did:did},
                    success:function (jobs) {//成功后回调函数
                        $("#jid").empty();
                        $("#jid").append("<option value='0'>部门</option>");
                        $(jobs).each(function (i) {
                            $("#jid").append("<option value="+jobs[i].jid+">"+jobs[i].jname+"</option>");
                        })
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
            <a href="admin" >员工管理&emsp;</a>
            <a href="pay" >薪资管理&emsp;</a>
            <a href="organizationalManagement" >组织管理&emsp;</a>
            <a href="attendanceInformation">考勤管理&emsp;</a>
            <a href="cultivate">培训管理&emsp;</a>
            <a href="ri">招聘信息&emsp;</a>
            <a href="r">招聘管理&emsp;</a>
            <a href="rap" style="color: red">奖惩管理&emsp;</a>
        </div>

    </div>
    <div id="d5">
        <form action="rap" method="post">
            <select name="did" id="did">
                <option value="0">部门</option>
                <c:forEach items="${departments}" var="department">
                    <option value="${department.did}"<c:if test="${department.did eq did}">
                        selected="selected"
                    </c:if>>${department.dname}</option>
                </c:forEach>
            </select>
            <select name="jid" id="jid">
                <option value="0">职位</option>
                <c:forEach items="${jobs}" var="job">
                    <option value="${job.jid}" <c:if test="${job.jid eq jid}">
                        selected="selected"
                    </c:if>>${job.jname}</option>
                </c:forEach>
            </select>
            <input type="date" name="radate" value="<%=DateAndString.dateToString((Date) request.getAttribute("radate"))%>">
            <input type="submit" value="确认"/>
        </form>
    </div>
    <div id="d3" style="font-size: 24px">
        <div id="d31">
            <table >
                <tr style="background-color: #faebd7">
                    <th width="100px">奖惩ID</th>
                    <th width="100px">员工ID</th>
                    <th width="300px">奖惩日期</th>
                    <th width="200px">奖惩金额</th>
                    <th width="300px">原因</th>
                </tr>
                <c:forEach items="${raps}" var="rap" varStatus="loop">
                    <tr >
                        <td>${rap.raid}</td>
                        <td>${rap.staff.sid}</td>
                        <td>${DateAndString.dateToString(rap.radate)}</td>
                        <td>${rap.ramoney}</td>
                        <td>${rap.raexplain}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="d32" >
            <a href="rap?radate=<%=DateAndString.dateToString((Date) request.getAttribute("radate"))%>&did=${did}&jid=${jid}&currentPage=${currentPage-1==0?currentPage:currentPage-1}">上一页</a>
            <a href="rap?radate=<%=DateAndString.dateToString((Date) request.getAttribute("radate"))%>&did=${did}&jid=${jid}&currentPage=${currentPage}">第${currentPage}页</a>
            共${totalPages}页
            <a href="rap?radate=<%=DateAndString.dateToString((Date) request.getAttribute("radate"))%>&did=${did}&jid=${jid}&currentPage=${currentPage+1>totalPages?currentPage:currentPage+1}">下一页</a>
            <form action="rap?radate=<%=DateAndString.dateToString((Date) request.getAttribute("radate"))%>&did=${did}&jid=${jid}" method="post">
                <input style="width: 30px" type="number" min="1" max="${totalPages}" value="${currentPage}" name="currentPage">
                <input type="submit" value="跳转">
            </form>
        </div>
    </div>
</div>
</body>
</html>
