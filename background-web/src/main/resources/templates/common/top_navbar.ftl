<div class="navbar navbar-default" id="navbar">
    <div id="navbar-container" class="navbar-container">
        <!-- toggle buttons are here or inside brand container -->
        <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler">
            <span class="sr-only">Toggle slider</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>

        <div class="navbar-header pull-left">
            <!-- brand text here -->
            <a href="#" class="navbar-brand">
                <small>
                    <i class="fa fa-github-alt yellow bigger-120"></i>
                    后台管理系统
                </small>
            </a>

        </div>
        <!-- /.navbar-header -->


        <div class="navbar-buttons navbar-header pull-right ">
            <ul class="nav ace-nav">
                <!--
                <li class="green">
                    <a href="javascript:;" data-toggle="dropdown" class="dropdown-toggle">
                        <i class="fa fa-bell ace-icon"></i>
                        <span class="badge badge-important">3</span>
                    </a>

                    <ul class="dropdown-menu dropdown-navbar dropdown-menu-right dropdown-caret dropdown-close">
                        <li class="dropdown-header">
                            <i class="ace-icon fa fa-exclamation-triangle"></i>
                            8 Notifications
                        </li>
                        <li class="dropdown-content">
                            <ul class="dropdown-menu dropdown-navbar">
                                <li>
                                    <a href="javascript:;">
                                        <div class="clearfix">
                                    <span class="pull-left">
                                    你有12条消息未读
                                    </span>
                                            <span class="pull-right badge badge-info">+12</span>

                                        </div>
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;">
                                        <div class="clearfix">
                                    <span class="pull-left">
                                    你有12条消息未读
                                    </span>
                                            <span class="pull-right badge badge-info">+12</span>

                                        </div>
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;">
                                        <div class="clearfix">
                                    <span class="pull-left">
                                    你有12条消息未读
                                    </span>
                                            <span class="pull-right badge badge-info">+12</span>

                                        </div>
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;">
                                        <div class="clearfix">
                                    <span class="pull-left">
                                    你有12条消息未读
                                    </span>
                                            <span class="pull-right badge badge-info">+12</span>

                                        </div>
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;">
                                        <div class="clearfix">
                                    <span class="pull-left">
                                    你有12条消息未读
                                    </span>
                                            <span class="pull-right badge badge-info">+12</span>

                                        </div>
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:;">
                                <div class="clearfix">
                                    <span class="pull-left">
                                    你有12条消息未读
                                    </span>
                                    <span class="pull-right badge badge-info">+12</span>

                                </div>
                            </a>
                        </li>

                        <li class="dropdown-footer">
                            <a href="javascript:;">
                                查看所有的通知！
                                <i class="ace-icon fa fa-arrow-right"></i>
                            </a>
                        </li>

                        </a>

                    </ul>
                </li>
                -->
                <li class="light-blue">
                    <a href="javascript:;" data-toggle="dropdown" class="dropdown-toggle">
                        <img class="nav-user-photo" src="images/profiles/woman.jpg" alt="Jason's Photo"/>
                        		
								<span class="user-info">
								<small>欢迎使用,</small>
								<#if adminName??>
									${adminName!""}
								<#else>
									admin
								</#if>
								</span>

                        <i class="ace-icon fa fa-caret-down"></i>
                    </a>
                    <ul class="user-menu dropdown-yellow dropdown-menu dropdown-menu-right dropdown-caret dropdown-close">
                        <li>
                            <a href="javascript:;">
                                <i class="ace-icon fa fa-cog"></i>
                                修改登录密码
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="sysAdminLogout.do" id="logOut_link">
                                <i class="ace-icon fa fa-power-off"></i>
                                退出
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
        <!-- /.navbar-buttons -->


    </div>
    <!-- /.navbar-container -->
</div>