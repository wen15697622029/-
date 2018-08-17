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
            $("#update").click(function () {
                var idcardnoReg=/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[012])(0[1-9]|[12]\d|3[01])\d{3}(\d|[xX])$/;
                var sidcardno =$("input[name='sidcardno']").val();
                if(!idcardnoReg.test(sidcardno)){
                    alert("身份证号码输入有误")
                    return false;
                }
                var postReg=/^[1-9][0-9]{5}$/;
                var spost =$("input[name='spost']").val();
                if(!postReg.test(spost)){
                    alert("邮编输入有误")
                    return false;
                }
                var phoneReg=/^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/;
                var sphone =$("input[name='sphone']").val();
                if(!phoneReg.test(sphone)){
                    alert("手机号码输入有误")
                    return false;
                }
                var emailReg=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
                var semail =$("input[name='semail']").val();
                if(!emailReg.test(semail)){
                    alert("email输入有误")
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
                if (!flag){
                    return false;
                }
                return confirm("确认更改");
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
    <div <%--<img src="resources/images/1.gif" style="width: 1000px;height: 83px"> id="d4">
       --%>
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
    <div id="d3" style="font-size: 24px">
        <div id="d31">
            <form action="updateD" method="post">
                <table >
                    <tr><td colspan="4" width="1000px" style="background: rgba(126, 87, 100, 0.2)">个人信息</td></tr>
                    <tr>
                        <td width="15%">姓名</td><td width="35%"><input type="text" name="sname" value="${staff.sname}"></td>
                        <td width="15%">性别</td><td width="35%"><input type="text" name="ssex" value="${staff.ssex}"></td>
                    </tr>
                    <tr>
                        <td width="15%">身份证号</td><td width="35%"><input type="text" name="sidcardno" value="${staff.sidcardno}"></td>
                        <td width="15%">出生时间</td><td width="35%"><input type="date" name="sbirthday" value="${DateAndString.dateToString(staff.getSbirthday())}"></td>
                    </tr>
                    <tr><td colspan="4" width="1000px" style="background: rgba(126, 87, 100, 0.2)">教育情况</td></tr>
                    <tr>
                        <td width="15%">学历</td><td width="35%"><input type="text" name="seducation" value="${staff.seducation}"></td>
                        <td width="15%">毕业院校</td><td width="35%"><input type="text" name="scollege" value="${staff.scollege}"></td>
                    </tr>
                    <tr>
                        <td width="15%">专业</td><td width="35%"><input type="text" name="smajor" value="${staff.smajor}"></td>
                        <td width="15%">毕业时间</td><td width="35%"><input type="date" name="sgraduate" value="${DateAndString.dateToString(staff.getSgraduate())}"></td>
                    </tr>
                    <tr><td colspan="4" width="1000px" style="background: rgba(126, 87, 100, 0.2)">联系方式</td></tr>
                    <tr>
                        <td width="15%">手机</td><td width="35%"><input type="text" name="sphone" value="${staff.sphone}"></td>
                        <td width="15%">电子邮箱</td><td width="35%"><input type="text" name="semail" value="${staff.semail}"></td>
                    </tr>
                    <tr>
                        <td width="15%">地址</td><td width="35%"><input type="text" name="saddress" value="${staff.saddress}"></td>
                        <td width="15%">邮编</td><td width="35%"><input type="text" name="spost" value="${staff.spost}"></td>
                    </tr>
                    <tr><td colspan="4" width="1000px" style="background: rgba(126, 87, 100, 0.2)">简介</td></tr>
                    <tr>
                        <td colspan="4" width="1000px" ><input type="text" name="sintro" value="${staff.sintro}"></td>
                    </tr>
                    <tr>
                        <td colspan="4" style="text-align: center">
                            <input type="hidden" name="sid" value="${staff.sid}">
                            <input type="submit" value="修改" id="update"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
