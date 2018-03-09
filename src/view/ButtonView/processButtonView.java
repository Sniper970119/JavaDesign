package view.ButtonView;

import bean.Order;
import bean.User;
import controll.BusinessService;
import view.OrderView.ProcessOrderView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by admin on 2017/6/13.
 */
public class processButtonView extends JPanel{

    JLabel BackGro;
    BusinessService business = new BusinessService();
   public processButtonView(User user){

       JPanel big = new JPanel();
       JPanel little = panelTable(user);

       BackGro = new JLabel(new ImageIcon("image/no.png"));
       BackGro.setOpaque(false);//最底层
       BackGro.setBounds(0,0,1000,490);

       JButton process = new JButton("完成订单");

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
               ProcessOrderView pro = new ProcessOrderView(user);
               pro.setVisible(true);

           }
       });

   }



    JPanel panelTable (User user){
        JPanel little = new JPanel(new GridLayout(1,2));
        JTable table=new JTable();
        BackGro = new JLabel(new ImageIcon("image/no.png"));
        BackGro.setOpaque(false);//最底层
        BackGro.setBounds(0,0,300,300);


        ArrayList<Order> list = business.getReceive_idList(user.getId());


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
