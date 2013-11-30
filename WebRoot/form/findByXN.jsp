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
        <html:base/><title>同系教师任课表</title>
		
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
                			{ display: '学院', name: 'DEPT', width: 150,align:'center' },                          
							{ display: '系名', name: 'FACULT', width: 50,align:'center' },
                            { display: '学年', name: 'XN', width: 80,align:'center' }, 
							{ display: '学期', name: 'XQ', width: 50,align:'center' },   
//							{ display: '教师号', name: 'TID', width: 50,align:'center' },    
							{ display: '教师', name: 'TNAME', width: 80,align:'center'},
							{ display: '课程编号', name: 'CID', width: 90,align:'center' },
							{ display: '课程名称', name: 'CNAME', width: 150,align:'center'},
							{ display: '课程性质', name: 'COURSETYPE', width: 110,align:'center'},
							{ display: '平均成绩', name: 'SUMAVG', width: 100,align:'center',render: function (row)
                                {
									if(row.SUMAVG=='null'){
	                                    var html = '<p>无评价</p>';
	                                    return html;
									}
									else {
									   if(row.SUMAVG>=90)
									       return "优" 
									   if(row.SUMAVG>=80 && row.SUMAVG<90)
									       return "良"
									   if(row.SUMAVG>=70 && row.SUMAVG<80)
									       return "中"
									   if(row.SUMAVG>=60 && row.SUMAVG<70)	   
										   return "合格"
									   if(row.SUMAVG<60)
									       return "不合格"
									}                                    
                                }
                            },
							{ display: '评价人数', name: 'NUM', width: 50,align:'center',render: function (row)
                                {
									if(row.SUMAVG=='null'){
	                                    var html = '<p>无评价</p>';
	                                    return html;
									}
									else {
									   return row.NUM
									}                                    
                                }
                            },
							{ display: '详细评价', isAllowHide: false,render: function (row)
                                {
                                    if(row.NUM=='null'){
										var html = '<p>无法查看</p>';
	                                    return html;
									}
									else{
										var html = '<a href="../TeaEvaluation.do?method=oneCourseResult&cid='+row.CID+'&teaid='+row.TID+'&xn='+row.XN+'&xq='+row.XQ+'" >查看评价</a>';
                                    	return html;
									}
                                    
                                }
                            }
                ], data: <%=request.getAttribute("showByXNString")%>, pageSize: 20, sortName: 'CustomerID',
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
