<%@page import="java.io.PrintWriter"%>
<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <head>
        <title>���ݴ�ѧ�������۱���ӡ��</title>
        <script language="JavaScript">      
		var Row=${Questions};                         
            function loop2(){
                var num = Row.length;
                
                document.write("<table frame=\"border\" style=\"width:90%;align:middle\" class=\"questions\" border=1 cellspacing=0>");
                document.write("<tr style=\"text-align:center\" border=\"1\"><th>&nbsp</th><th>������Ŀ</th><th>��</th><th>��</th><th>��</th><th>�ϸ�</th><th>���ϸ�</th></tr>");
                for (var a = 0; a < num; a++) {
                    document.write("<tr name=\"Qr" + (a + 1) + "\"><td>" + Row[a].QID + "</td><td>" + Row[a].Content + "</td>");
                    document.write("<td class=\"q" + (a + 1) + "\" id=\"" + Row[a].Weight * 0.95 + "\" style=\"width:8%;text-align:center\"></td>");
                    document.write("<td class=\"q" + (a + 1) + "\" id=\"" + Row[a].Weight * 0.85 + "\" style=\"width:8%;text-align:center\"></td>");
                    document.write("<td class=\"q" + (a + 1) + "\" id=\"" + Row[a].Weight * 0.75 + "\" style=\"width:8%;text-align:center\"></td>");
                    document.write("<td class=\"q" + (a + 1) + "\" id=\"" + Row[a].Weight * 0.65 + "\" style=\"width:8%;text-align:center\"></td>");
                    document.write("<td class=\"q" + (a + 1) + "\" id=\"" + Row[a].Weight * 0.5 + "\" style=\"width:8%;text-align:center\"></td>");
                    document.write("</tr>");
                };
                document.write("<tr><td colspan=\"2\">�ۺ����ۣ���Ϊ�š������С��ϸ񡢲��ϸ���ȣ�</td>");
                document.write("<td colspan=5 id=\"sum\" style=\"width:8%;text-align:center\"></td>");
                document.write("</tr>");
                
                document.write("<tr><th colspan=\"7\">�Կ��������Լ���������ľ���������飺</th></tr>");
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
                        q1[i].innerHTML = "��";
				}
                var q2 = getElementsByClassName("q2");
                for (var i=0;i<q2.length;i++) {
                    if (q2[i].id == "${teaEvaluationForm.q2}") 
                        q2[i].innerHTML = "��";
                    
                }
                var q3 = getElementsByClassName("q3");
                for (var i=0;i<q3.length;i++) {
                    if (q3[i].id == "${teaEvaluationForm.q3}") 
                        q3[i].innerHTML = "��";
                    
                }
                var q4 = getElementsByClassName("q4");
                for (var i=0;i<q4.length;i++) {
                    if (q4[i].id == "${teaEvaluationForm.q4}") 
                        q4[i].innerHTML = "��";
                    
                }
                var q5 = getElementsByClassName("q5");
                for (var i=0;i<q5.length;i++) {
                    if (q5[i].id == "${teaEvaluationForm.q5}") 
                        q5[i].innerHTML = "��";
                    
                }
                var q6 = getElementsByClassName("q6");
                for (var i=0;i<q6.length;i++) {
                    if (q6[i].id == "${teaEvaluationForm.q6}") 
                        q6[i].innerHTML = "��";
                    
                }
                var q7 = getElementsByClassName("q7");
                for (var i=0;i<q7.length;i++) {
                    if (q7[i].id == "${teaEvaluationForm.q7}") 
                        q7[i].innerHTML = "��";
                    
                }
                var q8 = getElementsByClassName("q8");
                for (var i=0;i<q8.length;i++) {
                    if (q8[i].id == "${teaEvaluationForm.q8}") 
                        q8[i].innerHTML = "��";
                    
                }
                var q9 = getElementsByClassName("q9");
                for (var i=0;i<q9.length;i++) {
                    if (q9[i].id == "${teaEvaluationForm.q9}") 
                        q9[i].innerHTML = "��";
                    
                }
                var q10 = getElementsByClassName("q10");
                for (var i=0;i<q10.length;i++) {
                    if (q10[i].id == "${teaEvaluationForm.q10}") 
                        q10[i].innerHTML = "��";
                    
                }
                var q11 = getElementsByClassName("q11");
                for (var i=0;i<q11.length;i++) {
                    if (q11[i].id == "${teaEvaluationForm.q11}") 
                        q11[i].innerHTML = "��";
                    
                }
                var sum = document.getElementById("sum");
				switch("${teaEvaluationForm.sum}")
				{
					case "95":
						sum.innerHTML = "��"; break;
					case "85":
						sum.innerHTML = "��"; break;
					case "75":
						sum.innerHTML = "��"; break;
					case "65":
						sum.innerHTML = "�ϸ�"; break;
					case "50":
						sum.innerHTML = "���ϸ�"; 	
				}
                
                var agelevel = document.getElementById("agelevel");
				switch("${teaEvaluationForm.agelevel}")
				{
					case "1":
						agelevel.innerHTML = "��"; break;
					case "2":
						agelevel.innerHTML = "��"; break;
					case "3":
						agelevel.innerHTML = "��";
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
                <h1 align="middle">�� �� �� ѧ �� �� �� �� ��</h1>
                <br>
				<div id="evalutable" align="center" style="width:100%;margin:auto;">
				<table style="width:90%;border-collapse:collapse">
					<tr>
						
						<td style="width:15%;text-align:right">���ε�λ��</td>
						<td style="text-align:center" width="30%" class="bottomline">${teaEvaluationForm.dept}</td>
						<td width="6%"></td>
						<td style="width:15%;text-align:right">�ڿΰ༶��</td>
						<td style="text-align:center" width="30%" class="bottomline">${teaEvaluationForm.teaclass}</td>
					</tr>
					<tr>
						
						<td style="width:15%;text-align:right">�γ����ƣ�</td>
						<td style="text-align:center" width="30%" class="bottomline">${teaEvaluationForm.cname}</td>
						<td width="6%"></td>
						<td style="width:15%;text-align:right">�γ����ͣ�</td>
						<td style="text-align:center" width="30%" class="bottomline">${teaEvaluationForm.coursetype}</td>
					</tr>
					<tr>
						
						<td style="width:15%;text-align:right">�ڿν�ʦ��</td>
						<td style="text-align:center" width="30%" class="bottomline">${teaEvaluationForm.teaname}</td>
						<td width="6%"></td>
						<td style="width:15%;text-align:right">�����Σ�</td>
						<td style="text-align:center" width="30%" class="bottomline" id="agelevel"></td>
					</tr>
					<tr>
						
						<td style="width:15%;text-align:right">�ڿ�ʱ�䣺</td>
						<td style="text-align:center" width="30%" class="bottomline">${teaEvaluationForm.teatime}</td>
						<td width="6%"></td>
						<td style="width:15%;text-align:right">�ڿεص㣺</td>
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
						<td style="width:25%;text-align:right">�����ˣ�ǩ�֣���</td>
						<td width="25%" class="bottomline"></td>
						<td width="6%"></td>
						<td style="width:15%;text-align:right"></td>
						<td width="28%">&nbsp&nbsp&nbsp��&nbsp&nbsp&nbsp��&nbsp&nbsp&nbsp��</td>
					</tr>
					<tr>
						<td colspan=5>
						<p style="font-size:72%;text-align:center">
						����ע�����κ����ڸ�������Ŀ֮�����Ӧ����λ����������ѡ�ֻ�޵�ѡ���ۺ�����ֻ��һ���ȼ���
						</p>
						</td>
					</tr>
				</table>
                <div class="notdiv">
                    <div id="submitbutton" style="width:50%;float:left">
					<OBJECT  id=WebBrowser  classid=CLSID:8856F961-340A-11D0-A96B-00C04FD705A2  height=0  width=0>
  					</OBJECT>
						<input type="button" value="ȷ�ϴ�ӡ" onclick="printTable()">                       
                    </div>
                    <div id="pressbutton" style="width:50%;float:right">
                        <input type="button" value="�ر�ҳ��" onclick="javascript:window.close()">						
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>