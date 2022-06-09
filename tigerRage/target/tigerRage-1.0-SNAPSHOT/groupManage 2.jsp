<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.Group" %>
<%@ page import="service.GroupService" %>
<%@ page import="service.ServiceImpl.GroupServiceImpl" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: xuruihang
  Date: 2022/6/6
  Time: 9:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>群组管理</title>
</head>
<link rel="stylesheet" href="css/groupManage.css">
<style>
    *{
        margin: 0;
        padding: 0;
    }
    body{
        background-image: url("img/bk2.jpg");
        background-position:center center;
        background-repeat: repeat;
        box-sizing: border-box;
    }

</style>

<%

    ArrayList<Group> groups = null;
    GroupService groupService = new GroupServiceImpl();
    String userId = (String)session.getAttribute("userId");
    try {
        groups = groupService.queryGroupsByUserId(Integer.parseInt(userId));
    } catch (SQLException e) {
        e.printStackTrace();
    }

%>
<body>
<div class="app">
       <form method="post" class="infor4" action="./addFiend.jsp">
           <p class="form1">   <input type="submit" value="添加好友"></p>
       </form>

     <%
         for (int i = 0; i < groups.size(); i ++) {

     %>
         <p class = "infor1"><%= groups.get(i).getName()%><p/>

         <form method="post"  action="${pageContext.request.contextPath}/exitGroupServlet">
             <input type="hidden" value="<%=groups.get(i).getId()%>" name = "groupId">
             <p class="form2">      <input type="submit" value="退群"></p>
         </form>

         <form method="post"  action="${pageContext.request.contextPath}/dissolveGroupServlet">
             <input type="hidden" value="<%=groups.get(i).getId()%>" name = "groupId">
             <p class="form3">  <input type="submit" value="解散群"> </p>
         </form>

         <form method="post"  action="${pageContext.request.contextPath}/addFriendToGroupJumpServlet">
             <input type="hidden" value="<%=groups.get(i).getId()%>" name = "groupId">
             <p class="form4"> <input type="submit" value="添加好友入群"></p>
         </form>

     <%
         }
     %>
</div>
</body>
</html>
