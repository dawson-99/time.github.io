package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class addFriendToGroupJumpServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String groupId = req.getParameter("groupId");
        HttpSession session = req.getSession();
        session.setAttribute("groupId",groupId);
        resp.sendRedirect("addFriendToGroup.jsp");
    }
}
