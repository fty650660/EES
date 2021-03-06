<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <script src="lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="lib/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerToolBar.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>

    <script src="lib/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script> 
    <script src="lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>

    <script type="text/javascript">
   		var dataAll=<%=request.getAttribute("List") %>;
   		var type=<%=request.getAttribute("Type") %>;
        var grid;
        var g;
        var grid1;
        $(function () {
            $("#maingrid").ligerGrid({
            	checkbox:true,
                columns: [
                          { display: '课程名', width: 150, name: 'CNAME' ,render: function (row)                    
                              {
                          var html = '<a href="/EES/admin.do?method=findByType&chooseType=1&selectedlist=WHERE CID=\''+row.CID+'\'" >'+row.CNAME+'</a>';
                          return html;
                      }
                      },
                          { display: '班号',width: 35, name: 'ClassNum',type:'float' },
                          { display: '教师名称', width: 70, name: 'TNAME' ,render: function (row)                    
                              {
                          var html = '<a href="/EES/admin.do?method=findByType&chooseType=1&selectedlist=WHERE TID=\''+row.TID+'\'" >'+row.TNAME+'</a>';
                          return html;
                      }
                      },
 
                          { display: '职务',width: 80, name: 'Title' },
                          { display: '院系', width: 50, name: 'FACULTY' },
                          { display: '专业',width: 50, name: 'Major' },
                          { display: '学年', name: 'XN',width: 70,render: function (row)                           {
                              var html = '<a href="/EES/admin.do?method=findByType&chooseType=1&selectedlist=WHERE XN=\''+row.XN+'\'" >'+row.XN+'</a>';
                              return html;
                          } },      
                          { display: '学期', width: 40, name: 'XQ' },                   
                          { display: '课程类型', width: 80, name: 'CourseType' },
                          { display: '已评价人数', width: 70, name: 'EVLNUM',type:'float' },
                          { display: '班级人数', width: 60, name: 'NUM',type:'float' },
                          { display: '分数', width: 60, name: 'Total',type:'float' },
                          { display: '查看评价', isAllowHide: false,render: function (row)
		                    {
                        	  
		                    if(row.EVLNUM >5){
		                    	var html = '<a href="/EES/admin.do?method=findByType&chooseType=4&selectedlist='+row.CID+','+row.TID+','+row.ClassNum+','+row.XN+'" >查看评价</a>';
		                        return html;}
		                        else {var html = '<p>评价人数过少不显示结果</p>';
		                        return html;};
		
		                    }
              			}
                          ], data: dataAll,
                          toolbar: { items: [
{ text: '提交', click: getCheckedData, icon: 'ok' }
]
},
sortName: 'CID',height:'100%',pageSize:30 
            });
            



           

            $("#pageloading").hide(); 
        });

        
        
        function getCheckedData()
        {	grid1 = $("#maingrid").ligerGetGridManager();
            var rows = grid1.getCheckedRows();
            var a=0;
            var str = "";
            $(rows).each(function ()
            {
            	if(this.EVLNUM==0){a=1};
                str += this.CID+ "," +this.TID+ "," +this.ClassNum+ "," +this.XN+ "-";
                
            });
            if(a==0){
            $.ligerDialog.alert('选择的是' + str,'提示', 'success');
            document.form1.action="/EES/admin.do?method=showSelected&type=2&selectedlist="+str;
			document.form1.submit();
            }else {$.ligerDialog.alert('您选择的课程评价人数过少无法显示','提示', 'error');}

            
            }
 
    </script>
</head>
<body style="padding:6px; overflow:hidden;">
<div class="l-loading" style="display:block" id="pageloading"></div>

  <form name="form1" method="post" action="">

    <div id="maingrid" style="margin:0; padding:0"></div>
  </form>


  <div style="display:none;">
 <input type="text" id="selected" name="selected" /> 
</div>
 
</body>
</html>