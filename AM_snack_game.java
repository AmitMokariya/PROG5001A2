import java.awt.EventQueue;
import java.lang.String;
import javax.swing.JFrame;
public class AM_snack_game extends JFrame {

    public AM_snack_game(String gameTille) {        
        setTitle(gameTille);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();        
    }
    
    public static void main(String[] args) {        
        EventQueue.invokeLater(() -> {
            //create the game with a game title as follow: The Snake Game (C) Your_Name
            JFrame sgame = new AM_snack_game("");
            sgame.setVisible(true);
        });
    }
}
