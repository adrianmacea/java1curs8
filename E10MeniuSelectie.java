import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class E10MeniuSelectie extends JFrame{
    
    JPanel p1 = new JPanel();
    
    JMenuBar mb = new JMenuBar();
    JMenu m1 = new JMenu("Culori");
    JRadioButtonMenuItem mi1 = new JRadioButtonMenuItem("Rosu");
    JRadioButtonMenuItem mi2 = new JRadioButtonMenuItem("Verde");
    JRadioButtonMenuItem mi3 = new JRadioButtonMenuItem("Albastru");
    JRadioButtonMenuItem mi4 = new JRadioButtonMenuItem("Negru", true); //il facem implicit folosind true
    ButtonGroup bg = new ButtonGroup(); //cele 4 butoane nu se grupeaza automat, trebuie sa le grupam noi
    
    public E10MeniuSelectie(){
        super("Color Menu");
        setVisible(true);
        setSize(800,800);
        setLocation(450,250);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setJMenuBar(mb);
        mb.add(m1);
        m1.add(mi1); m1.add(mi2); m1.add(mi3); m1.add(mi4);
        bg.add(mi1); bg.add(mi2); bg.add(mi3); bg.add(mi4); 
        //daca nu adaugam butoanele grupului, se vor comporta ca 4 grupuri independente a cate un buton
        
        add(p1);
        
        p1.addMouseListener(
            new MouseAdapter(){
                public void mouseClicked(MouseEvent ev){
                    Graphics g = p1.getGraphics();
                    int x = ev.getX();
                    int y = ev.getY();
                    if(mi1.isSelected()) g.setColor(Color.RED);
                    if(mi2.isSelected()) g.setColor(Color.GREEN);
                    if(mi3.isSelected()) g.setColor(Color.BLUE);
                    if(mi4.isSelected()) g.setColor(Color.BLACK);
                    g.fillOval(x-25,y-25,50,50);
                }
            }
        );
    }
    
    public static void main(String [] args){
        new E10MeniuSelectie();
    }
}
