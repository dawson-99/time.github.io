package servlets.eventServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.EventService;
import service.ServiceImpl.EventServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

public class eventCompleteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

          String id = req.getParameter("id");
        EventService eventService = new EventServiceImpl();
        int n = 0;
        try {
            n = eventService.completeEvent(Integer.parseInt(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (n > 0) {
            resp.sendRedirect("finishEvent.jsp");
        } else {
            resp.sendRedirect("error.jsp");
        }
    }


}
