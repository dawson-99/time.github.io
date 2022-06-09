
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>


        <form  action="${pageContext.request.contextPath}/LoginServlet" method="post">
<p>
                <span class="zhanghaoText">账号：</span>
               <label> <input type="text" class="login1" name = "username"/></label>
</p>

<p>
                <span class="mimaText">密码：</span>
            <label> <input type="password" class="login2" name = "password"/></label>
</p>
            <p>
           <input type="submit" class="loginButton" value="登录">
</p>

            <p class="checkstyle"><input id="checkbox"  type="checkbox" checked="checked" /><span style="font-size: 30px" >记住我的密码</span></p>
        </form>
        <p class="text1">还没有账号？<a href="register.jsp">创建账号</a></p>
        <p class="text2">忘记账号或密码？<a href="http://baidu.com">点击这里找回</a></p>

</body>
</html>
