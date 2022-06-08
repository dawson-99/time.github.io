package servlets.groupServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.GroupService;
import service.ServiceImpl.GroupServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

public class addFriendToGroupServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String groupId = (String)session.getAttribute("groupId");
        String userId = req.getParameter("userId");

        GroupService groupService = new GroupServiceImpl();
        int n = 0;
        try {
            groupService.addUserToGroup(Integer.parseInt(userId),Integer.parseInt(groupId));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (n > 0) {
            resp.sendRedirect("operationSuccess.jsp");
        } else {
            resp.sendRedirect("error.jsp");
        }

    }
}
