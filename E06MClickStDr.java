import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class E06MClickStDr extends JFrame{
    
    JPanel p1 = new JPanel();
    
    public E06MClickStDr(){
        super("Click Stanga si Dreapta");
        setVisible(true);
        setSize(900,900);
        setLocation(400,250);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add(p1);
        
        p1.addMouseListener(
            new MouseAdapter(){
                public void mouseClicked(MouseEvent ev){
                    int x = ev.getX(); //ia valoarea coordonatei X a mousului raportat la componenta
                    int y = ev.getY(); //exista si o metoda care ia valoarea raportata la ecran: getYOnScreen();
                    Graphics g = p1.getGraphics();
                    if(ev.getButton() == MouseEvent.BUTTON1) g.setColor(Color.RED);
                    if(ev.getButton() == MouseEvent.BUTTON3) g.setColor(Color.YELLOW);
                    g.fillOval(x-25,y-25,50,50);
                }
            }
        );        
    }
    
    public static void main(String [] args){
        new E06MClickStDr();
    }
}
