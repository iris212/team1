import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int timecount = 500;
    /**
     * 
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
   {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(850, 550, 1);
        int map[][] = {
                {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,0,1,1,1,1,1,1,1,0,1,1,0,1,1,0,1},
                {1,0,1,1,1,1,1,1,1,0,1,1,0,1,1,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,0,1,1,1,1,1,0,1,0,1,1,0,0,1,0,1},
                {1,0,1,1,1,1,1,0,1,0,1,1,0,0,1,0,1},
                {1,0,1,1,1,1,1,0,1,0,0,0,1,1,1,0,1},
                {1,0,1,1,1,1,1,0,1,0,1,0,0,0,1,0,1},
                {1,0,1,1,1,1,1,0,1,0,1,1,0,0,0,0,1},
                {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
            };
        for(int y = 0; y < 11; y++){
            for(int x = 0; x < 17; x++){
                if(map[y][x]==1){
                    addObject( new map_block1(), 25+(x*50), 25+(y*50));
                }
            }
        }
        
        
       /*
        * 
        if(map[y][x] != 0)
    {
          for(int i = 0; i< 2; i++)
        {
        int A = 0;
        int B = 850;
        int x = A + (int)(Math.random() * ( (B-A) +1) );
        
        
        B = 550;
        int y = A + (int)(Math.random() * ( (B-A) +1) );
        addObject( new mask(), x, y );
        }
      
        for(int i = 0; i< 5; i++)
        {
        int A = 0;
        int B = 850;
        int x = A + (int)(Math.random() * ( (B-A) +1) );
        
        
        B = 550;
        int y = A + (int)(Math.random() * ( (B-A) +1) );
        //addObject( new ORANGE(), x, y );
        }
        
    }
    */
   } 
   
    public void act()
    {
        timecount--;
        showText( ""+timecount, 25, 25 );
        
        if( timecount == 0)
        {
            showText( "TIME OVER" , 400,250 );
          Greenfoot.stop();
        }
        
        
    }
}
