$(function ($) {
    <!-- document父选择器  .toolbar a[data-target]子选择器-->
    var loginUname = false,
        loginPsw = false,
        resetPsw = false,
        regUname = false,
        regPsw = false,
        regSecondPsw = false;
    //切换注册登录页面
    $(document).on('click', '.toolbar a[data-target]', function (e) {
        e.preventDefault();
        var target = $(this).data('target');
        $('.widget-box.visible').removeClass('visible');//hide others
        $(target).addClass('visible');//show target
    });

//切换背景颜色
    $('#btn-login-dark').on('click', function (e) {
        $('body').attr('class', 'login-layout');
        $('#id-text2').attr('class', 'white');
        $('#id-company-text').attr('class', 'blue');

        e.preventDefault();
    });
    $('#btn-login-light').on('click', function (e) {
        $('body').attr('class', 'login-layout light-login');
        $('#id-text2').attr('class', 'grey');
        $('#id-company-text').attr('class', 'blue');

        e.preventDefault();
    });
    $('#btn-login-blur').on('click', function (e) {
        $('body').attr('class', 'login-layout blur-login');
        $('#id-text2').attr('class', 'white');
        $('#id-company-text').attr('class', 'light-blue');

        e.preventDefault();
    });
    $("#login-username").blur(function(){
        var obj = event.target;
        loginUname = validateUname(obj,"login-username-error","用户名错误");
    });
    $("#login-psw").blur(function(){
       var obj = event.target;
       loginPsw = validatePsw(obj,"login-psw-error","输入密码错误");
    });
    $("#forget-psw").blur(function(){
       var obj = event.target;
       resetPsw = validatePsw(obj,"forget-psw-error","输入密码错误");
    });

    $("#reg-username").blur(function(){
        var obj = event.target;
        regUname = validateUname(obj,"reg-username-error","用户名错误");
    });
    $("#reg-first-psw").blur(function(){
        var obj = event.target;
        regPsw = validatePsw(obj,"reg-firstPsw-error","输入密码错误");
    });
    var firstPsw = $("#reg-psw").val();
    $("#reg-second-psw").blur(function(){
        var obj = event.target;
        regSecondPsw = validatePsw(obj,"reg-secondPsw-error","确认密码错误");
    });


    $("#login-button").on("click",function(){
        loginCheck();
    });
    $("#reg-button").on("click",function(){
        regCheck();
    });
    $("#resetPsw-button").on("click",function(){
        resetPswCheck();
    });
function loginCheck(){
    var userName = $("#login-username").val();
    var userPwd = $("#login-psw").val();
    loginUname = validateUname($("#login-username"),"login-username-error","用户名错误");
    loginPsw = validatePsw($("#login-psw"),"forget-psw-error","输入密码错误");
    if(loginUname && loginPsw){
        $.ajax({
            type: 'post',
            url: '/sysAdminLogin.do',
            async: true,
            dataType: 'json',
            data: {
            	"adminName": userName,
            	"adminPwd": userPwd
            },
            success: function(data){
                if(data.flag){
                	window.location.href = "/base.do";
                }else{
                	call_alert_wizard(data.message);
                }
            },
            error: function(){
                
            }
        });
    };
}
    function regCheck(){
        var username = $("#reg-username").val();
        var fpsw = $("#reg-first-psw").val();
        var spsw = $("#reg-second-psw").val();
        regUname = validateUname($("#reg-username"),"reg-username-error","用户名错误");
        regPsw = validatePsw($("#reg-first-psw"),"reg-firstPsw-error","输入密码错误");
        regSecondPsw = validatePsw($("#reg-second-psw"),"reg-secondPsw-error","确认密码错误");
        if(regUname && regPsw && regSecondPsw){
            $.ajax({
                type: 'post',
                url: '/register.do',
                async: true,
                dataType: 'json',
                data: {
                	adminName: username,
                	adminPwd: fpsw,
                	confirmAdminPwd: spsw
                },
                success: function(data){
                	call_alert_wizard(data);
                    if(!data.flag){
                    	call_alert_wizard(data.message)
                    }else{
                    	window.location.href = "/login.do";
                    }
                },
                error: function(){
                	call_alert_wizard('系统错误，请联系管理员')
                }
            });
        };
    }
    function resetPswCheck(){
        var psw = $("#forget-psw").val();
        resetPsw = validatePsw($("#forget-psw"),"forget-psw-error","输入密码错误");
        if(resetPsw){
            $.ajax({
                type: 'post',
                url: '',
                async: true,
                dataType: 'json',
                data: {
                    password: psw
                },
                success: function(data){

                },
                error: function(){

                }
            });
        };
    }
function validateUname(obj,errorId,msg){
    var $this = obj;
    if(/^(\w){2,10}$/.test($this.value)){
        $('#'+errorId).css("visibility","hidden");
        return true;
    }else{
        showErrorMsg(errorId,msg);
        return false;
    }
}
function validatePsw(obj,errorId, errorMsg) {
    var $this = obj;
    if(/^(\w){6,16}$/.test($this.value)){
        $('#'+errorId).css("visibility","hidden");
        return true;
    }else{
        showErrorMsg(errorId,errorMsg);
        return false;
    }
}
function validateSecondPsw(obj, lastPsw, errorId, msg) {
    var $this = obj;
    if ($this.value == lastPsw) {
        $("#" + errorId).css("visibility", "hidden");
        return true;
    } else {
        showErrorMsg(errorId, msg);
        return false;
    }
}
function showErrorMsg(errorId,msg){
    $('#'+errorId).css("visibility","visible").html(msg);
}
});