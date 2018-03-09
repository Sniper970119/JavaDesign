package view.SendCode;

import javax.swing.*;
import java.awt.*;

/**
 * Created by admin on 2017/6/13.
 */
public class SendWithdrowCode extends JFrame{
    JLabel BackGro;
    public SendWithdrowCode(){
        Dimension screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screensize.getWidth();
        int height = (int)screensize.getHeight();
        setBounds(width/2+250,height/2-250,330,565);

        setTitle("发送验证码");
        setResizable(false);
        setVisible(true);
        setIconImage(Toolkit.getDefaultToolkit().createImage("image/tubiaoxiao.jpg"));//设置窗体图标

        BackGro = new JLabel(new ImageIcon("image/tixian.png"));
        BackGro.setOpaque(false);//最底层
        BackGro.setBounds(0,0,300,535);
        add(BackGro);

    }
}
