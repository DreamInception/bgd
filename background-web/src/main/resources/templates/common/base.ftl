<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <meta name="description" content="page description">
    <title> 多肉理财 - 后台管理</title>

    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/font-awesome.min.css" rel="stylesheet"/>
    <!-- only if needed -->

    <link href="css/ace-fonts.css" rel="stylesheet"/>
    <!-- you can also use google hosted fonts -->
    <link href="css/datepicker.css" rel="stylesheet"/>
    <link href="css/bootstrap-datetimepicker.css" rel="stylesheet"/>
    <link href="css/ace.min.css" rel="stylesheet"/>
    <!--[if lte IE 9]>
    <link href="css/ace-part2.min.css" rel="stylesheet"/>
    <![endif]-->

    <link href="css/ace-skins.min.css" rel="stylesheet"/>
    <!-- only if needed -->
    <link href="css/ace-rtl.min.css" rel="stylesheet"/>
    <link href="css/chosen.css" rel="stylesheet"/>
    <!-- only if needed -->

    <!--[if lte IE 9]>
    <link href="css/ace-ie.min.css" rel="stylesheet"/>
    <![endif]-->
    <link href="css/main.css" rel="stylesheet"/>
    <!-- ace settings handler -->
    <script src="script/common/ace-extra.min.js"></script>
    <!--[if lte IE 8]-->
    <script src="script/common/html5shiv.min.js"></script>
    <script src="script/common/respond.min.js"></script>
</head>
<body class="no-skin" style="background-color: #fff!important">
<#include "../common/top_navbar.ftl">
<#include "../common/sidebar.ftl">
   <!-- /.main-content -->
<div class="main-content">
	<#include "../activity_manage/activity_manage_list.ftl">
</div>
 
<#include "../common/footer.ftl">
<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
		<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
</a>
<!-- list of script files -->
<!--[if !IE]> -->
<script src="script/common/jquery.min.js"></script>
<!-- <![endif]-->
<!--[if lte IE 9]>
<script src="script/jquery1x.min.js"></script>
<![endif]-->

<script src="script/common/bootstrap.min.js"></script>

<!-- ie8 canvas if required for plugins such as charts, etc -->
<!--[if lte IE 8]>
<script src="script/excanvas.min.js"></script>
<![endif]-->
<!-- ace scripts -->
<script src="script/common/ace-elements.min.js"></script>
<script src="script/common/ace.min.js"></script>
<!--  Custom Plugin Start-->
<script src="script/common/jquery.rowSelect.js"></script>
<script src="script/common/chosen.jquery.min.js"></script>     
<script src="script/common/laypage/laypage.js"></script>
<script src="script/common/bootbox.min.js"></script>
<script src="script/common/fuelux.spinner.min.js"></script>
<script src="script/common/date-time/bootstrap-datepicker.min.js"></script>
<script src="script/common/date-time/moment.min.js"></script>
<script src="script/common/date-time/bootstrap-datetimepicker.min.js"></script>
<script src="script/common/My97DatePicker/WdatePicker.js"></script>
<script src="script/base.js"></script>
<script src="script/common/call.common.wizard.js"></script>
    	
</script>
<!-- Custom Plugin End-->
</body>
</html>