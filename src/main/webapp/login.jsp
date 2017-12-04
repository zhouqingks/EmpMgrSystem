<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录页面</title>
</head>
<body>
	<div id="msg">
	会话状态:<%=(session.isNew()? "新的会话" : "旧的会话")%>
	<br>
	会话ID:<%=session.getId() %>
	<br>
	创建时间:<%=(new Date(session.getCreationTime())).toLocaleString()%>
	<br>
	上次访问时间:<%=(new Date(session.getLastAccessedTime())).toLocaleString()%>
	<br>
	最大不活动时间间隔(s):<%=session.getMaxInactiveInterval() %>
	</div>
	<%
		if(session.getAttribute("err") != null)
		{
		    %>
		    <p><%=session.getAttribute("err")%></p>
		    <%	    
		}
	%>
	<form action="<%=request.getContextPath()%>/servlet/login1"" method="post">
		请输入用户名<input type="text" name="username"><br><br>
		请输入密码&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="password"><br><br>
		<input type="reset" value="重填">&nbsp;&nbsp;<input type="submit" value="登陆">
		
	</form>
</body>
</html>