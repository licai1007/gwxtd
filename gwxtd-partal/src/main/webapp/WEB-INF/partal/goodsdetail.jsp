<%@ page contentType="text/html;charset=utf-8"%>
<html>
  <head>
    <title>物品详细信息</title>
    <link href="${pageContext.request.contextPath}/res/css/generalstyle.css" type="text/css" rel="stylesheet">
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
                      <a href="#">
                        <img src="${pageContext.request.contextPath}/res/img/other/buy.gif" border="0"/>
                      </a>
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
          </center>
        </td>
      </tr>
    </table>
  </body>
</html>