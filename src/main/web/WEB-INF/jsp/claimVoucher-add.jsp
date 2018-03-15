<%@ page import="java.util.Date" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\3\15 0015
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="easyuiBasic.jsp"%>
    <script type="text/javascript">

        $(function () {
//            添加行
            var i = 1;
            $("input[name=addTrButton]").click(function () {
//                alert("测试动态添加表格行按钮");
                var addTr = $("<tr id='addtr"+i+"'>"+
                    "<td>填写类型：</td>"+
                "<td class='selectperson'>"+
                "<select class='selecttext' name='selectid'>"+
                "<option value='0' selected='selected'>--请选择--</option>"+
                "<option value='城际交通费'>城际交通费</option>"+
                "<option value='办公用品费'>办公用品费</option>"+
                "<option value='出差住宿费'>出差住宿费</option>"+
                "<option value='客户餐饮费'>客户餐饮费</option>"+
                "</select>"+
                "</td>"+
                "<td>金额：</td><td><input type='number' name='monkey'></td>"+
                "<td>理由：</td><td><input type='text' name='reason'></td>"+
                "</tr>");


                if (i < 5) {
                    i++;
                    $("#table2").append(addTr);
                }
            })
            //=========================================
            //删除行
            $("input[name=delTrButton]").click(function () {
                if (i > 1) {
                    var id = "#addtr" + (i - 1);
                    $(id).remove();
                    i--;
                }
            })
            //=========================================desc
            var data01="["

            $("input[name=saveButton]").click(function () {
                for(var n=0;n<i;n++){
                    data01=data01+"{'item':'";
                    var test1=$(".movetable tr:eq('"+n+"')>td>select[name=selectid]").val();
                    data01=data01+test1+"',";
                    data01=data01+"'account':'";
                    var test2=$(".movetable tr:eq('"+n+"')>td>input[name=monkey]").val();
                    data01=data01+test2+"',";
                    data01=data01+"'desc':'";
                    var test3=$(".movetable tr:eq('"+n+"')>td>input[name=reason]").val();



                    data01=data01+test3+"'},";
                }
                data01=data01+"]";
                alert(data01);

                $.post("${pageContext.request.contextPath}/bizClaimVoucher/doAddBizClaimVoucher",
                    {data: data01}, function (returnData) {
                        alert(returnData);
                        location.href = "${pageContext.request.contextPath}/bizClaimVoucher/toBizClaimVoucher";
                    }, "json");

            })

//            $("#table2").remove();

        })
    </script>
</head>
<body>
基本信息
<table id="table1">
    <tr>
        <td>填写人：</td>
        <td><input type="text" name="person" value="${loginUser.name}" readonly></td>

        <td>职位：</td>
        <td><input type="text" name="zhiwei" value="${loginUser.sysPositions.nameCn}" readonly></td>
        <td>创建时间：</td>
        <td><fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
    </tr>


    <%--<tr><td colspan="6" align="center"><input type="button" value="测试动态添加表格行按钮" name="addTrButton"></td></tr>--%>
    <%--<tr><td colspan="6" align="center"><input type="button" value="测试动态减行" name="deleteTrButton"></td></tr>--%>
    <%--<tr><td colspan="6" align="center"><input type="button" value="测试提交按钮" name="submitButton"></td></tr>--%>
</table>
<table id="table2" class="movetable">
    <tr id=' addtr1'>
        <td>填写类型：</td>
        <td class='selectperson'>
            <select class='selecttext' name='selectid'>
                <option value='0' selected='selected'>--请选择--</option>
                <option value='城际交通费'>城际交通费</option>
                <option value='办公用品费'>办公用品费</option>
                <option value='出差住宿费'>出差住宿费</option>
                <option value='客户餐饮费'>客户餐饮费</option>
            </select>
        </td>
        <td>金额：</td><td><input type='number' name='monkey'></td>
        <td>理由：</td><td><input type='text' name='reason'></td>
    </tr>

</table>
<table id="table3">
    <tr>
        <td>
            <input type="button" value="+" name="addTrButton">
            <input type="button" value="X" name="delTrButton">
            <input type="button" value="保存" name="saveButton">
        </td>
    </tr>
</table>

</body>
</html>
