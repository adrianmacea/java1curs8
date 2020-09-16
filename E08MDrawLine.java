import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class E08MDrawLine extends JFrame{
    
    JPanel p1 = new JPanel();
    
    int x1, x2, y1, y2;
    
    public E08MDrawLine(){
        super("Draw Lines");
        setVisible(true);
        setSize(800,800);
        setLocation(450,250);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add(p1);
        
        p1.addMouseListener(
            new MouseAdapter(){
                public void mousePressed(MouseEvent ev){
                    x1 = ev.getX();
                    y1 = ev.getY();
                }
                public void mouseReleased(MouseEvent ev){
                    x2 = ev.getX();
                    y2 = ev.getY();
                    Graphics g = p1.getGraphics();
                    g.drawLine(x1,y1,x2,y2);
                }
            }
        );
    }
    
    public static void main(String [] args){
        new E08MDrawLine();
    }
}