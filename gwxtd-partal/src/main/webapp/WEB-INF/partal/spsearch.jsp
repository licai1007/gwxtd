<%@ page contentType="text/html;charset=utf-8" %>
<script language="javascript" src="script/trim.js"></script>
<script language="javascript">
  function txtclear()
  {
    document.mfsearch.tsearch.value="";
  }
  function txtset(){
	if(document.mfsearch.tsearch.value.trim()==''){
		document.mfsearch.tsearch.value='请输入要搜索的关键字';
	}
  }
  function tijiao()
  {
    var key = document.mfsearch.tsearch.value;
    if(key.trim()=='请输入要搜索的关键字')
    {
      alert("关键字不能为空");
      return;
    }
    document.mfsearch.submit();
  }
</script>


<center>
<form name="mfsearch" method="get" action="${pageContext.request.contextPath}/goods/splist.html">
 	<table border="0" bgcolor="#FFE8D0" width="80%">
	  <tr>
	    <td>
	      <input type="text" id="tsearch" name="tsearch" value="请输入要搜索的关键字" onfocus="txtclear()" onblur="txtset();"/>
	    </td>
	  </tr>
	  <tr>
	  	<td align="right">
	  	    <input type="button" id="bsearch" name="bsearch" value="搜索" onclick="tijiao()"/>
	  	</td>
	  </tr>
	</table>
</form>
</center>