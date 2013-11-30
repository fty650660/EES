<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminCreat.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="lib/ligerUI/skins/Silvery/css/ligerui-form.css" rel="stylesheet"
        type="text/css" />
    <script src="lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/ligerui.min.js" type="text/javascript"></script> 
<script type="text/javascript" src="lib/jquery-validation/jquery.validate.js"></script>
<script type="text/javascript" src="lib/jquery-validation/jquery.metadata.js"></script>
<script type="text/javascript" src="lib/jquery-validation/messages_cn.js"></script>
    <script type="text/javascript">
    var a=0;
    var error='用户名已存在';
    var errCode =<%=request.getAttribute("error") %>;

    
    	
        $(function() {
            if (errCode !=null && a==0) {    alert(error);     a=1;};
         $.metadata.setType("attr", "validate");
            var v = $("form").validate({
                debug: true,
                errorPlacement: function(lable, element) {
                    if (element.hasClass("l-textarea")) element.ligerTip({ content: lable.html(), appendIdTo: lable });
                    else if (element.hasClass("l-text-field")) element.parent().ligerTip({ content: lable.html(), appendIdTo: lable });
                    else lable.appendTo(element.parents("td:first").next("td"));
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
                    //alert("Submitted!")
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

    <form name="form1" method="post" action="/EES/admin.do?method=adminEdit&type=1" id="form1">
<div>

        <table cellpadding="0" cellspacing="0" class="l-table-edit" >
            <tr>
                <td align="right" class="l-table-edit-td">管理员姓名:</td>
                <td align="left" class="l-table-edit-td"><input name="txtName" type="text" id="txtName" ltype="text" validate="{required:true,minlength:3,maxlength:10}" /></td>
                <td align="left"></td>
            </tr>
            <tr>
                <td align="right" class="l-table-edit-td">密码:</td>
                <td align="left" class="l-table-edit-td"><input name="password" type="password" id="pwd" ltype="text" validate="{required:true,minlength:3,maxlength:10}" /></td>
                <td align="left"></td>
            </tr>
            <tr>
                <td align="right" class="l-table-edit-td">确认密码:</td>
                <td align="left" class="l-table-edit-td"><input name="repassword" type="password" id="Repwd" ltype="text" validate="{equalTo:'#pwd'}"
"
 /></td>
                <td align="left"></td>
            </tr>
            <tr>
                <td align="right" class="l-table-edit-td">权限:</td>
                <td align="left" class="l-table-edit-td">
                <select name="ddlDepart" id="ddlDepart" ltype="select">
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
</select>
                </td>
            </tr>
        </table>
        
</div>     
<br/>
<input type="submit" value="提交" id="Button1" class="l-button l-button-submit" /> 
<input type="button" value="测试" class="l-button l-button-test"/>
    </form>
    <div style="display:none">
    <!--  数据统计代码 --></div>

    
</body>
</html>
