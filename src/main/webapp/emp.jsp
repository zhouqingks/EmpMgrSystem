<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page
	import="com.cheer.domain.*, com.cheer.util.*, java.util.*, java.sql.*, com.cheer.service.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Emp表</title>
</head>
<body>
	<div align="center">
		<input type="button" onclick="window.location.href='addEmp.jsp'"
			value="增加员工">
	</div>
	
	<br>

	<table border="1" cellspacing="0" align="center">
		<tr>
			<td>员工编号</td>
			<td>员工姓名</td>
			<td>工作</td>
			<td>领导编号</td>
			<td>雇佣日期</td>
			<td>薪水</td>
			<td>提成</td>
			<td>部门号</td>
			<td>操作</td>
		</tr>
		<%
		    EmpService empService = (EmpService)application.getAttribute("empService");
		    for (Emp emp : empService.getAll())
		    {
		%>
		<tr>
			<td><%=emp.getEmpno()%></td>
			<td><%=emp.getEname()%></td>
			<td><%=emp.getJob()%></td>
			<td><%=emp.getMgr()%></td>
			<td><%=emp.getHiredate()%></td>
			<td><%=emp.getSal()%></td>
			<td><%=emp.getComm()%></td>
			<td><%=emp.getDeptno()%></td>
			<td><a href="servlet/delEmp1?empno=<%=emp.getEmpno()%>">删除</a>&nbsp<a
				href="updateEmp.jsp?empno=<%=emp.getEmpno()%>">修改</a></td>
		</tr>
		<%
		    }
		%>
	</table>
</body>
</html>