<%@ page import="beans.User" %>
<%@ page import="service.EventService" %>
<%@ page import="service.ServiceImpl.EventServiceImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.Event" %><%--
  Created by IntelliJ IDEA.
  User: xuruihang
  Date: 2022/6/6
  Time: 6:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>日程信息</title>
</head>
<link rel="stylesheet" href="css/scheduleInformation.css">
<style>
    *{
        margin: 0;
        padding: 0;
    }
    body{
        background-image: url("img/bk2.jpg");
        background-position:center right;
        background-repeat:repeat;
        box-sizing: border-box;
    }


</style>

<%
    User user = (User)session.getAttribute("user");
    EventService eventService = new EventServiceImpl();
    ArrayList<Event> events = eventService.queryAllEventbyUserId(Integer.parseInt(user.getId()));

%>

<script>

</script>

<body>
<div class="app">
<a href=""><img src="img/createEvent.png" height=40px width=150px></a><br>
<h1>查看日程</h1>
       <p class="list">
           你的事件列表如下
       </p>
       <%
           for (int i = 0; i < events.size(); i ++) {

       %>
               <p class="infor">事件<%=i+1%>:</p>
               <p class="infor1">标题:<%= events.get(i).getTitle()%></p>
               <p class="infor2">时间:<%= events.get(i).getEndTime()%></p>

           <form method="post" action="${pageContext.request.contextPath}/eventCompleteServlet">
               <input type="hidden" value="<%=events.get(i).getId()%>" name = "id">
               <p class="form1">   <input type="submit" value="完成"></p>
           </form>

           <form method="post"  action="${pageContext.request.contextPath}/eventShareJumpServlet">
               <input type="hidden" value="<%=events.get(i).getId()%>" name = "eventId">
               <p class="form2">  <input type="submit" value="分享"></p>
           </form>

       <%
           }
       %>
</div>
</body>
</html>
