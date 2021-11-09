import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
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
    }
}
