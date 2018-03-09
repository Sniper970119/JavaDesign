package dao;

import bean.Order;
import bean.User;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;


/**
 * Created by admin on 2017/6/11.
 */
public class OrderDao {

    Connection conn;
    PreparedStatement stmt;
    ResultSet rs;

    Order order = new Order();

    //保存数据
    public boolean save(Order order){
        try {
            conn= DriverManager.getConnection("jdbc:derby:dailian;create=true");

            stmt=conn.prepareStatement("INSERT INTO APP.ORDERS (id,ORDERNAME,REWARD,STATE,RELEASE_ID,RECEIVE_ID) values (?,?,?,?,?,?)");

            stmt.setString(1,order.getId());
            stmt.setString(2,order.getOrderName());
            stmt.setDouble(3,order.getReward());
            stmt.setString(4,order.getState());
            stmt.setString(5,order.getRelease_id());
            stmt.setString(6,order.getReceive_id());
            stmt.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            release(conn,stmt,rs);
        }
    }

    //更新数据
    public boolean update(Order order){
        try {
            conn= DriverManager.getConnection("jdbc:derby:dailian;create=true");
            stmt = conn.prepareStatement("update APP.ORDERS set APP.ORDERS.ORDERNAME=?,APP.ORDERS.REWARD=?,"+
                                                    "APP.ORDERS.STATE=?,APP.ORDERS.RELEASE_ID=? ,RECEIVE_ID=? where id=?");

            stmt.setString(6,order.getId());
            stmt.setString(1,order.getOrderName());
            stmt.setDouble(2,order.getReward());
            stmt.setString(3,order.getState());
            stmt.setString(4,order.getRelease_id());
            stmt.setString(5,order.getReceive_id());
            stmt.execute();
            return  true;

        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            release(conn, stmt, rs);
        }
    }

    //删除数据
    public boolean del(Order order){
        try {
            conn= DriverManager.getConnection("jdbc:derby:dailian;create=true");
            stmt = conn.prepareStatement(" DELETE FROM APP.ORDERS WHERE id=?");
            stmt.setString(1,order.getId());//第一个问号填id
            stmt.execute();
            return  true;

        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            release(conn, stmt, rs);
        }
    }

    //查询数据（list）
    public ArrayList<Order> getList(/*String condition,String judgment*/){
        //condition  查询条件（比如state）  judgment 判断条件（比如‘已完成’）
        try {
            conn = DriverManager.getConnection("jdbc:derby:dailian;create=true");
            stmt = conn.prepareStatement("select * from APP.ORDERS");

            rs = stmt.executeQuery();
            ArrayList<Order> list = new ArrayList<Order>();
                    Order order = null;

            while (rs.next()) {
                order = new Order();
                order.setId(rs.getString("id"));
                order.setOrderName(rs.getString("OrderName"));
                order.setReward(rs.getDouble("REWARD"));
                order.setState(rs.getString("STATE"));
                order.setRelease_id(rs.getString("RELEASE_ID"));
                order.setReceive_id(rs.getString("RECEIVE_ID"));
                list.add(order);

            }
            return list;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            release(conn, stmt, rs);
        }

    }

    //根据id查找订单
    public Order find(String orderId) {
        try {
            Order order=new Order();
            order.setId(orderId);
            conn= DriverManager.getConnection("jdbc:derby:dailian;create=true");
            stmt = conn.prepareStatement("SELECT * FROM APP.ORDERS WHERE id=?");
            stmt.setString(1,order.getId());
            rs=stmt.executeQuery();
            if(rs.next()) {

                order.setId(rs.getString("id"));
                order.setOrderName(rs.getString("ORDERNAME"));
                order.setReward(rs.getDouble("REWARD"));
                order.setState(rs.getString("STATE"));
                order.setRelease_id(rs.getString("Release_id"));
                order.setReceive_id(rs.getString("Receive_id"));
                    return order;
            }
        }catch (SQLException e) {
            e.printStackTrace();

        }finally {
            release(conn, stmt, rs);
        }
        return  null;
    }

    //空间回收
    public void release(Connection conn,PreparedStatement stmt,ResultSet rs){
        try {
            if(conn!=null){//释放资源的过程
                conn.close();
            }
            if(stmt!=null){
                stmt.close();
            }
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

