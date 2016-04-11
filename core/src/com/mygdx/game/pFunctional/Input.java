package com.mygdx.game.pFunctional;

import java.util.HashSet;
import java.util.Set;

import Base.custom.IntArr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class Input {

	public Set<Integer> buttons = new HashSet<Integer>();
	public Set<Integer> keys = new HashSet<Integer>();
	public IntArr pos = new IntArr(0,0);
	
	@Override
	public String toString(){
		return 	"Button States: "+buttons.toString() +"\n"+
				"Key States: "+keys.toString()+"\n"+
				"Mouse Pos: "+pos.toString();
	}
	
	public void apply(){
		
		Gdx.input.setInputProcessor(new InputProcessor(){
			

			@Override
			public boolean keyDown(int keycode) {
				keys.add(keycode);
				return false;
			}

			@Override
			public boolean keyUp(int keycode) {
				keys.remove(keycode);
				return false;
			}

			@Override
			public boolean keyTyped(char character) {
				
				return false;
			}

			@Override
			public boolean touchDown(int screenX, int screenY, int pointer,
					int button) {
				buttons.add(button);
				return false;
			}

			@Override
			public boolean touchUp(int screenX, int screenY, int pointer,
					int button) {
				buttons.remove(button);
				return false;
			}

			@Override
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				
				return false;
			}

			@Override
			public boolean mouseMoved(int screenX, int screenY) {
				pos.set(0, screenX);
				pos.set(1,screenY);
				return false;
			}

			@Override
			public boolean scrolled(int amount) {
				
				return false;
			}
			
		});
		
	}
	
}
