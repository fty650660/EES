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
        <html:base/><title>�Լ����οα�</title>
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
//                            { display: 'ѧԺ����', name: 'Dept', width: 140,align:"center" },
//							{ display: 'ϵ����', name: 'facult',  width: 50,align: 'center' },
							{ display: 'ѧ��', name: 'XN', width: 80,align:'center' }, 
							{ display: 'ѧ��', name: 'XQ', width: 35,align:'center' }, 
//							{ display: '��ʦ��', name: 'TID', width: 80,align:'center' },  
                            { display: '��ʦ����', name: 'TName', width: 50,align:'center' },   
							{ display: '�γ̺�', name: 'CID', width: 100,align:'center' },
							{ display: '�γ�����', name: 'CNAME', width: 160,align:'center' },
							{ display: '�γ�����', name: 'CourseType', width: 110,align:'center' },
                            { display: '�鿴����', name: 'ISEVALU',width: 80,align:'center',render: function (row)
                                {
									if(row.ISEVALU!='null'){
										var html = '<a href="../TeaEvaluation.do?method=oneCourseResult&cid='+row.CID+'&teaid='+row.TID+'&xn='+row.XN+'&xq='+row.XQ+'" >�鿴����</a>';
                                        return html;
										
									}
                                    else{
										var html='������';
										return html;
									}
                                    
                                }
                            },
							{ display: '��������', name: 'TID',width: 80,align:'center',render: function (row)
                                {
								
										var html = '<a href="../TeaEvaluation.do?method=oneCourseResult&cid='+row.CID+'&teaid='+row.TID+'&xn='+row.XN+'&xq='+row.XQ+'" >��������</a>';
                                        return html;
										
		
                                    
                                }
                            }
                            ], data: <%=request.getAttribute("myCourseList") %>, pageSize: 30, sortName: 'TID', 
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
		<form action="<%=request.getContextPath()%>/TeaEvaluation.do?method=courseResults" form="teaEvaluationForm" method="post">
			<input type="submit" id="allCourseScores" value="�鿴���������ۿγ�">
		</form>
        <div id="maingrid4" style="margin:0; padding:0">
        </div>
        <div style="display:none;">
        </div>
    </body>
</html:html>
