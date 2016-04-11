package Base.custom;

public class LinkList<T> {

	public Link startLink;;

	
	public void addLink(T t){		
			if(startLink == null){
				startLink= new Link(t);
			}else{
				startLink.addLink(t);
			}
	}
	
	
	
	public void runThrough(Trigger<T> trigger){
		
		startLink.trigger(trigger);
		
	}
	
	public class Link{
		
		public Link heldLink = null;
		
		public T heldObject = null;
		
		public Link(T t){
			this.heldObject = t;
		}
		
		public Link(){
			
		}
		
		public void trigger(Trigger<T> trigger){
			trigger.activate(this);
			
			if(this.getNext() != null){
				this.getNext().trigger(trigger);
			}
			
		}
		
		public void set(T t){
			this.heldObject = t;
		}
		
		public void addLink(T t){
			if(heldLink != null){
				this.heldLink.addLink(t);
			}else{
			this.heldLink = new Link(t);
			}
		}
		
		public Link getNext(){			
			return heldLink;
		}
		

		
		@Override 
		public String toString(){
			String hold = "";
			if(heldObject != null){
				hold += "["+heldObject+"]";
			}
			
				if(heldLink != null){
					hold += heldLink.toString();
				}
			
			return hold;
			
		}
		
	}
	
	@Override
	public String toString(){
		
		return startLink.toString();
		
	}
	
	
	
}
