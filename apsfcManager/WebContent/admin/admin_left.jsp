<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style>
body {
	font:12px Arial, Helvetica, sans-serif;
	color: #000;
	background-color: #EEF2FB;
	background:liner-gradient(45deg,red,black);
	margin: 0px;
}
#container {
	width: 182px;
}
H1 {
	font-size: 12px;
	margin: 0px;
	width: 182px;
	cursor: pointer;
	height: 30px;
	line-height: 20px;	
}
H1 a {
	display: block;
	width: 182px;
	color: #000;
	height: 30px;
	text-decoration: none;
	moz-outline-style: none;
	line-height: 30px;
	text-align: center;
	margin: 0px;
	padding: 0px;
}
.content{
	width: 182px;
	
}
.MM ul {
	list-style-type: none;
	margin: 0px;
	padding: 5px;
	display: block;
	align:center;
}
.MM li {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 25px;
	color: #333333;
	list-style-type: none;
	display: block;
	text-decoration: none;
	height: 30px;
	width: 182px;
	padding-left: 0px;
}
.MM {
	width: 182px;
	margin: 0px;
	padding: 0px;
	left: 0px;
	top: 0px;
	right: 0px;
	bottom: 0px;
	clip: rect(0px,0px,0px,0px);
}
.MM a:link {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	height: 26px;
	width: 182px;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	text-decoration: none;
}
.MM a:visited {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	height: 26px;
	width: 182px;
	text-decoration: none;
}
.MM a:active {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	height: 26px;
	width: 182px;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	text-decoration: none;
}
.MM a:hover {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	font-weight: bold;
	color: #006600;
	text-align: center;
	display: block;
	margin: 0px;
	padding: 0px;
	height: 26px;
	width: 182px;
	text-decoration: none;
}
</style>
</head>

<body>


<table width="100%" height="280" border="0" cellpadding="0" cellspacing="0" bgcolor="#EEF2FB">
  <tr>
    <td width="182" valign="top"><div id="container">
      <h1 class="type"><a href="javascript:void(0)"><font size=3>菜单详情管理</font><img src="${pageContext.request.contextPath}/admin/images/7.png" width=30 height=20 title="订单"></a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        </table>
        <ul class="MM">
        
        <li><a href="${pageContext.request.contextPath}/menusServlet?action=findTypesAll" target="main"><font size=2 color="#7d7d7d"><strong>添加新菜单</a></li>
        <li><a href="${pageContext.request.contextPath}/menusServlet?action=findAll&&curPage=1" target="main">菜单信息列表</a></li>
      
        </ul>
      </div>
      <h1 class="type"><a href="javascript:void(0)"><font size=3>菜单类别管理</font><img src="${pageContext.request.contextPath}/admin/images/5.png" width=26 height=20 title="订单"></a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        </table>
        <ul class="MM">
            <li><a href="../admin/type_add.jsp" target="main"><font size=2 color="#7d7d7d">添加新类别</a></li>
            <li><a href="${pageContext.request.contextPath}/typeServlet?action=findAll" target="main">类别信息列表</a></li>
        </ul>
      </div>
      <h1 class="type"><a href="javascript:void(0)"><font size=3>公告信息管理</font><img src="${pageContext.request.contextPath}/admin/images/3.png" width=20 height=20 title="公告"></a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        </table>
        <ul class="MM">
		   <li><a href="../admin/notice_add.jsp" target="main"><font size=2 color="#7d7d7d">添加新通告</a></li>
            <li><a href="${pageContext.request.contextPath}/noticeServlet?action=findAll" target="main">通告信息列表</a></li>
        </ul>
      </div>
      <h1 class="type"><a href="javascript:void(0)"><font size=3>销售订单管理</font> <img src="${pageContext.request.contextPath}/admin/images/4.png" width=20 height=20 title="订单"></a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        </table>
        <ul class="MM">
          <li><a href="${pageContext.request.contextPath}/ordersServlet?action=findAll&&curPage=1" target="main"><font size=2 color="#7d7d7d"><strong>销售订单信息列表🖨</a></li>
          <li><a href="${pageContext.request.contextPath}/ordersServlet?action=orderSearch&&curPage=1" target="main">销售订单查询</a></li>
          <li><a href="${pageContext.request.contextPath}/orderStaticServlet?action=findOrder&&curPage=1" target="main">本日销售额统计</a></li>
        </ul>
      </div>
    </div>

    <h1 class="type"><a href="../admin/admin_update.jsp" target="main"><font size=3>系统用户管理<img src="${pageContext.request.contextPath}/admin/images/9.png" width=20 height=20 title="用户管理"></a></h1>
    <h1 class="type" align=center><a href="${pageContext.request.contextPath}/adminServlet?action=logout" target="main"><font size=3>注销退出 &nbsp;&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/admin/images/8.png" width=20 height=20 title="退出"></a></h1>
      </td>
  </tr>
</table>
</body>
</html>
