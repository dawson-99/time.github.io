package service.ServiceImpl;

import beans.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserServiceImpl implements service.UserService {

    public User login(int id, String password) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.queryUserByUserIdAndPassword(String.valueOf(id),password);
        return user;
    }

    public int register(User user) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        return userDao.addUser(user);
    }

    public int updateUser(User user) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        return userDao.updateUser(user);
    }

    //邀请好友
    public int addFriend(String friend1Id, String friend2Id) throws SQLException{
        UserDao userDao = new UserDaoImpl();
        return userDao.addFriend(friend1Id,friend2Id);
    }

    //查询好友
    public ArrayList<User> queryFriend(String userId) throws SQLException{
        UserDao userDao = new UserDaoImpl();
        return userDao.queryFriend(userId);
    }

}
