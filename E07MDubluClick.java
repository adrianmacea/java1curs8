import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class E07MDubluClick extends JFrame{
    
    JPanel p1 = new JPanel();
    
    public E07MDubluClick(){
        super("Dublu Click");
        setVisible(true);
        setSize(800,800);
        setLocation(450,250);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add(p1);
        
        p1.addMouseListener(
            new MouseAdapter(){
                public void mouseClicked(MouseEvent ev){
                    int x = ev.getX();
                    int y = ev.getY();
                    
                    //comportament din MouseEvent care numara cati clicks sau facut in functie de viteza setata in sistemul de operare
                    if(ev.getClickCount() == 2){
                        Graphics g = p1.getGraphics();
                        g.fillOval(x-25,y-25,50,50);
                    }
                }
            }
        );
    
    }
    
    public static void main(String [] args){
        new E07MDubluClick();
    }
}
