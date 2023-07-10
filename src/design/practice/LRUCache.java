package design.practice;

import java.util.HashMap;

public class LRUCache {
    private HashMap<Integer, Node> map;
    private DoubleLinkedList cache;
    private int capacity;
    public LRUCache(int capacity){
        this.capacity=capacity;
        map = new HashMap<>();
        cache = new DoubleLinkedList();
    }

    /**
     * Let a node be recently used
     * @param key
     */
    private void makeRecentlyUsed(int key){
        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }

    private void addRecentlyUsed(int key, int val){
        Node x = new Node(key,val);
        cache.addLast(x);
        map.put(key,x);
    }

    private void deleteKey(int key){
        Node x = map.get(key);
        cache.remove(x);
        map.remove(key);
    }

    private void deleteLeastRecentlyUsed(){
        Node deleteNode = cache.removeFirst();
        map.remove(deleteNode.key);
    }

    private int get(int key){
        if(!map.containsKey(key)) return -1;
        makeRecentlyUsed(key);
        return map.get(key).val;
    }

    private void put(int key, int value){
        if(map.containsKey(key)){
            deleteKey(key);
            addRecentlyUsed(key,value);
        }else{
            Node x = new Node(key,value);
            if(cache.size()==capacity)
                deleteLeastRecentlyUsed();
            cache.addLast(x);
            map.put(key,x);
        }
    }
}
