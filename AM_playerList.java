
/**
 * .
 *
 * @author (Amit mokariya)
 * @version (1.0)
 * UPDATE ON 22/05/2021
 */
import java.util.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.awt.event.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;



public class AM_PlayerList
{
        //list of player object
        private ArrayList<Player> playerList;
        //private AM_PlayerList playerList;
        
    
/** Constructor for object of class player   
     * 
     */
    
public AM_PlayerList() {
        // initialise the AM_player list
        playerList = new ArrayList<>();
         /*AM_PlayerList playerList = new AM_PlayerList();
        try {
            readPlayerFromFile("players.txt");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "File Not Found");
        }*/
    }
 
/**
     * Method to add a AM_player
     * @params name, password
     * @return none
     */
public void add(String name, String password) {
        Player player = new Player(name, password);
        playerList.add(player);
}

/**
     * Method to sort a player
     * @params direction (A - Acsending order, D - Descending order)
     * @return none
     */
    public void sort(char direction) {
        //modify this method to makes it works as expected
        if (direction == 'A') {
            //sort the list in ascending order
            Collections.sort(playerList);
        } else if (direction == 'D')        
        {
            //sort the list in descending order
            Collections.sort(playerList, Collections.reverseOrder());
        }
}


/**
     * Method to match a player in the list with a given name and password
     * @param name, password
     * @return true if matched and false if not
*/
public boolean matchPlayer (String name, String password) {
        boolean match;
        match = false;
        
        Iterator<Player> iter = playerList.iterator();
        while (iter.hasNext()) {
            Player player = iter.next();
            if ((player.name.compareTo(name)==0) && (player.password.compareTo(password)==0)) {
               match = true;
               break;
            }
        }        
        /*
         Player player = new player(name , password);
         if(playerList.indexOf(player)>0
        {
           match = true;
        }
         */
        return match;
    }
    
    /**
     * Method to convert the playerList to a string
     * @params none
     * @return a string that represents all AM_players in the list
     */
    @Override
    public String toString() {
        //modify this method to makes it works as expected
        String s = "";
        /*
        for (int i = 0; i < playerList.size(); i++) {
            Player player = playerList.get(i);
                s = s + player.toString() + "\n";
            }*/
        
       
        Iterator<Player> iter = playerList.iterator();
        while (iter.hasNext()) {
            Player player = iter.next();
            s = s + player.toString() + "\n";
        }
        return s;
    }
    
    /**
     * This private class for storing player's details 
     */
   class Player implements Comparable<Player> {
        public String name;
        public String password;
    
            public Player(String name, String password) {
            this.name = name;
            this.password = password;
        }
      
      @Override
        public String toString() {
            return name + "[pass=" + password + "]";
        }
 
      @Override
        public int compareTo(Player p) {
            return this.name.compareTo(p.name);
        }
    }
       
    /*
     * 
     */
    
    public static void main(String[] args) {
     
        AM_PlayerList playerList = new AM_PlayerList();
        playerList.add("Amit","5@5");
        playerList.add("Vinh","1@2");
        playerList.add("Atie","2@3");
        playerList.add("Raina","4@5");
        playerList.add("carolyn","0@5");
    //before short
    System.out.println("List before sorting: \n" + playerList);
    playerList.sort('D');
    if (playerList.matchPlayer("Vinh","1@2")) {
        System.out.println("matched a player \n");
}   else {
        System.out.println("Not found matching player \n");
}
//after short
    System.out.println("List after sorting: \n" + playerList);

    }
    
    
    
    
}



