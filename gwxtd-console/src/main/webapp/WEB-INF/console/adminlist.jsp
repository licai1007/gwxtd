<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>列表</title>
	<script type="text/javascript">
		function del(aid){
			if(confirm("您确认删除这个管理员吗？")){
				window.top.location.href = "${pageContext.request.contextPath}/manage/admin/delete.do?aid="+aid;
			}
		}
	</script>
</head>
<body>
	<table width="70%" hight="100%">
		<tr>
			<th>管理员ID</th>
	  		<th>用户名</th>
	  		<th>管理员级别</th>
	  		<th>管理员删除</th>
	    </tr>
        <c:forEach items="${admins}" var="admin" varStatus="vs">
	   		<c:choose>
	   			<c:when test="${vs.index%2==0}">
	   				<tr align="center" bgcolor="#F5F9FE">
	   			</c:when>
	   			<c:otherwise>
	   				<tr align="center">
	   			</c:otherwise>
	   		</c:choose>
          		<td>${admin.aid}</td>
          		<td>${admin.aname}</td>
          		<td>${admin.alevel}</td>
          		<td><a href="javascript:void(0)" onClick="del('${admin.aid}');">删除</a></td>
          	</tr>
         </c:forEach>
	</table>
</body>
</html>