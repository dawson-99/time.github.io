package dao;


import beans.Event;
import beans.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDao {


    //通过userId和password来查询
    public User queryUserByUserIdAndPassword(String userId, String password) throws SQLException;

    //更新用户信息
    public int updateUser(User user) throws SQLException;

    //通过userId来查询用户
    public User queryUserByUserId(String userId) throws SQLException;

    //添加用户
    public int addUser(User user) throws SQLException;

    //通过用户Id查找用户的事件
    public ArrayList<Event> selectAllEventbyUserId (int userId) throws SQLException;

    //邀请好友
    public int addFriend(String friend1Id, String friend2Id) throws SQLException;

    //查询好友
    public ArrayList<User> queryFriend(String userId) throws SQLException;


}
