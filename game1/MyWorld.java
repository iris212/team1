/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.core.TextLabel;
import greenfoot.WorldVisitor;
import greenfoot.util.GraphicsUtilities;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
public class MyWorld extends World
{   
    /**
     * 
     * Constructor for objects of class MyWorld.
     * 
     */
    // Reffered from core/TextLabel.java
    // Copyright (C) 2013,2014 Poul Henriksen and Michael Kolling 
    // Licence: GPL2
    class TextLabelEx extends TextLabel
    {
        boolean enable;
        int xpos;
        int ypos;
        int size;
        boolean bold;
        greenfoot.Color gfcolor;
        java.awt.Color color;
        String text;
        String[] lines;
        private GraphicsUtilities.MultiLineStringDimensions dimensions = null;
        
        @Override
        public int getX(){ return xpos;}
        
        @Override
        public int getY(){ return ypos;}
        
        @Override
        public String getText(){ return text;}     
        
        public TextLabelEx(String _text, int _xpos, int _ypos, int _size, boolean _bold, greenfoot.Color _gfcolor )
        {
            super("", 0, 0 );
            lines = new String[1];
            xpos = _xpos;
            ypos = _ypos;
            reset( _text, _size, _bold, _gfcolor );
        }
        
        public void reset( String _text, int _size, boolean _bold, greenfoot.Color _gfcolor )
        {
            if( text == _text && size == _size && bold == _bold && gfcolor == _gfcolor ) return;
            text = _text;
            size = _size;
            bold = _bold;
            gfcolor = _gfcolor;
            lines[0] = text;
            dimensions = null;
            
            if( text.length() == 0 ) enable = false;
            else enable = true;
        }

        @Override
        public void draw(Graphics2D g, int cellsize)
        {
            if( !enable ) return;
            if(dimensions == null) {
                dimensions = GraphicsUtilities.getMultiLineStringDimensions(lines, bold ? java.awt.Font.BOLD : java.awt.Font.PLAIN, size);
                color = new java.awt.Color( gfcolor.getRed(), gfcolor.getGreen(), gfcolor.getBlue(), gfcolor.getAlpha() );
            }
                
            int ydraw = ypos * cellsize - dimensions.getHeight() / 2 + cellsize / 2;
            int xdraw = xpos * cellsize - dimensions.getWidth() / 2 + cellsize / 2;
            g.translate(xdraw, ydraw);
            GraphicsUtilities.drawOutlinedText(g, dimensions, color, java.awt.Color.BLACK);
            g.translate(-xdraw, -ydraw);
        }
    }   
    
    public void showTextEx(String text, int x, int y, int size, boolean bold, greenfoot.Color color )
    {
        for( TextLabel label : WorldVisitor.getTextLabels(this) ){
            if( label.getX() == x && label.getY() == y ){
                if( label instanceof TextLabelEx ){
                    ((TextLabelEx)label).reset(text, size, bold, color);
                    return;                    
                }
            }
        }
        WorldVisitor.getTextLabels(this).add(new TextLabelEx( text, x, y, size, bold, color ) );
        
        //showText( "labels: "+WorldVisitor.getTextLabels(this).size(), 80, 20 );
    }
    
    
    
    private int timecount = 1500;
        public MyWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1250, 700, 1);
        //(850,550)
    
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
                {1,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,7,7,7,7,7,1}
            };
            
        for(int y = 0; y < 14; y++){
            for(int x = 0; x < 25; x++){
                if(map[y][x]==1){
                    addObject( new map_block1(), 25+(x*50), 25+(y*50));
                    if(y != 0){
                        if(map[y-1][x]!=1)addObject( new map_edge_up(),25+(x*50),(y*50));
                    }
                    if(y != 13){
                        if(map[y+1][x]!=1)addObject( new map_edge_down(),25+(x*50),50+(y*50));
                    }
                    if(x != 0){
                        if(map[y][x-1]!=1)addObject( new map_edge_left(),(x*50),25+(y*50));
                    }
                    if(x != 24){
                        if(map[y][x+1]!=1)addObject( new map_edge_right(),50+(x*50),25+(y*50));
                    }
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
                if(map[y][x]==7){
                    addObject( new map_block1(), 25+(x*50), 25+(y*50));
                }
            }
        }
        for(int y = 0; y < 14; y++){
            for(int x = 0; x < 25; x++){
                if(map[y][x]==7){
                    addObject( new virus_1(), 25+(x*50), 25+(y*50));
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
            addObject( new gameover(), 650 ,400 );
            showTextEx( "GAME OVER", 580, 250, 100, true, greenfoot.Color.RED );
            showText( "残り体力" , 400,300 );
            showText( "拾ったスコア加算アイテム数 " , 480,500 );
            showTextEx( "合計スコア " , 400,550, 50 , true , greenfoot.Color.BLACK );
            Greenfoot.stop();
        }
        
    }
    
}
