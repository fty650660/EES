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
        <html:base/><title>按系显示教师课程列表</title>
		
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
        //显示顾客
        function f_showCustomers()
        {
            g = $("#maingrid").ligerGrid({
                columns: [
                { display: '系名', name: 'FACULT', align: 'center'}
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
        //显示顾客订单
        function f_showOrder(row, detailPanel,callback)
        {
            var grid = document.createElement('div'); 
            $(detailPanel).append(grid);
            $(grid).css('margin',10).ligerGrid({
                columns:
                            [
//							{ display: '学院', name: 'DEPT', width: 150,align:'center' },                          
							{ display: '系名', name: 'FACULT', width: 50,align:'center' },
                            { display: '学年', name: 'XN', width: 80,align:'center' ,render: function (row)
                                {								
                                    var html = '<a href="../AdminCheckTea.do?method=showByXN&XN=' + row.XN + '&FACULT=' + row.FACULT + '" >' + row.XN + '</a>';
                                    return html;							                                
                                }
                            }, 
							{ display: '学期', name: 'XQ', width: 40,align:'center' },     
//							{ display: '教师号', name: 'TID', width: 50,align:'center' },  
							{ display: '教师', name: 'TNAME', width: 60,align:'center' ,render: function (row)
                                {								
                                    var html = '<a href="../AdminCheckTea.do?method=showByTnameF&TNAME=' + row.TNAME + '&FACULT=' + row.FACULT + '" >' + row.TNAME + '</a>';
                                    return html;							                                
                                }
                            },
							{ display: '职称', name: 'TITLE', width: 80,align:'center' ,render: function (row)
                                {								
                                    var html = '<a href="../AdminCheckTea.do?method=showByCourseCount&XN=' + row.XN + '&XQ=' + row.XQ+ '&FACULT=' + row.FACULT+ '&TITLE=' + row.TITLE + '" >' + row.TITLE + '</a>';
                                    return html;							                                
                                }
                            },
							{ display: '课程编号', name: 'CID', width: 80,align:'center' },
							{ display: '课程名称', name: 'CNAME', width: 150,align:'center' ,render: function (row)
                                {								
                                    var html = '<a href="../AdminCheckTea.do?method=showByCnameF&CNAME=' + row.CNAME + '&FACULT=' + row.FACULT + '" >'+row.CNAME+'</a>';
                                    return html;							                                
                                }
                            },
							{ display: '课程性质', name: 'COURSETYPE', width: 110,align:'center' ,render: function (row)
                                {								
                                    var html = '<a href="../AdminCheckTea.do?method=showByCourseTypeF&COURSETYPE=' + row.COURSETYPE + '&FACULT=' + row.FACULT + '" >'+row.COURSETYPE+'</a>';
                                    return html;							                                
                                }
                            },
							{ display: '平均成绩', name: 'SUMAVG', width: 70,align:'center',render: function (row)
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
	                                    var html = '无评价';
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
