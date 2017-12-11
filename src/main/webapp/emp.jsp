<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page
	import="com.cheer.domain.*, com.cheer.util.*, java.util.*, java.sql.*, com.cheer.service.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			List<Emp> list = empService.getAll();
			request.setAttribute("list", list);
		%>
		<c:forEach var="emp1" items="${list}">
			<tr>
			<td>${emp1.empno}</td>
			<td>${emp1.ename}</td>
			<td>${emp1.job}</td>
			<td>${emp1.mgr}</td>
			<td>${emp1.hiredate}</td>
			<td>${emp1.sal}</td>
			<td>${emp1.comm}</td>
			<td>${emp1.deptno}</td>
			<td><a href="servlet/delEmp1?empno=${emp1.empno}">删除</a>&nbsp<a
				href="updateEmp.jsp?empno=${emp1.empno}">修改</a></td>
		</tr>
		</c:forEach>
		<!-- 
		<%
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
		 -->
	</table>
</body>
</html>