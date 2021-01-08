<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>
    <%--引入css与base标签	--%>
    <%@include file="/pages/common/head.jsp" %>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
    <script type="text/javascript">
        $(function () {

            //验证码点击更新
            $("#code_img").click(function () {
                <%--alert("${basePath}");--%>
                this.src = "${basePath}kaptcha.jpg?d=" + new Date();
            });

            $("#sub_btn").click(function () {

                // 用户名验证
                var usernameText = $("#username").val();
                var usernamePatt = /^\w{5,12}$/;
                if (!usernamePatt.test(usernameText)) {
                    $("span.errorMsg").text("用户名不合法！");
                    return false;
                }


                // 密码验证
                var passwordText = $("#password").val();
                var passwordePatt = /^\w{5,12}$/;
                if (!passwordePatt.test(passwordText)) {
                    $("span.errorMsg").text("密码不合法！");
                    return false;
                }


                //验证确认密码
                var repwdText = $("#repwd").val();
                if (repwdText != passwordText) {
                    $("span.errorMsg").text("确认密码与密码不一致！");
                    return false;
                }

                //邮箱格式验证
                var emailText = $("#email").val();
                var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                if (!emailPatt.test(emailText)) {
                    $("span.errorMsg").text("邮箱格式错误！");
                    return false;
                }

                //验证码暂时只验证存在，不牵涉服务器验证码生成
                var codeText = $("#code").val();
                codeText = $.trim(codeText);

                if (codeText == null || codeText == "") {
                    $("span.errorMsg").text("验证码不能为空!");
                    return false;
                }

                $("span.errorMsg").text("");

            });
        });
    </script>


</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册尚硅谷会员</h1>
                    <span class="errorMsg"><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg")%></span>
                </div>
                <div class="form">
                    <!--                    <form action="regist_success.jsp" method="get" >-->
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="regist">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="username" id="username"
                               value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" id="password" value="123456"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
                               name="repwd" id="repwd" value="123456"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
                               name="email" id="email"
                               value="<%=request.getAttribute("email")==null?"":request.getAttribute("email")%>"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 130px;" id="code" name="code"/>、
                        <%--static/img/code.bmp--%>
                        <img id="code_img" alt="" src="http://localhost:8080/book/kaptcha.jpg"
                             style="float: right; margin-right: 40px; width: 80px; height:30px;">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%--页尾展示--%>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>