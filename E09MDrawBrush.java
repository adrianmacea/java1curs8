import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class E09MDrawBrush extends JFrame{
    
    JPanel p1 = new JPanel();
    
    public E09MDrawBrush(){
        super("Draw Brush");
        setVisible(true);
        setSize(800,800);
        setLocation(450,250);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add(p1);
        
        p1.addMouseListener(
            new MouseAdapter(){
                public void mouseDragged(MouseEvent ev){
                    Graphics g = p1.getGraphics();
                    int x = ev.getX();
                    int y = ev.getY();
                    g.fillOval(x-10,y-10,20,20);
                }
            }
        );
    }
    
    public static void main(String [] args){
        new E09MDrawBrush();
    }
}
