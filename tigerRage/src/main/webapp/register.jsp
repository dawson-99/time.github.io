<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2022/6/1
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<link rel="stylesheet" href="css/newindex.css">
<style >
    body {
        background: url("img/bk3.jpg") center no-repeat;
        width: 100%;
        height: 100%;
    }
    p input{
        height: 60px;
        width: 350px;
        font-size: 25px;
        border-radius: 20px;
    }
</style>
<body>
<a class="buttom1" href="login.jsp" > 返回</a>
<div  class="app">
    <div >
        <p class="tille" >register</p>
    </div>
    <div >
        <form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
            <p class="form1_1" >账号:<input  type="text" name="id"  placeholder="输入您的KeynoteID"><br></p>
            <p class="form1_2"  >设置您的密码:<input type="password" name="password" placeholder="密码需6位以上"><br></p>
            <p class="form1_3"></pc>  再次确认您的密码:<input  type="password" name="repassword"><br></p>
            <p class="from1_4"> <input type="submit" name="submit" value="创建Keynote账户"></p>
        </form>
    </div>
</div>
</body>
</html>
