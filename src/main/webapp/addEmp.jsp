<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>add emp</title>
</head>
<body>
	<form action="servlet/saveEmp">
		<p>请填入新员工信息</p>
		员工号：&nbsp&nbsp&nbsp&nbsp<input type="text" name="empno" /><br>
		<br> 员工姓名：<input type="text" name="ename" /><br>
		<br> 工作：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input
			type="text" name="job" /><br>
		<br> 领导编号：<input type="text" name="mgr" /><br>
		<br> 薪水：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input
			type="text" name="sal" /><br>
		<br> 提成：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input
			type="text" name="comm" /><br>
		<br> 部门号：&nbsp&nbsp&nbsp&nbsp<input type="text" name="deptno" /><br>
		<br>
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input
			type="submit" value="提交">
	</form>
</body>
</html>