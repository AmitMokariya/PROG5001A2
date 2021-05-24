import java.awt.EventQueue;
import java.lang.String;
import javax.swing.JFrame;
import java.awt.*;  
import javax.swing.*; 

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

class Border {  
JFrame f;  
Border(){  
    f=new JFrame();         
    f.setSize(500,300);  
    f.setVisible(true);  
}  
public static void main(String[] args) {  
    new Border();  
}  

}  
/*class snack extends gameBoard{
     void run(){
         start_play();
         stop_play();
         System.out.println("Snack runs"); 
        }
     void stop(){
         System.out.println("Snack stops");
        }
        
     private void start_play() {
            }
            
     private void stop_play(){
        }
        
     void turnright() {
         
     
       }
       
     void turnleft() {
         
        }*/
        
    

    