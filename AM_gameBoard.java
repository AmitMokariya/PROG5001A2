import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;

public class AM_gameBoard extends JPanel 
{     
 
  /* public void paintComponent(Graphics g){
      setBackground(Color.black);
      repaint();
    }*/
  public void paintComponent(Graphics g) {
    g.setColor(Color.black);
    g.fillRect(1,0, getWidth(), getHeight());
    //g.setColor(Color.black);
    //g.fillOval(getWidth()/2, getHeight()/2, getWidth()/2, getHeight()/2);
  }
  
  public static void main(String args[]) {
    JFrame frame = new JFrame("OvalPaint");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    AM_gameBoard panel = new AM_gameBoard();
    
    frame.add(panel);
    frame.setSize(200, 200);
    frame.setVisible(true);
  
}
    int xcells = 30;   
    int ycells = 30;
    int szcell = 10;       
    //This method create game board with black back ground colour   
    public AM_gameBoard() {
        setPreferredSize(new Dimension(xcells * szcell, ycells * szcell));        
        setBackground(Color.black);
        setFocusable(true);        
    }

   // @Override
    //public void paintComponent(Graphics g) {
   //     super.paintComponent(g);
    //}
    
}
    

    
 
   
abstract class gameBoard {
    int size;
    int speed;
     void run(){
        }
    
     void stop(){
        }
    // Below method display name of the game
    void printgameboard(){
        System.out.println ("This is a snack Game");
    }
}
