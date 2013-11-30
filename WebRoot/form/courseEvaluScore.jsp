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
        <html:base/><title>�γ����۽���鿴</title>
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
                    $(function () {
                        $("#maingrid4").ligerGrid({
                            columns: [      
							{ display: 'ͼ����ʾ', isAllowHide: false,render: function (row)
                                {
                                   var html = '<a href="../TeaEvaluation.do?method=teaScoreCharts&q1='+row.Q1+'&q2='+row.Q2+'&q3='+row.Q3+'&q4='+row.Q4+'&q5='+row.Q5+'&q6='+row.Q6+'&q7='+row.Q7+'&q8='+row.Q8+'&q9='+row.Q9+'&q10='+row.Q10+'&q11='+row.Q11+'&qsum='+row.QSum+'" >ͼ����ʾ</a>';
                                    return html;
                                    
                                }
                            },
							{ display: '��ʦ��', name: 'TName', width: 70,align:'center' },
							{ display: '�γ�����', name: 'CName', width: 150,align:'center' },
							{ display: '�γ̺�', name: 'CID', width: 90,align:'center' },     
                            { display: '�������鱥��', name: 'Q1', width: 90,align:'center' },
							{ display: '���������', name: 'Q2', width: 90,align:'center' }, 
							{ display: '�����и�Ⱦ��', name: 'Q3', width: 90,align:'center' }, 
							{ display: '�����������', name: 'Q4', width: 90,align:'center' }, 
							{ display: '�����������', name: 'Q5', width: 90,align:'center' }, 
							{ display: '��Ϥ�γ�����', name: 'Q6', width: 90,align:'center' }, 
							{ display: '�������ݳ�ʵ', name: 'Q7', width: 90,align:'center' }, 
							{ display: '��ϵ��ѧ��չ', name: 'Q8', width: 90,align:'center' }, 
							{ display: '����ѧ��˼��', name: 'Q9', width: 90,align:'center' }, 
							{ display: '�������ջ�Ծ', name: 'Q10', width: 90,align:'center' }, 
							{ display: '���ý�ѧý��', name: 'Q11', width: 90,align:'center' }, 
							{ display: '�ۺ�����', name: 'QSum', width: 60,align:'center' },    
							{ display: '��������', name: 'Number', width: 60,align:'center' },
                            
                            ], data: <%=request.getAttribute("courseScores") %>, pageSize: 30, sortName: 'TID', 
                            width: '100%',height:'100%'
                        }); 
                        $("#pageloading").hide(); 
                    });
                
        </script>
    </head>
    <body style="padding:0px; overflow:hidden">
		<div style="margin:5; padding:5; text-align:right">
		</div>
        <div class="l-loading" style="display:block" id="pageloading">
        </div>
        <div id="maingrid4" style="margin:0; padding:0">
        </div>
        <div style="display:none;">
        </div>
    </body>
</html:html>