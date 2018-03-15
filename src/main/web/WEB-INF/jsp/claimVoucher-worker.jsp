<%--
  Created by IntelliJ IDEA.
  User: 祖龙浩
  Date: 2018/3/14
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="easyuiBasic.jsp"%>
</head>
<body>


<table id="claimDg"></table>
</body>
<script type="application/javascript">
    $(function () {

        var sysPositionsId = "${loginUser.sysPositions.id}";
        var url = "";
        var createSn = "${loginUser.sn}";

        if(sysPositionsId==1){
            url = "${pageContext.request.contextPath}/bizClaimVoucher/queryClaimEmployeeVoByCreateSn?createSn="+createSn;

        }
        else if(sysPositionsId==2){
            url = "${pageContext.request.contextPath}/bizClaimVoucher/queryClaimEmployeeVoByStatus";
        }else if(sysPositionsId==3){
            url = "${pageContext.request.contextPath}/bizClaimVoucher/queryClaimEmployeeVoByCheckDMAndMoney";
        }else if(sysPositionsId==4){
            url = "${pageContext.request.contextPath}/bizClaimVoucher/queryClaimEmployeeVoByCheckGM";
        }
        $("#claimDg").datagrid({
            url:url,
            method:'GET',
            striped:true,
            checkOnSelect:false,
            pagination:true,
            rownumbers:true,
            columns:[[
                {field:'ids',title:'报销单编号',align:'center',width:100,formatter:function (value,row,index) {
                    return row.id;
                }},
                {field:'createTime',title:'填报日期',align:'center',width:150},
                {field:'sysEmployee',title:'填报人',align:'center',width:100,formatter:function (value,row,index) {
                    return row.sysEmployee.name;
                }},
                {field:'totalAccount',title:'报销金额(元)',align:'center',width:100},
                {field:'status',title:"报销单状态",align:'center',width:100}
            ]]
        });
    })

</script>
</html>
