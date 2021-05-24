import java.awt.EventQueue;
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
import javax.swing.JOptionPane;
import java.awt.event.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
 
/**
 * This program demonstrates how to use JFrame and LayoutManager.
 * @author Amit mokariya
 */

public class AM_Login extends JFrame implements ActionListener{
    private JLabel labelUsername;
    private JLabel labelPassword;   
    private JTextField textUsername;
    private JPasswordField fieldPassword;
    private JButton buttonLogin;
    private JButton buttonRegister;
    private AM_PlayerList AM_playerList;
 
    public AM_Login() {
        super("Login Form");
        //setdefaultCloseOperation(EXIT_ON_CLOSE);
        labelUsername = new JLabel("Enter username: ");
        labelPassword = new JLabel("Enter password: ");   
        textUsername = new JTextField(20);
        fieldPassword = new JPasswordField(20);
        buttonLogin = new JButton("Login");
        buttonRegister = new JButton("Register");
        
        // create a new panel with GridBagLayout manager
        JPanel panelLogin = new JPanel(new GridBagLayout());
        
        //use contrains to control the gridbaglayout
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
         
        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;     
        panelLogin.add(labelUsername, constraints);
 
        constraints.gridx = 1;
        panelLogin.add(textUsername, constraints);
         
        constraints.gridx = 0;
        constraints.gridy = 1;     
        panelLogin.add(labelPassword, constraints);
         
        constraints.gridx = 1;
        panelLogin.add(fieldPassword, constraints);
         
        constraints.gridx = 0;
        constraints.gridy = 2;
        panelLogin.add(buttonRegister, constraints);

        
                  
        constraints.gridx = 1;
        panelLogin.add(buttonLogin, constraints);
        
        // add the panel to this frame
        add(panelLogin);
         
        pack();
        
        //make the form apprear in the screen centre
        setLocationRelativeTo(null);
        
        //add ActionListener to the button
        buttonLogin.addActionListener(this);
        buttonRegister.addActionListener(new ActionListener(){
                    
            public void actionPerformed (ActionEvent e) {
                String username = textUsername.getText();
                String password = fieldPassword.getText();
                AM_playerList.register(username,password);
                JOptionPane.showMessageDialog(AM_Login.this, "User registered successfully.");
                
            }
        });
        
        //instantiate the playerList
        AM_playerList = new AM_PlayerList();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AM_Login().setVisible(true);
            }
        });
    }
    public void actionPerformed (ActionEvent e) {
        String username = textUsername.getText();
        String password = fieldPassword.getText();
        
        if (AM_playerList.matchPlayer(username,password)) 
        {
            //JOptionPane.showMessageDialog(this, username + ": login successfully");
            EventQueue.invokeLater(() -> {
            JFrame ex = new AM_Snake(username);
            ex.setVisible(true);
        });
            
        } else {
            JOptionPane.showMessageDialog(this, "wrong username or password");
        }

    }
    
    
    
}