<%@page import="java.util.*"%>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link href="${pageContext.request.contextPath}/admin/images/skin.css" rel="stylesheet" type="text/css" /> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
-->
</style>
</head>

<body>

	<table width="100%" height="1" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td valign="top" bgcolor="#F7F8F9">


				<div align="center">
					<table id="table2" class="line_table"
						style="width: 90%; margin: 0; padding: 0" cellSpacing="0"
						cellPadding="0" border=none>
						<tbody style="margin: 0; padding: 0">
							<tr>
								<td class="line_table" align="center" colspan="8" height="20" >
									<span class="left_bt2"><h3>公告信息列表</h3></span>
								</td>
							</tr>
							<tr>
								<td class="line_table" align="center" width="25%" border=none><span
									class="left_bt2">标题</span></td>
								<td class="line_table" align="center" width="40%"><span
									class="left_bt2">内容</span></td>
								<td class="line_table" align="center" width="25%"><span
									class="left_bt2">发布时间</span></td>
								<td class="line_table" align="center" width="10%"></td>
							</tr>
							<c:forEach items="${requestScope.notices }" var="type">
							<tr>
								<td class="line_table" align="center" width="20%"><span
									class="left_txt">${type.name}</span></td>
								<td class="line_table" align="center" width="40%"><span
									class="left_txt">${type.content}</span></td>
								<td class="line_table" align="center" width="20%"><span
									class="left_txt">${type.times}</span></td>
								<td class="line_table" align="center" width="20%"><a
									href="${pageContext.request.contextPath}/noticeServlet?action=delete&&id=${type.id}"><img src="${pageContext.request.contextPath}/admin/images/2.jpg" width=30 height=30 title="删除"></a></td>
							</tr>
						
							</c:forEach>
					</table>
				</div>

			</td>

		</tr>
	</table>
</body>
</html>
