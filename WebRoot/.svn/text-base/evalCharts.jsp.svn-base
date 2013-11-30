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
    <script type="text/javascript" src="lib/jscharts.js"></script>
<script type=text/javascript>
  var data=<%=request.getAttribute("selected") %>;
  
  //[{"CID":"071210T210","TNAME":"易丛琴","TID":"20069518","CNAME":"光纤通信","CATEGORY1":"50","CATEGORY2":"50","CATEGORY3":"50","CATEGORY4":"50","AVERAGE":"50","NUMBER":"1"}];
  //<%=request.getAttribute("selected") %>;
  


    
    
</script>
</head>
<body>
<script type=text/javascript>
    for (var i=0; i < data.length; i++) {
      document.write("<div id=\"graph"+i+"\" style=\"float: left\">Loading graph...</div>");
    };
</script>
<div align="left" style="float: left"></div>

<script type=text/javascript>

     for (var i=0; i < data.length; i++) {
      var myData = new Array();
      myData.push(['教学态度', parseInt(data[i].CATEGORY1)]);
      myData.push(['教学内容', parseInt(data[i].CATEGORY2)]);
      myData.push(['教学方法与手段', parseInt(data[i].CATEGORY3)]);
      myData.push(['教学效果', parseInt(data[i].CATEGORY4)]);
      myData.push(['总评', parseInt(data[i].AVERAGE)]);
    var colors = ['#AF0202', '#EC7A00', '#FCD200', '#81C714','#81C710'];
    var myChart = new JSChart("graph"+i, 'bar');
    myChart.setDataArray(myData);
    myChart.colorizeBars(colors);
    myChart.setTitle('这是'+data[i].TNAME+'老师的《'+data[i].CNAME+'》课程评价结果');
    myChart.setTitleColor('#8E8E8E');
    myChart.setAxisNameX('');
    myChart.setAxisNameY('%');
    myChart.setAxisColor('#C4C4C4');
    myChart.setAxisNameFontSize(16);
    myChart.setAxisNameColor('#999');
    myChart.setAxisValuesColor('#7E7E7E');
    myChart.setBarValuesColor('#7E7E7E');
    myChart.setAxisPaddingTop(60);
    myChart.setAxisPaddingRight(140);
    myChart.setAxisPaddingLeft(150);
    myChart.setAxisPaddingBottom(40);
    myChart.setTextPaddingLeft(105);
    myChart.setTitleFontSize(11);
    myChart.setBarBorderWidth(1);
    myChart.setBarBorderColor('#C4C4C4');
    myChart.setBarSpacingRatio(50);
    myChart.setGrid(false);
    myChart.setSize(600, 300);
    myChart.setBackgroundImage('chart_bg.jpg');
    myChart.draw();
    };
</script>
  </body>
</html>