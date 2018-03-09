package bean;

/**
 * Created by Haitao on 2017/6/9 0009.
 */
public class User {

    private String id;     //创建用户时候生成唯一的用户id
    private String username;
    private String password;
    private double money;//
    private String release_order;//发布的订单的id
    private String processing_order;//正在进行的订单的id

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", release_order='" + release_order + '\'' +
                ", processing_order='" + processing_order + '\'' +
                '}';
    }

    public User(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getRelease_order() {
        return release_order;
    }

    public void setRelease_order(String release_order) {
        this.release_order = release_order;
    }

    public String getProcessing_order() {
        return processing_order;
    }

    public void setProcessing_order(String processing_order) {
        this.processing_order = processing_order;
    }

}
