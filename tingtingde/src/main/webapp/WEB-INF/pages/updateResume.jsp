<%@ page import="com.w.model.Resume" %>
<%@ page import="com.w.util.DateAndString" %>
<%@ page import="java.util.Date" %><%--
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
    <link rel="stylesheet" href="resources/css/myResume.css" type="text/css"/>
    <script type="text/javascript" src="resources/js/index.js"></script>
    <script src="resources/js/jquery.js"></script>
    <script>
        $(function () {
            $("#update").click(function () {
                var idcardnoReg=/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[012])(0[1-9]|[12]\d|3[01])\d{3}(\d|[xX])$/;
                var reidcardno =$("input[name='reidcardno']").val();
                if(!idcardnoReg.test(reidcardno)){
                    alert("身份证号码输入有误")
                    return false;
                }
                var postReg=/^[1-9][0-9]{5}$/;
                var repost =$("input[name='repost']").val();
                if(!postReg.test(repost)){
                    alert("邮编输入有误")
                    return false;
                }
                var phoneReg=/^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/;
                var rephone =$("input[name='rephone']").val();
                if(!phoneReg.test(rephone)){
                    alert("手机号码输入有误")
                    return false;
                }
                var emailReg=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
                var reemail =$("input[name='reemail']").val();
                if(!emailReg.test(reemail)){
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
                return confirm("确认添加或更改");
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
            <a href="login.jsp">&emsp;${user.uname}</a>
        </div>
        <div id="d12">
            <a href="user" >简历投递&emsp;</a>
            <a href="myResume" STYLE="color: red">简历管理&emsp;</a>
            <a href="myInterview">面试管理&emsp;</a>
        </div>
    </div>
    <div id="d3" style="font-size: 24px">
        <div id="d31">
            <form action="updateResume" method="post">
                <table >
                    <tr><th colspan="4" style="text-align: center" width="1000px"><input type="text" name="resumename" value="${resume.resumename}"></th></tr>
                    <tr><td colspan="4" width="1000px" style="background: rgba(126, 87, 100, 0.2)">个人信息</td></tr>
                    <tr>
                        <td width="15%">姓名</td><td><input type="text" name="rename" value="${resume.rename}"></td>
                        <td width="15%">性别</td><td><input type="text" name="resex" value="${resume.resex}"></td>
                    </tr>
                    <tr>
                        <td width="15%">身份证号</td><td><input type="text" name="reidcardno" value="${resume.reidcardno}"></td>
                        <td width="15%">出生时间</td><td><input type="date" name="rebirthday" value="${resume.getRebirthday()==null?DateAndString.dateToString(now):DateAndString.dateToString(resume.getRebirthday())}"></td>
                    </tr>
                    <tr><td colspan="4" width="1000px" style="background: rgba(126, 87, 100, 0.2)">教育情况</td></tr>
                    <tr>
                        <td width="15%">学历</td><td><input type="text" name="reeducation" value="${resume.reeducation}"></td>
                        <td width="15%">毕业院校</td><td><input type="text" name="recollege" value="${resume.recollege}"></td>
                    </tr>
                    <tr>
                        <td width="15%">专业</td><td><input type="text" name="remajor" value="${resume.remajor}"></td>
                        <td width="15%">毕业时间</td><td><input type="date" name="regraduate" value="${resume.getRegraduate()==null?DateAndString.dateToString(now):DateAndString.dateToString(resume.getRegraduate())}"></td>
                    </tr>
                    <tr><td colspan="4" width="1000px" style="background: rgba(126, 87, 100, 0.2)">联系方式</td></tr>
                    <tr>
                        <td width="15%">手机</td><td><input type="text" name="rephone" value="${resume.rephone}"></td>
                        <td width="15%">电子邮箱</td><td><input type="text" name="reemail" value="${resume.reemail}"></td>
                    </tr>
                    <tr>
                        <td width="15%">地址</td><td><input type="text" name="readdress" value="${resume.readdress}"></td>
                        <td width="15%">邮编</td><td><input type="text" name="repost" value="${resume.repost}"></td>
                    </tr>
                    <tr><td colspan="4" width="1000px" style="background: rgba(126, 87, 100, 0.2)">简介</td></tr>
                    <tr>
                        <td colspan="4"><input type="text" name="reintro" value="${resume.reintro}"></td>
                    </tr>
                    <tr>
                        <td colspan="4" style="text-align: center">
                            <c:if test="${resume!=null}">
                                <input type="hidden" name="reid" value="${resume.reid}">
                            </c:if>
                            <input type="submit" value="添加或修改" id="update"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
