package com.mygdx.game.pFunctional;

import Base.custom.IntArr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.Viewport;

public class RunGame {
	
	TextureRegion[] t;
	public IntArr screen = new IntArr(0,0);
	public RenderManager RM = new RenderManager();
	public IntArr offsets = new IntArr(0,0);
	public Viewport v;
	public void init(){
		t = new TextureRegion[2];
		this.t[0] = new TextureRegion(new Texture("badlogic.jpg"));
		this.t[1] = new TextureRegion(new Texture("blue.bmp"));
		for(TextureRegion tr: t){
			tr.flip(false, true);
		}
	}
	
	public void update(Input input){
		RM.width = screen.get(0);
		RM.height = screen.get(1);
		int scale = 20;
		for(int i = 0; i < 4; i++){
			int h = 3;
			if(i == h && input.pos.get(0)/scale == 3 && input.pos.get(1)/scale == h*2){
				RM.addDraw(new DrawSpec(t[1],scale*3,i*scale*2+scale,scale,scale));
			}else{
			RM.addDraw(new DrawSpec(t[0],0,i*scale*2+scale,scale,scale));			
			}
		}
			
			RM.addDraw(new DrawSpec("test",0,0));
		
	}
	
	public void render(SpriteBatch sb,BitmapFont bf, Input input){
			offsets.set(0, v.getScreenX());
			offsets.set(1,v.getScreenY());
			this.update(input);
			RM.render(sb,bf);
			
			double holdX = (input.pos.get(0)-v.getScreenX())*((float)v.getWorldWidth()/v.getScreenWidth());
			double holdY = (input.pos.get(1)-v.getScreenY())*((float)v.getWorldHeight()/v.getScreenHeight());
			sb.draw(t[1],(float)(holdX), (float)(holdY),10,10);
	}
	
	public IntArr getRawMousePos(Input input){
		return new IntArr(input.pos.get(0)+offsets.get(0),input.pos.get(1)+offsets.get(1));
	}
	
	public float[] getWorldMousePos(Input input){
		IntArr ia = getRawMousePos(input);
		
		double holdX = ia.get(0)*((float)v.getWorldWidth()/v.getScreenWidth());
		double holdY = ia.get(1)*((float)v.getWorldHeight()/v.getScreenHeight());
		
		return new float[]{(float)holdX,(float)holdY};
	}
	
}
