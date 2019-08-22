<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
  <head>
    <title>我的商城</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/script/trim.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/script/jquery-1.8.2.min.js"></script>
    <script type="text/javascript">
	    function deleteItem(gid){
			if(confirm("您确定删除吗？")){
				window.location.href = "${pageContext.request.contextPath}/cart/delete.html?gid="+gid;
			}
		}
		function enterNumber(gid,index){
			var number = prompt("请输入商品数量：","");
			if(number!=null&&number.trim()!=''){
				var reg = /^[1-9][0-9]*$/;
				if(!reg.test(number.trim())){
					alert('商品数量只能为数字且不能为0!!!');
				}else{
					$(function(){
						$.ajax({
							url:"${pageContext.request.contextPath}/cart/updateNum.html",
							data:{"gid":gid,"num":number},
							type:"post",
							dataType:"json",
							success:function(result){
								if(result.stocknum!=''){
									alert("对不起，库存量只有："+result.stocknum);
								}else{
									document.getElementById("gnum"+index).value = number;
									total();
								}
							}
						});
			    	});
				}
			}
		}
		function total(){
			var totalPrice = 0;
			for(var i=0;i<'${fn:length(cartList)}';i++){
				var price = document.getElementById('gprice'+i).innerText;
				var num = document.getElementById('gnum'+i).value;
				totalPrice += price*num;
			}
			document.getElementById('totalPrice').innerText = totalPrice;
		}
    </script>
  </head>
  <body onload="total();">
    <table width="100%">
      <tr>
        <td><%@ include file="top.jsp" %></td>
      </tr>
      <tr>
        <td>
        	<c:choose>
        		<c:when test="${!empty cartList}">
        			<table border="0" width="100%" cellpadding="2px" cellspacing="0px">
			         <tr>
			        	<th>商品名称</th>
			        	<th>商品价格</th>
			        	<th>商品数量</th>
			        	<th>删除</th>
			      	 </tr>
			      	 <c:forEach items="${cartList}" var="item" varStatus="vs">
			      	 	<c:choose>
			      	 		<c:when test="${vs.index%2==0}">
			      	 			<tr bgcolor="#F5F9FE">
			      	 		</c:when>
			      	 		<c:otherwise>
			      	 			<tr>
			      	 		</c:otherwise>
			      	 	</c:choose>
			      			<td align="left">${item.gname}</td>
			      			<td align="center">￥
			      				<span id="gprice${vs.index}">${item.gprice}</span>
			      			</td>
			      			<td align="center">
							    <input type="text" id="gnum${vs.index}" name="gnum" 
							    value="${item.buynum}" size="1" readonly="readonly"/>
							    <input type="button" onClick="enterNumber('${item.gid}','${vs.index}');" value="修改"/>
						  	</td>
			      			<td align="center">
			      				<a href="javascript:void(0)" onClick="deleteItem('${item.gid}');">删除</a>
			      			</td>
			      		</tr>
			      	 </c:forEach>
	      			</table>
	      			<div style="margin-top:15px;margin-left:1250px;">
	      				<a href="${pageContext.request.contextPath}/cart/clearCart.html">清空购物车</a>
	      			</div>
	      			<div style="margin-top:20px;margin-left:1000px;">
	      				<span>商品价格总计:￥<strong id="totalPrice">0.00</strong>元</span>
	      				<br/><br/>
			       		<a href="${pageContext.request.contextPath}/order/receiverinfo.html">
			         		<img src="${pageContext.request.contextPath}/res/img/other/balance.gif" border="0"/>
			       		</a>
	      			</div>
        		</c:when>
        		<c:otherwise>
        			<table border="0" width="100%">
        				<tr>
        					<td align="center">
        						<br/><br/><br/>
        						<strong>您还没有购买商品</strong>
        					</td>
        				</tr>
        			</table>
        		</c:otherwise>
        	</c:choose>
        </td>
      </tr>
    </table>
  </body>
</html>