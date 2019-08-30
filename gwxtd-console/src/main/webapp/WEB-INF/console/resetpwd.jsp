<%@ page contentType="text/html;charset=utf-8" %>
<html>
  <head>
    <title>密码重置</title>
    <script language="javascript" src="${pageContext.request.contextPath}/res/script/trim.js"></script>
    <script language="javascript">
      function check()
      {
      	var aname = document.resetform.aname.value.trim();
      	var apwd = document.resetform.apwd.value;
      	var secpwd = document.resetform.secpwd.value;
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
      	document.resetform.submit();
      }
    </script>
</head>
<body>
  <form action="${pageContext.request.contextPath}/manage/admin/pwdreset.do" method="post" name="resetform" target="_top">
    <table width="50%">
	    <tr>
	      <td align="right">用户名:</td>
	      <td><input type="text" name="aname"/></td>
	    </tr>
        <tr>
          <td align="right"><br/>新密码:</td>
          <td><br/><input type="password" name="apwd"/></td>
        </tr>
        <tr>
          <td align="right"><br/>新密码确认:</td>
          <td><br/><input type="password" name="secpwd"/></td>
        </tr>
        <tr align="center">
          <td colspan="2">
            <br/>
            <input type="button" value="提交" onclick="check()"/>
            <input type="reset" value="重置"/>
          </td>
        </tr>
    </table>
  </form>
</body>
</html>