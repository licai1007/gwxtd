<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>提示页面</title>
    <link href="${pageContext.request.contextPath}/res/css/generalstyle.css" type="text/css" rel="stylesheet">
  </head>
  <body>
      <table border="0" width="100%">
		  <tr height="70">
		    <td align="center"><img src="${pageContext.request.contextPath}/res/img/other/logo.gif" width="50" height="50"/>购物新天地</td>
		  </tr>
		  <tr height="15">
		    <td><hr color="#FF7F00" width="100%"/></hr></td>
		  </tr>
	 </table>
	 <br/><br/><br/><br/><br/><br/><br/><br/><br/>
	 <center>
	   <font color="red" size="12">${msg}</font>
	   <br/><br/>
	   <c:if test="${flag != 'isExist'}">
	   	<a href="javascript:history.back()">单击这里返回</a>
	   </c:if>
	   &nbsp;&nbsp;&nbsp;&nbsp;
	   <a href="${pageContext.request.contextPath}/index.html">首页</a>
	 </center>
  </body>
</html>