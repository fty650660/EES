<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<%
	String logintype=request.getParameter("type");
	request.getSession().setAttribute("type",logintype);
	
%>

 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
    <head>
        <html:base/><title>学年学期显示</title>
		
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <link href="../lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
	    <script src="../lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
	    <script src="../lib/ligerUI/js/core/base.js" type="text/javascript"></script>
	    <script src="../lib/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script> 
        <script src="../lib/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
		<script type="text/javascript" >
               
		$(function ()
        {
            $("#maingrid4").ligerGrid({
                columns: [
                            { display: '学年', name: 'XN', width: 500,align:'center', render: function (row)
                                {
                                   
										var html = '<a href="../AdminCheckTea.do?method=showAllTitleByXn&XN='+row.XN+'" >'+row.XN+'</a>';
                                    	return html;					
                                    
                                }
							 }, 
							{ display: '学期', name: 'XQ', width: 500,align:'center' , render: function (row)
                                {
                                   
										var html = '<a href="../AdminCheckTea.do?method=showAllTitleByXnXq&XN='+row.XN+'&XQ='+row.XQ+'" >'+row.XQ+'</a>';
                                    	return html;					
                                    
                                }
							},   
//							
                ], data: <%=request.getAttribute("xnxqString")%>, pageSize: 20, sortName: 'CustomerID',
                width: '100%', height: '99%', checkbox: false
            });
            $("#pageloading").hide();
        });
        </script>
    </head>
    <body style="padding: 3px; overflow: hidden;">
        <div class="l-loading" style="display: block" id="pageloading">
        </div>
        <div id="maingrid4" style="margin: 0; padding: 0">
        </div>
        <div style="display: none;">
        </div>
    </body>
</html:html>
