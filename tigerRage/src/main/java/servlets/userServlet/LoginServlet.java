package servlets.userServlet;


import beans.Event;
import beans.Group;
import beans.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.EventService;
import service.GroupService;
import service.ServiceImpl.EventServiceImpl;
import service.ServiceImpl.GroupServiceImpl;
import service.ServiceImpl.UserServiceImpl;
import service.UserService;

//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();
    EventService eventService = new EventServiceImpl();
    GroupService groupService = new GroupServiceImpl();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //统一编码
        req.setCharacterEncoding("utf-8");
//        resp.sendRedirect("home.jsp");
//System.out.println("访问servlet");

        //1.收参
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //测试
//        User user = new User();
//        user.setId(username);
//        user.setPassword(password);
//        user.setNickName("123");
        //调用逻辑业务

        User user = null;
        try {
            user = userService.login(Integer.parseInt(username),password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(user!=null) {

            //获取session，没有则创建新的
            HttpSession session = req.getSession();
            //保存用户登录信息
            ArrayList<Group> groups = null;
            ArrayList<Event> events = null;

            try {
                groups = groupService.queryGroupsByUserId(Integer.parseInt(username));
                events = eventService.queryAllEventbyUserId(Integer.parseInt(username));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            session.setAttribute("userId", user.getId());
            session.setAttribute("user",user);
            //客户端重定向到首页
            resp.sendRedirect("home.jsp");
        }
        else{
            resp.sendRedirect("login_fail.jsp");//转到失败页面

        }
    }
}
