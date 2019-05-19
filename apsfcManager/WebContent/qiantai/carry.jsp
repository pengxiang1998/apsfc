<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>配送说明</title>
<meta content="" name=keywords />
<meta content="" name=description />
</head>
<body >
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="left" valign="top">
  
    
  <jsp:include flush="fasle" page="top.jsp"/>
    
    </td>
  </tr>
  <tr >
  <td height="50"></td>
  
</tr>
  
  <tr>
    <td align="center" valign="top" height="250">
    
    <table border="0" cellspacing="0"  width="100%">
    
		<tr>
		  <td  align="center" valign="top">
			 <strong><span style="font-family: Helvetica, sans-serif;font-size: 20px;">
			       配送指南
			 </span></strong>
			 <br>
		  </td>
		</tr>
		<c:forEach items="${requestScope.send }" var="send">
							
		<tr>
		  <td  align="left" valign="top" >
             <p style=" font-size: 14px;">
              <br><br>
             <strong>午餐时间：</strong><span style="color:#F00">${send.time1 }</span><br><br>
             <strong>晚餐时间：</strong><span style="color:#F00">${send.time2 }</span> <br><br>
             <strong>联系电话：</strong><span style="color:#F00">${send.phone }</span> <br><br>
             <strong>联系人：</strong><span style="color:#F00">${send.man }</span> <br><br>
             <strong>注：</strong><span style="color:#F00">${send.content }</span> <br><br>
             
             </p>
             
             <p style=" font-size: 14px;">
 
             &nbsp;&nbsp;&nbsp;&nbsp;订单经过本店客服人员确认后，将安排快递人员送餐。
                                            由于中午订餐人员比较多，请在本店正常营业时间外订餐，到时才能准时送达！
                                            周末进店人员比较多，暂不支持订餐，望见谅！<br><br>
             
             </p>
		  </td>
		</tr>
		</c:forEach>
		<tr>
		  <td  align="center"  >
			 <a href="index.jsp" target="_self">
			 <span style="font-family: Helvetica, sans-serif;font-size: 16px;">
			     返回
			 </span></a>
		  </td>
		</tr>	
   </table>
     </td>
  </tr>
  <tr>
    <td height="10">&nbsp;</td>
  </tr>
  <tr>
    <td height="50" align="center" valign="middle">&nbsp; 
   
        <jsp:include flush="fasle" page="copyright.jsp"/>
    </td>
  </tr>
  
</table>


 
</body>
</html>
