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
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;



public class AM_ScoreBoard
{
        //list of player object
        private ArrayList<Score> scoresList;
        //private AM_PlayerList playerList;
        
    
/** Constructor for object of class player   
     * 
     */
    
public AM_ScoreBoard() {
        // initialise the AM_player list
        scoresList = new ArrayList<>();
        try {
            readScoresFromFile("scores.txt");
        } catch (FileNotFoundException e) {
            //JOptionPane.showMessageDialog(this, "File Not Found");
        }
    }
 
/**
     * Method to add a AM_player
     * @params name, password
     * @return none
     */
public void add(String name, String score) {
        Score record = new Score(name, score);
        scoresList.add(record);
}

public void updateScore(String name, String score) {
    
    Iterator<Score> iter = scoresList.iterator();  
    boolean found = false;
    while(iter.hasNext())
    {
        Score record= iter.next();
        if(record.name.equals(name))
        {
            if(Integer.parseInt(score)>Integer.parseInt(record.score))
                record.score = score;
            found = true;
            break;
        }
    }
    if(!found)
    {
        Score record = new Score(name, score);
        scoresList.add(record);
    }
    try{
    saveScoresToFile("scores.txt");
}catch(Exception e){}   
}


public String getHighestScore()
{
    Iterator<Score> iter = scoresList.iterator();
    Score highest = null;
    if(iter.hasNext())
        highest = iter.next();
        
    while(iter.hasNext())
    {
        Score record= iter.next();
        if(Integer.parseInt(record.score)>Integer.parseInt(highest.score))
            highest = record;
    }
    if(highest == null)
        return "None";
    else
        return highest.toString();
}

private void readScoresFromFile(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
     
        //Creating Scanner instnace to read File in Java
        Scanner scnr = new Scanner(file);
     
        //Reading each line of file using Scanner class
        while(scnr.hasNextLine()){
            String line = scnr.nextLine();
            Scanner uscanner = new Scanner(line);
            String username = uscanner.next();
            String password = uscanner.next(); 
            add(username, password);
            //JOptionPane.showMessageDialog(this, username + ": " + password);
        }      
    }

    
private void saveScoresToFile(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
     
        PrintWriter writer = new PrintWriter(file);
     
        Iterator<Score> iter = scoresList.iterator();
        while(iter.hasNext())
        {
            Score p = iter.next();
            writer.println(p.name+" "+p.score);
        }
        writer.close();
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
            Collections.sort(scoresList);
        } else if (direction == 'D')        
        {
            //sort the list in descending order
            Collections.sort(scoresList, Collections.reverseOrder());
        }
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
        
       
        Iterator<Score> iter = scoresList.iterator();
        while (iter.hasNext()) {
            Score player = iter.next();
            s = s + player.toString() + "\n";
        }
        return s;
    }
    
    /**
     * This private class for storing player's details 
     */
   class Score implements Comparable<Score> {
        public String name;
        public String score;
    
            public Score(String name, String score) {
            this.name = name;
            this.score = score;
        }
      
      @Override
        public String toString() {
            return name + "[score=" + score + "]";
        }
 
      @Override
        public int compareTo(Score p) {
            return this.name.compareTo(p.name);
        }
    }
       
    /*
     * 
     */
    
    public static void main(String[] args) {
     
        AM_ScoreBoard scoreBoard = new AM_ScoreBoard();
        scoreBoard.add("Amit","20");
        scoreBoard.add("Vinh","2");
        scoreBoard.add("Atie","23");
        scoreBoard.add("Raina","4");
        scoreBoard.add("carolyn","5");
   
    }
    
    
    
    
}



