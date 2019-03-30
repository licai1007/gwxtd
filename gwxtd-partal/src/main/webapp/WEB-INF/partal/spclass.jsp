<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>class</title>
</head>
<body>
<center>
<table border="0" width="80%" bgcolor="#FFE3C8" height="90%">
  <tr align="center">
    <td><a href="adlogin.jsp">商品管理</a></td>
  </tr>
  <tr align="center">
    <td>商品分类</td>
  </tr>
	<c:forEach items="${classs}" var="classify">
	    <tr>
	      <td align="center">
	        <a href="${pageContext.request.contextPath}/goods/splist.html?gclass=${classify}">${classify}</a>
	      </td>
	    </tr>
	</c:forEach>
</table>
</center>
</body>
</html>