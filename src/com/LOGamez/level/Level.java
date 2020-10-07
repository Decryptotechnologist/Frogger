/*
OneLoneCoder.com - Code-It-Yourself! Frogger at the command prompt (quick and simple c++)
"Ribbet" - @Javidx9
License
~~~~~~~
Copyright (C) 2018  Javidx9
This program comes with ABSOLUTELY NO WARRANTY.
This is free software, and you are welcome to redistribute it
under certain conditions; See license for details. 
Original works located at:
https://www.github.com/onelonecoder
https://www.onelonecoder.com
https://www.youtube.com/javidx9
GNU GPLv3
https://github.com/OneLoneCoder/videos/blob/master/LICENSE
From Javidx9 :)
~~~~~~~~~~~~~~~
Hello! Ultimately I don't care what you use this for. It's intended to be 
educational, and perhaps to the oddly minded - a little bit of fun. 
Please hack this, change it and use it in any way you see fit. You acknowledge 
that I am not responsible for anything bad that happens as a result of 
your actions. However this code is protected by GNU GPLv3, see the license in the
github repo. This means you must attribute me if you use it. You can view this
license here: https://github.com/OneLoneCoder/videos/blob/master/LICENSE
Cheers!
Background
~~~~~~~~~~
This is a bit of an unusual one. The games mechanics are very simple, but as soon
as you add graphics the code almost doubles in size! By standardising how the
lanes work and interact with the frog, the game pretty much controls itself, meaning
the game code is really really short. Everything else is eye candy.
Controls
~~~~~~~~
Arrow keys move frog. Cross the road, then the river, to get frog to safety.
Author
~~~~~~
Twitter: @javidx9
Blog: www.onelonecoder.com
Video:
~~~~~~
https://youtu.be/QJnZ5QmpXOE
Last Updated: 20/08/2017
*/
package com.LOGamez.level;

import com.LOGamez.audio.Sound;
import com.LOGamez.graphics.*;
import com.LOGamez.frogger.*;
import com.LOGamez.gui.HUD;
import com.LOGamez.player.Player;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Nicholas Wright, javidx9
 */
public class Level {
    
    /**Attributes*/ 
    
    /**EnSpeedGlobal variable of Level*/ 
    public static int EnSpeedGlobal = 1;
    
    /**background variable of Level*/ 
    public static int background = 1;
    
    /**bgW coordinate of Level*/ 
    public static double bgW = 0.18 * 6;
    
    /**bgH coordinate of Level*/ 
    public static double bgH = 0.18 * 6;
    
    /**bgX coordinate of Level*/ 
    public static double bgX = (Frogger.getMainWidth()/5);
    
    /**bgY coordinate of Level*/ 
    public static double bgY = 200 + (720/6.0) /8;
    
    /**levelNo variable of Level*/ 
    public static int levelNo;
    
    /**levelName variable of Level*/ 
    private static String levelName;
    
    /**levelComplete variable of Level*/ 
    public static boolean levelComplete = false;
    
    /**gameComplete variable of Level*/ 
    private static boolean gameComplete;
    
    /**groundScale variable of Level*/ 
    public static double groundScale;
    
    /**groundX coordinate of Level*/ 
    public static int groundX;
    
    /**groundY coordinate of Level*/ 
    public static int groundY;
    
    /**powScale variable of Level*/ 
    public static double powScale;
    
    /**groundBounds Rectangle of Level*/ 
    public static Rectangle groundBounds;
    
    /**playerStartX variable of Level*/
    public static int playerStartX = 270;
    
    /**playerStartY variable of Level*/
    public static int playerStartY = 600;
    
    /**levelCompleteCount variable of Level*/ 
    private int levelCompleteCount;
    
    /**levelStartCount variable of Level*/ 
    private int levelStartCount;
    
    /**firstTick variable of Level*/
    public static boolean firstTick;
    
    /**lastTick variable of Level*/
    public static boolean lastTick;
    
    /**theLevelTime variable of Level*/
    public static String theLevelTime;
    
    /**lanes variable of Level*/
    public Map<String, Float> lanes = new HashMap<>(10);
    
    /**lane variable of Level*/
    public static String[] lane = new String[10];
    
    /**laneSpeed variable of Level*/
    public static float[] laneSpeed = new float[10];
    
    /**timeSinceStart variable of Level*/
    public static float timeSinceStart;

    /**cellWidth variable of Level*/
    private int cellWidth;
    
    /**cellHeight variable of Level*/
    private int cellHeight;
    
    /**img variable of Level*/
    private BufferedImage img;
    
    /**bus_R_A variable of Level*/
    private BufferedImage bus_R_A;
    
    /**bus_R_B variable of Level*/
    private BufferedImage bus_R_B;
    
    /**car_R_A variable of Level*/
    private BufferedImage car_R_A;
    
    /**car_R_B variable of Level*/
    private BufferedImage car_R_B;
    
    /**car_R_C variable of Level*/
    private BufferedImage car_R_C;
    
    /**car_R_D variable of Level*/
    private BufferedImage car_R_D;
    
    /**bus_L_A variable of Level*/
    private BufferedImage bus_L_A;
    
    /**bus_L_B variable of Level*/
    private BufferedImage bus_L_B;
    
    /**car_L_A variable of Level*/
    private BufferedImage car_L_A;
    
    /**car_L_B variable of Level*/
    private BufferedImage car_L_B;
    
    /**car_L_C variable of Level*/
    private BufferedImage car_L_C;
    
    /**car_L_D variable of Level*/
    private BufferedImage car_L_D;
    
    /**logA variable of Level*/
    private BufferedImage logA;
    
    /**logB variable of Level*/
    private BufferedImage logB;
    
    /**logC variable of Level*/
    private BufferedImage logC;
    
    /**pavement variable of Level*/
    private BufferedImage pavement;
    
    /**pavementA variable of Level*/
    private BufferedImage pavementA;
    
    /**wall_L variable of Level*/
    private BufferedImage wall_L;
    
    /**wall_R variable of Level*/
    private BufferedImage wall_R;
    
    /**wall_Centre variable of Level*/
    private BufferedImage wall_Centre;
    
    /**home variable of Level*/
    private BufferedImage home;
    
    /**water variable of Level*/
    private BufferedImage water;
    
    /**road variable of Level*/
    private BufferedImage road;
    
    /**bus_Centre variable of Level*/
    private BufferedImage bus_Centre;
    
    //private boolean[] bufDanger;
    
    /**r1 variable of Level*/
    private Rectangle r1;
    
    /**collisionList variable of Level*/
    public static List<Rectangle>[] collisionList = new List[12];
    
    /**r2 variable of Level*/
    private Rectangle r2;
    private BufferedImage home_Complete;
    
    
    
    /**Constructor*/
    
    /**
     * Level(int lNo)
     * 
     * @param lNo - level number of Level
     * @param w
     * @param h
     */
    public Level(int lNo, int w, int h){
        System.out.println("Level: New Level "+lNo+" Created");
        Game.labels = new Labels();
        Game.hud = new HUD();
        levelNo = lNo;
        
        System.out.println("Level: Loading Level "+levelNo+" : "+getLevelName());
        
        //Create Player
        if(Player.getLives() > 0 && levelNo != 1){
            //set player lives to current player lives
            Game.player = new Player(270, 600, 40, 40, Game.getPName(), Player.getLives());
        } else {
            //set player lives to 3
            Game.player = new Player(270, 600, 40, 40, Game.getPName(), 3);
        }
        
        setUp();
        
        init();
    }
    
    
    /**
     * setUp()
     * 
     */
    private void setUp(){
        
        switch(levelNo){
            case 1:
                setUpLevel1();
                break;
            case 2:
                setUpLevel2();
                break;
            case 3:
                setUpLevel3();
                break;
            case 4:
                setUpLevel4();
                break;
            case 5:
                setUpLevel5();
                break;
            case 6:
                setUpLevel6();
                break;
            case 7:
                setUpLevel7();
                break;
            case 8:
                setUpLevel8();
                break;
            case 9:
                setUpLevel9();
                break;
        }
        
    }
    
    
    /**
     * setUpLevel1()
     * 
     */
    private void setUpLevel1() {
        int width = Frogger.getMainWidth();
        
        //Set Enemies Color
        //Set Enemy Color: White
//        Enemy.setEnemyCol(0xffffff);//White

        //Set Enemy Bullet Color: White
//        Bullet.setEnemyBulletCol(0xffffff);//White

        //Set Level Background: 1
        setBackground(1);//1: Moon(Small)
        
        //Set Barricade Color: Green
//        Barricade.setBarricadeCol(0x00ff00);//Green
        
        //Set Ground Color: Green
        setGroundColor(0x00ff00);//Green

        //Set Level Text Background Color: Green
//        levelTxtBGCol = 0x00ff00;//Green

        //Set Enter Level Icon Background Color: Light Green
//        enterLvlIconBG = 0x00CD02;//Light Green

        //Set Enter Level Icon Foreground Color: Crimson
//        enterLvlIconFG = 0x00B200;//Crimson
                
        switch(width){
            case 300:
                //Set Enemies
                //E0rows = 10, E1rows = 10, E2rows = 10, E3rows = 10, E4rows = 10, E5rows = 10, E6rows = 10, E7rows = 0, E8rows = 0, E9rows = 0;
                /**
                *   **********
                *   **********
                *   **********
                *   **********
                *   **********
                *   **********
                *   **********
                * 
                * 
                * 
                */
//                Enemy.setNoEnemy(10, 10, 10, 10, 10, 10, 10, 0, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
//                //Set Enemy Color: White
//                Enemy.setEnemyCol(0xffffff);//White
//                
//                //Set Enemy Bullet Color: White
//                Bullet.setEnemyBulletCol(0xffffff);//White
//    
//                //Set Level Background: 1
//                setBackground(1);//1: Moon(Small)
            
                //Set Barricades
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **     **
                *  ****   ****   ****   ****
                *  ****   ****   ****   ****
                */
//                Barricade.setNoBarricades(4);
                
//                //Set Barricade Color: Green
//                Barricade.setBarricadeCol(0x00ff00);//Green
                
                //Set POW Scale: 0.75
                powScale = 0.75;
            
                //Set Ground
                //Set Ground Scale: 1.0
                groundScale = 1.0;
                
                //Set Ground POS: 4, Game.getGameHeight() - 140;
                groundX = 4;
                groundY = Frogger.getMainHeight() - 140;
                
//                //Set Ground Color: Green
//                setGroundColor(0x00ff00);//Green
//                
//                //Set Level Text Background Color: Green
//                levelTxtBGCol = 0x00ff00;//Green
//                
//                //Set Enter Level Icon Background Color: Light Green
//                enterLvlIconBG = 0x00CD02;//Light Green
//                
//                //Set Enter Level Icon Foreground Color: Crimson
//                enterLvlIconFG = 0x00B200;//Crimson
                
                break;
                
            case 480:
                //Set Enemies
                //E0rows = 10, E1rows = 10, E2rows = 10, E3rows = 10, E4rows = 10, E5rows = 10, E6rows = 10, E7rows = 0, E8rows = 0, E9rows = 0;
                /**
                *   **********
                *   **********
                *   **********
                *   **********
                *   **********
                *   **********
                *   **********
                * 
                * 
                * 
                */
//                Enemy.setNoEnemy(10, 10, 10, 10, 10, 10, 10, 0, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
//                //Set Enemy Color: White
//                Enemy.setEnemyCol(0xffffff);//White
//                
//                //Set Enemy Bullet Color: White
//                Bullet.setEnemyBulletCol(0xffffff);//White
//    
//                //Set Level Background: 1
//                setBackground(1);//1: Moon(Small)
            
                //Set Barricades
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **     **
                *  ****   ****   ****   ****
                *  ****   ****   ****   ****
                */
//                Barricade.setNoBarricades(4);
                
//                //Set Barricade Color: Green
//                Barricade.setBarricadeCol(0x00ff00);//Green
                
                //Set POW Scale: 0.75
                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 1.25
                groundScale = 1.25;
                
                //Set Ground POS: 10, Game.getGameHeight() - 140
                groundX = 10;
                groundY = Frogger.getMainHeight() - 140;
                
//                //Set Ground Color: Green
//                setGroundColor(0x00ff00);//Green
//                
//                //Set Level Text Background Color: Green
//                levelTxtBGCol = 0x00ff00;//Green
//                
//                //Set Enter Level Icon Background Color: Light Green
//                enterLvlIconBG = 0x00CD02;//Light Green
//                
//                //Set Enter Level Icon Foreground Color: Crimson
//                enterLvlIconFG = 0x00B200;//Crimson
                
                break;
                
            case 604:
                //Set Enemies
                //E0rows = 10, E1rows = 10, E2rows = 10, E3rows = 10, E4rows = 10, E5rows = 10, E6rows = 10, E7rows = 0, E8rows = 0, E9rows = 0;
                /**
                *   **********
                *   **********
                *   **********
                *   **********
                *   **********
                *   **********
                *   **********
                * 
                * 
                * 
                */
//                Enemy.setNoEnemy(10, 10, 10, 10, 10, 10, 10, 0, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
//                //Set Enemy Color: White
//                Enemy.setEnemyCol(0xffffff);//White
//                
//                //Set Enemy Bullet Color: White
//                Bullet.setEnemyBulletCol(0xffffff);//White
//    
//                //Set Level Background: 1
//                setBackground(1);//1: Moon(Small)
            
                //Set Barricades
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **     **
                *  ****   ****   ****   ****
                *  ****   ****   ****   ****
                */
//                Barricade.setNoBarricades(4);
                
//                //Set Barricade Color: Green
//                Barricade.setBarricadeCol(0x00ff00);//Green
                
                //Set POW Scale: 0.75
                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140
                groundX = -14;
                groundY = Frogger.getMainHeight() - 140;
                
//                //Set Ground Color: Green
//                setGroundColor(0x00ff00);//Green
//                
//                //Set Level Text Background Color: Green
//                levelTxtBGCol = 0x00ff00;//Green
//                
//                //Set Enter Level Icon Background Color: Light Green
//                enterLvlIconBG = 0x00CD02;//Light Green
//                
//                //Set Enter Level Icon Foreground Color: Crimson
//                enterLvlIconFG = 0x00B200;//Crimson
                
                break;
                
            default:
                //Set Enemies
                //E0rows = 10, E1rows = 10, E2rows = 10, E3rows = 10, E4rows = 10, E5rows = 10, E6rows = 10, E7rows = 0, E8rows = 0, E9rows = 0;
                /**
                *   **********
                *   **********
                *   **********
                *   **********
                *   **********
                *   **********
                *   **********
                * 
                * 
                * 
                */
//                Enemy.setNoEnemy(10, 10, 10, 10, 10, 10, 10, 0, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
//                //Set Enemy Color: White
//                Enemy.setEnemyCol(0xffffff);//White
//                
//                //Set Enemy Bullet Color: White
//                Bullet.setEnemyBulletCol(0xffffff);//White
//    
//                //Set Level Background: 1
//                setBackground(1);//1: Moon(Small)
            
                //Set Barricades
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **     **
                *  ****   ****   ****   ****
                *  ****   ****   ****   ****
                */
//                Barricade.setNoBarricades(4);
                
//                //Set Barricade Color: Green
//                Barricade.setBarricadeCol(0x00ff00);//Green
                
                //Set POW Scale: 0.75
                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140
                groundX = -14;
                groundY = Frogger.getMainHeight() - 140;
                
//                //Set Ground Color: Green
//                setGroundColor(0x00ff00);//Green
//                
//                //Set Level Text Background Color: Green
//                levelTxtBGCol = 0x00ff00;//Green
//                
//                //Set Enter Level Icon Background Color: Light Green
//                enterLvlIconBG = 0x00CD02;//Light Green
//                
//                //Set Enter Level Icon Foreground Color: Crimson
//                enterLvlIconFG = 0x00B200;//Crimson
                
                break;
                
        }
        
    }

    
    /**
     * setUpLevel2()
     * 
     */
    private void setUpLevel2(){
        int width = Frogger.getMainWidth();
        
        //Set Enemy Color: Red
//        Enemy.setEnemyCol(0xff0000);//Red

        //Set Enemy Bullet Color: Red
//        Bullet.setEnemyBulletCol(0xff0000);//Red

        //Set Level Background: 2
        setBackground(2);//2: Mars(Small)
        
        //Set Ground Color: Maroon
        setGroundColor(0x800000);

        //Set Level Text Background Color: Maroon
//        levelTxtBGCol = 0x800000;//Maroon

        //Set Enter Level Icon Background Color: Indian Red
//        enterLvlIconBG = 0xCD5C5C;//Indian Red

        //Set Enter Level Icon Foreground Color: Crimson
//        enterLvlIconFG = 0xDC100C;//Crimson
        
        switch(width){
            case 300:
                //Set Enemies
                //E0rows = 11, E1rows = 11, E2rows = 11, E3rows = 9, E4rows = 7, E5rows = 5, E6rows = 5, E7rows = 0, E8rows = 0, E9rows = 0;
                /**
                *   ***********
                *   ***********
                *    *********
                *     *******
                *      *****
                *      *****
                *   
                * 
                * 
                * 
                */
//                Enemy.setNoEnemy(11, 11, 11, 9, 7, 5, 5, 0, 0, 0);
                
                //Set Enemy UFOfreq: 8
//                Enemy.setUFOFreq(8);
                
//                //Set Enemy Color: Red
//                Enemy.setEnemyCol(0xff0000);//Red
//                
//                //Set Enemy Bullet Color: Red
//                Bullet.setEnemyBulletCol(0xff0000);//Red
//    
//                //Set Level Background: 2
//                setBackground(2);//2: Mars(Small)
            
                //Set Barricades
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *      **     **
                *     ****   ****
                *     ****   ****
                */
//                Barricade.setNoBarricades(2);
                
                //Set Barricade Color: Indian Red
//                Barricade.setBarricadeCol(0xCD5C5C);//Indian Red
                
                //Set POW Scale: 0.75
                powScale = 0.75;
            
                //Set Ground
                //Set Ground Scale: 1.0
                groundScale = 1.0;
                
                //Set Ground POS: 4, Game.getGameHeight() - 140;
                groundX = 4;
                groundY = Frogger.getMainHeight() - 140;
//                
//                //Set Ground Color: Maroon
//                setGroundColor(0x800000);
//                
//                //Set Level Text Background Color: Maroon
//                levelTxtBGCol = 0x800000;//Maroon
//                
//                //Set Enter Level Icon Background Color: Indian Red
//                enterLvlIconBG = 0xCD5C5C;//Indian Red
//                
//                //Set Enter Level Icon Foreground Color: Crimson
//                enterLvlIconFG = 0xDC100C;//Crimson
                
                break;
                
            case 480:
                //Set Enemies
                //E0rows = 11, E1rows = 11, E2rows = 11, E3rows = 9, E4rows = 7, E5rows = 5, E6rows = 5, E7rows = 0, E8rows = 0, E9rows = 0;
                /**
                *   ***********
                *   ***********
                *    *********
                *     *******
                *      *****
                *      *****
                *   
                * 
                * 
                * 
                */
//                Enemy.setNoEnemy(11, 11, 11, 9, 7, 5, 5, 0, 0, 0);
                
                //Set Enemy UFOfreq: 8
//                Enemy.setUFOFreq(8);
                
//                //Set Enemy Color: Red
//                Enemy.setEnemyCol(0xff0000);//Red
//                
//                //Set Enemy Bullet Color: Red
//                Bullet.setEnemyBulletCol(0xff0000);//Red
//    
//                //Set Level Background: 2
//                setBackground(2);//2: Mars(Small)
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *      **     **
                *     ****   ****
                *     ****   ****
                */
//                Barricade.setNoBarricades(2);
                
                //Set Barricade Color: Indian Red
//                Barricade.setBarricadeCol(0xCD5C5C);//Indian Red
                
                //Set POW Scale: 0.75
                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 1.25
                groundScale = 1.25;
                
                //Set Ground POS: 10, Game.getGameHeight() - 140;
                groundX = 10;
                groundY = Frogger.getMainHeight() - 140;
                
//                //Set Ground Color: Maroon
//                setGroundColor(0x800000);//Maroon
//                
//                //Set Level Text Background Color: Maroon
//                levelTxtBGCol = 0x800000;//Maroon
//                
//                //Set Enter Level Icon Background Color: Indian Red
//                enterLvlIconBG = 0xCD5C5C;//Indian Red
//                
//                //Set Enter Level Icon Foreground Color: Crimson
//                enterLvlIconFG = 0xDC100C;//Crimson
                
                break;
                
            case 604:
                //Set Enemies
                //E0rows = 11, E1rows = 11, E2rows = 11, E3rows = 9, E4rows = 7, E5rows = 5, E6rows = 5, E7rows = 0, E8rows = 0, E9rows = 0;
                /**
                *   ***********
                *   ***********
                *    *********
                *     *******
                *      *****
                *      *****
                *   
                * 
                * 
                * 
                */
//                Enemy.setNoEnemy(11, 11, 11, 9, 7, 5, 5, 0, 0, 0);
                
                //Set Enemy UFOfreq: 8
//                Enemy.setUFOFreq(8);
                
//                //Set Enemy Color: Red
//                Enemy.setEnemyCol(0xff0000);//Red
//                
//                //Set Enemy Bullet Color: Red
//                Bullet.setEnemyBulletCol(0xff0000);//Red
//    
//                //Set Level Background: 2
//                setBackground(2);//2: Mars(Small)
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *      **     **
                *     ****   ****
                *     ****   ****
                */
//                Barricade.setNoBarricades(2);
                
//                //Set Barricade Color: Indian Red
//                Barricade.setBarricadeCol(0xCD5C5C);//Indian Red
                
                //Set POW Scale: 0.75
                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Frogger.getMainHeight() - 140;
                
//                //Set Ground Color: Maroon
//                setGroundColor(0x800000);//Maroon
//                
//                //Set Level Text Background Color: Maroon
//                levelTxtBGCol = 0x800000;//Maroon
//                
//                //Set Enter Level Icon Background Color: Indian Red
//                enterLvlIconBG = 0xCD5C5C;//Indian Red
//                
//                //Set Enter Level Icon Foreground Color: Crimson
//                enterLvlIconFG = 0xDC100C;//Crimson
                
                break;
                
            default:
                //Set Enemies
                //E0rows = 11, E1rows = 11, E2rows = 11, E3rows = 9, E4rows = 7, E5rows = 5, E6rows = 5, E7rows = 0, E8rows = 0, E9rows = 0;
                /**
                *   ***********
                *   ***********
                *    *********
                *     *******
                *      *****
                *      *****
                *   
                * 
                * 
                * 
                */
//                Enemy.setNoEnemy(11, 11, 11, 9, 7, 5, 5, 0, 0, 0);
                
                //Set Enemy UFOfreq: 8
//                Enemy.setUFOFreq(8);
                
//                //Set Enemy Color: Red
//                Enemy.setEnemyCol(0xff0000);//Red
//                
//                //Set Enemy Bullet Color: Red
//                Bullet.setEnemyBulletCol(0xff0000);//Red
//    
//                //Set Level Background: 2
//                setBackground(2);//2: Mars(Small)
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *      **     **
                *     ****   ****
                *     ****   ****
                */
//                Barricade.setNoBarricades(2);
                
//                //Set Barricade Color: Indian Red
//                Barricade.setBarricadeCol(0xCD5C5C);//Indian Red
                
                //Set POW Scale: 0.75
                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Frogger.getMainHeight() - 140;
                
//                //Set Ground Color: Maroon
//                setGroundColor(0x800000);//Maroon
//                
//                //Set Level Text Background Color: Maroon
//                levelTxtBGCol = 0x800000;//Maroon
//                
//                //Set Enter Level Icon Background Color: Indian Red
//                enterLvlIconBG = 0xCD5C5C;//Indian Red
//                
//                //Set Enter Level Icon Foreground Color: Crimson
//                enterLvlIconFG = 0xDC100C;//Crimson
                
                break;
        }
        
    }
    
    
    /**
     * setUpLevel3()
     * 
     */
    private void setUpLevel3(){
        int width = Frogger.getMainWidth();
        
        //Set Enemy Color: Cadet Blue
//        Enemy.setEnemyCol(0x5F9EA0);//Cadet Blue

        //Set Enemy Bullet Color: Green
//        Bullet.setEnemyBulletCol(0x00ff00);//Green

        //Set Level Background: 3
        setBackground(3);//3: Earth(Small)
        
        //Set Barricade Color: Blue
//        Barricade.setBarricadeCol(0x0000ff);//Blue
        
        //Set Ground Color: Medium Blue
        setGroundColor(0x0000dd);//Medium Blue

        //Set Level Text Background Color: Medium Blue
//        levelTxtBGCol = 0x0000dd;//Medium Blue

        //Set Enter Level Icon Background Color: Green Blue
//        enterLvlIconBG = 0x00d5fc;//Green Blue

        //Set Enter Level Icon Foreground Color: Dark Green blue
//        enterLvlIconFG = 0xc0c0c0;//Dark Green blue
        
        switch(width){
            case 300:
                //Set Enemies
                //E0rows = 0, E1rows = 11, E2rows = 11, E3rows = 11, E4rows = 0, E5rows = 11, E6rows = 11, E7rows = 0, E8rows = 0, E9rows = 0;
                /**
                *   
                *   ***********
                *   ***********
                *   ***********
                *   
                *   ***********
                *   ***********
                * 
                * 
                * 
                */
//                Enemy.setNoEnemy(0, 11, 11, 11, 0, 11, 11, 0, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
//                //Set Enemy Color: Cadet Blue
//                Enemy.setEnemyCol(0x5F9EA0);//Cadet Blue
//                
//                //Set Enemy Bullet Color: Green
//                Bullet.setEnemyBulletCol(0x00ff00);//Green
//    
//                //Set Level Background: 3
//                setBackground(3);//3: Earth(Small)
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
//                //Set Barricade Color: Blue
//                Barricade.setBarricadeCol(0x0000ff);//Blue
                
                //Set POW Scale: 0.75
                powScale = 0.75;
            
                //Set Ground
                //Set Ground Scale: 1.0
                groundScale = 1.0;
                
                //Set Ground POS: 4, Game.getGameHeight() - 140;
                groundX = 4;
                groundY = Frogger.getMainHeight() - 140;
                
//                //Set Ground Color: Medium Blue
//                setGroundColor(0x0000dd);//Medium Blue
//                
//                //Set Level Text Background Color: Medium Blue
//                levelTxtBGCol = 0x0000dd;//Medium Blue
//                
//                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
//                
//                //Set Enter Level Icon Foreground Color: Dark Green blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
            case 480:
                //E0rows = 0, E1rows = 11, E2rows = 11, E3rows = 11, E4rows = 0, E5rows = 11, E6rows = 11, E7rows = 0, E8rows = 0, E9rows = 0;
                /**
                *   
                *   ***********
                *   ***********
                *   ***********
                *   
                *   ***********
                *   ***********
                * 
                * 
                * 
                */
//                Enemy.setNoEnemy(0, 11, 11, 11, 0, 11, 11, 0, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
//                //Set Enemy Color: Cadet Blue
//                Enemy.setEnemyCol(0x5F9EA0);//Cadet Blue
//                
//                //Set Enemy Bullet Color: Green
//                Bullet.setEnemyBulletCol(0x00ff00);//Green
//    
//                //Set Level Background: 3
//                setBackground(3);//3: Earth(Small)
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
//                //Set Barricade Color: Blue
//                Barricade.setBarricadeCol(0x0000ff);//Blue
                
                //Set POW Scale: 0.75
                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 1.25
                groundScale = 1.25;
                
                //Set Ground POS: 10, Game.getGameHeight() - 140;
                groundX = 10;
                groundY = Frogger.getMainHeight() - 140;
                
//                //Set Ground Color: Medium Blue
//                setGroundColor(0x0000dd);//Medium Blue
//                
//                //Set Level Text Background Color: Medium Blue
//                levelTxtBGCol = 0x0000dd;//Medium Blue
//                
//                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
//                
//                //Set Enter Level Icon Foreground Color: Dark Green blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
            case 604:
                //E0rows = 0, E1rows = 11, E2rows = 11, E3rows = 11, E4rows = 0, E5rows = 11, E6rows = 11, E7rows = 0, E8rows = 0, E9rows = 0;
                /**
                *   
                *   ***********
                *   ***********
                *   ***********
                *   
                *   ***********
                *   ***********
                * 
                * 
                * 
                */
//                Enemy.setNoEnemy(0, 11, 11, 11, 0, 11, 11, 0, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
//                //Set Enemy Color: Cadet Blue
//                Enemy.setEnemyCol(0x5F9EA0);//Cadet Blue
//                
//                //Set Enemy Bullet Color: Green
//                Bullet.setEnemyBulletCol(0x00ff00);//Green
//    
//                //Set Level Background: 3
//                setBackground(3);//3: Earth(Small)
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
//                //Set Barricade Color: Blue
//                Barricade.setBarricadeCol(0x0000ff);//Blue
                
                //Set POW Scale: 0.75
                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Frogger.getMainHeight() - 140;
                
//                //Set Ground Color: Medium Blue
//                setGroundColor(0x0000dd);//Medium Blue
//                
//                //Set Level Text Background Color: Medium Blue
//                levelTxtBGCol = 0x0000dd;//Medium Blue
//                
//                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
//                
//                //Set Enter Level Icon Foreground Color: Dark Green blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
            default:
                //E0rows = 0, E1rows = 11, E2rows = 11, E3rows = 11, E4rows = 0, E5rows = 11, E6rows = 11, E7rows = 0, E8rows = 0, E9rows = 0;
                /**
                *   
                *   ***********
                *   ***********
                *   ***********
                *   
                *   ***********
                *   ***********
                * 
                * 
                * 
                */
//                Enemy.setNoEnemy(0, 11, 11, 11, 0, 11, 11, 0, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
//                //Set Enemy Color: Cadet Blue
//                Enemy.setEnemyCol(0x5F9EA0);//Cadet Blue
//                
//                //Set Enemy Bullet Color: Green
//                Bullet.setEnemyBulletCol(0x00ff00);//Green
//    
//                //Set Level Background: 3
//                setBackground(3);//3; Earth(Small)
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
//                //Set Barricade Color: Blue
//                Barricade.setBarricadeCol(0x0000ff);//Blue
                
                //Set POW Scale: 0.75
                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Frogger.getMainHeight() - 140;
                
//                //Set Ground Color: Medium Blue
//                setGroundColor(0x0000dd);//Medium Blue
//                
//                //Set Level Text Background Color: Medium Blue
//                levelTxtBGCol = 0x0000dd;//Medium Blue
//                
//                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
//                
//                //Set Enter Level Icon Foreground Color: Dark Green blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
        }
        
    }
    
    
    /**
     * setUpLevel4()
     * 
     */
    private void setUpLevel4(){
        int width = Frogger.getMainWidth();
        switch(width){
            case 300:
                //Set Enemies
                //E0rows = 11, E1rows = 6, E2rows = 11, E3rows = 11, E4rows = 6, E5rows = 11, E6rows = 4, E7rows = 0, E8rows = 0, E9rows = 2;
                /**
                *   ***********
                *     ******
                *   ***********
                *   ***********
                *     ******
                *   ***********
                *      ****
                * 
                * 
                *       **
                */
//                Enemy.setNoEnemy(11, 6, 11, 11, 6, 11, 4, 0, 0, 2);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: 0xf7cb07
//                Enemy.setEnemyCol(0xf7cb07);
                
                //Set Enemy Bullet Color: 0xf7cb07
//                Bullet.setEnemyBulletCol(0xf7cb07);
    
                //Set Level Background: 4
                setBackground(4);//4: Sun
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Red
//                Barricade.setBarricadeCol(0xff0000);//Red
                
                //Set POW Scale: 0.75
                powScale = 0.75;
            
                //Set Ground
                //Set Ground Scale: 1.0
                groundScale = 1.0;
                
                //Set Ground POS: 4, Game.getGameHeight() - 140;
                groundX = 4;
                groundY = Frogger.getMainHeight() - 140;
                
                //Set Ground Color: OrangeRed
                setGroundColor(0xFF4500);//OrangeRed
                
                //Set Level Text Background Color: OrangeRed
//                levelTxtBGCol = 0xFF4500;//OrangeRed
                
                //Set Enter Level Icon Background Color: Orange
//                enterLvlIconBG = 0xFFA500;//Orange
                
                //Set Enter Level Icon Foreground Color: Gold
//                enterLvlIconFG = 0xffd700;//Gold
                
                break;
                
            case 480:
                //E0rows = 11, E1rows = 6, E2rows = 11, E3rows = 11, E4rows = 6, E5rows = 11, E6rows = 4, E7rows = 0, E8rows = 0, E9rows = 2;
                /**
                *   ***********
                *     ******
                *   ***********
                *   ***********
                *     ******
                *   ***********
                *      ****
                * 
                * 
                *       **
                */
//                Enemy.setNoEnemy(11, 6, 11, 11, 6, 11, 4, 0, 0, 2);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: 0xf7cb07
//                Enemy.setEnemyCol(0xf7cb07);
                
                //Set Enemy Bullet Color: 0xf7cb07
//                Bullet.setEnemyBulletCol(0xf7cb07);
    
                //Set Level Background: 4
                setBackground(4);//4: Sun
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Red
//                Barricade.setBarricadeCol(0xff0000);//Red
                
                //Set POW Scale: 0.75
                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 1.25
                groundScale = 1.25;
                
                //Set Ground POS: 10, Game.getGameHeight() - 140;
                groundX = 10;
                groundY = Frogger.getMainHeight() - 140;
                
                //Set Ground Color: OrangeRed
                setGroundColor(0xFF4500);//OrangeRed
                
                //Set Level Text Background Color: OrangeRed
//                levelTxtBGCol = 0xFF4500;//OrangeRed
                
                //Set Enter Level Icon Background Color: Orange
//                enterLvlIconBG = 0xFFA500;//Orange
                
                //Set Enter Level Icon Foreground Color: Gold
//                enterLvlIconFG = 0xffd700;//Gold
                
                break;
                
            case 604:
                //E0rows = 11, E1rows = 6, E2rows = 11, E3rows = 11, E4rows = 6, E5rows = 11, E6rows = 4, E7rows = 0, E8rows = 0, E9rows = 2;
                /**
                *   ***********
                *     ******
                *   ***********
                *   ***********
                *     ******
                *   ***********
                *      ****
                * 
                * 
                *       **
                */
//                Enemy.setNoEnemy(11, 6, 11, 11, 6, 11, 4, 0, 0, 2);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: 0xf7cb07
//                Enemy.setEnemyCol(0xf7cb07);
                
                //Set Enemy Bullet Color: 0xf7cb07
//                Bullet.setEnemyBulletCol(0xf7cb07);
    
                //Set Level Background: 4
                setBackground(4);//4: Sun
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Red
//                Barricade.setBarricadeCol(0xff0000);//Red
                
                //Set POW Scale: 0.75
                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Frogger.getMainHeight() - 140;
                
                //Set Ground Color: OrangeRed
                setGroundColor(0xFF4500);//OrangeRed
                
                //Set Level Text Background Color: OrangeRed
//                levelTxtBGCol = 0xFF4500;//OrangeRed
                
                //Set Enter Level Icon Background Color: Orange
//                enterLvlIconBG = 0xFFA500;//Orange
                
                //Set Enter Level Icon Foreground Color: Gold
//                enterLvlIconFG = 0xffd700;//Gold
                
                break;
                
            default:
                //E0rows = 11, E1rows = 6, E2rows = 11, E3rows = 11, E4rows = 6, E5rows = 11, E6rows = 4, E7rows = 0, E8rows = 0, E9rows = 2;
                /**
                *   ***********
                *     ******
                *   ***********
                *   ***********
                *     ******
                *   ***********
                *      ****
                * 
                * 
                *       **
                */
//                Enemy.setNoEnemy(11, 6, 11, 11, 6, 11, 4, 0, 0, 2);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: 0xf7cb07
//                Enemy.setEnemyCol(0xf7cb07);
                
                //Set Enemy Bullet Color: 0xf7cb07
//                Bullet.setEnemyBulletCol(0xf7cb07);
    
                //Set Level Background: 4
                setBackground(4);//4: Sun
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Red
//                Barricade.setBarricadeCol(0xff0000);//Red
                
                //Set POW Scale: 0.75
                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Frogger.getMainHeight() - 140;
                
                //Set Ground Color: OrangeRed
                setGroundColor(0xFF4500);//OrangeRed
                
                //Set Level Text Background Color: OrangeRed
//                levelTxtBGCol = 0xFF4500;//OrangeRed
                
                //Set Enter Level Icon Background Color: Orange
//                enterLvlIconBG = 0xFFA500;//Orange
                
                //Set Enter Level Icon Foreground Color: Gold
//                enterLvlIconFG = 0xffd700;//Gold
                
                break;
        }
        
    }
    
    
    /**
     * setUpLevel5()
     * 
     */
    private void setUpLevel5() {
        int width = Frogger.getMainWidth();
        switch(width){
            case 300:
                //Set Enemies
                //E0rows = 5, E1rows = 5, E2rows = 11, E3rows = 10, E4rows = 7, E5rows = 7, E6rows = 4, E7rows = 10, E8rows = 0, E9rows = 0;
                /**
                *      *****
                *      *****
                *   ***********
                *   **********
                *     *******
                *     *******
                *      ****
                *   **********
                * 
                *   
                */
//                Enemy.setNoEnemy(5, 5, 11, 10, 7, 7, 4, 10, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: Grey
//                Enemy.setEnemyCol(0x778899);//Grey
                
                //Set Enemy Bullet Color: Dark Grey
//                Bullet.setEnemyBulletCol(0x2F4FFF);//Dark Grey
    
                //Set Level Background: 1
                setBackground(1);//1: Moon
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Dark Grey
//                Barricade.setBarricadeCol(0x090909);//Dark Grey
                
                //Set POW Scale: 0.75
                powScale = 0.75;
            
                //Set Ground
                //Set Ground Scale: 1.0
                groundScale = 1.0;
                
                //Set Ground POS: 4, Game.getGameHeight() - 140;
                groundX = 4;
                groundY = Frogger.getMainHeight() - 140;
                
                //Set Ground Color: Grey
                setGroundColor(0x696969);//Grey
                
                //Set Level Text Background Color: Grey
//                levelTxtBGCol = 0x696969;//Grey
                
                //Set Enter Level Icon Background Color: Grey
//                enterLvlIconBG = 0x696969;//Grey
                
                //Set Enter Level Icon Foreground Color: Dark Grey
//                enterLvlIconFG = 0x090909;//Dark Grey
                
                break;
                
            case 480:
                //E0rows = 5, E1rows = 5, E2rows = 11, E3rows = 10, E4rows = 7, E5rows = 7, E6rows = 4, E7rows = 10, E8rows = 0, E9rows = 0;
                /**
                *      *****
                *      *****
                *   ***********
                *   **********
                *     *******
                *     *******
                *      ****
                *   **********
                * 
                *   
                */
//                Enemy.setNoEnemy(5, 5, 11, 10, 7, 7, 4, 10, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: Grey
//                Enemy.setEnemyCol(0x778899);//Grey
                
                //Set Enemy Bullet Color: Dark Grey
//                Bullet.setEnemyBulletCol(0x2F4FFF);//Dark Grey
    
                //Set Level Background: 1
                setBackground(1);//1: Moon
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Dark Grey
//                Barricade.setBarricadeCol(0x090909);//Dark Grey
                
                //Set POW Scale: 0.75
                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 1.25
                groundScale = 1.25;
                
                //Set Ground POS: 10, Game.getGameHeight() - 140;
                groundX = 10;
                groundY = Frogger.getMainHeight() - 140;
                
                //Set Ground Color: Grey
                setGroundColor(0x696969);//Grey
                
                //Set Level Text Background Color: Grey
//                levelTxtBGCol = 0x696969;//Grey
                
                //Set Enter Level Icon Background Color: Grey
//                enterLvlIconBG = 0x696969;//Grey
                
                //Set Enter Level Icon Foreground Color: Dark Grey
//                enterLvlIconFG = 0x090909;//Dark Grey
                
                break;
                
            case 604:
                //E0rows = 5, E1rows = 5, E2rows = 11, E3rows = 10, E4rows = 7, E5rows = 7, E6rows = 4, E7rows = 10, E8rows = 0, E9rows = 0;
                /**
                *      *****
                *      *****
                *   ***********
                *   **********
                *     *******
                *     *******
                *      ****
                *   **********
                * 
                *   
                */
//                Enemy.setNoEnemy(5, 5, 11, 10, 7, 7, 4, 10, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: Grey
//                Enemy.setEnemyCol(0x778899);//Grey
                
                //Set Enemy Bullet Color: Dark Grey
//                Bullet.setEnemyBulletCol(0x2F4F4F);//Dark Grey
    
                //Set Level Background: 1
                setBackground(1);//1: Moon
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Dark Grey
//                Barricade.setBarricadeCol(0x090909);//Dark Grey
                
                //Set POW Scale: 0.75
                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Frogger.getMainHeight() - 140;
                
                //Set Ground Color: Grey
                setGroundColor(0x696969);//Grey
                
                //Set Level Text Background Color: Grey
//                levelTxtBGCol = 0x696969;//Grey
                
                //Set Enter Level Icon Background Color: Grey
//                enterLvlIconBG = 0x696969;//Grey
                
                //Set Enter Level Icon Foreground Color: Dark Grey
//                enterLvlIconFG = 0x090909;//Dark Grey
                
                break;
                
            default:
                //E0rows = 5, E1rows = 5, E2rows = 11, E3rows = 10, E4rows = 7, E5rows = 7, E6rows = 4, E7rows = 10, E8rows = 0, E9rows = 0;
                /**
                *      *****
                *      *****
                *   ***********
                *   **********
                *     *******
                *     *******
                *      ****
                *   **********
                * 
                *   
                */
//                Enemy.setNoEnemy(5, 5, 11, 10, 7, 7, 4, 10, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: Grey
//                Enemy.setEnemyCol(0x778899);//Grey
                
                //Set Enemy Bullet Color: Dark Grey
//                Bullet.setEnemyBulletCol(0x2F4F4F);//Dark Grey
    
                //Set Level Background: 1
                setBackground(1);
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Dark Grey
//                Barricade.setBarricadeCol(0x090909);//Dark Grey
                
                //Set POW Scale: 0.75
                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Frogger.getMainHeight() - 140;
                
                //Set Ground Color: Grey
                setGroundColor(0x696969);//Grey
                
                //Set Level Text Background Color: Grey
//                levelTxtBGCol = 0x696969;//Grey
                
                //Set Enter Level Icon Background Color: Grey
//                enterLvlIconBG = 0x696969;//Grey
                
                //Set Enter Level Icon Foreground Color: Dark Grey
//                enterLvlIconFG = 0x090909;//Dark Grey
                
                break;
        }
        
    }
    
    
    /**
     * setUpLevel6()
     * 
     */
    private void setUpLevel6(){
        int width = Frogger.getMainWidth();
        switch(width){
            case 300:
                //Set Enemies
                //E0rows = 6, E1rows = 6, E2rows = 6, E3rows = 6, E4rows = 6, E5rows = 6, E6rows = 10, E7rows = 4, E8rows = 0, E9rows = 0;
                /**
                *     ******
                *     ******
                *     ******
                *     ******
                *     ******
                *     ******
                *   **********
                *      ****
                * 
                *   
                */
//                Enemy.setNoEnemy(6, 6, 6, 6, 6, 6, 10, 4, 0, 0);
                
                //Set Enemy UFOfreq: 8
//                Enemy.setUFOFreq(8);
                
                //Set Enemy Color: Crimson
//                Enemy.setEnemyCol(0xDC1000);//Crimson
                
                //Set Enemy Bullet Color: Red
//                Bullet.setEnemyBulletCol(0xff0000);//Red
    
                //Set Level Background: 2
                setBackground(2);//2: Mars
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *      **     **
                *     ****   ****
                *     ****   ****
                */
//                Barricade.setNoBarricades(2);
                
                //Set Barricade Color: Red
//                Barricade.setBarricadeCol(0xff0000);//Red
                
                //Set POW Scale: 0.75
                powScale = 0.75;
            
                //Set Ground
                //Set Ground Scale: 1.0
                groundScale = 1.0;
                
                //Set Ground POS: 4, Game.getGameHeight() - 140;
                groundX = 4;
                groundY = Frogger.getMainHeight() - 140;
                
                //Set Ground Color: Maroon
                setGroundColor(0x800000);//Maroon
                
                //Set Level Text Background Color: Maroon
//                levelTxtBGCol = 0x800000;//Maroon
                
                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
                
                //Set Enter Level Icon Foreground Color: Dark Green Blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
            case 480:
                //E0rows = 6, E1rows = 6, E2rows = 6, E3rows = 6, E4rows = 6, E5rows = 6, E6rows = 10, E7rows = 4, E8rows = 0, E9rows = 0;
                /**
                *     ******
                *     ******
                *     ******
                *     ******
                *     ******
                *     ******
                *   **********
                *      ****
                * 
                *   
                */
//                Enemy.setNoEnemy(6, 6, 6, 6, 6, 6, 10, 4, 0, 0);
                
                //Set Enemy UFOfreq: 8
//                Enemy.setUFOFreq(8);
                
                //Set Enemy Color: Crimson
//                Enemy.setEnemyCol(0xDC1000);//Crimson
                
                //Set Enemy Bullet Color: Red
//                Bullet.setEnemyBulletCol(0xff0000);//Red
    
                //Set Level Background: 2
                setBackground(2);//2: Mars
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *      **     **
                *     ****   ****
                *     ****   ****
                */
//                Barricade.setNoBarricades(2);
                
                //Set Barricade Color: Red
//                Barricade.setBarricadeCol(0xff0000);//Red
                
                //Set POW Scale: 0.75
                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 1.25
                groundScale = 1.25;
                
                //Set Ground POS: 10, Game.getGameHeight() - 140;
                groundX = 10;
                groundY = Frogger.getMainHeight() - 140;
                
                //Set Ground Color: Maroon
                setGroundColor(0x800000);//Maroon
                
                //Set Level Text Background Color: Maroon
//                levelTxtBGCol = 0x800000;//Maroon
                
                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
                
                //Set Enter Level Icon Foreground Color: Dark Green Blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
            case 604:
                //E0rows = 6, E1rows = 6, E2rows = 6, E3rows = 6, E4rows = 6, E5rows = 6, E6rows = 10, E7rows = 4, E8rows = 0, E9rows = 0;
                /**
                *     ******
                *     ******
                *     ******
                *     ******
                *     ******
                *     ******
                *   **********
                *      ****
                * 
                *   
                */
//                Enemy.setNoEnemy(6, 6, 6, 6, 6, 6, 10, 4, 0, 0);
                
                //Set Enemy UFOfreq: 8
//                Enemy.setUFOFreq(8);
                
                //Set Enemy Color: Crimson
//                Enemy.setEnemyCol(0xDC1000);//Crimson
                
                //Set Enemy Bullet Color: Red
//                Bullet.setEnemyBulletCol(0xff0000);//Red
    
                //Set Level Background: 2
                setBackground(2);//2: Mars
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *      **     **
                *     ****   ****
                *     ****   ****
                */
//                Barricade.setNoBarricades(2);
                
                //Set Barricade Color: Red
//                Barricade.setBarricadeCol(0xff0000);//Red
                
                //Set POW Scale: 0.75
                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Frogger.getMainHeight() - 140;
                
                //Set Ground Color: Maroon
                setGroundColor(0x800000);//Maroon
                
                //Set Level Text Background Color: Maroon
//                levelTxtBGCol = 0x800000;//Maroon
                
                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
                
                //Set Enter Level Icon Foreground Color: Dark Green Blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
            default:
                //E0rows = 6, E1rows = 6, E2rows = 6, E3rows = 6, E4rows = 6, E5rows = 6, E6rows = 10, E7rows = 4, E8rows = 0, E9rows = 0;
                /**
                *     ******
                *     ******
                *     ******
                *     ******
                *     ******
                *     ******
                *   **********
                *      ****
                * 
                *   
                */
//                Enemy.setNoEnemy(6, 6, 6, 6, 6, 6, 10, 4, 0, 0);
                
                //Set Enemy UFOfreq: 8
//                Enemy.setUFOFreq(8);
                
                //Set Enemy Color: Crimson
//                Enemy.setEnemyCol(0xDC1000);//Crimson
                
                //Set Enemy Bullet Color: Red
//                Bullet.setEnemyBulletCol(0xff0000);//Red
    
                //Set Level Background: 2
                setBackground(2);//2: Mars
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *      **     **
                *     ****   ****
                *     ****   ****
                */
//                Barricade.setNoBarricades(2);
                
                //Set Barricade Color: Red
//                Barricade.setBarricadeCol(0xff0000);//Red
                
                //Set POW Scale: 0.75
                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Frogger.getMainHeight() - 140;
                
                //Set Ground Color: Maroon
                setGroundColor(0x800000);//Maroon
                
                //Set Level Text Background Color: Maroon
//                levelTxtBGCol = 0x800000;//Maroon
                
                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
                
                //Set Enter Level Icon Foreground Color: Dark Green Blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
        }
        
    }
    
    
    /**
     * setUpLevel7()
     * 
     */
    private void setUpLevel7(){
        int width = Frogger.getMainWidth();
        switch(width){
            case 300:
                //Set Enemies
                //E0rows = 10, E1rows = 2, E2rows = 10, E3rows = 8, E4rows = 10, E5rows = 6, E6rows = 9, E7rows = 6, E8rows = 0, E9rows = 0;
                /**
                *   **********
                *       **
                *   **********
                *    ********
                *   **********
                *     ******
                *    *********
                *     ******
                * 
                *   
                */
//                Enemy.setNoEnemy(10, 2, 10, 8, 10, 6, 9, 6, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: 0xf7cb07
//                Enemy.setEnemyCol(0xf7cb07);
                
                //Set Enemy Bullet Color: 0xf7cb07
//                Bullet.setEnemyBulletCol(0xf7cb07);
    
                //Set Level Background: 4
                setBackground(4);//4: Sun
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Gold
//                Barricade.setBarricadeCol(0xFFD700);//Gold
                
                //Set POW Scale: 0.75
                powScale = 0.75;
            
                //Set Ground
                //Set Ground Scale: 1.0
                groundScale = 1.0;
                
                //Set Ground POS: 4, Game.getGameHeight() - 140;
                groundX = 4;
                groundY = Frogger.getMainHeight() - 140;
                
                //Set Ground Color: Red
                setGroundColor(0xff0000);//Red
                
                //Set Level Text Background Color: Red
//                levelTxtBGCol = 0xff0000;//Red
                
                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
                
                //Set Enter Level Icon Foreground Color: Dark Green Blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
            case 480:
                //E0rows = 10, E1rows = 2, E2rows = 10, E3rows = 8, E4rows = 10, E5rows = 6, E6rows = 9, E7rows = 6, E8rows = 0, E9rows = 0;
                /**
                *   **********
                *       **
                *   **********
                *    ********
                *   **********
                *     ******
                *    *********
                *     ******
                * 
                *   
                */
//                Enemy.setNoEnemy(10, 2, 10, 8, 10, 6, 9, 6, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: 0xf7cb07
//                Enemy.setEnemyCol(0xf7cb07);
                
                //Set Enemy Bullet Color: 0xf7cb07
//                Bullet.setEnemyBulletCol(0xf7cb07);
    
                //Set Level Background: 4
                setBackground(4);//4: Sun
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Gold
//                Barricade.setBarricadeCol(0xFFD700);//Gold
                
                //Set POW Scale: 0.75
                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 1.25
                groundScale = 1.25;
                
                //Set Ground POS: 10, Game.getGameHeight() - 140;
                groundX = 10;
                groundY = Frogger.getMainHeight() - 140;
                
                //Set Ground Color: Red
                setGroundColor(0xff0000);//Red
                
                //Set Level Text Background Color: Red
//                levelTxtBGCol = 0xff0000;//Red
                
                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
                
                //Set Enter Level Icon Foreground Color: Dark Green Blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
            case 604:
                //E0rows = 10, E1rows = 2, E2rows = 10, E3rows = 8, E4rows = 10, E5rows = 6, E6rows = 9, E7rows = 6, E8rows = 0, E9rows = 0;
                /**
                *   **********
                *       **
                *   **********
                *    ********
                *   **********
                *     ******
                *    *********
                *     ******
                * 
                *   
                */
//                Enemy.setNoEnemy(10, 2, 10, 8, 10, 6, 9, 6, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: 0xf7cb07
//                Enemy.setEnemyCol(0xf7cb07);
                
                //Set Enemy Bullet Color: 0xf7cb07
//                Bullet.setEnemyBulletCol(0xf7cb07);
    
                //Set Level Background: 4
                setBackground(4);//4: Sun
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Gold
//                Barricade.setBarricadeCol(0xFFD700);//Gold
                
                //Set POW Scale: 0.75
                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Frogger.getMainHeight() - 140;
                
                //Set Ground Color: Red
                setGroundColor(0xff0000);//Red
                
                //Set Level Text Background Color: Red
//                levelTxtBGCol = 0xff0000;//Red
                
                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
                
                //Set Enter Level Icon Foreground Color: Dark Green Blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
            default:
                //E0rows = 10, E1rows = 2, E2rows = 10, E3rows = 8, E4rows = 10, E5rows = 6, E6rows = 9, E7rows = 6, E8rows = 0, E9rows = 0;
                /**
                *   **********
                *       **
                *   **********
                *    ********
                *   **********
                *     ******
                *    *********
                *     ******
                * 
                *   
                */
//                Enemy.setNoEnemy(10, 2, 10, 8, 10, 6, 9, 6, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: 0xf7cb07
//                Enemy.setEnemyCol(0xf7cb07);
                
                //Set Enemy Bullet Color: 0xf7cb07
//                Bullet.setEnemyBulletCol(0xf7cb07);
    
                //Set Level Background: 4
                setBackground(4);//4: Sun
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Gold
//                Barricade.setBarricadeCol(0xFFD700);//Gold
                
                //Set POW Scale: 0.75
                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Frogger.getMainHeight() - 140;
                
                //Set Ground Color: Red
                setGroundColor(0xff0000);//Red
                
                //Set Level Text Background Color: Red
//                levelTxtBGCol = 0xff0000;//Red
                
                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
                
                //Set Enter Level Icon Foreground Color: Dark Green Blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
        }
        
    }
    
    
    /**
     * setUpLevel8()
     * 
     */
    private void setUpLevel8(){
        int width = Frogger.getMainWidth();
        Random random = new Random();
        switch(width){
            case 300:
                //Set Enemies
                //E0rows = 10, E1rows = 10, E2rows = 10, E3rows = 8, E4rows = 8, E5rows = 6, E6rows = 6, E7rows = 4, E8rows = 0, E9rows = 0;
                /**
                *   **********
                *   **********
                *   **********
                *    ********
                *    ********
                *     ******
                *     ******
                *      ****
                * 
                *   
                */
//                Enemy.setNoEnemy(10, 10, 10, 8, 8, 6, 6, 4, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: Random Blue
//                Enemy.setEnemyCol(0x0000ff + random.nextInt(0x0000ff));//Random Blue
                
                //Set Enemy Bullet Color: Random Blue
//                Bullet.setEnemyBulletCol(0x0000ff + random.nextInt(0x0000ff));//Random Blue
    
                //Set Level Background: 3
                setBackground(3);//3: Earth
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Random Green
//                Barricade.setBarricadeCol(0x00ff00 + random.nextInt(0xffffff));//Random Green
                
                //Set POW Scale: 0.75
                powScale = 0.75;
            
                //Set Ground
                //Set Ground Scale: 1.0
                groundScale = 1.0;
                
                //Set Ground POS: 4, Game.getGameHeight() - 140;
                groundX = 4;
                groundY = Frogger.getMainHeight() - 140;
                
                //Set Ground Color: Random Green
                setGroundColor(0x00ff00 + random.nextInt(0xffffff));//Random Green
                
                //Set Level Text Background Color: Green
//                levelTxtBGCol = 0x00ff00;//Green
                
                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
                
                //Set Enter Level Icon Foreground Color: Dark Green Blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
            case 480:
                //E0rows = 10, E1rows = 10, E2rows = 10, E3rows = 8, E4rows = 8, E5rows = 6, E6rows = 6, E7rows = 4, E8rows = 0, E9rows = 0;
                /**
                *   **********
                *   **********
                *   **********
                *    ********
                *    ********
                *     ******
                *     ******
                *      ****
                * 
                *   
                */
//                Enemy.setNoEnemy(10, 10, 10, 8, 8, 6, 6, 4, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: Random Blue
//                Enemy.setEnemyCol(0x0000ff + random.nextInt(0x0000ff));//Random Blue
                
                //Set Enemy Bullet Color: Random Blue
//                Bullet.setEnemyBulletCol(0x0000ff + random.nextInt(0x0000ff));//Random Blue
    
                //Set Level Background: 3
                setBackground(3);//3: Earth
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Random Green
//                Barricade.setBarricadeCol(0x00ff00 + random.nextInt(0xffffff));//Random Green
                
                //Set POW Scale: 0.75
                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 1.25
                groundScale = 1.25;
                
                //Set Ground POS: 10, Game.getGameHeight() - 140;
                groundX = 10;
                groundY = Frogger.getMainHeight() - 140;
                
                //Set Ground Color: Random Green
                setGroundColor(0x00ff00 + random.nextInt(0xffffff));//Random Green
                
                //Set Level Text Background Color: Green
//                levelTxtBGCol = 0x00ff00;//Green
                
                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
                
                //Set Enter Level Icon Foreground Color: Dark Green Blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
            case 604:
                //E0rows = 10, E1rows = 10, E2rows = 10, E3rows = 8, E4rows = 8, E5rows = 6, E6rows = 6, E7rows = 4, E8rows = 0, E9rows = 0;
                /**
                *   **********
                *   **********
                *   **********
                *    ********
                *    ********
                *     ******
                *     ******
                *      ****
                * 
                *   
                */
//                Enemy.setNoEnemy(10, 10, 10, 8, 8, 6, 6, 4, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: Random Blue
//                Enemy.setEnemyCol(0x0000ff + random.nextInt(0x0000ff));//Random Blue
                
                //Set Enemy Bullet Color: Random Blue
//                Bullet.setEnemyBulletCol(0x0000ff + random.nextInt(0x0000ff));//Random Blue
    
                //Set Level Background: 3
                setBackground(3);//3: Earth
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Random Green
//                Barricade.setBarricadeCol(0x00ff00 + random.nextInt(0xffffff));//Random Green
                
                //Set POW Scale: 0.75
                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Frogger.getMainHeight() - 140;
                
                //Set Ground Color: Random Green
                setGroundColor(0x00ff00 + random.nextInt(0xffffff));//Random Green
                
                //Set Level Text Background Color: Green
//                levelTxtBGCol = 0x00ff00;//Green
                
                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
                
                //Set Enter Level Icon Foreground Color: Dark Green Blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
            default:
                //E0rows = 10, E1rows = 10, E2rows = 10, E3rows = 8, E4rows = 8, E5rows = 6, E6rows = 6, E7rows = 4, E8rows = 0, E9rows = 0;
                /**
                *   **********
                *   **********
                *   **********
                *    ********
                *    ********
                *     ******
                *     ******
                *      ****
                * 
                *   
                */
//                Enemy.setNoEnemy(10, 10, 10, 8, 8, 6, 6, 4, 0, 0);
                
                //Set Enemy UFOfreq: 5
//                Enemy.setUFOFreq(5);
                
                //Set Enemy Color: Random Blue
//                Enemy.setEnemyCol(0x0000ff + random.nextInt(0x0000ff));//Random Blue
                
                //Set Enemy Bullet Color: Random Blue
//                Bullet.setEnemyBulletCol(0x0000ff + random.nextInt(0x0000ff));//Random Blue
    
                //Set Level Background: 3
                setBackground(3);//3: Earth
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Random Green
//                Barricade.setBarricadeCol(0x00ff00 + random.nextInt(0xffffff));//Random Green
                
                //Set POW Scale: 0.75
                powScale = 0.75;
           
                //Set Ground
                //Set Ground Scale: 2.45
                groundScale = 2.45;
                
                //Set Ground POS: -14, Game.getGameHeight() - 140;
                groundX = -14;
                groundY = Frogger.getMainHeight() - 140;
                
                //Set Ground Color: Random Green
                setGroundColor(0x00ff00 + random.nextInt(0xffffff));//Random Green
                
                //Set Level Text Background Color: Green
//                levelTxtBGCol = 0x00ff00;//Green
                
                //Set Enter Level Icon Background Color: Green Blue
//                enterLvlIconBG = 0x00d5fc;//Green Blue
                
                //Set Enter Level Icon Foreground Color: Dark Green Blue
//                enterLvlIconFG = 0xc0c0c0;//Dark Green blue
                
                break;
                
        }
        
    }
    
    
    /**
     * setUpLevel9()
     * 
     */
    private void setUpLevel9(){
        int width = Frogger.getMainWidth();
        Random random = new Random();
        switch(width){
            case 300:
                
            
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Random Green
//                Barricade.setBarricadeCol(0x00ff00 + random.nextInt(0xffffff));//Random Green
                
                powScale = 0.75;
            
                groundScale = 1.0;
                groundX = 4;
                groundY = Frogger.getMainHeight() - 140;
                setGroundColor(0x00ff00 + random.nextInt(0xffffff));
                
                break;
                
            case 480:
                
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Random Green
//                Barricade.setBarricadeCol(0x00ff00 + random.nextInt(0xffffff));//Random Green
                
                powScale = 0.75;
           
                groundScale = 1.25;
                groundX = 10;
                groundY = Frogger.getMainHeight() - 140;
                setGroundColor(0x00ff00 + random.nextInt(0xffffff));
                
                break;
                
            case 604:
                
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Random Green
//                Barricade.setBarricadeCol(0x00ff00 + random.nextInt(0xffffff));//Random Green
                
                powScale = 0.75;
           
                groundScale = 2.45;
                groundX = -14;
                groundY = Frogger.getMainHeight() - 140;
                setGroundColor(0x00ff00 + random.nextInt(0xffffff));
                
                break;
                
            default:
                
                /**
                *   
                *   
                *   
                *    
                *    
                *     
                *     
                *   **     **     **
                *  ****   ****   ****
                *  ****   ****   ****
                */
//                Barricade.setNoBarricades(3);
                
                //Set Barricade Color: Random Green
//                Barricade.setBarricadeCol(0x00ff00 + random.nextInt(0xffffff));//Random Green
                
                powScale = 0.75;
           
                groundScale = 2.45;
                groundX = -14;
                groundY = Frogger.getMainHeight() - 140;
                setGroundColor(0x00ff00 + random.nextInt(0xffffff));
                
                break;
                
        }
    }
    
    
    /**
     * init()
     * 
     */
    private void init(){
        Texture.clearMaps();
        
//        lane[0] = "xxx..xxx..xxx..xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";//HomeBase
//        lane[1] = "...xxxxx....xxxx............xxxx............xx........xxxx......";//Logs
//        lane[2] = "....xxxx.....xxxxx.......xx....xxxx.....xxx......xxxxx.....xx...";//Logs
//        lane[3] = ".....xx......xxx........xxxx......xx....xxx......xxx......xxx...";//Logs
//        lane[4] = "pppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp";//Pavement
//        lane[5] = "....xx....xx....xx........xx...xx....xx...xx..xx......xx........";//Cars
//        lane[6] = "......xxxx...........xxxx............xxxx..........xxxx.........";//Buses
//        lane[7] = "...xx...xx........xx......xx..........xx.......xx..xx...........";//Cars
//        lane[8] = ".....xx....xx....xx..xx....xx.....xx......xx..xx.xx......xx...xx";//Cars
//        lane[9] = "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq";//Pavement
        
        lane[0] = "wrhvwrhvwrhvwrhvwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww";//HomeBase
        lane[1] = ",,,jiiik,,,,jiik,,,,,,,,,,,,jiik,,,,,,,,,,,,jk,,,,,,,,jiik,,,,,,";//Logs
        lane[2] = ",,,,jiik,,,,,jiiik,,,,,,,jk,,,,jiik,,,,,jik,,,,,,jiiik,,,,,jk,,,";//Logs
        lane[3] = ",,,,,jk,,,,,,jik,,,,,,,,jiik,,,,,,jk,,,,jik,,,,,,jik,,,,,,jik,,,";//Logs
        lane[4] = "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq";//Pavement
        lane[5] = "....zx.t.xy..t..tz....xy...zz..t..xy...tz.t....xy...tx..z.t..z..";//Cars
        lane[6] = "ads...adds....as.....adds.....adds...adds...ads....ads.....as...";//Buses
        lane[7] = "...xy...zt........yt......zz..........xt.......yy..zx...........";//Cars
        lane[8] = ".....yy....tx....zy..tt....yz.....xy......zz..tx.yt......zx...xx";//Cars//"..........x....................................................x";//Cars
        lane[9] = "pppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp";//Pavement

        laneSpeed[0] = 0.0f;//HomeBase
        laneSpeed[1] = -3.0f;//Logs-
        laneSpeed[2] = 3.0f;//Logs+
        laneSpeed[3] = 2.0f;//Logs+
        laneSpeed[4] = 0.0f;//Pavement
        laneSpeed[5] = -3.0f;//Cars-
        laneSpeed[6] = 3.0f;//Buses+
        laneSpeed[7] = -4.0f;//Cars-
        laneSpeed[8] = 2.0f;//Cars+
        laneSpeed[9] = 0.0f;//Pavement
        
        lanes.put(lane[0], laneSpeed[0]);
        lanes.put(lane[1], laneSpeed[1]);
        lanes.put(lane[2], laneSpeed[2]);
        lanes.put(lane[3], laneSpeed[3]);
        lanes.put(lane[4], laneSpeed[4]);
        lanes.put(lane[5], laneSpeed[5]);
        lanes.put(lane[6], laneSpeed[6]);
        lanes.put(lane[7], laneSpeed[7]);
        lanes.put(lane[8], laneSpeed[8]);
        lanes.put(lane[9], laneSpeed[9]);
        
        collisionList[0] = new ArrayList<>();
        collisionList[1] = new ArrayList<>();
        collisionList[2] = new ArrayList<>();
        collisionList[3] = new ArrayList<>();
        collisionList[4] = new ArrayList<>();
        collisionList[5] = new ArrayList<>();
        collisionList[6] = new ArrayList<>();
        collisionList[7] = new ArrayList<>();
        collisionList[8] = new ArrayList<>();
        collisionList[9] = new ArrayList<>();
        collisionList[10] = new ArrayList<>();
        collisionList[11] = new ArrayList<>();
        
        //System.out.println("Lanes size: "+lanes.size());
//        bufDanger = new boolean[Frogger.getMainWidth() * Frogger.getMainHeight()];
        
        bus_L_A = new Texture("/sprites/Frogger_Truck_Lefta").getImage();
        bus_L_B = new Texture("/sprites/Frogger_Truck_Leftb").getImage();
        bus_Centre = new Texture("/sprites/Frogger_Truck_Centre").getImage();
        
        car_L_A = new Texture("/sprites/Frogger_Car_Lefta").getImage();
        car_L_B = new Texture("/sprites/Frogger_Car_Leftb").getImage();
        car_L_C = new Texture("/sprites/Frogger_Car_Leftc").getImage();
        car_L_D = new Texture("/sprites/Frogger_Car_Leftd").getImage();
        
        bus_R_A = new Texture("/sprites/Frogger_Truck_Righta").getImage();
        bus_R_B = new Texture("/sprites/Frogger_Truck_Rightb").getImage();
        car_R_A = new Texture("/sprites/Frogger_Car_Righta").getImage();
        car_R_B = new Texture("/sprites/Frogger_Car_Rightb").getImage();
        car_R_C = new Texture("/sprites/Frogger_Car_Rightc").getImage();
        car_R_D = new Texture("/sprites/Frogger_Car_Rightd").getImage();
        
        logA = new Texture("/sprites/Frogger_Loga").getImage();
        logB = new Texture("/sprites/Frogger_Logb").getImage();
        logC = new Texture("/sprites/Frogger_Logc").getImage();
        
        pavement = new Texture("/sprites/Frogger_pavementa").getImage();
        pavementA = new Texture("/sprites/Frogger_pavementb").getImage();
        
        wall_L = new Texture("/sprites/Frogger_Grass_L").getImage();
        wall_R = new Texture("/sprites/Frogger_Grass_R").getImage();
        wall_Centre = new Texture("/sprites/Frogger_Grass_Centre").getImage();
        home = new Texture("/sprites/Frogger_Grassa").getImage();
        home_Complete = new Texture("/sprites/Frogger_Safe").getImage();
        water = new Texture("/sprites/Frogger_Water").getImage();
        road = new Texture("/sprites/Frogger_Road").getImage();
        
        
        timeSinceStart = 0.0f;
        
        cellWidth = 60;
        cellHeight = 60;
        
        firstTick = true;
        lastTick = false;

        //Reset Level Time
        resetLevelTime();
    }
    
    
    /**
     * changeLevel()
     * 
     */
    public static void changeLevel(){
        if(levelNo < 8){
            levelNo++;
            setLevelNo(levelNo);
        } else {
            gameComplete = true;
        }
    }
    
    
    /**
     * getLevelNo()
     * 
     * 
     * @return levelNo
     */
    public static int getLevelNo(){
        return levelNo;
    }
    
    
    /**
     * setLevelNo()
     * 
     * 
     * @param levNo
     */
    public static void setLevelNo(int levNo){
        levelNo = levNo;
        Game.level = new Level(levelNo, Frogger.getMainWidth(), Frogger.getMainHeight());
    }
    
    
    /**
     * getLevelName()
     * 
     * 
     * @return levelName
     */
    public static String getLevelName(){
        switch(levelNo){
            case 1:
                levelName = "Start Zone - Dark side of the moon";
                
                break;
                
            case 2:
                levelName = "Martian Orbit - The Red Planet";
                
                break;
                
            case 3:
                levelName = "Terra Ferma - Protect Earth";
                
                break;
                
            case 4:
                levelName = "Fourth Quarter - Save the Sun";
                
                break;
                
            case 5:
                levelName = "Lunar Orbit - The Full Moon";
                
                break;
                
            case 6:
                levelName = "Martian Resistance - Defend Mars";
                
                break;
                
            case 7:
                levelName = "3rd Rock From The Sun - Protect Earth (again)";
                
                break;
                
            case 8:
                levelName = "Final Frontier - Send em to the Sun";
                
                break;
            
            default:
                levelName = "GAME COMPLETE!";
                
                break;
            
        }

        return levelName;
    }
    
    
    /**
    * tick()
    * 
    * 
    * Updates Level Object
    */
    public static void tick(){
        //Manage Level: First Tick
        if(firstTick) {
            //Set firstTick: false
            firstTick = false;
            
            //Reset Game Time
            Game.resetGameTime();
            
            //Reset Level Time
            resetLevelTime();
            
            if(Game.getGame().getGameMusic()){
                if(Game.levelNo == 1 && !Sound.Level1.isPlaying()){
                    Sound.Level1.loop();
                }
                if(Game.levelNo == 2 && !Sound.Level2.isPlaying()){
                    Sound.Level2.loop();
                }
                if(Game.levelNo == 3 && !Sound.Level3.isPlaying()){
                    Sound.Level3.loop();
                }
                if(Game.levelNo == 4 && !Sound.Level4.isPlaying()){
                    Sound.Level4.loop();
                }
                if(Game.levelNo == 5 && !Sound.Level5.isPlaying()){
                    Sound.Level5.loop();
                }
                if(Game.levelNo == 6 && !Sound.Level6.isPlaying()){
                    Sound.Level6.loop();
                }
                if(Game.levelNo == 7 && !Sound.Level7.isPlaying()){
                    Sound.Level7.loop();
                }
                if(Game.levelNo == 8 && !Sound.Level8.isPlaying()){
                    Sound.Level8.loop();
                }
            }
        }
        
        //Manage Level: Last Tick
        if(lastTick) {
            lastTick = false;
            Sound.stopAll();
            if(!Sound.creditsSoundtrack.isPlaying()){
                Sound.creditsSoundtrack.play();
            }
            
            //Reset Level Time
            resetLevelTime();
        }
            
        timeSinceStart += 0.01f;
          
    }
    
    
    /**
    * render(Render target, Graphics2D g)
    * 
    * 
    * Renders/Repaints Level Objects
    * 
    * @param target - the Render of Level
    * @param g2d
    */
    public void render(Render target, Graphics2D g2d){
        Graphics2D g2d_Level = g2d;
        AffineTransform oldXForm = g2d.getTransform();
        
        g2d_Level.translate(0, 50);
        
        //Frog Moved by platforms
//        if(Game.player.y <= 3) Game.player.x -= timeSinceStart * laneSpeed[(int) Game.player.y];
        
        //Collision detection
//        boolean tLeft = bufDanger[(int)(Game.player.y * cellHeight + 1) * Frogger.getMainWidth() + (int) (Game.player.x * cellWidth + 1)];
//        boolean tRight = bufDanger[(int)(Game.player.y * cellHeight + 1) * Frogger.getMainWidth() + (int) ((Game.player.x + 1) * cellWidth - 1)];
//        boolean bLeft = bufDanger[(int)((Game.player.y + 1) * cellHeight - 1) * Frogger.getMainWidth() + (int) (Game.player.x * cellWidth + 1)];
//        boolean bRight = bufDanger[(int)((Game.player.y + 1) * cellHeight - 1) * Frogger.getMainWidth() + (int) ((Game.player.x + 1) * cellWidth - 1)];
        
//        boolean tLeft = bufDanger[(int)(Game.player.y * 32 + 0.2f) * Frogger.getMainWidth() / cellWidth + 3 + (int) (Game.player.x * 32 + 0.2f)];
//        boolean tRight = bufDanger[(int)(Game.player.y * 32 + 0.2f) * Frogger.getMainWidth() / cellWidth + 3 + (int) ((Game.player.x + 0.2f) * 32 - 0.2f)];
//        boolean bLeft = bufDanger[(int)((Game.player.y + 0.2f) * 32 - 0.2f) * Frogger.getMainWidth() / cellWidth + 3 + (int) (Game.player.x * 32 + 0.2f)];
//        boolean bRight = bufDanger[(int)((Game.player.y + 0.2f) * 32 - 0.2f) * Frogger.getMainWidth() / cellWidth + 3 + (int) ((Game.player.x + 0.2f) * 32 - 0.2f)];
        
//        boolean tLeft = bufDanger[(int)(Game.player.y * 32 + 1) * Frogger.getMainWidth() + (int) (Game.player.x * 32 + 1)];
//        boolean tRight = bufDanger[(int)(Game.player.y * 32 + 1) * Frogger.getMainWidth() + (int) ((Game.player.x + 1) * 32 - 1)];
//        boolean bLeft = bufDanger[(int)((Game.player.y + 1) * 32 - 1) * Frogger.getMainWidth() + (int) (Game.player.x * 32 + 1)];
//        boolean bRight = bufDanger[(int)((Game.player.y + 1) * 32 - 1) * Frogger.getMainWidth() + (int) ((Game.player.x + 1) * 32 - 1)];
        
//        if(tLeft || tRight || bLeft || bRight){
//            //Frog has been hit
            //Game.player.x = (int) 8.0f;
            //Game.player.y = (int) 9.0f;
//            System.out.println("Collision Detected: tl:"+tLeft+" tr:"+tRight+" bl:"+bLeft+" br"+bRight);
            //Game.player.resetPlayer();
//        }
        
        //Draw Lanes
        int x = -1;
        int y = 0;
        collisionList[0].clear();
        collisionList[1].clear();
        collisionList[2].clear();
        collisionList[3].clear();
        collisionList[4].clear();
        collisionList[5].clear();
        collisionList[6].clear();
        collisionList[7].clear();
        collisionList[8].clear();
        collisionList[9].clear();
        collisionList[10].clear();
        collisionList[11].clear();
        
//        for(Map.Entry<String, Float> aLane : lanes.entrySet()){
        for(int i = 0; i < lane.length; i++){
            
            //Find Offset
            int startPOS = (int) (timeSinceStart * laneSpeed[i]) % 64;
            int cellOffset = (int) ((float) cellWidth * timeSinceStart * laneSpeed[i]) % cellWidth;
            if(startPOS < 0) startPOS = 64 - (Math.abs(startPOS) % 64);
            
            for(int j = 0; j < Frogger.getMainWidth() / cellWidth + 3; j++){
                char graphic = lane[i].toCharArray()[(startPOS + j) % 64];
                
                switch(graphic){
                    case 'a': //Bus Front
                        if(laneSpeed[i] < 0){
                            img = bus_R_A;
                        } else {
                            img = bus_L_A;
                        }
                        break;
                    case 's': //Bus Back
                        if(laneSpeed[i] < 0){
                            img = bus_R_B;
                        } else {
                            img = bus_L_B;
                        }
                        break;
                    case 'd': //Bus Centre
                        img = bus_Centre;
                        
                        break;
                    case 'f': 
                        img = home_Complete;
                        
                        break;
                        
                        //Logs
                    case 'j':
                        img = logA;//Log Start
                        break;
                    case 'i':
                        img = logB;//Log Middle
                        break;
                    case 'k':
                        img = logC;//Log End
                        break;
                        
                    case 'z':
                        if(laneSpeed[i] > 0){
                            img = car_L_A;
                        } else {
                            img = car_R_A;
                        }
                        break;
                    case 'x':
                        if(laneSpeed[i] > 0){
                            img = car_L_B;
                        } else {
                            img = car_R_B;
                        }
                        break;
                        
                    case 't':
                        if(laneSpeed[i] > 0){
                            img = car_L_C;
                        } else {
                            img = car_R_C;
                        }
                        break;
                    case 'y':
                        if(laneSpeed[i] > 0){
                            img = car_L_D;
                        } else {
                            img = car_R_D;
                        }
                        break;
                        
                    case 'v'://Wall
                        img = wall_L;
                        break;
                    case 'w'://Wall
                        img = wall_Centre;
                        break;
                    case 'r'://Wall
                        img = wall_R;
                        break;
                    case 'h'://Home
                        img = home;
                        break;
                    case ','://Water
                        img = water;
                        break;
                    case 'p'://Pavement(Road)
                        img = pavement;
                        break;
                    case 'q'://Pavement(Road/Water)
                        img = pavementA;
                        break;
                    case '.'://Road
                        img = road;
                        break;
                
                }
                
                g2d_Level.drawImage(img, (x + j) * cellWidth - cellOffset, y * cellHeight, cellWidth, cellHeight, null);
                
                //Draw Bounds
                r1 = new Rectangle((int) ((x + j) * cellWidth - cellOffset) + 8, (int)  (y * cellHeight) + 6, cellWidth - 16, cellHeight - 14);
                
                
                if(Game.showBounds){
                    r2 = new Rectangle((x + j) * cellWidth - cellOffset, y * cellHeight, cellWidth, cellHeight);
                    g2d_Level.setColor(Color.gray);
                    g2d_Level.drawRect(r2.x, r2.y, r2.width, r2.height);//(x + i + 1) * cellSize - cellOffset, (y + 1) * cellSize);
                    g2d_Level.setColor(Color.white);
                    if(graphic == 'x') g2d_Level.drawRect(r1.x, r1.y, r1.width, r1.height);
                    g2d_Level.drawString(""+graphic, (x + j) * cellWidth - cellOffset, y * cellHeight + 12);
                    g2d_Level.drawString(" x:"+((x + j) * cellWidth - cellOffset)+" y:"+(y * cellHeight), (x + j) * cellWidth - cellOffset, y * cellHeight + 18);
                }
                
                if(graphic == ','){//!(graphic == '.' || graphic == 'h')){
                    if(i == 0) collisionList[0].add(r1);//Water    
                    if(i == 1) collisionList[1].add(r1);//Water
                    if(i == 2) collisionList[2].add(r1);//Water    
                    if(i == 3) collisionList[3].add(r1);//Water
                } 
                if(graphic == 'j' || graphic == 'k' || graphic == 'l'){
                    if(i == 1) collisionList[4].add(r1);//Logs    
                    if(i == 2) collisionList[10].add(r1);//Logs    
                    if(i == 3) collisionList[11].add(r1);//Logs    
                }
                if(graphic == 'h'){
                    //if(i == 9) 
                        collisionList[9].add(r1);//Homebase
                }
                if(!(graphic == '.' || graphic == 'j' || graphic == 'k' || graphic == 'l' || graphic == 'p' || graphic == 'q' || graphic == 'h')){
                    if(i == 5) collisionList[5].add(r1);//Cars
                    if(i == 6) collisionList[6].add(r1);//Buses    
                    if(i == 7) collisionList[7].add(r1);//Cars    
                    if(i == 8) collisionList[8].add(r1);//Cars
                }
                
            }
            y++;
        }
        
        if(Game.showBounds){
            if(collisionList[0].size() > 0) System.out.println("Collision List 0 Size: "+collisionList[0].size()+" "+lane[0].toString());
            if(collisionList[1].size() > 0) System.out.println("Collision List 1 Size: "+collisionList[1].size()+" "+lane[1].toString());
            if(collisionList[2].size() > 0) System.out.println("Collision List 2 Size: "+collisionList[2].size()+" "+lane[2].toString());
            if(collisionList[3].size() > 0) System.out.println("Collision List 3 Size: "+collisionList[3].size()+" "+lane[3].toString());
            if(collisionList[4].size() > 0) System.out.println("Collision List 4 Size: "+collisionList[4].size()+" "+lane[1].toString());
            if(collisionList[5].size() > 0) System.out.println("Collision List 5 Size: "+collisionList[5].size()+" "+lane[5].toString());
            if(collisionList[6].size() > 0) System.out.println("Collision List 6 Size: "+collisionList[6].size()+" "+lane[6].toString());
            if(collisionList[7].size() > 0) System.out.println("Collision List 7 Size: "+collisionList[7].size()+" "+lane[7].toString());
            if(collisionList[8].size() > 0) System.out.println("Collision List 8 Size: "+collisionList[8].size()+" "+lane[8].toString());
            if(collisionList[9].size() > 0) System.out.println("Collision List 9 Size: "+collisionList[9].size()+" "+lane[0].toString());
            if(collisionList[10].size() > 0) System.out.println("Collision List 10 Size: "+collisionList[10].size()+" "+lane[2].toString());
            if(collisionList[11].size() > 0) System.out.println("Collision List 11 Size: "+collisionList[11].size()+" "+lane[3].toString());
        }
        
        
//        Game.hud.render(target, g2d_Level);
        if(!levelComplete && Game.pauseTime == 0){

            switch(levelNo){
                case 1:
//                    anim.render(target, 180, 220, 0.75, 1280, 720);
                    break;
                case 2:
//                    animMars.render(target, 120, 190, 0.75, 480, 270);
                    break;
                case 3:
//                    animEarth.render(target, 180, 220, 0.5, 480, 270);
                    break;
                case 4:
//                    animSun.render(target, 10, 110, 0.6, 480, 270);
                    break;
                case 5:
//                    anim.render(target, 80, 170, 1.3, 1280, 720);
                    break;
                case 6:
//                    animMars.render(target, 60, 140, 1.0, 480, 270);
                    break;
                case 7:
//                    animSun.render(target, 10, 110, 0.6, 480, 270);
                    break;
                case 8:
//                    animEarth.render(target, 40, 140, 1.0, 480, 270);
                    break;
            }
            
        }
        
        if(Game.showFPS){
            String fps = Game.theFPS;
            target.draw(fps, Labels.fpsX, Labels.fpsY, 0xfe1300);
        }
        if(Game.showUPS){
            String ups = Game.theUPS;
            target.draw(ups, Labels.upsX, Labels.upsY, 0xf0ff00);
        }
        if(Game.showGameTime){
            String gameTime = Game.theGameTime;
            target.draw(gameTime, Labels.upsX+110, Labels.upsY+44, 0x008fea);
        }
        if(Game.showLevelTime){
            String levTime = theLevelTime;
            target.draw(levTime, Labels.upsX+310, Labels.upsY+44, 0xff8fea);
        }
                
        //target.scaleDraw(Texture.ground, groundScale, groundX, groundY, 0, 0, 256, 64, groundColor);

        if(Game.showBounds){
            g2d_Level.setColor(Color.GREEN);
//            g2d_Level.drawRect(groundBounds.x, groundBounds.y, groundBounds.width, groundBounds.height);
            g2d_Level.setColor(Color.WHITE);
            //g.drawRect(Enemy.leftSide - 5, 29, 5, Display.game.getHeight() - (28 + groundBounds.height + 8));
            g2d_Level.setColor(Color.WHITE);
            //g.drawRect(Enemy.rightSide + 19, 29, 5, Display.game.getHeight() - (28 + groundBounds.height + 8));
        }    
        
        if (Game.pauseTime > 0 && !Game.paused && Game.getGame().menu == null) {
            if(levelComplete){
                long time = System.currentTimeMillis();
//                BRCExplode.clearAll();
//                Barricade.clearAll();
//                P1Explode.clearAll();
//                P1Bullet.clearAll();
                
                for (levelCompleteCount = 0; levelCompleteCount < 500; levelCompleteCount++) {
                    //Draw scaled 3D SI Icon: GOLD
                    if(time / 25 % 5 == 0){
                        //render Space Invaders Icon
                        //target.scaleDraw(Texture.buttonsA, 3, 234, 132, 48, 126, 50, 38, 0xFFBF00);
                        //target.scaleDraw(Texture.buttonsA, 3, 230, 128, 48, 126, 50, 38, 0xBF9B30);
                    } else if(time / 200 % 40 == 0){
                        //render Space Invaders Icon
                        //target.scaleDraw(Texture.buttonsA, 3, 234, 132, 48, 126, 50, 38, 0xBF9B30);
                        //target.scaleDraw(Texture.buttonsA, 3, 230, 128, 48, 126, 50, 38, 0xFFBF00);
                    }
                    if (time / 450 % 2 == 0) {

                        //COMPLETE
                        //target.scaleDraw(Texture.buttonsA, Labels.click2FocusScale, Labels.click2FocusX-20, Labels.click2FocusY+40, 235, 200, 220, 30, 0xBF9B30);
                        //target.scaleDraw(Texture.buttonsA, Labels.click2FocusScale, Labels.click2FocusX-24, Labels.click2FocusY+36, 235, 200, 220, 30, 0xffffff);

                        
                        //Level
                        //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelX-120, Labels.LevelY, 130, 300, 73, 35, levelTxtBGCol);
                        //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelX-116, Labels.LevelY-4, 130, 300, 73, 35, 0xffffff);

                        if (Game.levelNo == 1){
                            //level 1 No.
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX-120, Labels.LevelNoY, 200, 300, 15, 35, levelTxtBGCol);
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX-116, Labels.LevelNoY-4, 200, 300, 15, 35, 0xffffff);
                        }
                        
                        if (Game.levelNo == 2) {
                            //level 2 No.
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX-120, Labels.LevelNoY, 220, 300, 15, 35, levelTxtBGCol);
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX-116, Labels.LevelNoY-4, 220, 300, 15, 35, 0xffffff);
                        }

                        if (Game.levelNo == 3) {
                            //level 3 No.
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX-120, Labels.LevelNoY, 240, 300, 15, 35, levelTxtBGCol);
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX-116, Labels.LevelNoY-4, 240, 300, 15, 35, 0xffffff);
                        }
                        
                        if (Game.levelNo == 4) {
                            //level 4 No.
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX-120, Labels.LevelNoY, 260, 300, 15, 35, levelTxtBGCol);
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX-116, Labels.LevelNoY-4, 260, 300, 15, 35, 0xffffff);
                        }
                        
                        if (Game.levelNo == 5) {
                            //level 5 No.
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX-120, Labels.LevelNoY, 276, 300, 15, 35, levelTxtBGCol);
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX-116, Labels.LevelNoY-4, 276, 300, 15, 35, 0xffffff);
                        }
                        
                        if (Game.levelNo == 6) {
                            //level 6 No.
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX-120, Labels.LevelNoY, 292, 300, 15, 35, levelTxtBGCol);
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX-116, Labels.LevelNoY-4, 292, 300, 15, 35, 0xffffff);
                        }

                        if (Game.levelNo == 7) {
                            //level 7 No.
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX-120, Labels.LevelNoY, 310, 300, 15, 35, levelTxtBGCol);
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX-116, Labels.LevelNoY-4, 310, 300, 15, 35, 0xffffff);
                        }

                        if (Game.levelNo == 8) {
                            //level 8 No.
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX-120, Labels.LevelNoY, 332, 300, 15, 35, levelTxtBGCol);
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX-116, Labels.LevelNoY-4, 332, 300, 15, 35, 0xffffff);
                        }                        
                    
                        //target.drawText("Lives Bonus: "+Game.getLivesBonus(), 2, Labels.enterLevelX+120, Labels.enterLevelY+170, 0xFeca00);
                        //target.drawText("Time Bonus: "+Game.getTimeBonus(), 2, Labels.enterLevelX+120, Labels.enterLevelY+200, 0xFF0000);
                        //target.drawText("Accuracy Bonus: "+Game.getAccuracyBonus(), 2, Labels.enterLevelX+120, Labels.enterLevelY+230, 0xFFaa00);
                        //target.drawText("Level Bonus: "+Game.getLevelBonus(), 3, Labels.enterLevelX+120, Labels.enterLevelY+275, 0xFFce00);
                        
                        Frogger.setStatusBar("Level "+Game.levelNo+" : "+getLevelName()+" Completed!!");    
                    } else {
                        //target.drawText("Level Bonus: "+Game.getLevelBonus(), 3, Labels.enterLevelX+120, Labels.enterLevelY+275, 0xffffff);
                    }
                    
                    if (Game.levelNo == 1){
                        //level 1 3D Name
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX-30, Labels.enterLevelY+70, levelTxtBGCol);
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX-32, Labels.enterLevelY+68, 0xffffff);
                    }
                    if (Game.levelNo == 2){
                        //level 2 3D Name
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX, Labels.enterLevelY+70, levelTxtBGCol);
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX-2, Labels.enterLevelY+68, 0xffffff);
                    }
                    if (Game.levelNo == 3){
                        //level 3 3D Name
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX+10, Labels.enterLevelY+70, levelTxtBGCol);
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX+8, Labels.enterLevelY+68, 0xffffff);
                    }
                    if (Game.levelNo == 4){
                        //level 4 3D Name
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX-5, Labels.enterLevelY+70, levelTxtBGCol);
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX-7, Labels.enterLevelY+68, 0xffffff);
                    }
                    if (Game.levelNo == 5){
                        //level 5 3D Name
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX+10, Labels.enterLevelY+70, levelTxtBGCol);
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX+8, Labels.enterLevelY+68, 0xffffff);
                    }
                    if (Game.levelNo == 6){
                        //level 6 3D Name
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX-22, Labels.enterLevelY+70, levelTxtBGCol);
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX-24, Labels.enterLevelY+68, 0xffffff);
                    }
                    if (Game.levelNo == 7){
                        //level 7 3D Name
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX-60, Labels.enterLevelY+70, levelTxtBGCol);
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX-62, Labels.enterLevelY+68, 0xffffff);
                    }
                    if (Game.levelNo == 8){
                        //level 8 3D Name
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX-50, Labels.enterLevelY+70, levelTxtBGCol);
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX-52, Labels.enterLevelY+68, 0xffffff);
                    }
                    
                    if (levelCompleteCount == 0) {
                        lastTick = true;
                        break;
                    }
                }
                
            } else {
                long time = System.currentTimeMillis();
                for (levelStartCount = 0; levelStartCount < 100; levelStartCount++) {    
                    //Draw scaled 3D SI Icon: BLUE
                    if(time / 25 % 5 == 0){
                        //render Space Invaders Icon
                        //target.scaleDraw(Texture.buttonsA, 3, 234, 132, 48, 126, 50, 38, enterLvlIconBG);
                        //target.scaleDraw(Texture.buttonsA, 3, 230, 128, 48, 126, 50, 38, enterLvlIconFG);
                    } else if(time / 20 % 40 == 0){
                        //render Space Invaders Icon
                        //target.scaleDraw(Texture.buttonsA, 3, 234, 132, 48, 126, 50, 38, enterLvlIconFG);
                        //target.scaleDraw(Texture.buttonsA, 3, 230, 128, 48, 126, 50, 38, enterLvlIconBG);
                    }
                    if (time / 450 % 2 == 0) {

                        //Entering 3D
                        //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.enterLevelX, Labels.enterLevelY+30, 0, 300, 130, 35, levelTxtBGCol);
                        //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.enterLevelX-4, Labels.enterLevelY+26, 0, 300, 130, 35, 0xffffff);

                        //Level
                        //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelX, Labels.LevelY+30, 130, 300, 73, 35, levelTxtBGCol);
                        //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelX-4, Labels.LevelY+26, 130, 300, 73, 35, 0xffffff);

                        if (Game.levelNo == 1 || Game.levelNo == -1) {
                            
                            //level 1 No.
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX, Labels.LevelY+30, 200, 300, 15, 35, levelTxtBGCol);
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX-4, Labels.LevelY+26, 200, 300, 15, 35, 0xffffff);
                        }

                        if (Game.levelNo == 2) {
                            //level 2 No.
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX, Labels.LevelNoY+30, 220, 300, 15, 35, levelTxtBGCol);
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX-4, Labels.LevelNoY+26, 220, 300, 15, 35, 0xffffff);
                        }

                        if (Game.levelNo == 3) {
                            //level 3 No.
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX, Labels.LevelNoY+30, 240, 300, 15, 35, levelTxtBGCol);
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX-4, Labels.LevelNoY+26, 240, 300, 15, 35, 0xffffff);
                        }

                        if (Game.levelNo == 4) {
                            //level 4 No.
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX, Labels.LevelNoY+30, 260, 300, 15, 35, levelTxtBGCol);
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX-4, Labels.LevelNoY+26, 260, 300, 15, 35, 0xffffff);
                        }
                        
                        if (Game.levelNo == 5) {
                            //level 5 No.
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX, Labels.LevelNoY+30, 276, 300, 15, 35, levelTxtBGCol);
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX-4, Labels.LevelNoY+26, 276, 300, 15, 35, 0xffffff);
                        }

                        if (Game.levelNo == 6) {
                            //level 6 No.
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX, Labels.LevelNoY+30, 292, 300, 15, 35, levelTxtBGCol);
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX-4, Labels.LevelNoY+26, 292, 300, 15, 35, 0xffffff);
                        }

                        if (Game.levelNo == 7) {
                            //level 7 No.
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX, Labels.LevelNoY+30, 310, 300, 15, 35, levelTxtBGCol);
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX-4, Labels.LevelNoY+26, 310, 300, 15, 35, 0xffffff);
                        }

                        if (Game.levelNo == 8) {
                            //level 8 No.
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX, Labels.LevelNoY+30, 332, 300, 15, 35, levelTxtBGCol);
                            //target.scaleDraw(Texture.buttonsA, Labels.enterLevelNoScale, Labels.LevelNoX-4, Labels.LevelNoY+26, 332, 300, 15, 35, 0xffffff);
                        }
                        Frogger.setStatusBar("Entering Level "+Game.levelNo+" : "+getLevelName());
                        
                    }
                    
                    if (Game.levelNo == 1 || Game.levelNo == -1) {
                        //level 3D Name
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX-30, Labels.enterLevelY+100, 0xffffff);
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX-31, Labels.enterLevelY+99, levelTxtBGCol);
                    }
                    if (Game.levelNo == 2) {
                        //level 2 Name
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX, Labels.enterLevelY+100, 0xffffff);
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX-1, Labels.enterLevelY+99, levelTxtBGCol);
                    }
                    if (Game.levelNo == 3) {
                        //level 3 Name
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX+10, Labels.enterLevelY+100, 0xffffff);
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX+9, Labels.enterLevelY+99, levelTxtBGCol);
                    }
                    if (Game.levelNo == 4) {
                        //level 4 Name
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX-5, Labels.enterLevelY+100, 0xffffff);
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX-6, Labels.enterLevelY+99, levelTxtBGCol);
                    }
                    if (Game.levelNo == 5) {
                        //level 5 Name
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX+10, Labels.enterLevelY+100, 0xffffff);
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX+9, Labels.enterLevelY+99, levelTxtBGCol);
                    }
                    if (Game.levelNo == 6) {
                        //level 6 Name
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX-22, Labels.enterLevelY+100, 0xffffff);
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX-21, Labels.enterLevelY+99, levelTxtBGCol);
                    }
                    if (Game.levelNo == 7) {
                        //level 7 Name
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX-60, Labels.enterLevelY+100, 0xffffff);
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX-61, Labels.enterLevelY+99, levelTxtBGCol);
                    }
                    if (Game.levelNo == 8) {
                        //level 8 Name
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX-50, Labels.enterLevelY+100, 0xffffff);
                        //target.drawText(getLevelName(), 2, Labels.enterLevelX-51, Labels.enterLevelY+99, levelTxtBGCol);
                    }
                    
                    if(levelStartCount == 100){
                        firstTick = true;
                        //Reset Level Time
                        resetLevelTime();
                        break;
                    }
                    
                }
            }
            
        }
        g2d.setTransform(oldXForm);
        g2d_Level.setTransform(oldXForm);
    }

    
    /**
    * setBackground(int index)
    * 
    * 
    * @param index
    */
    public static void setBackground(int index) {
        background = index;
    }

    
    /**
    * setGroundColor(int col)
    * 
    * 
    * @param col
    */
    private void setGroundColor(int col) {
//        groundColor = col;
    }

    
    /**
    * resetLevelTime()
    * 
    */
    public static void resetLevelTime() {
        System.out.println("Level: Resetting Level Time");
        Game.levelTime = 0;
    }
    
}
