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

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
	<script src="lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
	<script src="lib/ligerUI/js/core/base.js" type="text/javascript"></script> 
	<script src="lib/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script>
       

	<script src="lib/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
   	<script src="lib/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>

	    <script type="text/javascript">
	    	var type=<%=request.getAttribute("type") %>;
			var a=type;
			if(type==0){       
			$(function () {
          
            $("#maingrid").ligerGrid({
                columns: [
                           { display: '学年', width: 80, name: 'XN' ,render: function (row)                    
                            {
                        var html = '<a href="/EES/admin.do?method=findByType&chooseType=1&selectedlist=WHERE XN=\''+row.XN+'\'" >'+row.XN+'</a>';
                        return html;
                    }
                    },
                            { display: '学期', name: 'XQ',render: function (row)                           {
                        var html = '<a href="/EES/admin.do?method=findByType&chooseType=1&selectedlist=WHERE XN=\''+row.XN+'\' and XQ=\''+row.XQ+'\'" >'+row.XQ+'</a>';
                        return html;
                    } }
                ],isScroll: true, data: <%=request.getAttribute("List") %>, sortName: 'FACULTY',height:'100%',pageSize:30 
            });


            $("#pageloading").hide(); 
        });}
			else {
			
        $(function () {
          
            $("#maingrid").ligerGrid({
                columns: [
                           { display: '学年', width: 80, name: 'XN' ,render: function (row)                    
                            {
                        var html = '<a href="/EES/admin.do?method=showStaticlist&chooseType='+a+'&selectedlist='+row.XN+'" >'+row.XN+'</a>';
                        return html;
                    }
                    },
                            { display: '学期', name: 'XQ',render: function (row)                           {
                        var html = '<a href="/EES/admin.do?method=showStaticlist&chooseType='+a+'&selectedlist='+row.XN+'~'+row.XQ+'" >'+row.XQ+'</a>';
                        return html;
                    } }
                ],isScroll: true, data: <%=request.getAttribute("List") %>, sortName: 'FACULTY',height:'100%',pageSize:30 
            });


            $("#pageloading").hide(); 
        });}
    </script>

  </head>

 <body style="padding:0px; overflow:hidden;">
<div class="l-loading" style="display:block" id="pageloading"></div> 
<h3>课程分类</h3>
    <div id="maingrid"></div>
    <br />
  <div style="display:none;">
  
</div>
</body>
</html:html>