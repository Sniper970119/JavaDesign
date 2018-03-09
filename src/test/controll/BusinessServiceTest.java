package test.controll; 

import bean.Order;
import controll.BusinessService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;

/**
* BusinessService Tester.
*
* @author <Authors name>
* @since <pre>六月 12, 2017</pre>
* @version 1.0
*/
public class BusinessServiceTest {

@Before
public void before() throws Exception {
}

@After
public void after() throws Exception {
}

/**
*
* Method: registUser(String username, String password)
*
*/
@Test
public void testRegistUser() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: loginUser(String username, String password)
*
*/
@Test
public void testLoginUser() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: retrievePassword(String newPassword)
*
*/
@Test
public void testRetrievePassword() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: rechargeMoney(float money)
*
*/
@Test
public void testRechargeMoney() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: withdrowMoney(float money)
*
*/
@Test
public void testWithdrowMoney() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: releaseOrder(User user, String ordername, double reward)
*
*/
@Test
public void testReleaseOrder() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: updateOrderState(User user, String orderId, String state)
*
*/
@Test
public void testUpdateOrderState() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: receiveOrder(User user, String orderId)
*
*/
@Test
public void testReceiveOrder() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: delOrder(User user, String orderId)
*
*/
@Test
public void testDelOrder() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: finishOrder(User user, String orderId)
*
*/
@Test
public void testFinishOrder() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: orderList()
*
*/
@Test
public void testOrderList() throws Exception {
//TODO: Test goes here...
    BusinessService s=new BusinessService();
    ArrayList<Order> ls=s.getStateList("已完成");
    //打印出所有状态为null的订单 OK

    for (Order o:ls){
        System.out.println(o);
    }

} 


} 
