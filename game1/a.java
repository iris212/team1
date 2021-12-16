import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class a here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class a extends MyWorld
{

    /**
     * Constructor for objects of class a.
     * 
     */
    public a()
    {
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
        for(int y = 0; y < 14; y++){
            for(int x = 0; x < 25; x++){
                //mapブロック置きます+(エッジ処理)
                if(map[y][x]==1 || map[y][x]==7){
                    addObject( new map_block1(), 25+(x*50), 25+(y*50));
                    if(y != 0){
                        if(map[y-1][x]!=1 && map[y-1][x]!=7){
                            addObject( new map_edge_up(),25+(x*50),(y*50));
                        }
                    }
                    if(y != 13){
                        if(map[y+1][x]!=1 && map[y+1][x]!=7){
                            addObject( new map_edge_down(),25+(x*50),50+(y*50));
                        }
                    }
                    if(x != 0){
                        if(map[y][x-1]!=1 && map[y][x-1]!=7){
                            addObject( new map_edge_left(),(x*50),25+(y*50));
                        }
                    }
                    if(x != 24){
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
        for(int y = 0; y < 14; y++){
            for(int x = 0; x < 25; x++){
                if(map[y][x]==7){
                    addObject( new virus_1(), 25+(x*50), 25+(y*50));
                }
                if(map[y][x]==8){
                    addObject( new virus_2(), 25+(x*50), 25+(y*50));
                }
            }
        } 
    }
}