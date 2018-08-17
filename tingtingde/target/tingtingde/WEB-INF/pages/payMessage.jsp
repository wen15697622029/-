<%@ page import="com.w.util.DateAndString" %>
<%@ page import="com.w.model.Job" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
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
    <link rel="stylesheet" href="resources/css/rapMessage.css" type="text/css"/>
    <script type="text/javascript" src="resources/js/index.js"></script>
    <script src="resources/js/jquery.js"></script>
    <script>
        $(function () {
            $(".affirm").click(function () {
                var pid=parseInt($(this).siblings().eq(0).val());
                $.ajax({
                    type:"post",
                    url:"affirm",
                    data:{pid:pid},
                    success:function (obj) {//成功后回调函数
                        alert(obj);
                        location.reload(true);
                    },
                    error:function (obj) {

                    }
                })
            })
            $(".reconsider").click(function () {
                var pid=parseInt($(this).siblings().eq(0).val());
                $.ajax({
                    type:"post",
                    url:"reconsider",
                    data:{pid:pid},
                    success:function (obj) {//成功后回调函数
                        alert(obj);
                        location.reload(true);
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
            <a href="staff">员工信息&emsp;</a>
            <a href="cultivateMessage" >培训通知&emsp;</a>
            <a href="rapMessage">奖惩&emsp;</a>
            <a href="attendanceMessage">考勤&emsp;</a>
            <a href="payMessage" style="color: red">薪资&emsp;</a>
        </div>
    </div>
    <div id="d5">
        <form action="payMessage" method="post">
            <input type="date" name="pdate" value="<%=DateAndString.dateToString((Date) request.getAttribute("pdate"))%>">
            <input type="submit" value="确认"/>
        </form>
    </div>
    <div id="d3" style="font-size: 24px">
        <div id="d31">
            <table >
                <tr style="background-color: #faebd7">
                    <th width="80px">薪资ID</th>
                    <th width="100px">结算日期</th>
                    <th width="90px">基本工资</th>
                    <th width="90px">绩效</th>
                    <th width="90px">加班</th>
                    <th width="90px">奖惩</th>
                    <th width="90px">社保</th>
                    <th width="90px">实际工资</th>
                    <th width="80px">状态</th>
                    <th width="120px">说明</th>
                    <th width="80px">操作</th>
                </tr>
                <c:forEach items="${pays}" var="pay" varStatus="loop">
                    <tr >
                        <td>${pay.pid}</td>
                        <td>${DateAndString.dateToString(pay.pdate)}</td>
                        <td>${pay.pbase}</td>
                        <td>${pay.pperformance}</td>
                        <td>${pay.povertime}</td>
                        <td>${pay.prap}</td>
                        <td>${pay.pss}</td>
                        <td>${pay.ppay}</td>
                        <td>${pay.pstate==0?"待确定":pay.pstate==1?"正常":"待复议"}</td>
                        <td>${pay.pintro}</td>
                        <td><input type="hidden" name="pid" value="${pay.pid}">
                            <c:if test="${pay.pstate eq 0}">
                                <input type="button" value="确认" class="affirm">
                                <input type="button" value="复议" class="reconsider">
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="d32" >
            <a href="payMessage?pdate=<%=DateAndString.dateToString((Date) request.getAttribute("pdate"))%>&currentPage=${currentPage-1==0?currentPage:currentPage-1}">上一页</a>
            <a href="payMessage?pdate=<%=DateAndString.dateToString((Date) request.getAttribute("pdate"))%>&currentPage=${currentPage}">第${currentPage}页</a>
            共${totalPages}页
            <a href="payMessage?pdate=<%=DateAndString.dateToString((Date) request.getAttribute("pdate"))%>&currentPage=${currentPage+1>totalPages?currentPage:currentPage+1}">下一页</a>
            <form action="payMessage&pdate=<%=DateAndString.dateToString((Date) request.getAttribute("pdate"))%>" method="post">
                <input style="width: 30px" type="number" min="1" max="${totalPages}" value="${currentPage}" name="currentPage">
                <input type="submit" value="跳转">
            </form>
        </div>
    </div>
</div>
</body>
</html>
