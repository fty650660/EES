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

            
               switch( parseInt(type)){
                case 1:
				          
			     
                break;
                
                case 2:
                $("#maingrid").ligerGrid({
                
                columns: [
                { display: '院系', name: 'ID', align: 'left', width: 60 },
                { display: '班级', name: 'NAME', minWidth: 120 },
                { display: '查看评价', isAllowHide: false,render: function (row)
                    {
                        var html = '<a href="/EES/admin.do?method=showSelected&type=2&selectedlist='+row.NAME+'" >查看</a>';
                        return html;
                    }
                }
                ], dataAction: 'server', pageSize: 30,
                data: data1, sortName: 'ID',
                width: '100%', height: '100%'
                });
                $("#submit").css("display","none");
                break;
                
                case 3:
                $("#maingrid").ligerGrid({
                checkbox: true,
                columns: [
                { display: '课程', name: 'ID', align: 'left', width: 60 },
                { display: '年级', name: 'NAME', minWidth: 120 }
                ], dataAction: 'server', pageSize: 30,
                data: data1, sortName: 'ID',
                width: '100%', height: '100%'
                });                
                break;
                
                case 5:
                $("#maingrid").ligerGrid({
                //checkbox: true,
                columns: [
                { display: '管理员ID', name: 'ID', align: 'left', width: 60 },
                { display: '姓名', name: 'NAME', minWidth: 120 },
                { display: '级别', name: 'LEVEL', minWidth: 120 },
                { display: '修改权限', isAllowHide: false,render: function (row)
                    {
                        var html = '<a href="/EES/admin.do?method=adminEdit&type=1&Id='+row.ID+'&edit=1" >修改</a>';
                        return html;
                    }
                } ,
                { display: '删除管理员', isAllowHide: false,render: function (row)
                    {
                        var html = '<a href="/EES/admin.do?method=adminEdit&type=3&Id='+row.ID+'" >删除</a>';
                        return html;
                    }
                }
                ], pageSize: 20,
                data: dataAll, pageSize: 30, sortName: 'ID', 
                width: '100%',height:'auto'
                });      
                $("#submit").css("display","none"); 
                $("#create").css("display","block");         
                break;
                
                case 6:
                $("#maingrid").ligerGrid({
                //checkbox: true,
                columns: [
                { display: '问卷号', name: 'ID', align: 'left', width: 60 },
                { display: '内容', name: 'CONTENT',align: 'left', minWidth: 300 },
                { display: '类别', name: 'CATEGORY', minWidth: 80 },
                { display: '权重', name: 'WEIGHT', minWidth: 80 },
                { display: '编辑/修改', isAllowHide: false,render: function (row)
                    {
                        var html = '<a href="/EES/admin.do?method=adminEdit&type=2&Id='+row.ID+'" >修改</a>';
                        return html;
                    }
                } ,
                { display: '删除', isAllowHide: false,render: function (row)
                    {
                        var html = '<a href="/EES/admin.do?method=adminEdit&type=4&Id='+row.ID+'" >删除</a>';
                        return html;
                    }
                }
                ], dataAction: 'server', pageSize: 30,
                data: dataAll, sortName: 'ID',
                width: '100%', height: '100%'
                });  
                $("#submit").css("display","none"); 
                $("#create").css("display","block");                 
                break;
                
                default:
                $("#maingrid").ligerGrid({
                checkbox: true,
                columns: [
                { display: '编号', name: 'ID', align: 'left', width: 60 },
                { display: '姓名', name: 'NAME', minWidth: 120 }
                ], dataAction: 'server', pageSize: 30,
                data: data1, sortName: 'ID',
                width: '100%', height: '100%'
                });                
                break;
                
            }
            grid = $("#maingrid").ligerGetGridManager();
            $("#pageloading").hide();
        });
        
        
        
        
        
        function getCheckedData()
        {
            var rows = grid.getCheckedRows();
            var str = "";
            $(rows).each(function ()
            {
                str += this.ID + ",";
            });
            //$("#selected").value=str;
            //document.getElementById("selected").value=str;
               switch( parseInt(type)){
                case 1:
                document.form1.action="/EES/admin.do?method=showSelected&type=1&selectedlist="+str;
                break;
                case 3:
                document.form1.action="/EES/admin.do?method=showSelected&type=3&selectedlist="+str;
                break;
                case 3:
                document.form1.action="/EES/admin.do?method=showSelected&type=3&selectedlist="+str;
                break;
                case 6:
                document.form1.action="/EES/admin.do?method=showSelected&type=3&selectedlist="+str;
                break;
                default:
                break;
                }

            $.ligerDialog.alert('选择的是' + str);
            }
            
        function edit(){
            if (parseInt(type)==5) window.location.replace("<%=path%>/adminCreate.jsp");
            else if (parseInt(type)==6) {window.location.replace("<%=path%>/questionnaire.jsp")};
            
        }
 
    </script>
</head>
<body style="padding:6px; overflow:hidden;">
<div class="l-loading" style="display:block" id="pageloading"></div> 
  <form name="form1" method="post" action="" >
    <input type="submit" onclick="getCheckedData()"id="submit" value="提交">
    <input type="button" style="display: none" onclick="edit()" id="create" value="新建">
    <div id="maingrid" style="margin:0; padding:0"></div>
  </form>


  <div style="display:none;">
 <input type="text" id="selected" name="selected" /> 
</div>
 
</body>
</html>
