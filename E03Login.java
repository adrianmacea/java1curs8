import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

public class E03Login extends JFrame{
    
    JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    
    JLabel l1 = new JLabel("User: ");
    JLabel l2 = new JLabel("Parola: ");
    
    JTextField t1 = new JTextField(20);
    JPasswordField pf = new JPasswordField(20); //un camp text care ascunde caracterele, info e preluata putin diferit de aici
    
    JButton b = new JButton("Conectare");
    
    public E03Login(){
        super("LOGIN WINDOW");
        setVisible(true);
        setLocation(600,450);
        setSize(360,160);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setLayout(new GridLayout(3,1));
        
        add(p1);add(p2);add(p3);
        p1.add(l1);p1.add(t1);
        p2.add(l2);p2.add(pf);
        p3.add(b);
        
        b.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ev){
                    String user = t1.getText();
                    String parola = new String(pf.getPassword());
                    if(user.equals("gigel") && parola.equals("12345")){
                        JOptionPane.showMessageDialog(null,"Conexiune realizata","SUCCES",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null,"Conexiune esuata","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        );
    }
    
    public static void main(String [] args){
        new E03Login();
    }
    
}
