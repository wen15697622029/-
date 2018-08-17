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
            <a href="attendanceInformation" style="color: red">考勤管理&emsp;</a>
            <a href="cultivate">培训管理&emsp;</a>
            <a href="ri">招聘信息&emsp;</a>
            <a href="r">招聘管理&emsp;</a>
            <a href="rap">奖惩管理&emsp;</a>
        </div>
    </div>
    <div id="d5">
        <form action="staffAttendance" method="post">
            <input type="hidden" name="sid" value="${sid}"/>
            <input type="date" name="adate" value="<%=DateAndString.dateToString((Date) request.getAttribute("adate"))%>">
            <input type="submit" value="确认"/>
        </form>
    </div>
    <div id="d3" style="font-size: 24px">
        <div id="d31">
            <table >
                <tr style="background-color: #faebd7">
                    <th width="100px">考勤ID</th>
                    <th width="200px">考勤日期</th>
                    <th width="200px">上班时间</th>
                    <th width="200px">下班时间</th>
                    <th width="300px">状态</th>
                </tr>
                <c:forEach items="${attendances}" var="attendance" varStatus="loop">
                    <tr >
                        <td>${attendance.aid}</td>
                        <td>${DateAndString.dateToString(attendance.adate)}</td>
                        <td>${DateAndString.dateToStringTime(attendance.ontime)}</td>
                        <td>${attendance.offtime==null?null:DateAndString.dateToStringTime(attendance.offtime)}</td>
                        <td>${attendance.astate==0?"上班中":attendance.astate==1?"正常":attendance.astate==2?"加班"
                                :attendance.astate==3?"早退":attendance.astate==4?"迟到":attendance.astate==5?"迟到加班":
                                attendance.astate==6?"迟到早退":attendance.astate==7?"旷工":"旷工加班"}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="d32" >
            <a href="staffAttendance?adate=<%=DateAndString.dateToString((Date) request.getAttribute("adate"))%>&sid=${sid}&currentPage=${currentPage-1==0?currentPage:currentPage-1}">上一页</a>
            <a href="staffAttendance?adate=<%=DateAndString.dateToString((Date) request.getAttribute("adate"))%>&sid=${sid}&currentPage=${currentPage}">第${currentPage}页</a>
            共${totalPages}页
            <a href="staffAttendance?adate=<%=DateAndString.dateToString((Date) request.getAttribute("adate"))%>&sid=${sid}&currentPage=${currentPage+1>totalPages?currentPage:currentPage+1}">下一页</a>
            <form action="staffAttendance?adate=<%=DateAndString.dateToString((Date) request.getAttribute("adate"))%>&sid=${sid}" method="post">
                <input style="width: 30px" type="number" min="1" max="${totalPages}" value="${currentPage}" name="currentPage">
                <input type="submit" value="跳转">
            </form>
        </div>
    </div>
</div>
</body>
</html>
