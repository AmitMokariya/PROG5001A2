/**
 * Write a description of class AM_snake here.
 *
 * @author (Amit gopal mokariya)
 * @version (1.0)
 * 23/05/2019
 */
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class AM_Snake extends JFrame implements ScoreListener{
    String playerName;
    AM_ScoreBoard scoreBoard;
    JLabel currentScore;
    public AM_Snake(String playerName) {
        this.playerName = playerName;
        scoreBoard = new AM_ScoreBoard();   
        initUI();
    }
    
    private void initUI() {
        setLayout(new FlowLayout());
        
        
        JLabel topScore = new JLabel("HIGHEST: "+scoreBoard.getHighestScore(),SwingConstants.CENTER);
        topScore.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLUE, 1),new EmptyBorder(10, 10, 10, 10)));
        
        currentScore = new JLabel("YOUR SOCRE: 134",SwingConstants.CENTER);
        currentScore.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLUE, 1),new EmptyBorder(10, 10, 10, 10)));
        
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("resources/logo.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        JLabel gameLogo = new JLabel(imageIcon,SwingConstants.CENTER);
        
        JLabel projectInfo = new JLabel("<html>PROG5001: 2021<br/>Amit Mokariya</html>", SwingConstants.CENTER);
        projectInfo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLUE, 1),new EmptyBorder(10, 10, 10, 10)));
        
        JButton quitButton = new JButton("QUIT");
        quitButton.addActionListener(new ActionListener() {        
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        JPanel optionsPanel = new JPanel(new GridBagLayout());
        optionsPanel.setPreferredSize(new Dimension(200,310));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        
        
        optionsPanel.add(topScore,gbc);
        optionsPanel.add(Box.createRigidArea(new Dimension(10,10)),gbc);
        optionsPanel.add(currentScore,gbc);
        optionsPanel.add(Box.createRigidArea(new Dimension(1,10)),gbc);

        optionsPanel.add(gameLogo,gbc);
        optionsPanel.add(Box.createRigidArea(new Dimension(1,10)),gbc);

        optionsPanel.add(projectInfo,gbc);
        optionsPanel.add(Box.createRigidArea(new Dimension(1,10)),gbc);

        optionsPanel.add(quitButton,gbc);
        
        add(new AM_GameBoard(this));
        add(optionsPanel);
        
        pack();
        setTitle("Snake");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
   
    public void scoreUpdate(int score)
    {
        currentScore.setText("YOUR SOCRE: "+score);
    }
    public void gameOver(int score)
    {
        scoreBoard.updateScore(playerName,String.valueOf(score));
    }
     
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            JFrame ex = new AM_Snake("Amit");
            ex.setVisible(true);
        });
    }
}

