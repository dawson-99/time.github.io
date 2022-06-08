package dao.impl;

import beans.Event;
import beans.User;
import dao.Connect;
import dao.UserDao;

import java.sql.*;
import java.util.ArrayList;

public class UserDaoImpl implements UserDao {



    //通过userId和password来查询
    public User queryUserByUserIdAndPassword(String userId, String password) throws SQLException {
        Connection conn = null;
        java.sql.Statement stmt = null;

        conn = new Connect().getConnect();
        stmt = conn.createStatement();

        String sql;//执行语句
        sql = "SELECT * FROM USER Where " + userId + "= id AND " + password + " = PASSWORD";

            ResultSet rs = stmt.executeQuery(sql);


            System.out.println("正在查询登陆用户...");
            User user = new User();
            if (rs.next()) {
                user.setId(rs.getString("id"));
                user.setNickName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setSex(rs.getString("sex"));
                user.setTel(rs.getString("tel"));
                user.setText(rs.getString("text"));

                System.out.println("查询到了用户");

                rs.close();
                stmt.close();
                conn.close();

                return user;
            } else {
                System.out.println("该用户不存在");
                return null;
            }

    }

    //保存用户信息
    public int updateUser(User user) throws SQLException {
        Connection conn = null;
        java.sql.Statement stmt = null;

        conn = new Connect().getConnect();


        String sql;//执行语句
        String username = user.getNickName();
        String password = user.getPassword();
        String sex = user.getSex();
        String id = user.getId();
        String tel = user.getTel();
        String text = user.getText();

        sql = " UPDATE USER SET USERNAME = ?, PASSWORD = ?, SEX = ?, TEL = ?, TEXT = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,username);
        ps.setString(2,password);
        ps.setString(3,sex);
        ps.setString(4,tel);
        ps.setString(5,text);
        ps.setString(6,id);

        int n = ps.executeUpdate();
        System.out.println("成功更新用户" + n + "行");

        return n;
    }

    //通过userId和password来查询
    public User queryUserByUserId(String id) throws SQLException {

        Connection conn = null;
        java.sql.Statement stmt = null;

        conn = new Connect().getConnect();
        stmt = conn.createStatement();

        String sql;//执行语句
        sql = "SELECT * FROM USER Where " + id + "= ID";

        ResultSet rs = stmt.executeQuery(sql);

        User user = new User();
        if(rs.next()) {
            user.setId(rs.getString("id"));
            user.setNickName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setSex(rs.getString("sex"));
            user.setTel(rs.getString("tel"));
            user.setText(rs.getString("text"));
            System.out.println("这里是userDao 的 queryUser 通过id找到了用户");
            rs.close();
            stmt.close();
            conn.close();
            return user;
        } else {
            System.out.println("该用户不存在");
            rs.close();
            stmt.close();
            conn.close();
            return null;
        }



    }

    // 添加用户
    public int addUser(User user) throws SQLException {

        Connection conn = new Connect().getConnect();
        java.sql.Statement stmt = null;
        System.out.println("进入创建账号dao");


        String sql;//执行语句
        String username = user.getNickName();
        String password = user.getPassword();
        String sex = user.getSex();
        String id = user.getId();
        String tel = user.getTel();
        String text = user.getText();


        try {
            sql = " INSERT INTO USER (username,password,sex,tel,text,id) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,sex);
            ps.setString(4,tel);
            ps.setString(5,text);
            ps.setString(6,id);

            int n = ps.executeUpdate();
            System.out.println("成功添加用户" + n + "行");
            return n;
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("这里是userDao的addUser方法,遇到错误");
            return 0;
        }

    }

    //通过用户的ID来查找用户的所有事件
    public ArrayList<Event> selectAllEventbyUserId (int userId) throws SQLException {

        ArrayList<Event> events = new ArrayList<>();

        Connection conn = null;
        java.sql.Statement stmt = null;

        conn = new Connect().getConnect();
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT * " +
                "FROM EVENT " +
                "WHERE EVENT.ID IN" +
                "(SELECT E_ID " +
                "FROM RELATE_U_E " +
                "WHERE U_ID = "
                + userId + " AND SITUATION != 2" + ")";

        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("正在查询用户事件...");
        while(rs.next()) {
            Event event = new Event();
            event.setDescription(rs.getString("text"));
            event.setEndTime(rs.getString("end_time"));
            event.setStartTime(rs.getString("start_time"));
            event.setId(Integer.parseInt(rs.getString("id")));
            event.setSituation(Integer.parseInt(rs.getString("situation")));
            event.setTitle(rs.getString("title"));
            events.add(event);
        }

        stmt.close();
        conn.close();

        return events;
    }

    public int addFriend(String friend1Id, String friend2Id) throws SQLException {
        Connection conn = new Connect().getConnect();
        System.out.println("进入添加好友dao");

        String sql;//执行语句

        //保证双向
        Statement statement = conn.createStatement();
        sql = "INSERT INTO RELATE_U_U (U1_ID,U2_ID) VALUES ('" + friend1Id + "','" + friend2Id + "')";
        int n = statement.executeUpdate(sql);
        sql = "INSERT INTO RELATE_U_U (U1_ID,U2_ID) VALUES ('" + friend2Id + "','" + friend1Id + "')";
        int m = statement.executeUpdate(sql);

        if ( n > 0 && m > 0) {
            System.out.println("成功添加好友");
            return 1;

        }
        System.out.println("添加好友失败");
        return 0;

    }

    public ArrayList<User> queryFriend(String userId) throws SQLException {

        Connection conn = new Connect().getConnect();
        java.sql.Statement stmt = null;
        System.out.println("进入查询好友dao");

        ArrayList<User> users = new ArrayList<>();

        stmt = conn.createStatement();
        String sql;//执行语句
        sql = "SELECT * FROM USER WHERE ID IN " +
                "(SELECT U2_ID FROM RELATE_U_U WHERE U1_ID = '"+ userId + "')";
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            String id = rs.getString("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String sex = rs.getString("sex");
            String tel = rs.getString("tel");
            String text = rs.getString("text");

            User user = new User();
            user.setPassword(password);
            user.setId(id);
            user.setTel(tel);
            user.setSex(sex);
            user.setNickName(username);
            user.setText(text);
            users.add(user);
        }

        System.out.println("查询完毕");
        return users;
    }



}
