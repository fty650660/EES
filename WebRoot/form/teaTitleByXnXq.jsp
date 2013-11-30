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
        <html:base/><title>按年份显示职称统计表</title>
		
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
							{ display: '系名', name: 'FACULT', width: 50,align:'center' },
                            { display: '学年', name: 'XN', width: 80,align:'center' }, 
							{ display: '学期', name: 'XQ', width: 50,align:'center' },   
                            { display: '职称', name: 'TITLE', width: 80,align:'center' }, 
							{ display: '任课数目', name: 'COURSECOUNT', width: 80,align:'center',render: function (row)
                                {								
                                    var html = '<a href="../AdminCheckTea.do?method=showByCourseCount&XN=' + row.XN + '&XQ=' + row.XQ+ '&FACULT=' + row.FACULT+ '&TITLE=' + row.TITLE + '" >' + row.COURSECOUNT + '</a>';
                                    return html;							                                
                                }
							},
							{ display: '优', name: 'YOU', width: 80,align:'center',render: function (row)
                                {								
								  if(row.YOU==0){
								  	return '0';
								  }
								  else{
								  	 var html = '<a href="../AdminCheckTea.do?method=showByYou&XN=' + row.XN + '&XQ=' + row.XQ+ '&FACULT=' + row.FACULT+ '&TITLE=' + row.TITLE + '" >'+ row.YOU + '</a>';
                                    return html;
								  }                        							                                
                                }
							},
							{ display: '良', name: 'LIANG', width: 80,align:'center',render: function (row)
                                {		
								if(row.LIANG==0){
								  	return '0';
								  }
								  else{						
                                    var html = '<a href="../AdminCheckTea.do?method=showByLiang&XN=' + row.XN + '&XQ=' + row.XQ+ '&FACULT=' + row.FACULT+ '&TITLE=' + row.TITLE + '" >'+ row.LIANG + '</a>';
                                    return html;	
									}						                                
                                }
							},
							{ display: '中', name: 'ZHONG', width: 80,align:'center',render: function (row)
                                {		
								if(row.ZHONG==0){
								  	return '0';
								  }
								  else{						
                                    var html = '<a href="../AdminCheckTea.do?method=showByZhong&XN=' + row.XN + '&XQ=' + row.XQ+ '&FACULT=' + row.FACULT+ '&TITLE=' + row.TITLE + '" >'+ row.ZHONG + '</a>';
                                    return html;
									}							                                
                                }
							},
							{ display: '合格', name: 'CHA', width: 80,align:'center',render: function (row)
                                {		
								if(row.CHA==0){
								  	return '0';
								  }
								  else{						
                                    var html = '<a href="../AdminCheckTea.do?method=showByCha&XN=' + row.XN + '&XQ=' + row.XQ+ '&FACULT=' + row.FACULT+ '&TITLE=' + row.TITLE + '" >'+ row.CHA + '</a>';
                                    return html;
									}							                                
                                }
							},
							{ display: '不合格', name: 'BUHEGE', width: 80,align:'center',render: function (row)
                                {		
								if(row.BUHEGE==0){
								  	return '0';
								  }
								  else{						
                                    var html = '<a href="../AdminCheckTea.do?method=showByBuhege&XN=' + row.XN + '&XQ=' + row.XQ+ '&FACULT=' + row.FACULT+ '&TITLE=' + row.TITLE + '" >'+ row.BUHEGE + '</a>';
                                    return html;
									}							                                
                                }
							},
							{ display: '未评价课程数', name: 'NOTEVALUED', width: 80,align:'center',render: function (row)
                                {					
								if(row.NOTEVALUED==0){
								  	return '0';
								  }
								  else{			
                                    var html = '<a href="../AdminCheckTea.do?method=showByNotEvalued&XN=' + row.XN + '&XQ=' + row.XQ+ '&FACULT=' + row.FACULT+ '&TITLE=' + row.TITLE + '" >'+ row.NOTEVALUED + '</a>';
                                    return html;
									}							                                
                                }
							},
							
                ], data: <%=request.getAttribute("allTitleStringXnXq")%>, pageSize: 20, sortName: 'CustomerID',
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
