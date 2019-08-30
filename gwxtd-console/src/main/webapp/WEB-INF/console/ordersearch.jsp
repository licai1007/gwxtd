<%@ page contentType="text/html;charset=utf-8" %>
<script language="javascript" src="${pageContext.request.contextPath}/res/script/trim.js"></script>
<script language="javascript">
  function txtclear()
  {
    document.mfsearch.oid.value="";
  }
  function txtset(){
	if(document.mfsearch.oid.value.trim()==''){
		document.mfsearch.oid.value='请输入要查询的定单号';
	}
  }
  function check()
  {
    var key = document.mfsearch.oid.value;
    if(key=="请输入要查询的定单号")
    {
      alert("关键字不能为空!!!");
      return;
    }
    var reg = /^\d+$/;
    if(!reg.test(key))
    {
      alert("定单号只能为整数!!!");
      return;
    }
    document.mfsearch.submit();
  }
</script>
<form name="mfsearch" action="${pageContext.request.contextPath}/manage/order/index.do" method="post">
<table>
  <tr>
    <td>
      <input type="text" name="oid" value="请输入要查询的定单号" onfocus="txtclear()" onblur="txtset();"/>
    </td>
  </tr>
  <tr>
    <td align="right">
      <input type="button" value="搜索" onclick="check()"/>
    </td>
  </tr>
</table>
</form>