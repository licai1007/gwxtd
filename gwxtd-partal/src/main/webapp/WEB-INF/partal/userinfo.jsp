<%@ page contentType="text/html;charset=utf-8"%>
<html>
  <head>
    <title>用户信息修改</title>
    <script language="javascript" src="script/trim.js"></script>
    <script language="javascript">
      function check()
      {
       	var fpwd = document.mfmodify.upwd.value;
       	var email = document.mfmodify.uemail.value.trim();
       	var reg = new RegExp('^([a-zA-Z0-9]+)@([a-zA-Z0-9]+)\.([a-z]{2,})$');
       	if(fpwd=="")
       	{
       		alert("密码不能为空!!!");
       		return;
       	}
       	else if(!fpwd.match("^[a-zA-Z0-9]{6,20}$"))
       	{
       		alert("密码必须由大小写英文字母、数字组成，长度6－20位!!!");
       		return;
       	}else if(email=="")
       	{//当该项为空时
       		alert("Email地址不能为空!!!");
       		return;
       	}else if(!reg.test(email)){
       		alert("Email地址必须合乎规范!!!");
       		return;
       	}
      	document.mfmodify.submit();
      }
    </script>
  </head>
  <body>
     <table width="100%">
		  <tr>
		    <td><%@ include file="top.jsp" %></td>
		  </tr>
		  <tr align="center">
		    <td>
		      <table>
		        <form action="${pageContext.request.contextPath}/user/modify.html" method="post" name="mfmodify">
		          <tr align="center">
		            <td><br/><br/>用户名:</td>
		            <td align="left"><br/><br/>${ur.uname}</td>
		          </tr>
		          <tr>
		            <td><br/><br/>密&nbsp;&nbsp;&nbsp;码:</td>
		            <td><br/><br/><input type="text" name="upwd" value="${ur.upwd}"/></td>
		          </tr>
		          <tr>
		            <td><br/><br/>E-mail:</td>
		            <td><br/><br/><input type="text" name="uemail" value="${ur.uemail}"/></td>
		          </tr>
		          <tr>
		            <td align="right">
		              <br/><br/><input type="button" value="修改" onclick="check()"/>
		            </td>
		            <td align="right"><br/><br/>
		              <a href="javascript:history.back()">单击这里返回</a>
		            </td>
		          </tr>
		        </form>
		      </table>
		    </td>
		  </tr>
	</table>
  </body>
</html>