<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>管理员管理</title>
  </head>
  <frameset rows="150,*" frameborder="no" framespacing="0">
  	<frame src="${pageContext.request.contextPath}/manage/admin/top.do" name="topFrame" noresize="noresize"/>
  	<frame src="${pageContext.request.contextPath}/manage/admin/main.do" name="mainFrame"/>
  </frameset>
<noframes>
<body></body>
</noframes>
</html>