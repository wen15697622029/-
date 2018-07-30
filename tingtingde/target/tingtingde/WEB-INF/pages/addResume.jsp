<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/30
  Time: 13:37
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
    <link rel="stylesheet" href="resources/css/index.css" type="text/css"/>
    <script type="text/javascript" src="resources/js/index.js"></script>
    <script src="resources/js/jquery.js"></script>
</head>
<body>
<div id="d">
    <div id="d1">
        <div id="d11">
            <a href="login.jsp">&emsp;${user.uname}</a>
        </div>
        <div id="d12">
            <a href="myResume" STYLE="color: red">我的简历&emsp;</a>
            <a href="myInterview">面试管理&emsp;</a>
        </div>
    </div>
    <div id="d3" style="font-size: 24px">
        <div id="d31">
            <form action="addResume1" method="post">
                <table >
                    <tr><th colspan="4"><input type="text" name="resumename" value="简历名"></th></tr>
                    <tr><td colspan="4" style="text-align: center">个人信息</td></tr>
                    <tr>
                        <td>姓名</td><td><input type="text" name="rename"></td>
                        <td>性别</td><td><input type="text" name="resex"></td>
                    </tr>
                    <tr>
                        <td>身份证号</td><td><input type="text" name="reidcardno"></td>
                        <td>出生时间</td><td><input type="date" name="rebirthday"></td>
                    </tr>
                    <tr><td colspan="4"  s style="text-align: center">教育情况</td></tr>
                    <tr>
                        <td>学历</td><td><input type="text" name="reeducation"></td>
                        <td>毕业院校</td><td><input type="text" name="recollege"></td>
                    </tr>
                    <tr>
                        <td>专业</td><td><input type="text" name="remajor"></td>
                        <td>毕业时间</td><td><input type="date" name="regraduate"></td>
                    </tr>
                    <tr><td colspan="4" style="text-align: center">联系方式</td></tr>
                    <tr>
                        <td>手机</td><td><input type="text" name="rephone"></td>
                        <td>电子邮箱</td><td><input type="text" name="reemail"></td>
                    </tr>
                    <tr>
                        <td>地址</td><td><input type="text" name="readdress"></td>
                        <td>邮编</td><td><input type="text" name="repost"></td>
                    </tr>
                    <tr><td colspan="4">简介</td></tr>
                    <tr>
                        <td colspan="4"><input type="text" name="reintro"></td>
                    </tr>
                    <tr>
                        <td colspan="4"><input type="submit" value="添加"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
