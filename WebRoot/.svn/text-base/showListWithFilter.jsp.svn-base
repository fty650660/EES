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
    <!-- <link href="lib/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css" /> -->
    <link href="lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <script src="lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
	
    <script src="lib/ligerUI/js/core/base.js" type="text/javascript"></script>
	<!--<script src="lib/ligerUI/js/ligerui.all.js"></script>-->
	 <script src="lib/ligerUI/js/plugins/ligerToolBar.js" type="text/javascript"></script>
    
    <script src="lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script> 
  
    <script src="lib/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
	
	
	 <script src="lib/ligerUI/js/plugins/ligerFilter.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/showFilter.js" type="text/javascript"></script>
	
    <script type="text/javascript">
    var errCode=<%=request.getAttribute("errCode") %>;
	var error='您刚才选的课程评价人数过少无法显示！';
	var dataAll=<%=request.getAttribute("List") %>;
	var a=0;
	
	
    //去掉  大于小于包括,并改变顺序
   //去掉  大于小于包括,并改变顺序
  
   
    $.ligerDefaults.Filter.operators['string'] = $.ligerDefaults.Filter.operators['text'] =["like" , "equal"];

    //这个例子展示了本地过滤，你也可以在服务器端过滤(将过滤规则组成json，以一个参数提交给服务器)
    //相见ligerGrid.showFilter.js
        $(function ()
        { if(errCode==1 && a==0){
			$.ligerDialog.alert(error,'提示', 'error');a++;};
            window['g'] =$("#maingrid4").ligerGrid({
                checkbox: true,
                columns: [
                            
                            { display: '课程编号', width: 80, name: 'CID' },
                            { display: '课程名', name: 'CNAME' },
                            { display: '班号', name: 'CNO', width: 40 },
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
                ], data: $.extend(true,{},dataAll), pageSize: 30,
                toolbar: { items: [
{ text: '高级自定义查询', click: itemclick, icon: 'search2'},
{ line: true },
{ text: '提交', click: getCheckedData, icon: 'ok' }
]
},
                width: '90%', height: '80%', checkbox: false
            });
            $("#pageloading").hide();
        });
        function itemclick()
        {
            g.options.data = $.extend(true,{}, dataAll);
            g.showFilter();
        }
        
        
        
                function getCheckedData()
        {   grid1 = $("#maingrid4").ligerGetGridManager();
            var rows = grid1.getCheckedRows();
            
            var a=0;
            var str = "";
            $(rows).each(function ()
            {
            	if(this.EVLNUM==0){a=1};
                str += this.CID+ "," +this.TID+ "," +this.CNO+"-";
                
            });
            if(a==0){
            $.ligerDialog.alert('选择的是' + str,'提示', 'success');
            document.form1.action="/EES/admin.do?method=showSelected&type=1&selectedlist="+str;
			document.form1.submit();
            }else {$.ligerDialog.alert('您选择的课程评价人数过少无法显示','提示', 'error');}


            
            }
			
			//alert("2");
    </script>
</head>
<body style="padding: 4px; overflow: hidden;">
 <form name="form1" method="post" action="">
    <div class="l-loading" style="display: block" id="pageloading">
    </div>
    <div id="maingrid4" style="margin: 0; padding: 0">
    </div>
    <div style="display: none;">
    </div>
	</form>
</body>
</html>
