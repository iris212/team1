import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class alcohol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class alcohol extends Actor
{
    /**
     * Act - do whatever the alcohol wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
        int A = 0;
        int B = 360;
        int C = A + (int)(Math.random()*((B-A)+1));
        setRotation(C);
        
    }    
}
