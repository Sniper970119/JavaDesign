package view.ButtonView;

import bean.User;
import view.AddMoneyView;
import view.ChangePasswordView;
import view.WithdrowView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by admin on 2017/6/13.
 */
public class aboutButtonView extends JPanel{
        public User user;

    public aboutButtonView(User user){
        this.user= user;

        JLabel j = new JLabel();
        setLayout(new BorderLayout());
        j.setIcon(new ImageIcon("image/Bj.jpg"));

        JLabel welcome = new JLabel("欢迎您！");
        JLabel userid  = new JLabel("用户ID             :   "+user.getId());
        JLabel username = new JLabel("用户手机号    :   "+user.getUsername());
        JLabel userpassword = new JLabel("用户密码        :   **********");
        JLabel usermoney = new JLabel("账户余额        :   "+user.getMoney());
        JButton addMoney = new JButton("充值");
        JButton withdrowMoney = new JButton("提现");
        JButton changePassword =  new JButton("修改密码");

        welcome.setBounds(100,50,100,30);
        userid.setBounds(100,100,500,30);
        username.setBounds(100,150,500,30);
        userpassword.setBounds(100,200,200,30);
        changePassword.setBounds(270,200,100,30);
        usermoney.setBounds(100,250,150,30);
        addMoney.setBounds(270,250,100,30);
        withdrowMoney.setBounds(390,250,100,30);

        add(welcome);
        add(userid);
        add(username);
        add(userpassword);
        add(changePassword);
        add(usermoney);
        add(addMoney);
        add(withdrowMoney);
        add(j);


        //修改密码
        changePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangePasswordView change = new ChangePasswordView(user);
                change.setVisible(true);
            }
        });

        //充值
        addMoney.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddMoneyView add = new AddMoneyView(user);
                add.setVisible(true);
            }
        });

        //提现
        withdrowMoney.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WithdrowView withdrow = new WithdrowView(user);
                withdrow.setVisible(true);
            }
        });

    }

}
