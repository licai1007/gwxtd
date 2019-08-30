<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
  <title>订单管理</title>
</head>
<body>
  <table width="100%" cellpadding="0" cellspacing="0">
     <tr>
        <td><%@ include file="admintop.jsp" %></td>
     </tr>
     <tr>
        <td>
          <table>
            <tr>
              <td>
              	<br/><br/>
                <table>
                  <tr align="center">
                    <td><a href="${pageContext.request.contextPath}/manage/order/index.do"><br/>查看所有定单</a></td>
                  </tr>
                  <tr align="center">
                    <td><a href="${pageContext.request.contextPath}/manage/order/index.do?ostate=已发货"><br/>查看已发货定单</a></td>
                  </tr>
                  <tr align="center">
                    <td><a href="${pageContext.request.contextPath}/manage/order/index.do?ostate=未发货"><br/>查看未发货定单</a></td>
                  </tr>
                  <tr>
                    <td align="left"><br/>订单号搜索:</td>
                  </tr>
                  <tr>
                    <td><%@ include file="ordersearch.jsp" %></td>
                  </tr>
                </table>
              </td>
              <td width="100%">
              	<br/>
              	<%@ include file="orderlist.jsp" %>
              </td>
            </tr>
          </table>
        </td>
     </tr>
  </table>
</body>
</html>