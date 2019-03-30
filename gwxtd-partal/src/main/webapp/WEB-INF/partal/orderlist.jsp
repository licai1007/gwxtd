<%@ page contentType="text/html;charset=gb2312"%>
<table width="100%" border="0">
  <tr>
    <th>订单号</th>
    <th>订购人</th>
    <th>定购日期</th>
    <th>订购状态</th>
    <th>订单详细信息</th>
  </tr>
 <%--  <% 
  	Vector<String[]> vorder = (Vector<String[]>)request.getAttribute("vorder");
  	if(vorder==null)
  	{
  		String sql = "select Oid,Uname,Odate,Ostate from OrderInfo,UserInfo"+
  				" where Ostate='未发货' and OrderInfo.Uid=UserInfo.Uid order by Oid";
  		String sqlpage = "select count(*) from OrderInfo where Ostate='未发货'";
  		sqlpage = new String(sqlpage.getBytes(),"ISO-8859-1");
  		sql = new String(sql.getBytes(),"ISO-8859-1");
  		//记住当前总页数
  	}
	for(int i=0;i<vorder.size();i++)
	{
		String[] str = vorder.get(i);
		if(i%2==0)
		{
			out.println("<tr align='center'>");
		}
		else
		{
			out.println("<tr align='center' bgcolor='#F5F9FE'>");
		}
   %> --%>
   		<td><%=  %></td>
   		<td><%=  %></td>
   		<td><%=  %></td>
   		<td><%=  %></td>
   		<td><a href="AdminServlet?action=ordermanage&oid=<%= %>">查看/管理</a></td>
   	 </tr>
  <%--  <% 
   	}
   %> --%>
   <tr>
     <td colspan="5"><hr/></hr></td>
   </tr>
   <tr>
  
     <td align="right">
     <%-- <% 
     	if(curPage>1)
     	{
     %> --%>
     	
    <%--  <%
     	}
     %> --%>
     </td>
     <form action="AdminServlet" method="post">
       <td colspan="3" align="center">
      	  </select>
       </td>
       <input type="hidden" name="action" value="orderPageChange"/>
     </form>
     <td align="left">
     <%-- <% 
     	if(curPage<totalPage)
     	{
      %> --%>
      	<a href="AdminServlet?action=orderPageChange&curPage=<%= %>">下一页>></a>
      <%-- <% 
      	}
      %> --%>
     </td>
   </tr>
</table>