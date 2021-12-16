import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    static public int score = 0;
    public static int hearts;
    public MyWorld()
    {   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1250, 700, 1);
        //(850,550)
        //showText( "score = " + score, 100, 50 );
        hearts = 4;
    }
    public void act()
    {
       if( Greenfoot.isKeyDown( "enter" ) ){
        World game = new a();
        Greenfoot.setWorld( game );
    }

    }
}

