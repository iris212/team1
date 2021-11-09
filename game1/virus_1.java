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

        if( isAtEdge() ){
            if( flag_edge == false ){
                C = A + (int)(Math.random()*((B-A)+1));
                setRotation(C);
                flag_edge=true;
            }
        }
        else{flag_edge = false;}
    }
}
