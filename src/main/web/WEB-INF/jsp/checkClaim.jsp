<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<h3>报销单审核</h3>
<h5>基本信息</h5>
编&nbsp;&nbsp;:${claimEmployeeVo.id}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;填写人:${claimEmployeeVo.sysEmployee.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;职&nbsp;&nbsp;位:${claimEmployeeVo.sysEmployee.sysPositions.nameCn}<br/>
<br/>
总金额:${claimEmployeeVo.totalAccount}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;填报时间:<fmt:formatDate value="${claimEmployeeVo.createTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;状&nbsp;&nbsp;态:${claimEmployeeVo.status}<br/>
<br/>
---------------------------------------------------------------------------------------------------<br/>
<h5>报销单明细</h5>
<table border="1" width="50%">
    <tr align="center">
        <td width="30%">项目类别</td>
        <td width="30%">项目金额</td>
        <td >费用说明</td>
    </tr>
    <c:forEach items="${bcdList}" var="details">
        <tr align="center">
            <td>${details.item}</td>
            <td>${details.account}</td>
            <td>${details.desc}</td>
        </tr>
    </c:forEach>
</table>



<form method="post">
    <input type="hidden" name="id" value="${claimEmployeeVo.id}"/>
    <input type="hidden" name="status" />
</form>

<c:if test="${loginUser.sysPositions.id  eq 2}">
    <button id="passBtn" class="easyui-linkbutton"  onclick="passClaim()">审批通过</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button id="refuseBtn" class="easyui-linkbutton" onclick="refuseClaim()">审批拒绝</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button id="backToBtn" class="easyui-linkbutton" onclick="backToClaim()">打回</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button id="returnBtn" class="easyui-linkbutton" onclick="window.history.go(-1);">返回</button>
</c:if>
<c:if test="${loginUser.sysPositions.id  eq 3}">
    <button id="passBtn" class="easyui-linkbutton" class="easyui-linkbutton" onclick="passClaim()">审批通过</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button id="refuseBtn" class="easyui-linkbutton" onclick="refuseClaim()">审批拒绝</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button id="backToBtn" class="easyui-linkbutton" onclick="backToClaim()">打回</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button id="returnBtn" class="easyui-linkbutton" onclick="window.history.go(-1);">返回</button>
</c:if>
<c:if test="${loginUser.sysPositions.id  eq 4}">
    <button id="passBtn" class="easyui-linkbutton" onclick="passClaim()">审批通过</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button id="returnBtn" class="easyui-linkbutton" onclick="window.history.go(-1);">返回</button>
</c:if>
<c:if test="${loginUser.sysPositions.id eq 1}">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button id="returnBtn" class="easyui-linkbutton" onclick="window.history.go(-1);">返回</button>
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
