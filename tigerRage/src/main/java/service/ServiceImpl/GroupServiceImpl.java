package service.ServiceImpl;

import beans.Event;
import beans.User;
import beans.Group;
import dao.GroupDao;
import dao.impl.GroupDaoImpl;
import service.GroupService;

import java.sql.SQLException;
import java.util.ArrayList;

public class GroupServiceImpl implements GroupService {

    public ArrayList<User> queryUsers(int groupId) throws SQLException {
        GroupDao groupDao = new GroupDaoImpl();
        ArrayList<User> users = groupDao.queryUsers(groupId);
        return users;
    }

    public ArrayList<Event> queryEvent(int groupId) throws SQLException {
        ArrayList<Event> events;
        GroupDao groupDao = new GroupDaoImpl();
        events = groupDao.queryEvents(groupId);
        return events;
    }

    public int deleteUserFromGroup(int userId, int groupId) throws SQLException {
        GroupDao groupDao = new GroupDaoImpl();
        return groupDao.deleteUserFormGroup(groupId,userId);
    }


    public int deleteEventFromGroup(int eventId, int groupId) throws SQLException {
        GroupDao groupDao = new GroupDaoImpl();
        return groupDao.deleteEventFormGroup(groupId,eventId);
    }

    public int addUserToGroup(int userId, int groupId) throws SQLException {
        GroupDao groupDao = new GroupDaoImpl();
        return groupDao.addUserToGroup(groupId,userId);
    }

    public int addEventToGroup(String eventId, int groupId) throws SQLException {
        GroupDao groupDao = new GroupDaoImpl();
        return groupDao.addEventToGroup(groupId,eventId);
    }

    public ArrayList<Group> queryGroupsByUserId(int userId) throws SQLException {
        GroupDao groupDao = new GroupDaoImpl();
        return groupDao.selectGroupsByUserId(userId);
    }

    public ArrayList<User> queryUserByGroupId(int groupId) throws SQLException {

        ArrayList<User> users;
        GroupDao groupDao = new GroupDaoImpl();
        users = groupDao.queryUsers(groupId);
        return users;
    }

    public ArrayList<Event> queryEventByGroupId(int groupId) throws SQLException {

        ArrayList<Event> events;
        GroupDao groupDao = new GroupDaoImpl();
        events = groupDao.queryEvents(groupId);
        return events;
    }

    public Group queryGroupByGroupId(String groupId) throws SQLException {
         GroupDao groupDao = new GroupDaoImpl();
         return groupDao.queryGroupByGroupId(groupId);
    }

    public int deleteGroup(String groupId, String userId) throws SQLException {
        GroupDao groupDao = new GroupDaoImpl();
        return groupDao.deleteGroup(userId,groupId);
    }
}
