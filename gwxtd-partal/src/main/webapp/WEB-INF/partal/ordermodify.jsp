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
    <title>��������</title>
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
	          <th>��������</td>
	          <th>��������</td>
	          <th>�����ܼ�</td>          
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
              <td>�ջ�������:<%= %></td>
            </tr>
            <tr>
              <td>�ջ��˵�ַ:<%= %></td>
            </tr>
            <tr>
              <td>�ջ��˵绰:<%= %></td>
            </tr>
            <tr>
              <td>��������:<%= %></td>
            </tr>
            <tr>
              <td>��������״̬:<%= %></td>
            </tr>
          </table>
        </td>
      </tr>
      <tr>
        <td><hr/></hr></td>
      </tr>
      <tr align="center">
        <td>
          <a href="AdminServlet?action=orderEnsure&oid=<%=%>">��������</a>
          <a href="AdminServlet?action=orderDelete&oid=<%=%>">����ɾ��</a>
          <a href="javascript:history.back()">����</a>
        </td>
      </tr>
    </table>
  </body>
</html>
<%-- <% 
	}
%> --%>