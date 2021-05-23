/**
 * Write a description of class AM_snake here.
 *
 * @author (Amit gopal mokariya)
 * @version (1.0)
 * 23/05/2019
 */
import java.awt.EventQueue;
import javax.swing.JFrame;

public class AM_Snake extends JFrame {
      
        public AM_Snake() {
            
        initUI();
    }
    
    private void initUI() {
        
        add(new AM_GameBoard());
        
        setResizable(false);
        pack();
        
        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
   
     
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            JFrame ex = new AM_Snake();
            ex.setVisible(true);
        });
    }
}

