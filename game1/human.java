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
    int dir = 0;
    int damage = 0;
    /**
     * Act - do whatever the human wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
   
        int x = getX();
        int y = getY();
        
        dir = 0;
        //right=1,up=2,left=3,down=4
        if( Greenfoot.isKeyDown( "right") ) dir = 1;
        else if( Greenfoot.isKeyDown( "up"   ) ) dir = 2;
        else if( Greenfoot.isKeyDown( "left" ) ) dir = 3;
        else if( Greenfoot.isKeyDown( "down" ) ) dir = 4;
        
        if(dir == 1)setLocation( x+s,y );
        else if(dir == 2)setLocation( x,y-s );
        else if(dir == 3)setLocation( x-s,y );
        else if(dir == 4)setLocation( x,y+s );
        Actor edge_up = getOneIntersectingObject( map_edge_up.class );
        Actor edge_down = getOneIntersectingObject( map_edge_down.class );
        Actor edge_left = getOneIntersectingObject( map_edge_left.class );
        Actor edge_right = getOneIntersectingObject( map_edge_right.class );
        setLocation( x,y );
        
        if(dir==1){
            if(edge_left != null)dir = 0;
            if(edge_up != null)dir = 2;
            if(edge_down != null)dir = 4;
        }
        else if(dir==2){
            if(edge_down != null)dir = 0;
            if(edge_right != null)dir = 1;
            if(edge_left != null)dir = 3;
        }
        else if(dir==3){
            if(edge_right != null)dir = 0;
            if(edge_up != null)dir = 2;
            if(edge_down != null)dir = 4;
        }
        else if(dir==4){
            if(edge_up != null)dir = 0;
            if(edge_right != null)dir = 1;
            if(edge_left != null)dir = 3;
        }
 
        if(dir == 1)setLocation( x+s,y );
        else if(dir == 2)setLocation( x,y-s );
        else if(dir == 3)setLocation( x-s,y );
        else if(dir == 4)setLocation( x,y+s );


        Actor actor1 = getOneIntersectingObject( alcohol.class );
        if( actor1 != null ){
            MyWorld.score += 500;
            
            getWorld().removeObject( actor1 );
        }      

        Actor actor2 = getOneIntersectingObject( mask.class );
        if( actor2 != null ){
            MyWorld.score += 100;
            getWorld().removeObject( actor2 );
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
        if( (virus_1 != null || virus_2 != null) && damage == 0 ){
            //主人公は一時停止　ウイルスは動く

        }  


            MyWorld.hearts -= 1;
            getImage().setTransparency(128);
            damage = 100;

        if(damage > 0){
            damage-=1;
            if(damage ==0)getImage().setTransparency(255);
        }

    }    
}
