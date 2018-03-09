package test.dao; 

import bean.Order;
import dao.OrderDao;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.lang.reflect.Array;
import java.util.ArrayList;

/** 
* OrderDao Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 11, 2017</pre> 
* @version 1.0 
*/ 
public class OrderDaoTest { 

    OrderDao dao = new OrderDao();
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

@Test
public void test(){
    ArrayList<Order> i= dao.getList();
//    System.out.println(i.size());
    for(Order od:i){
        System.out.println(od);
    }
    //搞定

}
/** 
* 
* Method: save(Order order) 
* 
*/ 
@Test
public void testSave() throws Exception { 
//TODO: Test goes here...
    Order order = new Order();
    order.setId("0000ABCX002");
    order.setOrderName("网通一区");
    order.setReward(100);
    order.setRelease_id(null);
    order.setReceive_id(null);
    dao.save(order);
    System.out.println(order);
} 

/** 
* 
* Method: update(Order order) 
* 
*/ 
@Test
public void testUpdate() throws Exception { 
//TODO: Test goes here...
    Order order = new Order();
   Boolean order1 ;
    order.setId("0000ABCX001");
    order.setOrderName("网通一区");
    order.setReward(100);
    order.setRelease_id(null);
    order.setReceive_id(null);
    order1 = dao.update(order);
    System.out.println(order1);
}

/** 
* 
* Method: del(Order order) 
* 
*/ 
@Test
public void testDel() throws Exception { 
//TODO: Test goes here...
    Order order = new Order();
    Boolean order1;
    order.setId("ea269b9d-e7bd-498a-845f-5bccfbffaead");
//    order.setOrderName("网通一区");
//    order.setReward(100);
//    order.setRelease_id("null");
//    order.setReceive_id("null");
    order1 = dao.del(order);
    System.out.println(order1);

} 

/** 
* 
* Method: find(String orderId) 
* 
*/ 
@Test
public void testFind() throws Exception { 
//TODO: Test goes here...
    Order order = new Order();
    //order.setId("0000ABCX001");
    order =dao.find("0000ABCX001");
    System.out.println(order);
} 

/** 
* 
* Method: release(Connection conn, PreparedStatement stmt, ResultSet rs) 
* 
*/ 
@Test
public void testRelease() throws Exception { 
//TODO: Test goes here...

} 


} 
