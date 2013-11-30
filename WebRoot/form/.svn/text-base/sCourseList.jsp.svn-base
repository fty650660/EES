<%@ page language="java" pageEncoding="GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>学生选课表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	  <link href="../lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <script src="../lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
       <script src="../lib/ligerUI/js/ligerui.all.js" type="text/javascript"></script> 
 
    <script type="text/javascript">
var g;
$(function ()
{
g = $("#maingrid").ligerGrid({
columns: [
{ display: '课程号', name: 'CID', align: 'left', width: 120 },
{ display: '课程名', name: 'CNAME', width: 50,align:'left' },
{ display: '老师名', name: 'TNAME', minWidth: 60 },
{ display: '选课类型', name: 'COURSETYPE', minWidth: 60 },
{ display: '学年', name: 'XN', minWidth: 60 },
{ display: '学期', name: 'XQ', minWidth: 60 },
{ display: '评价', isAllowHide: false,render: function (row)
{if(row.TRUE=='未评价'){var html = '<a href="../student.do?method=getQuestionnaire&CID='+row.CID+'&TID='+row.TID+'&CNO='+row.CNO+'&CName='+row.CNAME+'" >评价</a>';
return html;}
else{var html = '<p>已评价</p>';return html;}
}
}
],data: <%=request.getAttribute("datastring") %> , 
pageSize: 20, sortName: 'CID',
width: '98%', height: 'auto', rownumbers:true
});
$("#pageloading").hide();
}); 
    </script>

  </head>

 <body style="padding:0px; overflow:hidden;">
<div class="l-loading" style="display:block" id="pageloading"></div> 
    <div id="maingrid" style="margin:0; padding:0"></div>


  <div style="display:none;">
  
</div>
</body>
</html:html>
