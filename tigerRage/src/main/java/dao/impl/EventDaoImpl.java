package dao.impl;

import beans.Event;
import dao.Connect;
import dao.EventDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventDaoImpl implements EventDao {

    public int addEventToUser(int userId, Event event) throws SQLException {

        Connection conn = null;
        java.sql.Statement stmt = null;

        conn = new Connect().getConnect();


        String sql;//执行语句

        String title = event.getTitle();
        String startTime = event.getStartTime();
        String endTime = event.getEndTime();
        String text = event.getDescription();
        int situation = event.getSituation();

        sql = " INSERT INTO EVENT (title,start_time,end_time,text,situation) VALUES(?,?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,title);
        ps.setString(2,startTime);
        ps.setString(3,endTime);
        ps.setString(4,text);
        ps.setString(5, String.valueOf(situation));

        int n = ps.executeUpdate();
        System.out.println("成功添加" + n + "个事件");



        stmt = conn.createStatement();

        //获取上一个添加事件的id
        sql = "SELECT LAST_INSERT_ID()";

        ResultSet rs = stmt.executeQuery("select last_insert_id() as last_id from event");
        rs.next();
        String lastEventId = rs.getString("last_id");
        //将用户事件表更新，保持完整一致性
        sql = "INSERT INTO RELATE_U_E (U_ID,E_ID) VALUES ('" + userId + "','" + lastEventId + "')";

        int m = stmt.executeUpdate(sql);
        stmt.close();
        conn.close();

        if (n > 0 && m > 0) {
            return n;
        }

        return 0;

    }

    public Event selectByEventId(int eventId) throws SQLException {

        Connection conn = null;
        java.sql.Statement stmt = null;

        conn = new Connect().getConnect();
        String sql;
        sql = "SELECT * FROM EVENT WHERE ID = '" + eventId +"'";
        stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        rs.next();
        Event event = new Event();

        event.setId(Integer.parseInt(rs.getString("id")));
        event.setTitle(rs.getString("title"));
        event.setSituation(Integer.parseInt(rs.getString("situation")));
        event.setStartTime(rs.getString("start_time"));
        event.setEndTime(rs.getString("end_time"));
        event.setDescription(rs.getString("text"));

        return event;



    }

    public int updateEvent(Event event) throws SQLException {
        Connection conn = null;
        java.sql.Statement stmt = null;

        conn = new Connect().getConnect();

        String sql;//执行语句

        String title = event.getTitle();
        String startTime = event.getStartTime();
        String endTime = event.getEndTime();
        String text = event.getDescription();
        String situation = String.valueOf(event.getSituation());
        String id = String.valueOf(event.getId());

        sql = " UPDATE EVENT SET TITLE = ?, START_TIME = ?, END_TIME = ?, TEXT = ?, SITUATION = ? WHERE id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,title);
        ps.setString(2,startTime);
        ps.setString(3,endTime);
        ps.setString(4,text);
        ps.setString(5,situation);
        ps.setString(6,id);

        int n = ps.executeUpdate();

        System.out.println("成功更新" + n + "个事件");
        return n;
    }

    public int completeEvent(int eventId) throws SQLException {
        Connection conn = null;
        java.sql.Statement stmt = null;

        conn = new Connect().getConnect();

        String sql;//执行语句

        sql = " UPDATE EVENT SET situation = 2 WHERE id = '" + eventId +"'";

        int n = conn.createStatement().executeUpdate(sql);

        System.out.println("成功把" + n + "个事件完成");
        return n;

    }


}
