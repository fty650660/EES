<%@ page language="java" pageEncoding="GBK" %>
<%@ page import="java.io.PrintWriter"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%
	String root=request.getContextPath();
	System.out.println(root); 
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <head>
        <title>�޸Ľ�ʦ���۱�</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" /> 
	    <script src="../lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
	    <script src="../lib/ligerUI/js/core/base.js" type="text/javascript"></script>
	    <script src="../lib/ligerUI/js/plugins/ligerForm.js" type="text/javascript"></script>
	    <script src="../lib/ligerUI/js/plugins/ligerDateEditor.js" type="text/javascript"></script>
	    <script src="../lib/ligerUI/js/plugins/ligerComboBox.js" type="text/javascript"></script>
	    <script src="../lib/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>
	    <script src="../lib/ligerUI/js/plugins/ligerButton.js" type="text/javascript"></script>
	    <script src="../lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	    <script src="../lib/ligerUI/js/plugins/ligerRadio.js" type="text/javascript"></script>
	    <script src="../lib/ligerUI/js/plugins/ligerSpinner.js" type="text/javascript"></script>
	    <script src="../lib/ligerUI/js/plugins/ligerTextBox.js" type="text/javascript"></script> 
	    <script src="../lib/ligerUI/js/plugins/ligerTip.js" type="text/javascript"></script>
	    <script src="../lib/jquery-validation/jquery.validate.min.js" type="text/javascript"></script> 
	    <script src="../lib/jquery-validation/jquery.metadata.js" type="text/javascript"></script>
	    <script src="../lib/jquery-validation/messages_cn.js" type="text/javascript"></script>
		
        <script language="JavaScript">                      
            var Row=${Questions}
            function loop2(){
                var num = Row.length;

                document.write("<table style=\"width:80%;align:middle\" class=\"questions\" border=\"1\">");
                document.write("<tr style=\"text-align:center\"><th>&nbsp</th><th style=\"text-align:center\">������Ŀ</th><th style=\"text-align:center\">��</th><th style=\"text-align:center\">��</th><th style=\"text-align:center\">��</th><th style=\"text-align:center\">�ϸ�</th><th style=\"text-align:center\">���ϸ�</th></tr>");
                for (var a = 0; a < num; a++) {
                    document.write("<tr name=\"Qr" + (a + 1) + "\"><td>" + Row[a].QID + "</td><td>" + Row[a].Content + "</td>");
                    document.write("<td style=\"width:8%;text-align:center\"><input type=\"radio\" value=\"" + Row[a].Weight * 0.95 + "\" name=\"q" + (a + 1) + "\"></td>");
                    document.write("<td style=\"width:8%;text-align:center\"><input type=\"radio\" value=\"" + Row[a].Weight * 0.85 + "\" name=\"q" + (a + 1) + "\"></td>");
                    document.write("<td style=\"width:8%;text-align:center\"><input type=\"radio\" value=\"" + Row[a].Weight * 0.75 + "\" name=\"q" + (a + 1) + "\"></td>");
                    document.write("<td style=\"width:8%;text-align:center\"><input type=\"radio\" value=\"" + Row[a].Weight * 0.65 + "\" name=\"q" + (a + 1) + "\"></td>");
                    document.write("<td style=\"width:8%;text-align:center\"><input type=\"radio\" value=\"" + Row[a].Weight * 0.5 + "\" name=\"q" + (a + 1) + "\"></td>");
                    document.write("</tr>");
                };
                document.write("<tr><td colspan=\"2\">�ۺ����ۣ���Ϊ�š������С��ϸ񡢲��ϸ���ȣ�</td>");
                document.write("<td style=\"text-align:center\"><input type=\"radio\" value=\"" + 100 * 0.95 + "\" name=\"sum\"></td>");
                document.write("<td style=\"text-align:center\"><input type=\"radio\" value=\"" + 100 * 0.85 + "\" name=\"sum\"></td>");
                document.write("<td style=\"text-align:center\"><input type=\"radio\" value=\"" + 100 * 0.75 + "\" name=\"sum\"></td>");
                document.write("<td style=\"text-align:center\"><input type=\"radio\" value=\"" + 100 * 0.65 + "\" name=\"sum\"></td>");
                document.write("<td style=\"text-align:center\"><input type=\"radio\" value=\"" + 100 * 0.5 + "\" name=\"sum\"></td>");
                document.write("</tr>");
                
                document.write("<tr><th colspan=\"7\" style=\"text-align:center\">�Կ��������Լ���������ľ���������飺</th></tr>");
                document.write("<tr height=\"200\"><td width:100% colspan=\"7\"><textarea style=\"width:98%;height:200px\" name=\"reason\" id=\"reason\" validate=\"{required:true}\"></textarea></td></tr>");
                
                document.write("</table>");
            }
			
			var eee;
        $(function ()
        {
            $.metadata.setType("attr", "validate");
            var v = $("form").validate({
                debug: true,
				
                errorPlacement: function (lable, element)
                {
                    if (element.hasClass("l-textarea"))
                    {
						
                        element.ligerTip({ content: lable.html(), target: element[0] }); 
                    }
                    else if (element.hasClass("l-text-field"))
                    {
						
                        element.parent().ligerTip({ content: lable.html(), target: element[0] });
                    }
                    else
                    {
						
                        lable.appendTo(element.parents("td:first").next("td"));
                    }
					
                },						
                success: function (lable)
                {
                    lable.ligerHideTip();
                    lable.remove();
                },
                submitHandler: function submitfunction ()
                {
                    $("form .l-text,.l-textarea").ligerHideTip();
					if(checktime() && checkfill() && checkreason()){
						alert("��ϲ�����޸����۳ɹ���");
						var url="<%=request.getContextPath()%>/TeaEvaluation.do?method=updateEvaluation";
						document.evaluform.action=url;
						document.evaluform.submit();
					}
				}
            });
            $("form").ligerForm();
            $(".l-button-test").click(function ()
            {
				var cf=confirm("������Ա��������޸ģ���ȷ���Ѿ�������޸ġ���ť���������ܱ�֤���ı����ȷ��ӡ��\nȷ�ϴ�ӡ������ȷ����������������ȡ����");
            	if(cf==true)
				{
					window.open('printEvaluation.jsp');
				}
				
			});
        });          
		   
		   function checktime(){
				teatime=document.getElementById("teatime").value;
					date_tea=new Date(teatime);
					
					subtime=document.getElementById("subtime").value;
					data_sub=new Date(subtime);
					if(data_sub.getTime()<date_tea.getTime())
						alert("�ڿ�ʱ����д����^_^");
//						document.getElementById("timetip").value="Teatime is too late!"
					else
						return true;
			}
			
			function checkreason(){
				reason=document.getElementById("reason");
				if(reason.value.length<=100)
//					alert(reason.value.length);
					alert("���۽��鲻������100���֡�");
				else
					return true;
			}
		   	          
           function checkfill(){				
                if (!document.getElementsByTagName) 
                    return false;
                var tables = document.getElementsByTagName("table");
                var rows = tables[1].getElementsByTagName("tr");
				var sumradio=document.getElementsByName("sum");
				var count=0;
				
				for(var x=0;x<Row.length;x++){
                        rows[x+1].style.backgroundColor = "#ffffff";		
						sumradio[0].style.backgroundColor = "#ffffff";		
							
				}
                rows[Row.length+1].style.backgroundColor = "#ffffff";
                for (var x = 0; x < Row.length ; x++) {
                    var flag = false;
                    var qradio = document.getElementsByName("q" + (x + 1));
					
                    for (var i = 0; i < qradio.length; i++) {
                        if (qradio[i].checked){
                            flag = true;
							count++;							
						} 
                    }
                    if (flag == false) {
                        rows[x+1].style.backgroundColor = "#ffd2ff";
					}
                }
				var sumflag=false;
				for(var i=0; i<sumradio.length; i++){					
					if(sumradio[i].checked){
						sumflag=true;
						count++;						
					}
				}
				if(sumflag==false)
					rows[Row.length+1].style.backgroundColor="#ffd2ff";
				
				if(count==12)
					return true;
            }
			
			function fillscores(){
				var agelevels=document.getElementsByName("agelevel");
				for(var i=0;i<agelevels.length;i++){
					if(agelevels[i].value=="${teaEvaluationForm.agelevel}")
						agelevels[i].checked="checked";							
				}
				var q=document.getElementsByName("q1");
				for(var i=0;i<q.length;i++){
					if(q[i].value=="${teaEvaluationForm.q1}")
						q[i].checked="checked";							
				}
				var q=document.getElementsByName("q2");
				for(var i=0;i<q.length;i++){
					if(q[i].value=="${teaEvaluationForm.q2}")
						q[i].checked="checked";							
				}
				var q=document.getElementsByName("q3");
				for(var i=0;i<q.length;i++){
					if(q[i].value=="${teaEvaluationForm.q3}")
						q[i].checked="checked";							
				}
				var q=document.getElementsByName("q4");
				for(var i=0;i<q.length;i++){
					if(q[i].value=="${teaEvaluationForm.q4}")
						q[i].checked="checked";							
				}
				var q=document.getElementsByName("q5");
				for(var i=0;i<q.length;i++){
					if(q[i].value=="${teaEvaluationForm.q5}")
						q[i].checked="checked";							
				}
				var q=document.getElementsByName("q6");
				for(var i=0;i<q.length;i++){
					if(q[i].value=="${teaEvaluationForm.q6}")
						q[i].checked="checked";							
				}
				var q=document.getElementsByName("q7");
				for(var i=0;i<q.length;i++){
					if(q[i].value=="${teaEvaluationForm.q7}")
						q[i].checked="checked";							
				}
				var q=document.getElementsByName("q8");
				for(var i=0;i<q.length;i++){
					if(q[i].value=="${teaEvaluationForm.q8}")
						q[i].checked="checked";							
				}
				var q=document.getElementsByName("q9");
				for(var i=0;i<q.length;i++){
					if(q[i].value=="${teaEvaluationForm.q9}")
						q[i].checked="checked";							
				}
				var q=document.getElementsByName("q10");
				for(var i=0;i<q.length;i++){
					if(q[i].value=="${teaEvaluationForm.q10}")
						q[i].checked="checked";							
				}
				var q=document.getElementsByName("q11");
				for(var i=0;i<q.length;i++){
					if(q[i].value=="${teaEvaluationForm.q11}")
						q[i].checked="checked";							
				}
				var sum=document.getElementsByName("sum");
				for(var i=0;i<sum.length;i++){
					if(sum[i].value=="${teaEvaluationForm.sum}")
						sum[i].checked="checked";							
				}
				var reason=document.getElementById("reason");
				reason.value="${teaEvaluationForm.reason}"
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
			
			body{ font-size:12px;}
	        .l-table-edit {}
	        .l-table-edit-td{ padding:4px;}
	        .l-button-submit,.l-button-test{width:80px; margin-left:10px; padding-bottom:2px;}
	        .l-verify-tip{ left:230px; top:120px;}         
			
            body {
                TEXT-ALIGN: center;
            } #center {
                MARGIN-RIGHT: auto;
                MARGIN-LEFT: auto;
            } *:focus {
                outline: none;
            }			
        </style>
    </head>
	
    <body>       
	
        <div style=widows:>
        </div>
        
        <form id="evaluform" name="evaluform" action="" method="post">
        	<div id="container" align="center" style="width:85%;margin:auto;">
        		<br>
        		<h1 align="middle" >�� �� �� ѧ �� �� �� �� ��</h1>
				<br><br>
				<table style="width:90%;border-collapse:collapse" class="l-table-edit">
					<tr>
						<td style="width:15%;text-align:right" class="l-table-edit-td">���ε�λ��</td>
						<td style="text-align:center" width="30%" ><input type="text" name="dept" id="dept" validate="{required:true}" value=${teaEvaluationForm.dept}></td>
						<td width="6%"></td>
						<td style="width:15%;text-align:right" class="l-table-edit-td">�ڿΰ༶��</td>
						<td style="text-align:center" width="30%" ><input type="text" name="teaclass" id="teaclass" validate="{required:true}" value=${teaEvaluationForm.teaclass}> </td>
					</tr>
					<tr>
						
						<td style="width:15%;text-align:right" class="l-table-edit-td">�γ����ƣ�</td>
						<td style="text-align:center" width="30%" ><input type="text" name="cname" id="cname" validate="{required:true}" value=${teaEvaluationForm.cname}></td>
						<td width="6%"></td>
						<td style="width:15%;text-align:right" class="l-table-edit-td">�γ����ͣ�</td>
						<td style="text-align:center" width="30%" ><input type="text" name="coursetype" id="coursetype" validate="{required:true}" value=${teaEvaluationForm.coursetype}></td>
					</tr>
					<tr>
						
						<td style="width:15%;text-align:right" class="l-table-edit-td">�ڿν�ʦ��</td>
						<td style="text-align:center" width="30%" ><input type="text" name="teaname" id="tname"  validate="{required:true}" value=${teaEvaluationForm.teaname}></td>
						<td width="6%"></td>
						<td style="width:15%;text-align:right" class="l-table-edit-td">�����Σ�</td>
						<td style="text-align:left" width="30%" id="agelevel" class="l-table-edit-td">
							<input type="radio" value="1" name="agelevel">��&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="radio" value="2" name="agelevel">��&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="radio" value="3" name="agelevel" checked="checked">��
						</td>
					</tr>
					<tr>
						
						<td style="width:15%;text-align:right" class="l-table-edit-td">�ڿ�ʱ�䣺</td>
						<td style="text-align:center" width="30%" ><input type="text" ltype="date" name="teatime" id="teatime" validate="{required:true}" value=${teaEvaluationForm.teatime}></td>
						<td width="6%"></td>
						<td style="width:15%;text-align:right" class="l-table-edit-td">�ڿεص㣺</td>
						<td style="text-align:center" width="30%" ><input type="text" name="tealocation" id="tealocation" validate="{required:true}" value=${teaEvaluationForm.tealocation}></td>
					</tr>
				</table>
				<br>
				<div id="evalutable">
					<script language="JavaScript">
		                loop2();
						fillscores();
		            </script>
				</div>
				<br>
		
		       <div style="witth:100%" align="center">
				<br>
				<table width="90%" style="border-collapse:collapse" class="l-table-edit">
					<tr>
						<td style="width:25%;text-align:right" class="l-table-edit-td">�����ˣ�ǩ�֣���</td>
						<td width="25%"><input type="text" name="lisname" class="l-table-edit-td" validate="{required:true}" value=${teaEvaluationForm.lisname}></td>
						<td width="6%"></td>
						<td style="width:15%;text-align:right" class="l-table-edit-td">�ύʱ�䣺</td>
						<td width="28%"><input type="text" id="subtime" name="subtime" class="l-table-edit-td" validate="{required:true}" value=${teaEvaluationForm.subtime}></td>
					</tr>
				</table>
				</div>
				<br>

				<div id="submitbutton" style="width:50%;float:left">
	            	<input type="submit" value="�޸�" class="l-button l-button-submit">
				</div>
				<div id="printbutton" style="width:50%;float:right">				
					<input type="button" value="��ӡ" class="l-button l-button-test">
				</div>				
			</div> 
			<!--
			<div id="container" align="middle" style="width:85%">
        		<h1 align="middle" >�� �� �� ѧ �� �� �� �� ��</h1>   						
        		<div id="leftcontent" style="width:50%;float:left">	
	        		���ε�λ��<input type="text" name="dept" id="dept" value=${teaEvaluationForm.dept}>    <br>   				
					�γ����ƣ�<input type="text" name="cname" id="cname" value=${teaEvaluationForm.cname}>      <br>
					�ڿν�ʦ��<input type="text" name="teaname" id="teaname" value=${teaEvaluationForm.teaname}>      <br>
	        		�ڿ�ʱ�䣺<input type="text" name="teatime" id="teatime" value=${teaEvaluationForm.teatime}>  
				</div>
			
				<div id="rightcontent" style="width:50%;float:left">
					�ڿΰ༶��<input type="text" name="teaclass" id="teaclass" value=${teaEvaluationForm.teaclass}>  <br>
					�γ����ͣ�<input type="text" name="coursetype" id="coursetype" value=${teaEvaluationForm.coursetype}><br>
				           �����Σ�<input type="radio" value="��" name="agelevel">��<input type="radio" value="��" name="agelevel">��<input type="radio" value="��" name="agelevel">�� <br>
					�ڿεص㣺<input type="text" name="tealocation" id="tealocation" value=${teaEvaluationForm.tealocation}> 
            	</div>
            	
            	
				<div class="clearfix"><br></div>
				
				<div id="evalutable">
					<script language="JavaScript">
		                loop2();
						fillscores();			
		            </script>
				</div>
				
				
				<div style="width:50%;float:left">
					�����ˣ�ǩ�֣���<input type="text" name="lisname" value=${teaEvaluationForm.lisname}>
				</div>
				<div style="width:50%;float:left">
					�ύʱ�䣺<input type="text" name="subtime" value=${teaEvaluationForm.subtime}> 
				</div>
				<div class="clearfix"><br><br></div>
				
				<div id="updatebutton" style="width:50%;float:left">
	            	<input type="submit" value="�޸�" >
				</div>
				<div id="printbutton" style="width:50%;float:right">				
					<input type="button" value="��ӡ" onclick="javascript:window.open('printEvaluation.jsp')">
				</div>
				
			</div> 
			-->
        </form>
    </body>
</html>