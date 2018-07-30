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
    <script>
        $(function () {
            var p1;
            var p2;
            var flag1 = false;
            var flag2 = false;
            var flag3 = false;
            $("#uname").focus(function () {
                $("#name").html("字母开头，6-16位字母、数字");
            })
            $("#pwd1").focus(function () {
                $("#pass").html("6-16位字母、数字");
            })
            $("#pwd2").focus(function () {
                $("#pass1").html("请再次输入你的密码");
            })
            $("#pwd2").blur(function () {
                p1 = $("#pwd1").val();
                p2 = $("#pwd2").val();
                if(p1==p2&&flag2){
                    $("#pass1").html("密码相同且符合要求");
                    flag3 = true;
                    ff();
                }else{
                    $("#pass1").html("密码不相同或不符合要求");
                    flag3 = false;
                }
            })
            $("#pwd1").blur(function () {
                p1 = $("#pwd1").val();
                var reg=/[A-z0-9]{6,16}/;
                if (p1.length<6){
                    $("#pass").html("密码小于6位");
                    flag2 = false;
                }else if(p1.length>16){
                    $("#pass").html("密码大于16位");
                    flag2 = false;
                }else if(!reg.test(p1)){
                    $("#pass").html("密码设置不符合要求");
                    flag2 = false;
                }else {
                    $("#pass").html("密码命名符合要求");
                    flag2 = true;
                    ff();
                }
            })
            $("#uname").blur(function () {
                uname = $("#uname").val();
                var reg=/[A-z][A-z0-9]{5,15}/;
                if (uname.length<6){
                    $("#name").html("用户名小于6位");
                    flag1 = false;
                }else if(uname.length>16){
                    $("#name").html("用户名大于16位");
                    flag1 = false;
                }else if(!reg.test(uname)){
                    $("#name").html("用户名命名不符合要求");
                    flag1 = false;
                }else {
                    $.ajax({
                        type:"get",
                        url:"checkName",
                        data:{uname:$("#uname").val()},
                        success:function (obj) {//成功后回调函数
                            $("#name").text(obj);
                        },
                        error:function (obj) {
                            $("#name").text(obj);
                        }
                    })
                    flag1 = true;
                    ff();
                }
            })
            function ff() {
                if (flag1&&flag2&&flag3){
                    $("#register").attr("disabled",false);
                    $("#uname").attr("readonly",true);
                    $("#pwd1").attr("readonly",true);
                    $("#pwd2").attr("readonly",true);
                }else{
                    $("#register").attr("disabled",true);
                }
            }
            $("#rt").click(function () {
                $("#register").attr("disabled",true);
                $("#uname").attr("readonly",false);
                $("#pwd1").attr("readonly",false);
                $("#pwd2").attr("readonly",false);
                flag1 = false;
                flag2 = false;
                flag3 = false;
            })
        })
    </script>
</head>
<body>
BUG_RAP
<form action="register" method="post">
    账号:<input name="uname"><br/>
    密码:<input name="upass"><br/>
    <input type="submit" value="注册">

</form>
</body>
</html>
