<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style>
    p{ 
       color: blue;
        font-size: 12px;
    }

</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>关于我们</title>
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
    <td align="center" valign="top" height="400">
    
    <table border="0" cellspacing="0"  width="100%">
    
		<tr>
		  <td  align="center" vlign="top"  >
			 <strong><span style="font-family: Helvetica, sans-serif;font-size: 20px;">
			       关于我们
			 </span></strong>
			 <br>
		  </td>
		</tr>
		<tr>
		  <td  align="left" vlign="top" >
             <p style=" font-size: 16px;">
              <br><br>
 
 
 
      <c:forEach items="${requestScope.des }" var="des">
							<tr>
								<td class="line_table" align="center" width="20%"><span
									class="left_txt"><p style: font-size:12px>${des.content }</p></span></td>
								
							</tr>
						</c:forEach>
 
 
 
            
             </p>
        
		  </td>
		</tr>
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
