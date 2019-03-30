<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>我的商城</title>
  </head>
  <link href="${pageContext.request.contextPath}/res/css/generalstyle.css" type="text/css" rel="stylesheet">
  <body>
    <center>
      <table border="0" width="100%" height="100%" cellpadding="0" cellspacing="0">
        <tr height="100">
          <td colspan="2" align="center"><%@ include file="top.jsp" %></td>
        </tr>
        <tr height="100">
          <td width="225" height="100" align="center">
          <c:choose>
          	<c:when test="${empty ur}">
              <%@ include file="login.jsp" %>
            </c:when>
            <c:otherwise>
             	<table border='0' bgcolor='#FFF0E1' width='80%' height='150'>
	             	<tr align='center' height='80'>
		             	<td>
			             	${ur.uname}你好,<br/>
			             	欢迎你光顾本店!!!<br/>
			             	<a href="${pageContext.request.contextPath}/userinfo.html">查看/修改个人信息</a>
			             	<a href="${pageContext.request.contextPath}/user/logout.html">[注销]</a>
		             	</td>
	             	</tr>
             	</table>
          	</c:otherwise>
          </c:choose>
          </td>
          <td rowspan="3"><jsp:include page="${pageContext.request.contextPath}/goods/splist.html"/></td>
        </tr>
        <tr>
          <td height="50"><%@ include file="spsearch.jsp" %></td>
        </tr>
        <tr>
          <td valign="top"><jsp:include page="${pageContext.request.contextPath}/spclass.html"/></td>
        </tr>
      </table>
    </center>
  </body>
</html>