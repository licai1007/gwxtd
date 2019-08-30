<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
  <head>
    <title>订单详情</title>
    <script type="text/javascript">
    	function send(){
    		if('${order.ostate}'=='已发货'){
    			alert('已发货');
    			return;
    		}
    		window.location.href = "${pageContext.request.contextPath}/manage/order/update.do?oid=${order.oid}&url=${url}";
    	}
    	function del(){
    		if(confirm("您确定删除定单吗?")){
    			window.location.href = "${pageContext.request.contextPath}/manage/order/delete.do?oid=${order.oid}&url=${url}";
    		}
    	}
    </script>
  </head>
  <body>
    <table width="100%" cellpadding="0" cellspacing="0">
      <tr>
        <td><%@ include file="admintop.jsp" %></td>
      </tr>
      <tr align="center">
        <td>
          <table width="60%">
            <tr>
	          <th>货物名称</th>
	          <th>货物数量</th>
	          <th>货物总价</th>          
            </tr>
        	<c:forEach items="${orderDetails}" var="orderDetail" varStatus="vs">
        		<c:choose>
        			<c:when test="${vs.index%2==0}">
        				<tr align="center" bgcolor="#F5F9FE">
        			</c:when>
        			<c:otherwise>
        				<tr align="center">
        			</c:otherwise>
        		</c:choose>
              		<td>${orderDetail.gname}</td>
              		<td>${orderDetail.ogamount}</td>
              		<td>${orderDetail.ogtotalprice}</td>
            	</tr>
         	</c:forEach>
          </table>
        </td>
      </tr>
      <tr>
        <td><hr/></td>
      </tr>
      <tr align="center">
        <td>
          <table>
            <tr>
              <td>收货人姓名:${order.orecname}</td>
            </tr>
            <tr>
              <td>收货人地址:${order.orecadr}</td>
            </tr>
            <tr>
              <td>收货人电话:${order.orectel}</td>
            </tr>
            <tr>
              <td>订购日期:<fmt:formatDate value="${order.odate}" pattern="yyyy-MM-dd HH:mm"/></td>
            </tr>
            <tr>
              <td>订单发送状态:${order.ostate}</td>
            </tr>
          </table>
        </td>
      </tr>
      <tr>
        <td><hr/></td>
      </tr>
      <tr align="center">
        <td>
          <a href="javascript:void(0)" onClick="send()">订单发送</a>
          <a href="javascript:void(0)" onClick="del()">订单删除</a>
          <a href="javascript:history.back()">返回</a>
        </td>
      </tr>
    </table>
  </body>
</html>