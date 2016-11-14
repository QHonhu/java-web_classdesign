<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>管理员 </title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
	<script type="text/javascript" src="js/login.js"></script>
	<link href="css/login2.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
		function reloadCode() {
			var time = new Date().getTime();
			document.getElementById("imagecode").src = "randomcode.jpg?d="
					+ time;
		}
	</script>
</head>
<body>
	<h1>
		网上电子商城<sup>V1.0</sup>
	</h1>

	<div class="login" style="margin-top: 50px;">

		<div class="header">
			<div class="switch" id="switch">
				<a class="switch_btn_focus" id="switch_qlogin"
					href="javascript:void(0);" tabindex="7">管理员登录</a> 
				<div class="switch_bottom" id="switch_bottom"
					style="position: absolute; width: 64px; left: 0px;"></div>
			</div>
		</div>


		<div class="web_qr_login" id="web_qr_login"
			style="display: block; height: 350px;">

			<!--登录-->
			<div class="web_login" id="web_login">


				<div class="login-box">


					<div class="login_form">
						<form action="<%=request.getContextPath()%>/loginservlet"
							name="loginform" accept-charset="utf-8" id="login_form"
							class="loginForm" method="post">
							<input type="hidden" name="did" value="0" /> <input
								type="hidden" name="to" value="log" />
							<div class="uinArea" id="uinArea">
								<label class="input-tips" for="u">帐号：</label>
								<div class="inputOuter" id="uArea">

									<input type="text" id="u" name="username" class="inputstyle" />
								</div>
							</div>
							<div class="pwdArea" id="pwdArea">
								<label class="input-tips" for="p">密码：</label>
								<div class="inputOuter" id="pArea">

									<input type="password" id="p" name="password"
										class="inputstyle" /><br />
								</div>
							</div>
							<div id="checkcode">验证码:</div>
							<div id="yzmk">
								<input type="text" name="checkcode" class="inputstyle" />
							</div>
							<img id="imagecode" alt="验证码" src="randomcode.jpg"> <a
								href="javascript:reloadCode();"><p id="kbq">看不清</p></a><br/><br/>
									
								<input type="submit" value="登 录" style="width: 90px;height:30px;float:left;"
											class="button_blue" />
								<input type="reset" value="取 消" style="width: 90px;height:30px;float:right;"
											class="button_blue" />
											
						</div>
						</form>
					</div>

				</div>

			</div>
			<!--登录end-->
		</div>
	<div class="jianyi">*推荐使用ie8或以上版本ie浏览器或Chrome内核浏览器访问本站</div>
</body>
</html>