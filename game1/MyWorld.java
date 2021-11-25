import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int timecount = 3000;
    /**
     * 
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
   {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1250, 700, 1);
        //(850,550)
        int map[][] = {
                {1,6,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,1,1},
                {1,5,1,1,0,1,1,1,1,0,1,1,0,1,1,0,1,0,1,1,1,1,0,1,1},
                {1,0,1,1,0,1,1,1,1,0,1,1,0,1,1,0,1,0,1,1,1,1,0,1,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,1},
                {1,0,1,1,1,1,1,0,1,0,1,1,0,0,1,0,1,1,1,1,0,1,0,1,1},
                {1,0,1,1,1,0,0,0,1,0,1,1,0,0,1,0,1,1,1,1,0,0,0,1,1},
                {1,0,1,1,0,0,1,0,1,0,0,0,0,1,1,0,1,1,1,1,1,1,0,1,1},
                {1,0,1,0,0,1,1,0,1,0,1,0,0,0,1,0,1,1,1,1,1,0,0,1,1},
                {1,0,0,4,0,0,0,0,1,0,1,1,0,0,3,0,0,0,0,2,3,0,1,1,1},
                {1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
            };
            
        for(int y = 0; y < 14; y++){
            for(int x = 0; x < 25; x++){
                if(map[y][x]==1){
                    addObject( new map_block1(), 25+(x*50), 25+(y*50));
                }
                if(map[y][x]==2){
                    addObject( new alcohol(), 25+(x*50), 25+(y*50));
                }
                if(map[y][x]==3){
                    addObject( new mask(), 25+(x*50), 25+(y*50));
                }
                if(map[y][x]==4){
                    addObject( new skate(), 25+(x*50), 25+(y*50));
                }
                if(map[y][x]==5){
                    addObject( new vaccine(), 25+(x*50), 25+(y*50));
                }
                if(map[y][x]==6){
                    addObject( new human(), 25+(x*50), 25+(y*50));
                }
            }
        }
        
        for(int i = 1;  i< 4; i++)
        {
            addObject( new heart(), 850 - 74*i ,25);
        }           
      
   } 
   
    public void act()
    {
        timecount--;
        showText( ""+timecount, 25, 25 );
        
        if( timecount == 0)
        {
            showText( "TIME OVER" , 400,250 );
            addObject( new gameover(), 650 ,400 );
          Greenfoot.stop();
        }
        
    }
}
