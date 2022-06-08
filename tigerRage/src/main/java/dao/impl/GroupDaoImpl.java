package dao.impl;

import beans.Event;
import beans.Group;
import beans.User;
import dao.Connect;
import dao.GroupDao;

import java.sql.*;
import java.util.ArrayList;


public class GroupDaoImpl implements GroupDao {


    //通过groupId查询群里面的人员
    public ArrayList<User> queryUsers(int groupId) throws SQLException {

        ArrayList<User> users = new ArrayList<>();
        Connection conn = null;
        java.sql.Statement stmt = null;

        conn = new Connect().getConnect();
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT * " +
                "FROM USER " +
                "WHERE USER.ID IN" +
                "(SELECT U_ID " +
                "FROM RELATE_U_G " +
                "WHERE G_ID = "
        + groupId + ")";

        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()) {
            User user = new User();
            user.setPassword(rs.getString("password"));
            user.setSex(rs.getString("sex"));
            user.setTel(rs.getString("tel"));
            user.setNickName(rs.getString("username"));
            user.setId(rs.getString("id"));
            user.setText(rs.getString("text"));

            users.add(user);
        }

        stmt.close();
        conn.close();

        return users;
    }

    //通过groupId来查询群组事件
    public ArrayList<Event> queryEvents(int groupId) throws SQLException {

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
                "FROM RELATE_E_G " +
                "WHERE G_ID = "
                + groupId + ")";

        ResultSet rs = stmt.executeQuery(sql);

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

    //将用户拉入群组
    public int addUserToGroup(int groupId, int userId) throws SQLException {
        Connection conn = null;
        java.sql.Statement stmt = null;

        conn = new Connect().getConnect();
        stmt = conn.createStatement();
        String sql;

        sql = "INSERT INTO RELATE_U_G(U_ID, G_ID) VALUES ('" + userId + "','" + groupId + "')";

        int n = stmt.executeUpdate(sql);
        System.out.println("成功添加" + n + "个用户到群组");

        //保持一致性，群组中的事件也会被添加到该用户的事件列表中
        //先查询群组事件ID
        sql = "SELECT ID FROM EVENT WHERE ID IN" +
                "(SELECT E_ID FROM RELATE_E_G WHERE G_ID = '" + groupId +"')";

        ResultSet rs = stmt.executeQuery(sql);
        Statement statement2 = conn.createStatement();

        while(rs.next()) {
            sql = "INSERT INTO RELATE_U_E (U_ID,E_ID) VALUES " +
                    "('" + userId + "','" + rs.getString("id") +"')";
            statement2.executeUpdate(sql);
        }
        return n;
    }

    //将事件添加进入群组
    public int addEventToGroup(int groupId, String eventId) throws SQLException {

        Connection conn = null;
        java.sql.Statement stmt = null;
        java.sql.Statement stmt2 = null;

        conn = new Connect().getConnect();

//        sql = " INSERT INTO EVENT (title,start_time,end_time,text,situation) VALUES(?,?,?,?,?)";
//
//        PreparedStatement ps = conn.prepareStatement(sql);
//        ps.setString(1,title);
//        ps.setString(2,startTime);
//        ps.setString(3,endTime);
//        ps.setString(4,text);
//        ps.setString(5, String.valueOf(situation));
//
//        int n = ps.executeUpdate();
        stmt = conn.createStatement();
        stmt2 = conn.createStatement();

//        //获取上一个添加事件的id
//        sql = "SELECT LAST_INSERT_ID()";
//
//        ResultSet rs = stmt.executeQuery("select last_insert_id() as last_id from event");
//        rs.next();
//        String lastEventId = rs.getString("last_id");
//        //将群组事件表更新，保持完整一致性
//        sql = "INSERT INTO RELATE_E_G (G_ID,E_ID) VALUES ('" + groupId + "','" + lastEventId + "')";

        //将事件添加到用户事件列表
        String sql;
        sql = "INSERT INTO RELATE_E_G (G_ID,E_ID) VALUES ('" + groupId+ "','" + eventId +"')";
        int m = stmt.executeUpdate(sql);

        //先寻找群里面有哪些人
        sql = "SELECT U_ID FROM RELATE_U_G WHERE G_ID = '" + groupId + "'";
        ResultSet rs1 = stmt.executeQuery(sql);
        int n = 0;


        while(rs1.next()) {
            sql = "INSERT INTO RELATE_U_E (U_ID,E_ID) VALUES " +
                    "('" + rs1.getString("u_id") + "','" + eventId + "')";
            n = stmt2.executeUpdate(sql);
        }

        stmt.close();
        conn.close();

        if (n > 0 && m > 0) {
            System.out.println("成功添加" + m + "个事件到群组");
            return n;
        }
        System.out.println("添加事件到群组失败");
        return 0;
    }

    //从群中删除事件
    public int deleteEventFormGroup(int groupId, int eventId) throws SQLException {
        Connection conn = null;
        java.sql.Statement stmt = null;

        conn = new Connect().getConnect();
        stmt = conn.createStatement();
        String sql;

        sql = "DELETE FROM RELATE_E_G " +
                "WHERE G_ID = '" +
                groupId +"'" + "AND E_ID = '" +
                eventId + "'";

        int n = stmt.executeUpdate(sql);
        System.out.println("从群组中删除了" + n + "个事件");
        return n;
    }

    //从群主中删除人员
    public int deleteUserFormGroup(int groupId, int userId) throws SQLException {
        Connection conn = null;
        java.sql.Statement stmt = null;

        conn = new Connect().getConnect();
        stmt = conn.createStatement();
        String sql;

        sql = "DELETE FROM RELATE_U_G " +
                "WHERE G_ID = '" +
                groupId +"'" + "AND U_ID = '" +
                userId + "'";

        int n = stmt.executeUpdate(sql);
        System.out.println("从群组中删除了" + n + "个用户");

        //保持一致性，群中的任务也会从该用户事件列表中删除
        sql = "DELETE FROM RELATE_U_E WHERE E_ID IN " +
                "(SELECT E_ID FROM RELATE_E_G WHERE G_ID = '" + groupId +"') " +
                "AND U_ID = '" + userId + "'";
        stmt.executeUpdate(sql);
        return n;
    }

    //通过userId寻找user的所有群组
    public ArrayList<Group> selectGroupsByUserId(int userId) throws SQLException {

        ArrayList<Group> groups = new ArrayList<>();
        Connection conn = null;
        java.sql.Statement stmt = null;

        conn = new Connect().getConnect();
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT * " +
                "FROM GROUPP " +
                "WHERE GROUPP.ID IN" +
                "(SELECT G_ID " +
                "FROM RELATE_U_G " +
                "WHERE U_ID = "
                + userId + ")";

        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()) {
            Group group = new Group();
            group.setText(rs.getString("text"));
            group.setId(Integer.parseInt(rs.getString("id")));
            group.setName(rs.getString("name"));
            groups.add(group);
        }

        stmt.close();
        conn.close();

        return groups;
    }

    public int createGroup(int userId, Group group) throws SQLException {

        Connection conn = null;
        java.sql.Statement stmt = null;

        conn = new Connect().getConnect();
        stmt = conn.createStatement();

        String name = group.getName();
        String text = group.getText();
        String onwer = group.getOwner();

        String sql;



        sql = "INSERT INTO GROUPP (NAME,TEXT,ONWER) VALUES ('" + name + "','" + text + "','" + onwer + "')";

        int n = stmt.executeUpdate(sql);
        System.out.println("成功创建" + n + "个群组");
        return n;

    }

    public Group queryGroupByGroupId(String groupId) throws SQLException {
        Connection conn = null;
        java.sql.Statement stmt = null;

        conn = new Connect().getConnect();
        stmt = conn.createStatement();

        String sql;
        sql = "SELECT * FROM GROUPP WHERE ID = '" + groupId + "'";
        ResultSet rs = stmt.executeQuery(sql);

        rs.next();
        Group group = new Group();
        String id = rs.getString("id");
        String name = rs.getString("name");
        String text = rs.getString("text");
        String onwer = rs.getString("onwer");

        group.setName(name);
        group.setOwner(onwer);
        group.setText(text);
        group.setId(Integer.parseInt(id));

        return group;
    }

    public int deleteGroup(String userId, String groupId) throws SQLException {

        Connection conn = null;
        java.sql.Statement stmt = null;

        conn = new Connect().getConnect();
        stmt = conn.createStatement();
        java.sql.Statement stmt2 = conn.createStatement();

        String sql;
        //查询群组事件id
        sql = "SELECT ID FROM EVENT WHERE ID IN " +
                "(SELECT E_ID FROM RELATE_E_G " +
                "WHERE G_ID = '"+ groupId +"')";
        ResultSet rs = stmt.executeQuery(sql);

        //删除用户群组表
        sql = "DELETE FROM RELATE_U_G WHERE G_ID = '" + groupId + "'";
        int m = stmt2.executeUpdate(sql);
        //删除用户事件表
        while(rs.next()) {
            sql = "DELETE FROM RELATE_U_E " +
                    "WHERE E_ID = '" + rs.getString("id") + "', " +
                    "AND U_ID = '" + userId +"'";
            stmt2.executeUpdate(sql);
        }
        //删除群组事件表
        sql = "DELETE FROM RELATE_E_G WHERE G_ID = '" + groupId +"'";
        int n = stmt2.executeUpdate(sql);
        return 1;
    }





}
