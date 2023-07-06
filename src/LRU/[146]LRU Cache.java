package LRU;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    Map<Integer,Node> map;
    Node head, tail;
    int capacity;
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        this.capacity=capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }else{
            Node node = map.get(key);
            moveToHead(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            moveToHead(node);
        }else{
            if(map.size()==capacity){
                removeLast();
            }
            Node node = new Node(key,value);
            map.put(key,node);
            moveToHead(node);
        }
    }

    public void moveToHead(Node node){
        if(node.next!=null && node.prev!=null){
            node.next.prev = node.prev;
            node.prev.next=node.next;
        }
        node.prev = head;
        node.next = head.next;
        head.next.prev=node;
        head.next = node;
    }
    public void removeLast(){
        if(map.size()==0) return;
        Node cur = tail.prev;
        cur.prev.next=tail;
        tail.prev = cur.prev;
        map.remove(cur.key);
    }


}

/**
 * Your LRUCacheBackup object will be instantiated and called as such:
 * LRUCacheBackup obj = new LRUCacheBackup(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

//leetcode submit region end(Prohibit modification and deletion)
