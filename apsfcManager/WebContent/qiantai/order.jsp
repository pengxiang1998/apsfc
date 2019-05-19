<%@ page language="java" import="java.util.*,java.text.*"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<base href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>我的订单</title>
<meta content="" name=keywords />
<meta content="" name=description />
<link href="css/skin.css" rel="stylesheet" type="text/css" /> 
<script src="js/date.js" type="text/javascript"></script>
</head>

<body style='background: transparent'>
	<table width="900" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td align="left" valign="top"><jsp:include flush="fasle"
					page="top.jsp" /></td>
		</tr>
		<tr>
			<td height="50px"></td>

		</tr>

		<tr>
			<td align="center" valign="top" height="420px">

				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td align="left" valign="top">

							<div align="center" width="120">
								<form action="${pageContext.request.contextPath}/ordersServlet?action=orderSearch3&&curPage=1&&username=${sessionScope.user.name}" name="form1" method="post">
									<table id="table1" class="line_table"
										style="width: 500px; margin: 0; padding: 0" cellSpacing="0"
										cellPadding="0">
										<tbody style="margin: 0; padding: 0">
											<tr>
												<td class="line_table" align="right" width="40%"><span
													class="left_bt2">按菜品名称查询</span></td>
												<td class="line_table" align="left" width="60%"><input
													type="text" name="menuname" size="20"> <input
													type="submit" value="查询"></td>
											<tr>
												
											</tr>
											<tr>
												<td class="line_table" align="center" colspan="3"><a
													href="${pageContext.request.contextPath}/ordersServlet?action=orderSearch1&&curPage=1&&username=${sessionScope.user.name}">我的所有订单</a>&nbsp;&nbsp;&nbsp;&nbsp; <a href="#">未已派送订单</a>&nbsp;&nbsp;&nbsp;&nbsp;
													<a href="#">已派送订单</a>&nbsp;&nbsp;&nbsp;&nbsp;</td>
											</tr>
									</table>
								</form>
							</div>
						</td>
					</tr>
					<tr>
						<td align="left" valign="top" height="20px"></td>
					</tr>
					<tr>
						<td align="left" valign="top">


							<div align="center">
								<table id="table2" class="line_table"
									style="width: 900px; margin: 0; padding: 0" cellSpacing="0"
									cellPadding="0"><hr>
									<tbody style="margin: 0; padding: 0" border=1>
										<tr>
											<td class="line_table" align="center" colspan="9"><span
												class="left_bt2"><h2>订单查询结果信息列表</h2></span></td>
										</tr>
										<tr bgcolor="#f0f0f0" height=40>
											<td class="line_table" align="center"><span
												class="left_bt2"><strong>菜品名称</strong></span></td>
											<td class="line_table" align="center"><span
												class="left_bt2"><strong>真实姓名</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2"><strong>订购电话</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2"><strong>派送地址</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2"><strong>订购数量</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2"><strong>单价(元)</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2"><strong>合计(元)</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2"><strong>订购时间</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2"><strong>是否派送</span></td>
										</tr>
										<tr><th colspan=9 height=8></th></tr>
										<c:forEach items="${requestScope.page.list }" var="order">
										<tr bgcolor="#f0f0f0" height=30>
											<td class="line_table" align="center"><span
												class="left_txt"><strong>${order.menuname }</span></td>
											<td class="line_table" align="center"><span
												class="left_txt"><strong>${order.realname }</span></td>
											<td class="line_table" align="center"><span
												class="left_txt"><strong>${order.phone }</span></td>
											<td class="line_table" align="center"><span
												class="left_txt"><strong>${order.address }</span></td>
											<td class="line_table" align="center"><span
												class="left_txt"><strong>${order.menusum}</span></td>
											<td class="line_table" align="center"><span
												class="left_txt"><strong>${order.price}</span></td>
											<td class="line_table" align="center"><span
												class="left_txt"><strong><font color=red>${order.price*order.menusum }</span></td>
											<td class="line_table" align="center"><span
												class="left_txt"><strong>${order.times}</span></td>
											<td class="line_table" align="center"><span
												class="left_txt"><strong>${order.delivery}</strong></span></td>
												
										</tr>
										<tr><th colspan=9 height=8></th></tr>
										</c:forEach>
										
										
								</table>
							</div>
						</td>
					</tr>
					<tr>
					
								<td class="line_table" align="center" colspan="11" height="40">
								<span class="left_bt2">第${page.curPage }页
										&nbsp;&nbsp;共${page.totalPage }页
								</span>&nbsp;&nbsp; 
								<c:choose>
								<c:when test="${page.curPage eq 1 }">
								 <span style="color: gray;font-size: 12px">[首页]</span>
								</c:when>
								<c:otherwise>
					<a href="${pageContext.request.contextPath }/ordersServlet?action=orderSearch1&&curPage=1&&username=${sessionScope.user.name}">[首页]</a>
								</c:otherwise>
								</c:choose>
								 
								 <c:choose>
								 <c:when test="${page.curPage eq page.totalPage  }">
								 <span style="color: gray;font-size: 12px">[尾页]</span>
								 </c:when>
								 <c:otherwise>
								 <a href="${pageContext.request.contextPath }/ordersServlet?action=orderSearch1&&curPage=${page.totalPage}&&username=${sessionScope.user.name}">[尾页]</a>
								 </c:otherwise>
								 </c:choose>
								 
								 <c:choose>
								 <c:when test="${page.curPage eq 1 }">
								 <span style="color: gray;font-size: 12px">[上一页]</span>
								 </c:when>
								 <c:otherwise>
					<a href="${pageContext.request.contextPath }/ordersServlet?action=orderSearch1&&curPage=${page.curPage-1 }&&username=${sessionScope.user.name}">[上一页]</a>
								</c:otherwise>
								 </c:choose>
								 
								  <c:choose>
								 <c:when test="${page.curPage eq page.totalPage  }">
								 <span style="color: gray;font-size: 12px">[下一页]</span>
								 </c:when>
								 <c:otherwise>
					<a href="${pageContext.request.contextPath }/ordersServlet?action=orderSearch1&&curPage=${page.curPage+1 }&&username=${sessionScope.user.name}">[下一页]</a>
								</c:otherwise>
								 </c:choose>
								</td>
							</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="10px">&nbsp;</td>
		</tr>
		<tr>
			<td height="50px" align="center" valign="middle"><jsp:include
					flush="fasle" page="copyright.jsp" /></td>
		</tr>
	</table>
</body>
</html>
