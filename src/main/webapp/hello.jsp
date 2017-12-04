<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>hello</title>
</head>
<body>
	<%session.setAttribute("err", null); %>
	<div id="msg">
		会话状态:<%=(session.isNew() ? "新的会话" : "旧的会话")%>
		<br> 会话ID:<%=session.getId()%>
		<br> 创建时间:<%=(new Date(session.getCreationTime())).toLocaleString()%>
		<br> 上次访问时间:<%=(new Date(session.getLastAccessedTime())).toLocaleString()%>
		<br> 最大不活动时间间隔(s):<%=session.getMaxInactiveInterval()%>
	</div>
	<p>
		欢迎你,<%=session.getAttribute("username")%></p>
	<div>
		<a href="login.jsp">重新登陆</a>&nbsp;&nbsp;<a
			href="<%=request.getContextPath()%>/servlet/loginout">注销</a>
	</div>
</body>
</html>