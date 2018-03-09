package view;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by admin on 2017/6/14.
 */
public class MyButton extends JButton{

    private int currentIcon;
    private ImageIcon[] allIcon;
    private boolean isSelect;
    private String repaint;

    final static  int USUAL = 0;
    final  static  int SUSPEND = 1;
    final  static int SELECT = 2;
    {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if(!isSelect){
                    setCurrentIcon(SUSPEND);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if(!isSelect){
                    setCurrentIcon(USUAL);
                }
            }
        });

    }



    public MyButton(ImageIcon[] allIcon,String repaint){
        if(allIcon.length!=3){
            throw new RuntimeException("传入的imageIcon数组长度必须是3,0正常,1悬浮,2选中");
        }else {
            this.allIcon = allIcon;
            setCurrentIcon(USUAL);
            this.repaint=repaint;
        }
    }


    public void setCurrentIcon(int currentIcon){
        this.currentIcon = currentIcon;
        setIcon(allIcon[currentIcon]);
        if(currentIcon ==2){
            isSelect = true;
        }else{
            isSelect = false;
        }
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;

    }

    public String getRepaint() {
        return repaint;
    }

    public void setRepaint(String repaint) {
        this.repaint = repaint;
    }

    public ImageIcon[] getAllIcon() {
        return allIcon;
    }


}
