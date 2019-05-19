<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<base href="${pageContext.request.contextPath }/admin/">
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
<script type="text/javascript">
function altRows(id){
if(document.getElementsByTagName){  
var table = document.getElementById(id);  
var rows = table.getElementsByTagName("tr"); 
for(i = 0; i < rows.length; i++){          
if(i % 2 == 0){
                rows[i].className = "evenrowcolor";
            }else{
                rows[i].className = "oddrowcolor";
            }      
        }
    }
}
window.onload=function(){
    altRows('alternatecolor');
}
</script>


<style type="text/css">
table.altrowstable {
    font-family: verdana,arial,sans-serif;
    font-size:11px;
    color:#333333;
    border-width: 1px;
    border-color: #dfdfdf;
    border-collapse: collapse;
}

table.altrowstable td {
    border-width: 1px;
    padding: 8px;
    border-style: solid;
    border-color: #dfdfdf;
}
.oddrowcolor{
    background-color:#e8e8e8;
}
.evenrowcolor{
    background-color:#7d7d7d;
}

</style>
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
		cellspacing="0" >
		<tr>
			<td valign="top" bgcolor="#F7F8F9">
				<div align="center">
					<table id="table2" class="altrowstable"
						style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
						cellPadding="0" >
						<tbody style="margin: 0; padding: 0">
							<tr>
								<td class="line_table" align="center" colspan="8" height="20">
									<span class="left_bt2">本日销售额统计</span>
								</td>
							</tr>
							<tr>
								<td class="line_table" align="center" width="25%" height=35><span
									class="left_bt2">菜品名称</span></td>
								<td class="line_table" align="center" width="25%"><span
									class="left_bt2">订购数量</span></td>
								<td class="line_table" align="center" width="25%"><span
									class="left_bt2">单价</span></td>
								<td class="line_table" align="center" width="25%"><span
									class="left_bt2">合计</span></td>
							</tr>

							<c:forEach items="${requestScope.page.list}" var="order">
							<tr >
								<td class="line_table" align="center" width="25%"><span
									class="left_txt">${order.menuname}	</span></td>
								<td class="line_table" align="center" width="25%"><span
									class="left_txt">${order.sum }</span></td>
								<td class="line_table" align="center" width="25%"><span
									class="left_txt">${order.price }</span></td>
								<td class="line_table" align="center" width="25%"><span
									class="left_txt">${order.price*order.sum}</span></td>
							</tr>
							<tr><th colspan=5 height=3></th></tr>
							<c:set var="price1" value="${price1+order.sum*order.price }"></c:set>
							</c:forEach>
							
							<tr>
								<td class="line_table" align="center" colspan="8"><span
									class="left_bt2"><strong>销售总计：${price1}元</strong>
								</span></td>
								
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
					<a href="${pageContext.request.contextPath }/orderStaticServlet?action=findOrder&&curPage=1">[首页]</a>
								</c:otherwise>
								</c:choose>
								 
								 <c:choose>
								 <c:when test="${page.curPage eq page.totalPage  }">
								 <span style="color: gray;font-size: 12px">[尾页]</span>
								 </c:when>
								 <c:otherwise>
								 <a href="${pageContext.request.contextPath }/orderStaticServlet?action=findOrder&&curPage=${page.totalPage}">[尾页]</a>
								 </c:otherwise>
								 </c:choose>
								 
								 <c:choose>
								 <c:when test="${page.curPage eq 1 }">
								 <span style="color: gray;font-size: 12px">[上一页]</span>
								 </c:when>
								 <c:otherwise>
					<a href="${pageContext.request.contextPath }/orderStaticServlet?action=findOrder&&curPage=${page.curPage-1 }">[上一页]</a>
								</c:otherwise>
								 </c:choose>
								 
								  <c:choose>
								 <c:when test="${page.curPage eq page.totalPage  }">
								 <span style="color: gray;font-size: 12px">[下一页]</span>
								 </c:when>
								 <c:otherwise>
					<a href="${pageContext.request.contextPath }/orderStaticServlet?action=findOrder&&curPage=${page.curPage+1 }">[下一页]</a>
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
