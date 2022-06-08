package servlets.groupServlet;

import beans.Group;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.GroupService;
import service.ServiceImpl.GroupServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

public class dissolveGroupServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userId = (String)session.getAttribute("userId");
        String groupId = req.getParameter("groupId");

        GroupService groupService = new GroupServiceImpl();
        //进行所属者检查
        Group group = null;
        try {
            group = groupService.queryGroupByGroupId(groupId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(group.getOwner().equals(userId)) {
            try {
                groupService.deleteGroup(groupId,userId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
              resp.sendRedirect("error.jsp");
        }

    }
}
