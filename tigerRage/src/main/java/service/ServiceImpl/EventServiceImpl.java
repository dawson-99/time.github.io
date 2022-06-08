package service.ServiceImpl;

import beans.Event;
import dao.Connect;
import dao.EventDao;
import dao.UserDao;
import dao.impl.EventDaoImpl;
import dao.impl.UserDaoImpl;
import service.EventService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class EventServiceImpl implements EventService {

    //通过userId查找User的所有事件
    public ArrayList<Event> queryAllEventbyUserId (int userId) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        return userDao.selectAllEventbyUserId(userId);
    }

    //添加事件
    public int addEventToUser(int userId, Event Event) throws SQLException {
        EventDao eventDao = new EventDaoImpl();
        return eventDao.addEventToUser(userId,Event);
    }

    //根据事件的id寻找事件
    public Event selectByEventId(int eventId) throws SQLException {
        EventDao eventDao = new EventDaoImpl();
        return eventDao.selectByEventId(eventId);
    }

    //更新事件
    public int updateEvent(Event event) throws SQLException {
        EventDao eventDao = new EventDaoImpl();
        int n = eventDao.updateEvent(event);
        return n;
    }

    //完成事件
    public int completeEvent(int eventId) throws SQLException {
        EventDao eventDao = new EventDaoImpl();
        return eventDao.completeEvent(eventId);
    }

}
