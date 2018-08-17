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
                        $("#jid").append("<option value='0'>职位</option>");
                        $(jobs).each(function (i) {
                            $("#jid").append("<option value="+jobs[i].jid+">"+jobs[i].jname+"</option>");
                        })
                    },
                    error:function (obj) {

                    }
                })
            })
            $("#jid").change(function () {
                var jid=parseInt($(this).val());
                $.ajax({
                    type:"post",
                    url:"load",
                    data:{jid:jid},
                    success:function (job) {//成功后回调函数
                        $("#jname").val(job.jname);
                        $("#jsalary").val(job.jsalary);
                    },
                    error:function (obj) {

                    }
                })
            })
            $("#deld").click(function () {
                var did=parseInt($("#did").val());
                if(did==0){
                    alert("未选择部门");
                    return false;
                }
                if(!confirm("确认删除该部门")){
                    return false;
                }
                $.ajax({
                    type:"post",
                    url:"deld",
                    data:{did:did},
                    success:function (obj) {//成功后回调函数
                        alert(obj);
                        location.reload(true);
                    },
                    error:function (obj) {

                    }
                })
            })
            $("#delj").click(function () {
                var jid=parseInt($("#jid").val());
                if(jid==0){
                    alert("未选择职位");
                    return false;
                }
                if(!confirm("确认删除该职位")){
                    return false;
                }
                $.ajax({
                    type:"post",
                    url:"delj",
                    data:{jid:jid},
                    success:function (obj) {//成功后回调函数
                        alert(obj);
                        location.reload(true);
                    },
                    error:function (obj) {

                    }
                })
            })
            $("#saved").click(function () {
                var did=parseInt($("#did").val());
                var dname=$("#dname").val();
                if (dname==null||dname==""){
                    alert("部门名不能为空");
                    return false;
                }
                $.ajax({
                    type:"post",
                    url:"checkDname",
                    data:{dname:dname},
                    success:function (obj) {//成功后回调函数
                        if(obj=="重名"){
                            alert("重名");
                            return false;
                        }else{
                            if(did==0){
                                if(!confirm("确认添加该部门")){
                                    return false;
                                }
                                $.ajax({
                                    type:"post",
                                    url:"addd",
                                    data:{dname:dname},
                                    success:function (obj) {//成功后回调函数
                                        alert(obj);
                                        location.reload(true);
                                    },
                                    error:function (obj) {

                                    }
                                })
                            }else{
                                if(!confirm("确认修改该部门")){
                                    return false;
                                }
                                $.ajax({
                                    type:"post",
                                    url:"updated",
                                    data:{did:did,dname:dname},
                                    success:function (obj) {//成功后回调函数
                                        alert(obj);
                                        location.reload(true);
                                    },
                                    error:function (obj) {

                                    }
                                })
                            }
                        }
                    },
                    error:function (obj) {

                    }
                })
            })
            $("#savej").click(function () {
                var did=parseInt($("#did").val());
                if(did==0){
                    alert("必须选择部门")
                    return false;
                }
                var jid=parseInt($("#jid").val());
                var jname=$("#jname").val();
                if (jname==null||jname==""){
                    alert("职位名不能为空");
                    return false;
                }
                var jsalary=$("#jsalary").val();
                if(jsalary==""){
                    alert("请输入基本工资");
                    return false;
                }
                jsalary=parseFloat(jsalary);
                if(jsalary<4000){
                    alert("基本工资不能小于4000");
                    return false;
                }
                $.ajax({
                    type:"post",
                    url:"checkJname",
                    data:{jname:jname},
                    success:function (obj) {//成功后回调函数
                        if(obj=="重名"){
                            alert("重名");
                            return false;
                        }else{
                            if(jid==0){
                                if(!confirm("确认添加该职位")){
                                    return false;
                                }
                                $.ajax({
                                    type:"post",
                                    url:"addj",
                                    data:{did:did,jname:jname,jsalary:jsalary},
                                    success:function (obj) {//成功后回调函数
                                        alert(obj);
                                        location.reload(true);
                                    },
                                    error:function (obj) {

                                    }
                                })
                            }else{
                                if(!confirm("确认修改该职位")){
                                    return false;
                                }
                                $.ajax({
                                    type:"post",
                                    url:"updatej",
                                    data:{jid:jid,jname:jname,jsalary:jsalary},
                                    success:function (obj) {//成功后回调函数
                                        alert(obj);
                                        location.reload(true);
                                    },
                                    error:function (obj) {

                                    }
                                })
                            }
                        }
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
            <a href="organizationalManagement" style="color: red">组织管理&emsp;</a>
            <a href="attendanceInformation">考勤管理&emsp;</a>
            <a href="cultivate">培训管理&emsp;</a>
            <a href="ri">招聘信息&emsp;</a>
            <a href="r">招聘管理&emsp;</a>
            <a href="rap">奖惩管理&emsp;</a>
        </div>
    </div>
    <div id="d3" style="font-size: 24px;margin-top: 50px">

        <div id="d31">
            <table >
                <tr style="background-color: #faebd7">
                    <td>
                        <select name="did" id="did">
                        <option value="0">部门</option>
                        <c:forEach items="${departments}" var="department">
                            <option value="${department.did}">${department.dname}</option>
                        </c:forEach>
                    </select>
                    </td><td><input type="button" value="删除部门" id="deld">部门名：<input type="text" name="dname" id="dname"><input type="button" value="添加修改部门" id="saved"></td>
                </tr>
                <tr style="background-color: #faebd7">
                    <td>
                        <select name="jid" id="jid">
                            <option value="0">职位</option>
                        </select>
                    </td><td><input type="button" value="删除职位" id="delj">职位名：<input type="text" name="jname" id="jname">基本工资：<input type="number" min="4000" max="1000000" step="0.1" name="jsalary" id="jsalary"><input type="button" value="添加修改职位" id="savej"></td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>
