<%@ page contentType="text/html;charset=gb2312"%>
<table width="100%" border="0">
  <tr>
    <th>������</th>
    <th>������</th>
    <th>��������</th>
    <th>����״̬</th>
    <th>������ϸ��Ϣ</th>
  </tr>
 <%--  <% 
  	Vector<String[]> vorder = (Vector<String[]>)request.getAttribute("vorder");
  	if(vorder==null)
  	{
  		String sql = "select Oid,Uname,Odate,Ostate from OrderInfo,UserInfo"+
  				" where Ostate='δ����' and OrderInfo.Uid=UserInfo.Uid order by Oid";
  		String sqlpage = "select count(*) from OrderInfo where Ostate='δ����'";
  		sqlpage = new String(sqlpage.getBytes(),"ISO-8859-1");
  		sql = new String(sql.getBytes(),"ISO-8859-1");
  		//��ס��ǰ��ҳ��
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
   		<td><a href="AdminServlet?action=ordermanage&oid=<%= %>">�鿴/����</a></td>
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
      	<a href="AdminServlet?action=orderPageChange&curPage=<%= %>">��һҳ>></a>
      <%-- <% 
      	}
      %> --%>
     </td>
   </tr>
</table>