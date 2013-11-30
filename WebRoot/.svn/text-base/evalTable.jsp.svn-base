<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'evalCharts.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <script src="lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/ligerui.all.js" type="text/javascript"></script>
<script type=text/javascript>
  var data1=<%=request.getAttribute("selected") %>;
  //{Rows:[{"CID":"071210T210","TNAME":"易丛琴","TID":"20069518","CNAME":"光纤通信","CATEGORY1":"50","CATEGORY2":"50","CATEGORY3":"50","CATEGORY4":"50","AVERAGE":"50","NUMBER":"1"}],Total:1};
  //<%=request.getAttribute("selected") %>;
  
    $(function () {
            $("#maingrid").ligerGrid({
            	checkbox: true,
                columns: [
                            { display: '课程编号', width: 80, name: 'CID',type:'float' },
                            { display: '课程名', name: 'CNAME',type:'float' },
                            { display: '班级号', width: 70, name: 'CNO' },
                            { display: '教师ID', width: 70, name: 'TID' },
                            { display: '教师名称',width: 70, name: 'TNAME' },
                            { display: '教学态度',width: 70, name: 'CATEGORY1' },
                            { display: '教学内容',width: 70, name: 'CATEGORY2' },
                            { display: '教学方法与手段',width: 110, name: 'CATEGORY3' },
                            { display: '教学效果',width: 70, name: 'CATEGORY4' },
                            { display: '平均值', width: 70, name: 'AVERAGE' }
                           
                ], data:data1, sortName: 'CID',height:'auto',pageSize:30 ,
                onCheckRow: function (checked,data,rowobj,rowindex)
                {
                    checked && $.ligerDialog.alert('选择的是'+data.CNAME,'提示', 'success');
                }
            });
            grid = $("#maingrid").ligerGetGridManager();
            $("#pageloading").hide();
        });
        
        function getCheckedData()
        { //$.ligerDialog.alert('提示内容', '提示', type);
            
            var rows = grid.getCheckedRows();
            var str = "";
            
            $(rows).each(function ()
            {
                
                str += this.CID+ "," +this.TID+ "," +this.CNO+"-";
                
            });
            $.ligerDialog.alert('选择的是' + str,'提示', 'success');
            document.form1.action="/EES/admin.do?method=showSelected&type=1&selectedlist="+str;
			document.form1.submit();
            
            }
</script>
  </head>
  
 <body>
 <form name="form1" method="post" action="">
<input type="submit" onclick="getCheckedData()"id="submit1" value="显示图表">
<div id="maingrid"></div>

</form>
  </body>
</html>
