package Base.custom;

import java.util.ArrayList;
import java.util.HashSet;

public class Indexer{
	
	public HashSet<Integer> gTags = new HashSet<Integer>();//Global Tags
	
	public ArrayList<Integer> rTags = new ArrayList<Integer>();//Recycled Tags
	
	int tagCount = 0;
	
	public int getNextTag(){
		int tag = tagCount;
		if(rTags.size() == 0){
			tagCount++;
			gTags.add(tag);
			return tag;
		}else{
			tag = rTags.get(0);
			rTags.remove(0);
			gTags.add(tag);
			return tag;
		}
	}
	
	public void removeTag(int num){		
		gTags.remove(((Integer)num));
		rTags.add(num);		
	}
	
	public HashSet<Integer> activeSet(){
		return this.gTags;
	}
	
	public ArrayList<Integer> unusedSet(){
		return rTags;
	}
	
	public Integer[] getTags(){
		Integer[] fill = new Integer[gTags.size()];
		return gTags.toArray(fill);
	}
	
}

