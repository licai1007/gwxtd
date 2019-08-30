<%@ page contentType="text/html;charset=utf-8" %>
<link href="${pageContext.request.contextPath}/res/css/generalstyle.css" type="text/css" rel="stylesheet">
<script type="text/javascript">
	function remind(){
		if(confirm("您确定注销吗?")){
			window.top.location.href = "${pageContext.request.contextPath}/logout.do";
		}
	}
</script>
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
  <tr>
    <td>
      <table width="50%">
        <tr align="center">
          <td><a href="${pageContext.request.contextPath}/manage/goods/index.do" target="_top">商品管理</a></td>
          <td><a href="${pageContext.request.contextPath}/manage/order/index.do" target="_top">订单管理</a></td>
          <td><a href="${pageContext.request.contextPath}/manage/admin/index.do" target="_top">管理员管理</a></td>
          <td><a href="${pageContext.request.contextPath}/manage/admin/changepwd.do" target="_top">修改密码</a></td>
          <td><a href="javascript:void(0)" onClick="remind();">注销</a></td>
        </tr>
      </table>
    </td>
  </tr>
</table>