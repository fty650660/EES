<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
 <%				String id=String.valueOf(request.getSession().getAttribute("ID"));
              	String type=(String)request.getSession().getAttribute("role"); 
            if(id==null || id.isEmpty()){response.sendRedirect("form/login.jsp");}
            String root=request.getContextPath(); %>
<head>
    <title></title>
    <link href="CSS/Reset.css" rel="stylesheet" type="text/css" />
    <link href="CSS/Common.css" rel="stylesheet" type="text/css" />
    <link href="CSS/Frame.css" rel="stylesheet" type="text/css" />

    <link href="lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <link href="lib/ligerUI/skins/Silvery/css/ligerui-all.css" rel="stylesheet" type="text/css" />

    <script src="lib/jquery-1.4.1-vsdoc.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/ligerui.all.js" type="text/javascript"></script>

    <script type="text/javascript">
        var tab;
        var a=<%=type%>;
		      $(function(){
            if(a==1){$("<li ><span>站内信箱</span><ul><li><span><a href=\"\">发邮件</a></span></li><li><span><a href=\"\">邮件箱</a></span></li></ul></li><li><span>学生</span><ul><li><span><a href=\"<%=root%>/student.do?method=getStudentCourse\">选课表</a></span></li></ul></li> ").appendTo($("#nav"));}
            else if(a==2){$("<li><span>教师</span><ul><li><span><a href=\"<%=root%>/teacher.do?method=getTeacherCourse\">任课表</a></span></li></ul></li>").appendTo($("#nav"));}
            else{$("<li><span>站内信箱</span><ul><li ><span><a href=\"\">邮件箱</a></span></li></ul></li><li><span>管理员</span><ul><li isexpand=\"false\"><span>评价结果查看</span><ul><li><span><a href=\"\">学院列表</a></span></li><li><span><a href=\"<%=root%>/admin.do?method=findByType&chooseType=1\">教师列表</a></span></li><li><span><a href=\"<%=root%>/admin.do?method=findByType&chooseType=2\">班级列表</a></span></li><li><span><a href=\"<%=root%>/admin.do?method=findByType&chooseType=3\">课程列表</a></span></li></ul></li><li isexpand=\"false\"><span>系统管理</span><ul><li><span><a href=\"<%=root%>/admin.do?method=findByType&chooseType=5\">权限修改</a></span></li><li><span><a href=\"<%=root%>/admin.do?method=findByType&chooseType=6\">问卷题目管理</a></span></li></ul></li></ul></li>").appendTo($("#nav"));};
            })
		      
		      
        function heightChanged(obj) {
           if(tab) tab.addHeight(obj.diff);
        }

        function init() {
            var obj = {
                topHeight: $("#top").height(),
                bottomHeight: $("#bottom").height(),
                leftWidth: 200,
                onHeightChanged: heightChanged
            };
            $("#container").ligerLayout(obj);
            $("#nav").ligerTree({
                checkbox:false
            });

            var height = $(".l-layout-center").height();
            $("#tab").ligerTab({ height: height });
            tab = $("#tab").ligerGetTabManager();

            $("#nav a").click(function () {
                if (this.target == "dialog") {
                    $.ligerDialog.open({
                        url: this.href,
                        title: this.innerHTML,
                        width: this.attributes["w"].value,
                        height: $(this).attr("h"),
                        isResize: true
                    });
                }
                else {
                    tab.addTabItem({
                        tabid: this.target,
                        url: this.href,
                        text: this.innerHTML
                    });
                }
                return false;
            });
        }
        $(init);

    </script>
</head>
<body>
    <div id="container"  class="l-layout" style="height: 349px;">
        <div id="top" position="top" style="height: 70px;">
            <h4>EES 教学评估系统</h4>
            <input style="float:right" type="button" value="退出" onClick="javascript:location.href ='<%=root%>/form/login.jsp' "/> 
           <!--   <a style="float:right" href="<%=root%>/form/login.jsp">退出</a>-->
                          <h1><%=id %>角色类型：<%=type %></h1>         


        </div>
        <div title="系统菜单" id="left" position="left">
            <ul id="nav">
        <script language="JavaScript">
			  typeget();
		</script>
            </ul>
        </div>
        <div id="center" position="center">
            <!--<iframe name="main" src="http://www.baidu.com/"></iframe>-->
            <div id="tab">
                <div tabid="home" title="我的主页" >
                    <img src="lib/icon.jpg" alt="Alternate Text" />
                </div>
            </div>
        </div>
        <div id="bottom" position="bottom">Andy·Wade 版权所有 </div>
    </div>
</body>
</html>
