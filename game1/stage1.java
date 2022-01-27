import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.core.TextLabel;
import greenfoot.WorldVisitor;
import greenfoot.util.GraphicsUtilities;
import java.util.ArrayList;
import java.awt.Graphics2D;

/**
 * Write a description of class stage1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class stage1 extends World
{

    private int timecount = 3000;

    public int width = 25;
    public int height = 14;
    public static int map[][] = {
            {1,6,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,8,1},
            {1,5,1,1,0,1,1,1,1,0,1,1,0,1,1,0,1,0,1,1,1,1,1,0,1},
            {1,0,1,1,0,1,1,1,1,0,1,1,0,1,1,0,1,0,1,1,1,1,0,0,1},
            {1,0,0,0,0,0,0,8,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1},
            {1,0,1,1,1,1,1,0,1,0,1,1,0,0,1,0,1,1,1,1,0,1,1,0,1},
            {1,0,1,1,1,0,0,0,1,0,1,1,0,0,1,0,0,0,0,1,0,0,0,0,1},
            {1,0,1,1,0,0,1,0,1,0,0,0,0,1,1,0,1,1,0,1,1,1,0,1,1},
            {1,0,1,0,0,1,1,0,1,0,1,0,0,0,1,0,1,1,0,1,1,0,0,1,1},
            {1,0,0,4,0,0,0,8,1,0,1,1,0,0,3,0,0,0,0,2,3,0,0,1,1},
            {1,0,0,1,1,1,1,0,1,0,1,1,1,0,0,1,1,0,1,0,0,0,0,0,1},
            {1,0,0,1,1,1,0,0,1,0,0,0,1,1,0,0,1,0,1,0,1,1,1,0,1},
            {1,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,8,0,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,7,7,7,1}
        };
    /**
     * Constructor for objects of class stage1.
     * 
     */

    public stage1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1250, 700, 1);
        MyWorld.score=0;
        MyWorld.hearts = 3;

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

    public void act()
    {
        timecount--;
        if( timecount % 10 == 0)MyWorld.score+=1;
        showText( "残り時間:"+timecount, 100, 50 );
        showText( "score :"+MyWorld.score, 100, 80 );
        if( timecount == 0 || MyWorld.hearts == 0)
        {
            if(timecount != 0)addObject( new gameover(), 650 ,400 );
            else addObject( new clear(), 650 ,400 );
            MyWorld.score += MyWorld.hearts * 1000;
            //((MyWorld)getWorld()).showText( "GAME OVER", 580, 250, 100, true, greenfoot.Color.RED );
            showText( "残り体力  ："+MyWorld.hearts , 400,300 );
            showText( "合計スコア ："+MyWorld.score , 480,500 );
            //showText(getMyWorld)( "合計スコア " , 400,550, 50 , true , greenfoot.Color.BLACK );
            Greenfoot.stop();
        }

        int mx =0;
        int my =0;
        if( timecount % 200 == 0){
            mx =0;
            my =0;
            while(stage1.map[my][mx] == 1 ||stage1.map[my][mx] == 7){
                mx = (int)(Math.random()*(width));
                my = (int)(Math.random()*(height));
            }
            addObject( new mask(), 25+(mx*50), 25+(my*50));
            addObject( new virus_1(), 25+(width*50), 25+(height*50));
        }
        if( timecount % 300 == 0){
            mx =0;
            my =0;
            while(stage1.map[my][mx] == 1 ||stage1.map[my][mx] == 7){
                mx = (int)(Math.random()*(width));
                my = (int)(Math.random()*(height));
            }
            addObject( new alcohol(), 25+(mx*50), 25+(my*50));
        }
        if( timecount % 500 == 0){
            mx =0;
            my =0;
            while(stage1.map[my][mx] == 1 ||stage1.map[my][mx] == 7){
                mx = (int)(Math.random()*(width));
                my = (int)(Math.random()*(height));
            }
            addObject( new vaccine(), 25+(mx*50), 25+(my*50));
        }
    }

    public void set_hearts(){
        for(int x = 1; x <= MyWorld.hearts; x++){
            addObject( new heart(), 1225-(x*50), 25);
        }
    }   
}
