<%@page import="java.util.*"%>
<%@ page language="java"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<base href="${pageContext.request.contextPath }/admin/">
<!-- <link href="images/common.css" rel="stylesheet" type="text/css" /> -->
<link href="images/skin.css" rel="stylesheet" type="text/css" />
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
						cellPadding="0">
						<tbody style="margin: 0; padding: 0">
							<tr>
								<td class="line_table" align="center" colspan="11" height="20"><span
									class="left_bt2">菜单信息列表</span></td>
							</tr>
							
							<tr>
								<td class="line_table" align="center" width=80><span
									class="left_bt2">菜单名称</span></td>
								<td class="line_table" align="center" width=60 height=30><span
									class="left_bt2">展示图片</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">原料</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">类型</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">说明</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">市场价格</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">市场价销售数量</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">会员单价</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">会员价销售数量</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">&nbsp;</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">&nbsp;</span></td>
							</tr>
				
							
							
						<c:forEach items="${requestScope.page.list }" var="menus">
							<tr onmouseover="this.style.backgroundColor='#c5c5c5';" onmouseout="this.style.backgroundColor='#ececec';">
								<td class="line_table" align="center"><a
									href="menus_update.jsp?">${menus.name}</a></td>
								<td class="line_table" align="center" height=55 width=65><a
									href="${pageContext.request.contextPath }/${menus.imgpath}"><img src="${pageContext.request.contextPath }/${menus.imgpath}"
										width="60" height="50"></a></td>
								<td class="line_table" align="center"><span
									class="left_txt">${menus.burden}</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${menus.typename}</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${menus.brief}</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${menus.price}</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${menus.sums}</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${menus.price1}</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${menus.sums1}</span></td>
								<td class="line_table" align="center"><a
									href="${pageContext.request.contextPath}/menusServlet?action=findID&&id=${menus.id}"><img src="${pageContext.request.contextPath}/admin/images/1.jpg" width=30 height=30 title="修改"></a></td>
								<td class="line_table" align="center"><a
									href="${pageContext.request.contextPath}/menusServlet?action=delete&&name=${menus.name}"><img src="${pageContext.request.contextPath}/admin/images/2.jpg" width=30 height=30 title="删除"></a></td>
							</tr>
							<tr><th colspan=11 height=8></th></tr>
							</c:forEach>
							
							<tr>
								<td class="line_table" align="center" colspan="11" height="20">
								<span class="left_bt2">第${page.curPage }页
										&nbsp;&nbsp;共${page.totalPage }页
								</span>&nbsp;&nbsp; 
								<c:choose>
								<c:when test="${page.curPage eq 1 }">
								 <span style="color: gray;font-size: 12px">[首页]</span>
								</c:when>
								<c:otherwise>
					<a href="${pageContext.request.contextPath }/menusServlet?action=findAll&&curPage=1">[首页]</a>
								</c:otherwise>
								</c:choose>
								 
								 <c:choose>
								 <c:when test="${page.curPage eq page.totalPage  }">
								 <span style="color: gray;font-size: 12px">[尾页]</span>
								 </c:when>
								 <c:otherwise>
								 <a href="${pageContext.request.contextPath }/menusServlet?action=findAll&&curPage=${page.totalPage}">[尾页]</a>
								 </c:otherwise>
								 </c:choose>
								 
								 <c:choose>
								 <c:when test="${page.curPage eq 1 }">
								 <span style="color: gray;font-size: 12px">[上一页]</span>
								 </c:when>
								 <c:otherwise>
					<a href="${pageContext.request.contextPath }/menusServlet?action=findAll&&curPage=${page.curPage-1 }">[上一页]</a>
								</c:otherwise>
								 </c:choose>
								 
								  <c:choose>
								 <c:when test="${page.curPage eq page.totalPage  }">
								 <span style="color: gray;font-size: 12px">[下一页]</span>
								 </c:when>
								 <c:otherwise>
					<a href="${pageContext.request.contextPath }/menusServlet?action=findAll&&curPage=${page.curPage+1 }">[下一页]</a>
								</c:otherwise>
								 </c:choose>
								</td>
							</tr>

					</table>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
