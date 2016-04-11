package com.mygdx.game.pFunctional;

public class Chain<T> {

	public Link<T> start = new Link<T>();
	public Link<T> last = start;
	
	public void add(T t){
		if(start == null){
			start = new Link<T>();
			last = start;
		}
		last.held = t;
		last = last.next = new Link<T>();
	}
	
	public T take(){
		if(start == null){
			return null;
		}
		T hold = start.held;
		start = start.next;
		return hold;
	}
	
	
}
