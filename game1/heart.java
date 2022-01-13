import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class heart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class heart extends Actor
{
    /**
     * Act - do whatever the heart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int now_hearts = MyWorld.hearts;
    static int myhearts = 0;
    public void act() 
    {
        // Add your action code here.
        int x = getX();
        if(x < 1200-(MyWorld.hearts*50)){
            getWorld().removeObject( this );
        }
        
    }
}
