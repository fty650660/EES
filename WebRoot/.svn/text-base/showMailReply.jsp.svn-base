<%@page import="com.ees.hibernate.MailReply"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%
	List<MailReply> mailReplyList = (List<MailReply>) request.getAttribute("mailReplyList");
%>
<html>
	<head>
		<title>显示邮件和回复</title>
	</head>
	<body>	
		<a name="top"></a>	
		<fieldset style="height: 45%; color: #5959ff;">
				<legend>
					邮件
				</legend>
			<div id="MailContent"
				style="font-family: verdana; font-size: 15px; color: #5959ff;">
				<div style="color: #5959ff;">
					<h3>
						主&nbsp;&nbsp;题：${showMailReplyForm.theme}
					</h3>
					<table cellpadding="2" cellspacing="2">
						<tr style="color: #5959ff;">
							<td align="left" >
								发件人：
							</td>
							<td align="left" >
								${showMailReplyForm.sname}
							</td>
							<td align="left">
							</td>
						</tr>
						<tr style="color: #5959ff;">
							<td align="left" >
								时&nbsp;&nbsp;间：
							</td>
							<td align="left" >
								${showMailReplyForm.subtime}
							</td>
							<td align="left">
							</td>
						</tr>
						<tr style="color: #5959ff;">
							<td align="left" >
								收件人：
							</td>
							<td align="left" >
								${showMailReplyForm.tname}
							</td>
							<td align="left">
							</td>
						</tr>
					</table>
				</div>
				<br>
				<div
					style="BORDER-RIGHT: 2px outset; BORDER-TOP: 2px outset; BACKGROUND: #ffffff; BORDER-LEFT: 2px outset; WIDTH: 95%; BORDER-BOTTOM: 2px outset; HEIGHT: 40%"
					align=left>
					${showMailReplyForm.details}
				</div>
				<a href="#reply">回复邮件</a>
			</div>
		</fieldset>
		
		<a name="reply" >
			<h3>
				回复：
			</h3>
		</a>		
		<div id="NewReply">
			<html:form action="/MailReply.do?method=newReply" method="post">
				<textarea name="reply" style="width:60%;height:15%;" >
				</textarea>
				<br>
				<html:submit value="回复" />				
			</html:form>
		</div>
		
		<div id="ReplyList">
			<%
				for (int i = 0; i < mailReplyList.size(); i++) {
					if (i % 2 == 0) {
			%>
			<div style="background-color: #d5d5d5;">
				<%
					} else {
				%>
				<div style="background-color: #f0f0f0;">
					<%
						}
							if (mailReplyList.get(i).getIsFromStu()) {
					%>
					
					Student: ${showMailReplyForm.sname }
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<%=new Date(mailReplyList.get(i).getSubTime()
							.getTime())%>
					<br>
					<br>
					<%=mailReplyList.get(i).getReply()%>
					<br>
					<br>
					<a href="#reply">回复</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="#top">TOP</a>
				</div>
				<%
					} else {
				%>
				Teacher:${showMailReplyForm.tname }
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<%=new Date(mailReplyList.get(i).getSubTime()
							.getTime())%>
				<br>
				<br>
				<%=mailReplyList.get(i).getReply()%>
				<br>
				<br>
				<a href="#reply" >回复</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="#top">TOP</a>
			</div>
			<%
				}
			%>
			<%
				}
			%>
		</div>
		
	</body>
</html>