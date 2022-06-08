package service;


import beans.Event;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface EventService {

    //输入user的ID，返回User参与的所有事件
    public ArrayList<Event> queryAllEventbyUserId(int userId) throws SQLException;
    //给用户添加事件，添加事件的时候，请不要输入id，数据库会自动给出
    public int addEventToUser(int userId, Event Event) throws SQLException;
    //输入事件的id，将返回事件
    public Event selectByEventId(int eventId) throws SQLException;
    //更新事件，一定确认id，id作为唯一标识符进行更新
    public int updateEvent(Event event) throws SQLException;
    //将事件的situation表示修改为完成2
    public int completeEvent(int eventId) throws SQLException;


}
