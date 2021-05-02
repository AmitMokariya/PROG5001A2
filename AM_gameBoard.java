import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class AM_gameBoard extends JPanel {    
    int xcells = 30;   
    int ycells = 30;
    int szcell = 10;       
    //This method create game board with black back ground colour   
    public AM_gameBoard() {
        setPreferredSize(new Dimension(xcells * szcell, ycells * szcell));        
        setBackground(Color.black);
        setFocusable(true);        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    
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