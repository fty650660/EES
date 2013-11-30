<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String test=request.getAttribute("data0").toString();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="expires" content="0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<script type="text/javascript" src="lib/jquery/achart.js"></script>
<script type="text/javascript" src="lib/jscharts.js"></script>
<script>
/**
 * 横向柱形图
 * 
 * @author 	纵横(lrenwang)
 * @email	lrenwang@qq.com
 * @blog	blog.lrenwang.com
 * @qq		3142442
 * @version 1.2
 * 兼容 IE7 FireFox
 */
var bar = function (id,title,data){
	//展示的id
	this.id = '';

	//标题
	this.title = '';

	//数据
	this.data = '';

	//宽
	this.width = 600;
	
	//背景图片位置
	this.bgimg = 'lib/plan.gif';
	
	//动画速度
	this.speed = 2000;

	//投票总数
	var num_all = 0;
	this.show = function (){
		//添加一个table对象
		$("#"+this.id).append("<table width='"+this.width+"' cellpadding=0 cellspacing=6 border=0 style='font-size:12px;' ></table>")

		$("#"+this.id+" table").append("<tr><td colspan=3 align='center' ><span style='font:900 14px ;color:#444'>"+this.title+"</span></td></tr>")

		//计算总数
		$(this.data).each(function(i,n){
			num_all += parseInt(n[1]);
		})

		var that = this;

		//起始
		var s_img = [0,-52,-104,-156,-208];
		//中间点起始坐标
		var c_img = [-312,-339,-367,-395,-420];
		//结束
		var e_img = [-26,-78,-130,-182,-234];
		var that = this;
		var div;
		$(this.data).each(function(i,n){
			
			//计算比例
			var bili = (n[1]*100/num_all).toFixed(2);
			
			//计算图片长度, *0.96是为了给前后图片留空间
			var img = parseFloat(bili)*0.96;
	
			if(img>0)
			{
				div = "<div style='width:3px;height:20px;background:url("+that.bgimg+") 0px "+s_img[i]+"px ;float:left;'></div><div fag='"+img+"' style='width:0%;height:16px;background:url("+that.bgimg+") 0 "+c_img[i]+"px repeat-x ;float:left;'></div><div style='width:3px;height:16px;background:url("+that.bgimg+") 0px "+e_img[i]+"px ;float:left;'></div>";
			}
			else
			{
				div='';
			}
			$("#"+that.id+" table").append("<tr><td width='30%' align='right' >"+n[0]+"：</td><td width='60%' bgcolor='#fffae2' >"+div+"</td><td width='10%' nowrap >"+n[1]+"("+bili+"%)</td></tr>")
		})
		
		this.play();
	}

	this.play = function (){
		var that = this;		
		$("#"+this.id+" div").each(function(i,n){
			if($(n).attr('fag'))
			{
				$(n).animate( { width: $(n).attr('fag')+'%'}, that.speed )
			}
		})
	}
}
</script>

</head>
<body>
<div id="graph">Loading graph...</div>
<div id="show" ></div>
<script type="text/javascript">
	var myData = new Array(['教学态度', <%=request.getAttribute("data0").toString() %>], ['教学内容', <%=request.getAttribute("data1").toString() %>], ['教学方法与手段', <%=request.getAttribute("data2").toString() %>], ['教学效果', <%=request.getAttribute("data3").toString() %>],['总评', <%=request.getAttribute("data4").toString() %>]);
	var colors = ['#AF0202', '#EC7A00', '#FCD200', '#81C714','#81C710'];
	var myChart = new JSChart('graph', 'bar');
	myChart.setDataArray(myData);
	myChart.colorizeBars(colors);
	myChart.setTitle('这是您的评价结果');
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
	myChart.setSize(616, 321);
	myChart.setBackgroundImage('lib/chart_bg.jpg');
	myChart.draw();
</script>
<script>
var data = [];
data[0] = ['教学态度','<%=request.getAttribute("data0").toString() %>'];
data[1] = ['教学内容','<%=request.getAttribute("data1").toString() %>'];
data[2] = ['教学方法与手段','<%=request.getAttribute("data2").toString() %>'];
data[3] = ['教学效果','<%=request.getAttribute("data3").toString() %>'];
data[4] = ['总评','<%=request.getAttribute("data4").toString() %>'];
var title = '评价结果';
var bar1 = new bar();
bar1.id = 'show';
bar1.title = title;
bar1.data = data;
bar1.show();
</script>
  </body>
</html>
