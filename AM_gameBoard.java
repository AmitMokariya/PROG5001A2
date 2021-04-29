import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class AM_gameBoard extends JPanel {    
    int xcells = 30;   
    int ycells = 30;
    int szcell = 10;       
       
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
