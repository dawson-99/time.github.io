package service;


import beans.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserService {

    //登陆，传入用户id和密码
    public User login(int id, String password) throws SQLException;

    //注册用户，调用这个接口将会在数据库中添加用户，返回添加用户数
    public int register(User user) throws SQLException;

    //更新User的信息，传入一个User的参数，请不要修改id，id是作为判断的依据
    public int updateUser(User user) throws SQLException;

    //邀请好友
    public int addFriend(String friend1Id, String friend2Id) throws SQLException;

    //查询好友
    public ArrayList<User> queryFriend(String userId) throws SQLException;

}

