﻿<%@ page language="java" contentType="text/html; charset=utf-8" %>
<html>
    <%	String id=String.valueOf(request.getSession().getAttribute("ID"));
    String type=(String)request.getSession().getAttribute("role");
    if(id==null || id.isEmpty()){response.sendRedirect("form/login.jsp");}
    String root=request.getContextPath(); %>
    <head>
        <title></title>
        <link href="CSS/Reset.css" rel="stylesheet" type="text/css" />
        <link href="CSS/Common.css" rel="stylesheet" type="text/css" />
        <link href="CSS/Frame.css" rel="stylesheet" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
        <link href="lib/ligerUI/skins/Silvery/css/ligerui-all.css" rel="stylesheet" type="text/css" />
        <script src="lib/jquery/jquery-1.3.2.min.js" type="text/javascript">
        </script>
        <script src="lib/ligerUI/js/ligerui.all.js" type="text/javascript">
        </script>
        <script type="text/javascript">
                        var tab = null;
                        var accordion = null;
                        var tree = null;
                        var a=<%=type%>;
                        var indexdata ;
                        $(function ()
                        {
                            
            
                if (a==3) {indexdata = 
                [
                    { text: '站内信箱',isexpand:false, children: [ 
                        {url:"<%=root%>/MailList.do?method=adminMailList",text:"查看站内信"}
                    ]
                    },
                    { text: '学生评价结果查看', isexpand: false, children: [
						{ url: "<%=root%>/admin.do?method=showStaticlist&chooseType=5&type=0", text: "按学期分类" },
						{ url: "<%=root%>/admin.do?method=showStaticlist&chooseType=5&type=1", text: "专业统计表" },
					{ text: '职称统计', isexpand: false, children: [
                        { url: "<%=root%>/admin.do?method=showStaticlist&chooseType=5&type=4", text: "任课情况表" },
						{ url: "<%=root%>/admin.do?method=showStaticlist&chooseType=5&type=2", text: "职称统计表" },
                        
                    	]
                    	},
						{ url: "<%=root%>/admin.do?method=showStaticlist&chooseType=5&type=3", text: "课程类型统计表" }
                        
                    ]
                    },					
					{ text: '教师互评结果查看', isexpand: false, children: [
                        { url: "<%=root%>/AdminCheckTea.do?method=showAllTeaCourseListByFaculty", text: "教师评价结果（系）" },
                        { url: "<%=root%>/AdminCheckTea.do?method=showAllTeaCourseListByXn", text: "教师评价结果（学年）" },
                        { url: "<%=root%>/AdminCheckTea.do?method=showAllTeaCourseListBySearch", text: "总教师表(高级查询)" },
						{ url: "<%=root%>/AdminCheckTea.do?method=xnXq", text: "职称统计(教师互评)" }
                        
                    ]
                    },
                        { text: '系统管理', isexpand: false, children: [
                        { url: "<%=root%>/admin.do?method=findByType&chooseType=5", text: "权限修改" },
                        { url: "<%=root%>/admin.do?method=findByType&chooseType=6", text: "问卷题目管理" }
                    ]
                    },

                ];} 
            				else if (a==2) {indexdata =
                            [
                                { text: '老师', isexpand: false, children: [
            					{ url: "<%=root%>/TeaEvaluation.do?method=showFacultyCourse", text: "评价同系教师" },
            					{ url: "<%=root%>/TeaEvaluation.do?method=myCourseList", text: "查看教师评价" },
                                { url: "<%=root%>/teacher.do?method=getTeacherCourse", text: "查看学生课表" }
                                    
                                ]
                                }
                            ];} else{indexdata =
                            [
                                { text: '站内信箱',isexpand:false, children: [ 
            						{url:"<%=root%>/Mail.do?method=fillSelectAction",text:"发站内信"},
                                    {url:"<%=root%>/MailList.do?method=stuMailList",text:"查看站内信"}
                                ]
                                },
                                { text: '学生', isexpand: false, children: [
                                    { url: "<%=root%>/student.do?method=getStudentCourse", text: "选课表" }
                                    
                                ]
                                }
                            ];};
                            //布局
                            $("#layout1").ligerLayout({ leftWidth: 190, height: '100%',heightDiff:-34,space:4, onHeightChanged: f_heightChanged });
            
                            var height = $(".l-layout-center").height();
            
                            //Tab
                            $("#framecenter").ligerTab({ height: height });
            
                            //面板
                            $("#accordion1").ligerAccordion({ height: height - 24, speed: null });
            
                            $(".l-link").hover(function ()
                            {
                                $(this).addClass("l-link-over");
                            }, function ()
                            {
                                $(this).removeClass("l-link-over");
                            });
                            //树
                            $("#tree1").ligerTree({
                                data : indexdata,
                                checkbox: false,
                                slide: false,
                                nodeWidth: 120,
                                attribute: ['nodename', 'url'],
                                onSelect: function (node)
                                {
                                    if (!node.data.url) return;
                                    var tabid = $(node.target).attr("tabid");
                                    if (!tabid)
                                    {
                                        tabid = new Date().getTime();
                                        $(node.target).attr("tabid", tabid);
                                    } 
                                    f_addTab(tabid, node.data.text, node.data.url);
                                }
                            });
            
                            tab = $("#framecenter").ligerGetTabManager();
                            accordion = $("#accordion1").ligerGetAccordionManager();
                            tree = $("#tree1").ligerGetTreeManager();
                            $("#pageloading").hide();
            
                        });
                        function f_heightChanged(options)
                        {
                            if (tab)
                                tab.addHeight(options.diff);
                            if (accordion && options.middleHeight - 24 > 0)
                                accordion.setHeight(options.middleHeight - 24);
                        }
                        function f_addTab(tabid,text, url)
                        { 
                            tab.addTabItem({ tabid : tabid,text: text, url: url });
                        } 
                         
                        
                 
        </script>
        <style type="text/css">
            body, html {
                height: 100%;
            }
            
            body {
                padding: 0px;
                margin: 0;
                overflow: hidden;
            } .l-link {
                display: block;
                height: 26px;
                line-height: 26px;
                padding-left: 10px;
                text-decoration: underline;
                color: #333;
            } .l-link2 {
                text-decoration: underline;
                color: white;
                margin-left: 2px;
                margin-right: 2px;
            } .l-layout-top {
                background: #102A49;
                color: White;
            } .l-layout-bottom {
                background: #E5EDEF;
                text-align: center;
            } #pageloading {
                position: absolute;
                left: 0px;
                top: 0px;
                background: white url('loading.gif') no-repeat center;
                width: 100%;
                height: 100%;
                z-index: 99999;
            } .l-link {
                display: block;
                line-height: 22px;
                height: 22px;
                padding-left: 16px;
                border: 1px solid white;
                margin: 4px;
            } .l-link-over {
                background: #FFEEAC;
                border: 1px solid #DB9F00;
            } .l-winbar {
                background: #2B5A76;
                height: 30px;
                position: absolute;
                left: 0px;
                bottom: 0px;
                width: 100%;
                z-index: 99999;
            } .space {
                color: #E7E7E7;
            }
            
            /* 顶部 */ .l-topmenu {
                margin: 0;
                padding: 0;
                height: 60px;
                line-height: 31px;
                background: url('lib/top.jpg') repeat-x bottom;
                position: relative;
                border-top: 1px solid #1D438B;
            }
            
            /*.l-topmenu-logo{ color:#E7E7E7; padding-left:35px; line-height:26px;background:url('lib/topicon.gif') no-repeat 10px 5px;}*/ .l-topmenu-welcome {
                position: absolute;
                height: 24px;
                line-height: 24px;
                right: 30px;
                top: 2px;
            } .l-topmenu-welcome a {
                color: #E7E7E7;
                text-decoration: underline
            }
        </style>
    </head>
    <body style="padding:0px;background:#EAEEF5;">
        <div id="pageloading">
        </div>
        <div id="topmenu" class="l-topmenu">
            <div class="l-topmenu-logo">
                <h1>EES 教学评估系统</h1>
            </div>
            <div class="l-topmenu-welcome">
                <input style="float:right" type="button" value="退出" onClick="javascript:location.href ='<%=root%>/form/login.jsp' "/><!--<a href="<%=root%>/form/login.jsp" style= class="l-link2" target="_blank">退出</a>-->
            </div>
        </div>
        <div id="layout1" style="width:99.2%; margin:0 auto; margin-top:4px; ">
            <div position="left" title="主要菜单" id="accordion1">
                <div title="功能列表" class="l-scroll">
                    <ul id="tree1" style="margin-top:3px;">
                </div>
            </div>
            <div position="center" id="framecenter">
                <div tabid="home" title="我的主页" style="height:300px">
                    <img src="lib/icon.jpg" alt="Alternate Text" />
                </div>
            </div>
        </div>
        <div style="height:32px; line-height:32px; text-align:center;">
            版权所有：贵州大学计算机科学与信息学院   中国·贵州·花溪 
            2001-2012.All Rights Reserved
        </div>
        <div style="display:none">
        </div>
    </body>
</html>
