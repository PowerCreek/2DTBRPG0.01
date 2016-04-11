package Base.custom;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SetPairMapB<K, V>{

	private HashMap<K,Set<V>> keyMap = new HashMap<K,Set<V>>();
	
	public void put(K key, V val){
		
		if(!keyMap.containsKey(key)){
			keyMap.put(key, new HashSet<V>());
		}
		keyMap.get(key).add(val);
		
	}
	
	public void removeKey(K key){
		keyMap.remove(key);
	}
	
	public void removeValue(K key, V val){
		if(!keyMap.containsKey(key)){
			return;
		}
		if(!keyMap.get(key).contains(val)){
			return;
		}
		Set<V> hold;
		(hold = keyMap.get(key)).remove(val);
		if(hold.isEmpty()){
			keyMap.remove(key);
		}
	}
	
	@Override
	public String toString(){
		return this.keyMap.toString()+"\n"+keyMap.values();
	}
	
}
