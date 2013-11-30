<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'questionnaire.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

    <link href="lib/ligerUI/skins/Silvery/css/ligerui-form.css" rel="stylesheet"
        type="text/css" />
    <script src="lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/ligerui.all.js" type="text/javascript"></script> 

<script type="text/javascript" src="lib/jquery-validation/jquery.validate.js"></script>
<script type="text/javascript" src="lib/jquery-validation/jquery.metadata.js"></script>
<script type="text/javascript" src="lib/jquery-validation/messages_cn.js"></script>   
    <script type="text/javascript">
        var eee;
        $(function ()
        {
            $.metadata.setType("attr", "validate");
            var v = $("form").validate({
                debug: true,
                errorPlacement: function (lable, element)
                {
                    if (element.hasClass("l-textarea"))
                    {
                        element.ligerTip({ content: lable.html(), target: element[0] }); 
                    }
                    else if (element.hasClass("l-text-field"))
                    {
                        element.parent().ligerTip({ content: lable.html(), target: element[0] });
                    }
                    else
                    {
                        lable.appendTo(element.parents("td:first").next("td"));
                    }
                },
                success: function (lable)
                {
                    lable.ligerHideTip();
                    lable.remove();
                },
                submitHandler: function ()
                {
                    $("form .l-text,.l-textarea").ligerHideTip();
                    document.form1.submit();
                }
            });
            $("form").ligerForm();
        });  
    </script>
    <style type="text/css">
           body{ font-size:12px;}
        .l-table-edit {}
        .l-table-edit-td{ padding:4px;}
        .l-button-submit,.l-button-test{width:80px; float:left; margin-left:10px; padding-bottom:2px;}
        .l-verify-tip{ left:230px; top:120px;}
    </style>


</head>

<body style="padding:10px">

    <form name="form1" method="post" action="/EES/admin.do?method=adminEdit&type=2" id="form1">
<div>
</div>
        <table cellpadding="0" cellspacing="0" class="l-table-edit" >
            <tr>
            	<!--<td><a href="<%=path%>/admin.do?method=adminEdit&type=2">test</a></td>                -->
            	<td align="right" class="l-table-edit-td">问题内容:</td>
                <td align="left" class="l-table-edit-td"> 
                <textarea cols="100" rows="4" class="l-textarea" name="content" id="content" style="width:300px" validate="{required:true,minlength:5,maxlength:100}" ></textarea>
                </td><td align="left"></td>
            </tr>
            <tr>
                <td align="right" class="l-table-edit-td">权重:</td>
                <td align="left" class="l-table-edit-td">
                    <input name="txtWeight" type="text" id="txtWeight" ltype='spinner' ligerui="{type:'int'}" value="1" class="required" validate="{digits:true,min:1,max:10}" />
                </td><td align="left"></td>
            </tr>
            <tr>
                <td align="right" class="l-table-edit-td">评价类别:</td>
                <td align="left" class="l-table-edit-td">
                <select name="Category" id="Category" ltype="select">
	<option value="1">教学态度</option>
	<option value="2">教学内容</option>
	<option value="3">教学方法与手段</option>
	<option value="4">教学效果</option>
</select>
                </td>
            </tr>
            
            <tr>
                <td align="right" class="l-table-edit-td">添加描述:</td>
                <td align="left" class="l-table-edit-td"> 
                <textarea cols="100" rows="4" class="l-textarea" name="describe" id="describe" style="width:300px" validate="{required:true,minlength:10,maxlength:125}"></textarea>
                </td><td align="left"></td>
            </tr>
        </table>
 <br />
<input type="submit" value="提交" id="Button1" class="l-button l-button-submit"  /> 
<input type="button" value="测试" class="l-button l-button-test"/>
    </form>
    <div style="display:none">
    <!--  数据统计代码 --></div>

    
</body>
</html>
