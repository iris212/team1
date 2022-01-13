import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class stage1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class stage1 extends World
{
    public int width = 25;
    public int height = 14;
    /**
     * Constructor for objects of class stage1.
     * 
     */
    public static int hearts;
    public stage1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1250, 700, 1);
        
        int map[][] = {
                {1,6,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,1},
                {1,5,1,1,0,1,1,1,1,0,1,1,0,1,1,0,1,0,1,1,1,1,1,0,1},
                {1,0,1,1,0,1,1,1,1,0,1,1,0,1,1,0,1,0,1,1,1,1,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1},
                {1,0,1,1,1,1,1,0,1,0,1,1,0,0,1,0,1,1,1,1,0,1,1,0,1},
                {1,0,1,1,1,0,0,0,1,0,1,1,0,0,1,0,0,0,0,1,0,0,0,0,1},
                {1,0,1,1,0,0,1,0,1,0,0,0,0,1,1,0,1,1,0,1,1,1,0,1,1},
                {1,0,1,0,0,1,1,0,1,0,1,0,0,0,1,0,1,1,0,1,1,0,0,1,1},
                {1,0,0,4,0,0,0,0,1,0,1,1,0,0,3,0,0,0,0,2,3,0,0,1,1},
                {1,0,0,1,1,1,1,0,1,0,1,1,1,0,0,1,1,0,1,0,0,0,0,0,1},
                {1,0,0,1,1,1,0,0,1,0,0,0,1,1,0,0,1,0,1,0,1,1,1,0,1},
                {1,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,8,8,0,0,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,7,7,7,7,7,1}
            };
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                //mapブロック置きます+(エッジ処理)
                if(map[y][x]==1 || map[y][x]==7){
                    addObject( new map_block1(), 25+(x*50), 25+(y*50));
                    if(y != 0){
                        if(map[y-1][x]!=1 && map[y-1][x]!=7){
                            addObject( new map_edge_up(),25+(x*50),(y*50));
                        }
                    }
                    if(y != height-1){
                        if(map[y+1][x]!=1 && map[y+1][x]!=7){
                            addObject( new map_edge_down(),25+(x*50),50+(y*50));
                        }
                    }
                    if(x != 0){
                        if(map[y][x-1]!=1 && map[y][x-1]!=7){
                            addObject( new map_edge_left(),(x*50),25+(y*50));
                        }
                    }
                    if(x != width-1){
                        if(map[y][x+1]!=1 && map[y][x+1]!=7){
                            addObject( new map_edge_right(),50+(x*50),25+(y*50));
                        }
                    }
                }
                //他諸々のアイテム
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
        //ウイルス置くよ
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                if(map[y][x]==7){
                    addObject( new virus_1(), 25+(x*50), 25+(y*50));
                }
                if(map[y][x]==8){
                    addObject( new virus_2(), 25+(x*50), 25+(y*50));
                }
            }
        }
        set_hearts();
    }

    public void set_hearts(){
        for(int x = 1; x <= MyWorld.hearts; x++){
            addObject( new heart(), 1225-(x*50), 25);
        }
    }
}