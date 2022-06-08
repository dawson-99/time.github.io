package servlets.userServlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import beans.User;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ServiceImpl.UserServiceImpl;
import service.UserService;
import dao.impl.UserDaoImpl;


public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("id");
        String password = req.getParameter("password");

        //查询用户名是否已存在0:不存在，1:存在
        int a1 = 0;
        User user1 = null;
        UserDaoImpl userDao = new UserDaoImpl();
        try {
            user1 = userDao.queryUserByUserId(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(user1 != null){
            a1=1;
            resp.sendRedirect("registerFailed.jsp");
        }
        else {//查询为空该用户名可以注册
            //注册，1注册成功0不成功
            UserService userService = new UserServiceImpl();
            User user2 = new User();
            user2.setId(username);
            user2.setPassword(password);
            user2.setText("null");
            user2.setNickName("null");
            user2.setTel("null");
            user2.setSex("1");
            int a2 = 0;
            try {
                a2 = userService.register(user2);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (a2 != 0) {
                resp.sendRedirect("register_success.jsp");
            } else {
                resp.sendRedirect("registerFailed.jsp");
            }
        }
        //响应数据给客户端
//        resp.setContentType("text/html;charset=UTF-8");
//        PrintWriter printWriter = resp.getWriter();
//        System.out.println("注册成功！");
    }
}
