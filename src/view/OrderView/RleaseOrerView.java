package view.OrderView;

import bean.User;
import controll.BusinessService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by admin on 2017/6/18.
 */
public class RleaseOrerView extends JFrame{
    JLabel BackGro;
    BusinessService business = new BusinessService();

    public RleaseOrerView(User user){
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screensize.getWidth();
        int height = (int) screensize.getHeight();
        setBounds(width / 2+ 200, height / 2 - 150, 400, 300);
        setResizable(false);//不可改变大小
        setVisible(true);
        setTitle("删除订单");
        setLayout(null);//空布局

        setIconImage(Toolkit.getDefaultToolkit().createImage("image/tubiaoxiao.jpg"));//设置窗体图标

        BackGro = new JLabel(new ImageIcon("image/no.png"));
        BackGro.setOpaque(false);//最底层

        JLabel order_id = new JLabel("请输入订单号");
        JLabel remainOne = new JLabel("直接选中订单栏然后复制粘贴即可");
        JLabel remainTwo = new JLabel("佣金稍后会打到账户余额中");

        remainOne.setFont(new   java.awt.Font("Dialog",0,13));
        remainOne.setForeground(Color.gray);
        remainTwo.setFont(new   java.awt.Font("Dialog",0,13));
        remainTwo.setForeground(Color.gray);

        JTextField inputOrder = new JTextField(36);

        JButton processButon = new JButton("删除订单");

        order_id.setBounds(30,50,100,35);
        remainOne.setBounds(150,90,200,20);
        remainTwo.setBounds(150,110,200,20);

        inputOrder.setBounds(150,50,200,30);

        processButon.setBounds(200,200,100,35);

        add(order_id);
        add(remainOne);
        add(remainTwo);

        add(inputOrder);

        add(processButon);

        setVisible(true);


        processButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = inputOrder.getText();
                s = s.substring(0,36);
                boolean succ;
                succ = business.delOrder(user,s);
                if(succ==true){
                    JOptionPane.showMessageDialog
                            (null,"删除成功","成功", JOptionPane.WARNING_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog
                            (null,"该订单处于不可操作状态或\n你没有对该订单操作的权限","错误", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

    }
}
