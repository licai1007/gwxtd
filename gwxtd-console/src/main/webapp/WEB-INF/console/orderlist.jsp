<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/script/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#changePage').change(function(){
			window.location.href="${pageContext.request.contextPath}/manage/order/index.do?pageNumber="+$(this).val()+"&ostate=${ostate}";
		});
	});
	function lookAndManage(oid){
		window.location.href = "${pageContext.request.contextPath}/manage/order/handle.do?oid="+oid+"&url="+encodeURIComponent(window.location.href);
	}
</script>
<table width="100%" border="0">
  <c:choose>
  	<c:when test="${!empty pageInfo.list}">
  		<tr>
    		<th width="20%">订单号</th>
    		<th width="20%">订购人</th>
    		<th width="20%">定购日期</th>
    		<th width="20%">订购状态</th>
    		<th width="20%">订单详细信息</th>
  		</tr>
  		<c:forEach items="${pageInfo.list}" var="order" varStatus="vs">
  			<c:choose>
  				<c:when test="${vs.index%2==0}">
  					<tr align='center' bgcolor='#F5F9FE'>
  				</c:when>
  				<c:otherwise>
  					<tr align='center'>
  				</c:otherwise>
  			</c:choose>
   				<td>${order.oid}</td>
   				<td>${order.uname}</td>
   				<td><fmt:formatDate value="${order.odate}" pattern="yyyy-MM-dd HH:mm"/></td>
   				<td>${order.ostate}</td>
   				<td><a href="javascript:void(0)" onClick="lookAndManage('${order.oid}');">查看/管理</a></td>
   	 		</tr>
   	 	</c:forEach>
   	 	<tr>
     		<td colspan="5"><hr/></td>
   		</tr>
   		<tr>
   	  		<td align="right">
      			<c:if test="${pageInfo.pageNo>1}">
      				<a href="${pageContext.request.contextPath}/manage/order/index.do?pageNumber=${pageInfo.pageNo-1}&ostate=${ostate}">&lt;&lt;上一页</a>
      			</c:if>
      		</td>
      		<td colspan="3" align="center">
     			<select id="changePage" name="selPage">
  	      			<c:forEach begin="1" end="${pageInfo.totalPage}" varStatus="vs">
  	    				<option value="${vs.index}" <c:if test="${pageInfo.pageNo==vs.index}">selected="selected"</c:if>>第${vs.index}页</option>
  	      			</c:forEach>
    			</select>
      		</td>
      		<td align="left">
      			<c:if test="${pageInfo.pageNo<pageInfo.totalPage}">
      	 			<a href="${pageContext.request.contextPath}/manage/order/index.do?pageNumber=${pageInfo.pageNo+1}&ostate=${ostate}">下一页&gt;&gt;</a>
      			</c:if>
      		</td>
   		</tr>
  	</c:when>
  	<c:otherwise>
  		<tr align='center'>
  			<td>
  				<font color="red">对不起，没有搜到你要查询的订单!!!</font>
  			</td>
  		</tr>
  	</c:otherwise>
  </c:choose>
</table>