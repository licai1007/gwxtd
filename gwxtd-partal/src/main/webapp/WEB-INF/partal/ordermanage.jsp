<%@ page contentType="text/html;charset=gb2312" %>
<% 
	if(session.getAttribute("admin")==null)
	{
		response.sendRedirect("adlogin.jsp");
	}
	else
	{
 %>
<html>
  <head>
    <title>��������</title>
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
                <table>
                  <tr align="center">
                    <td><a href="AdminServlet?action=orderSearch&type=all">�鿴���ж���</a></td>
                  </tr>
                  <tr align="center">
                    <td><a href="AdminServlet?action=orderSearch&type=yes"><br/>�鿴�ѷ�������</a></td>
                  </tr>
                  <tr align="center">
                    <td><a href="AdminServlet?action=orderSearch&type=no"><br/>�鿴δ��������</a></td>
                  </tr>
                  <tr>
                    <td align="left"><br/>����������:</td>
                  </tr>
                  <tr>
                    <td><%@ include file="ordersearch.jsp" %></td>
                  </tr>
                </table>
              </td>
              <td align="center" width="100%"></td>
            </tr>
          </table>
        </td>
      </tr>
    </table>
  </body>
</html>
<% 
	}
 %>