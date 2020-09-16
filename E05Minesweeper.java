import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class E05Minesweeper extends JFrame implements ActionListener{
        
    Icon ico1 = new ImageIcon("Happy.png");
    Icon ico2 = new ImageIcon("Mine.png");
    Icon ico3 = new ImageIcon("Dead.png");
    Icon ico4 = new ImageIcon("Flag.png");
    
    JPanel p1 = new JPanel();
    JButton s = new JButton(ico1);
        
    JPanel p2 = new JPanel(new GridLayout(10,10));
    JButton [][] b = new JButton[10][10];
    
    int [][] m = new int [12][12];
    
    JMenuBar mb = new JMenuBar();
    JMenu m1 = new JMenu("Options");
    JMenuItem mi1 = new JMenuItem("New");
    JMenuItem mi2 = new JMenuItem("Exit");
        
    public E05Minesweeper(){
        super("MINESWEEPER");
        setVisible(true);
        setSize(900,900);
        setLocation(400,250);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setJMenuBar(mb);
        mb.add(m1);
        m1.add(mi1); m1.add(mi2);
        
        mi1.setIcon(ico1);
        mi2.setIcon(ico2);
        
        KeyStroke ks1 = KeyStroke.getKeyStroke("control N"); //am declarat shortcutul ctrl+n 
        KeyStroke ks2 = KeyStroke.getKeyStroke("alt Z"); //literele se scriu cu majuscula, modificatorii cu minuscula
        mi1.setAccelerator(ks1); //am asignat shotcutul ks1 itemului m11
        mi2.setAccelerator(ks2); //am asignat shotcutul ks2 itemului m12
        
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        
        p1.add(s);
                
        initializare();
        generare();
        count();
        
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                b[i][j] = new JButton();
                b[i][j].addActionListener(this);
                //b[i][j].setOpaque(true);
                //if(m[i+1][j+1] == -1) b[i][j].setBackground(Color.RED);
                p2.add(b[i][j]);
            }
        }
        
                
        s.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ev){
                    newGame();
                }
            }
        );
        
        mi1.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ev){
                    newGame();
                }
            }
        );
        
        mi2.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ev){
                    System.exit(0);
                }
            }
        );
    }
  
    public void initializare(){
        for(int i=0;i<12;i++){
            for(int j=0;j<12;j++){
                m[i][j] = 0;
            }
        }
    }
    
    public void generare(){ //genereaza locatia bombelor
        Random r = new Random();
        for(int i=0;i<20;i++){
            int x = r.nextInt(10)+1;
            int y = r.nextInt(10)+1;
            if(m[x][y] == -1){
                i--;
            }else{
                m[x][y] = -1;
            }
        }
    }
    
    public void count(){
        for(int i=1;i<11;i++){
            for(int j=1;j<11;j++){
                if(m[i][j] != -1){
                    if(m[i-1][j-1] == -1){m[i][j]++;}
                    if(m[i-1][j] == -1){m[i][j]++;}
                    if(m[i-1][j+1] == -1){m[i][j]++;}
                    if(m[i][j-1] == -1){m[i][j]++;}
                    
                    if(m[i][j+1] == -1){m[i][j]++;}
                    if(m[i+1][j-1] == -1){m[i][j]++;}
                    if(m[i+1][j] == -1){m[i][j]++;}
                    if(m[i+1][j+1] == -1){m[i][j]++;}
                }
            }
        }
    }
    
    public void actionPerformed(ActionEvent ev){
        JButton bx = (JButton) ev.getSource();
        
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(bx == b[i][j]){
                    if(m[i+1][j+1] == -1){ 
                        //game over
                        gameOver();
                    }else{ 
                        //jocul continua 
                        bx.setText(m[i+1][j+1]+"");
                        bx.setEnabled(false);
                        aiCastigat();
                        if(m[i+1][j+1] == 0){
                            if(0<i & i<11 & 0<j & j<11) b[i-1][j-1].setText(m[i][j]+"");
                            if(0<i & i<11 & -1<j & j<10) b[i-1][j].setText(m[i][j+1]+"");
                            if(0<i & i<11 & -2<j & j<9) b[i-1][j+1].setText(m[i][j+2]+"");
                            if(-1<i & i<10 & 0<j & j<11) b[i][j-1].setText(m[i+1][j]+"");
                            if(-1<i & i<10 & -2<j & j<9) b[i][j+1].setText(m[i+1][j+2]+"");
                            if(-2<i & i<9 & 0<j & j<11) b[i+1][j-1].setText(m[i+2][j]+"");
                            if(-2<i & i<9 & -1<j & j<10) b[i+1][j].setText(m[i+2][j+1]+"");
                            if(-2<i & i<9 & -2<j & j<9) b[i+1][j+1].setText(m[i+2][j+2]+"");
                                
                            if(m[i][j] != 0 & 0<i & i<11 & 0<j & j<11) b[i-1][j-1].setEnabled(false);
                            if(m[i][j+1] != 0 & 0<i & i<11 & -1<j & j<10) b[i-1][j].setEnabled(false);
                            if(m[i][j+2] != 0 & 0<i & i<11 & -2<j & j<9) b[i-1][j+1].setEnabled(false);
                            if(m[i+1][j] != 0 & -1<i & i<10 & 0<j & j<11) b[i][j-1].setEnabled(false);
                            if(m[i+1][j+2] != 0 & -1<i & i<10 & -2<j & j<9) b[i][j+1].setEnabled(false);
                            if(m[i+2][j] != 0 & -2<i & i<9 & 0<j & j<11) b[i+1][j-1].setEnabled(false);
                            if(m[i+2][j+1] != 0 & -2<i & i<9 & -1<j & j<10) b[i+1][j].setEnabled(false);
                            if(m[i+2][j+2] != 0 & -2<i & i<9 & -2<j & j<9) b[i+1][j+1].setEnabled(false);
                        }
                    }
                }
            }
        }
    } 
    
        
    public void dezactivareButoane(){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                b[i][j].setEnabled(false);
            }
        }
    }
    
    public void afisareMine(){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(m[i+1][j+1] == -1){
                    b[i][j].setIcon(ico2);
                }
            }
        }
    }
    
    public void gameOver(){
        dezactivareButoane();
        afisareMine();
        s.setIcon(ico3);
        JOptionPane.showMessageDialog(null,"BOOOOM!","GAME OVER",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void stergeEticheteButoane(){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                b[i][j].setText("");
            }
        }
    }
    
    public void stergeMineButoane(){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                b[i][j].setIcon(null);
            }
        }
    }
    
    public void activareButoane(){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                b[i][j].setEnabled(true);
            }
        }
    }
    
    public void newGame(){
        stergeEticheteButoane();
        stergeMineButoane();
        activareButoane();
        initializare();
        generare();
        count();
        s.setIcon(ico1);
    }
    
    public void aiCastigat(){
        boolean win = true;
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(b[i][j].getText() == "" && m[i+1][j+1] != -1){
                    win = false;
                }
            }
        }
        if(win == true) JOptionPane.showMessageDialog(null,"Ai castigat!","GAME OVER",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void main(String [] args){
        new E05Minesweeper();
    }
}