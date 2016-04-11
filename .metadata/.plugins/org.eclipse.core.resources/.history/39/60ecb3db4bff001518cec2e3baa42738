package com.mygdx.game.pFunctional;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class RenderManager {

	public Chain<DrawSpec> renderChain = new Chain<>();
	public int width = 0;
	public int height = 0;
	public void addDraw(DrawSpec drawSpec){
		renderChain.add(drawSpec);
	}
	
	
	public void render(SpriteBatch sb, BitmapFont bf){
		
		DrawSpec txy;
		while((txy = renderChain.take()) != null){
			txy.draw(sb,bf,0,0);
		}
	}
	
}
