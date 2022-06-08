<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2022/6/2
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Calendar"  contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主菜单</title>
    <link rel="stylesheet" href="css/newindex.css">
</head>
<style >
    *{
        margin: 0;
        padding: 0;
    }
    body{
        background-image: url("img/bk2.jpg");
        background-position:center;
        background-repeat:repeat;
        box-sizing: border-box;
    }
</style>

<body>
<div class="app1">
    <div>
        <form action="login.jsp" method="post">
            <p class=" form2_1">  <input  type="submit" value="退出登录"></p>
        </form>
    </div>
    <div >
        <p class="appearance" >
                <%
            Calendar calendar=Calendar.getInstance();
            int year=calendar.get(Calendar.YEAR);
            int month=calendar.get(Calendar.MONTH);
            int day=calendar.get(Calendar.DATE);
        %>
                <%=year %>/<%=month %>/<%=day%>
        <p>
    </div>
    <div>

        <form action="${pageContext.request.contextPath}/manageJumpServlet" method="post">
            <p class="form2_2">  <input type="submit" value="管理"></p>
        </form>
    </div>

    <div>

        <form action="${pageContext.request.contextPath}/scheduleJumpServlet" method="post">
            <p class="form2_3"> <input type="submit" value="日程"></p>
        </form>
    </div>
    <div>
        <form action="${pageContext.request.contextPath}/personInfoServlet" method="post">
            <p class="form2_4">  <input type="submit" value="我的"></p>
        </form>
    </div>
</div>
</body>
</html>
