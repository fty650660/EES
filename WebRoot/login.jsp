<%@ page language="java" pageEncoding="GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
	<html:base />
	<title>登录</title>
	<link href="css/Reset.css" rel="stylesheet" type="text/css" />
	<link href="css/Common.css" rel="stylesheet" type="text/css" />

	<link href="css/Default.css" rel="stylesheet" type="text/css" />
	<script src="lib/Admin.js" type="text/javascript"></script>
</head>

<body>
	<html:form action="/login" method="post" style="">
		<div class="page" style="">
			<div id="header">
				<!-- 
				<img src="lib/gzu_logo.jpg"
					style="position: relative; size: inherit;">
					 -->
				<div id="title">
					<h1
						style="background-image: url('lib/gzu_logo.jpg'); background-repeat: no-repeat;">
						&nbsp;
					</h1>

				</div>
			</div>
			<div id="main"
				style="margin-top: 0px; clear: both; position: relative">
				<p
					style="font-size: xx-large; font-style: inherit; color: rgb(0, 134, 139);">
					贵州大学计算机学院教学评价系统
				</p>
				<div id="main-left" style="">
					<fieldset style="width: 500px">
						<div class="editor-label">
							<label for="UserName">
								教师号/学号
							</label>
						</div>
						<div class="editor-field">
							<html:text property="name" />
							<html:errors property="name" />
						</div>
						<div class="editor-label">
							<label for="Password">
								密码
							</label>
						</div>
						<div class="editor-field">
							<html:password property="password" />
							<html:errors property="password" />
						</div>
						<div class="editor-label">
							<label for="UserName">
								用户类型 &nbsp; &nbsp; &nbsp;
							</label>
						</div>
						<div class="editor-field">

							<html:select property="selectType" style="width: 200px">
								<html:option value="1">学生</html:option>
								<html:option value="2">教师</html:option>
								<html:option value="3">管理员</html:option>
							</html:select>

						</div>
						<p>
							<html:submit value="登录" style="width: 100px" />
							<html:button value="退出" style="width: 100px" property="" />
						</p>
					</fieldset>
				</div>
				<div id="main-right" style="float: right;">

				</div>
			</div>
			<div id="footer">
			</div>
		</div>
	</html:form>
</body>
</html:html>