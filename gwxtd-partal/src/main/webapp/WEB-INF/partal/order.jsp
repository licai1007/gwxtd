<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>订单确认</title>
  </head>
  <body>
      <table width="100%">
        <tr>
          <td><%@ include file="top.jsp" %></td>
        </tr>
        <tr>
          <td>
            <center>
            <table width="80%">
              <tr>
 	        	<th>商品名称</th>
	        	<th>商品价格</th>
	        	<th>商品数量</th>
              </tr>
              <c:forEach items="${cartList}" var="item" varStatus="vs">
              	<c:choose>
	      	 		<c:when test="${vs.index%2==0}">
	      	 			<tr align='center' bgcolor="#F5F9FE">
	      	 		</c:when>
	      	 		<c:otherwise>
	      	 			<tr align='center'>
	      	 		</c:otherwise>
			      </c:choose>
				  <td>${item.gname}</td>
				  <td>￥${item.gprice}</td>
				  <td>${item.buynum}</td>
				</tr>
              </c:forEach>
			  <tr>
			    <td colspan="3" align="right">
			    	<b>商品价格总计:￥
			    		<span style="color:blue;">${totalPrice}</span>
			    	元</b>
			    </td>
			  </tr>
			  <tr>
			  	<td colspan="3" align="center">
			  		<br/><br/><br/>
			  		<input type="button" value="提交订单" 
			  		onClick="window.location.href='${pageContext.request.contextPath}/order/commitorder.html';"/>
			  	</td>
			  </tr>
            </table>
            </center>
          </td>
        </tr>
      </table>
  </body>
</html>