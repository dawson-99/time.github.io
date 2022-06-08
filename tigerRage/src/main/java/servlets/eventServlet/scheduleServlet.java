package servlets.eventServlet;

import beans.Event;
import beans.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.EventService;
import service.ServiceImpl.EventServiceImpl;

//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class scheduleServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

                String year = req.getParameter("year");
                String month = req.getParameter("month");
                String day = req.getParameter("day");
                String text = req.getParameter("text");

        Event event = new Event();
        event.setSituation(1);
        event.setDescription(text);
        event.setTitle(text);
        event.setEndTime(year + "-" + month + "-" + day);
        event.setStartTime(LocalDateTime.now().toString());

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        String id = user.getId();
        EventService eventService = new EventServiceImpl();

        try {
            eventService.addEventToUser(Integer.parseInt(id),event);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("schedule.jsp");

    }
}
