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
               
		var grid=null;
//		var courseListString=<%=request.getAttribute("courseListString")%>;
                    $(function () {
                       grid=$("#maingrid4").ligerGrid({
                            columns: [
							{ display: '学院名称', name: 'Dept', width: 140,align:"center" },
							{ display: '系名称', name: 'facult',  width: 50,align: 'center' },
							//{ display: '教师号', name: 'TID', width: 80,align:'center' },  
							{ display: '学年', name: 'XN', width: 80,align:'center' }, 
							{ display: '学期', name: 'XQ', width: 35,align:'center' },       
							{ display: '教师姓名', name: 'TName', width: 50,align:'center' },   
							{ display: '职称', name: 'Title', width: 50,align:'center' },                        
							{ display: '课程号', name: 'CID', width: 100,align:'center' },
							{ display: '课程名称', name: 'CNAME', width: 160,align:'center' },
							{ display: '选课班号', name: 'CLASSNUM', width: 50,align:'center' },
							{ display: '课程性质', name: 'CourseType', width: 110,align:'center' },
//                            { display: '听课评价', isAllowHide: false,render: function (row)
							{ display: '听课评价', name: 'ISEVALU',render: function (row)
                                {
									if(row.ISEVALU=='null'){
	                                    var html = '<a href="../TeaEvaluation.do?method=fillinEvaluTable&teaid='+row.TID+'&teaname='+row.TName+'&cid='+row.CID+'&coursetype='+row.CourseType+'&cname='+row.CNAME+'&dept='+row.Dept+'&classnum='+row.CLASSNUM+'&xn='+row.XN+'&xq='+row.XQ+'" >评价</a>';
	                                    return html;
									}
									else{
										var html = '<a href="../TeaEvaluation.do?method=fillinEvaluTable&teaid='+row.TID+'&teaname='+row.TName+'&cid='+row.CID+'&coursetype='+row.CourseType+'&cname='+row.CNAME+'&dept='+row.Dept+'&classnum='+row.CLASSNUM+'&xn='+row.XN+'&xq='+row.XQ+'" >查看/打印</a>';
	                                    return html;
									}                                    
                                }
                            }
                            ], data: $.extend(true,{},<%=request.getAttribute("courseListString")%>), pageSize: 30,where : f_getWhere(), sortName: 'TID', 
                            width: '100%',height:'100%'
                        }); 
                        $("#pageloading").hide(); 
                    });
                function f_search()
		        {
		            grid.options.data = $.extend(true,{},<%=request.getAttribute("courseListString")%>);
		            grid.loadData(f_getWhere());
		        }
		        function f_getWhere()
		        {
		            if(!grid) return null;
		            var clause = function (rowdata, rowindex)
		            {
		                var key = $("#txtKey").val();
		                if($("#selector").val()=='1')
							return rowdata.TName.indexOf(key) > -1;
						else
							return rowdata.CNAME.indexOf(key) > -1;
		            };
		            return clause; 
		        }
        </script>
    </head>
    <body style="padding:0px; overflow:hidden">
		<div style="margin:5; padding:5; text-align:right">
		</div>
        <div class="l-loading" style="display:block" id="pageloading">
        </div>
		<div id="searchbar">
			<select id="selector">
				<option value="1">教师姓名</option>
				<option value="2">课程名称</option>				
			</select>		
		    <input id="txtKey" type="text" />
		    <input id="btnOK" type="button" value="查找" onclick="f_search()" />
		</div>
        <div id="maingrid4" style="margin:0; padding:0">
        </div>
        <div style="display:none;">
        </div>
    </body>
</html:html>
