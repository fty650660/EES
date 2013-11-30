<%@ page language="java" pageEncoding="GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>ѧ��ѡ�α�</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
	<script src="lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
	<script src="lib/ligerUI/js/core/base.js" type="text/javascript"></script> 
	<script src="lib/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script>
       

	<script src="lib/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
   	<script src="lib/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>

	    <script type="text/javascript">
	    	var slist=${slist};
			var slist1=<%=request.getAttribute("slist1") %>;
			if(slist1==null){
				slist= 'XN=\''+slist+'\' and ';
			}else {
				slist= 'XN=\''+slist+'\' and XQ=\''+slist1+'\' and ';	
			}
        $(function () {
          
            $("#maingrid").ligerGrid({
                columns: [
                           { display: 'ְ��', width: 80, name: 'Title' ,render: function (row)                    
                            {
                        var html = '<a href="/EES/admin.do?method=findByType&chooseType=1&selectedlist=WHERE  '+slist+'  Title=\''+row.Title+'\'" >'+row.Title+'</a>';
                        return html;
                    }
                    },
                            { display: 'ѧ��', name: 'XN',render: function (row)                           {
                        var html = '<a href="/EES/admin.do?method=findByType&chooseType=1&selectedlist=WHERE XN=\''+row.XN+'\'" >'+row.XN+'</a>';
                        return html;
                    } },
					        { display: 'ѧ��', name: 'XQ' , width: 40},
                            { display: '�γ���', name: 'CountClass', width: 40 ,render: function (row)                    
                            {
                        var html = '<a href="/EES/admin.do?method=findByType&chooseType=1&selectedlist=WHERE '+slist+'  Title=\''+row.Title+'\' AND XN=\''+row.XN+'\'" >'+row.CountClass+'</a>';
                        return html;
                    }
                    },
                            { display: '�ſγ���', width: 70, name: 'you' ,render: function (row)                    
                            {
                        var html = '<a href="/EES/admin.do?method=findByType&chooseType=1&selectedlist=WHERE '+slist+'  Title=\''+row.Title+'\' AND XN=\''+row.XN+'\' AND Total>=80" >'+row.you+'</a>';
                        return html;
                    }
                    },
                            { display: '���γ���',width: 70, name: 'liang'  ,render: function (row)                   
                            {
                        var html = '<a href="/EES/admin.do?method=findByType&chooseType=1&selectedlist=WHERE '+slist+'  Title=\''+row.Title+'\' AND XN=\''+row.XN+'\' AND Total>=70 AND Total<80" >'+row.liang+'</a>';
                        return html;
                    }
                    },
                            { display: '�пγ���', width: 70, name: 'zhong'   ,render: function (row)                  
                            {
                        var html = '<a href="/EES/admin.do?method=findByType&chooseType=1&selectedlist=WHERE '+slist+'  Title=\''+row.Title+'\' AND XN=\''+row.XN+'\' AND Total>=60 AND Total<70" >'+row.zhong+'</a>';
                        return html;
                    }
                    },
                            { display: '��γ���', width: 60, name: 'cha'      ,render: function (row)               
                            {
                        var html = '<a href="/EES/admin.do?method=findByType&chooseType=1&selectedlist=WHERE '+slist+'  Title=\''+row.Title+'\' AND XN=\''+row.XN+'\' AND Total<60" >'+row.cha+'</a>';
                        return html;
                    }
                    }
                ], data: <%=request.getAttribute("List") %>, sortName: 'FACULTY',height:'100%',pageSize:30 
            });


            $("#pageloading").hide(); 
        });
    </script>

  </head>

 <body style="padding:0px; overflow:hidden;">
<div class="l-loading" style="display:block" id="pageloading"></div> 
<h3>�γ̷���</h3>
    <div id="maingrid"></div>
    <br />
  <div style="display:none;">
  
</div>
</body>
</html:html>