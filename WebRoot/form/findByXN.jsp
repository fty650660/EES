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
        <html:base/><title>ͬϵ��ʦ�οα�</title>
		
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
                			{ display: 'ѧԺ', name: 'DEPT', width: 150,align:'center' },                          
							{ display: 'ϵ��', name: 'FACULT', width: 50,align:'center' },
                            { display: 'ѧ��', name: 'XN', width: 80,align:'center' }, 
							{ display: 'ѧ��', name: 'XQ', width: 50,align:'center' },   
//							{ display: '��ʦ��', name: 'TID', width: 50,align:'center' },    
							{ display: '��ʦ', name: 'TNAME', width: 80,align:'center'},
							{ display: '�γ̱��', name: 'CID', width: 90,align:'center' },
							{ display: '�γ�����', name: 'CNAME', width: 150,align:'center'},
							{ display: '�γ�����', name: 'COURSETYPE', width: 110,align:'center'},
							{ display: 'ƽ���ɼ�', name: 'SUMAVG', width: 100,align:'center',render: function (row)
                                {
									if(row.SUMAVG=='null'){
	                                    var html = '<p>������</p>';
	                                    return html;
									}
									else {
									   if(row.SUMAVG>=90)
									       return "��" 
									   if(row.SUMAVG>=80 && row.SUMAVG<90)
									       return "��"
									   if(row.SUMAVG>=70 && row.SUMAVG<80)
									       return "��"
									   if(row.SUMAVG>=60 && row.SUMAVG<70)	   
										   return "�ϸ�"
									   if(row.SUMAVG<60)
									       return "���ϸ�"
									}                                    
                                }
                            },
							{ display: '��������', name: 'NUM', width: 50,align:'center',render: function (row)
                                {
									if(row.SUMAVG=='null'){
	                                    var html = '<p>������</p>';
	                                    return html;
									}
									else {
									   return row.NUM
									}                                    
                                }
                            },
							{ display: '��ϸ����', isAllowHide: false,render: function (row)
                                {
                                    if(row.NUM=='null'){
										var html = '<p>�޷��鿴</p>';
	                                    return html;
									}
									else{
										var html = '<a href="../TeaEvaluation.do?method=oneCourseResult&cid='+row.CID+'&teaid='+row.TID+'&xn='+row.XN+'&xq='+row.XQ+'" >�鿴����</a>';
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
