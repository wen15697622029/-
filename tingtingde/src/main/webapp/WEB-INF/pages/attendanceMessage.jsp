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
    <link rel="stylesheet" href="resources/css/rapMessage.css" type="text/css"/>
    <script type="text/javascript" src="resources/js/index.js"></script>
    <script src="resources/js/jquery.js"></script>
    <script>
        $(function () {
            $("#on").click(function () {
                alert(1111)
                $.ajax({
                    type:"post",
                    url:"on",
                    data:{},
                    success:function (obj) {//成功后回调函数
                        alert(obj);
                        location.reload(true);
                    },
                    error:function (obj) {

                    }
                })
            })
            $("#off").click(function () {
                $.ajax({
                    type:"post",
                    url:"off",
                    data:{},
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
            <a href="staffDetail">&emsp;${staff.susername}</a>
        </div>
        <div id="d12">
            <a href="staff">员工信息&emsp;</a>
            <a href="cultivateMessage" >培训通知&emsp;</a>
            <a href="rapMessage">奖惩&emsp;</a>
            <a href="attendanceMessage" style="color:red">考勤&emsp;</a>
            <a href="payMessage">薪资&emsp;</a>
        </div>
    </div>
    <div id="d5">
        <input type="button" value="上班打卡" id="on"/>
        <input type="button" value="下班打卡" id="off"/>
        <form action="attendanceMessage" method="post" style="display: inline">
            <input type="date" name="adate" value="<%=DateAndString.dateToString(new Date())%>">
            <input type="submit" value="确认"/>
        </form>
    </div>
    <div id="d3" style="font-size: 24px">
        <div id="d31">
            <table >
                <tr style="background-color: #faebd7">
                    <th width="100px">考勤ID</th>
                    <th width="250px">考勤日期</th>
                    <th width="250px">上班时间</th>
                    <th width="250px">下班时间</th>
                    <th width="150px">状态</th>
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
            <a href="attendanceMessage?adate=<%=DateAndString.dateToString((Date) request.getAttribute("adate"))%>&currentPage=${currentPage-1==0?currentPage:currentPage-1}">上一页</a>
            <a href="attendanceMessage?adate=<%=DateAndString.dateToString((Date) request.getAttribute("adate"))%>&currentPage=${currentPage}">第${currentPage}页</a>
            共${totalPages}页
            <a href="attendanceMessage?adate=<%=DateAndString.dateToString((Date) request.getAttribute("adate"))%>&currentPage=${currentPage+1>totalPages?currentPage:currentPage+1}">下一页</a>
            <form action="attendanceMessage&adate=<%=DateAndString.dateToString((Date) request.getAttribute("adate"))%>" method="post">
                <input style="width: 30px" type="number" min="1" max="${totalPages}" value="${currentPage}" name="currentPage">
                <input type="submit" value="跳转">
            </form>
        </div>
    </div>
</div>
</body>
</html>
