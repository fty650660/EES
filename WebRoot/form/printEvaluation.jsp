<%@page import="java.io.PrintWriter"%>
<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <head>
        <title>贵州大学听课评价表（打印）</title>
        <script language="JavaScript">      
		var Row=${Questions};                         
            function loop2(){
                var num = Row.length;
                
                document.write("<table frame=\"border\" style=\"width:90%;align:middle\" class=\"questions\" border=1 cellspacing=0>");
                document.write("<tr style=\"text-align:center\" border=\"1\"><th>&nbsp</th><th>评价项目</th><th>优</th><th>良</th><th>中</th><th>合格</th><th>不合格</th></tr>");
                for (var a = 0; a < num; a++) {
                    document.write("<tr name=\"Qr" + (a + 1) + "\"><td>" + Row[a].QID + "</td><td>" + Row[a].Content + "</td>");
                    document.write("<td class=\"q" + (a + 1) + "\" id=\"" + Row[a].Weight * 0.95 + "\" style=\"width:8%;text-align:center\"></td>");
                    document.write("<td class=\"q" + (a + 1) + "\" id=\"" + Row[a].Weight * 0.85 + "\" style=\"width:8%;text-align:center\"></td>");
                    document.write("<td class=\"q" + (a + 1) + "\" id=\"" + Row[a].Weight * 0.75 + "\" style=\"width:8%;text-align:center\"></td>");
                    document.write("<td class=\"q" + (a + 1) + "\" id=\"" + Row[a].Weight * 0.65 + "\" style=\"width:8%;text-align:center\"></td>");
                    document.write("<td class=\"q" + (a + 1) + "\" id=\"" + Row[a].Weight * 0.5 + "\" style=\"width:8%;text-align:center\"></td>");
                    document.write("</tr>");
                };
                document.write("<tr><td colspan=\"2\">综合评价（分为优、良、中、合格、不合格五等）</td>");
                document.write("<td colspan=5 id=\"sum\" style=\"width:8%;text-align:center\"></td>");
                document.write("</tr>");
                
                document.write("<tr><th colspan=\"7\">对课堂内容以及其它方面的具体意见或建议：</th></tr>");
                document.write("<tr height=\"200\"><td width:100% colspan=\"7\"><p style=\"text-align:left\" id=\"reason\"></p></td></tr>");
                
                document.write("</table>");
            }
            
			function getElementsByClassName(searchClass, node, tag){
                if (document.getElementsByClassName) {
                    return document.getElementsByClassName(searchClass);
                }
                else {
                    node = node || document;
                    tag = tag || "*";
                    var returnElements = [];
                    var els = (tag == '*' && node.all) ? node.all : node.getElementsByTagName(tag);
                    var i = els.length;
                    searchClass = searchClass.replace(/\-/g, '\\-');
                    var pattern = new RegExp('(^|\\s)' + searchClass + '(\\s|$)');
                    while (--i >= 0) {
                        if (pattern.test(els[i].className)) {
                            returnElements.push(els[i]);
                        }
                    }
                    return returnElements;
                }
            }
			
            function fillscores(){
                var q1 = getElementsByClassName("q1");				
				for(var i=0;i<q1.length;i++){
					if (q1[i].id == "${teaEvaluationForm.q1}") 
                        q1[i].innerHTML = "√";
				}
                var q2 = getElementsByClassName("q2");
                for (var i=0;i<q2.length;i++) {
                    if (q2[i].id == "${teaEvaluationForm.q2}") 
                        q2[i].innerHTML = "√";
                    
                }
                var q3 = getElementsByClassName("q3");
                for (var i=0;i<q3.length;i++) {
                    if (q3[i].id == "${teaEvaluationForm.q3}") 
                        q3[i].innerHTML = "√";
                    
                }
                var q4 = getElementsByClassName("q4");
                for (var i=0;i<q4.length;i++) {
                    if (q4[i].id == "${teaEvaluationForm.q4}") 
                        q4[i].innerHTML = "√";
                    
                }
                var q5 = getElementsByClassName("q5");
                for (var i=0;i<q5.length;i++) {
                    if (q5[i].id == "${teaEvaluationForm.q5}") 
                        q5[i].innerHTML = "√";
                    
                }
                var q6 = getElementsByClassName("q6");
                for (var i=0;i<q6.length;i++) {
                    if (q6[i].id == "${teaEvaluationForm.q6}") 
                        q6[i].innerHTML = "√";
                    
                }
                var q7 = getElementsByClassName("q7");
                for (var i=0;i<q7.length;i++) {
                    if (q7[i].id == "${teaEvaluationForm.q7}") 
                        q7[i].innerHTML = "√";
                    
                }
                var q8 = getElementsByClassName("q8");
                for (var i=0;i<q8.length;i++) {
                    if (q8[i].id == "${teaEvaluationForm.q8}") 
                        q8[i].innerHTML = "√";
                    
                }
                var q9 = getElementsByClassName("q9");
                for (var i=0;i<q9.length;i++) {
                    if (q9[i].id == "${teaEvaluationForm.q9}") 
                        q9[i].innerHTML = "√";
                    
                }
                var q10 = getElementsByClassName("q10");
                for (var i=0;i<q10.length;i++) {
                    if (q10[i].id == "${teaEvaluationForm.q10}") 
                        q10[i].innerHTML = "√";
                    
                }
                var q11 = getElementsByClassName("q11");
                for (var i=0;i<q11.length;i++) {
                    if (q11[i].id == "${teaEvaluationForm.q11}") 
                        q11[i].innerHTML = "√";
                    
                }
                var sum = document.getElementById("sum");
				switch("${teaEvaluationForm.sum}")
				{
					case "95":
						sum.innerHTML = "优"; break;
					case "85":
						sum.innerHTML = "良"; break;
					case "75":
						sum.innerHTML = "中"; break;
					case "65":
						sum.innerHTML = "合格"; break;
					case "50":
						sum.innerHTML = "不合格"; 	
				}
                
                var agelevel = document.getElementById("agelevel");
				switch("${teaEvaluationForm.agelevel}")
				{
					case "1":
						agelevel.innerHTML = "老"; break;
					case "2":
						agelevel.innerHTML = "中"; break;
					case "3":
						agelevel.innerHTML = "青";
				}	         
				
				var reason=document.getElementById("reason");
				reason.innerHTML="${teaEvaluationForm.reason}";    
            }	
			
			function printTable(){				
		        if (window.ActiveXObject) {
//					alert("IE~!");
					if(document.all.WebBrowser.ExecWB(7, 1)){
						
					}else{
						window.print();
					}
					
				}
				else {
//					alert("No IE!!");
					window.print();
				}
			}		
        </script>
		
		<style type="text/css">
            .bottomline {
                border-bottom: 1px solid;
                border-left-width: 0px;
                border-right-width: 0px;
                border-top-width: 0px;			
            } .clearfix:after {
                content: ".";
                display: block;
                height: 0;
                clear: both;
                visibility: hidden;
            } .clearfix {
                display: inline-block;
            } .clearfix {
                display: block;
            }
            
            body {
                TEXT-ALIGN: center;
            } #center {
                MARGIN-RIGHT: auto;
                MARGIN-LEFT: auto;
            } *:focus {
                outline: none;
            }			
        </style>
		<style media="print">
		.notdiv {display:none;}
		</style>
    </head>
    <body>
        
        <div style=widows:>
        </div>
        
        <form id="evaluform" action="">
            <br>
            <br>
            <div id="container" style="width:95%;">
                <h1 align="middle">贵 州 大 学 听 课 评 价 表</h1>
                <br>
				<div id="evalutable" align="center" style="width:100%;margin:auto;">
				<table style="width:90%;border-collapse:collapse">
					<tr>
						
						<td style="width:15%;text-align:right">开课单位：</td>
						<td style="text-align:center" width="30%" class="bottomline">${teaEvaluationForm.dept}</td>
						<td width="6%"></td>
						<td style="width:15%;text-align:right">授课班级：</td>
						<td style="text-align:center" width="30%" class="bottomline">${teaEvaluationForm.teaclass}</td>
					</tr>
					<tr>
						
						<td style="width:15%;text-align:right">课程名称：</td>
						<td style="text-align:center" width="30%" class="bottomline">${teaEvaluationForm.cname}</td>
						<td width="6%"></td>
						<td style="width:15%;text-align:right">课程类型：</td>
						<td style="text-align:center" width="30%" class="bottomline">${teaEvaluationForm.coursetype}</td>
					</tr>
					<tr>
						
						<td style="width:15%;text-align:right">授课教师：</td>
						<td style="text-align:center" width="30%" class="bottomline">${teaEvaluationForm.teaname}</td>
						<td width="6%"></td>
						<td style="width:15%;text-align:right">年龄层次：</td>
						<td style="text-align:center" width="30%" class="bottomline" id="agelevel"></td>
					</tr>
					<tr>
						
						<td style="width:15%;text-align:right">授课时间：</td>
						<td style="text-align:center" width="30%" class="bottomline">${teaEvaluationForm.teatime}</td>
						<td width="6%"></td>
						<td style="width:15%;text-align:right">授课地点：</td>
						<td style="text-align:center" width="30%" class="bottomline">${teaEvaluationForm.tealocation}</td>
					</tr>
				</table>
				<br>   
                <script language="JavaScript">
                    loop2();
                    fillscores();
                </script>
            </div>
            <br>
			
            <div style="witth:100%" align="middle">
				<table width="90%" style="border-collapse:collapse">
					<tr>
						<td style="width:25%;text-align:right">听课人（签字）：</td>
						<td width="25%" class="bottomline"></td>
						<td width="6%"></td>
						<td style="width:15%;text-align:right"></td>
						<td width="28%">&nbsp&nbsp&nbsp年&nbsp&nbsp&nbsp月&nbsp&nbsp&nbsp日</td>
					</tr>
					<tr>
						<td colspan=5>
						<p style="font-size:72%;text-align:center">
						（备注：听课后请在各评价项目之后的相应评分位置填入您的选项，只限单选。综合评价只填一个等级）
						</p>
						</td>
					</tr>
				</table>
                <div class="notdiv">
                    <div id="submitbutton" style="width:50%;float:left">
					<OBJECT  id=WebBrowser  classid=CLSID:8856F961-340A-11D0-A96B-00C04FD705A2  height=0  width=0>
  					</OBJECT>
						<input type="button" value="确认打印" onclick="printTable()">                       
                    </div>
                    <div id="pressbutton" style="width:50%;float:right">
                        <input type="button" value="关闭页面" onclick="javascript:window.close()">						
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>