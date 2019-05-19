<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 导入jstl类库 -->
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
	<table width="90%" height="1" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td valign="top" bgcolor="#F7F8F9">
				<div align="center">
					<table id="table2" class="line_table"
						style="width: 80%; margin: 0; padding: 0" cellSpacing="0"
						cellPadding="0">
						<tbody style="margin: 0; padding: 0">
							<tr>
								<td class="line_table" align="center" colspan="8" height="20">
									<span class="left_bt2"><h3>类别信息列表</h3></span>
								</td>
							</tr>
							<tr>
								<td class="line_table" align="center" width="25%"><span
									class="left_bt2">类别ID</span></td>
								<td class="line_table" align="center" width="45%"><span
									class="left_bt2">类别名称</span></td>
								<td class="line_table" align="center" width="15%">操作</td>
								<td class="line_table" align="center" width="15%">操作</td>
							</tr>
							
							
							<c:forEach items="${requestScope.types }" var="type">
							<tr>
								<td class="line_table" align="center" width="25%"><span
									class="left_txt">${type.id}</span></td>
								<td class="line_table" align="center" width="45%"><span
									class="left_txt">${type.name} </span></td>
								<td class="line_table" align="center" width="15%"><a
									href="${pageContext.request.contextPath}/typeServlet?action=findById&&id=${type.id}" target="main"><img src="${pageContext.request.contextPath}/admin/images/1.jpg" width=30 height=30 title="修改"></a></td>
								<td class="line_table" align="center" width="15%"><a
									href="${pageContext.request.contextPath}/typeServlet?action=delete&&id=${type.id}" target="main"><img src="${pageContext.request.contextPath}/admin/images/2.jpg" width=30 height=30 title="删除"></a></td>
							</tr>

							</c:forEach>
					</table>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
