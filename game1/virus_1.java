import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class virus_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class virus_1 extends Actor
{
    boolean flag_edge = false;
    int A = 0;
    int B = 359;
    int C = A + (int)(Math.random()*((B-A)+1));
    /**
     * Act - do whatever the virus_1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        setRotation(C); 
        move(4);
        int x = getX();
        int y = getY();
        
        if( x == 0 ){
            C = 300 + (int)(Math.random()*((120)+1));
            C = C % 360;
            setRotation(C);
        }
        if( x == 1249 ){
            C = 120 + (int)(Math.random()*((120)+1));
            setRotation(C);
        }
        if( y == 0 ){
            C = 30 + (int)(Math.random()*((120)+1));
            setRotation(C);
        }
        if( y == 699 ){
            C = 210 + (int)(Math.random()*((120)+1));
            setRotation(C);
        }
    }
}
