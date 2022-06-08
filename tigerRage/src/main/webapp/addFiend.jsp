<%--
  Created by IntelliJ IDEA.
  User: xuruihang
  Date: 2022/6/6
  Time: 11:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>邀请好友</title>
</head>
<body>
       <form action="${pageContext.request.contextPath}/addFriendServlet">
           请输入用户账号：<input type="text" name = "friendId"><br>
           <input type="submit" value="添加">
       </form>
</body>
</html>
