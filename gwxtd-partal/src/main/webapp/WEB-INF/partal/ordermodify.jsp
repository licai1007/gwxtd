<%@ page contentType="text/html;charset=gb2312" %>
<%-- <% 
	if(session.getAttribute("admin")==null)
	{
		response.sendRedirect("adlogin.jsp");
	}
	else
	{
		Vector<String[]> vordergoods = 
					(Vector<String[]>)request.getAttribute("vordergoods");
		Vector<String[]> vorderinfo = 
					(Vector<String[]>)request.getAttribute("vorderinfo");
		String[] str = vorderinfo.get(0);
%> --%>
<html>
  <head>
    <title>订单详情</title>
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
	          <th>货物名称</td>
	          <th>货物数量</td>
	          <th>货物总价</td>          
            </tr>
          <%-- <% 
          	  int i=0;
          	  for(String[] temp:vordergoods)
          	  {
          	  	  i++;
			   	  if(i%2==0)
				  {
			   		 out.println("<tr align='center'>");
				  }
				  else
				 {
					 out.println("<tr align='center' bgcolor='#F5F9FE'>");
				 }
           %> --%>
              <td><%= %></td>
              <td><%= %></td>
              <td><%=%></td>
            </tr>
         <%--   <% 
           	   }
            %> --%>
          </table>
        </td>
      </tr>
      <tr>
        <td><hr/></hr></td>
      </tr>
      <tr align="center">
        <td>
          <table>
            <tr>
              <td>收货人姓名:<%= %></td>
            </tr>
            <tr>
              <td>收货人地址:<%= %></td>
            </tr>
            <tr>
              <td>收货人电话:<%= %></td>
            </tr>
            <tr>
              <td>订购日期:<%= %></td>
            </tr>
            <tr>
              <td>订单发送状态:<%= %></td>
            </tr>
          </table>
        </td>
      </tr>
      <tr>
        <td><hr/></hr></td>
      </tr>
      <tr align="center">
        <td>
          <a href="AdminServlet?action=orderEnsure&oid=<%=%>">订单发送</a>
          <a href="AdminServlet?action=orderDelete&oid=<%=%>">订单删除</a>
          <a href="javascript:history.back()">返回</a>
        </td>
      </tr>
    </table>
  </body>
</html>
<%-- <% 
	}
%> --%>