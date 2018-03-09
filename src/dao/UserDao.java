package dao;

import bean.User;

import java.sql.*;

/**
 * Created by Haitao on 2017/6/9 0009.
 */
public class UserDao {

    Connection conn;
    PreparedStatement stmt;
    ResultSet rs;

    public void test() {
        try {
            conn = DriverManager.getConnection("jdbc:derby:daiLian;create=true");
            stmt = conn.prepareStatement("select * from users");//之前这是userKu
            //这个地方直接查userKu中有没有帐号是username且密码是password的记录.
            rs = stmt.executeQuery();
            //这里如果rs不是空的就会返回一个true作为确认


            while (rs.next()) {

                String username = rs.getString("username");
                //String id = rs.getString("id");
                String money = rs.getString("money");
                String password = rs.getString("password");
                System.out.print(username + "|");
                //System.out.print(id + "|");
                System.out.print(password + "|");
                System.out.println(money + "|");


            }


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("找不到表");
        } finally {
            //这里无论是否找到记录.都要释放掉占用的资源

            try {
                if (conn != null) {//释放资源的过程
                    conn.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }


    //这里需要写的方法分别有
    //将一个User对象存入数据库.

    //注册
    public  boolean save(User user){
        try {
            conn= DriverManager.getConnection("jdbc:derby:dailian;create=true");
            stmt=conn.prepareStatement("INSERT INTO users (id,username,password,money) values (?,?,?,?)");
            //这里在新建用户时只能添加id 名字 密码 和金钱这几个属性.不管正在处理和发布的订单
            stmt.setString(1,user.getId());//第一个问号填id
            stmt.setString(2,user.getUsername());
            stmt.setString(3,user.getPassword());
            stmt.setDouble(4,user.getMoney());
            //设置好了以后运行
            stmt.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }finally {
            release(conn,stmt,rs);
        }

    }


    //根据用户id查询用户.返回值是对应的用户,没有对应的用户时返回null
    //再写一个
    //按照id查找
    public User find(String id){

        try {
            conn= DriverManager.getConnection("jdbc:derby:dailian;create=true");

            stmt=conn.prepareStatement("SELECT * FROM users where id=?");
            stmt.setString(1,id);

            //进行查询操作
            rs=stmt.executeQuery();

            User user=null;

            if(rs.next()) {
                //其实这里我不知道怎么样才能知道有没有查到数据,所以用笨方法.如果有更好的方法的话可以替代掉
                if (rs.getObject("username") != null) {
                    user=new User();
                    //把user的属性设置为查到的值
                    user.setId(rs.getString("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setMoney(rs.getFloat("money"));
                    user.setProcessing_order(rs.getString("processing_order"));
                    user.setRelease_order(rs.getString("release_order"));
                }
            }

            //将封装后的user拿回去.下面的login操作也类似,这样就可以解决登录后显示的问题了
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            release(conn,stmt,rs);
        }


    }

    public User findname(String username){

        try {
            conn= DriverManager.getConnection("jdbc:derby:dailian;create=true");

            stmt=conn.prepareStatement("SELECT * FROM users where USERNAME=?");
            stmt.setString(1,username);

            //进行查询操作
            rs=stmt.executeQuery();

            User user=null;

            if(rs.next()) {
                //其实这里我不知道怎么样才能知道有没有查到数据,所以用笨方法.如果有更好的方法的话可以替代掉
                if (rs.getObject("username") != null) {
                    user=new User();
                    //把user的属性设置为查到的值
                    user.setId(rs.getString("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setMoney(rs.getFloat("money"));
                    user.setProcessing_order(rs.getString("processing_order"));
                    user.setRelease_order(rs.getString("release_order"));
                }
            }

            //将封装后的user拿回去.下面的login操作也类似,这样就可以解决登录后显示的问题了
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            release(conn,stmt,rs);
        }


    }
    //--------下面的代码还没写.---------------------------------------------------------------------------

    //根据帐密登录,只有帐密都匹配时才会正确登录,返回值是对应的用户对象,错误时返回null
    public User login(String username, String password) {

        //sql如下:
        //"SELECT * FROM users where username=? and password=?"
        User user = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby:dailian;create=true");

            stmt = conn.prepareStatement("SELECT * FROM APP.USERS where username='" + username + "' and password='" + password + "'");
            rs = stmt.executeQuery();
            user = null;

            if (rs.next()) {

                user = new User();
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setMoney(rs.getFloat("money"));
                user.setProcessing_order(rs.getString("processing_order"));
                user.setRelease_order(rs.getString("release_order"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            release(conn, stmt, rs);
        }
        return user;
    }

    //根据用户id删除用户
    public boolean del(String id){

        try{
            conn = DriverManager.getConnection("jdbc:derby:dailian;create=true");

            stmt = conn.prepareStatement("DELETE * FROM users WHERE id=?");
            User user =null;
            stmt.setString(1,user.getId());//第一个问号填id
            stmt.execute();
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
            return false;

        }finally {
            release(conn,stmt,rs);
        }

    }

    //直接传入一个修改好的User对象,除了id其它地方都能改 ,因为这个方法是根据用户的id更新对象
    //修改
    public boolean update(User user){

        //sql如下 :
        // update users set password=?,money=?,processing_order='?',release_order=? where id=?;

        try{
            conn = DriverManager.getConnection("jdbc:derby:dailian;create=true");

            stmt  = conn.prepareStatement("update users set password=?,money=?,processing_order=?,release_order=? where id=?");
            stmt.setString(1,user.getPassword());
            stmt.setDouble(2,user.getMoney());
            stmt.setString(3,user.getProcessing_order());
            stmt.setString(4,user.getRelease_order());
            stmt.setString(5,user.getId());
            stmt.execute();
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            release(conn,stmt,rs);
        }
    }


    //释放资源的方法
    public boolean release(Connection conn,PreparedStatement stmt,ResultSet rs){
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
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
