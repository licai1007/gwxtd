<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>物品详细信息</title>
    <link href="${pageContext.request.contextPath}/res/css/generalstyle.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/res/script/jquery-1.8.2.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$('#buy').click(function(){
				$.ajax({
					url:"${pageContext.request.contextPath}/cart/addToCart.html",
					data:{"gid":'${goods.gid}'},
					type:"post",
					dataType:"json",
					success:function(result){
						if(result.stocknum!=''){
							alert(result.stocknum);
						}
					}
				});
			});
		});
	</script>
  </head>
  <body>
    <table width="100%">
      <tr>
        <td><%@ include file="top.jsp" %></td>
      </tr>
      <tr>
        <td>
          <table width="80%">
          	<tr>
              <td><img src="${pageContext.request.contextPath}/res/${goods.gimgurl}" height="150" border="1"/></td>
              <td>
                <table width="100%">
                  <tr>
                    <td bgcolor="#E4EDFA">${goods.gname}</td>
                  </tr>
                  <tr>
			        <td><font>${goods.gintro}</font></td>
			      </tr>
			      <tr>
			        <td bgcolor="#E4EDFA"><font>所属分类:${goods.gclass}</font></td>
			      </tr>
			      <tr>
			        <td><font>定价:￥${goods.gprice}</font></td>
			      </tr>
			      <tr>
			        <td bgcolor="#E4EDFA"><font>浏览次数:${goods.glook}</font></td>
			      </tr>
			      <tr>
                    <td>
                      <c:choose>
        				<c:when test="${goods.gamount>0}">
	            			<a id="buy" href="#">	
	            				<img src="${pageContext.request.contextPath}/res/img/other/buy.gif" border="0"/>
	            			</a>
          				</c:when>
          				<c:otherwise>
          					<font style="color:red;">缺货</font>
          				</c:otherwise>
        			   </c:choose>
                    </td>
                  </tr>
                </table>
              </td>        	
          	</tr>
          	<tr>
          	  <td><b><br/>商品简述:</b></td>
          	</tr>
          	<tr>
          	  <td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;${goods.gbrief}</td>
          	</tr>
          	<tr>
          		<td colspan="2" align="right">
          			<br/>
          			<a href="javascript:history.back();">返回</a>
          			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          		</td>
          	</tr>
          </table>
        </td>
      </tr>
    </table>
  </body>
</html>