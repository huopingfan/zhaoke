<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'page.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     <center>
                <c:if test="${page.pagenow==1 }">
                首页 ，上一页
                </c:if>
                   <c:if test="${page.pagenow !=1 }">
                    <a href="javascript:;" onclick="jumpPage(1)">首页  ，</a>
                      <a href="javascript:;" onclick="jumpPage(${page.pagenow }-1)">上一页  ，</a>
                </c:if>
                <c:if test="${page.pagesum==page.pagenow or page.pagesum ==0 }">
                         下一页，尾页 ，
                </c:if>
                 <c:if test="${page.pagesum !=page.pagenow and page.pagesum !=0 }">
                     <a href="javascript:;" onclick="jumpPage(${page.pagenow }+1)">下一页, </a>
                     <a href="javascript:;" onclick="jumpPage(${page.pagesum })">尾页 ，</a>
                </c:if>
                第${page.pagenow }页，共${page.pagesum }页，共${page.totalcount }条
            </center>
  </body>
</html>
