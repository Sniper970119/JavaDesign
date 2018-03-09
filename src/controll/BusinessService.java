package controll;

import bean.Order;
import bean.User;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.org.apache.xpath.internal.operations.Or;
import dao.OrderDao;
import dao.UserDao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Created by Haitao on 2017/6/9 0009.
 */
public class BusinessService {

    private UserDao userDao = new UserDao();
    private OrderDao orderdao = new OrderDao();

    public String serviceId;


    //注册用户
    public User registUser(String username, String password) {

        Boolean succ;
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUsername(username);
        user.setPassword(password);
        user.setMoney(0);
        user.setRelease_order(null);
        user.setProcessing_order(null);
        succ = userDao.save(user);

        if(succ==true){
            return user;
        }

        return null;
    }

    //登录
    public User loginUser(String username, String password) {
        User user = null;
        if (username != null && password != null) {

            return userDao.login(username, password);

        }
        return null;

    }


    //根据用户名修改密码
    public boolean retrievePasswordBuUsername(String username,String password) {
        User user = userDao.findname(username);
        Boolean succ;
        if (user != null) {
            user.setPassword(password);
            succ =userDao.update(user);
            if(succ==true){
                return  true;
            }
        }
        return false;
    }

    //根据id找到用户然后修改他的密码
    public void retrievePassword(User user,String newPassword) {
        if (user != null) {
            user.setPassword(newPassword);
            userDao.update(user);
        }
    }

    //充值
    public boolean rechargeMoney(User user ,Double money) {

        if (user != null) {
            double moneyNow = user.getMoney();
            user.setMoney(money + moneyNow);
            userDao.update(user);
            return  true;
        }
        return false;
    }

    //提现
    public boolean withdrowMoney(User user,Double money) {
        if (user != null) {
            double moneyNow = user.getMoney();
            if (moneyNow >= money && money > 0) {
                user.setMoney(moneyNow - money);
                userDao.update(user);
                return true;
            } else {
               return false;
            }
        }
        return false;
    }

    //发布订单
    public Order releaseOrder(User user, String ordername, double reward) {
        Order order = new Order();
        String userid = user.getId();
        order.setId(UUID.randomUUID().toString());

        user.setRelease_order(order.getId());
        //这里要判断 佣金 要大于0  但我想都在view传之前进行判断
        user.setMoney(user.getMoney() - reward);

        order.setOrderName(ordername);
        order.setReward(reward);
        order.setState("未接单");
        order.setRelease_id(userid);
        orderdao.save(order);
        userDao.update(user);
        return order;
    }


    //更改订单状态
    public boolean updateOrderState(User user, String orderId, String state) {
        Order order = orderdao.find(orderId);
        String userid = user.getId();
        //感觉这里还需要一个权限判断  以后写需要再回来加
        order.setState(state);
        orderdao.update(order);
        return true;
    }

    //接受订单
    public boolean receiveOrder(User user, String orderId) {
        Order order = orderdao.find(orderId);
        String userid = user.getId();
        order.setReceive_id(userid);
        order.setState("已接单");
        user.setProcessing_order(orderId);
        userDao.update(user);
        orderdao.update(order);
        return true;

    }

    //删除订单
    public boolean delOrder(User user, String orderId) {
        Order order = orderdao.find(orderId);
        if(order.getState().equals("未接单")||order.getState().equals("已完成")){
            String orderID = order.getRelease_id();
            String  userID = user.getId();
            if(userID.equals(orderID)) {
                user.setProcessing_order(null);
                user.setMoney(user.getMoney() + order.getReward());
                userDao.update(user);
                orderdao.del(order);
                return true;
            }else{
                return false;
            }
        }
        else{
            return  false;
        }
    }

    //完成订单
    public boolean finishOrder(User user, String orderId) {
        Order order = orderdao.find(orderId);

        String orderID = order.getReceive_id();
        String  userID = user.getId();


        if(userID.equals(orderID)){
            double money = user.getMoney();
            user.setMoney(money + order.getReward());
            user.setProcessing_order(null);
            order.setState("已完成");
            orderdao.update(order);
            userDao.update(user);
            return true;
        }else{
            return false;
        }

    }


    //这个方法是拿到一个状态为state的所有订单的列表
    public ArrayList<Order> getStateList(String state) {
        if (state == null) {
            return null;
        }
        ArrayList<Order> list = orderdao.getList();
        ArrayList<Order> stateList = new ArrayList<Order>();
        //int number = businesslist.size();
        for (Order o : list) {
            if (state.equals(o.getState())) {
                stateList.add(o);
            }
        }
        return stateList;
    }


    //拿到所有的release_id 列表
    public ArrayList<Order> getRelease_idList(String release_id) {
        if (release_id == null) {
            return null;
        }
        ArrayList<Order> list = orderdao.getList();
        ArrayList<Order> release_idList = new ArrayList<Order>();
        for (Order o : list) {
            if (release_id.equals(o.getRelease_id())) {
                release_idList.add(o);
            }
        }
        return release_idList;
    }

    //receive_id 查找List
    public ArrayList<Order> getReceive_idList(String receive_id) {
        if (receive_id == null) {
            return null;
        }
        ArrayList<Order> list = orderdao.getList();
        ArrayList<Order> receive_idList = new ArrayList<Order>();
        for (Order o : list) {
            if (receive_id.equals(o.getReceive_id())) {
                receive_idList.add(o);
            }
        }
        return receive_idList;
    }
}



