<%@ page import="com.w.model.Resume" %>
<%@ page import="com.w.util.DateAndString" %><%--
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
            $("#update").click(function () {
                var did=parseInt($("#did").val());
                var jid=parseInt($("#jid").val());
                if (did==0||jid==0){
                    alert("请选择部门职位");
                    return false;
                }
                var flag=true;
                $("input[type=text]").each(function(i){
                    var text = $(this).val();
                    if(text ==""){
                        alert("有空值");
                        flag=false;
                        return false;
                    }
                });
                var rinum =$("input[name='rinum']").val();
                if(rinum==""){
                    alert("请输入人数");
                }
                if (!flag){
                    return false;
                }
                return confirm("确认添加或更改");
            })
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
            <a href="adminLogin.jsp">&emsp;${admin.adname}</a>
        </div>
        <div id="d12">
            <a href="admin">员工管理&emsp;</a>
            <a href="pay" >薪资管理&emsp;</a>
            <a href="organizationalManagement" >组织管理&emsp;</a>
            <a href="attendanceInformation">考勤管理&emsp;</a>
            <a href="cultivate">培训管理&emsp;</a>
            <a href="ri" style="color: red">招聘信息&emsp;</a>
            <a href="r">招聘管理&emsp;</a>
            <a href="rap">奖惩管理&emsp;</a>
        </div>
    </div>
    <div id="d5">
        <a href="ri?ristate=0"
                <c:if test="${ristate eq 0}">
                    style="color: red"
                </c:if>
        >未发布&emsp;</a>
        <a href="ri?ristate=1"
                <c:if test="${ristate eq 1}">
                    style="color: red"
                </c:if>>已发布&emsp;</a>
        <a href="addRi" style="color: red">添加</a>
    </div>
    <div id="d3" style="font-size: 24px">
        <div id="d31">
            <form action="update" method="post">
                <table width="300px">
                    <tr>
                        <td  width="30%">部门</td><td width="70%">
                        <select name="department.did" id="did">
                            <option value="0">部门</option>
                            <c:forEach items="${departments}" var="department">
                                <option value="${department.did}">${department.dname}</option>
                            </c:forEach>
                        </select></td>
                    </tr>
                    <tr> <td width="30%">职位</td><td width="70%">
                        <select name="job.jid" id="jid">
                            <option value="0">职位</option>
                        </select>
                    </td>
                    </tr>
                    <tr>
                        <td width="30%">人数</td><td width="70%"><input type="number" min="1" max="10" name="rinum" value="${recruitInformation.rinum}"></td>
                    </tr>
                    <tr><td width="30%">简介</td><td width="70%"><input type="text" name="riintro" value="${recruitInformation.riintro}"></td></tr>

                    <tr>
                        <td colspan="2" style="text-align: center">
                            <c:if test="${recruitInformation!=null}">
                                <input type="hidden" name="riid" min="1" value="${recruitInformation.riid}">
                            </c:if>
                            <input type="submit" value="确认" id="update"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
