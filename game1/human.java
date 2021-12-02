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
    int s = 4;
    /**
     * Act - do whatever the human wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int x = getX();
        int y = getY();
        Actor edge_up = getOneIntersectingObject( map_edge_up.class );
        Actor edge_down = getOneIntersectingObject( map_edge_down.class );
        Actor edge_left = getOneIntersectingObject( map_edge_left.class );
        Actor edge_right = getOneIntersectingObject( map_edge_right.class );

        if( Greenfoot.isKeyDown( "left" ) ){
            setLocation( x-s,y );
            if(edge_right != null)setLocation( x+1,y );
        }
        if( Greenfoot.isKeyDown( "right" ) ){
            setLocation( x+s,y );
            if(edge_left != null)setLocation( x-1,y );
        }
        if( Greenfoot.isKeyDown( "up" ) ){
            setLocation( x,y-s );
            if(edge_down != null)setLocation( x,y+1 );
        }
        if( Greenfoot.isKeyDown( "down" ) ){
            setLocation( x,y+s );
            if(edge_up != null)setLocation( x,y-1 );
        }

        
        //アイテム判定諸々
        Actor alcohol = getOneIntersectingObject( alcohol.class );
        if( alcohol != null ){
            score = 500;
            getWorld().removeObject( alcohol );
        }      
        Actor mask = getOneIntersectingObject( mask.class );
        if( mask != null ){
            score = 100;
            getWorld().removeObject( mask );
        }     
        Actor skate = getOneIntersectingObject( skate.class );
        if( skate != null ){
            s = 6;
            getWorld().removeObject( skate );
        }
        Actor vaccine = getOneIntersectingObject( vaccine.class );
        if( vaccine != null ){
            //体力を回復
            getWorld().removeObject( vaccine );
        }  
        Actor virus_1 = getOneIntersectingObject( virus_1.class );
        if( virus_1 != null ){
            //主人公は一時停止　ウイルスは動く
        } 
        Actor virus_2 = getOneIntersectingObject( virus_2.class );
        if( virus_2 != null ){
            //主人公は一時停止　ウイルスは動く
        }  

    }    
}
