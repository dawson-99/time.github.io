package dataBaseServlet;


import beans.Event;
import beans.Group;
import beans.User;
import dao.EventDao;
import dao.GroupDao;
import dao.UserDao;
import dao.impl.EventDaoImpl;
import dao.impl.GroupDaoImpl;
import dao.impl.UserDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.EventService;
import service.GroupService;
import service.ServiceImpl.EventServiceImpl;
import service.ServiceImpl.GroupServiceImpl;
import service.ServiceImpl.UserServiceImpl;
import service.UserService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


//此servlet为测试数据库设定，其他人别写
public class dataBaseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*
         *通过账号和密码来查询用户
         * 已测试，完成
         */
//        String id = req.getParameter("id");
//
//        String pass = req.getParameter("pass");
//
//        UserDao userDao = new UserDaoImpl();
//
//        try {
//            User user = userDao.queryUserByUserIdAndPassword(id,pass);
//            if (user != null) {
//                System.out.println("可以通过id和密码来查询数据库");
//                System.out.println("text:" + user.getText() );
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

          /*
           * 保存用户
           * 已测试，成功
           */
//        UserDao userDao = new UserDaoImpl();
//        User user = new User();
//        user.setId("123");
//        user.setText(" 2022更帅了");
//        user.setTel("123213213");
//        user.setNickName("dawson");
//        user.setSex("2");
//        user.setPassword("123");
//
//        try {
//            userDao.saveUser(user);
//            System.out.println("成功更新用户数据");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("更新用户数据失败！！！！");
//        }

         /*
          * 通过userId来查询
          * 已测试，完成
          */
//        UserDao userDao = new UserDaoImpl();
//        try {
//            User user = userDao.queryUserByUserId("123");
//            System.out.println(user.getText());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        /*
         * 添加用户
         * 已测试，完成
         */
//        UserDao userDao = new UserDaoImpl();
//        try {
//
//            User user = new User();
//           user.setId("123455421");
//           user.setText("我爱zrx");
//           user.setTel("123212213");
//           user.setNickName("zrx");
//           user.setSex("2");
//           user.setPassword("123213");
//
//           userDao.addUser(user);
//            System.out.println("这是servlet页面，成功添加用户");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

                /* 利用groupId得到群里面的人
                * 已测试，完成
                */
//        GroupDao groupDao = new GroupDaoImpl();
//        try {
//
//            ArrayList<User> users = groupDao.queryUsers(1);
//
//            for (int i = 0; i < users.size(); i++) {
//                System.out.println(users.get(i).getText());
//            }
//
//            System.out.println("这是servlet页面，正在得到群里面的人");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        /* 利用groupId得到群里面的事件
         * 已测试，完成
         */
//        GroupDao groupDao = new GroupDaoImpl();
//        try {
//
//            ArrayList<Event> events = groupDao.queryEvents(1);
//
//            for (int i = 0; i < events.size(); i++) {
//                System.out.println(events.get(i).getDescription());
//            }
//
//            System.out.println("这是servlet页面，正在得到群里面的事件");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        /* 将用户拉入群组
         * 已测试，完成
         */
//        GroupDao groupDao = new GroupDaoImpl();
//        try {
//
//            int n = groupDao.addUserToGroup(2,12343);
//
//            System.out.println("这是servlet页面，拉了" + n + "个人到群组");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        /* 将事件拉入群组
         * 已测试，完成
         */
//        GroupDao groupDao = new GroupDaoImpl();
//        try {
//
//            int n = groupDao.addEventToGroup(1,1);
//
//            System.out.println("这是servlet页面，拉了" + n + "个事件到群组");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        /* 群中删除事件
         * 已测试，完成
         */
//        GroupDao groupDao = new GroupDaoImpl();
//
//        int n = 0;
//        try {
//            n = groupDao.deleteEventFormGroup(1,1);
//            System.out.println("这是servlet页面，从群组中删除了" + n + "个事件");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        /* 群中删除人
         * 已测试，完成
         */
//        GroupDao groupDao = new GroupDaoImpl();
//
//        int n = 0;
//        try {
//            n = groupDao.deleteUserFormGroup(1,123);
//            System.out.println("这是servlet页面，从群组中删除了" + n + "个人");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        /* 通过userId查找用户的所有事件
         * 已测试，完成
         */
//        UserDao userDao = new UserDaoImpl();
//        try {
//            ArrayList<Event> events = userDao.selectAllEventbyUserId(123);
//            for (int i = 0; i < events.size(); i++) {
//                System.out.println(events.get(i).getDescription());
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


        /* 给user添加事件
         * 已测试，完成
         */
//        EventDao eventDao = new EventDaoImpl();
//        Event event = new Event();
//        event.setTitle("啦啦啦啦");
//        event.setDescription("爱情与忠诚");
//        event.setStartTime("123213123");
//        event.setEndTime("234324324");
//
//        try {
//            int n = eventDao.addEventToUser(123,event);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        /* 更新事件
         * 已测试，完成
         */
//        EventDao eventDao = new EventDaoImpl();
//        Event event = new Event();
//        event.setTitle("aaaaaa啦啦啦啦");
//        event.setDescription("傲慢与偏见");
//        event.setStartTime("123213123");
//        event.setEndTime("234324324");
//        event.setId(12);
//        try {
//            int n = eventDao.updateEvent(event);
//            System.out.println("更新了" + n + "条事件");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        /* 把事件设置为完成
         * 已测试，完成
         */
//        EventDao eventDao = new EventDaoImpl();
//        try {
//            int n = eventDao.completeEvent(10);
//            System.out.println("" + n + "条事件已设置为完成");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        /* 通过userId寻找用户的群
         * 已测试，完成
         */
//        GroupDao groupDao = new GroupDaoImpl();
//        try {
//            ArrayList<Group> groups = groupDao.selectGroupsByUserId(123);
//            for (int i = 0; i < groups.size(); i++) {
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        /*
         *
         * ----------------------------以下开始对Service接口进行逐个测试
         * 以下几个实例为测试实例
         */

        Event event = new Event();
        event.setTitle("我爱zrx");
        event.setDescription("热爱与忠诚");
        event.setStartTime("2022：03：18");
        event.setEndTime("2122：03：18");
        event.setId(12);

        User user = new User();
        user.setId("1314520");
        user.setText("我爱zrx");
        user.setTel("19999999");
        user.setNickName("zrx");
        user.setSex("2");
        user.setPassword("1314");

        EventService eventService = new EventServiceImpl();
        UserService userService = new UserServiceImpl();
        GroupService groupService = new GroupServiceImpl();

        try {
//            eventService.addEventToUser(123,event); 检查正常，完整性一致正常

//            eventService.completeEvent(7); 检查正常

//            Event event1 = eventService.selectByEventId(1);
//            System.out.println(event1.getTitle()); 检查正常

//            eventService.updateEvent(event); 检查正常

//             ArrayList<Event> events = eventService.selectAllEventbyUserId(123);
//             for (int i = 0;i < events.size(); i++) {
//             System.out.println(events.get(i).getTitle()); 检查正常


//            User user1 = userService.login(1234, String.valueOf(123213));
//            System.out.println(user1.getNickName()); 检查正常

//              int m = userService.register(user);
//              int n = userService.updateUser(user);
//              System.out.println(m); 修改1个bug，检查正常

//            System.out.println(groupService.addEventToGroup(event,1));检查正常，一致性正常

//            groupService.addUserToGroup(123,1);检查正常

//            groupService.deleteEventFromGroup(2,1);检查正常

//            groupService.deleteUserFromGroup(123,1);检查正常

//              ArrayList<Group> groups = groupService.selectGroupsByUserId(1234);
//              for (int i = 0; i < groups.size(); i++) {
//                  System.out.println(groups.get(i).getName());
//              } 检查正常

//            ArrayList<Event> events = groupService.queryEvent(1);
//            for (int i = 0; i < events.size(); i++) {
//                  System.out.println(events.get(i).getTitle());
//              } 检查正常

//            ArrayList<User> users = groupService.selectUserByGroupId(2);
//            for (int i = 0; i < users.size(); i++) {
//                  System.out.println(users.get(i).getText());
//              } 检查正常

//            ArrayList<Event> events = groupService.selectEventByGroupId(1);
//            for (int i = 0; i < events.size(); i++) {
//                  System.out.println(events.get(i).getDescription());
//              } 检查正常

            ArrayList<User> users = groupService.queryUsers(1);
            for (int i = 0; i < users.size(); i++) {
                  System.out.println(users.get(i).getText());
              } //检查正常






        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
