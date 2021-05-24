import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.event.*;

public class AM_GameBoard extends JPanel implements ActionListener

{     
 
 
    
    int xcells = 30;   
    int ycells = 30;


    private final int DOT_SIZE = 10;
    private final int B_WIDTH = DOT_SIZE*xcells;
    private final int B_HEIGHT = DOT_SIZE*ycells;
    private final int ALL_DOTS = xcells * ycells;
    private final int RAND_POS = 29;
    private final int DELAY = 140;

    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];

    private int dots;
    private int apple_x;
    private int apple_y;

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    private Timer timer;
    private Image ball;
    private Image apple;
    private Image head;

    ScoreListener scoreListener;
    int score=0;
    
    public AM_GameBoard(ScoreListener scoreListener) {
        //This method create game board with black back ground colour and load image
        this.scoreListener = scoreListener;
        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        initGame();
        
        
        addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent arg0) {
                if(!inGame)
                {
                    initGame();
                }
            }
        });
    }
    
    private void loadImages() {

        ImageIcon iid = new ImageIcon("resources/dot.png");
        ball = iid.getImage();
        ball = ball.getScaledInstance(DOT_SIZE, DOT_SIZE, Image.SCALE_DEFAULT);

        ImageIcon iia = new ImageIcon("resources/apple.png");
        apple = iia.getImage();
        apple = apple.getScaledInstance(DOT_SIZE, DOT_SIZE, Image.SCALE_DEFAULT);

        ImageIcon iih = new ImageIcon("resources/head.png");
        head = iih.getImage();
        head = head.getScaledInstance(DOT_SIZE, DOT_SIZE, Image.SCALE_DEFAULT);
    }

    private void initGame() {

        leftDirection = false;
        rightDirection = true;
        upDirection = false;
        downDirection = false;
        inGame = true;
        dots = 3;
        scoreListener.scoreUpdate(0);
        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * DOT_SIZE;
            y[z] = 50;
        }

        locateApple();

        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    /*public void paintComponent(Graphics g) {
    g.setColor(Color.black);
    g.fillRect(0,0, getWidth(), getHeight());
    //g.setColor(Color.black);
    //g.fillOval(getWidth()/2, getHeight()/2, getWidth()/2, getHeight()/2);
  }*/
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0,0, getWidth(), getHeight());
        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        
        if (inGame) {

            g.drawImage(apple, apple_x, apple_y, this);

            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this);
                } else {
                    g.drawImage(ball, x[z], y[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {

            gameOver(g);
        }        
    }
    
    private void gameOver(Graphics g) {
        
        String msg = "GAME OVER";
        Font small = new Font("Arial", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
        msg = "CLICK TO PLAY";
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2+metr.getHeight());
        scoreListener.gameOver(score);
    }
    
    private void checkApple() {

        if ((x[0] == apple_x) && (y[0] == apple_y)) {
            score++;
            scoreListener.scoreUpdate(score);
            dots++;
            locateApple();
        }
    }
    
    private void move() {

        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
        }

        if (upDirection) {
            y[0] -= DOT_SIZE;
        }

        if (downDirection) {
            y[0] += DOT_SIZE;
        }
    }
    private void checkCollision() {

        for (int z = dots; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }

        if (y[0] >= B_HEIGHT) {
            inGame = false;
        }

        if (y[0] < 0) {
            inGame = false;
        }

        if (x[0] >= B_WIDTH) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }
        
        if(!inGame) {
            timer.stop();
        }
    }
    private void locateApple() {

        int r = (int) (Math.random() * RAND_POS);
        apple_x = ((r * DOT_SIZE));

        r = (int) (Math.random() * RAND_POS);
        apple_y = ((r * DOT_SIZE));
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {

            checkApple();
            checkCollision();
            move();
        }

        repaint();
    }
    
     private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
        }
        
    }
    
    public static void main(String args[]) {
    JFrame frame = new JFrame("OvalPaint");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    AM_GameBoard panel = new AM_GameBoard(new ScoreListener(){
        public void scoreUpdate(int score)
        {
        }
        public void gameOver(int score)
        {
        }
    });
    
    frame.add(panel);
    frame.setSize(300, 300);
    frame.setVisible(true);
  
}
}