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
        <html:base/><title>总教师任课表（高级查询）</title>
		
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <link href="../lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
		<link href="../lib/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css" />
	    <script src="../lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
	    <script src="../lib/ligerUI/js/core/base.js" type="text/javascript"></script>
	    <script src="../lib/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script> 
    	<link href="../lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    	<script src="../lib/ligerUI/js/plugins/ligerToolBar.js" type="text/javascript"></script>
    	<script src="../lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
    	<script src="../lib/ligerUI/js/plugins/ligerFilter.js" type="text/javascript"></script>
    	<script src="../lib/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>
    	<script src="../lib/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
        <script src="ligerGrid.showFilter.js" type="text/javascript"></script>
		<script type="text/javascript" >
        //去掉  大于小于包括,并改变顺序
    $.ligerDefaults.Filter.operators['string'] =
    $.ligerDefaults.Filter.operators['text'] =
    ["like" , "equal", "notequal", "startwith", "endwith" ];

    //这个例子展示了本地过滤，你也可以在服务器端过滤(将过滤规则组成json，以一个参数提交给服务器)
    //相见ligerGrid.showFilter.js
        $(function ()
        {
            window['g'] = 
            $("#maingrid4").ligerGrid({
                columns: [
            { display: '学院', name: 'DEPT', width: 150,align:'center' },                          
							{ display: '系名', name: 'FACULT', width: 50,align:'center' },
                            { display: '学年', name: 'XN', width: 80,align:'center' }, 
							{ display: '学期', name: 'XQ', width: 50,align:'center' },       
							{ display: '教师', name: 'TNAME', width: 80,align:'center'},
							{ display: '课程编号', name: 'CID', width: 50,align:'center' },
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
                ], data: $.extend(true,{},<%=request.getAttribute("allTeaString")%>), pageSize: 30,
                toolbar: { items: [{ text: '高级自定义查询', click: itemclick, icon: 'search2'}]
                },
                width: '90%', height: '80%', checkbox: false
            });
            $("#pageloading").hide();
        });
        function itemclick()
        {
            g.options.data = $.extend(true,{}, <%=request.getAttribute("allTeaString")%>);
            g.showFilter();
        }
        </script>
    </head>
    <body style="padding: 4px; overflow: hidden;">
    <div class="l-loading" style="display: block" id="pageloading">
    </div>
    <div id="maingrid4" style="margin: 0; padding: 0">
    </div>
    <div style="display: none;">
    </div>
</body>
</html:html>
