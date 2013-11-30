<%@ page language="java" pageEncoding="GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>学生选课表</title>

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
                           { display: '职称', width: 80, name: 'Title' ,render: function (row)                    
                            {
                        var html = '<a href="/EES/admin.do?method=findByType&chooseType=1&selectedlist=WHERE  '+slist+'  Title=\''+row.Title+'\'" >'+row.Title+'</a>';
                        return html;
                    }
                    },
                            { display: '学年', name: 'XN',render: function (row)                           {
                        var html = '<a href="/EES/admin.do?method=findByType&chooseType=1&selectedlist=WHERE XN=\''+row.XN+'\'" >'+row.XN+'</a>';
                        return html;
                    } },
					        { display: '学期', name: 'XQ' , width: 40},
                            { display: '课程数', name: 'CountClass', width: 40 ,render: function (row)                    
                            {
                        var html = '<a href="/EES/admin.do?method=findByType&chooseType=1&selectedlist=WHERE '+slist+'  Title=\''+row.Title+'\' AND XN=\''+row.XN+'\'" >'+row.CountClass+'</a>';
                        return html;
                    }
                    },
                            { display: '优课程数', width: 70, name: 'you' ,render: function (row)                    
                            {
                        var html = '<a href="/EES/admin.do?method=findByType&chooseType=1&selectedlist=WHERE '+slist+'  Title=\''+row.Title+'\' AND XN=\''+row.XN+'\' AND Total>=80" >'+row.you+'</a>';
                        return html;
                    }
                    },
                            { display: '良课程数',width: 70, name: 'liang'  ,render: function (row)                   
                            {
                        var html = '<a href="/EES/admin.do?method=findByType&chooseType=1&selectedlist=WHERE '+slist+'  Title=\''+row.Title+'\' AND XN=\''+row.XN+'\' AND Total>=70 AND Total<80" >'+row.liang+'</a>';
                        return html;
                    }
                    },
                            { display: '中课程数', width: 70, name: 'zhong'   ,render: function (row)                  
                            {
                        var html = '<a href="/EES/admin.do?method=findByType&chooseType=1&selectedlist=WHERE '+slist+'  Title=\''+row.Title+'\' AND XN=\''+row.XN+'\' AND Total>=60 AND Total<70" >'+row.zhong+'</a>';
                        return html;
                    }
                    },
                            { display: '差课程数', width: 60, name: 'cha'      ,render: function (row)               
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
<h3>课程分类</h3>
    <div id="maingrid"></div>
    <br />
  <div style="display:none;">
  
</div>
</body>
</html:html>