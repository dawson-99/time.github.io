package servlets.eventServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class eventShareJumpServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String eventId = req.getParameter("eventId");
        HttpSession session = req.getSession();
        session.setAttribute("eventId",eventId);
        resp.sendRedirect("share.jsp");
    }
}
