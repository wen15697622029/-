<%@ page import="com.w.model.Resume" %>
<%@ page import="com.w.util.DateAndString" %><%--
  Created by IntelliJ IDEA.
  User: destiny
  Date: 2018/6/24/0024
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="now" class="java.util.Date" scope="page"/>
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
            $("#affirm").click(function () {
                var flag=true;
                $("input[type=text]").each(function(i){
                    var text = $(this).val();
                    if(text ==""){
                        alert("有空值");
                        flag=false;
                        return false;
                    }
                });
                if (!flag){
                    return false;
                }
                return confirm("确定发送面试邀请？");
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
    <div id="d3" style="font-size: 24px">
        <div id="d31">
            <form action="addInterview" method="post">
                <table width="300px">
                    <tr>
                        <td width="30%">面试人</td><td width="70%">
                        <select name="staff.sid" id="sid">
                            <c:forEach items="${staffs}" var="staff">
                                <option value="${staff.sid}">${staff.sname}</option>
                            </c:forEach>
                        </select></td>
                    </tr>
                    <tr> <td width="30%">面试时间</td><td width="70%">
                        <input type="datetime-local" name="midate" value="${DateAndString.dateToStringTime1(now)}">
                    </td>
                    </tr>
                    <tr>
                        <td width="30%">面试地点</td><td width="70%"><input type="text" name="iaddress" value="公司5楼503会议室"></td>
                    </tr>
                    <tr><td colspan="2">简介</td></tr>
                    <tr><td colspan="2"><input type="text" name="iintro" value="带好必要的资料"></td></tr>

                    <tr>
                        <td colspan="2">
                            <input type="hidden" name="rid"  value="${recruit.rid}">
                            <input type="submit" value="确认" id="affirm"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
