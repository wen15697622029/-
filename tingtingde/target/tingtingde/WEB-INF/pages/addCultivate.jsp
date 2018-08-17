<%@ page import="com.w.util.DateAndString" %>
<%--
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
            $("#save").click(function () {
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
            <a href="cultivate" style="color: red">培训管理&emsp;</a>
            <a href="ri">招聘信息&emsp;</a>
            <a href="r">招聘管理&emsp;</a>
            <a href="rap">奖惩管理&emsp;</a>
        </div>
    </div>
    <div id="d5">
        <a href="cultivate?istate=0"
                <c:if test="${cstate eq 0}">
                    style="color: red"
                </c:if>>未发布&emsp;</a>
        <a href="cultivate?cstate=1"
                <c:if test="${cstate eq 1}">
                    style="color: red"
                </c:if>>发布中&emsp;</a>
        <a href="addcultivate1" style="color: red">新增培训&emsp;</a>
    </div>
    <div id="d3" style="font-size: 24px">
        <div id="d31">
            <form action="addcultivate" method="post">
            <table width="300px">
                <tr >
                    <td width="30%">主题</td>
                    <td width="70%"><input type="text" name="ctheme" value="${cultivate.ctheme}"></td>
                </tr>
                <tr >
                    <td width="30%">内容</td>
                    <td width="70%"><input type="text" name="ccontent" value="${cultivate.ccontent}"></td>
                </tr>
                <tr >
                    <td width="30%">开始时间</td>
                    <td width="70%"><input type="datetime-local" name="begintime" value="${cultivate.cbegintime==null?DateAndString.dateToStringTime1(now):DateAndString.dateToStringTime1(cultivate.cbegintime)}"></td>
                </tr>
                <tr >
                    <td width="30%">结束时间</td>
                    <td width="70%"><input type="datetime-local" name="endtime" value="${cultivate.cendtime==null?DateAndString.dateToStringTime1(now):DateAndString.dateToStringTime1(cultivate.cendtime)}"></td>
                </tr>
                <tr >
                    <td width="30%">地点</td>
                    <td width="70%"><input type="text" name="caddress" value="${cultivate.caddress}"></td>
                </tr>
                <tr>
                    <c:if test="${cultivate!=null}">
                        <input type="hidden" name="cid" value="${cultivate.cid}">
                    </c:if>
                    <td colspan="2" style="text-align: center"><input type="submit" value="添加或修改" id="save"></td> </tr>
            </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
