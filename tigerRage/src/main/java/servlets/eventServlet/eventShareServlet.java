package servlets.eventServlet;

import beans.Event;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.EventService;
import service.GroupService;
import service.ServiceImpl.EventServiceImpl;
import service.ServiceImpl.GroupServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

public class eventShareServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String eventId = (String)session.getAttribute("eventId");
        String groupId = req.getParameter("groupId");

        GroupService groupService = new GroupServiceImpl();
        int n = 0;
        try {
            n = groupService.addEventToGroup(eventId, Integer.parseInt(groupId));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (n > 0) {
            resp.sendRedirect("share_successful.jsp");
        } else {
            resp.sendRedirect("error.jsp");
        }
    }
}
