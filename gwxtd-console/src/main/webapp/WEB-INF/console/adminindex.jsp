<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>主页界面</title>
  </head>
  <body>
    <table width="100%">
      <tr>
        <td><%@ include file="admintop.jsp" %></td>
      </tr>
      <tr>
        <td>
		 <table>
		  <tr>
		    <td>
		      <table>
				<tr>
				  <td>
				  	<br/><br/>
				  	<%@ include file="adminsearch.jsp" %>
				  </td>
				</tr>
				<tr align="center">
				  <td>
				  	<br/>
				    <a href="${pageContext.request.contextPath}/manage/goods/add.do">商品添加</a>
				  </td>
				</tr>
				<tr align="center">
				  <td><br/>商品类别</td>
				</tr>
				<tr>
				  <td>
				  	<center>
				  	  <table>
						<c:forEach items="${classs}" var="clazz">
						    <tr>
						      <td align="center">
						        <a href="${pageContext.request.contextPath}/manage/goods/list.do?gclass=${clazz}">${clazz}</a>
						      </td>
						    </tr>
						</c:forEach>
					  </table>
					</center>
				  </td>
				</tr>
		      </table>
		    </td>
		    <td width="100%"><jsp:include page="/manage/goods/list.do"></jsp:include></td>
		  </tr>
		 </table>
        </td>
      </tr>
    </table>
  </body>
</html>