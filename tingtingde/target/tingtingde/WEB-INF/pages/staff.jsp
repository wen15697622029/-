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
    <link rel="stylesheet" href="resources/css/staff.css" type="text/css"/>
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
                        $("#jid").append("<option value='0'>职位</option>");
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
            <a href="staffDetail">&emsp;${staff.susername}</a>
        </div>
        <div id="d12">
            <a href="staff" style="color: red">员工信息&emsp;</a>
            <a href="cultivateMessage">培训通知&emsp;</a>
            <a href="rapMessage">奖惩&emsp;</a>
            <a href="attendanceMessage">考勤&emsp;</a>
            <a href="payMessage">薪资&emsp;</a>
        </div>
    </div>
    <div id="d5">
        <form action="staff" method="post">
            <select name="did" id="did">
                <option value="0">部门</option>
                <c:forEach items="${departments}" var="department">
                    <option value="${department.did}" <c:if test="${department.did eq did}">
                        selected="selected"
                    </c:if>>${department.dname}</option>
                </c:forEach>
            </select>
            <select name="jid" id="jid">
                <option value="0">职位</option>
            </select>
            <select name="sstate" id="sstate">
                <option value="-1">在职状态</option>
                <option value="1" <c:if test="${sstate eq 1}">
                    selected="selected"
                </c:if>>在职</option>
                <option value="0"<c:if test="${sstate eq 0}">
                    selected="selected"
                </c:if>>实习</option>
                <option value="2" <c:if test="${sstate eq 2}">
                    selected="selected"
                </c:if>>离职</option>
            </select>
            <input type="submit" value="确认"/>
        </form>
    </div>
    <div id="d3" style="font-size: 24px">
        <div id="d31">
            <table >
                <tr style="background-color: #faebd7">
                    <th width="80px">员工ID</th>
                    <th width="80px">姓名</th>
                    <th width="60px">性别</th>
                    <th width="100px">入职状态</th>
                    <th width="120px">生日</th>
                    <th width="120px">手机号</th>
                    <th width="220px">email</th>
                    <th width="100px">部门</th>
                    <th width="100px">职位</th>
                </tr>
                <c:forEach items="${staffs}" var="staff" varStatus="loop">
                    <tr >
                        <td>${staff.sid}</td>
                        <td>${staff.sname}</td>
                        <td>${staff.ssex}</td>
                        <td>${staff.sstate==1?"在职":staff.sstate==0?"实习":"离职"}</td>
                        <td>${DateAndString.dateToString(staff.sbirthday)}</td>
                        <td>${staff.sphone}</td>
                        <td>${staff.semail}</td>
                        <td>${staff.department.dname}</td>
                        <td>${staff.job.jname}</td>
                    </tr>
                </c:forEach>
                <tr><td colspan="6">
                </td>
                    <td colspan="2" id="str" style="color: red"></td>
                </tr>
            </table>
        </div>
        <div id="d32" >
            <a href="staff?did=${did}&jid=${jid}&sstate=${sstate}&currentPage=${currentPage-1==0?currentPage:currentPage-1}">上一页</a>
            <a href="staff?did=${did}&jid=${jid}&sstate=${sstate}&currentPage=${currentPage}">第${currentPage}页</a>
            共${totalPages}页
            <a href="staff?did=${did}&jid=${jid}&sstate=${sstate}&currentPage=${currentPage+1>totalPages?currentPage:currentPage+1}">下一页</a>
            <form action="staff?did=${did}&jid=${jid}&sstate=${sstate}" method="post">
                <input style="width: 30px" type="number" min="1" max="${totalPages}" value="${currentPage}" name="currentPage">
                <input type="submit" value="跳转">
            </form>
        </div>
    </div>
</div>
</body>
</html>
