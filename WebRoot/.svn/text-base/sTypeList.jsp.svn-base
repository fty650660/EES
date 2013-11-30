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
        $(function () {
            $("#maingrid").ligerGrid({
                columns: [
                { display: '课程分类', name: 'COURSETYPE', align: 'center', width: 200, minWidth: 60 },
				{ display: '分类选取', isAllowHide: false,render: function (row)
                    {
                        var html = '<a href="/EES/admin.do?method=findByType&chooseType=2&selectedlist='+row.COURSETYPE+'" >进入该分类</a>';
                        return html;
                    }
                }
                ], data: <%=request.getAttribute("List1") %>, sortName: 'COURSETYPE',height:'auto',pageSize:30 
            });
            
            $("#maingrid1").ligerGrid({
                columns: [
                { display: '院系分类', name: 'FACULTY', align: 'center', width: 200, minWidth: 60 },
				{ display: '院系选取', isAllowHide: false,render: function (row)
                    {
                        var html = '<a href="/EES/admin.do?method=findByType&chooseType=1&selectedlist='+row.FACULTY+'" >进入该院系</a>';
                        return html;
                    }
                }
                ], data: <%=request.getAttribute("List") %>, sortName: 'FACULTY',height:'auto',pageSize:30 
            });

           $("#maingrid2").ligerGrid({
                columns: [
                { display: '专业', name: 'MAJOR', align: 'center', width: 200, minWidth: 60 },
                { display: '年级', name: 'GRADE', align: 'center', width: 200, minWidth: 60 },
				{ display: '专业', isAllowHide: false,render: function (row)
                    {
                        var html = '<a href="/EES/admin.do?method=findByType&chooseType=2&selectedlist='+row.MAJOR+'" >'+row.MAJOR+'</a>';
                        return html;
                    }
                },
                { display: '年级', isAllowHide: false,render: function (row)
                    {
                        var html = '<a href="/EES/admin.do?method=findByType&chooseType=2&selectedlist='+row.GRADE+'" >'+row.GRADE+'</a>';
                        return html;
                    }
                }
                ], data: <%=request.getAttribute("List2") %>, sortName: 'MAJOR',height:'auto',pageSize:30 
            });

            $("#pageloading").hide(); 
        });
    </script>

  </head>

 <body style="padding:0px; overflow:hidden;">
<div class="l-loading" style="display:block" id="pageloading"></div> 
<h3>课程分类</h3>
    <div id="maingrid"></div>
    <br />
<h3>院系分类</h3>
    <div id="maingrid1"></div>
    <br />
  <div style="display:none;">
  
</div>
</body>
</html:html>