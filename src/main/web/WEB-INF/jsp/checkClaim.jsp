<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 祖龙浩
  Date: 2018/3/14
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <%@include file="easyuiBasic.jsp"%>
</head>
<body>
审核报销单



<form method="post">
    <input type="hidden" name="id" value="${claimEmployeeVo.id}"/>
    <input type="hidden" name="status" />
</form>

<c:if test="${loginUser.sysPositions.id  eq 2}">
    <button id="passBtn" onclick="passClaim()">审批通过</button>
    <button id="refuseBtn" onclick="refuseClaim()">审批拒绝</button>
    <button id="backToBtn" onclick="backToClaim()">打回</button>
    <button id="returnBtn" onclick="window.history.go(-1);">返回</button>
</c:if>
<c:if test="${loginUser.sysPositions.id  eq 3}">
    <button id="passBtn" onclick="passClaim()">审批通过</button>
    <button id="refuseBtn" onclick="refuseClaim()">审批拒绝</button>
    <button id="backToBtn" onclick="backToClaim()">打回</button>
    <button id="returnBtn" onclick="window.history.go(-1);">返回</button>
</c:if>
<c:if test="${loginUser.sysPositions.id  eq 4}">
    <button id="passBtn" onclick="passClaim()">审批通过</button>
    <button id="returnBtn" onclick="window.history.go(-1);">返回</button>
</c:if>


</body>
<script type="application/javascript">
    //通过按钮
    function passClaim() {
        var posId = "${loginUser.sysPositions.id}";
        if(posId==2) {
            var money = "${claimEmployeeVo.totalAccount}";
            if(money < 5000){
                $("form").attr("action","${pageContext.request.contextPath}/bizClaimVoucher/updateCheckDmAndCheckGmById");
                $("form").submit();
            }else{
                $("form").attr("action","${pageContext.request.contextPath}/bizClaimVoucher/updateCheckDmById");
                $("form").submit();
            }
        }else if(posId==3) {
            $("form").attr("action","${pageContext.request.contextPath}/bizClaimVoucher/updateCheckGmById");
            $("form").submit();

        }else if(posId==4) {
            $("form").attr("action","${pageContext.request.contextPath}/bizClaimVoucher/updateAllStatus");
            $("form").submit();
        }
    }
//拒绝按钮
    function refuseClaim() {
        var posId = "${loginUser.sysPositions.id}";
        if(posId==2) {
            $("input[name='status']").val("1");
            $("form").attr("action","${pageContext.request.contextPath}/bizClaimVoucher/updateStatusById");
            $("form").submit();

        }else if(posId==3) {
            $("form").attr("action","${pageContext.request.contextPath}/bizClaimVoucher/updateCheckDmAndStatusById");
            $("form").submit();

        }
    }
    //打回按钮
    function backToClaim() {
        var posId = "${loginUser.sysPositions.id}";
        if(posId==2) {
            $("input[name='status']").val("2");
            $("form").attr("action","${pageContext.request.contextPath}/bizClaimVoucher/updateStatusById");
            $("form").submit();

        }else if(posId==3) {
            $("form").attr("action","${pageContext.request.contextPath}/bizClaimVoucher/updateCheckDmAndStatusById1");
            $("form").submit();

        }
    }
</script>
</html>
