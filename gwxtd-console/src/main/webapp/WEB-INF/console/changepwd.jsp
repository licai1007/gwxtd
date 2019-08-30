<%@ page contentType="text/html;charset=utf-8" %>
<html>
  <head>
    <title>修改密码</title>
    <script language="javascript">
      function pwdCheck()
      {
      	var oldpwd = document.pwdform.oldpwd.value;
      	var firpwd = document.pwdform.newpwd.value;
      	var secpwd = document.pwdform.secpwd.value;
      	if(oldpwd==""||oldpwd.length<6)
      	{
      		alert("旧密码输入不合法,长度不得小于6!!!");
      		return;
      	}
      	if(firpwd==""||firpwd.length<6)
      	{
      		alert("新密码输入不合法,长度不得小于6!!!");
      		return;
      	}
      	if(secpwd==""||secpwd.length<6)
      	{
      		alert("第二次新密码输入不合法,长度不得小于6!!!");
      		return;
      	}
      	if(firpwd!=secpwd)
      	{
      		alert("新密码两次输入不相同!!!");
      		return;
      	}
      	document.pwdform.submit();
      }
    </script>
  </head>
  <body>
    <table width="100%" hight="100%" cellpadding="0" cellspacing="0">
      <tr>
        <td><%@ include file="admintop.jsp" %></td>
      </tr>
      <tr align="center">
        <td>
          <form name="pwdform" action="${pageContext.request.contextPath}/manage/admin/changepwd.do" method="post">
            <table>
              <tr>
                <td align="right"><br/><br/><br/>用户名:</td>
                <td><br/><br/><br/>${name}</td>
              </tr>
              <tr>
                <td align="right"><br/>旧密码:</td>
                <td><br/><input type="password" name="oldpwd"/></td>
              </tr>
              <tr>
                <td align="right"><br/>新密码:</td>
                <td><br/><input type="password" name="newpwd"/></td>
              </tr>
              <tr>
                <td align="right"><br/>新密码确认:</td>
                <td><br/><input type="password" name="secpwd"/></td>
              </tr>
              <tr>
                <td align="center" colspan="2">
                  <br/>
                  <input type="button" value="提交" onclick="pwdCheck()"/>
                  <input type="reset" value="重置"/>
                </td>
              </tr>
            </table>
          </form>
        </td>
      </tr>
    </table>
  </body>
</html> 