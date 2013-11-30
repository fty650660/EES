<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
	<html:base />
    <title>form登录</title>
    <link href="../css/Reset.css" rel="stylesheet" type="text/css" />
    <link href="../css/Common.css" rel="stylesheet" type="text/css" />

    <link href="../css/Default.css" rel="stylesheet" type="text/css" />
    <script src="../lib/Admin.js" type="text/javascript"></script>
</head>

<body>
	<html:form action="/login" method="post">
       <div class="page">
        <div id="header">
            <div id="title">
                <h1>
                    贵州大学计算机学院教师教学评价系统&nbsp;</h1><h1>请登录</h1>
            </div>
        </div>
        <div id="main">
            <p>
                请输入用户名和密码。</p>
            <fieldset>
                <div class="editor-label">
                    <label for="UserName">
                        用户类型：</label>
                </div>
                <div class="editor-field">
							
				<html:select property="selectType">
					<html:option value="1">student</html:option>
					<html:option value="2">teacher</html:option>
					<html:option value="3">admin</html:option>
				</html:select>
						
                </div>
                <div class="editor-label">
                    <label for="UserName">
                        用户名</label>
                </div>
                <div class="editor-field">
                    <html:text property="name"/><html:errors property="name"/>
                </div>
                <div class="editor-label">
                    <label for="Password">
                        密码</label>
                </div>
                <div class="editor-field">
                  <html:password property="password"/><html:errors property="password"/>
                </div>
                <p>
                    <html:submit value="登录" />                       
                </p>
            </fieldset>
        </div>
        <div id="footer">
        </div>
    </div>
    </html:form>
 </body>
</html:html>
