/**
 * Write a description of class AM_player here.
 *
 * @author (Amit mokariya)
 * @version (1.0)
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;

public class AM_playerList
{
    // list of AM_player objects
    private ArrayList<AM_player> AM_playerList;
 
    /**
     * Constructor for objects of class AM_player
     */
    public AM_playerList() {
        // initialise the AM_player list
        AM_playerList = new ArrayList<>();
    }

    /**
     * Method to add a AM_player
     * @params name, password
     * @return none
     */
    public void add(String name, String password) {
        AM_player AM_player = new AM_player(name, password);
        AM_playerList.add(AM_player);
    }

    /**
     * Method to sort AM_playerList
     * @params direction (A - Acsending order, D - Descending order)
     * @return none
     */
    public void sort(char direction) {
        //modify this method to makes it works as expected
        if (direction == 'A') {
            //sort the list in ascending order
            Collections.sort(AM_playerList);
        } else if (direction == 'D')        
        {
            //sort the list in descending order
            Collections.sort(AM_playerList, Collections.reverseOrder());
        }
    }


    /**
     * Method to match a AM_player in the list with a given name and password
     * @param name, password
     * @return true if matched and false if not
     */
    public boolean matchPlayer(String name, String password) {
        boolean match;
        match = false;
        
        Iterator<AM_player> iter = AM_playerList.iterator();
        while (iter.hasNext()) {
            AM_player AM_player = iter.next();
            if ((AM_player.name.compareTo(name)==0) && (AM_player.password.compareTo(password)==0)) {
               match = true;
               break;
            }
        }        
        
        return match;
    }
    
    /**
     * Method to convert the AM_playerList to a string
     * @params none
     * @return a string that represents all AM_players in the list
     */
    @Override
    public String toString() {
        //modify this method to makes it works as expected
        String s = "";
        /*
        for (int i = 0; i < AM_playerList.size(); i++) {
            AM_player AM_player = AM_playerList.get(i);
                s = s + AM_player.toString() + "\n";
            }*/
        
       
        Iterator<AM_player> iter = AM_playerList.iterator();
        while (iter.hasNext()) {
            AM_player AM_player = iter.next();
            s = s + AM_player.toString() + "\n";
        }
        return s;
    }
    
    /**
     * This private class for storing AM_player's details 
     */
    class AM_player implements Comparable<AM_player> {
        public String name;
        public String password;
    
        public AM_player(String name, String password) {
            this.name = name;
            this.password = password;
        }
      
        @Override
        public String toString() {
            return name + "[pass=" + password + "]";
        }
 
        @Override
        public int compareTo(AM_player p) {
            return this.name.compareTo(p.name);
        }
    }
    /**
 * player list 
 */
public static void main(String[] args) {
    AM_player playerList = new AM_player();
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
} else {
    System.out.println("Not found matching player \n");
}
//after short
System.out.println("List after sorting: \n" + playerList);

    }
}
 


