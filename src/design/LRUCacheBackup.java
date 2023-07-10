package design;

import java.util.LinkedHashMap;

/**
 * Leetcode 146
 */
public class LRUCacheBackup {
    private int capacity;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    public LRUCacheBackup(int capacity) {
        this.capacity=capacity;
    }

    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        makeRecently(key);
        return cache.get(key);

    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.put(key,value);
            makeRecently(key);
            return;
        }
        if(cache.size()==this.capacity){
            //get the first key
            int leastUsedKey = cache.keySet().iterator().next();
            cache.remove(leastUsedKey);
        }
        cache.put(key,value);
    }

    public void makeRecently(int key){
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key,val);
    }
}
