package test.dao; 

import bean.User;
import dao.UserDao;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.omg.PortableInterceptor.USER_EXCEPTION;

/** 
* UserDao Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 10, 2017</pre> 
* @version 1.0 
*/ 
public class UserDaoTest { 

    UserDao s = new UserDao();

    @Test
    public void testTest() throws Exception {
    //TODO: Test goes here...

    }


    @Test
    public void testSave() throws Exception {
        User user=new User();
        user.setId("123");
        user.setUsername("小白");
        user.setPassword("abc");
        user.setMoney(0);
        user.setRelease_order("001");
        user.setProcessing_order("001");
        s.save(user);
        User u=s.find("123");
        System.out.println(u);

        System.out.println(s);

        //TODO: Test goes here...
    }

    /**
    *
    * Method: find(String id)
    *
    */
    @Test
    public void testFind() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: login(String username, String password)
    *
    */
    @Test
    public void testLogin() throws Exception {
    //TODO: Test goes here...

        User user= s.login("11","11");
        if(user == null){
            System.out.println("flase");
        }else{
            System.out.println("true");
        }
    }

    /**
    *
    * Method: del(String id)
    *
    */
    @Test
    public void testDel() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: update(User user)
    *
    */
    @Test
    public void testUpdate() throws Exception {
    //TODO: Test goes here...

        User u = new User();
        u.setId("00000000OX1");
        u.setUsername("159");
        u.setPassword("abcd");
        u.setProcessing_order("001");
        u.setRelease_order("001");
        u.setMoney(100);
        //User user = s.update(u);
        //System.out.println(user);

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
