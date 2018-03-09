package bean;

/**
 * Created by Haitao on 2017/6/9 0009.
 */
public class Order {
    private String id;
    private String orderName;
    private Double reward;
    private  String state;
    private String release_id;//发布者id
    private String receive_id;//接收者id

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", orderName='" + orderName + '\'' +
                ", reward=" + reward +
                ", state='" + state + '\'' +
                ", release_id='" + release_id + '\'' +
                ", receive_id='" + receive_id + '\'' +
                '}';
    }

    public Order(){}

    public void setId(String id){
        this.id=id;
    }

    public String getId(){
        return id;
    }

    public void setOrderName(String orderName){
        this.orderName = orderName;
    }

    public String getOrderName(){
        return orderName;
    }

    public void setReward(double reward){
        this.reward = reward;
    }

    public double getReward(){
        return reward;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }

    public void setRelease_id(String release_id){
        this.release_id= release_id;
    }

    public String getRelease_id(){
        return  release_id;
    }

     public  void setReceive_id(String receive_id){
        this.receive_id = receive_id;
     }

     public  String getReceive_id(){
         return  receive_id;
     }


}
