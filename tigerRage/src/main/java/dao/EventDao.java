package dao;

import beans.Event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface EventDao {

    //输入Event时，不需要设置event的主键，我会自动设置
    public int addEventToUser(int userId, Event event) throws SQLException;

    //根据事件的id寻找事件
    public Event selectByEventId(int eventId) throws SQLException;

    //更新事件
    public int updateEvent(Event Event) throws SQLException;

    //完成事件，使得事件的situation为2
    public int completeEvent(int eventId) throws SQLException;

}
