<%--
  Created by IntelliJ IDEA.
  User: 祖龙浩
  Date: 2018/3/3
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="easyuiBasic.jsp"%>
</head>
<body>

    <div class="easyui-layout" style="width: 100%; height: 100%">
        <div region="north" style="height:15%;padding: 10px">
            <div align="center">
                <h1>JBOA管理系统</h1>
            </div>
            <div align="right">
                <h3>欢迎您${loginUser.name}</h3>
            </div>
        </div>
        <div region="south">
            <div align="center" style="padding: 15px">
                <h4>版权xxx</h4>
            </div>
        </div>
        <div region="west" title="菜单栏" style="width: 15%">
           <li>
               <a href="#" url="${pageContext.request.contextPath}/bizClaimVoucher/toBizClaimVoucher">报销单列表</a>
           </li>
        </div>
        <div region="center">
            <div id="tt" class="easyui-tabs" style="width:100%;height:100%;">
                <div title="首页" >
                    欢迎光临
                </div>

            </div>

        </div>
    </div>
</body>
<script type="application/javascript">
    $(function () {
       $("li>a").click(function () {
            var title=$(this).text();
           var url = $(this).attr("url");
           if($("#tt").tabs("exists",title)){
               $("#tt").tabs("select",title);
           }else{

               var content = "<iframe scrolling='auto' frameborder='0' style='width: 100%;height: 100%' src='"+url+"'></iframe>";
               $("#tt").tabs("add",{
                   title:title,
                   content:content,
                   closable:true
               });
           }

       });


    });


</script>
</html>
