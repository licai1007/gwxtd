<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>操作</title>
</head>
<body>
	<table>
      <tr>
        <td><a href="${pageContext.request.contextPath}/manage/admin/add.do" target="rightFrame">管理员添加</a></td>
      </tr>
      <tr>
        <td><br/><a href="${pageContext.request.contextPath}/manage/admin/pwdreset.do" target="rightFrame">密码重置</a></td>
      </tr>
      <tr>
        <td><br/><a href="${pageContext.request.contextPath}/manage/admin/list.do" target="rightFrame">查看所有管理员</a></td>
      </tr>
    </table>
</body>
</html>