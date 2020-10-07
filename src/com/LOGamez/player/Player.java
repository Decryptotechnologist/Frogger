/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LOGamez.player;

import com.LOGamez.audio.Sound;
import com.LOGamez.graphics.*;
import com.LOGamez.level.*;
import com.LOGamez.frogger.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.vecmath.Vector2f;

/**
 *
 * @author Nicholas Wright
 */
public class Player {

    /**Attributes*/
    
    /**x variable of Player*/ 
    //public int x;
    public float x;
    
    /**y variable of Player*/ 
    //public int y;
    public float y;
    
    /**dx variable of Player*/ 
    //double dx;
    float dx;
    
    /**dy variable of Player*/ 
    //double dy;
    float dy;
    
    /**Pwidth variable of Player*/ 
    int Pwidth;
    
    /**Pheight variable of Player*/ 
    int Pheight;
    
    /**lives variable of Player*/ 
    public static int lives;
    
    /**startLives variable of Player*/
    int startLives;
    
    /**LALCount variable of Player*/
    int LALCount;
    
    /**P1Rect variable of Player*/
    public static Rectangle P1Rect;
    
    /**moveSpeed variable of Player*/
    public static float moveSpeed;
    
    /**pLives0X variable of Player*/
    public static int pLives0X = 540;
    
    /**pLives1X variable of Player*/
    public static int pLives1X = 560;
    
    /**pLives2X variable of Player*/
    public static int pLives2X = 580;
    
    /**pLivesScale variable of Player*/
    public static int pLivesScale = 16;
    
    /**pLivesY variable of Player*/
    public static int pLivesY = Frogger.getMainHeight() - 56;
    
    /**isFiring variable of Player*/
    boolean isFiring;
    
    /**isDead variable of Player*/
    boolean isDead;
    
    /**mouseLeft variable of Player*/
    public static boolean mouseLeft;
    
    /**mouseRight variable of Player*/
    public static boolean mouseRight;
    
    /**mouseFire variable of Player*/
    public static boolean mouseFire;
    
    /**playerImg variable of Player*/
    BufferedImage playerImg;
    
    /**pLivesImg variable of Player*/
    public static BufferedImage pLivesImg;
    
    /**imgP1 variable of Player*/
    BufferedImage imgP1;
    
    /**imgPLives variable of Player*/
    public static BufferedImage imgPLives;
    
    /**playerName variable of Player*/
    String playerName;
    
    /**playerImg0 variable of Player*/
    BufferedImage playerImg0;
    
    /**playerImg1 variable of Player*/
    BufferedImage playerImg1;
    
    /**playerImg2 variable of Player*/
    BufferedImage playerImg2;
    
    /**currentVec variable of Player*/
    public static Vector2f currentVec;
    
    /**power variable of Player*/
    public static int power;

    /**levelNo variable of Player*/
    public static String levelNo;
    
    /**livesNo variable of Player*/
    public static String livesNo;
    
    /**playScore variable of Player*/
    private String playScore;
    
    /**isMoving variable of Player*/
    private boolean isMoving;
    
    /**playerAnim variable of Player*/
    private Animation playerAnim = new Animation(8, 
        new Texture("/sprites/Frogger_Right1a"), 
        new Texture("/sprites/Frogger_Right1b"), 
        new Texture("/sprites/Frogger_Right1c"), 
        new Texture("/sprites/Frogger_Right1a")
    );
    
    /**playerLeftAnim variable of Player*/
    private final Animation playerLeftAnim = new Animation(8, 
        new Texture("/sprites/Frogger_Left1a"), 
        new Texture("/sprites/Frogger_Left1b"), 
        new Texture("/sprites/Frogger_Left1c"), 
        new Texture("/sprites/Frogger_Left1a")
    );
    
    /**playerRightAnim variable of Player*/
    private final Animation playerRightAnim = new Animation(8, 
        new Texture("/sprites/Frogger_Right1a"), 
        new Texture("/sprites/Frogger_Right1b"), 
        new Texture("/sprites/Frogger_Right1c"), 
        new Texture("/sprites/Frogger_Right1a")
    );
    
    /**playerUpAnim variable of Player*/
    private final Animation playerUpAnim = new Animation(8, 
        new Texture("/sprites/Frogger_Up1a"), 
        new Texture("/sprites/Frogger_Up1b"), 
        new Texture("/sprites/Frogger_Up1c"), 
        new Texture("/sprites/Frogger_Up1a")
    );
    
    /**playerDownAnim variable of Player*/
    private final Animation playerDownAnim = new Animation(8, 
        new Texture("/sprites/Frogger_Down1a"), 
        new Texture("/sprites/Frogger_Down1b"), 
        new Texture("/sprites/Frogger_Down1c"), 
        new Texture("/sprites/Frogger_Down1a")
    );
    
    /**playerDeadAnim variable of Player*/
    private final Animation playerDeadAnim = new Animation(8, 
        new Texture("/sprites/Frogger_Death1b"), 
        new Texture("/sprites/Frogger_Death1b"), 
        new Texture("/sprites/Frogger_Death1b"), 
        new Texture("/sprites/Frogger_Death1b"),
        new Texture("/sprites/Frogger_Death1b"),
        new Texture("/sprites/Frogger_Death1b")    
    );
    
    /**isDeadCount variable of Player*/
    private int isDeadCount = 0;
    
    /**cellWidth variable of Player*/
    private final int cellWidth = 40/5;
    
    /**cellHeight variable of Player*/
    private final int cellHeight = 60/5;
    
    /**boundCol variable of Player*/
    private Color boundCol;
    
    /**pR variable of Player*/
    public Rectangle pR;
    
    

    
    /**Links*/
    
    
    
    
    
    /**Constructor*/
    
    
    /**
     * Player Constructor
     * 
     * 
     * @param _x
     * @param _y
     * @param w
     * @param h
     * @param name
     * @param Lives
     */
    //public Player(int _x, int _y, int w, int h, String name, int Lives) {
    public Player(float _x, float _y, int w, int h, String name, int Lives) {
        System.out.println("Player: New Player Created");
        
        this.x = _x/cellWidth;//_x;
        this.y = _y/cellHeight;//_y;
        this.currentVec = new Vector2f(this.x, this.y);
        this.Pwidth = w;
        this.Pheight = h;
        playerName = name;
        lives = Lives;
        this.startLives = lives;
        this.LALCount = 0;
        
        moveSpeed = 0.2f;//1.0f;
        isMoving = false;
        isDead = false;
        
        pLivesImg = new Texture("/sprites/Frogger_Life").getImage();
        playerImg = new Texture("/sprites/Frogger_Up1a").getImage();
        playerImg0 = new Texture("/sprites/Frogger_Right1a").getImage();
        playerImg1 = new Texture("/sprites/Frogger_Left1a").getImage();
        playerImg2 = new Texture("/sprites/Frogger_Down1a").getImage();
        
        imgP1 = playerImg;
        
        pR = new Rectangle((int) this.x, (int) this.y, this.Pwidth, this.Pheight);
    }
    
    
    
    /**Public Protocol*/
    
    
    /**
     * increasePlayerLives(int liv)
     * 
     * 
     * @param liv
     */
    public void increasePlayerLives(int liv) {
        lives += liv;
    }
    
    
    /**
     * render(Game game, Graphics2D g2d)
     * 
     *
     * @param g2d
     */
    public void render(Graphics2D g2d){
        Graphics2D g2d_Player = g2d;
        AffineTransform oldXForm = g2d.getTransform();
        
        //Draw Game Title
        g2d_Player.setColor(Color.GREEN);
        g2d_Player.drawString(Game.TITLE, Game.gameWidth/2 - Game.TITLE.length() * 3, 12);
        ///////////////////////////////////////////////////////////////////////////////////

        //Draw Player Name
        g2d_Player.setColor(Color.GRAY);
        g2d_Player.drawString("Player Name: ", Game.gameWidth/2 - Game.getPName().length() * 8, 28);
        g2d_Player.setColor(Color.GRAY);
        g2d_Player.drawString(Game.getPName(), Game.gameWidth/2 + Game.getPName().length() * 2, 28);
        ///////////////////////////////////////////////////////////////////////////////////
        
        //Draw Player Lives
        if(lives == 3){            
            g2d_Player.drawImage(imgPLives, pLives2X, pLivesY, pLivesScale, pLivesScale, null);
            g2d_Player.drawImage(imgPLives, pLives1X, pLivesY, pLivesScale, pLivesScale, null);
            g2d_Player.drawImage(imgPLives, pLives0X, pLivesY, pLivesScale, pLivesScale, null);
        }
        
        if(lives == 2){
            g2d_Player.drawImage(imgPLives, pLives1X, pLivesY, pLivesScale, pLivesScale, null);
            g2d_Player.drawImage(imgPLives, pLives0X, pLivesY, pLivesScale, pLivesScale, null);
        }
        
        if(lives == 1){
            g2d_Player.drawImage(imgPLives, pLives0X, pLivesY, pLivesScale, pLivesScale, null);
        }
        ///////////////////////////////////////////////////////////////////////////////////
        
        //Draw Hi-Score
        Font currentFont = new Font("default", Font.BOLD, 28);
        g2d_Player.setFont(currentFont);
        g2d_Player.setColor(Color.YELLOW);
        ///////////////////////////////////////////////////////////////////////////////////
        
        //Draw Current Score
        String currentScore;
        if(Game.gameScore == 0){ 
            currentScore = "000000";
        } else if(Game.gameScore > 0 && Game.gameScore < 1000){
            currentScore = "000"+Game.gameScore;
        } else if(Game.gameScore > 1000 && Game.gameScore < 10000){ 
            currentScore = "00"+Game.gameScore;
        } else if(Game.gameScore > 10000 && Game.gameScore < 100000){
            currentScore = "0"+Game.gameScore;
        } else if(Game.gameScore > 100000 && Game.gameScore < 1000000){ 
            currentScore = "0"+Game.gameScore;
        } else {
            currentScore = ""+Game.gameScore;
        }
        
        g2d_Player.drawString(currentScore, 36, 30);
        currentFont = new Font("default", Font.PLAIN, 10);
        g2d_Player.setFont(currentFont);
        ///////////////////////////////////////////////////////////////////////////////////
        
        if(isDead) playerDeadAnim.render(g2d, (int) this.x * cellWidth,  (int) this.y * cellHeight, this.Pwidth, this.Pheight);
                
        if(this.isDead == false){
            if(isMoving){
                //Draw Player Animation
                playerAnim.render(g2d, (int) this.x * cellWidth, (int) this.y * cellHeight, this.Pwidth, this.Pheight);
            } else {
                //Draw Player
                g2d_Player.drawImage(imgP1, (int) this.x * cellWidth, (int) this.y * cellHeight, this.Pwidth, this.Pheight, null);//Pwidth, Pheight, null);
                ///////////////////////////////////////////////////////////////////////////////////
            }
            
            
            //Draw Bounds
            if(Game.showBounds || Game.showPlayerBounds){
                //Draw Bounding Box
                g2d_Player.setColor(boundCol);
                g2d_Player.drawRect(pR.x, pR.y, pR.width, pR.height);
                g2d_Player.setColor(Color.white);
                g2d_Player.drawString(" x:"+pR.x+" y:"+pR.y, pR.x, pR.y);

                g2d_Player.setColor(Color.ORANGE);
                g2d_Player.drawRect(pR.x, pR.y, pR.width, pR.height);
                
            }
            ///////////////////////////////////////////////////////////////////////////////////
            
        }
        
        g2d.setTransform(oldXForm);
        g2d_Player.setTransform(oldXForm);
    
    }
    
    
    /**
     * tick(Game game, boolean up, boolean down, boolean left, boolean right, boolean fire)
     * 
     * 
     * @param game
     * @param up
     * @param down
     * @param left
     * @param right
     * @param fire
     */
    public void tick(Game game, boolean up, boolean down, boolean left, boolean right, boolean fire){//, boolean rotLeft, boolean rotRight){
        checkCollisions();
        //Load Player Lives Image
        imgPLives = pLivesImg;        
        
        if(left){
            isMoving = true;

            playerAnim = playerLeftAnim;
            imgP1 = playerImg1;
            if(x  * cellWidth > 0){
                dx -= moveSpeed;
            }
        } else 
        
        if(right){
            isMoving = true;

            playerAnim = playerRightAnim;
            imgP1 = playerImg0;
            if(x * cellWidth < Frogger.getMainWidth() - Pwidth){
                dx += moveSpeed;
            }
        } else
            
        if(down){
            isMoving = true;

            playerAnim = playerDownAnim;
            imgP1 = playerImg2;
            if((y * cellHeight) < 612){
                dy += moveSpeed;
            }
        } else 
        
        if(up){
            isMoving = true;

            playerAnim = playerUpAnim;
            imgP1 = playerImg;
            if((y * cellHeight) > 60){
                dy -= moveSpeed;
            }
        }
        
        if(Player.lives == 0){
            isDead = true;
            dead();
	}
        
        Player.lives = Player.getLives();
        this.x += this.dx;
        this.y += this.dy;
        
        currentVec = new Vector2f(this.x, this.y);
        
        this.dx = 0;
        this.dy = 0;
        
        if(!up && !down && !left && !right){
            isMoving = false;
        } else {
            playerAnim.run();
            playerLeftAnim.run();
            playerRightAnim.run();
            playerUpAnim.run();
            playerDownAnim.run();
        }
        
        playerDeadAnim.run();
        
        if(isDeadCount > 0 && isDead){ 
            isDeadCount--;
            System.out.println("Target Count: "+isDeadCount);
        } 
        if(isDeadCount == 0 && isDead){
            resetPlayer();
        }
        
    }
    
    
    /**
    * P1Hit()
    * 
    */
    public void P1Hit(){
        if(isDeadCount == 0 && isDead == false){
            loseALife();
            if(LALCount < startLives){
                LALCount += 1;
            } else {
                LALCount = 0;
            }
        }
    }
    
    
    /**
    * loseALife()
    * 
    */
    public void loseALife(){
        if(LALCount < 1){
            if(lives >= 1){
                lives--;
                isDead = true;
                isDeadCount = 110;
                
                if(Game.getGameSound()){
                    Sound.P1Exp.play();
                }
            }
        }
    }
    
    
    /**
    * dead()
    * 
    * 
    */
    public void dead(){
        System.out.println("Player: GAME OVER!!!");
        isDead = true;
        Game.loseGame();
    }
    
    
    /**
    * getLives()
    * 
    * 
    * @return lives
    */
    public static int getLives() {
        return lives;
    }
    
    
    /**
    * setPlayerName(String name)
    * 
    * 
    * @param name
    */
    public void setPlayerName(String name) {
        this.playerName = name;
    }
    
    
    
    /**
    * setPOW(int pow)
    * 
    * 
    * @param pow
    */
    public static void setPOW(int pow) {
        
    }
    
    
    /**
    * getPOW()
    * 
    * 
    * @return power
    */
    public static int getPOW() {
        return power;
    }

    
    /**
    * extraLife()
    * 
    * Checks if LALCount is less than 1 then 
    * checks if live is greater than or equal 
    * to 1. As the checks pass lives is 
    * decremented by 1 and a P1Explode is 
    * fired via the P1Explode.P1Detonate(this) 
    * message.
    * 
    */
    public void extraLife(){
	lives++;
	
        setPOW(getPOW());
    }

    
    /**
    * getPlayScore()
    * 
    * 
    * @return playScore
    */
    public String getPlayScore() {
        return playScore;
    }

    
    /**
    * setLives(int liv)
    * 
    * 
    * @param liv
    */
    public void setLives(int liv) {
        lives = liv;
    }

    
    /**
     * getBounds()
     * 
     * 
     * @return n1
     */
    public Rectangle getBounds() {
        Rectangle n1 = new Rectangle((int) this.x * 8, (int) (this.y * 12) - 60, this.Pwidth, this.Pheight);
        return n1;
    }

    
    /**
     * checkCollisions()
     * 
     * 
     */
    private void checkCollisions() {
        
        for(Rectangle r1 : Level.collisionList[0]){//Wall
            
            if(getBounds().intersects(r1)){
                System.out.println("Collision Detected!!! p1:"+pR.x+"-"+(pR.x+pR.width)+", "+pR.y+"-"+(pR.y+pR.height)+" r1:"+r1.x+"-"+(r1.x+r1.width)+", "+r1.y+"-"+(r1.y+r1.height));
                boundCol = Color.GREEN;
                
                //p1 hit
                this.P1Hit();
                //resetPlayer();
            }
            boundCol = Color.WHITE;
        }
        
        for(Rectangle r1 : Level.collisionList[1]){//Water
            
            if(getBounds().intersects(r1)){
                System.out.println("Water Collision Detected!!! p1:"+pR.x+"-"+(pR.x+pR.width)+", "+pR.y+"-"+(pR.y+pR.height)+" r1:"+r1.x+"-"+(r1.x+r1.width)+", "+r1.y+"-"+(r1.y+r1.height));
                boundCol = Color.GREEN;
                
                //p1 hit
                this.P1Hit();
                //resetPlayer();
            }
            boundCol = Color.WHITE;
        }
        
        for(Rectangle r1 : Level.collisionList[2]){//Water
            
            if(getBounds().intersects(r1)){
                System.out.println("Water Collision Detected!!! p1:"+pR.x+"-"+(pR.x+pR.width)+", "+pR.y+"-"+(pR.y+pR.height)+" r1:"+r1.x+"-"+(r1.x+r1.width)+", "+r1.y+"-"+(r1.y+r1.height));
                boundCol = Color.GREEN;
                
                //p1 hit
                this.P1Hit();
                //resetPlayer();
            }
            boundCol = Color.WHITE;
        }
        
        for(Rectangle r1 : Level.collisionList[3]){//Water
            
            if(getBounds().intersects(r1)){
                System.out.println("Water Collision Detected!!! p1:"+pR.x+"-"+(pR.x+pR.width)+", "+pR.y+"-"+(pR.y+pR.height)+" r1:"+r1.x+"-"+(r1.x+r1.width)+", "+r1.y+"-"+(r1.y+r1.height));
                boundCol = Color.GREEN;
                
                //p1 hit
                this.P1Hit();
                //resetPlayer();
            }
            boundCol = Color.WHITE;
        }
        
        for(Rectangle r1 : Level.collisionList[4]){//Logs
            
            if(getBounds().intersects(r1)){
                System.out.println("Log Collision Detected!!! p1:"+pR.x+"-"+(pR.x+pR.width)+", "+pR.y+"-"+(pR.y+pR.height)+" r1:"+r1.x+"-"+(r1.x+r1.width)+", "+r1.y+"-"+(r1.y+r1.height));
                boundCol = Color.GREEN;
                
                //p1 move with log
                if(this.x > 0) this.x -= moveSpeed * (Level.laneSpeed[1] * 0.3f);//1.0f;// Level.laneSpeed[2];//(Level.timeSinceStart * Level.laneSpeed[2]);
            }
            boundCol = Color.WHITE;
        }
        
        for(Rectangle r1 : Level.collisionList[10]){//Logs
            
            if(getBounds().intersects(r1)){
                System.out.println("Log Collision Detected!!! p1:"+pR.x+"-"+(pR.x+pR.width)+", "+pR.y+"-"+(pR.y+pR.height)+" r1:"+r1.x+"-"+(r1.x+r1.width)+", "+r1.y+"-"+(r1.y+r1.height));
                boundCol = Color.GREEN;
                
                //p1 move with log
                if(this.x > 0) this.x -= moveSpeed * (Level.laneSpeed[2] * 0.3f);//1.0f;// Level.laneSpeed[2];//(Level.timeSinceStart * Level.laneSpeed[2]);
            }
            boundCol = Color.WHITE;
        }
        
        for(Rectangle r1 : Level.collisionList[11]){//Logs
            
            if(getBounds().intersects(r1)){
                System.out.println("Log Collision Detected!!! p1:"+pR.x+"-"+(pR.x+pR.width)+", "+pR.y+"-"+(pR.y+pR.height)+" r1:"+r1.x+"-"+(r1.x+r1.width)+", "+r1.y+"-"+(r1.y+r1.height));
                boundCol = Color.GREEN;
                
                //p1 move with log
                if(this.x > 0) this.x -= moveSpeed * (Level.laneSpeed[3] * 0.3f);//1.0f;// Level.laneSpeed[2];//(Level.timeSinceStart * Level.laneSpeed[2]);
            }
            boundCol = Color.WHITE;
        }
        
        for(Rectangle r1 : Level.collisionList[5]){//Cars
            
            if(getBounds().intersects(r1)){
                System.out.println("Car Collision Detected!!! p1:"+pR.x+"-"+(pR.x+pR.width)+", "+pR.y+"-"+(pR.y+pR.height)+" r1:"+r1.x+"-"+(r1.x+r1.width)+", "+r1.y+"-"+(r1.y+r1.height));
                boundCol = Color.GREEN;
                
                //p1 hit
                this.P1Hit();
                //resetPlayer();
            }
            boundCol = Color.WHITE;
        }
        
        for(Rectangle r1 : Level.collisionList[6]){//Buses
            
            if(getBounds().intersects(r1)){
                System.out.println("Bus Collision Detected!!! p1:"+pR.x+"-"+(pR.x+pR.width)+", "+pR.y+"-"+(pR.y+pR.height)+" r1:"+r1.x+"-"+(r1.x+r1.width)+", "+r1.y+"-"+(r1.y+r1.height));
                boundCol = Color.GREEN;
                
                //p1 hit
                this.P1Hit();
                //resetPlayer();
            }
            boundCol = Color.WHITE;
        }
        
        for(Rectangle r1 : Level.collisionList[7]){//Cars
            
            if(getBounds().intersects(r1)){
                System.out.println("Car Collision Detected!!! p1:"+pR.x+"-"+(pR.x+pR.width)+", "+pR.y+"-"+(pR.y+pR.height)+" r1:"+r1.x+"-"+(r1.x+r1.width)+", "+r1.y+"-"+(r1.y+r1.height));
                boundCol = Color.GREEN;
                
                //p1 hit
                this.P1Hit();
                //resetPlayer();
            }
            boundCol = Color.WHITE;
        }
        
        for(Rectangle r1 : Level.collisionList[8]){//Cars
            
            if(getBounds().intersects(r1)){
                System.out.println("Car Collision Detected!!! p1:"+pR.x+"-"+(pR.x+pR.width)+", "+pR.y+"-"+(pR.y+pR.height)+" r1:"+r1.x+"-"+(r1.x+r1.width)+", "+r1.y+"-"+(r1.y+r1.height));
                boundCol = Color.GREEN;
                
                //p1 hit
                this.P1Hit();
                //resetPlayer();
            }
            boundCol = Color.WHITE;
        }
        
        for(Rectangle r1 : Level.collisionList[9]){//Home
            
            if(getBounds().intersects(r1)){
                //increase score
                Game.increaseScore(200);
                System.out.println("Home Collision Detected!!! p1:"+pR.x+"-"+(pR.x+pR.width)+", "+pR.y+"-"+(pR.y+pR.height)+" r1:"+r1.x+"-"+(r1.x+r1.width)+", "+r1.y+"-"+(r1.y+r1.height));
                boundCol = Color.GREEN;
                
                //p1 hit
                //this.P1Hit();
                
                //Home Hit
                if(r1.x < 100) Level.lane[0].toCharArray()[3] = 'f';//Level.lane[0] = "wrfvwrhvwrhvwrhvwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww";//HomeBase//Level.lane[0].toCharArray()[3] = 'f';
                if(r1.x > 100 && r1.x < 400) Level.lane[0] = "wrfvwrfvwrhvwrhvwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww";//HomeBase//Level.lane[0].toCharArray()[7] = 'f';
                if(r1.x > 400) Level.lane[0] = "wrfvwrfvwrfvwrhvwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww";//HomeBase//Level.lane[0].toCharArray()[11] = 'f';
                resetPlayer();
            }
            boundCol = Color.WHITE;
        }
    }

    
    /**
     * resetPlayer()
     * 
     */
    public void resetPlayer() {
        this.x = Level.playerStartX/cellWidth;
        this.y = Level.playerStartY/cellHeight;
        isDead = false;
    }

}
