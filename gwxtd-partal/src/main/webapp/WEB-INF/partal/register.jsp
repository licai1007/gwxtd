<%@ page contentType="text/html;charset=utf-8" %>
<html>
  <head>
    <title>注册</title>
    <script language="javascript" src="script/trim.js"></script>
    <script language="javascript">
    var ok1 = false;
    var ok2 = false;
    var ok3 = false;
    var ok4 = false;
      function checkUid()
      {
      	var uname = document.regform.uname.value;
      	if(uname.trim()=="")
      	{
      		document.all.uinfo.innerHTML =
      				"<font color='red' size='2px'>此项为必填项，请设置你的用户名。</font>";
      		ok1 = false;
      	}
      	else
      	{
			document.all.uinfo.innerHTML =
					"<font size='2px'>用户名可以由小写英文字母、中文、数字组成。</font>";
      		ok1 = true;
      	}
      }
      
      function checkFirPwd()
      {
      	var fpwd = document.regform.fpwd.value;
      	if(fpwd=="")
      	{
      		document.all.pfinfo.innerHTML = 
      				"<font color='red' size='2px'>此项为必填项，请设置你的密码。</font>";
      		ok2 = false;
      	}
      	else if(fpwd.length<6||fpwd.length>20||!fpwd.match("^[a-zA-Z0-9]+$"))
      	{
      		document.all.pfinfo.innerHTML = 
      				"<font color='red' size='2px'>您设置的密码有误，请重新设置你的密码。</font>";
      		ok2 = false;
      	}
      	else
      	{
     		document.all.pfinfo.innerHTML = 
      				"<font size='2px'>您的密码可以由大小写英文字母、数字组成，长度6－20位。</font>"; 
      		ok2 = true;
      	}
      }
      
      function checkSecPwd()
      {
      	var fpwd = document.regform.fpwd.value;
      	var spwd = document.regform.upwd.value;
      	if(spwd=="")
      	{
       		document.all.psinfo.innerHTML = 
      				"<font color='red' size='2px'>此项为必填项，请再次输入您的密码。</font>"; 
      		ok3 = false;
      	}
      	else if(fpwd!=spwd)
      	{
      		document.all.psinfo.innerHTML = 
     				"<font color='red' size='2px'>两次密码输入的不一致，请重新输入。</font>";
     		ok3 = false;
      	}
      	else
      	{
      		document.all.psinfo.innerHTML = "";
      		ok3 = true;
      	}
      }
      
      function checkEmail()
      {
      	var email = document.regform.uemail.value.trim();
      	var reg = new RegExp('^([a-zA-Z0-9]+)@([a-zA-Z0-9]+)\.([a-z]{2,})$');
      	if(email=="")
      	{//当该项为空时
      		document.all.einfo.innerHTML = 
      				"<font color='red' size='2px'>此项为必填项，请输入您的Email地址。</font>";
      		ok4 = false;
      	}else if(!reg.test(email)){
      		document.all.einfo.innerHTML = 
  				"<font color='red' size='2px'>请输入正确的Email地址。</font>";
      		ok4 = false;
      	}else{
      		document.all.einfo.innerHTML = 
      				"<font size='2'>请填写有效的E-mail地址。</font>";
      		ok4 = true;
      	}
      }
      
      function mfSub()
      {
      	if(ok1&&ok2&&ok3&&ok4){
      		document.regform.submit();
      	}
      }
    </script>
  </head>
  <body>
    <center>
      <table border="0" width="100%">
		  <tr height="70">
		    <td align="center"><img src="${pageContext.request.contextPath}/res/img/other/logo.gif" width="50" height="50"/>购物新天地</td>
		  </tr>
		  <tr height="15">
		    <td><hr color="#FF7F00" width="100%"/></hr></td>
		  </tr>
		  <tr align="center">
		    <td>
		      <table border="0">
		      <form action="${pageContext.request.contextPath}/user/register.html" method="post" name="regform">
		        <tr height="50">
		          <td>请填写你的用户名:</td>
		          <td><input type="text" name="uname" size="20" onblur="checkUid()"/></td>
		          <td id="uinfo">
		            <font size="2px">用户名可以由小写英文字母、中文、数字组成。</font>
		          </td>
		        </tr>
		        <tr height="50">
		          <td>设置你的密码:</td>
		          <td><input type="password" name="fpwd" size="20" onblur="checkFirPwd()"/></td>
		          <td id="pfinfo">
		            <font size="2px">您的密码可以由大小写英文字母、数字组成，长度6－20位。</font>
		          </td>
		        </tr>
		        <tr height="50">
		          <td>请再次输入你的密码:</td>
		          <td><input type="password" name="upwd" size="20" onblur="checkSecPwd()"/></td>
		          <td id="psinfo"></td>
		        </tr>
		        <tr height="50">
		          <td>请填写你的E-mail地址:</td>
		          <td><input type="text" name="uemail" size="20" onblur="checkEmail()"/></td>
		          <td id="einfo">
		            <font size="2">请填写有效的E-mail地址。</font>
		          </td>
		        </tr>
		        <tr align="center">
		          <td colspan="3">注:以上各项为必填项,请认真填写。</td>
		        </tr>
		        <tr align="center">
		          <td colspan="2" align="right">
		            <input type="button" name="sub" value="注册" onclick="mfSub()"/>
		            <input type="reset" value="重置"/>
		          </td>
		          <td><a href="javascript:history.back()">单击这里返回</a></td>
		        </tr>
		        </form>
		      </table>
		    </td>
		  </tr>
      </table>
    </center>
  </body>
</html>