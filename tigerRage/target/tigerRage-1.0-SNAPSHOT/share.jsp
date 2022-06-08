<%@ page import="beans.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.Group" %>
<%@ page import="service.GroupService" %>
<%@ page import="service.ServiceImpl.GroupServiceImpl" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2022/6/4
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>分享页面</title>
    <link rel="stylesheet" href="css/share.css">
</head>
<script>
    function shareGroup(groupId) {

    }
</script>
<style>
    *{
        margin: 0;
        padding: 0;
    }
    body{
        background-image: url("img/bk2.jpg");
        background-position:right top;
        background-repeat:repeat;
        box-sizing: border-box;
    }

</style>
<body>
<%
    GroupService groupService = new GroupServiceImpl();
    User user = (User) session.getAttribute("user");
    ArrayList<Group> groups = null;
    try {
        groups = groupService.queryGroupsByUserId(Integer.parseInt(user.getId()));
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
<div class="app">

            <p class="button"> <a href="scheduleInformation.jsp" >"返回"</a></p>
        </form>
        <p class="title">选择分享对象</p>

        <%
            for (int i = 0; i < groups.size(); i ++) {

        %>

            <form action = "${pageContext.request.contextPath}/eventShareServlet" method="post" >
              <p class="user">  <%= groups.get(i).getName()%>
                <input type="hidden" value="<%=groups.get(i).getId()%>" name = "groupId">
                  <input type="submit" value="分享"></p>
            </form>
        </div>
        <%
            }
        %>
</div>
</body>
</html>
