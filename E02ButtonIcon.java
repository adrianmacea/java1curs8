import javax.swing.*; //ne trebuie pentru componente JFrame, JButton ...
import java.awt.*; //ne trebuie pentru FlowLayout
import java.awt.event.*; //ne trebuie pentru ActionListener

public class E02ButtonIcon extends JFrame{
    
    Icon ico = new ImageIcon("Button60px.png");
    
    JButton b = new JButton("APASA");
    
    public E02ButtonIcon(){
        super("ICON");
        setVisible(true);
        setLocation(600,450);
        setSize(500,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setLayout(new FlowLayout());
        
        add(b);
        
        b.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ev){
                    if(b.getText().equals("APASA")){
                        b.setText("");
                        b.setIcon(ico);
                    }else{
                        b.setText("APASA");
                        b.setIcon(null);
                    }
                }
            }
        );
    }
    
    public static void main(String [] args){
        new E02ButtonIcon();
    }
    
}
