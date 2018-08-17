<%@ page import="com.w.util.DateAndString" %>
<%@ page import="com.w.model.Job" %>
<%@ page import="java.util.List" %>
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
    <link rel="stylesheet" href="resources/css/myResume.css" type="text/css"/>
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
            <a href="staffDetail" style="color: red">&emsp;${staff.susername}</a>
        </div>
        <div id="d12">
            <a href="staff">员工信息&emsp;</a>
            <a href="cultivateMessage" >培训通知&emsp;</a>
            <a href="rapMessage">奖惩&emsp;</a>
            <a href="attendanceMessage">考勤&emsp;</a>
            <a href="payMessage">薪资&emsp;</a>
        </div>
    </div>
    <div id="d5">
        <a href="updateDetail">修改&emsp;</a>
    </div>
    <div id="d3" style="font-size: 24px">
        <div id="d31">

                <table >
                    <tr><td colspan="4" width="1000px" style="background: rgba(126, 87, 100, 0.2)">个人信息</td></tr>
                    <tr>
                        <td width="15%">姓名</td><td width="35%">${staff.sname}</td>
                        <td width="15%">性别</td><td width="35%">${staff.ssex}</td>
                    </tr>
                    <tr>
                        <td width="15%">身份证号</td><td width="35%">${staff.sidcardno}</td>
                        <td width="15%">出生时间</td><td width="35%">${DateAndString.dateToString(staff.sbirthday)}</td>
                    </tr>
                    <tr>
                        <td width="15%">部门</td><td width="35%">${staff.department.dname}</td>
                        <td width="15%">职位</td><td width="35%">${staff.job.jname}</td>
                    </tr>
                    <tr><td colspan="4" width="1000px" style="background: rgba(126, 87, 100, 0.2)">教育情况</td></tr>
                    <tr>
                        <td width="15%">学历</td><td width="35%">${staff.seducation}</td>
                        <td width="15%">毕业院校</td><td width="35%">${staff.scollege}</td>
                    </tr>
                    <tr>
                        <td width="15%">专业</td><td width="35%">${staff.smajor}</td>
                        <td width="15%">毕业时间</td><td width="35%">${DateAndString.dateToString(staff.sgraduate)}</td>
                    </tr>
                    <tr><td colspan="4" width="1000px" style="background: rgba(126, 87, 100, 0.2)">联系方式</td></tr>
                    <tr>
                        <td width="15%">手机</td><td width="35%">${staff.sphone}</td>
                        <td width="15%">电子邮箱</td><td width="35%">${staff.semail}</td>
                    </tr>
                    <tr>
                        <td width="15%">地址</td><td width="35%">${staff.saddress}</td>
                        <td width="15%">邮编</td><td width="35%">${staff.spost}</td>
                    </tr>
                    <tr><td colspan="4" width="1000px" style="background: rgba(126, 87, 100, 0.2)">简介</td></tr>
                    <tr>
                        <td colspan="4" width="1000px" >${staff.sintro}</td>
                    </tr>
                </table>
        </div>
    </div>
</div>
</body>
</html>
