<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
	<title>商品管理</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/res/script/jquery-1.8.2.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$('#changePage').change(function(){
				window.location.href="${pageContext.request.contextPath}/manage/goods/list.do?pageNumber="+$('#changePage').val()+"&gclass=${gclass}&tsearch=${gname}";
			});
		});
		function edit(gid){
			window.location.href = "${pageContext.request.contextPath}/manage/goods/edit.do?gid="+gid+"&url="+encodeURIComponent(window.location.href);
		}
	</script>
</head>
<body>
<table border="0" width="100%">
	<c:forEach items="${pageInfo.list}" var="goods">
	  <tr>
	    <td width="150" align="center">
	        <img src="${pageContext.request.contextPath}/res/${goods.gimgurl}" height="150" border="1"/>
	    </td>
	    <td colspan="2">
	      <table width="100%">
	        <tr>
	          <td bgcolor="#E4EDFA">${goods.gname}</td>
	        </tr>
	        <tr>
	          <td><font>${goods.gintro}</font></td>
	        </tr>
	        <tr>
	          <td bgcolor="#E4EDFA"><font>所属分类:${goods.gclass}</font></td>
	        </tr>
	        <tr>
	          <td><font>定价:￥${goods.gprice}</font></td>
	        </tr>
	        <tr>
	          <td bgcolor="#E4EDFA"><font>浏览次数:${goods.glook}</font></td>
	        </tr>
	        <tr>
	          <td><font>上架日期:<fmt:formatDate value="${goods.gdate}" pattern="yyyy-MM-dd hh:mm"/></font></td>
	        </tr>
	        <tr>
	          <td bgcolor="#E4EDFA">
	            <a href="javascript:void(0)" onClick="edit('${goods.gid}');">修改/删除商品</a>
	          </td>
	        </tr>
	      </table>
	    </td>
	  </tr>
	</c:forEach>
   <tr>
     <td colspan="3"><hr/></td>
   </tr>
   <tr align="center">
      <td>
      	<c:if test="${pageInfo.pageNo>1}">
     	 <a href="${pageContext.request.contextPath}/manage/goods/list.do?pageNumber=${pageInfo.pageNo-1}&gclass=${gclass}&tsearch=${gname}">&lt;&lt;上一页</a>
     	</c:if>
      </td>
      <td width="200">
     	<select id="changePage" name="selPage">
   	      <c:forEach begin="1" end="${pageInfo.totalPage}" varStatus="vs">
   	    	<option value="${vs.index}" <c:if test="${pageInfo.pageNo==vs.index}">selected="selected"</c:if>>第${vs.index}页</option>
   	      </c:forEach>
     	 </select>
      </td>
      <td align="left" width="40%">
      	<c:if test="${pageInfo.pageNo<pageInfo.totalPage}">
      	 <a href="${pageContext.request.contextPath}/manage/goods/list.do?pageNumber=${pageInfo.pageNo+1}&gclass=${gclass}&tsearch=${gname}">下一页&gt;&gt;</a>
      	</c:if>
      </td>
    </tr>
    <tr>
     <td colspan="3">
     	<a href="${pageContext.request.contextPath}/manage/goods/index.do">主页</a>
     </td>
   	</tr>
</table>
</body>
</html>