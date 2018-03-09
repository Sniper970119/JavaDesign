package view; /**
 * Created by admin on 2017/6/6.
 */

import bean.User;
import controll.BusinessService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginView extends JFrame {
    JTextField inputUser;//输入帐号
    JPasswordField inputPassword;//输入密码
    JButton loginButton;//登录按钮
    JButton registButton;//注册按钮
    JButton forgetPasswordButton;//忘记密码
    JLabel BackGro;
    JPanel panel;             //放置各种用户答题所需要的组件

    private BusinessService business = new BusinessService();
    public User user = new User();

    public LoginView() {

        Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕大小
        int width = (int)screensize.getWidth();
        int height = (int)screensize.getHeight();
        setBounds(width/2-200,height/2-150,400,300);
        setResizable(false);//不可改变大小
        setVisible(true);
        setTitle("欢迎登录代练宝");

        setIconImage(Toolkit.getDefaultToolkit().createImage("image/tubiaoxiao.jpg"));//设置窗体图标
        setLayout(null);//空布局
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginButton = new JButton("立即登录");
        registButton = new JButton("注册代练宝");
        forgetPasswordButton = new JButton("忘记密码");

        inputUser = new JTextField(20);//帐号输入长度
        inputPassword = new JPasswordField(20);//密码输入长度

        BackGro = new JLabel(new ImageIcon("image/2.jpg"));
        BackGro.setOpaque(false);//最底层

        JLabel UserText = new JLabel("用户帐号");
        add(UserText);
        add(inputUser);

        JLabel UserPassword = new JLabel("登录密码");
        add(UserPassword);



        add(inputPassword);
        add(loginButton);
        add(registButton);
        add(forgetPasswordButton);
        add(BackGro);

        BackGro.setBounds(0,0,400,300);
        UserText.setBounds(50, 100, 100, 35);
        inputUser.setBounds(130,105,200,30);
        UserPassword.setBounds(50, 150, 100, 35);
        inputPassword.setBounds(130,153,200,30);
        loginButton.setBounds(260, 200, 100, 35);
        registButton.setBounds(40, 200, 100, 35);
        forgetPasswordButton.setBounds(150,200,100,35);

        //登录
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                user = business.loginUser(inputUser.getText().trim(),inputPassword.getText().trim());
                if(user==null){

                    JOptionPane.showMessageDialog
                            (null,"请输入正确的帐号密码","帐号或密码错误", JOptionPane.WARNING_MESSAGE);

                }else{

                    business.serviceId=user.getId();
                    mainView main = new mainView(user);
                    main.setVisible(true);

                }
            }
        });

        //注册
        registButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                RegistView registview = new RegistView();
                registview.setVisible(true);

            }
        });

        //忘记
        forgetPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                forgetView forget = new forgetView();
                forget.setVisible(true);

            }
        });

        validate();
        setVisible(true);

    }

}
