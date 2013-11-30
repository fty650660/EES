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
        <html:base/><title>邮件列表</title>
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
//							{ display: '邮件编号', name: 'ThID', width: 50,align:'center' },  
                            { display: '收件人', name: 'TName', width: 50,align:'center' },              
                            { display: '邮件主题', name: 'Theme', width: 120,align:"center" },
//							{ display: '发件人', name: 'SName',  width: 50,align: 'center' },
							{ display: '发送时间', name: 'Sub_Time', width: 90,align:'center' },
                            { display: '查看邮件', isAllowHide: false,render: function (row)
                                {
                                    var html = '<a href="../MailReply.do?method=showMailReply&thid='+row.ThID+'" >查看</a>';
                                    return html;
                                    
                                }
                            }
                            ], data: <%=request.getAttribute("mailListString") %>, pageSize: 30, sortName: 'ThID', 
                            width: '100%',height:'100%'
                        }); 
                        $("#pageloading").hide(); 
                    });
                
        </script>
		<script type="text/javascript">
			function clearText(){
				$("#adminName").val("");
			}
		</script>
    </head>
    <body style="padding:0px; overflow:hidden">
		<div style="margin:5; padding:5; text-align:right">
			<form action="<%= request.getContextPath()%>/MailList.do?method=stuMailList" method="post">
				收件人（管理员）名称：
				<input id="adminName" type="text" name="adminName">
				<input type="submit" value="筛选邮件/显示全部">
			</form>
		</div>
        <div class="l-loading" style="display:block" id="pageloading">
        </div>
        <div id="maingrid4" style="margin:0; padding:0">
        </div>
        <div style="display:none;">
        </div>
    </body>
</html:html>
