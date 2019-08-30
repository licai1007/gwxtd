<%@ page contentType="text/html;charset=utf-8" %>
<html>
  <head>
    <title>管理员添加</title>
    <script language="javascript" src="${pageContext.request.contextPath}/res/script/trim.js"></script>
    <script language="javascript">
      function check()
      {
      	var aname = document.addform.aname.value.trim();
      	var apwd = document.addform.apwd.value;
      	var secpwd = document.addform.secpwd.value;
      	if(aname=="")
      	{
      		alert("用户名不能为空!!!");
      		return;
      	}
      	if(apwd==""||apwd.length<6)
      	{
      		alert("密码不合法,长度不得小于6!!!");
      		return;
      	}
      	if(secpwd!=apwd)
      	{
      		alert("两次密码输入不一致!!!");
      		return;
      	}
      	document.addform.submit();
      }
    </script>
  </head>
<body>
	<form action="${pageContext.request.contextPath}/manage/admin/add.do" method="post" name="addform" target="_top">
  		<table width="50%">
	      <tr>
	        <td align="right">请输入管理员用户名:</td>
	        <td><input type="text" name="aname"/></td>
	      </tr>
	      <tr>
	        <td align="right"><br/>请输入管理员密码:</td>
	        <td><br/><input type="password" name="apwd"/></td>
	      </tr>
	      <tr>
	        <td align="right"><br/>请再次输入管理员密码:</td>
	        <td><br/><input type="password" name="secpwd"/></td>
	      </tr>
	      <tr>
	        <td align="right">
	          <br/><input type="button" value="添加" onclick="check()"/>
	        </td>
	        <td><br/><input type="reset" value="重置"/></td>
	      </tr>
  		</table>
	</form>
</body>
</html>