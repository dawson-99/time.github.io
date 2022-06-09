
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="beans.User" %>
<html>
<head>
    <link rel="stylesheet" href="css/personInfo.css">
<%--    <script>function getUserName()--%>
<%--    {--%>
<%--        String name = <%=user.get%>--%>

<%--        return name;--%>
<%--    }
    </script>--%>
</head>
<title>个人信息页</title>
    <style>
        body{
            background: url("img/bk4.png") center no-repeat;
        }
        p input{
            height: 60px;
            width: 350px;
            font-size: 25px;
            border-radius: 20px;
        }
    </style>

<body>
    <%
       String path = request.getContextPath();
        String basePase = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
        User user = (User)request.getSession().getAttribute("user");
    %>
    <div class="app">
   <a class="return_personInfo" href="home.jsp">返回</a>
   <form action="${pageContext.request.contextPath}/updateInfoServlet" method="post">
        <p class="name_text">昵称:<input type="text" value="<%=user.getNickName()%>" class="name" name="nickName"> <br> </p>
        <p class="mailbox_text">密码: <input type="password" name="password"><br></p>
        <p class="sex_text">性别:<input type="radio" name="sex"  checked="checked" style="width: 35px;height: 35px;color: #333333; " value="male">男
            <input type="radio" name="sex" style="width: 35px;height: 35px;color: #333333" value="female">女<br> </p>
        <p class="mailbox_text1"> 电话:<input type="text" name="tel" value =" <%=user.getTel()%>"><br></p>
        <p class="mailbox_text2"> 个人描述: <input type="text" name="text" value = "<%=user.getText()%>"> <br></p>
       <p class="submit"> <input type="submit" value="保存" class="save"></p>
   </form>
</div>
</body>
</html>
