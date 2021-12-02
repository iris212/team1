import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap; 
/**
 * Write a description of class virus_2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class virus_2 extends Actor
{
    boolean flag_edge = false;
    int A = 0;
    int B = 359;
    int C = A + (int)(Math.random()*((B-A)+1));
    
    
    /**
     * Act - do whatever the virus_2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        setRotation(C); 
        move(4);

        Actor edge_up = getOneIntersectingObject( map_edge_up.class );
        Actor edge_down = getOneIntersectingObject( map_edge_down.class );
        Actor edge_left = getOneIntersectingObject( map_edge_left.class );
        Actor edge_right = getOneIntersectingObject( map_edge_right.class );
        if( edge_right != null ){
            C = 300 + (int)(Math.random()*((120)+1));
            C = C % 360;
            setRotation(C);
        }
        else if( edge_left != null ){
            C = 120 + (int)(Math.random()*((120)+1));
            setRotation(C);
        }
        else if( edge_down != null ){
            C = 30 + (int)(Math.random()*((120)+1));
            setRotation(C);
        }
        else if( edge_up != null ){
            C = 210 + (int)(Math.random()*((120)+1));
            setRotation(C);
        }
    }    
}
