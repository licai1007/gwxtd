<%@ page contentType="text/html;charset=gb2312"%>
<table border="0" width="100%">
<%-- <% 
	Vector<String[]> vgoods = (Vector<String[]>)request.getAttribute("vgoods");
	if(vgoods==null)
	{
        			"Gprice,Glook,Gid,Gdate from GoodsInfo";
	}
	for(int i=0;i<vgoods.size();i++)
	{
		String[] str = vgoods.get(i);
 %> --%>
  <tr>
    <td width="150" align="center">
        <img src="<%= %>" height="150" border="1"/>
    </td>
    <td colspan="2">
      <table width="100%">
        <tr>
          <td bgcolor="#E4EDFA"><%= %></td>
        </tr>
        <tr>
          <td><font></font></td>
        </tr>
        <tr>
          <td bgcolor="#E4EDFA"><font>所属分类:<%= %></font></td>
        </tr>
        <tr>
          <td><font>定价:￥<%= %></font></td>
        </tr>
        <tr>
          <td bgcolor="#E4EDFA"><font>浏览次数:<%= %></font></td>
        </tr>
        <tr>
          <td><font>上架日期:<%= %></font></td>
        </tr>
        <tr>
          <td bgcolor="#E4EDFA">
            <a href="AdminServlet?action=goodsManage&gid=<%= %>">修改/删除商品</a>
          </td>
        </tr>
      </table>
    </td>
  </tr>
<%--   <% 
  	}
   %> --%>
   <tr>
     <td colspan="3"><hr/></hr></td>
   </tr>
   <tr align="center">

      <td>
     <%--  <% 
      	if(curPage>1)
      	{
      %> --%>
     <%--  <%
      	}
      %> --%>
      </td>
      <form action="AdminServlet" method="post">
      <td align="right" width="200">
      	  <select onchange="this.form.submit()" name="selPage">
      	   <%-- <% 
      	   		for(int i=1;i<=totalPage;i++)
      	   		{
      	   			String flag = "";
      	   			if(i==curPage)
      	   			{
      	   				flag = "selected";
      	   			}
      	    %> --%>
      	    	<option value="<%=%>" <%=  %>>第<%=  %>页</option>
      	   <%--  <% 
      	    	}
      	     %> --%>
      	  </select>
      	</td>
      	</form>
      <td align="left" width="40%">
      <%-- 	<% 
      		if(curPage<totalPage)
      		{
      	 %> --%>
      	 	<a href="AdminServlet?action=pageChange&curPage=<%=%>">下一页>></a>
      	 <%-- <% 
      	 	}
      	  %> --%>
      </td>
    </tr>
</table>