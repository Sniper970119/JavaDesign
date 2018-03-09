package view.ButtonView;

import bean.Order;
import bean.User;
import controll.BusinessService;
import view.OrderView.RleaseOrerView;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by admin on 2017/6/13.
 */
public class releaseButtonView extends JPanel {
    int row =0;
    JLabel BackGro;
    BusinessService business = new BusinessService();
    public releaseButtonView(User user){

//        setBackground(Color.cyan);//找不到设置Jpanel的背景图片的办法。先暂时用颜色
//        JButton j=new JButton();
//        j.setIcon(new ImageIcon("image/E1.jpg"));//这里算是测试陈功了。该怎么改你自己试试把。桥都麻带！ 这样就没有拖动更改了？
//        add(j);


        /*JLabel j = new JLabel();
        j.setIcon(new ImageIcon("image/12.png"));

        add(j);*/



        /*JScrollPane jsp=new JScrollPane(table);//这个地方得把Table放进jsp里面才能有header。。列名， 以及滚动条。。我给忘记怎么写了。等会


        String[] headers={"id","name","gender","age","score"};//
        Object[][] cellData=null;
        DefaultTableModel model = new DefaultTableModel(cellData, headers) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table=new JTable(model);

        DefaultTableModel tm=(DefaultTableModel)table.getModel();
        ////然后这个地方 拿到一个订单列表。放进一个for（Order o:list） 里。然后像下面一样装进去

        for (int i = 0; i <50 ; i++) {
            tm.addRow(new Object[]{i+"","jack","male","13","77"});//等会  那怎么选择订单啊 可以这样。你把一个JPanel分为两部分。。左边是Table，右边是按钮。
            //左边选中后右边可以选择xxx你  <-------   你怎么知道我选得是哪跳啊    Jtable的API有对应的方法。你可以查一下看看API可不可以根据功能查啊 还是只能查方法
            //你打开API

        }*/

        /*List ls=new List() ;
        for(Order o:ls){
            Object[] a=new Object[]{o.getOrderName(),o.getId()*//*o.getXX()*//*};
            tm.addRow(a);、、这样  我去画个图
        }*/


//        add(table);
//        validate();
//        setVisible(true);

       /*
           JTable table=new JTable();
       BackGro = new JLabel(new ImageIcon("image/no.png"));
        BackGro.setOpaque(false);//最底层


        ArrayList<Order> list = business.getStateList("未接单");


        String[] headers={"订单ID ","订单信息","订单佣金","订单状态"};
        Object[][] cellData=null;
        DefaultTableModel model = new DefaultTableModel(cellData, headers) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table=new JTable(model);

        DefaultTableModel tm=(DefaultTableModel)table.getModel();
//        for (int i = 0; i < list.size(); i++) {
//            tm.addRow(new Object[]{list.get(i)});
//
//        }
        for(Order o:list){
            Object[] a=new Object[]{o.getId(),o.getOrderName(),o.getReward(),o.getState()};
                    tm.addRow(a);
        }

        table.getColumnModel().getColumn(0).setPreferredWidth(235);
        table.getColumnModel().getColumn(1).setPreferredWidth(230);
        table.getColumnModel().getColumn(2).setPreferredWidth(68);
        table.getColumnModel().getColumn(3).setPreferredWidth(68);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(600, 400));
        add(scrollPane);
        add(BackGro);
        validate();
        setVisible(true);*/

       JPanel big = new JPanel();
       JPanel little = panelTable(user);

        BackGro = new JLabel(new ImageIcon("image/no.png"));
        BackGro.setOpaque(false);//最底层
        BackGro.setBounds(0,0,1000,490);

       JButton process = new JButton("删除订单");

       process.setBounds(450,300,100,35);
       little.setBounds(20,80,600,400);
       big.setBounds(0,0,1000,490);
//
//
        big.add(little);
        big.add(process);
        //big.add(BackGro);

        add(big);

        process.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                RleaseOrerView rlea = new RleaseOrerView(user);
                rlea.setVisible(true);
            }
        });

    }



    JPanel panelTable (User user){
        JPanel little = new JPanel(new GridLayout(1,2));
         JTable table=new JTable();
        BackGro = new JLabel(new ImageIcon("image/no.png"));
        BackGro.setOpaque(false);//最底层
        BackGro.setBounds(0,0,300,300);


        ArrayList<Order> list = business.getRelease_idList(user.getId());



        String[] headers={"订单ID ","订单信息","订单佣金","订单状态"};
        Object[][] cellData=null;
        DefaultTableModel model = new DefaultTableModel(cellData, headers) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
         table =new JTable(model);

        DefaultTableModel tm=(DefaultTableModel)table.getModel();

        for(Order o:list){
            Object[] a=new Object[]{o.getId(),o.getOrderName(),o.getReward(),o.getState()};
            tm.addRow(a);
        }

        table.getColumnModel().getColumn(0).setPreferredWidth(235);
        table.getColumnModel().getColumn(1).setPreferredWidth(230);
        table.getColumnModel().getColumn(2).setPreferredWidth(68);
        table.getColumnModel().getColumn(3).setPreferredWidth(68);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(600, 400));
        little.add(scrollPane);

//        class getrow extends releaseButtonView{
//             public int getRowLine(){
//                 row = table.getSelectedRow();
//                 return row;
//             }
//         }

        validate();
        setVisible(true);


        return little;
    }
}
