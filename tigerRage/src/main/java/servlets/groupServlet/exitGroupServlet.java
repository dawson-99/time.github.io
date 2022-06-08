package servlets.groupServlet;

import beans.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.GroupService;
import service.ServiceImpl.GroupServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

public class exitGroupServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           String groupId = req.getParameter("groupId");
           HttpSession session = req.getSession();
           User user = (User)session.getAttribute("user");
           GroupService groupService = new GroupServiceImpl();
           int n = 0;
        try {
             n = groupService.deleteUserFromGroup(Integer.parseInt(user.getId()),Integer.parseInt(groupId));
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
