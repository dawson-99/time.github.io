package servlets.groupServlet;

import beans.User;
import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.ServiceImpl.UserServiceImpl;
import service.UserService;

import java.io.IOException;
import java.sql.SQLException;

public class addFriendServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");

        String userId = user.getId();
        String friendId = req.getParameter("friendId");

        UserService userService = new UserServiceImpl();
        int rs = 0;
        try {
            rs = userService.addFriend(userId,friendId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(rs > 0) {
            resp.sendRedirect("addFriend_success.jsp");
        } else {
            resp.sendRedirect("error.jsp");
        }
    }
}
