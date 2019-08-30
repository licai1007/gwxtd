<%@ page contentType="text/html;charset=utf-8" %>
<link href="${pageContext.request.contextPath}/res/css/generalstyle.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/res/script/trim.js"></script>
<script type="text/javascript">
	function txtclear()
	{
	  document.mfsearch.tsearch.value='';
	}
	function txtset(){
		if(document.mfsearch.tsearch.value.trim()==''){
			document.mfsearch.tsearch.value='请输入要搜索的关键字';
		}
	}
	function check()
	{
	  var key = document.mfsearch.tsearch.value;
	  if(key.trim()=='请输入要搜索的关键字')
	  {
	    alert('关键字不能为空!');
	    return;
	  }
	  document.mfsearch.submit();
	}
 </script>
<form action="${pageContext.request.contextPath}/manage/goods/list.do" method="get" name="mfsearch">
<table>
  <tr>
    <td>
      <input type="text" name="tsearch" value="请输入要搜索的关键字" onfocus="txtclear()" onblur="txtset()"/>
    </td>
  </tr>
  <tr align="right">
    <td>
      <input type="button" id="bsearch" name="bsearch" value="搜索" onclick="check()"/>		        
    </td>
  </tr>
</table>
</form>