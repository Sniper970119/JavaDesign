package view.ButtonView;

import bean.User;
import com.sun.org.apache.xpath.internal.operations.Or;
import controll.BusinessService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by admin on 2017/6/13.
 */
public class needButtonView extends JPanel{
    public User user;
    BusinessService business  = new BusinessService();
    public needButtonView(User user){
        JLabel j = new JLabel();
        setLayout(new BorderLayout());
        j.setIcon(new ImageIcon("image/Bj_need.jpg"));

        this.user = user;

        JLabel orderName = new JLabel("请输入订单名");
        JLabel remain = new JLabel("   例： 电信一区 大师100点 - 王者500点");
        remain.setFont(new   java.awt.Font("Dialog",0,15));
        remain.setForeground(Color.gray);
        JLabel reward = new JLabel("订单佣金");

        JTextField inputOrderName = new JTextField();
        JTextField inputReward = new JTextField();

        JButton sendOrder =  new JButton("发布订单");

        orderName.setBounds(100,50,100,35);
        remain.setBounds(420,50,600,35);
        reward.setBounds(100,100,100,35);

        inputOrderName.setBounds(220,50,200,35);
        inputReward.setBounds(220,100,200,35);

        sendOrder.setBounds(250,200,100,35);

        add(orderName);
        add(remain);
        add(reward);

        add(inputOrderName);
        add(inputReward);

        add(sendOrder);

        add(j);
        String release = user.getRelease_order();

        //发送订单
        sendOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!inputOrderName.getText().isEmpty()) {
                    if (!inputReward.getText() .isEmpty()) {
                        String mon = inputReward.getText().trim();
                        Double reward = Double.parseDouble(mon);
                        if (reward > 0&&user.getMoney()-reward>0) {
                            business.releaseOrder(user, inputOrderName.getText(), reward);
                            JOptionPane.showMessageDialog
                                    (null, "发布成功\n再次点击个人中心可刷新", "成功", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog
                                    (null, "佣金格式错误\n或 余额不足", "错误", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog
                                (null, "请输入正确的佣金", "错误", JOptionPane.WARNING_MESSAGE);
                    }

//                String mon = inputReward.getText().trim();
//                Double reward = Double.parseDouble(mon);
//                business.releaseOrder(user,inputOrderName.getText(),reward);
                } else {
                    JOptionPane.showMessageDialog
                            (null, "请输入订单信息", "错误", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

    }


}
