
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>日程</title>
    <link rel="stylesheet" href="css/schedule.css" />
</head>
<body>


<a href="home.jsp" class="return">返回</a>
<table class="eventList" border="1" >
    <tr  style="height:40px ;width:256px " class="list1">
        <td><img style="height:40px ;width:256px " src="img/createEvent.png" alt="null"></td>
    </tr>
    <tr style="vertical-align: top" >
        <td><img style="height: 40px;width: 40px" src="img/findEvent.png">
            <a href="scheduleInformation.jsp" style="font-size: 35px ;text-decoration: none;color: #46535B ">查看日程</a></td>
    </tr>
</table>
<form  action="${pageContext.request.contextPath}/scheduleServlet" method="post" name = "time">
    <div>
        <span class="date_text">日期</span>
        <input type="text" class="year" name="year">
        <span class="year_text">年</span>
        <input type="text" class="month" name="month">
        <span class="month_text">月</span>
        <input type="text" class="day" name="day">
        <span class="day_text">日</span>
    </div>
    <p class="event_text" >
        事件
    </p>
    <p> <textarea rows="10" cols="20" class="event" style="font-weight: bold" name="text">输入您的日程</textarea></p>
    <input type="submit" value="创建日程" class="creatEvent">
</form>




</body>
</html>
