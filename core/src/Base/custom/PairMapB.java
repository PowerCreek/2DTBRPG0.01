package Base.custom;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PairMapB<K,V> {

	int size = 0;
	
	public PairMapB(int size){
		this.size = size;
	}
	
	private HashMap<Integer,HashMap<K,V>> KeyMap = new HashMap<Integer,HashMap<K,V>>();
	
	private HashMap<K,Integer> KeyIndexMap = new HashMap<K,Integer>();
	
	Indexer indX = new Indexer();
	
	int lastIndex = 0;
	
	public void put(K key,V val){
		
		if(!KeyIndexMap.containsKey(key)){
			
			if(KeyMap.isEmpty()){
				int index;
				KeyMap.put(index = indX.getNextTag(), new HashMap<K,V>());
				KeyIndexMap.put(key, index);				
				KeyMap.get(index).put(key, val);
			}else{
				int index = lastIndex;
				
				if(KeyMap.get(lastIndex).size() > size){
					lastIndex = indX.getNextTag();					
					KeyMap.put(lastIndex, new HashMap<K,V>());
				}
				KeyIndexMap.put(key, lastIndex);
				KeyMap.get(lastIndex).put(key, val);
				
			}
			
		}else{
			KeyMap.get(KeyIndexMap.get(key)).put(key, val);
		}
		
		
	}
	
	public void remove(K key){
		int size;
		int index;
		if(KeyIndexMap.containsKey(key)){
			KeyMap.get(index = KeyIndexMap.get(key)).remove(key);
			KeyIndexMap.remove(key);
			if(KeyMap.get(index).isEmpty()){
				KeyMap.remove(index);
				indX.removeTag(index);
			}
		}
	}
	
	public V get(K key){
		
		if(KeyIndexMap.containsKey(key)){
			return KeyMap.get(KeyIndexMap.get(key)).get(key);
		}
		
		return null;
		
	}
	
	@Override
	public String toString(){
		
		return "KeyMap: "+KeyMap+"\n"+"Indexes: "+KeyIndexMap;
		
	}

	public boolean containsKey(K key) {
		return KeyIndexMap.containsKey(key);
	}

	public Set<K> getKeys() {
		return KeyIndexMap.keySet();
	}
	
	
	
}
