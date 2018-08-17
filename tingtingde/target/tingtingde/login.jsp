<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/25
  Time: 16:13
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
   <style>
       #d666{
           margin-top: 100px;
           text-align: center;
       }
   </style>
</head>
<body>
<div id="d666">
    <form action="login " method="post">
        账号:<input type="text" name="uname"><br/>
        密码:<input type="password" name="upass"><br/>
        <input type="submit" value="登陆">

    </form>

</div>

</body>
</html>
