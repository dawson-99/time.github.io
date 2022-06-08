package service;


import beans.Event;
import beans.User;
import beans.Group;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface GroupService {

    //输入群组号，返回该群的所有人员
    ArrayList<User> queryUsers(int groupId) throws SQLException;
    //输入群组号，返回该群的所有事件
    ArrayList<Event> queryEvent(int groupId) throws SQLException;
    //输入群组号和id号，从群中删除人员
    int deleteUserFromGroup(int userId, int groupId) throws SQLException;

    int deleteEventFromGroup(int EventId, int groupId) throws SQLException;

    int addUserToGroup(int userId, int groupId) throws SQLException;

    public int addEventToGroup(String eventId, int groupId) throws SQLException;

    ArrayList<Group> queryGroupsByUserId(int id) throws SQLException;

    ArrayList<User> queryUserByGroupId(int id) throws SQLException;

    ArrayList<Event> queryEventByGroupId(int groupId) throws SQLException;

    Group queryGroupByGroupId(String groupId) throws SQLException;

    int deleteGroup(String groupId,String userId) throws SQLException;
}
