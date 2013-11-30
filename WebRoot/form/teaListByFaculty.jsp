<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<%
	String logintype=request.getParameter("type");
	request.getSession().setAttribute("type",logintype);
	String root=request.getContextPath();
	
%>

 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
    <head>
        <html:base/><title>��ϵ��ʾ��ʦ�γ��б�</title>
		
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
               
		 var allTeaString=<%=request.getAttribute("allTeaString") %>
		 var facultyString=<%=request.getAttribute("facultyString") %>
//		 var xnString=<%=request.getAttribute("xnString") %>
		 var g;
        $(function ()
        {
            f_showCustomers(); 
        });
        //��ʾ�˿�
        function f_showCustomers()
        {
            g = $("#maingrid").ligerGrid({
                columns: [
                { display: 'ϵ��', name: 'FACULT', align: 'center'}
                ],   

isScroll: true, frozen:false,

pageSizeOptions: [3,10, 20, 30, 40, 50, 100], 
data:facultyString,
                showTitle: false,width:'90%',height:"100%",columnWidth:"100%",
                detail: { onShowDetail: f_showOrder,height:'100%' },
                onError: function (a, b)
                { 
                }
            });
        }
        function f_getOrdersData(FACULT)
        {
            var data = { Rows: [] };
            for (var i = 0; i < allTeaString.Rows.length; i++)
            {
                if (allTeaString.Rows[i].FACULT == FACULT)
                    data.Rows.push(allTeaString.Rows[i]);
            }
            return data;
        }
        //��ʾ�˿Ͷ���
        function f_showOrder(row, detailPanel,callback)
        {
            var grid = document.createElement('div'); 
            $(detailPanel).append(grid);
            $(grid).css('margin',10).ligerGrid({
                columns:
                            [
//							{ display: 'ѧԺ', name: 'DEPT', width: 150,align:'center' },                          
							{ display: 'ϵ��', name: 'FACULT', width: 50,align:'center' },
                            { display: 'ѧ��', name: 'XN', width: 80,align:'center' ,render: function (row)
                                {								
                                    var html = '<a href="../AdminCheckTea.do?method=showByXN&XN=' + row.XN + '&FACULT=' + row.FACULT + '" >' + row.XN + '</a>';
                                    return html;							                                
                                }
                            }, 
							{ display: 'ѧ��', name: 'XQ', width: 40,align:'center' },     
//							{ display: '��ʦ��', name: 'TID', width: 50,align:'center' },  
							{ display: '��ʦ', name: 'TNAME', width: 60,align:'center' ,render: function (row)
                                {								
                                    var html = '<a href="../AdminCheckTea.do?method=showByTnameF&TNAME=' + row.TNAME + '&FACULT=' + row.FACULT + '" >' + row.TNAME + '</a>';
                                    return html;							                                
                                }
                            },
							{ display: 'ְ��', name: 'TITLE', width: 80,align:'center' ,render: function (row)
                                {								
                                    var html = '<a href="../AdminCheckTea.do?method=showByCourseCount&XN=' + row.XN + '&XQ=' + row.XQ+ '&FACULT=' + row.FACULT+ '&TITLE=' + row.TITLE + '" >' + row.TITLE + '</a>';
                                    return html;							                                
                                }
                            },
							{ display: '�γ̱��', name: 'CID', width: 80,align:'center' },
							{ display: '�γ�����', name: 'CNAME', width: 150,align:'center' ,render: function (row)
                                {								
                                    var html = '<a href="../AdminCheckTea.do?method=showByCnameF&CNAME=' + row.CNAME + '&FACULT=' + row.FACULT + '" >'+row.CNAME+'</a>';
                                    return html;							                                
                                }
                            },
							{ display: '�γ�����', name: 'COURSETYPE', width: 110,align:'center' ,render: function (row)
                                {								
                                    var html = '<a href="../AdminCheckTea.do?method=showByCourseTypeF&COURSETYPE=' + row.COURSETYPE + '&FACULT=' + row.FACULT + '" >'+row.COURSETYPE+'</a>';
                                    return html;							                                
                                }
                            },
							{ display: 'ƽ���ɼ�', name: 'SUMAVG', width: 70,align:'center',render: function (row)
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
	                                    var html = '������';
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
                            ], isScroll: true, showToggleColBtn: false, width: '100%',pageSize: 20,
                data: f_getOrdersData(row.FACULT) , showTitle: false, columnWidth: 100
                 , onAfterShowData: callback,frozen:false
            });  
        }
        </script>
    </head>
    <body style="padding:10px">
        <div id="maingrid">
        </div>
        <br/>
        <div style="display:none;">
            <!-- g data total ttt -->
        </div>
    </body>
</html:html>
