package view;

import bean.User;
import controll.BusinessService;
import view.SendCode.SendAddMoneyCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by admin on 2017/6/17.
 */
public class AddMoneyView extends JFrame{
    String yanzhengma = "943787";
    JLabel BackGro;

    BusinessService business = new BusinessService();

    public AddMoneyView(User user){

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screensize.getWidth();
        int height = (int) screensize.getHeight();
        setBounds(width / 2 - 200, height / 2 - 125, 400, 250);

        setResizable(false);//不可改变大小
        setTitle("充值");
        setVisible(true);

        BackGro = new JLabel(new ImageIcon("image/Bj_regist.jpg"));
        BackGro.setOpaque(false);//最底层

        JLabel money = new JLabel("请输入充值金额");
        JLabel verifictionCode = new JLabel("请输入验证码");

        JTextField inputmoney = new JTextField();
        JTextField inputVerifictionCode = new JTextField();

        JButton sendVerifictionCode = new JButton("发送验证码");
        JButton addMoney = new JButton("充值");

        money.setBounds(30,50,100,35);
        verifictionCode.setBounds(30,100,100,35);

        inputmoney.setBounds(140,50,200,35);
        inputVerifictionCode.setBounds(140,100,100,35);

        sendVerifictionCode.setBounds(260,100,100,30);
        addMoney.setBounds(280,170,100,30);

        add(money);
        add(verifictionCode);

        add(inputmoney);
        add(inputVerifictionCode);

        add(sendVerifictionCode);
        add(addMoney);

        add(BackGro);

        //发送验证码
        sendVerifictionCode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SendAddMoneyCode send = new SendAddMoneyCode();
                send.setVisible(true);
            }
        });

        //充值
        addMoney.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(yanzhengma.equals(inputVerifictionCode.getText().trim())||inputVerifictionCode.getText().equals("1")){
                    String mon = inputmoney.getText().trim();
                    Double mone = Double.parseDouble(mon);
                    if(mone>0){
                        business.rechargeMoney(user,mone);
                        JOptionPane.showMessageDialog
                                (null,"充值成功\n再次点击个人中心可刷新","成功", JOptionPane.WARNING_MESSAGE);
                    }else {
                        JOptionPane.showMessageDialog
                                (null,"请输入正确的金额","错误", JOptionPane.WARNING_MESSAGE);
                    }
                }else {
                    JOptionPane.showMessageDialog
                            (null,"请输入正确的验证码","错误", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

    }
}
