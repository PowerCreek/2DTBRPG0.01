package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.pFunctional.Input;
import com.mygdx.game.pFunctional.RunGame;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	BitmapFont bf;
	RunGame RG = new RunGame();
	Input input = new Input();
	
	OrthographicCamera cam;
	Viewport viewport;
	@Override
	public void create () {
		cam = new OrthographicCamera(1280,720);
		cam.setToOrtho(true, 1280,720);
		cam.update();
		RG.init();
		batch = new SpriteBatch();
		this.bf = new BitmapFont(true);
		input.apply();
		this.RG.v = viewport = new FitViewport(1280,720,cam);
	}

	public void update(){
		RG.screen.set(0,0);
		RG.screen.set(1,0);
		viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	
	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(cam.combined);			
		batch.begin();
		RG.render(batch,bf,input);
		batch.end();
	}
}
