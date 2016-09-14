<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Login Page - Ace Admin</title>

		<meta name="description" content="User login page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/css/font-awesome.min.css" />
		<!-- text fonts -->
		<link rel="stylesheet" href="/css/ace-fonts.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="/css/ace.min.css" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="css/ace-part2.min.css" />
		<![endif]-->
		<link rel="stylesheet" href="/css/ace-rtl.min.css" />

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="css/ace-ie.min.css" />
		<![endif]-->
		<link rel="stylesheet" href="/css/login.css" />
		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="script/html5shiv.js"></script>
		<script src="script/respond.min.js"></script>
		<![endif]-->
	</head>
	<!--  login-layout 整个页面背景颜色 -->
	<body class="login-layout">
		<div class="main-container">
			<!--  main-content 左右外边距为0，内边距为15px -->
			<div class="main-content">
				<!-- row 外边距为-12px -->
				<div class="row">
					<!-- 大于等于768px的宽度占10/12，左侧外边距 1/12-->
					<div class="col-sm-10 col-sm-offset-1">
						<!-- 大于等于768px的宽度375px ； 小于等于540px的宽度是98%  居中-->
						<div class="login-container">
							<!-- 文字居中-->
							<div class="center">
								<!-- 覆盖bs的 h1标签的字体大小，字宽，字体-->
								<h1>
									<!-- ace-icon 字体居中； fa：font-awesome字体的样式； fa-leaf:before： 字体的内容；green: 字体的颜色 -->
									<i class="ace-icon fa fa-leaf green"></i>
									<span class="red">多肉后台</span>
									<span class="white" id="id-text2">管理系统</span>
								</h1>
								<!-- 覆盖bs的 h4标签的字体大小，字宽，字体-->
								<h4 class="blue" id="id-company-text">&copy; 景源金融</h4>
							</div>
							<!-- 宽度为1，上下外边距为6px和5px-->
							<div class="space-6"></div>
							<!-- 相对定位-->
							<div class="position-relative">
								<!-- visible 控制窗口显示与过渡效果；
									 widget-box 全局默认样式： 外边距、内边距、边框和阴影
									 			小于等于540px 内边距为0；
									 			小于等于767px 上下外边距为7px;
									 			大于等于767px 绝对定位fixed, 优先级，外边距、内边距、边框、阴影以及显示
									no-border: 边框为0
									 -->
								<div id="login-box" class="login-box visible widget-box no-border">
									<!-- 背景颜色为白色-->
									<div class="widget-body">
										<!-- 全局默认样式： 内边距为12px;
										 	 小于等于540px 内边距为16px；
									 		 大于等于767px 上下内边距为 16px 左右36px; 背景覆盖widget-body背景色
										 -->
										<div class="widget-main">
											<!-- header 内外边距和边框，lighter 字体宽度 h4.bigger 字体大小-->
											<h4 class="header blue lighter bigger">
												<i class="ace-icon fa fa-coffee green"></i>
												请输入登录信息
											</h4>

											<div class="space-6"></div>

											<form>
												<fieldset>
													<!-- label 全局默认样式 字体大小和字宽,覆盖bs样式
		                                                       当前页面下： 外下边距11px;
		                                                 block 块元素
		                                                 clearfix：before : 内部html标签实现如CSS 制作table的样式,里面的元素可设置最小宽度，等高，清除浮动
															-->
													<label class="block clearfix">
														<!-- span input-icon： 内联样式 input-icon 块样式
														     block： 块元素
														-->
														<span class="block input-icon input-icon-right">
															<!-- form-control 全局默认样式 颜色边框背景，覆盖bs默认样式
	                                                             input[type=text]  覆盖form-control样式，设置字体边框背景等
	                                                             input-icon>input  左右内边距
	                                                             .input-icon.input-icon-right>input 重新覆盖左右内边距
															-->
															<input type="text" class="form-control" placeholder="用户名" id="login-username"/>
															<i class="ace-icon fa fa-user"></i>
														</span>
													</label>
													<p id="login-username-error" class="errorMsg"></p>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="密码" id="login-psw"/>
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label>
													<p id="login-psw-error" class="errorMsg"></p>
													<!-- 高度为1，上下外边距为12px-->
													<div class="space"></div>

													<div class="clearfix">
														<label class="inline">
															<!-- label input[type=checkbox].ace  把原生checkbox高度设为0
															 	input[type=checkbox].ace:checked 原生checkbox选中后outline设为0
															 -->
															<input type="checkbox" class="ace" />
															<!-- lbl 设置内联样式，最小宽高等
															input[type=checkbox].ace+.lbl::before  未选中时内容‘\a0'和其他样式
															input[type=checkbox].ace:checked+.lbl::before 选中后，内容，背景和边框改变
															-->
															<!--<span class="lbl"> Remember Me</span>-->
														</label>
														<!-- width-35 宽度35%； btn，btn-primary 覆盖bs默认样式和颜色
															btn-sm 设置btn字体，内边距，边框等
														-->
														<button type="button" class="width-100  btn btn-sm btn-primary" id="login-button">
															<i class="ace-icon fa fa-key"></i>
															<!-- bigger-110 字体大小110%；-->
															<span class="bigger-110">登录</span>
														</button>
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>
											<!-- social-or-login 相对定位
												.social-or-login:before： 加 内容为空的绝对定位的横线
											-->
											<!--<div class="social-or-login center">-->
												<!--<span class="bigger-110">Or Login Using</span>-->
											<!--</div>-->

											<!--<div class="space-6"></div>-->

											<!--<div class="social-login center">-->
												<!--&lt;!&ndash; a标签  设置宽高，弧度等&ndash;&gt;-->
												<!--<a class="btn btn-primary">-->
													<!--&lt;!&ndash; .social-login a>.ace-icon 字体大小-->
															<!--.ace-icon  字体居中-->
														<!--&ndash;&gt;-->
													<!--<i class="ace-icon fa fa-facebook"></i>-->
												<!--</a>-->

												<!--<a class="btn btn-info">-->
													<!--<i class="ace-icon fa fa-twitter"></i>-->
												<!--</a>-->

												<!--<a class="btn btn-danger">-->
													<!--<i class="ace-icon fa fa-google-plus"></i>-->
												<!--</a>-->
											<!--</div>-->
										</div><!-- /.widget-main -->
										<!-- toolbar 背景边框颜色-->
										<div class="toolbar clearfix">
											<!-- div 宽度小于540px，为auto;大于为50% ；浮动、内联-->
											<div>
												<a href="#" data-target="#forgot-box" class="forgot-password-link">
													<i class="ace-icon fa fa-arrow-left"></i>
													忘记密码
												</a>
											</div>

											<div>
												<a href="#" data-target="#signup-box" class="user-signup-link">
													注册账号
													<i class="ace-icon fa fa-arrow-right"></i>
												</a>
											</div>
										</div>
									</div><!-- /.widget-body -->
								</div><!-- /.login-box -->
								<!-- 打开时 添加visible CSS 水平方向从0到100%，同时右移150px-->
								<div id="forgot-box" class="forgot-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header red lighter bigger">
												<i class="ace-icon fa fa-key"></i>
												重设登录密码
											</h4>

											<div class="space-6"></div>
											<!--<p class="blue">-->
												<!--请设置新的登录密码:-->
											<!--</p>-->

											<form>
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="密码6~16位" id="forget-psw"/>
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label>
													<p id="forget-psw-error" class="errorMsg"></p>
													<div class="clearfix" style="margin-top:20px">
														<button type="button" class="width-100 btn btn-sm btn-danger"  id="resetPsw-button">
															<i class="ace-icon fa fa-lightbulb-o"></i>
															<span class="bigger-110">提交</span>
														</button>
													</div>
												</fieldset>
											</form>
										</div><!-- /.widget-main -->

										<div class="toolbar center">
											<a href="#" data-target="#login-box" class="back-to-login-link">
												返回登录页
												<i class="ace-icon fa fa-arrow-right"></i>
											</a>
										</div>
									</div><!-- /.widget-body -->
								</div><!-- /.forgot-box -->

								<div id="signup-box" class="signup-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header green lighter bigger">
												<i class="ace-icon fa fa-users blue"></i>
												新用户注册
											</h4>

											<div class="space-6"></div>
											<!--<p> Enter your details to begin: </p>-->

											<form>
												<fieldset>
													<!--<label class="block clearfix">-->
														<!--<span class="block input-icon input-icon-right">-->
															<!--<input type="email" class="form-control" placeholder="Email" />-->
															<!--<i class="ace-icon fa fa-envelope"></i>-->
														<!--</span>-->
													<!--</label>-->

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="用户名" id="reg-username"/>
															<i class="ace-icon fa fa-user"></i>
														</span>
													</label>
													<p id="reg-username-error" class="errorMsg"></p>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="密码" id="reg-first-psw"/>
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label>
													<p id="reg-firstPsw-error" class="errorMsg"></p>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="确认密码" id="reg-second-psw"/>
															<i class="ace-icon fa fa-retweet"></i>
														</span>
													</label>
													<p id="reg-secondPsw-error" class="errorMsg"></p>
													<!--<label class="block">-->
														<!--<input type="checkbox" class="ace" />-->
														<!--<span class="lbl">-->
															<!--I accept the-->
															<!--<a href="#">User Agreement</a>-->
														<!--</span>-->
													<!--</label>-->

													<div class="space-24"></div>

													<div class="clearfix">
														<button type="button" class="width-100  btn btn-sm btn-success" id="reg-button">
															<span class="bigger-110">注册</span>

															<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
														</button>
														<!--<button type="reset" class="width-30 pull-right btn btn-sm">-->
															<!--<i class="ace-icon fa fa-refresh"></i>-->
															<!--<span class="bigger-110">取消</span>-->
														<!--</button>-->


													</div>
												</fieldset>
											</form>
										</div>

										<div class="toolbar center">
											<a href="#" data-target="#login-box" class="back-to-login-link">
												<i class="ace-icon fa fa-arrow-left"></i>
												返回登录页
											</a>
										</div>
									</div><!-- /.widget-body -->
								</div><!-- /.signup-box -->
							</div><!-- /.position-relative -->
							<!-- navbar-fixed-top 绝对定位fixed,设置top和边框覆盖bs样式
								 align-right 右对齐
								 点击每个颜色可改变背景色： 为body 标签添加 背景颜色和图片的css选择器
							-->
							<!--<div class="navbar-fixed-top align-right">-->
								<!--<br />-->
								<!--&nbsp;-->
								<!--<a id="btn-login-dark" href="#">Dark</a>-->
								<!--&nbsp;-->
								<!--<span class="blue">/</span>-->
								<!--&nbsp;-->
								<!--<a id="btn-login-blur" href="#">Blur</a>-->
								<!--&nbsp;-->
								<!--<span class="blue">/</span>-->
								<!--&nbsp;-->
								<!--&lt;!&ndash; 右侧文字右边保留空格&ndash;&gt;-->
								<!--<a id="btn-login-light" href="#">Light</a>-->
								<!--&nbsp; &nbsp; &nbsp;-->
							<!--</div>-->
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div><!-- /.main-content -->
		</div><!-- /.main-container -->

		<!-- basic scripts -->
		<!--[if !IE]> -->
			<script src="script/common/jquery.min.js"></script>
<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='script/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='script/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="script/common/bootstrap.min.js"></script>
		<script src="script/common/bootbox.min.js"></script>
		<script src="script/common/call.common.wizard.js"></script>
		<script src="script/login.js"></script>
		<!-- inline scripts related to this page -->

	</body>
</html>
