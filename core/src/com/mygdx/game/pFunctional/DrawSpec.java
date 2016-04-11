package com.mygdx.game.pFunctional;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class DrawSpec {

		
	public int type;
	public TextureRegion t;
	public int x;
	public int y;
	public int w;
	public int h;
	public String text;
	
	public DrawSpec(TextureRegion t,int x,int y,int w,int h){
		this.t = t;
		
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.type = 0;
	}
	
	public DrawSpec(String s, int x, int y){
		this.text = s;
		this.x = x;
		this.y = y;
		this.type = 1;
	}
	
	public void draw(SpriteBatch sb, BitmapFont bf, int xOff, int yOff){
		switch(this.type){
		case 0:
			sb.draw(t,x+xOff,y+yOff,this.w,this.h);
			break;
		case 1:
			
			bf.draw(sb, text, x+xOff,y+yOff);
			break;
		}
	}
	
	
}
