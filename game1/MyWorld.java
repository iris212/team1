/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{   
    /**
     * 
     * Constructor for objects of class MyWorld.
     * 
     */
    // Reffered from core/TextLabel.java
    // Copyright (C) 2013,2014 Poul Henriksen and Michael Kolling 
    // Licence: GPL2
    static public int counter = 0;  // カウンタ本体
    static public int skate_counter = 0;  // カウンタ本体
    static public int alcohol_counter = 0;  // カウンタ本体
    static public int vaccine_counter = 0;  // カウンタ本体
    static public int mask_counter = 0;  // カウンタ本体   


    static public int score = 0;

    public MyWorld()
    {   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1250, 700, 1);

        //(850,550)                  
    } 
   
   
    public void act()
    {
        
        ++counter;

        if( Greenfoot.isKeyDown( "space" ) ){ // スペースで MyWorld2 表示
            World world2 = new a();
            Greenfoot.setWorld( world2 );
        }
        
        if( Greenfoot.isKeyDown( "a" ) ){
        World game = new a();
        Greenfoot.setWorld( game );
    }

        //(850,550)
        //showText( "score = " + score, 100, 50 );

        
        
    }
    

    
    
          
}

