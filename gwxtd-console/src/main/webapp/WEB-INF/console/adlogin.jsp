<%@ page contentType="text/html;charset=utf-8"%>
<html>
  <head>
    <title>管理员登录</title>
    <link href="${pageContext.request.contextPath}/res/css/generalstyle.css" type="text/css" rel="stylesheet">
    <script language="javascript" src="${pageContext.request.contextPath}/res/script/trim.js"></script>
    <script language="javascript">
      function check()
      {
          var aname = document.adform.aname.value.trim();
          var apwd = document.adform.apwd.value;
          if(aname=="")
          {
          	alert("用户名不能为空!!!");
          	return;
          }
          if(apwd=="")
          {
            alert("密码不能为空!!!");
            return;
          }
          document.adform.submit();
      }
      function tip(){
    	  if('${message}'!=''){
    		  alert('${message}');
    	  }
      }
    </script>
  </head>
  <body onload="tip();">
    <table width="100%">
      <tr>
        <td>
        	<table width="100%" height="100" bgcolor="#F5F9FE">
			  <tr height="70">
			    <td align="center">
			    	<img src="${pageContext.request.contextPath}/res/img/other/logo.gif" width="50" height="50"/>
			    	购物新天地
			    </td>
			  </tr>
			  <tr height="15">
			    <td>
			    	<hr color="#FF7F00" width="100%"/>
			    </td>
			  </tr>
			</table>
        </td>
      </tr>
      <tr align="center">
        <td>
        	<br/>
        	<h2>管理员登录</h2>
        </td>
      </tr>
      <tr>
      	<td>
      	  <center>
      		<form action="${pageContext.request.contextPath}/login.do" method="post" name="adform">
	     		<table>
			      <tr>
			        <td align="right">用户名:</td>
			        <td><input type="text" name="aname"/></td>
			      </tr>
			      <tr>
			        <td align="right">密&nbsp;&nbsp;&nbsp;码:</td>
			        <td><input type="password" name="apwd"/></td>
			      </tr>
			      <tr align="center">
			        <td colspan="2">
			          <br/>
			          <input type="button" value="登录" onclick="check()"/>
			          <input type="reset" name="重置"/>
			        </td>
			      </tr>
	     		</table>
      		</form>
      	  </center>
      	</td>
      </tr>
    </table>
  </body>
</html>