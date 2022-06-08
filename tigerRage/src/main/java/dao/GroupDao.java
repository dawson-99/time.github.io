package dao;



import beans.Event;
import beans.Group;
import beans.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface GroupDao {


    public ArrayList<User> queryUsers(int groupId) throws SQLException;

    public ArrayList<Event> queryEvents(int groupId) throws SQLException;

    public int addUserToGroup(int groupId, int userId) throws SQLException;

    public int addEventToGroup(int groupId, String eventId) throws SQLException;

    public int deleteUserFormGroup(int groupId, int userId) throws SQLException;

    public int deleteEventFormGroup(int groupId, int eventId) throws SQLException;

    public ArrayList<Group> selectGroupsByUserId(int userId) throws SQLException;

    public int createGroup(int userId, Group group) throws SQLException;

    public Group queryGroupByGroupId(String groupId) throws SQLException;

    public int deleteGroup(String userId, String groupId) throws SQLException;

}
