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
    <script src="lib/ligerUI/js/ligerui.all.js" type="text/javascript"></script>
    <!--
    
    <script src="lib/ligerUI/js/core/base.js" type="text/javascript"></script> 
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
        $(function ()
        {
            f_showCustomers(); 
        });
        //显示顾客
        function f_showCustomers()
        {
            g = $("#maingrid").ligerGrid({
                columns: [
                { display: '选课类型', name: 'COURSETYPE', align: 'left',frozen:true },
                { display: '选课类型', name: 'COURSETYPE', align: 'center'}
                ],   

isScroll: true, frozen:false,

pageSizeOptions: [3,10, 20, 30, 40, 50, 100], 
data:dataType,
                showTitle: false,width:'90%',columnWidth:340,
                detail: { onShowDetail: f_showOrder,height:'auto' },
                onError: function (a, b)
                { 
                }
            });
        }
        function f_getOrdersData(COURSETYPE)
        {
            var data = { Rows: [] };
            for (var i = 0; i < dataAll.Rows.length; i++)
            {
                if (dataAll.Rows[i].COURSETYPE == COURSETYPE)
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
            	//checkbox: true,
                columns:
                            [
                            { display: '课程编号', name: 'CID',type:'float' },
                            { display: '班号', name: 'CNO', width: 50,type:'float' },
                            { display: '教师ID', name: 'TID' },
                            { display: '教师名称',width: 70, name: 'TNAME' },
                            { display: '已评价人数', width: 70, name: 'EVLNUM' },
                            { display: '班级人数', width: 60, name: 'NUM' },
                            { display: '院系', width: 80, name: 'FACULTY' },
							{ display: '院系', width: 80, name: 'FACULTY' },
                            { display: '查看评价', isAllowHide: false,render: function (row)
                    {
                        var html = '<a href="/EES/admin.do?method=showSelected&type=2&selectedlist='+row.NAME+'" >查看</a>';
                        return html;
                    }
                }
                            ], isScroll: true, showToggleColBtn: false, width: '90%', pageSize: 20,
                data: f_getOrdersData(row.COURSETYPE) , showTitle: false, columnWidth: 100
                 , onAfterShowData: callback,frozen:false
            });  
        }
       
 
    </script>
</head>
<body  style="padding:10px">
 
    <div id="maingrid"></div>
 <br /> 
 <div style="display:none;">
 <!-- g data total ttt -->
</div>
</body>
</html>