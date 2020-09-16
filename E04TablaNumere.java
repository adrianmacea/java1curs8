import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class E04TablaNumere extends JFrame implements ActionListener{
    
    int [] v1 = {2,5,3,8,7};
    int [] v2 = {7,4,3,6,5};
    
    JButton [][] b = new JButton[5][5];
    
    JPanel p1 = new JPanel(new GridLayout(5,5));
    JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    
    JLabel l1 = new JLabel("SUMA: 0");
    
    int suma = 0;
    
    public E04TablaNumere(){
        
        super("NUMERE");
        setVisible(true);
        setLocation(600,450);
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add(p1,BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        
        p2.add(l1);
        
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                b[i][j] = new JButton(v1[i]+v2[j]+"");
                p1.add(b[i][j]);
                b[i][j].setOpaque(true); //fara asta culoarea butonului nu se vede pe macOS
                b[i][j].addActionListener(this);
            }        
        }        
    }
    
    public void actionPerformed(ActionEvent ev){
        JButton bx = (JButton) ev.getSource();
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(bx == b[i][j]){
                    int n = Integer.parseInt(bx.getText()); //n este numarul care se afla pe buton
                    bx.setBackground(Color.YELLOW);
                    suma += n;
                    l1.setText("SUMA: "+suma);
                    for(int k=0;k<5;k++){
                        b[k][j].setEnabled(false); //dezactiveaza butoanele
                        b[i][k].setEnabled(false);                        
                    }
                }
            }        
        }
    }
    
    public static void main(String [] args){
        new E04TablaNumere();
    }
    
}
