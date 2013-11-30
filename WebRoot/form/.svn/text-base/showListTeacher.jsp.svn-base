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
    <!--<script src="lib/ligerUI/js/core/base.js" type="text/javascript"></script>
    -->
    <script src="lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/ligerui.all.js" type="text/javascript"></script>
    <!-- 
    <script src="lib/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script> 
    <script src="lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
    -->
    <script type="text/javascript">
   		var dataAll=<%=request.getAttribute("List") %>;
   		var dataType=<%=request.getAttribute("List1") %>;
   		var type=<%=request.getAttribute("Type") %>;
        var grid;
        var g;
        var grid1;
        $(function ()
        {
            f_showCustomers(); 
            
            
            
            $("#pageloading").hide(); 
        });
        //显示顾客
        function f_showCustomers()
        {
           g = $("#maingrid").ligerGrid({
           		checkbox: true,
                columns: [
                { display: '院系类别', name: 'FACULTY', align: 'center'}
                ],   

isScroll: true, frozen:false,

pageSizeOptions: [3,10, 20, 30, 40, 50, 100], 
data:dataType,
                showTitle: false,width:'90%',height:'100%',columnWidth:'100%',
                detail: { onShowDetail: f_showOrder,height:'100%' },
                onError: function (a, b)
                { 
                }
            });
            
        }
        function f_getOrdersData(FACULTY)
        {
            var data = { Rows: [] };
            for (var i = 0; i < dataAll.Rows.length; i++)
            {
                if (dataAll.Rows[i].FACULTY == FACULTY)
                    data.Rows.push(dataAll.Rows[i]);
            }
            return data;
        }
        //显示顾客订单
        function f_showOrder(row, detailPanel,callback)
        {
            var grid = document.createElement('div'); 
            $(detailPanel).append(grid);
            $(grid).css('margin',10).ligerGrid({
            	checkbox: true,
                columns:
                            [
                            { display: '课程编号', width: 80, name: 'CID',type:'float' },
                            { display: '课程名', name: 'CNAME',type:'float' },
                            { display: '班号', name: 'CNO', width: 40,type:'float' },
                            { display: '教师ID', width: 70, name: 'TID' },
                            { display: '教师名称',width: 70, name: 'TNAME' },
                            { display: '已评价人数', width: 70, name: 'EVLNUM' },
                            { display: '班级人数', width: 60, name: 'NUM' },
                            { display: '院系', width: 80, name: 'FACULTY' },
                            { display: '查看评价', isAllowHide: false,render: function (row)
		                    {
		                    if(row.EVLNUM >5){
		                    	var html = '<a href="/EES/admin.do?method=showSelected&type=2&selectedlist='+row.CID+','+row.TID+','+row.CNO+'-" >查看评价</a>';
		                        return html;}
		                        else {var html = '<p>评价人数过少不显示结果</p>';
		                        return html;};
		
		                    }
                			}
                            ], isScroll: true, showToggleColBtn: false, width: '100%', pageSize: 20,
                data: f_getOrdersData(row.FACULTY) , showTitle: false, columnWidth: 100
                 ,onAfterShowData: callback,frozen:false
            }); 
             
        }
        
        
        function getCheckedData()
        {	grid1 = $("#maingrid").ligerGetGridManager();
            var rows = grid1.getCheckedRows();
            
            var str = "";
            $(rows).each(function ()
            {
                str += this.CID+ "," +this.TID+ "," +this.CNO+"-";
                
            });
            
            $.ligerDialog.alert('选择的是' + str,'提示', 'success');
            //document.form1.action="/EES/admin.do?method=showSelected&type=1&selectedlist="+str;
			//document.form1.submit();

            
            }
 
    </script>
</head>
<body style="padding:6px; overflow:hidden;">
<div class="l-loading" style="display:block" id="pageloading"></div>

  <form name="form1" method="post" action="">
    <input type="button" onclick="getCheckedData()" value="Get Checked Data" />

    <div id="maingrid" style="margin:0; padding:0"></div>
  </form>


  <div style="display:none;">
 <input type="text" id="selected" name="selected" /> 
</div>
 
</body>
</html>