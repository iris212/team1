import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class rem extends Actor
{
    /**
     * Act - do whatever the rem wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
        if( Greenfoot.isKeyDown( "up" ) ){
        setRotation(270);
        move(1);
    }
        
    }    
}