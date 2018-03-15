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
    <%@include file="easyuiBasic.jsp" %>
</head>
<body>


<table id="claimDg"></table>
</body>
<script type="text/javascript">
    $(function () {

        var sysPositionsId = "${loginUser.sysPositions.id}";
        var url = "";
        var createSn = "${loginUser.sn}";

        if (sysPositionsId == 1) {
            url = "${pageContext.request.contextPath}/bizClaimVoucher/queryClaimEmployeeVoByCreateSn?createSn=" + createSn;

        }
        else if (sysPositionsId == 2) {
            url = "${pageContext.request.contextPath}/bizClaimVoucher/queryClaimEmployeeVoByStatus";
        } else if (sysPositionsId == 3) {
            url = "${pageContext.request.contextPath}/bizClaimVoucher/queryClaimEmployeeVoByCheckDMAndMoney";
        } else if (sysPositionsId == 4) {
            url = "${pageContext.request.contextPath}/bizClaimVoucher/queryClaimEmployeeVoByCheckGM";
        }
        $("#claimDg").datagrid({
            url: url,
            method: 'GET',
            striped: true,
            checkOnSelect: false,
            pagination: true,
            rownumbers: true,
            columns: [[
                {
                    field: 'ids',
                    title: '报销单编号',
                    align: 'center',
                    width: 100,
                    formatter: function (value, row, index) {
                        return row.id;
                    }
                },
                {field: 'createTime', title: '填报日期', align: 'center', width: 150},
                {
                    field: 'sysEmployee',
                    title: '填报人',
                    align: 'center',
                    width: 100,
                    formatter: function (value, row, index) {
                        return row.sysEmployee.name;
                    }
                },
                {field: 'totalAccount', title: '报销金额(元)', align: 'center', width: 100},
                {field: 'status', title: "报销单状态", align: 'center', width: 100},
                {
                    field: 'ck',
                    title: '操作',
                    align: 'center',
                    width: 200,
                    formatter: function (value, row, index) {
                        var deleteBtn = "<button class='easyui-linkButton' onclick='deleteClaim(" + row.id + ")'>删除</button>";
                        var queryBtn = "<button class='easyui-linkButton' onclick='queryClaim(" + row.id + ")'>详情</button>";
                        var submitBtn = "<button class='easyui-linkButton' onclick='submitClaim(" + row.id + ")'>提交</button>";
                        return deleteBtn + queryBtn + submitBtn;
                    }
                }
            ]]
        });
    })
    function queryClaim(id) {
        var url = "${pageContext.request.contextPath}/bizClaimVoucher/toCheck?id=" + id;
        location.href = url;
    }


    function deleteClaim(id) {

        console.log(id);

        if (confirm("确定删除这条报销记录吗?")) {
            $.post("${pageContext.request.contextPath}/bizClaimVoucher/deleteBizClaimVoucherById", {"id": id}, function (data) {
                alert(data.msg);
                $("#claimDg").datagrid("reload");
            });
        }
    }

    function submitClaim(id) {

       if (confirm("提交后将不能再修改,确定提交?")) {
            $.post("${pageContext.request.contextPath}/bizClaimVoucher/updataBizClaimVoucherById", {"id": id}, function (data) {
                alert(data.msg);
                $("#claimDg").datagrid("reload");
            })
        }


    }
</script>
</html>
