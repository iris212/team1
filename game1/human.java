import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class human here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class human extends Actor
{
    private int score = 0;
    /**
     * Act - do whatever the human wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int x = getX();
        int y = getY();
        int s = 4;

        if( Greenfoot.isKeyDown( "left" ) ){
            setLocation( x-s,y );
        }
        if( Greenfoot.isKeyDown( "right" ) ){
            setLocation( x+s,y );
        }
        if( Greenfoot.isKeyDown( "up" ) ){
            setLocation( x,y-s );
        }
        if( Greenfoot.isKeyDown( "down" ) ){
            setLocation( x,y+s );
        }

        Actor actor1 = getOneIntersectingObject( alcohol.class );
        if( actor1 != null ){
            score = 500;
            getWorld().removeObject( actor1 );
        }      

        Actor actor2 = getOneIntersectingObject( mask.class );
        if( actor2 != null ){
            score = 100;
            getWorld().removeObject( actor2 );
        }     

        Actor actor3 = getOneIntersectingObject( skate.class );
        if( actor3 != null ){
            s = 6;

            if( Greenfoot.isKeyDown( "left" ) ){
                setLocation( x+s,y );
            }
            if( Greenfoot.isKeyDown( "right" ) ){
                setLocation( x-s,y );
            }
            if( Greenfoot.isKeyDown( "up" ) ){
                setLocation( x,y+s );
            }
            if( Greenfoot.isKeyDown( "down" ) ){
                setLocation( x,y-s );
            }
            getWorld().removeObject( actor3 );
        }
        
           Actor actor4 = getOneIntersectingObject( vaccine.class );
        if( actor4 != null ){
            //体力を回復
            
        }  
        
         Actor actor5 = getOneIntersectingObject( virus_1.class );
        if( actor5 != null ){
            //主人公は一時停止　ウイルスは動く
        } 
         Actor actor6 = getOneIntersectingObject( virus_2.class );
        if( actor6 != null ){
            //主人公は一時停止　ウイルスは動く
        }  

        
    }    
}
