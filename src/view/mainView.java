package view;

import bean.Order;
import bean.User;
import com.sun.org.apache.xpath.internal.operations.Or;
import controll.BusinessService;
import sun.security.mscapi.*;
import view.controll.JPanelController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import  javax.swing.ImageIcon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/6/13.
 */
public class mainView extends JFrame {

    JLabel BackGro;
    JLabel topPic;
    JPanelController jpc=new JPanelController();
    JPanel jp;
    User user;

    public mainView(User user){
        this.user = user;

        Dimension screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screensize.getWidth();
        int height = (int)screensize.getHeight();
        this.setBounds(width/2-500,height/2-300,1000,600);
        this.setIconImage(Toolkit.getDefaultToolkit().createImage("image/tubiaoxiao.jpg"));//设置窗体图标
        this.setLayout(null);//空布局
        setResizable(false);//不可改变大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("代练宝");


        BackGro = new JLabel(new ImageIcon("image/Bj_main.jpg"));
        BackGro.setOpaque(false);//最底层

        topPic = new JLabel(new ImageIcon("image/head.jpg"));
        topPic.setOpaque(false);//最底层

        ImageIcon[] a1 = new ImageIcon[]{new ImageIcon("image/A1.png"),new ImageIcon("image/A2.png"),new ImageIcon("image/A2.png")};
        MyButton a =new MyButton(a1,"首页");
        a.setBounds(35,15,80,80);

        ImageIcon[] b1 = new ImageIcon[]{new ImageIcon("image/B1.png"),new ImageIcon("image/B2.png"),new ImageIcon("image/B2.png")};
        MyButton b =new MyButton(b1,"发单管理");
        b.setBounds(150,15,80,80);

        ImageIcon[] c1 = new ImageIcon[]{new ImageIcon("image/C1.png"),new ImageIcon("image/C2.png"),new ImageIcon("image/C2.png")};
        MyButton c =new MyButton(c1,"接单管理");
        c.setBounds(265,15,80,80);

        ImageIcon[] d1 = new ImageIcon[]{new ImageIcon("image/D1.png"),new ImageIcon("image/D2.png"),new ImageIcon("image/D2.png")};
        MyButton d =new MyButton(d1,"个人中心");
        d.setBounds(380,15,80,80);

        ImageIcon[] e1 = new ImageIcon[]{new ImageIcon("image/E1.jpg"),new ImageIcon("image/E1.jpg"),new ImageIcon("image/E1.jpg")};
        MyButton e =new MyButton(e1,"我要发单");
        e.setBounds(495,30,152,45);


        topPic.setBounds(0,0,1000,110);
        BackGro.setBounds(0,80,1000,500);

        ArrayList<view.MyButton> list=new ArrayList<view.MyButton>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);



  //      jp= new JPanel();
   //     jp.setBounds(0,110,1000,490);
        this.add(BackGro); //这啊 直接显示一背景图p


        for(int i = 0;i< list.size();i++ ){
            MyButton m =list.get(i);
            //list.get(0).setCurrentIcon(MyButton.SELECT);
            m.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    m.setCurrentIcon(MyButton.SELECT);
                    for(MyButton mb:list){
                        if(mb!=m){
                            mb.setCurrentIcon(MyButton.USUAL);
                        }
                    }
                    if(jp!=null){
                        remove(jp);
                    }
                    jp = jpc.repaintUI(m.getRepaint(),user);
                    jp.setBounds(0,110,1000,490);
                    add(jp);
                    validate();
                }
            });
        }


        this.add(a);
        this.add(b);
        this.add(c);
        this.add(d);
        this.add(e);

        this.add(topPic);
        this.add(BackGro);

        this.setVisible(true);


    }

}
