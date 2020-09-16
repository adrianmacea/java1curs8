import javax.swing.*; //ne trebuie pentru componente JFrame, JButton ...
import java.awt.*; //ne trebuie pentru FlowLayout
import java.awt.event.*; //ne trebuie pentru ActionListener
import java.util.*; //ne trebuie pentru random


public class E01RandomFrame extends JFrame{
    
    JButton b = new JButton("New Random Frame");
    
    Random r = new Random();
    
    public E01RandomFrame(){
        super("MORE AND MORE FRAMES");
        setVisible(true);
        setLocation(600,450);
        setSize(500,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //inchide procesele atunci cand este inchisa fereastra
        
        setLayout(new FlowLayout());
        
        add(b);
        b.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ev){
                    int x = r.nextInt(1400);
                    int y = r.nextInt(800);
                    
                    E01RandomFrame f = new E01RandomFrame();
                    f.setLocation(x,y);
                }
            }
        );
    }
    
    
    public static void main(String [] args){
        new E01RandomFrame();
    }
}