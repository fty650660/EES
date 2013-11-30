<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%String logintype=request.getParameter("type");
request.getSession().setAttribute("type",logintype); 
//request.getSession().setAttribute("filterOption",${filterOption});
%>
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
    <head>
        <html:base/><title>�ʼ��б�</title>
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

		<script type="text/javascript">    
                                $(function () {
                                    $("#maingrid4").ligerGrid({
                                        columns: [
            //							{ display: '�ʼ����', name: 'ThID', width: 50,align:'center' },  
                                        { display: '����Ա', name: 'TName', width: 50,align:'center' },              
                                        { display: '�ʼ�����', name: 'Theme', width: 120,align:"center" },
            							{ display: 'ѧ��', name: 'SName',  width: 50,align: 'center' },
										{ display: 'ѧ���༶', name: 'CLName', width: 90,align:'center' },
            							{ display: '����ʱ��', name: 'Sub_Time', width: 90,align:'center' },
                                        { display: '�鿴�ʼ�', isAllowHide: false,render: function (row)
                                            {
                                                var html = '<a href="../MailReply.do?method=showMailReply&thid='+row.ThID+'" >�鿴</a>';
                                                return html;
                                                
                                            }
                                        }
                                        ], data: <%=request.getAttribute("mailListString") %>, pageSize: 30, sortName: 'ThID', 
                                        width: '100%',height:'100%'
                                    }); 
                                    $("#pageloading").hide(); 
                                });
                            
                    
        </script>
    </head>
    <body style="padding:0px; overflow:hidden;">
        <div style="margin:5; padding:5; text-align:right">
		<form action="<%= request.getContextPath()%>/MailList.do?method=adminMailList" method="post">
            <select  name="filterOption">
                <option value="1">�༶</option>
                <option value="2">ѧ��</option>
            </select>
			<input type="text" name="stuClName"><input type="submit" value="ɸѡ/ȫѡ�ʼ�">
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
