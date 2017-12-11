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
			var $msg1 = $("#msg1");
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
							$msg1.text("用户名已存在！");
							$msg1.css("color", "red");
						}
						else {
							$msg1.text("");
						}
					},
					error : function() {
						alert("error");
					}
				});

			}
			else 
			{
				$msg1.text("长度需要大于8位！");
				$msg1.css("color", "red");
			}
		});
		$("#password").on("change", function() {
			var $msg2 = $("#msg2");
			if (check($("#password").val())) 
			{
				$msg2.text("");
			} 
			else 
			{
				$msg2.text("长度需要大于8位！");
				$msg2.css("color", "red");
			}
			
		});

		$("#confirmPassword").on("change", function() {
			var $msg3 = $("#msg3");

			if ($("#confirmPassword").val() != $("#password").val()) {
				$msg3.text("前后密码不匹配！");
				$msg3.css("color", "red");
			} else {
				$msg3.text("");
			}
		});

		function check(param) {
			//var $msg = $(".msg");

			if (param.length < 8) {
				//$msg.text("长度需要大于8位！");
				//$msg.css("color", "red");
				return false;
			} else {
				//$msg.text("");
				return true;
			}
		}
	});
</script>
</head>
<body>
	<div class="container">
		
		<form action="servlet/regist" method="post">	
			<input type="text" id="username" name="username" placeholder="请输入用户名">
			<div id="msg1" class="msg"></div><br>
			<input type="password" id="password" name="password" placeholder="请输入密码">
			<div id="msg2" class="msg"></div><br>
			<input type="password" id="confirmPassword" placeholder="请输入确认密码">
			<div id="msg3" class="msg"></div><br>
			<input type="submit" value="注册"><span>&nbsp&nbsp</span>
			<input type="reset" value="重置">
		</form>
	</div>
	</div>
</body>
</html>