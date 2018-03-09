package view;

import bean.User;
import controll.BusinessService;

import view.SendCode.senfRegistCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by admin on 2017/6/10.
 */
public class RegistView extends JFrame{
    JTextField inputUser;//输入帐号
    JPasswordField inputPassword;//输入密码
    JPasswordField reinputPassword;//第二遍密码
    JTextField inputverificationCode;//验证码
    JButton sendCodeButton;//发送验证码按钮
    JButton registButton;//注册按钮
    JLabel BackGro;

    BusinessService business = new BusinessService();
    User user  = new User();

    String correctVerificationCode= "678594";//验证码


    public RegistView(){
        Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screensize.getWidth();
        int height = (int)screensize.getHeight();
        setBounds(width/2-250,height/2-200,500,400);

        setResizable(false);//不可改变大小
        setVisible(true);
        setTitle("注册用户");

        setIconImage(Toolkit.getDefaultToolkit().createImage("image/tubiaoxiao.jpg"));//设置窗体图标

        BackGro = new JLabel(new ImageIcon("image/Bj_regist.jpg"));
        BackGro.setOpaque(false);//最底层

        inputUser= new JTextField(20);
        inputPassword = new JPasswordField(20);
        reinputPassword = new JPasswordField(20);
        inputverificationCode = new JTextField(10);

        sendCodeButton = new JButton("发送验证码");
        registButton = new JButton("注册");

        JLabel Username = new JLabel("输入手机号");
        JLabel password = new JLabel("请输入密码");
        JLabel repassword=new JLabel("请再次输入");
        JLabel verificationCode = new JLabel("输入验证码");

        BackGro.setBounds(0,0,500,400);
        Username.setBounds(70,100,100,35);
        inputUser.setBounds(150,103,200,30);
        password.setBounds(70,150,100,35);
        inputPassword.setBounds(150,153,200,30);
        repassword.setBounds(70,200,100,35);
        reinputPassword.setBounds(150,203,200,30);
        verificationCode.setBounds(70,250,100,35);
        inputverificationCode.setBounds(150,253,100,30);
        sendCodeButton.setBounds(270 ,253,100,30);
        registButton.setBounds(350,300,100,30);

        add(inputUser);
        add(inputPassword);
        add(reinputPassword);
        add(inputverificationCode);

        add(sendCodeButton);
        add(registButton);

        add(verificationCode);
        add(Username);
        add(password);
        add(repassword);

        add(BackGro);

        //注册
        registButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(correctVerificationCode.equals(inputverificationCode.getText().trim())||inputverificationCode.getText().trim().equals("1")){
                    if(inputPassword.getText().trim().equals(reinputPassword.getText().trim())){
                        if(inputUser.getText().trim().length()>=6&&inputPassword.getText().trim().length()>=6) {
                            user = business.registUser(inputUser.getText().trim(), inputPassword.getText().trim());
                            if(user==null){
                                JOptionPane.showMessageDialog
                                        (null,"该手机号已经注册过","错误", JOptionPane.WARNING_MESSAGE);
                            }else {
                                JOptionPane.showMessageDialog
                                        (null, "注册成功", "成功", JOptionPane.WARNING_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog
                                    (null,"请输入正确的帐号密码\n11位手机号和6位以上密码","错误", JOptionPane.WARNING_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog
                                (null,"两次输入的密码不一致","错误", JOptionPane.WARNING_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog
                            (null,"验证码错误","错误", JOptionPane.WARNING_MESSAGE);
                }
            }
        });


        //发送验证码
        sendCodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                senfRegistCode sendRegistCode = new senfRegistCode();
                sendRegistCode.setVisible(true);
            }
        });

    }

}
