<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <script src="lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerRadio.js" type="text/javascript"></script>
		<script language="JavaScript">
		var Row=<%=request.getAttribute("datastring")%>;
		//var Row=[{"QID":"1","Content":"尊守教学纪律（上下课按时、教案教具齐备等）情况","Weight":"5"},{"QID":"2","Content":"从严执教、教书育人情况","Weight":"5"},{"QID":"3","Content":"讲课有热情、精神饱满、有感染力、吸引学生注意力","Weight":"5"},{"QID":"4","Content":"基本概念、理论讲解科学准确程度","Weight":"10"},{"QID":"5","Content":"重点突出、难点讲清程度","Weight":"5"},{"QID":"6","Content":"问题阐述深入浅出、有启发性、简练准确程度","Weight":"5"},{"QID":"7","Content":"讲述内容充实、信息量大小程度","Weight":"5"},{"QID":"8","Content":"教学内容深度、广度和前沿性（反映或联系学科的新","Weight":"10"},{"QID":"9","Content":"对课程内容娴熟、运用自如程度","Weight":"5"},{"QID":"10","Content":"普通话规范、板书设计合理和体态语自然情况","Weight":"2"},{"QID":"11","Content":"课堂结构设计紧凑合理情况","Weight":"3"},{"QID":"12","Content":"教材处理科学合理、详略得当、易于学生接受情况","Weight":"3"},{"QID":"13","Content":"布置作业、介绍参考书目情况","Weight":"2"},{"QID":"14","Content":"教学方法（教授法、谈话法、讨论式、读书指导法","Weight":"5"},{"QID":"15","Content":"启发思维，给学生思考、联想和创新的启迪情况","Weight":"2"},{"QID":"16","Content":"双向交流，调动学生情绪、课堂气氛活跃情况","Weight":"3"},{"QID":"17","Content":"有效利用各种教学媒体情况","Weight":"5"},{"QID":"18","Content":"学生对基本概念、理论的理解和掌握、运用程度","Weight":"8"},{"QID":"19","Content":"学生学习积极性调动情况","Weight":"7"},{"QID":"20","Content":"对学生实践能力和创新精神的培养情况","Weight":"5"},{"QID":"21","Content":"dsaf","Weight":"1"},{"QID":"22","Content":"dsalf;k","Weight":"1"},{"QID":"23","Content":"sadfas","Weight":"1"},{"QID":"24","Content":"saafsda","Weight":"1"},{"QID":"25","Content":"sdfa","Weight":"1"}];
function loop1(){
		    var num=20;
            var tag=false;
		    for (var a=0; a <Row.length; a++) {
            document.write("<tr id="+a+">");
            document.write("<td style=\"width:30px\">"+Row[a].QID+"</td>");            
            document.write("<td>"+Row[a].Content+"</td>");
            document.write("<td style=\"width:50px\"><input type=\"radio\"value=\"" +Row[a].Weight+     "\" onclick=\"raidoClick("+a+")\"  name=\"Q"+a+"\"/>优</td>");
            document.write("<td style=\"width:50px\"><input type=\"radio\"value=\"" +Row[a].Weight*0.8+ "\" onclick=\"raidoClick("+a+")\"  name=\"Q"+a+"\"/>良</td>");
            document.write("<td style=\"width:50px\"><input type=\"radio\"value=\"" +Row[a].Weight*0.6+ "\" onclick=\"raidoClick("+a+")\"  name=\"Q"+a+"\"/>中</td>");
            document.write("<td style=\"width:50px\"><input type=\"radio\"value=\"" +Row[a].Weight*0.4+ "\" onclick=\"raidoClick("+a+")\"  name=\"Q"+a+"\"/>合格</td>");
            document.write("<td style=\"width:70px\"><input type=\"radio\"value=\"" +Row[a].Weight*0.2+ "\" onclick=\"raidoClick1("+a+")\"  name=\"Q"+a+"\"/>不合格</td>");
            document.write("</tr>");
            };
            document.write("<tr id=\"reason\" >");
            document.write("<td align=\"right\" style=\"width:30px\"  class=\"l-table-edit-td\">评价:</td>");
            document.write("<td align=\"left\" colspan=6 class=\"l-table-edit-td\">");
            document.write("<textarea cols=\"100\" rows=\"4\" class=\"l-textarea\" name=\"reason\" id=\"reason\" style=\"width:400px\" ></textarea>");
            document.write("</td>");
            document.write("</tr>");
            //document.write("<textarea cols=\"100\" rows=\"4\" class=\"l-textarea\" id=\"describe\" style=\"width:300px\" ></textarea>");
		}; 
		
		var val=null;
		var clicked=false;
		var radioes=null;
		$(document).ready(function(){
		    $("button").click(function(){
		       var count=Row.length;
		        clicked=true;
		        for (var i=0; i < Row.length; i++) {
		            val=null
		              radioes = document.getElementsByName('Q'+i);
                            for(var j=0;j<radioes.length;j++){
                           if(radioes[j].checked){val=radioes[j].value;}
                                                        }
                            if (val==null) {$("tr#"+i+"").css("background-color","yellow")}
                            else if (val!=null) {
                                count--;
                                //$("tr#"+i+"").css("background-color","white")
                                };;
				};
				//alert("oh,yeah!");
		        if (count==0) {};
		        
		        
		        $("form").submit();
		        
		        
		    })
		});
		
		function raidoClick(id){
		    if (clicked==true) {$("tr#"+id+"").css("background-color","white");
		    };		    
		};
		/*$("button").click(function(){
		$("form").submit();
		});*/
		</script>

</head>
<body style="padding: 10px">
    <form name="form1" method="post" action="/EES/student.do?method=questionnaire&cid=<%=request.getParameter("CID")%>&tid=<%=request.getParameter("TID")%>&CNO=<%=request.getParameter("CNO")%>" >
<table border="1" id="myTable" width=100%>
	                <tr>
            <td style="width:50px">序号</td>
            <td>内容</td>
            <td style="width:50px">选项</td>
            <td style="width:50px">选项</td> 
            <td style="width:50px">选项</td> 
            <td style="width:50px">选项</td>
            <td style="width:60px">选项</td>
            
        </tr>
        <!--<input type="text" name="error" style="display:none">-->
	    <script language="JavaScript">
			loop1();
		</script>
		</table>
		</form>
		<button>提交</button>
		</div>
</body>
</html>