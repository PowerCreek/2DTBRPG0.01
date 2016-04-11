package com.mygdx.game.pFunctional;

public class Link<T>{

	public T held = null;
	public Link<T> next = null;
	
	@Override
	public String toString(){
		if(held == null){
			return "no held object";
		}
		return held.toString();
	}
	
}
