<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>内容</title>
  </head>
  <frameset cols="250,*" frameborder="no" framespacing="0">
  	<frame src="${pageContext.request.contextPath}/manage/admin/left.do" name="leftFrame" noresize="noresize"/>
  	<frame src="${pageContext.request.contextPath}/manage/admin/list.do" name="rightFrame"/>
  </frameset>
<noframes>
<body></body>
</noframes>
</html>