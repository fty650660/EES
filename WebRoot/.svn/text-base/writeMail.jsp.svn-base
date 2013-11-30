<%@page import="java.util.List" %>
<%@ page language="java" pageEncoding="GBK" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%List selectlist = (List) request.getAttribute("selectlist"); %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title></title>
        <link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
        <script src="lib/jquery/jquery-1.3.2.min.js" type="text/javascript">
        </script>
        <script src="lib/ligerUI/js/core/base.js" type="text/javascript">
        </script>
        <script src="lib/ligerUI/js/plugins/ligerForm.js" type="text/javascript">
        </script>
        <script src="lib/ligerUI/js/plugins/ligerDateEditor.js" type="text/javascript">
        </script>
        <script src="lib/ligerUI/js/plugins/ligerComboBox.js" type="text/javascript">
        </script>
        <script src="lib/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript">
        </script>
        <script src="lib/ligerUI/js/plugins/ligerButton.js" type="text/javascript">
        </script>
        <script src="lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript">
        </script>
        <script src="lib/ligerUI/js/plugins/ligerRadio.js" type="text/javascript">
        </script>
        <script src="lib/ligerUI/js/plugins/ligerSpinner.js" type="text/javascript">
        </script>
        <script src="lib/ligerUI/js/plugins/ligerTextBox.js" type="text/javascript">
        </script>
        <script type="text/javascript">
            $(function(){
                $("form").ligerForm();
            });
        </script>
        <style type="text/css">
            .l-table-edit {
            } .l-table-edit-td {
                padding: 4px;
            } .l-button-submit, .l-button-reset {
                width: 80px;
                float: left;
                margin-left: 10px;
                padding-bottom: 2px;
            }
        </style>
    </head>
    <body style="padding:10px">
        <form action="<%= request.getContextPath()%>/Mail.do?method=writeMailAction" method="post">
            <div>
            </div>
            <table cellpadding="0" cellspacing="0" class="l-table-edit">
                <tr>
                    <td align="right" class="l-table-edit-td">
                        发送给:
                    </td>
                    <td align="left" class="l-table-edit-td">
                        <select name="fillselect" id="fillselect" ltype="select">
                            <%                            for (int i = 0; i < selectlist.size(); i++) { %>
                            <option value="<%=selectlist.get(i)%>"><%=selectlist.get(i) %></option>
                            <%                            } %>
                        </select>
                    </td>
                </tr>
               
                <tr>
                    <td align="right" class="l-table-edit-td">
                        主题:
                    </td>
                    <td align="left" class="l-table-edit-td">
                        <input name="theme" type="text" id="theme" ltype="text" />
                    </td>
                    <td align="left">
                    </td>
                </tr>
                <tr>
                    <td align="right" class="l-table-edit-td" >
                        邮件内容:
                    </td>
                    <td align="left" class="l-table-edit-td">
                        <textarea name="details" cols="100" rows="4" class="l-textarea" style="width:90%">
                        </textarea>
                    </td>
                    <td align="left">
                    </td>
                </tr>
            </table>
            <br/>
            <input type="submit" value="发送邮件" class="l-button l-button-submit" /><input type="reset" value="重置" class="l-button l-button-reset"/>
        </form>
        <div style="display:none">
            <!--  数据统计代码 -->
        </div>
    </body>
</html>
