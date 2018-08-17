<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/27
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
    <link rel="stylesheet" href="resources/css/login.css" type="text/css"/>
</head>
<body>
<div id="d">
    <div id="d1">
        <img src="resources/images/2.jpg">
    </div>
    <div id="d2">
        <div id="d21">
            <img src="resources/images/3.jpg"/>
        </div>
        <div id="d22" style="text-align: left">
            <div id="d221">
                <form method="post" action="adminLogin">
                    <div id="d2211"><h3 style="height:40px;margin-top:20px">管理员密码登录</h3></div>
                    <div>
                        <img src="resources/images/4.jpg" style="height:40px "/><input type="text" name="adname" style="height:40px;width:200px "/>
                    </div>
                    <div>
                        <img src="resources/images/5.jpg" style="height:40px "/><input type="password" name="adpass" style="height:40px;width:200px "/>
                    </div>
                    <div>
                        <input type="submit" value="登录" style="background-color: orangered;height:40px;margin-top: 15px;width: 240px;margin-bottom: 15px"/>
                    </div>
                    <div style="text-align: right;margin-right: 30px">
                        <span style="color: red;float: left">${error}</span>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
