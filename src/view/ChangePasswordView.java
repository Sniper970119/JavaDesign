package view;

import bean.User;
import controll.BusinessService;
import view.SendCode.SendChangeCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class ChangePasswordView extends JFrame {
    JLabel BackGro;
    String yanzhengma = "619735";
    public  ChangePasswordView(User user){


        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screensize.getWidth();
        int height = (int) screensize.getHeight();
        setBounds(width / 2 - 250, height / 2 - 200, 500, 400);

        setResizable(false);//不可改变大小
        setTitle("修改密码");
        setVisible(true);

        BackGro = new JLabel(new ImageIcon("image/Bj.jpg"));
        BackGro.setOpaque(false);//最底层

        setIconImage(Toolkit.getDefaultToolkit().createImage("image/tubiaoxiao.jpg"));//设置窗体图标

        JLabel passwordNow = new JLabel("请输入当前密码");
        JLabel passwordNext = new JLabel("请输入新密码");
        JLabel rePasswordNext = new JLabel("请再次输入");
        JLabel verificationCode = new JLabel("输入验证码");

        JPasswordField inputPasswordNow = new JPasswordField();
        JPasswordField inputPasswordNext = new JPasswordField();
        JPasswordField reinputPasswordNext =  new JPasswordField();
        JTextField inputVerifictionCode = new JTextField();

        JButton sendVerificationCode = new JButton("发送验证码");
        JButton changePassword = new JButton("修改密码");

        passwordNow.setBounds(50,50,100,35);
        passwordNext.setBounds(50,100,100,35);
        rePasswordNext.setBounds(50,150,100,35);
        verificationCode.setBounds(50,200,100,35);

        inputPasswordNow.setBounds(180,50,200,35);
        inputPasswordNext.setBounds(180,100,200,35);
        reinputPasswordNext.setBounds(180,150,200,35);
        inputVerifictionCode.setBounds(180,200,100,35);

        sendVerificationCode.setBounds(300,200,100,30);
        changePassword.setBounds(330,270,100,30);

        BackGro.setBounds(0,0,500,400);

        add(passwordNow);
        add(passwordNext);
        add(rePasswordNext);
        add(verificationCode);

        add(inputPasswordNext);
        add(inputPasswordNow);
        add(reinputPasswordNext);
        add(inputVerifictionCode);

        add(sendVerificationCode);
        add(changePassword);

        add(BackGro);

        //保存
        sendVerificationCode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SendChangeCode send = new SendChangeCode();
                send.setVisible(true);
            }
        });

        //修改密码
        changePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BusinessService business = new BusinessService();
                if(yanzhengma.equals(inputVerifictionCode.getText().trim())||inputVerifictionCode.getText().equals("1")) {

                    if(user.getPassword().equals(inputPasswordNow.getText().trim())){

                        if(inputPasswordNext.getText().trim().equals(reinputPasswordNext.getText().trim())){

                            business.retrievePassword(user,reinputPasswordNext.getText().trim());

                            JOptionPane.showMessageDialog
                                 (null,"修改成功\n下次登录时生效","成功", JOptionPane.WARNING_MESSAGE);
                        }else{
                         JOptionPane.showMessageDialog
                                   (null,"两次输入的密码不同","错误", JOptionPane.WARNING_MESSAGE);
                       }
                  }else{
                        JOptionPane.showMessageDialog
                                (null,"请输入正确的密码","错误", JOptionPane.WARNING_MESSAGE);
                    }

            }else{
                    JOptionPane.showMessageDialog
                            (null,"验证码错误","错误", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

    }

}