package servlets.userServlet;

import beans.User;
import dao.impl.UserDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.ServiceImpl.UserServiceImpl;
import service.UserService;

import java.io.IOException;
import java.sql.SQLException;

//@WebServlet("/update")
public class UpdateInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            String nickName = req.getParameter("nickName");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String tel = req.getParameter("tel");
        String text = req.getParameter("text");

        System.out.println(text + "---------");
        User user = null;

        HttpSession session = req.getSession();
        user = (User)session.getAttribute("user");

        if(nickName.equals("")) {
            user.setNickName(user.getNickName());
        } else {
            user.setNickName(nickName);
        }
        if(sex.equals("")) {
            user.setSex(user.getSex());
        } else {
            user.setNickName(sex);
        }
        if (tel.equals("")) {
            user.setTel(user.getTel());
        } else {
            user.setNickName(tel);
        }
        if(text.equals("")) {
            user.setText(user.getText());
        } else {
            user.setText(text);
        }
        if(password.equals("")) {
            user.setPassword(user.getPassword());
        } else {
            user.setPassword(password);
        }

        UserService userService = new UserServiceImpl();
        try {
            userService.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
