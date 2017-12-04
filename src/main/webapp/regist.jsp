<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>regist</title>
<style type="text/css">
.container {
	text-align: center;
	position: relative;
	top: 100px;
}
</style>

<script type="text/javascript" src="./jquery/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(function() {
		$("#username").on("change", function() {
			if (check($("#username").val())) {
				$.ajax({
					url : "servlet/validate",
					type : "POST",
					dataType : "json",
					data : {
						username : $("#username").val()
					},
					success : function(data) {
						if (data.result == 1) {
							var $msg = $("#msg");
							$msg.text("用户名以存在！");
							$msg.css("color", "red");
						}
					},
					error : function() {
						alert("error");
					}
				});

			}
		});
		$("#password").on("change", function() {
			check($("#password").val());
		});

		$("#confirmPassword").on("change", function() {
			var $msg = $("#msg");

			if ($("#confirmPassword").val() != $("#password").val()) {
				$msg.text("前后密码不匹配！");
				$msg.css("color", "red");
			} else {
				$msg.text("");
			}
		});

		function check(param) {
			var $msg = $("#msg");

			if (param.length < 8) {
				$msg.text("长度需要大于8位！");
				$msg.css("color", "red");
				return false;
			} else {
				$msg.text("");
				return true;
			}
		}
	});
</script>
</head>
<body>
	<div class="container">
		<div id="msg"></div>
		<form action="servlet/regist" method="post">
			<input type="text" id="username" name="username" placeholder="请输入用户名"><br>
			<input type="password" id="password" name="password"
				placeholder="请输入密码"><br> <input type="password"
				id="confirmPassword" placeholder="请输入确认密码"><br> <input
				type="submit" value="注册"><span>&nbsp&nbsp</span> <input
				type="reset" value="重置">
		</form>
	</div>
	</div>
</body>
</html>