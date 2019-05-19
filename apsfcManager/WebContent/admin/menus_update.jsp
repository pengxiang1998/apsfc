<%@page import="java.util.*"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--  <base href="${pageContext.request.contextPath }/admin/">-->
<!-- <link href="images/common.css" rel="stylesheet" type="text/css" /> -->
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="js/verify.js"></script>
<script type="text/javascript">
	function verifyInfo() {
		//菜品名称
		if(!verifyNotNull(document.form1.name.value)) {
			alert("菜品名称不能为空!");
			return false;
		}
		//原料
		if(!verifyNotNull(document.form1.burden.value)) {
			alert("原料不能为空");
			return false;
		}
		//市场价格
		/* debugger; */
		if(!verifyPositiveInt(document.form1.price.value)) {
			alert("市场价格必须为正整数");
			return false;
		}
		//会员价格
		if(!verifyPositiveInt(document.form1.price1.value)) {
			alert("会员价格必须为正整数");
			return false;
		}
		//说明
		if(!verifyNotNull(document.form1.brief.value)) {
			alert("说明不能为空");
			return false;
		}
	}
</script>
</head>
<body>

	<table width="100%" height="1" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td valign="top" bgcolor="#F7F8F9">
				<p>修改菜单</p>
				<div align="center">
					<form action="${pageContext.request.contextPath}/menusServlet?action=update" method="post"
						name="form1" onSubmit="return verifyInfo()">
						<table id="table2" class="line_table"
							style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
							cellPadding="0">

							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">菜单名称：</span></td>
								<td class="line_table" height="25" width="70%"><input
									type="text" name="name" size="45" value="${requestScope.menus.name }">
									<input
									type="text" name="id"  size="45" value="${requestScope.menus.id }" hidden>
									</td>
							</tr>

							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">原&nbsp;&nbsp;&nbsp; 料：</span></td>
								<td class="line_table" height="25" width="80%"><input
									type="text" name="burden" size="45"
									value="${requestScope.menus.burden }"></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">市场价格：</span></td>
								<td height="25" width="80%"><input type="text" name="price"
									size="45" value="${requestScope.menus.price }"></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">会员价格：</span></td>
								<td height="25" width="80%"><input type="text"
									name="price1" size="45" value="${requestScope.menus.price1 }"></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">说&nbsp;&nbsp;&nbsp; 明：</span></td>
								<td class="line_table" height="25" width="80%"><textarea
										rows="6" name="brief" cols="70">${requestScope.menus.brief }</textarea></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">菜品类别：</span></td>
								<td class="line_table" height="25" width="80%"><select
									name="typeid">
										<c:forEach items="${requestScope.types }" var="type">
									<c:choose>
									<c:when test="${menus.typeid eq type.id }">
									<option value="${type.id }" selected="selected">${type.name }</option>
									</c:when>
									<c:otherwise>
									<option value="${type.id }">${type.name }</option>
									</c:otherwise>
									</c:choose>
										
									
									</c:forEach>

								</select></td>
							</tr>
							<tr>
								<td class="line_table" align="right" width="20%"><span
									class="left_bt2">展示图片</span>：</td>
								<td class="line_table" width="80%" align="left"><img
								style="border-radius:5px"	src="${pageContext.request.contextPath }/${menus.imgpath}" width=120 height=100><input type="hidden" name="id" value="1"/></td>
							</tr>

							<tr>
								
								<td class="line_table" height="25" align="center" colspan="2">
									<input type="submit" value="修改" >
								</td>
							</tr>
						</table>
					</form>
				</div>
			</td>

		</tr>
	</table>


</body>
</html>
