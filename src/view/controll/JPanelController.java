package view.controll;

import bean.*;
import view.ButtonView.*;

import javax.swing.*;

/**
 * Created by admin on 2017/6/14.
 */
public class JPanelController {

    //更新界面
    public JPanel repaintUI(String  repaint,User user){
        JPanel j=new JPanel();
        j.setBounds(0,110,1000,490);

        if("首页".equals(repaint)){
            j=new homePageButtonView(user);
            return  j;

        }

        if("发单管理".equals(repaint)){
            j=new releaseButtonView(user);
            return  j;
        }

        if("接单管理".equals(repaint)){
            j =new processButtonView(user);
            return  j;

        }

        if("个人中心".equals(repaint)){
            j =new aboutButtonView(user);
            return  j;

        }

        if("我要发单".equals(repaint)){
            j =new needButtonView(user);
            return  j;

        }

        return null;

    }


}
