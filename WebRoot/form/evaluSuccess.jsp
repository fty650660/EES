<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>添加评价成功</title>
		<script type="text/javascript">
			function printEvaluTable(){
				window.open("printEvaluation.jsp");
			}
		</script>
    </head>
    <body>
        <p>
            评价成功，返回上一页进行打印？<a href="javascript:" onClick="history.back(-1)">返回</a>
        </p>
    </body>
</html>
