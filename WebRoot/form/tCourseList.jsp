<%@ page language="java" pageEncoding="GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>老师任课表</title>
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
        $(function () {
            $("#maingrid4").ligerGrid({
                columns: [
                { display: '课程名', name: 'CNAME', width: 90,align:'left' },
                { display: '班号', name: 'CNO', width: 40,align:'left' },
                { display: '学年', name: 'XN', width: 80,align:'left' },
                { display: '学期', name: 'XQ', width: 50,align:'left' },
                { display: '已评价人数', name: 'EVLNUM', width: 70,align:'left' },
                { display: '班级人数', name: 'NUM', width: 50,align:'left' },
                { display: '查看评价', isAllowHide: false,render: function (row)
                    {
                    if(row.EVLNUM >5){var html = '<a href="../teacher.do?method=getValresult&CID='+row.CID+'&TID='+row.TID+'&CNO='+row.CNO+'" >查看评价</a>';
                        return html;}
                        else {var html = '<p>评价人数过少不显示结果</p>';
                        return html;};

                    }
                }
                ], data: <%=request.getAttribute("datastring") %>, pageSize: 30, sortName: 'SID', 
                width: '100%',height:'auto'
            }); 
            $("#pageloading").hide(); 
        });
    </script>

  </head>

 <body style="padding:0px; overflow:hidden;">
<div class="l-loading" style="display:block" id="pageloading"></div> 
    <div id="maingrid4" style="margin:0; padding:0"></div>


  <div style="display:none;">
  
</div>
</body>
</html:html>