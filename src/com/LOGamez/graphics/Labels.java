/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LOGamez.graphics;

import com.LOGamez.frogger.*;


/**
 *
 * @author Nicholas Wright
 */
public class Labels {
    
    /**Attributes*/
    
    /**scoreLabelScale variable of Labels*/
    public static double scoreLabelScale;
    
    /**scoreX coordinate of Labels*/
    public static int scoreX;
    
    /**scoreY coordinate of Labels*/
    public static int scoreY;
    
    /**livesLabelX coordinate of Labels*/
    public static int livesLabelX;
    
    /**livesLabelY coordinate of Labels*/
    public static int livesLabelY;
    
    /**livesLabelShadowCol coordinate of Labels*/
    public static int livesLabelBGCol;
    
    /**livesLabelShadowCol coordinate of Labels*/
    public static int livesLabelFGCol;
    
    /**playerNameX coordinate of Labels*/
    public static int playerNameX;
    
    /**playerNameY coordinate of Labels*/
    public static int playerNameY;
    
    /**livesImgScale variable of Labels*/
    public static int livesImgScale;
    
    /**livesImg0X coordinate of Labels*/
    public static int livesImg0X;
    
    /**livesImg0Y coordinate of Labels*/
    public static int livesImg0Y;
    
    /**livesImg1X coordinate of Labels*/
    public static int livesImg1X;
    
    /**livesImg1Y coordinate of Labels*/
    public static int livesImg1Y;
    
    /**livesImg2X coordinate of Labels*/
    public static int livesImg2X;
    
    /**livesImg2Y coordinate of Labels*/
    public static int livesImg2Y;
    
    /**scoreLabelX coordinate of Labels*/
    public static int scoreLabelX;
    
    /**scoreLabelY coordinate of Labels*/
    public static int scoreLabelY;
    
    /**scoreLabelBGCol coordinate of Labels*/
    public static int scoreLabelBGCol;
    
    /**scoreLabelFGCol coordinate of Labels*/
    public static int scoreLabelFGCol;
    
    /**LabelScale variable of Labels*/
    public static double LabelScale;
    
    /**fpsX coordinate of Labels*/
    public static int fpsX;
    
    /**fpsY coordinate of Labels*/
    public static int fpsY;
    
    /**upsX coordinate of Labels*/
    public static int upsX;
    
    /**upsY coordinate of Labels*/
    public static int upsY;  
    
    /**enterLevelNoScale variable of Labels*/
    public static double enterLevelNoScale;
    
    /**enterLevelX coordinate of Labels*/
    public static int enterLevelX;
    
    /**enterLevelY coordinate of Labels*/
    public static int enterLevelY;
    
    /**LevelX coordinate of Labels*/
    public static int LevelX;
    
    /**LevelY coordinate of Labels*/
    public static int LevelY;
    
    /**LevelNoX coordinate of Labels*/
    public static int LevelNoX;
    
    /**LevelNoY coordinate of Labels*/
    public static int LevelNoY;
    
    /**click2FocusScale variable of Labels*/
    public static double click2FocusScale;
    
    /**click2FocusX coordinate of Labels*/
    public static int click2FocusX;
    
    /**click2FocusY coordinate of Labels*/
    public static int click2FocusY;
    
    
    
    
    /**Constructor*/
    
    
    /**
     * Labels Constructor
     * 
     */
    public Labels(){
        System.out.println("Labels: New Labels Created");
        setUp();
    }    
    
    
    /**Public Protocol*/
    
    
    /**
     * setUp()
     * 
     */
    public static void setUp(){
        int width = Frogger.getMainWidth();
        switch(width){
            case 300:
                LabelScale = 0.75;
            
                scoreLabelX = Frogger.getMainWidth() - 175;
                scoreLabelY = -12;
                scoreLabelBGCol = 0x0e8100;//Dark Green
                scoreLabelFGCol = 0xffffff;//White

                scoreX = Frogger.getMainWidth() - 40;
                scoreY = 15;

                livesLabelX = 5;
                livesLabelY = -12;
                livesLabelBGCol = 0x0e8100;//Dark Green
                livesLabelFGCol = 0xffffff;//White

                playerNameX = Frogger.getMainWidth() / 2 - Game.getPName().length() * 5;
                playerNameY = 15;

                livesImgScale = 25;
                livesImg0X = 90;
                livesImg0Y = -5;

                livesImg1X = 115;
                livesImg1Y = -5;

                livesImg2X = 140;
                livesImg2Y = -5;

                enterLevelNoScale = 1;
                enterLevelX = Frogger.getMainWidth() / 6 - 30;//10
                enterLevelY = Frogger.getMainHeight() - 175;

                LevelX = Frogger.getMainWidth() - 150;//120
                LevelY = Frogger.getMainHeight() - 174;

                LevelNoX = Frogger.getMainWidth() - 60;//165
                LevelNoY = LevelY;

                click2FocusScale = 1;
                click2FocusX = Frogger.getMainWidth() / 6;
                click2FocusY = Frogger.getMainHeight() / 2 - 50;

                fpsX = 5;
                fpsY = Frogger.getMainHeight() - 55;
                upsX = 5;
                upsY = Frogger.getMainHeight() - 45;
            
                break;
                
            case 480:
                LabelScale = 1.00;
            
                scoreLabelX = Frogger.getMainWidth() - 175;
                scoreLabelY = -22;
                scoreLabelBGCol = 0x0e8100;//Dark Green
                scoreLabelFGCol = 0xffffff;//White

                scoreX = Frogger.getMainWidth() - 80;
                scoreY = 15;

                livesLabelX = 5;
                livesLabelY = -22;
                livesLabelBGCol = 0x0e8100;//Dark Green
                livesLabelFGCol = 0xffffff;//White

                playerNameX = Frogger.getMainWidth() / 2 - Game.getPName().length() * 5;
                playerNameY = 15;

                livesImgScale = 50;
                livesImg0X = 90;
                livesImg0Y = -15;

                livesImg1X = 140;
                livesImg1Y = -15;

                livesImg2X = 190;
                livesImg2Y = -15;

                enterLevelNoScale = 2;
                enterLevelX = Frogger.getMainWidth() / 6 - 30;
                enterLevelY = Frogger.getMainHeight() - 375;

                LevelX = Frogger.getMainWidth() - 290;
                LevelY = Frogger.getMainHeight() - 374;

                LevelNoX = Frogger.getMainWidth() - 135;
                LevelNoY = LevelY;

                click2FocusScale = 2.0;
                click2FocusX = Frogger.getMainWidth() / 6;
                click2FocusY = Frogger.getMainHeight() / 2 - 50;

                fpsX = 5;
                fpsY = Frogger.getMainHeight() - 115;
                upsX = 5;
                upsY = Frogger.getMainHeight() - 95;
                
                break;
                
            case 604:
                LabelScale = 1.25;
            
                scoreLabelX = Frogger.getMainWidth() - 160;
                scoreLabelY = -22;
                scoreLabelBGCol = 0xe81000;//0x0e8100;//Dark Green
                scoreLabelFGCol = 0xffffff;//White

                scoreX = Frogger.getMainWidth() - 70;
                scoreY = 15;

                livesLabelX = 5;
                livesLabelY = -22;
                livesLabelBGCol = 0x0e8100;//Dark Green
                livesLabelFGCol = 0xffffff;//White

                playerNameX = Frogger.getMainWidth() / 2 - Game.getPName().length() * 5;
                playerNameY = 15;

                livesImgScale = 50;
                livesImg0X = 90;
                livesImg0Y = -15;

                livesImg1X = 140;
                livesImg1Y = -15;

                livesImg2X = 190;
                livesImg2Y = -15;

                enterLevelNoScale = 2;
                enterLevelX = Frogger.getMainWidth() / 6 - 30;
                enterLevelY = Frogger.getMainHeight() - 465;

                LevelX = Frogger.getMainWidth() - 290;
                LevelY = Frogger.getMainHeight() - 464;

                LevelNoX = Frogger.getMainWidth() - 135;
                LevelNoY = LevelY;

                click2FocusScale = 2.0;
                click2FocusX = Frogger.getMainWidth() / 6;
                click2FocusY = Frogger.getMainHeight() / 2 - 50;

                fpsX = 5;
                fpsY = Frogger.getMainHeight() - 115;
                upsX = 5;
                upsY = Frogger.getMainHeight() - 95;
                
                break;
                
            default:
                LabelScale = 1.25;
            
                scoreLabelX = Frogger.getMainWidth() - 175;
                scoreLabelY = -22;
                scoreLabelBGCol = 0x0e8100;//Dark Green
                scoreLabelFGCol = 0xffffff;//White

                scoreX = Frogger.getMainWidth() - 70;
                scoreY = 15;

                livesLabelX = 5;
                livesLabelY = -22;
                livesLabelBGCol = 0x0e8100;//Dark Green
                livesLabelFGCol = 0xffffff;//White

                playerNameX = Frogger.getMainWidth() / 2 - Game.getPName().length() * 5;
                playerNameY = 15;

                livesImgScale = 50;
                livesImg0X = 90;
                livesImg0Y = -15;

                livesImg1X = 140;
                livesImg1Y = -15;

                livesImg2X = 190;
                livesImg2Y = -15;

                enterLevelNoScale = 2;
                enterLevelX = Frogger.getMainWidth() / 6 - 30;
                enterLevelY = Frogger.getMainHeight() - 465;

                LevelX = Frogger.getMainWidth() - 290;
                LevelY = Frogger.getMainHeight() - 464;

                LevelNoX = Frogger.getMainWidth() - 135;
                LevelNoY = LevelY;

                click2FocusScale = 2.0;
                click2FocusX = Frogger.getMainWidth() / 6;
                click2FocusY = Frogger.getMainHeight() / 2 - 50;

                fpsX = 5;
                fpsY = Frogger.getMainHeight() - 115;
                upsX = 5;
                upsY = Frogger.getMainHeight() - 95;
                
                break;       
        }
    }
    
}
