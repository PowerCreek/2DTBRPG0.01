package Base.custom;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SetMap<K,V> {

	public HashMap<K,Set<V>> keyMap = new HashMap<K,Set<V>>();
	
	public void put(K key, V val){		
		if(!keyMap.containsKey(key)){
			keyMap.put(key, new HashSet<V>());
		}
		keyMap.get(key).add(val);		
	}
	
	public Set<V> get(K key){
		return keyMap.get(key);
	}
	
	public Set<V> remove(K key){
		return keyMap.remove(key);
	}
	
	public void remove(K key, V val){
		if(keyMap.containsKey(key)){
			keyMap.get(key).remove(val);
			if(keyMap.get(key).isEmpty()){
				keyMap.remove(key);
			}
		}
	}

	public void addToKey(K key, Set<V> values) {
		if(values != null && !values.isEmpty()){
			if(!keyMap.containsKey(key)){
				keyMap.put(key, new HashSet<V>());
			}		
			keyMap.get(key).addAll(values);
		}
	}
	
	/**Returns true if the set removed changed the set within the map.*/
	public boolean removeSetFromKey(K key, Set<V> values){
		if(keyMap.containsKey(key)){			
		return	keyMap.get(key).removeAll(values);
		}
		return false;
	}
	
}
