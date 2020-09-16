import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class E11ColorPalette extends JFrame{
    
    JPanel p1 = new JPanel();
    
    JMenuBar mb = new JMenuBar();
    JMenu m1 = new JMenu("Optiuni");
    JMenuItem mi1 = new JMenuItem("Culori");
    
    Color c = Color.BLACK;
    
    JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel l1 = new JLabel("Size: ");
    JLabel l2 = new JLabel("50 px");
    JSlider s1 = new JSlider(10,90,50); //val initiala, val finala, val default
    
    public E11ColorPalette(){
        super("Color Palette");
        setVisible(true);
        setSize(800,800);
        setLocation(450,250);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setJMenuBar(mb);
        mb.add(m1);
        m1.add(mi1);
        
        add(p1);
        add(p2, BorderLayout.NORTH);
        p2.add(l1); p2.add(l2); p2.add(s1);
        
        s1.addChangeListener(
            new ChangeListener(){
                public void stateChanged(ChangeEvent ev){
                    l2.setText(s1.getValue()+" px");
                }
            }
        );
        
        mi1.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ev){
                    c = JColorChooser.showDialog(null,"Culori",Color.BLACK);
                }
            }
        );
        
        p1.addMouseListener(
            new MouseAdapter(){
                public void mouseClicked(MouseEvent ev){
                    int x = ev.getX();
                    int y = ev.getY();
                    Graphics g = p1.getGraphics();
                    g.setColor(c);
                    int val = s1.getValue();
                    g.fillOval(x-val/2,y-val/2,val,val);
                }
            }
        );
    }
    
    public static void main(String [] args){
        new E11ColorPalette();
    }
}
