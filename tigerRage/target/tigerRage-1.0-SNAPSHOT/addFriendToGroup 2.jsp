<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.User" %>
<%@ page import="service.UserService" %>
<%@ page import="service.ServiceImpl.UserServiceImpl" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: xuruihang
  Date: 2022/6/7
  Time: 12:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加好友进群</title>
</head>
<link rel="stylesheet" href="css/addFriendToGroup.css">
<style>
    body{
        background: url("img/bk3.jpg") no-repeat center;
        width: 100%;
        height: 100%;
    }
</style>
<body>

    <%
        UserService userService = new UserServiceImpl();
        String userId = (String)session.getAttribute("userId");
        ArrayList<User> users = null;
        try {
             users = (ArrayList<User>)userService.queryFriend(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    %>
    <div class = "app">
        <p class="little">可邀请好友</p>
    <%
       for (int i = 0; i < users.size(); i++) {
    %>
        <form action="${pageContext.request.contextPath}/addFriendToGroupServlet" class = "form" method="post">
            <p class="form1"><%= users.get(i).getNickName()%></p>
              <input type="hidden" value="<%= users.get(i).getId()%>" name = "userId">
            <p class="form2" > <input type="submit" value="添加入群"></p>
         </form>
     <%}%>
</div>
</body>
</html>
