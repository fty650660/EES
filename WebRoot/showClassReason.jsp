<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
	<script src="lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
	<script src="lib/ligerUI/js/core/base.js" type="text/javascript"></script> 
	<script src="lib/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script>
       

	<script src="lib/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
   	<script src="lib/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>
    <script type="text/javascript">

$(function () {
  
    $("#maingrid").ligerGrid({
        columns: [
					{ display: '评价号', width: 60, name: 'Markid',type:'float' },
					{ display: '评论理由', name: 'Reason',type:'float' }
        ], data: <%=request.getAttribute("List") %>, sortName: 'FACULTY',height:'100%',pageSize:30 
    });


    $("#pageloading").hide(); 
});
                        
 
    </script>
</head>
<body style="padding:6px; overflow:hidden;">
<div class="l-loading" style="display:block" id="pageloading"></div>

  <form name="form1" method="post" action="">

    <div id="maingrid" style="margin:0; padding:0"></div>
  </form>


  <div style="display:none;">
 <input type="text" id="selected" name="selected" /> 
</div>
 
</body>
</html>